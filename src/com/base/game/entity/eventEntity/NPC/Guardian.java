package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Guardian extends NPC
{
	public Animation upLft, upRgt, dwnLft, dwnRgt;
	public Guardian(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 200, 200);
		setBounds(new Rectangle(20, 40, 25, 30));
		
		scriptNum = 2;
		
		upLft = new Animation(150, Assets.b8UpLft, 0);
		dwnRgt = new Animation(150, Assets.b8DwnRgt, 0);
		upRgt = new Animation(150, Assets.b8UpRgt, 0);
		dwnLft = new Animation(150, Assets.b8DwnLft, 0);
		
		currentAnimation = dwnRgt;
	}
	
	public void setCurrentAnimation(Animation currentAnimation)
	{
		this.currentAnimation = currentAnimation;
		
	}
	
	public void setCurrentAnimation()
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
