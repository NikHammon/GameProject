package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Fairy extends NPC
{
	public Fairy(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 52, 60);
		setBounds(new Rectangle(20, 40, 25, 30));
		
		currSpeed = 2;
		scriptNum = 2;
		canFly = true;
		
		lft = new Animation(150, Assets.fairyUpLft, 0);
		rgt = new Animation(150, Assets.fairyDwnRgt, 0);
		up = new Animation(150, Assets.fairyUpRgt, 0);
		dwn = new Animation(150, Assets.fairyDwnLft, 0);
		
		currentAnimation = dwn;
	}
}
