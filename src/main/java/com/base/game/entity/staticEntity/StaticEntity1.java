package com.base.game.entity.staticEntity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.tiles.Tile;

public class StaticEntity1 extends StaticEntity
{
	
	
	public StaticEntity1(Handler handler, float x, float y, int layer) {
		super(handler, x, y, layer, Tile.TILE_WIDTH, Tile.TILE_HEIGHT * 2);
		bounds.y = 80;
		bounds.height = 35;
	}

	@Override
	public void update()
	{

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(myImage, (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
	}

	
	
	
}
