package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Boy extends NPC
{
	public Boy(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 60, 60);
		setBounds(new Rectangle(15, 30, 30, 25));
		
		scriptNum = 1;
		
		stationary = Assets.NPC12Stationary;
		
		lft = new Animation(150, Assets.NPC12Lft, 0);
		rgt = new Animation(150, Assets.NPC12Rgt, 0);
		up = new Animation(150, Assets.NPC12Up, 0);
		dwn = new Animation(150, Assets.NPC12Dwn, 0);
		
		currentAnimation = dwn;
	}
}
