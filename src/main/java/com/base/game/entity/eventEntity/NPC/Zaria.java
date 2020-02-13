package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Zaria extends NPC
{
	public Zaria(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(20, 40, 25, 30));
		
		currSpeed = 5;
		scriptNum = 2;
		
		stationary = Assets.NPC3Stationary;
		
		lft = new Animation(150, Assets.NPC3Lft, 0);
		rgt = new Animation(150, Assets.NPC3Rgt, 0);
		up = new Animation(150, Assets.NPC3Up, 0);
		dwn = new Animation(150, Assets.NPC3Dwn, 0);
		
		currentAnimation = dwn;
	}
}
