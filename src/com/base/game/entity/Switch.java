package com.base.game.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.base.game.Handler;
import com.base.game.tiles.Tile;

public abstract class Switch extends Entity
{
	protected BufferedImage switchOn, switchOff;
	
	public Switch(Handler handler, float x, float y, int layer, int id) 
	{
		super(handler, x, y, layer, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

		on = false;
		this.id = id;
	}

	@Override
	public void update()
	{
		for(Entity e : handler.getGame().geteManager().entities)
		{
			if(e instanceof Switch)
				continue;
			if(id == e.id)
				e.on = on;
		}
	}

	@Override
	public void render(Graphics g) {
		if(!on)
			g.drawImage(switchOff, (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
		else
			g.drawImage(switchOn, (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
	}

	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}
	
}
