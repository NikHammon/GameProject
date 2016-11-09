package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Rubel extends NPC
{
	public Rubel(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(20, 40, 25, 30));
		
		currSpeed = 5;
		scriptNum = 284;
		
		stationary = Assets.NPC4Stationary;
		
		lft = new Animation(150, Assets.NPC4Lft, 0);
		rgt = new Animation(150, Assets.NPC4Rgt, 0);
		up = new Animation(150, Assets.NPC4Up, 0);
		dwn = new Animation(150, Assets.NPC4Dwn, 0);
		
		currentAnimation = dwn;
	}
}
