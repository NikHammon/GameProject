package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class NPC17 extends NPC
{
	public NPC17(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(20, 40, 35, 30));
		
		scriptNum = 1;
		
		stationary = Assets.NPC18Stationary;
		
		lft = new Animation(150, Assets.NPC18Lft, 0);
		rgt = new Animation(150, Assets.NPC18Rgt, 0);
		up = new Animation(150, Assets.NPC18Up, 0);
		dwn = new Animation(150, Assets.NPC18Dwn, 0);
		
		currentAnimation = dwn;
	}
}
