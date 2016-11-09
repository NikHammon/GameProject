package com.base.game.entity.staticEntity;

import java.awt.Color;
import java.awt.Graphics;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.tiles.Tile;

public class Pitfall extends StaticEntity
{
	public Pitfall(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
//		bounds.y = 80;
//		bounds.x = 60;
//		bounds.height = 5;
//		bounds.width = 5;
		renderOrder = 1;
	}

	@Override
	public void update()
	{

	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(Assets.pitfall, (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
		
	}
}
