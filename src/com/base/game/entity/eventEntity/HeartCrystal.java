package com.base.game.entity.eventEntity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Assets;
import com.base.game.Handler;

public class HeartCrystal extends DroppedItem
{
	public HeartCrystal(Handler handler, float x, float y, int layer, int direction) 
	{
		super(handler, x, y, layer, 32, 32, direction);
		setBounds(new Rectangle(6, 6, 21, 21));
		
		eventSpace = getCollisionBounds(0, 0);
		renderOrder = 2;
	}
	
	float yRate = 0.25f;
	float yStart = y;
	float yEnd = y + 5;
	@Override
	public void update()
	{
		if(state == "SPAWNING")
			spawn();
		
		if(y < yStart || y > yEnd)
			yRate = -yRate;
	
		y+=yRate;
			
		if(handler.getGame().geteManager().getPlayer().getState() == "CHASE" && eventSpace.intersects(handler.getGame().geteManager().getPlayer().getCollisionBounds(0, 0)))
		{
			handler.getGame().geteManager().removeEntity(this);
			handler.getGame().getPlayer().addHeartCrystal();
		}
		
		eventSpace = getCollisionBounds(0, 0);
	}
	
	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.heartCrystal, (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
	}
}
