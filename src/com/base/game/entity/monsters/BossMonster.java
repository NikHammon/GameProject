package com.base.game.entity.monsters;

import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.eventEntity.HeartCrystal;

public abstract class BossMonster extends Monster
{
	public BossMonster(Handler handler, float x, float y, int layer, int width, int height) 
	{
		super(handler, x, y, layer, width, height, 1);
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
	
	public void update()
	{
		if(state != "DEFEATED")
			super.update();
		
		stateUpdate();
	}
	
	public void idle()
	{
		
	}
	
	public void chase()
	{		
		xMove = (target.getCenterPosX()-centerPosX)/(Math.abs((target.getCenterPosX()-centerPosX)) + Math.abs((target.getCenterPosY()-centerPosY))) * currSpeed * 1.5f;
		yMove = (target.getCenterPosY()-centerPosY)/(Math.abs((target.getCenterPosX()-centerPosX)) + Math.abs((target.getCenterPosY()-centerPosY))) * currSpeed * 1.5f;
		
		move();
		
		if(target.getState() == "DEAD")		
			state = "IDLE";
		
		if(rand.nextInt(attackProb) == 1 && reachRect.intersects(targetBounds))
		{		
			setAttack();
		}
	}
	
	public void dead()
	{
		if(death.isComplete())
		{
			state = "DEFEATED";
		}
	}
	
	public void dying()
	{
		tempBounds = bounds;
		bounds = new Rectangle(0,0,0,0);
		attackBounds = new Rectangle(0,0,0,0);
		Utils.playSound("squish");
		currentAnimation = death;
		renderOrder = 1;
		state = "DEAD";
	}

}
