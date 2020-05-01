package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.attacks.Ink;
import com.base.game.entity.attacks.LightSlash;
import com.base.game.entity.attacks.LightningSplash;
import com.base.game.entity.attacks.LightningStrike;
import com.base.game.entity.attacks.Quake;
import com.base.game.entity.staticEntity.StaticEntity;
import com.base.game.tiles.Tile;

public class D5Boss extends BossMonster
{
	public BufferedImage[] stationary, eleStationary;
	public Animation lft, rgt, up, dwn;
	public Animation lftEle, rgtEle, upEle, dwnEle;
	public Animation chargeLft, chargeRgt, chargeDwn, chargeUp;
	public D5Boss(Handler handler, float x, float y, int layer)
	{
		super(handler, x, y, layer, 72, 72);
		
		setBounds(new Rectangle(36, 30, 54, 46));
		currSpeed = baseSpeed = 4f;
		health = myHealth = 20;
		damage = 0;
		attackProb = 200;
		reach = 10;
			
		stationary = Assets.NPC11Stationary;
		eleStationary = Assets.b5EleStationary;
		
		lft = new Animation(150, Assets.NPC11Lft, 0);
		rgt = new Animation(150, Assets.NPC11Rgt, 0);
		up = new Animation(150, Assets.NPC11Up, 0);
		dwn = new Animation(150, Assets.NPC11Dwn, 0);
		
		lftEle = new Animation(150, Assets.b5EleLft, 0);
		rgtEle = new Animation(150, Assets.b5EleRgt, 0);
		upEle = new Animation(150, Assets.b5EleUp, 0);
		dwnEle = new Animation(150, Assets.b5EleDwn, 0);
		
		chargeLft = new Animation(100, Assets.b5ChargeLft, 3);
		chargeRgt = new Animation(100, Assets.b5ChargeRgt, 3);
		chargeUp = new Animation(100, Assets.b5ChargeUp, 3);
		chargeDwn = new Animation(100, Assets.b5ChargeDwn, 3);
		
		currentAnimation = dwn;
	}
	
	public void stateUpdate()
	{
		switch(state)
		{
		case "KNOCKBACK":
			knockBack();
			lightning();
			break;
		case "FORCEMOVE":
			forceMove();
			break;
		case "IDLE":
			idle();
			break;
		case "CHASE":
			chase();
			lightning();
			break;
		case "RETREAT":
			retreat();
			lightning();
			break;
		case "ATTACK":
			attack();
			lightning();
			break;
		case "RECOVERING":
			recover();
			break;
		case "DYING":
			dying();
			break;	
		}
	}
	
	public void lightning()
	{
		if(ThreadLocalRandom.current().nextInt(100) == 0)
		{
			handler.getGame().geteManager().addEntity(new LightningStrike(handler, this, ThreadLocalRandom.current().nextInt(handler.getWidth()), ThreadLocalRandom.current().nextInt(handler.getHeight()) - 244, layer));
		}
	}
	
	public void retreat()
	{
		xMove = 0; yMove = 0;
		if(Math.abs(Math.abs(target.getX()) - Math.abs(x)) < Math.abs(Math.abs(target.getY()) - Math.abs(y)) + (direction == UP || (direction == DOWN) ? -32 : 32))
		{
			if(target.getX() + currSpeed < x)
				xMove += currSpeed;
			else if(target.getX() - currSpeed > x)
				xMove -= currSpeed;
		}
		else
		{
			if(target.getY() + currSpeed < y)
				yMove += currSpeed;
			else if(target.getY() - currSpeed > y)
				yMove -= currSpeed;
		}
		
		move();
		
		if(ThreadLocalRandom.current().nextInt(100) == 1)
			state = "CHASE";
	}
	
	public void chase()
	{		
		xMove = 0; yMove = 0;
		
		if(Math.abs(Math.abs(target.getX()) - Math.abs(x)) > Math.abs(Math.abs(target.getY()) - Math.abs(y)) + (direction == UP || (direction == DOWN) ? 32 : -32))
		{
			if(target.getX() > x + currSpeed)
				xMove += currSpeed;
			else if(target.getX() < x - currSpeed)
				xMove -= currSpeed;
		}
		else
		{
			if(target.getY() > y + currSpeed)
				yMove += currSpeed;
			else if(target.getY() < y - currSpeed)
				yMove -= currSpeed;
		}
		
		move();
		
		if(target.getState() == "DEAD")		
			state = "IDLE";
		
		if(ThreadLocalRandom.current().nextInt(attackProb) == 1 && reachRect.intersects(targetBounds))
		{		
			setAttack();
		}
	}
	
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
	
	int attackNum;
	public void setAttack()
	{
		state = "ATTACK";
		
		if(ThreadLocalRandom.current().nextInt(1) == 0)
		{
			attackNum = 0;
			if(Math.abs(target.getY() - y) > Math.abs(target.getX() - x))
			{
				if(target.getY() < y)
					currentAnimation = chargeUp;	
				else
					currentAnimation = chargeDwn;
			}
			else
			{
				if(target.getX() > x)
					currentAnimation = chargeRgt;
				else
					currentAnimation = chargeLft;	
			}
		}
	}
	
	@Override
	public void attack() 
	{
		switch(attackNum)
		{
		case 0:
			if(currentAnimation.isComplete())
			{
				handler.getGame().geteManager().getEntities().add(new LightningSplash(handler, this, centerPosX - 46, centerPosY - 40, layer));
				currentAnimation.reset();
				state = "RETREAT";
			}
			
		damageEntity();		
		break;
		}
	
	}
	
	@Override
	public void render(Graphics g) 
	{
		super.render(g);
		if(rVal == 0 && gVal == 0 && bVal == 0)
		{	
			if(getCurrentAnimation() != null)		
				g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			else 
				g.drawImage((state != "CHASE") ? stationary[direction/2] : eleStationary[direction/2],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			
		}
		else 
		{
			if(getCurrentAnimation() != null)		
				g.drawImage(Utils.tintImage(currentAnimation.getCurrentFrame(), rVal, gVal, bVal), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			else 
				g.drawImage(Utils.tintImage((state != "CHASE") ? stationary[direction/2] : eleStationary[direction/2], rVal, gVal, bVal) ,(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		}
		
	}
	
	public void setCurrentAnimation()
	{	
		if(state == "CHASE")
		{
			if(yMove > 0)
			{
				currentAnimation = dwnEle;
				direction = DOWN;
			}
			else if(yMove < 0)
			{
				currentAnimation =  upEle;
				direction = UP;
			}
			else if(xMove < 0)
			{
				currentAnimation = lftEle;
				direction = LEFT;
			}
			else if(xMove > 0)
			{
				currentAnimation = rgtEle;
				direction = RIGHT;
			}
			else if(stationary != null)
				currentAnimation = null;
		}
		else if(state != "ATTACK")
		{
			if(yMove > 0)
			{
				currentAnimation = dwn;
				direction = DOWN;
			}
			else if(yMove < 0)
			{
				currentAnimation =  up;
				direction = UP;
			}
			else if(xMove < 0)
			{
				currentAnimation = lft;
				direction = LEFT;
			}
			else if(xMove > 0)
			{
				currentAnimation = rgt;
				direction = RIGHT;
			}
			else if(stationary != null)
				currentAnimation = null;
		}

	}
}
