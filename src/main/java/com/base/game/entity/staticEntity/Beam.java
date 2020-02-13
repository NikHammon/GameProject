package com.base.game.entity.staticEntity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Entity;
import com.base.game.entity.attacks.Attack;

public class Beam extends Attack
{

	public Beam(Handler handler, float x, float y, int layer) 
	{
		super(handler, null, x, y, layer, 64, 256);
		currentAnimation = new Animation(100, Assets.beam, 0);
	}

	@Override
	public void update() 
	{
		currentAnimation.update();
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
	}

}
