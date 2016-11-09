package com.base.game.levels;

import java.awt.Graphics;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Entity;

public class Cliffs extends Entity
{
	private float endX;
	public Cliffs(Handler handler, float x, float y) {
		super(handler, x, y, 0, 0, 800);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.cliffs, (int)(x - handler.getCamera().getxOffset()), (int)(y - handler.getCamera().getyOffset()), width, height, null);
		
	}

	public float getEndX() {
		return endX;
	}

	public void setEndX(float endX) {
		this.endX = endX;
		width = (int) (endX - x);
	}
	
}
