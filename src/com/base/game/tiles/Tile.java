package com.base.game.tiles;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.base.game.Assets;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.Attack;
import com.base.game.entity.item.WingedBoots;
import com.base.game.entity.item.ShadowPuppet;

public class Tile 
{	
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
	
	private BufferedImage texture;
	private int id;
	private CollisionMap cMap;
	
	public Tile(BufferedImage texture, CollisionMap cMap, int id)
	{
		this.texture = texture;
		this.id = id;
		this.cMap = cMap;
	}
	
	public Tile(BufferedImage texture)
	{
		this.texture = texture;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics g, int x, int y)
	{
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid()
	{
		for(int i = 0; i < cMap.getTargets().length; i++)
		{
			for(int j = 0; j < cMap.getTargets().length; j++)
			{
				if(cMap.getTargets()[i][j] != 0)
					return true;
			}
		}
		return false;
	}
	
	public boolean isNotSolidGround()
	{
		for(int i = 0; i < cMap.getTargets().length; i++)
		{
			for(int j = 0; j < cMap.getTargets().length; j++)
			{
				if(cMap.getTargets()[i][j] == 0)
					return false;
			}
		}
		return true;
	}
	
	public int getID(){return id;}
	public CollisionMap getcMap() {return cMap;}
	public void setcMap(CollisionMap cMap) {this.cMap = cMap;}

}
