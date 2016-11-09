package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Dollface extends NPC
{
	public Animation attack;
	public Dollface(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 72, 72);
		setBounds(new Rectangle(20, 40, 25, 30));
		
		currSpeed = 5;
		scriptNum = 2;
		
		stationary = Assets.NPC11Stationary;
		
		lft = new Animation(150, Assets.NPC11Lft, 0);
		rgt = new Animation(150, Assets.NPC11Rgt, 0);
		up = new Animation(150, Assets.NPC11Up, 0);
		dwn = new Animation(150, Assets.NPC11Dwn, 0);
		
		attack = new Animation(100, Assets.NPC11Attack, 1);
		
		currentAnimation = dwn;
	}
	
	public void setCurrentAnimation(Animation currentAnimation) {
		this.currentAnimation = currentAnimation;
		
	}
}
