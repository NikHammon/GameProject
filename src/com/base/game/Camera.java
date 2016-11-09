package com.base.game;

import com.base.game.entity.Entity;
import com.base.game.tiles.Tile;

public class Camera 
{
	private Handler handler;
	private float xOffset, yOffset;
	
	public Camera(Handler handler, float xOffset, float yOffset)
	{
		this.handler = handler;
		this.setxOffset(xOffset);
		this.setyOffset(yOffset);
	}
	
	int tileWidth, tileHeight;
	public void checkBlankSpace()
	{
		if(handler.getGame().getGameState().getLevelManager().isInDungeon())
		{
			if(xOffset < 0)
				xOffset = 0;
			else if(xOffset > handler.getGame().getWidth() * Tile.TILE_WIDTH - handler.getGame().getWidth())
				xOffset = handler.getGame().getWidth() * Tile.TILE_WIDTH - handler.getGame().getWidth();
			if(yOffset < 0)
				yOffset = 0;
			else if(yOffset > handler.getGame().getHeight() * Tile.TILE_HEIGHT - handler.getGame().getHeight())
				yOffset = handler.getGame().getHeight() * Tile.TILE_HEIGHT - handler.getGame().getHeight();
		}
		else
		{
			if(xOffset < 0)
				xOffset = 0;
			else if(xOffset > handler.getGame().getGameState().getLevelManager().getBaseCamp().getCurrentWidth() - handler.getGame().getWidth())
				xOffset = handler.getGame().getGameState().getLevelManager().getBaseCamp().getCurrentWidth() - handler.getGame().getWidth();
			if(yOffset < 0)
				yOffset = 0;
			else if(yOffset > handler.getGame().getGameState().getLevelManager().getBaseCamp().getCurrentHeight() - handler.getGame().getHeight())
				yOffset = handler.getGame().getGameState().getLevelManager().getBaseCamp().getCurrentHeight() - handler.getGame().getHeight();
		}
	}

	public void centerOnEntity(Entity e)
	{
		xOffset = e.getX() - handler.getGame().getWidth() / 2 + e.getWidth() / 2;
		yOffset = e.getY() - handler.getGame().getHeight() / 2 + e.getHeight() / 2;
		checkBlankSpace();
	}
	
	public void move(float xAmt, float yAmt)
	{
		xOffset += xAmt;
		yOffset += yAmt;
		checkBlankSpace();
	}
	
	float speed = 4.5f;
	boolean isComplete;
	public boolean scrawl(float xEnd, float yEnd)
	{
		isComplete = true;
		if(xEnd > xOffset + speed)
		{
			xOffset += speed;
			isComplete = false;
		}
		else if(xEnd < xOffset - speed)
		{
			xOffset -= speed;
			isComplete = false;
		}
		
		if(yEnd > yOffset + speed)
		{
			yOffset += speed;
			isComplete = false;
		}
		else if(yEnd < yOffset - speed)
		{
			yOffset -= speed;
			isComplete = false;
		}
		
		return isComplete;
	}
	
	public float getxOffset() {return xOffset;}
	public void setxOffset(float xOffset) {this.xOffset = xOffset;}
	public float getyOffset() {return yOffset;}
	public void setyOffset(float yOffset) {this.yOffset = yOffset;}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
			
}
