package com.base.game.entity.staticEntity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;

public class Breakables extends StaticEntity
{
	protected int level;
	
	public Breakables(Handler handler, float x, float y, int layer, int width, int height, int level) 
	{
		super(handler, x, y, layer, width, height);
		this.level = level;
	}
	
	public void update()
	{
		switch(state)
		{
		case "HIT":
			hit();	
			break;
		case "BROKEN":
			broken();	
			break;
		}
	}
	
	Rectangle tempBounds;
	public void hit()
	{
		tempBounds = bounds;
		bounds = new Rectangle(0,0,0,0);
		renderOrder = 1;
		dropItem();
		state = "BROKEN";
	}
	
	public void broken()
	{
		currentAnimation.update();
		
		if(currentAnimation.isComplete())
			handler.getGame().geteManager().removeEntity(this);
	}
	
	public void reset(float x, float y, int layer)
	{
		this.x = x;
		this.y = y;
		this.layer = layer;
		state = "";
		renderOrder = 3;
		bounds = tempBounds;
		currentAnimation.reset();
	}

	@Override
	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		
	}

}
