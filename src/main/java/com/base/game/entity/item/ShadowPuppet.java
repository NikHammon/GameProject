package com.base.game.entity.item;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.staticEntity.StaticEntity;
import com.base.game.tiles.Tile;

public class ShadowPuppet extends Monster
{
	private Player player;
	private Animation shadowDown, shadowLeft, shadowUp, shadowRight, shadowDownLeft, shadowDownRight, shadowUpLeft, shadowUpRight;
	
	private BufferedImage[] shadowStationary;
	
	private Animation shadowIn, shadowOut;
	
	private float desLocX, desLocY;
	private float speed;
	private int pos;
	public ShadowPuppet(Handler handler, float x, float y, int layer, int pos) 
	{
		super(handler, x, y, layer, 64, 64, 0);
		setBounds(new Rectangle(0, 0, 0, 0));
		setAttackBounds(new Rectangle(23, 46, 18, 18));
		this.pos = pos;
		desLocX = x;
		desLocY = y;
		health = 1;
		damage = 3;
		speed = 6;
		reach = 10;
		shadowStationary = Assets.playerStationaryShadow;
		
		shadowDown = new Animation(125, Assets.playerDownShadow, 0);
		shadowUp = new Animation(125, Assets.playerUpShadow, 0);
		shadowLeft = new Animation(125, Assets.playerLeftShadow, 0);
		shadowRight = new Animation(125, Assets.playerRightShadow, 0);
		shadowDownLeft = new Animation(125, Assets.playerDownLeftShadow, 0);
		shadowDownRight = new Animation(125, Assets.playerDownRightShadow, 0);
		shadowUpLeft = new Animation(125, Assets.playerUpLeftShadow, 0);
		shadowUpRight = new Animation(125, Assets.playerUpRightShadow, 0);
		
		direction = handler.getGame().geteManager().getPlayer().getDirection();
		
		shadowIn = new Animation(100, Assets.shadowIn, 1);
		shadowOut = new Animation(100, Assets.shadowOut, 1);
		
		currentAnimation = shadowIn;
		
		taggedEntities = new ArrayList<Entity>();
	}

	Entity lastTarget;
	List<Entity> taggedEntities;
	@Override
	public void update() 
	{
		if(state == "DESTROY")
			destroy();
		else if(shadowIn.isComplete())
		{
			if(health <= 0)
				destroy();
			
			xMove = 0;
			yMove = 0;
			
			player = handler.getGame().geteManager().getPlayer();

			if(target == null)
			{
				findDesiredLocs();
				moveTo(desLocX, desLocY);
			}
			else
			{
				moveTo(target.getCenterPosX(), target.getCenterPosY());
			}
			reachRect = new Rectangle((int)(x + width/2 - reach * Tile.TILE_WIDTH/2 - handler.getCamera().getxOffset()), (int)(y + height/2 - reach * Tile.TILE_HEIGHT/2 - handler.getCamera().getyOffset()), reach * Tile.TILE_WIDTH, reach * Tile.TILE_HEIGHT);
			
			taggedEntities.removeAll(taggedEntities);
			for(Entity e : handler.getGame().geteManager().getEntities())
			{
				if(e instanceof ShadowPuppet)
				{
					if(((ShadowPuppet) e).getTarget() != null)
					{
						taggedEntities.add(e);
					}
				}
			}
			for(Entity e : handler.getGame().geteManager().getEntities())
			{
				if(!(e instanceof Monster))
					continue;
				if(e instanceof ShadowPuppet || taggedEntities.contains(e))
					continue;
				if(e == lastTarget)
					continue;
				if(e.getCollisionBounds(-handler.getCamera().getxOffset(), -handler.getCamera().getyOffset()).intersects(reachRect))
				{
					target = e;
				}
			}
			
			if(target != null && !(reachRect.intersects(target.getCollisionBounds(-handler.getCamera().getxOffset(), -handler.getCamera().getyOffset()))))
			{
				target = null;
				lastTarget = null;
			}
			
			setCurrentAnimation();
			damageEntity();
			move();
			
		}
		
		if(currentAnimation != null)
			currentAnimation.update();
	}

	public void findDesiredLocs()
	{
		switch(pos)
		{
		case 0:
			desLocX = player.getX();
			desLocY = player.getCenterPosY() - 96;
			break;
		case 2:
			desLocX = player.getX() + 96;
			desLocY = player.getCenterPosY();
			break;
		case 4:
			desLocX = player.getX();
			desLocY = player.getCenterPosY() + 96;
			break;
		case 6:
			desLocX = player.getX() - 96;
			desLocY = player.getCenterPosY();
			break;
		}
	}
	
	public void destroy()
	{
		state = "DESTROY";
		currentAnimation = shadowOut;
		bounds = new Rectangle(0,0,0,0);
		if(currentAnimation.isComplete())
			handler.getGame().geteManager().getEntities().remove(this);
	}
	
	public void damageEntity()
	{
		for(Entity e : handler.getGame().geteManager().getEntities())
		{
			if(getAttackBounds(0,0).intersects(e.getCollisionBounds(0,0)))
			{
				if(e.equals(this))
					continue;
				else if(e instanceof Monster)
				{
					Creature c = ((Creature)e);
					c.takeDamage(damage);
					
					if(c.getHealth() > 0)
						c.setKnockBack(x, y, knockBack);
					
					lastTarget = target;
					target = null;
					
				}
			}
		}
	}
	
	@Override
	public void render(Graphics g)
	{

		if(getCurrentAnimation() != null)		
			g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		else
			g.drawImage(shadowStationary[direction],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
	
	}
	
	public void setCurrentAnimation()
	{
		if(yMove > 0 && xMove == 0)
		{
			currentAnimation = shadowDown;
			direction = DOWN;
		}
		else if(yMove < 0 && xMove == 0)
		{
			currentAnimation =  shadowUp;
			direction = UP;
		}
		else if(xMove < 0 && yMove == 0)
		{
			currentAnimation = shadowLeft;
			direction = LEFT;
		}
		else if(xMove > 0 && yMove == 0)
		{
			currentAnimation = shadowRight;
			direction = RIGHT;
		}
		else if(xMove < 0 && yMove > 0)
		{
			currentAnimation = shadowDownLeft;
			direction = DOWNLEFT;
		}
		else if(xMove > 0 && yMove > 0)
		{
			currentAnimation = shadowDownRight;
			direction = DOWNRIGHT;
		}
		else if(xMove < 0 && yMove < 0)
		{
			currentAnimation = shadowUpLeft;
			direction = UPLEFT;
		}
		else if(xMove > 0 && yMove < 0)
		{
			currentAnimation = shadowUpRight;
			direction = UPRIGHT;
		}
		else
			currentAnimation = null;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

}
