package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.concurrent.ThreadLocalRandom;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.ElectroBall;
import com.base.game.entity.attacks.LightSlash;

public class LightKnight extends Monster
{
	private Animation dwnSlash, upSlash, lftSlash, rgtSlash, dashLft, dashRgt, shieldLft, shieldRgt, shieldUp, shieldDwn;
	
	public LightKnight(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 130, 130, level);
		
		setBounds(new Rectangle(30, 30, 66, 66));
		baseSpeed = 3.5f;
		currSpeed = baseSpeed;
		
		myHealth = 50;
		health = myHealth;
		reach = 10;
		
		damage = 1;
		
		attackProb = 50;
		
		dwnLft = new Animation(125, Assets.lightKnightDwnLft, 0);
		dwnRgt = new Animation(125, Assets.lightKnightDwnRgt, 0);
		upLft = new Animation(125, Assets.lightKnightUpLft, 0);
		upRgt = new Animation(125, Assets.lightKnightUpRgt, 0);
		
		dwnSlash = new Animation(50, Assets.lightKnightAtkDwn, 1);
		upSlash = new Animation(50, Assets.lightKnightAtkUp, 1);
		lftSlash = new Animation(50, Assets.lightKnightAtkLft, 1);
		rgtSlash = new Animation(50, Assets.lightKnightAtkRgt, 1);
		
		dashLft = new Animation(75, Assets.lightKnightLft, 0);
		dashRgt = new Animation(75, Assets.lightKnightRgt, 0);
		
		shieldLft = new Animation(275, Assets.lightKnightShieldLft, 1);
		shieldRgt = new Animation(275, Assets.lightKnightShieldRgt, 1);
		shieldUp = new Animation(275, Assets.lightKnightShieldUp, 1);
		shieldDwn = new Animation(275, Assets.lightKnightShieldDwn, 1);
		
		currentAnimation = dwnRgt;
	}

	@Override
	public void update()
	{		
		super.update();

		if(state == "BLOCKING")
		{
			if(currentAnimation.isComplete())
			{
				currentAnimation.reset();
				state = "CHASE";
			}
		}
		else
		{
			stateUpdate();
		}
		
	}
	
	public void setBlocking()
	{
		state = "BLOCKING";
		
		if(Math.abs(target.getY() - y) > Math.abs(target.getX() - x))
		{
			if(target.getY() < y)
			{
				currentAnimation = shieldUp;	
				//setBounds(new Rectangle(30, 76, 44, 42));
			}
			else
			{
				currentAnimation = shieldDwn;
				//setBounds(new Rectangle(50, 66, 44, 42));
			}
		}
		else
		{
			if(target.getX() > x)
			{
				currentAnimation = shieldRgt;
				//setBounds(new Rectangle(34, 62, 44, 42));
			}
			else
			{
				currentAnimation = shieldLft;
				//setBounds(new Rectangle(60, 64, 44, 42));
			}	
		}
	}
	
	
	@Override
	public void render(Graphics g) 
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
		
//		g.setColor(Color.MAGENTA);
//		g.fillRect(getAttackBounds(-handler.getCamera().getxOffset(), -handler.getCamera().getyOffset()).x, getAttackBounds(-handler.getCamera().getxOffset(), -handler.getCamera().getyOffset()).y, attackBounds.width, attackBounds.height);
//		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
//	
		
	}
	int attackNum;
	float atkSpeedX, atkSpeedY, atkSpeed = 8;
	public void setAttack()
	{
		state = "ATTACK";
		
		if(ThreadLocalRandom.current().nextInt(3) == 0)
		{
			attackNum = 0;
			if(target.getX() > x)
			{
				currentAnimation = dashRgt;	
				setAttackBounds(new Rectangle(34, 50, 62, 68));
			}
			else
			{
				currentAnimation = dashLft;	
				setAttackBounds(new Rectangle(0, 50, 62, 68));
			}
			
			atkSpeedX = (target.getX() - x)/(Math.abs(target.getX() - x) + Math.abs(target.getY() - y)) * atkSpeed;
			atkSpeedY = (target.getY() - y)/(Math.abs(target.getY() - y) + Math.abs(target.getX() - x)) * atkSpeed;
			
		}
		else
		{
			attackNum = 1;
			if(Math.abs(target.getY() - y) > Math.abs(target.getX() - x))
			{
				if(target.getY() < y)
				{
					currentAnimation = upSlash;	
					//setBounds(new Rectangle(30, 76, 44, 42));
				}
				else
				{
					currentAnimation = dwnSlash;
					//setBounds(new Rectangle(50, 66, 44, 42));
				}
			}
			else
			{
				if(target.getX() > x)
				{
					currentAnimation = rgtSlash;
					//setBounds(new Rectangle(34, 62, 44, 42));
				}
				else
				{
					currentAnimation = lftSlash;
					//setBounds(new Rectangle(60, 64, 44, 42));
				}	
			}
		}
	}
	
	public void takeDamage(int damage)
	{	
		if(state != "KNOCKBACK" && state != "RECOVERING" && state != "BLOCKING")
		{		
			if(ThreadLocalRandom.current().nextInt(5) == 0)
			{
				health-=damage;
				rVal = 200;	
			}
			else
			{
				setBlocking();
			}
		}
	}
	
	boolean attacked = false;
	int atkDist;
	@Override
	public void attack() 
	{
		switch(attackNum)
		{
		case 0:
			xMove = atkSpeedX;
			yMove = atkSpeedY;
			atkDist += Math.abs(atkSpeedX) + Math.abs(atkSpeedY);
			
			if(atkDist > 500)
			{
				state = "CHASE";
				atkDist = 0;	
			}
			else
			{
				move();
			}		
		break;
		default:
			if(!attacked && currentAnimation.getCurrentIndex() == 5)
			{
				if(currentAnimation == upSlash)
				{
					setAttackBounds(new Rectangle(24, 18, 92, 72));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x, y, layer, target.getX()-x, target.getY()-y));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x + 10, y, layer, target.getX()-x + 30, target.getY()-y));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x - 10, y, layer, target.getX()-x - 30, target.getY()-y));
				}
				else if(currentAnimation == dwnSlash)
				{
					setAttackBounds(new Rectangle(46, 56, 92, 72));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x, y, layer, target.getX()-x, target.getY()-y));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x + 10, y, layer, target.getX()-x + 30, target.getY()-y));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x - 10, y, layer, target.getX()-x - 30, target.getY()-y));
				}
				else if(currentAnimation == rgtSlash)
				{
					setAttackBounds(new Rectangle(30, 50, 92, 72));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x, y, layer, target.getX()-x, target.getY()-y));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x, y + 10, layer, target.getX()-x, target.getY()-y + 30));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x, y - 10, layer, target.getX()-x, target.getY()-y - 30));
				}
				else
				{
					setAttackBounds(new Rectangle(8, 50, 92, 72));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x, y, layer, target.getX()-x, target.getY()-y));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x, y + 10, layer, target.getX()-x + 30, target.getY()-y + 30));
					handler.getGame().geteManager().addEntity(new LightSlash(handler, this, x, y - 10, layer, target.getX()-x - 30, target.getY()-y - 30));
				}
				attacked = true;
			}
			else if(currentAnimation.isComplete())
			{
				currentAnimation.reset();
				attacked = false;
				state = "CHASE";
			}
		}
			
		damageEntity();	
	}
	
	public void setCurrentAnimation()
	{
		if(state == "IDLE" && idleDwnLft != null)
		{
			if(xMove < 0 && yMove > 0)
			{
				currentAnimation = idleDwnLft;
			}
			else if(xMove > 0 && yMove > 0)
			{
				currentAnimation =  idleDwnRgt;
			}
			else if(xMove < 0 && yMove < 0)
			{
				currentAnimation = idleUpLft;
			}
			else if(xMove > 0 && yMove < 0)
			{
				currentAnimation = idleUpRgt;
			}
		}
		
		if(state == "CHASE")
		{
			if(xMove < 0 && yMove > 0)
			{
				currentAnimation = dwnLft;
				//setBounds(new Rectangle(40, 40, 42, 44));
				setAttackBounds(new Rectangle(44, 80, 30, 44));
			}
			else if(xMove > 0 && yMove > 0)
			{
				currentAnimation =  dwnRgt;
				//setBounds(new Rectangle(40, 40, 42, 44));
				setAttackBounds(new Rectangle(44, 80, 30, 44));
			}
			else if(xMove < 0 && yMove < 0)
			{
				currentAnimation = upLft;
				//setBounds(new Rectangle(48, 72, 42, 44));
				setAttackBounds(new Rectangle(52, 26, 34, 50));
			}
			else if(xMove > 0 && yMove < 0)
			{
				currentAnimation = upRgt;
				//setBounds(new Rectangle(48, 72, 42, 44));
				setAttackBounds(new Rectangle(52, 26, 34, 50));
			}
		}
	}
}
