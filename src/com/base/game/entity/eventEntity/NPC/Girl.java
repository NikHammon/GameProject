package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Girl extends NPC
{
	public Girl(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 60, 60);
		setBounds(new Rectangle(15, 30, 30, 25));
		
		scriptNum = 3;
		
		stationary = Assets.NPC10Stationary;
		
		lft = new Animation(150, Assets.NPC10Lft, 0);
		rgt = new Animation(150, Assets.NPC10Rgt, 0);
		up = new Animation(150, Assets.NPC10Up, 0);
		dwn = new Animation(150, Assets.NPC10Dwn, 0);
		
		currentAnimation = dwn;
	}
}
