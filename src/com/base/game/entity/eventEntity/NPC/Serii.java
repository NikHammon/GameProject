package com.base.game.entity.eventEntity.NPC;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Serii extends NPC
{
	private Animation upLft, upRgt, dwnLft, dwnRgt;
	public Animation rise;
	public Serii(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 64, 64);
		setBounds(new Rectangle(23, 46, 18, 18));
		
		scriptNum = 194;
		currSpeed = 5;
		stationary = Assets.player3Stationary;
		
		lft = new Animation(150, Assets.player3Left, 0);
		rgt = new Animation(150, Assets.player3Right, 0);
		up = new Animation(150, Assets.player3Up, 0);
		dwn = new Animation(150, Assets.player3Down, 0);
		
		upLft = new Animation(150, Assets.player3UpLeft, 0);
		upRgt = new Animation(150, Assets.player3UpRight, 0);
		dwnLft = new Animation(150, Assets.player3DownLeft, 0);
		dwnRgt = new Animation(150, Assets.player3DownRight, 0);
		
		rise = new Animation(150, Assets.player3Rise, 1);
		
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
			g.drawImage(Assets.player3Stationary[direction], (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		
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
