package com.base.game.entity.eventEntity.NPC;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Shadow extends NPC
{
	public Animation shadowIn, shadowOut;
	private Animation upLft, upRgt, dwnLft, dwnRgt;
	
	public Shadow(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 64, 64);
		setBounds(new Rectangle(20, 40, 25, 30));
		
		scriptNum = 2;
		stationary = Assets.playerStationaryShadow;
		
		lft = new Animation(150, Assets.playerLeftShadow, 0);
		rgt = new Animation(150, Assets.playerRightShadow, 0);
		up = new Animation(150, Assets.playerUpShadow, 0);
		dwn = new Animation(150, Assets.playerDownShadow, 0);
		
		upLft = new Animation(150, Assets.playerUpLeftShadow, 0);
		upRgt = new Animation(150, Assets.playerUpRightShadow, 0);
		dwnLft = new Animation(150, Assets.playerDownLeftShadow, 0);
		dwnRgt = new Animation(150, Assets.playerDownRightShadow, 0);
		
		shadowIn = new Animation(100, Assets.shadowIn, 1);
		shadowOut = new Animation(100, Assets.shadowOut, 1);
		
		currentAnimation = dwn;
	}
	
	@Override
	public void render(Graphics g) 
	{	
		if(!doNotRenderShadow)
			g.drawImage(Assets.shadow, (int) (x - shadowOffsetX - handler.getCamera().getxOffset()), (int) (y + height - 12 - shadowOffsetY - handler.getCamera().getyOffset()), 64, 24, null);
	
		if(getCurrentAnimation() != null)		
			g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		else
			g.drawImage(Assets.playerStationaryShadow[direction], (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		
		if(expressionAnimation != null)			
			renderExpression(g);
	
	}	
	
	public void setCurrentAnimation()
	{	
		if(yMove > 0 && xMove == 0)
		{
			currentAnimation = dwn;
			direction = DOWN;
		}
		else if(yMove < 0 && xMove == 0)
		{
			currentAnimation =  up;
			direction = UP;
		}
		else if(xMove < 0 && yMove == 0)
		{
			currentAnimation = lft;
			direction = LEFT;
		}
		else if(xMove > 0 && yMove == 0)
		{
			currentAnimation = rgt;
			direction = RIGHT;
		}
		else if(xMove < 0 && yMove > 0)
		{
			currentAnimation = dwnLft;
			direction = DOWNLEFT;
		}
		else if(xMove > 0 && yMove > 0)
		{
			currentAnimation = dwnRgt;
			direction = DOWNRIGHT;
		}
		else if(xMove < 0 && yMove < 0)
		{
			currentAnimation = upLft;
			direction = UPLEFT;
		}
		else if(xMove > 0 && yMove < 0)
		{
			currentAnimation = upRgt;
			direction = UPRIGHT;
		}
		else
			currentAnimation = null;
	}

	public void setCurrentAnimation(Animation currentAnimation) {
		this.currentAnimation = currentAnimation;
		
	}
}
