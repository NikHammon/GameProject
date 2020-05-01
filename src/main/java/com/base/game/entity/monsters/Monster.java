package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.item.ShadowPuppet;
import com.base.game.entity.staticEntity.StaticEntity;
import com.base.game.tiles.Tile;

public abstract class Monster extends Creature
{
	protected final int DEFAULT_SIGHT = 12;
	protected final int DEFAULT_REACH = 1;
	
	protected Animation dwnLft;
	protected Animation dwnRgt;	
	protected Animation upLft;
	protected Animation upRgt;
	
	protected Animation idleDwnLft;
	protected Animation atkDwnLft;
	protected Animation idleUpLft;
	protected Animation atkUpLft;
	protected Animation idleDwnRgt;
	protected Animation atkDwnRgt;
	protected Animation idleUpRgt;
	protected Animation atkUpRgt;
	
	protected Animation death;
	
	protected int type;
	protected int randDirection;
	protected int oldDirection;
	protected int atkDirection;
	protected int sight;
	protected int reach;
	protected int damage;
	protected int attackProb;
	protected boolean stopped;
	protected boolean harmsOtherMonsters;
	protected String element;
	
	protected Entity target;

	public Monster(Handler handler, float x, float y, int layer, int width, int height, int level)
	{
		super(handler, x, y, layer, width, height);
		state = "IDLE";	
		element = "";
		this.level = level;
		attackProb = 50;
		knockBack = 60;
		
		sight = DEFAULT_SIGHT;
		reach = DEFAULT_REACH;
		harmsOtherMonsters = false;
		damagesPlayerOnImpact = true;
		
		death = new Animation(100, Assets.enemyDeath, 1);
	}
	
	public void update()
	{
		super.update();
		
		if(state == "DEAD")
		{
			dead();
		}
		else
		{
			setCurrentAnimation();
			
			if(health <= 0)
				state = "DYING";

			if(target == null)
			{
				target = handler.getGame().geteManager().getPlayer();
			}
			
			targetBounds = target.getCollisionBounds(-handler.getCamera().getxOffset(), -handler.getCamera().getyOffset());
			sightRect = new Rectangle((int)(x + width/2 - DEFAULT_SIGHT * Tile.TILE_WIDTH/2 - handler.getCamera().getxOffset()), (int)(y + height/2 - DEFAULT_SIGHT * Tile.TILE_HEIGHT/2 - handler.getCamera().getyOffset()), DEFAULT_SIGHT * Tile.TILE_WIDTH, DEFAULT_SIGHT * Tile.TILE_HEIGHT);
			if(reach == 1)
				reachRect = attackBounds;
			else
				reachRect = new Rectangle((int)(x + width/2 - reach * Tile.TILE_WIDTH/2 - handler.getCamera().getxOffset()), (int)(y + height/2 - reach * Tile.TILE_HEIGHT/2 - handler.getCamera().getyOffset()), reach * Tile.TILE_WIDTH, reach * Tile.TILE_HEIGHT);
			
		}
		
		checkStatus();
	}
	
	public void render(Graphics g)
	{
		super.render(g);
		if(rVal == 0 && gVal == 0 && bVal == 0)
		{
			if(getCurrentAnimation() != null)		
				g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		}
		else 
		{
			if(getCurrentAnimation() != null)		
				g.drawImage(Utils.tintImage(currentAnimation.getCurrentFrame(), rVal, bVal, gVal), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		}
	}
	
	public void stateUpdate()
	{
		switch(state)
		{
		case "KNOCKBACK":
			knockBack();
			break;
		case "FORCEMOVE":
			forceMove();
			break;
		case "IDLE":
			idle();
			break;
		case "CHASE":
			chase();
			break;
		case "ATTACK":
			attack();
			break;
		case "RECOVERING":
			recover();
			break;
		case "DYING":
			dying();
			break;	
		}
	}
	
	public void dead()
	{
		if(death.isComplete())
		{
			handler.getGame().geteManager().removeEntity(this);
		}
	}
	
	protected Rectangle sightRect;
	public void idle()
	{
		if(randDirection != oldDirection)
			randomMove();
		
		if(ThreadLocalRandom.current().nextInt(20) == 1)
		{
			oldDirection = randDirection;
			randDirection = ThreadLocalRandom.current().nextInt(25);
		}
			
		if(sightRect.intersects(targetBounds) && target.getState() != "DEAD")
		{
			state = "CHASE";			
		}
	}
	
	private void randomMove()
	{		
		xMove = 0;
		yMove = 0;
		
		if(randDirection == UP)
		{
			yMove -= currSpeed;
			xMove += currSpeed;
			direction = UP;
		}
		if(randDirection == DOWN)
		{
			yMove += currSpeed;
			xMove += currSpeed;
			direction = DOWN;
		}
		if(randDirection == LEFT)
		{
			yMove -= currSpeed;
			xMove -= currSpeed;
			direction = LEFT;
		}
		if(randDirection == RIGHT)
		{
			yMove -= currSpeed;
			xMove += currSpeed;
			direction = RIGHT;
		}
	
		move();
	
	}
	
	protected String[] shortestPath;
	protected Rectangle reachRect;
	protected Rectangle targetBounds;
	public void chase()
	{		
		xMove = (target.getCenterPosX()-centerPosX)/(Math.abs((target.getCenterPosX()-centerPosX)) + Math.abs((target.getCenterPosY()-centerPosY))) * currSpeed * 1.5f;
		yMove = (target.getCenterPosY()-centerPosY)/(Math.abs((target.getCenterPosX()-centerPosX)) + Math.abs((target.getCenterPosY()-centerPosY))) * currSpeed * 1.5f;
		
		move();
		
		if(!sightRect.intersects(targetBounds) || layer != target.getLayer() || target.getState() == "DEAD")		
			state = "IDLE";
		
		if(collided)
		{
			//shortestPath = Pathfinder.findPath(handler, this, target);
			if(shortestPath == null)
				state = "IDLE";
			else
			{
				hasPath = true;
			}
		}

		if(hasPath)
		{
			xMove = 0;
			yMove = 0;
	
			setForceMove(shortestPath);
			
		}		
		if(ThreadLocalRandom.current().nextInt(attackProb) == 1 && reachRect.intersects(targetBounds))
		{
			
			setAttack();
		}
	}
	
	public void setAttack()
	{
		state = "ATTACK";
	}
	public abstract void attack();
	
	public void damageEntity()
	{
		for(Entity e : handler.getGame().geteManager().getEntities())
		{
			if(getAttackBounds(0,0).intersects(e.getCollisionBounds(0,0)))
			{
				if(e.equals(this) || e.isRecovering())
					continue;
				else if(e instanceof StaticEntity)
					stopped = true;
				else if(e instanceof Monster && !harmsOtherMonsters)
					continue;
				else if(e instanceof Creature)
				{
					damageEntity(e);
				}
			}
		}
	}
	
	public void damageEntity(Entity e)
	{		
		Creature c = ((Creature)e);
		c.takeDamage(damage);
		
		switch(element)
		{
		case "FIRE":
			c.setStatusCondition("BURNED");
			break;
		case "ICE":
			c.setStatusCondition("FROZEN");
			break;
		}
		
		if(c.getHealth() > 0)
			c.setKnockBack(x, y, knockBack);
			
	}

	Rectangle tempBounds;
	public void dying()
	{
		tempBounds = bounds;
		bounds = new Rectangle(0,0,0,0);
		attackBounds = new Rectangle(0,0,0,0);
		Utils.playSound("squish");
		dropItem();
		currentAnimation = death;
		renderOrder = 1;
		state = "DEAD";
	}
	
	public void setCurrentAnimation()
	{
		if(state == "IDLE" && idleDwnLft != null)
		{
			if(xMove < 0 && yMove > 0)
				currentAnimation = idleDwnLft;
			else if(xMove > 0 && yMove > 0)
				currentAnimation =  idleDwnRgt;
			else if(xMove < 0 && yMove < 0)
				currentAnimation = idleUpLft;
			else if(xMove > 0 && yMove < 0)
				currentAnimation = idleUpRgt;
		}
		
		if(state == "CHASE")
		{
			if(xMove < 0 && yMove > 0)
				currentAnimation = dwnLft;
			else if(xMove > 0 && yMove > 0)
				currentAnimation =  dwnRgt;
			else if(xMove < 0 && yMove < 0)
				currentAnimation = upLft;
			else if(xMove > 0 && yMove < 0)
				currentAnimation = upRgt;
		}
	}
	
	public void reset(float x, float y, int layer)
	{
		this.x = x;
		this.y = y;
		this.layer = layer;
		state = "IDLE";
		health = myHealth;
		bounds = tempBounds;
		renderOrder = 3;
		death.reset();
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public Entity getTarget() {
		return target;
	}

	public void setTarget(Entity target) {
		this.target = target;
	}	

	
}
