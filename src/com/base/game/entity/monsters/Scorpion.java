package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.staticEntity.Pitfall;
import com.base.game.entity.staticEntity.StaticEntity;
import com.base.game.tiles.Tile;

public class Scorpion extends Monster
{
	private Animation left, atkLeft, atkRgt, skyAtkLeft, inHoleLeft, inHoleRight, up;
	
	private Rectangle reachRect;
	
	public Scorpion(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 560, 560, level);
		
		bounds.y = 460;
		bounds.height = 80;
		bounds.x = 240;
		bounds.width = 60;
		
		reachRect = new Rectangle(0,0,0,0);
		reach = 2;
		baseSpeed = 2.5f;
		currSpeed = baseSpeed;
		health = 50;
		damage = 2;
		knockBack = 100;
		setCanBeKnkBack(false);
		
		left = new Animation(150, Assets.scorpionLeft, 0);
		
		skyAtkLeft = new Animation(150, Assets.scorpionLeftFall, 1);
		atkLeft = new Animation(250, Assets.scorpionLftAtk, 1);
		atkRgt = new Animation(250, Assets.scorpionRgtAtk, 1);
		inHoleLeft = new Animation(250, Assets.scorpionLeftInHole, 0);
		inHoleRight = new Animation(250, Assets.scorpionRightInHole, 0);
		
		up = new Animation(150, Assets.scorpionUp, 1);
		
		currentAnimation = inHoleLeft;
		state = "FLYING";

	}

	@Override
	public void update()
	{	
		setCurrentAnimation();
		if(currentAnimation != null)
			currentAnimation.update();

		if(health <= 0)
			state = "DEAD";
		else
			checkStatus();

		switch(state)
		{
		case "FLYING":
			fly();
			break;
		case "SKYATTACK":
			skyAtk();
			break;
		case "RECOIL":
			recoil();
			break;
		case "STUCK":
			stuck();
			break;
		case "ATTACK":
			attack();
			break;
		case "DEAD":
			dead();
			break;	
		}
	
	}
	
	public void dead()
	{
		attackBounds = new Rectangle(0,0,0,0);

		dropItem();

		currentAnimation = death;
		renderOrder = 1;
		state = "";
	}
	
	float sSpeed = 5;
	float sX, sY; 
	int sWidth, sHeight;
	Rectangle target;
	private void fly()
	{
		if(sX + sWidth/2 + sSpeed <= handler.getLevel().geteManager().getPlayer().getCenterPosX())
			sX += sSpeed;
		else
			sX -= sSpeed;
		
		if(sY + sHeight/2 + sSpeed <= handler.getLevel().geteManager().getPlayer().getCenterPosY())
			sY += sSpeed;
		else
			sY -= sSpeed;
		
		sWidth += 4;
		sHeight += 2;
		
		if(sWidth >= 700)
			sSpeed = 2;
		else
			sSpeed = 5;
		
		if(sWidth >= 800)
		{
			x = (sX + sWidth/2 - bounds.x - bounds.width) + 35;
			y = (sY + sHeight/2 - bounds.y - bounds.height) - handler.getGame().getHeight()/2 + 25;
			state = "SKYATTACK";
			skyAtkLeft.reset();
			counter = 0;
		}
		
	}
	
	int counter = 0;
	private void skyAtk()
	{	
		if(counter >= handler.getGame().getHeight()/2)
		{
			attackBounds = new Rectangle((int)((sX + sWidth/2) - (sX + sWidth/2)%64), (int)((sY + sHeight/2) - (sY + sHeight/2)%64), 64, 64);
			sWidth = 0;
			sHeight = 0;
			knkBackX = 0;
			damageEntity();
			for(Entity e : handler.getLevel().geteManager().entities)
				if(e instanceof Pitfall && attackBounds.intersects(e.getCollisionBounds(0, 0)))
					currentAnimation = skyAtkLeft;
			
			if(currentAnimation.isComplete())
			{
				lastTime = System.currentTimeMillis();
				timer = 0;
				state = "STUCK";	
			}
			if(currentAnimation != skyAtkLeft)
				state = "RECOIL";
		}
		else
		{
			currentAnimation = left;
			y += 8;
			counter += 8;
		}
	}
	
	private void recoil()
	{
		if(currentAnimation != left)
		{
			currentAnimation = up;
		}
		if(up.isComplete())
		{
			currentAnimation = left;
		}
		if(currentAnimation == left)
		{
			y -= 4;
			counter -= 4;
			
			if(counter < 0)
			{
				state = "FLYING";
				
			}
		}
	}
	
	private void stuck()
	{
		timer += System.currentTimeMillis() - lastTime;
		
		if(handler.getLevel().geteManager().getPlayer().getCenterPosX() < x + width/2)
			currentAnimation = inHoleLeft;
		else
			currentAnimation = inHoleRight;
		
		atkLeft.reset();
		atkRgt.reset();
		
		Rectangle playerBounds = handler.getLevel().geteManager().getPlayer().getCollisionBounds(0, 0);
		Random rand = new Random();
		int tryAttack = rand.nextInt(40);
		
		reachRect = new Rectangle((int)(getCollisionBounds(0,0).x - 150), (int)(getCollisionBounds(0,0).y + bounds.height - reach * Tile.TILE_HEIGHT/2), 3 * reach * Tile.TILE_WIDTH, reach * Tile.TILE_HEIGHT);
		if(tryAttack == 1 && reachRect.intersects(playerBounds) && handler.getLevel().geteManager().getPlayer().getHealth() >= 0)
		{
			state = "ATTACK";
			if(handler.getLevel().geteManager().getPlayer().getCenterPosX() < x + width/2)
				currentAnimation = atkLeft;
			else
				currentAnimation = atkRgt;
		}
		
		if(timer > 1000000)
		{
			up.reset();
			state = "RECOIL";
		}
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.shadow,(int)(sX - handler.getCamera().getxOffset()), (int)(sY- handler.getCamera().getyOffset()), sWidth, sHeight, null);
		if(state != "FLYING")
		{		
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
		g.setColor(Color.blue);
		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
//		g.setColor(Color.cyan);
//		g.fillRect((int)(attackBounds.x - handler.getCamera().getxOffset()), (int)(attackBounds.y - handler.getCamera().getyOffset()), attackBounds.width, attackBounds.height);

	}

	@Override
	public void attack() 
	{	
		
		if(currentAnimation.isComplete())
			state = "STUCK";
		
		if(currentAnimation.getCurrentIndex() > 2 && currentAnimation.getCurrentIndex() < 5)
			updateAttackBounds();
		else
			attackBounds = new Rectangle(0,0,0,0);
		
		damageEntity();
		
	}
	
	public void updateAttackBounds()
	{
		attackBounds = getCollisionBounds(0,0);

		if(currentAnimation == atkLeft)
		{
			attackBounds.x -= 50;
			attackBounds.y -= 50;
			attackBounds.width += 250;
			attackBounds.height += 100;
			knkBackX = 20;
		}
		else if(currentAnimation == atkRgt)
		{
			attackBounds.x -= 175;
			attackBounds.y -= 50;
			attackBounds.width += 250;
			attackBounds.height += 100;
			knkBackX = -20;
		}
	}
	
	int knkBackX;
	public void damageEntity()
	{
		for(Entity e : handler.getLevel().geteManager().getEntities())
		{
			if(attackBounds.intersects(e.getCollisionBounds(0,0)))
			{
				if(e.equals(this))
					continue;
				else if(e instanceof StaticEntity)
					stopped = true;
				else if(e instanceof Monster && !harmsOtherMonsters)
					continue;
				else if(e instanceof Creature)
				{
					Creature c = ((Creature)e);
					c.setrVal(200);
					c.takeDamage(damage);
					attackBounds = new Rectangle(0,0,0,0);
					if(c.getHealth() > 0)
						c.setKnockBack(knkBackX, 60, knockBack);
					
				}
			}
		}
	}
	
}
