package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Fineas extends NPC
{
	public Fineas(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(20, 40, 25, 30));
		
		scriptNum = 2;
		
		stationary = Assets.fineasStationary;
		
		lft = new Animation(150, Assets.fineasLft, 0);
		rgt = new Animation(150, Assets.fineasRgt, 0);
		up = new Animation(150, Assets.fineasUp, 0);
		dwn = new Animation(150, Assets.fineasDwn, 0);
		
		currentAnimation = dwn;
	}
}
