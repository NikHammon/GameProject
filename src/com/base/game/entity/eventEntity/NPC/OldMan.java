package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class OldMan extends NPC
{
	public OldMan(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(15, 30, 30, 25));
		
		scriptNum = 1;
		
		currSpeed = 2;
		
		stationary = Assets.NPC2Stationary;
		
		lft = new Animation(150, Assets.NPC2Lft, 0);
		rgt = new Animation(150, Assets.NPC2Rgt, 0);
		up = new Animation(150, Assets.NPC2Up, 0);
		dwn = new Animation(150, Assets.NPC2Dwn, 0);
		
		currentAnimation = dwn;
	}
}
