package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Ken extends NPC
{
	public Ken(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(15, 30, 30, 25));
		
		scriptNum = 1;
		
		currSpeed = 3;
		
		stationary = Assets.NPC5Stationary;
		
		lft = new Animation(150, Assets.NPC5Lft, 0);
		rgt = new Animation(150, Assets.NPC5Rgt, 0);
		up = new Animation(150, Assets.NPC5Up, 0);
		dwn = new Animation(150, Assets.NPC5Dwn, 0);
		
		currentAnimation = dwn;
	}
}
