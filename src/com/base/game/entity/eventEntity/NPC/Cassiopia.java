package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Cassiopia extends NPC
{
	public Cassiopia(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(20, 40, 25, 30));
		
		currSpeed = 5;
		scriptNum = 2;
		
		stationary = Assets.NPC7Stationary;
		
		lft = new Animation(150, Assets.NPC7Lft, 0);
		rgt = new Animation(150, Assets.NPC7Rgt, 0);
		up = new Animation(150, Assets.NPC7Up, 0);
		dwn = new Animation(150, Assets.NPC7Dwn, 0);
		
		currentAnimation = dwn;
	}
}
