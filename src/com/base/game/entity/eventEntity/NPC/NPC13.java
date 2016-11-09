package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class NPC13 extends NPC
{
	public NPC13(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(15, 30, 30, 25));
		
		scriptNum = 1;
		
		stationary = Assets.NPC13Stationary;
		
		lft = new Animation(150, Assets.NPC13Lft, 0);
		rgt = new Animation(150, Assets.NPC13Rgt, 0);
		up = new Animation(150, Assets.NPC13Up, 0);
		dwn = new Animation(150, Assets.NPC13Dwn, 0);
		
		currentAnimation = dwn;
	}
}
