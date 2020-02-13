package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Obin extends NPC
{
	public Obin(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 108, 64);
		setBounds(new Rectangle(20, 40, 25, 30));
		
		scriptNum = 2;
		currSpeed = 10;
		shadowOffsetX = -20;
		canFly = true;
		
		stationary = Assets.obinStationary;
		
		lft = new Animation(50, Assets.obinLft, 0);
		rgt = new Animation(50, Assets.obinRgt, 0);
		up = new Animation(50, Assets.obinUp, 0);
		dwn = new Animation(50, Assets.obinDwn, 0);
		
		currentAnimation = dwn;
	}
}
