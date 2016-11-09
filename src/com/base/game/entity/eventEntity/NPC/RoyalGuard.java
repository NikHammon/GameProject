package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class RoyalGuard extends NPC
{
	public RoyalGuard(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(20, 40, 35, 30));
		
		scriptNum = 1;
		
		stationary = Assets.NPC8Stationary;
		
		lft = new Animation(150, Assets.NPC8Lft, 0);
		rgt = new Animation(150, Assets.NPC8Rgt, 0);
		up = new Animation(150, Assets.NPC8Up, 0);
		dwn = new Animation(150, Assets.NPC8Dwn, 0);
		
		currentAnimation = dwn;
	}
}
