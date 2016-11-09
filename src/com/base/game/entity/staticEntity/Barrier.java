package com.base.game.entity.staticEntity;

import com.base.game.Handler;

public class Barrier extends StaticEntity
{
	public Barrier(Handler handler, float x, float y, int layer, int width, int height)
	{
		super(handler, x, y, layer, width, height);
		doNotRenderShadow = true;
	}

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		
	}

}
