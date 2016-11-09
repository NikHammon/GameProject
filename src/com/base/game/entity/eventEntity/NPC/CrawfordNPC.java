package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class CrawfordNPC extends NPC
{
	public Animation upLft, upRgt, dwnLft, dwnRgt;
	public CrawfordNPC(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 60, 60);
		setBounds(new Rectangle(20, 40, 25, 30));
		
		scriptNum = 206;
		
		upLft = new Animation(150, Assets.crawUpLft, 0);
		dwnRgt = new Animation(150, Assets.crawDwnRgt, 0);
		upRgt = new Animation(150, Assets.crawUpRgt, 0);
		dwnLft = new Animation(150, Assets.crawDwnLft, 0);
		
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
