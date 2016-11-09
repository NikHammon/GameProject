package com.base.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.base.game.levels.Cliffs;
import com.base.game.tiles.Tile;

public class ParallaxLayer 
{
	private Handler handler;
	private SpriteSheet sheet;
	private BufferedImage clouds;
	private float x, y;
	
	ArrayList<Cliffs> cliffs;
	
	public ParallaxLayer(Handler handler, SpriteSheet sheet)
	{
		this.handler = handler;
		this.sheet = sheet;
		cliffs = new ArrayList<Cliffs>();
	}
	
	public void update(float xSpeed, float ySpeed)
	{
		updateCloudLayer(xSpeed, ySpeed);		
	}
	
	int cloudSpeed = 2;
	public void updateCloudLayer(float xSpeed, float ySpeed)
	{
		x += cloudSpeed + xSpeed;
		y += ySpeed/2;
		if(x > 2000 - handler.getWidth() || x < 0)
			cloudSpeed = -cloudSpeed;
		
		checkSpace();
		clouds = sheet.crop((int)x, (int)y, handler.getWidth(), handler.getHeight());
	}
	
	public void checkSpace()
	{
		if(x < 0)
			x = 0;
		else if(x >= 2000 - handler.getWidth())
			x = 2000 - handler.getWidth();
		if(y < 0)
			y = 0;
		else if(y >= 2000 - handler.getHeight())
			y = 2000 - handler.getHeight();
	}
	
	public void setCliff(int x, int y)
	{
		cliffs.add(new Cliffs(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT));
	}
	
	public void endCliff(int x)
	{
		cliffs.get(cliffs.size()).setEndX(x * Tile.TILE_WIDTH);
	}	

	public void render(Graphics g)
	{
		//g.setColor(new Color(100, 165, 180));
		//g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		for(Cliffs c : cliffs)
		{
			c.render(g);
		}		
		
		g.drawImage(clouds, 0, 0, handler.getWidth(), handler.getHeight(), null);
	}
	
	public ArrayList<Cliffs> getCliffs() {return cliffs;}
	public void setCliffs(ArrayList<Cliffs> cliffs) {this.cliffs = cliffs;}
}
