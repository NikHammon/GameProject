package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class NPC12 extends NPC
{
	public NPC12(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(15, 30, 30, 25));
		
		scriptNum = 1;
		
		stationary = Assets.NPC17Stationary;
		
		lft = new Animation(150, Assets.NPC17Lft, 0);
		rgt = new Animation(150, Assets.NPC17Rgt, 0);
		up = new Animation(150, Assets.NPC17Up, 0);
		dwn = new Animation(150, Assets.NPC17Dwn, 0);
		
		currentAnimation = dwn;
	}
}
