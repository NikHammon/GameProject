package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.base.game.Handler;
import com.base.game.entity.Entity;
import com.base.game.entity.staticEntity.StaticEntity;
import com.base.game.tiles.Tile;

public class Pathfinder
{
	public static final int UP = 0;
	public static final int UPRIGHT = 1;
	public static final int RIGHT = 2;
	public static final int DOWNRIGHT = 3;
	public static final int DOWN = 4;
	public static final int DOWNLEFT = 5;
	public static final int LEFT = 6;
	public static final int UPLEFT = 7;
	
	private static int targetTileX;
	private static int targetTileY;
	
	static int[][] tiles = new int[11][11];
	static ArrayList<String> shortestPath;
	
//	public void chase()
//	{
//		Rectangle playerBounds = handler.getLevel().geteManager().getPlayer().getCollisionBounds(0, 0);
//		moveTo(playerBounds.x - Tile.TILE_WIDTH/4, playerBounds.y - Tile.TILE_HEIGHT/2);
//		
//		if(layer != handler.getLevel().geteManager().getPlayer().getLayer())
//			state = "IDLE";
//		if(stoppedByEntity)
//		{
//			shortestPath = findPath(handler.getLevel().geteManager().getPlayer());
//			if(shortestPath == null)
//				state = "IDLE";
//			else
//			{
//				hasPath = true;
//			}
//		}
//
//		if(hasPath)
//		{
//			xMove = 0;
//			yMove = 0;
//	
//			forceMove(shortestPath);
//			
//		}
//		move();
//		
//	}

	public static String[] findPath(Handler handler, Entity predator, Entity target)
	{	
		targetTileX = -1;
		targetTileY = -1;
		shortestPath = new ArrayList<String>();
		calcGrid(handler, predator, target);
		
		if(targetTileX == -1 && targetTileY == -1)
			return null;
		else
		{
			orderGrid();
			
//			for(int y = 0; y < tiles.length; y++)
//			{
//				for(int x = 0; x < tiles.length; x++)
//				{
//					if(tiles[x][y] == -1)
//						System.out.print('W' + " ");
//					else
//						System.out.print(tiles[x][y] + " ");
//				}
//				System.out.println();
//			}
			
			findShortestPath(targetTileX, targetTileY);
			//System.out.println(shortestPath);
			
			return shortestPath.toArray(new String[shortestPath.size()]);
		}	
		
	}
	
	private static void findShortestPath(int x, int y)
	{
		int tries = 0;
		while(x < tiles.length && y < tiles.length && tries < 10 && tiles[x][y] != 0)
		{
			tries ++;
			int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
			
			if(x < tiles.length-1 && tiles[x + 1][y] >= 0)
				a = tiles[x + 1][y];
			if(x > 0 && tiles[x - 1][y] >= 0)
				b = tiles[x - 1][y];	
			if(y < tiles.length-1 && tiles[x][y + 1] >= 0)
				c = tiles[x][y + 1];
			if(y > 0 && tiles[x][y - 1] >= 0)
				d = tiles[x][y - 1];			
			
			if(a == Math.min(Math.min(Math.min(a, b), c), d))
			{
				shortestPath.add(0, "LEFT");
				x++;
			}
			
			else if(b == Math.min(Math.min(Math.min(a, b), c), d))
			{
				shortestPath.add(0, "RIGHT");
				x--;
			}
			
			else if(c == Math.min(Math.min(Math.min(a, b), c), d))
			{
				shortestPath.add(0, "UP");
				y++;
			}
			
			else if(d == Math.min(Math.min(Math.min(a, b), c), d))
			{
				shortestPath.add(0, "DOWN");
				y--;
			}
		}
	}
	
	private static void orderGrid()
	{
		ArrayList<Integer> stops = new ArrayList<Integer>();
		for(int y = 0; y >= -tiles.length/2; y--) // right/up
		{
			for(int x = 0; x <= tiles.length/2; x++)
			{
				if(stops.contains(x) && tiles[x + tiles.length/2][y + tiles.length/2] != -1)
					tiles[x + tiles.length/2][y + tiles.length/2] = -5;
				else{
					if(tiles[x + tiles.length/2][y + tiles.length/2] == 1)
						tiles[x + tiles.length/2][y + tiles.length/2] = Math.abs(x) + Math.abs(y);
					else if(tiles[x + tiles.length/2][y + tiles.length/2] == -1)
						stops.add(x);
				}
			}	
		}
		
		stops.removeAll(stops);
		
		for(int x = 0; x <= tiles.length/2; x++)
		{
			for(int y = 0; y >= -tiles.length/2; y--)
			{
				if(stops.contains(y) && tiles[x + tiles.length/2][y + tiles.length/2] != -1)
					tiles[x + tiles.length/2][y + tiles.length/2] = -5;
				else if(tiles[x + tiles.length/2][y + tiles.length/2] == -1)
						stops.add(y);
				
			}	
		}
	
		stops.removeAll(stops);
		
		for(int y = 0; y >= -tiles.length/2; y--) //left/up
		{
			for(int x = 0; x >= -tiles.length/2; x--)
			{
				if(stops.contains(x) && tiles[x + tiles.length/2][y + tiles.length/2] != -1)
					tiles[x + tiles.length/2][y + tiles.length/2] = -5;
				else{
					if(tiles[x + tiles.length/2][y + tiles.length/2] == 1)
						tiles[x + tiles.length/2][y + tiles.length/2] = Math.abs(x) + Math.abs(y);
					else if(tiles[x + tiles.length/2][y + tiles.length/2] == -1)
						stops.add(x);
				}
			}	
		}
		
		stops.removeAll(stops);
		
		for(int x = 0; x >= -tiles.length/2; x--) 
		{
			for(int y = 0; y >= -tiles.length/2; y--)
			{
				if(stops.contains(y) && tiles[x + tiles.length/2][y + tiles.length/2] != -1)
					tiles[x + tiles.length/2][y + tiles.length/2] = -5;
				else if(tiles[x + tiles.length/2][y + tiles.length/2] == -1)
						stops.add(y);
				
			}	
		}
	
		stops.removeAll(stops);
		
		for(int y = 0; y <= tiles.length/2; y++) //left/down
		{
			for(int x = 0; x >= -tiles.length/2; x--)
			{
				if(stops.contains(x) && tiles[x + tiles.length/2][y + tiles.length/2] != -1)
					tiles[x + tiles.length/2][y + tiles.length/2] = -5;
				else{
					if(tiles[x + tiles.length/2][y + tiles.length/2] == 1)
						tiles[x + tiles.length/2][y + tiles.length/2] = Math.abs(x) + Math.abs(y);
					else if(tiles[x + tiles.length/2][y + tiles.length/2] == -1)
						stops.add(x);
				}
			}	
		}
		
		stops.removeAll(stops);
		
		for(int x = 0; x >= -tiles.length/2; x--) 
		{
			for(int y = 0; y <= tiles.length/2; y++)
			{
				if(stops.contains(y) && tiles[x + tiles.length/2][y + tiles.length/2] != -1)
					tiles[x + tiles.length/2][y + tiles.length/2] = -5;
				else if(tiles[x + tiles.length/2][y + tiles.length/2] == -1)
						stops.add(y);
				
			}	
		}
		
		stops.removeAll(stops);
		
		for(int y = 0; y <= tiles.length/2; y++) //right/down
		{
			for(int x = 0; x <= tiles.length/2; x++)
			{
				if(stops.contains(x) && tiles[x + tiles.length/2][y + tiles.length/2] != -1)
					tiles[x + tiles.length/2][y + tiles.length/2] = -5;
				else{
					if(tiles[x + tiles.length/2][y + tiles.length/2] == 1)
						tiles[x + tiles.length/2][y + tiles.length/2] = Math.abs(x) + Math.abs(y);
					else if(tiles[x + tiles.length/2][y + tiles.length/2] == -1)
						stops.add(x);
				}
			}	
		}
		
		stops.removeAll(stops);
		
		for(int x = 0; x <= tiles.length/2; x++) 
		{
			for(int y = 0; y <= tiles.length/2; y++)
			{
				if(stops.contains(y) && tiles[x + tiles.length/2][y + tiles.length/2] != -1)
					tiles[x + tiles.length/2][y + tiles.length/2] = -5;
				else if(tiles[x + tiles.length/2][y + tiles.length/2] == -1)
						stops.add(y);
				
			}	
		}
		
	    spiral(true);
	    spiral(false);
	    
		for(int y1 = 0; y1 < tiles.length; y1++) //remainders
		{
			for(int x1 = 0; x1 < tiles.length; x1++)
			{
				if(getSmallestTile(x1, y1) > 0 && tiles[x1][y1] == -5 || tiles[x1][y1] > getSmallestTile(x1, y1) + 1)
				{
					tiles[x1][y1] = getSmallestTile(x1, y1) + 1;
				}
	
			}
		}
	
//	    for(int y1 = 0; y1 < tiles.length; y1++)
//			{
//				for(int x1 = 0; x1 < tiles.length; x1++)
//				{
//					if(tiles[x1][y1] == -1)
//						System.out.print('W' + " ");
//					else
//						System.out.print(tiles[x1][y1] + " ");
//				}
//				System.out.println();
//			}
		
	}
	
	private static void spiral(boolean right)
	{
		int x, y, dx, dy;
		if(right)
		{
			dx = 0;
		    dy = -1;
		}
		else
		{
			dx = 0;
			dy = 1;
		}

	    x = y = tiles.length/2;
	    
	    int temp, pass, layer;
	    pass = 0;
	    layer = 1;

	    for(int i =0; i < tiles.length * tiles.length; i++)
	    {
	        if (tiles[x][y] == -5 || tiles[x][y] > getSmallestTile(x, y) + 1)
	        {
	        	if(getSmallestTile(x, y) > 0)
				{
					tiles[x][y] = getSmallestTile(x, y) + 1;
						
				}
	        }
	        if((x == y) || ((x < tiles.length) && (Math.abs(x-y) == layer)) || ((x > 0) && (Math.abs(x-y) == layer)))
	        {
	            temp = dx;
	            dx = -dy;
	            dy = temp;
	            pass++;
	            if(pass == 3)
	            {
	            	pass = 1;
	            	layer++;
	            }
	        }
	        x += dx;
	        y += dy;
	    }
	}
	
	private static int getSmallestTile(int x, int y)
	{
		int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
		int min;
		if(x + 1 < tiles.length && tiles[x + 1][y] >= 0)
			a = tiles[x + 1][y];
		if(x - 1 > 0 && tiles[x - 1][y] >= 0)
			b = tiles[x - 1][y];
		if(y + 1 < tiles.length && tiles[x][y + 1] >= 0)
			c = tiles[x][y + 1];
		if(y - 1 > 0 && tiles[x][y - 1] >= 0)
			d = tiles[x][y - 1];
		
		min = Math.min(Math.min(Math.min(a, b), c), d);
		if(min == Integer.MAX_VALUE)
			return -1;
		else
			return min;
	}
	
	private static void calcGrid(Handler handler, Entity predator, Entity target)
	{	
		int startX = predator.resolveToTile().x - tiles.length/2 * Tile.TILE_WIDTH;
		int startY = predator.resolveToTile().y - tiles.length/2 * Tile.TILE_HEIGHT;
		
		for(int y = 0; y < tiles.length; y++)
		{
			for(int x = 0; x < tiles.length; x++)
			{	
				tiles[x][y] = checkTileForEntity(handler, predator, target, startX + x * Tile.TILE_WIDTH, startY + y * Tile.TILE_HEIGHT);
				if(tiles[x][y] == -5)
				{
					targetTileX = x;
					targetTileY = y;
					tiles[x][y] = 1;
				}
			}
		}
		
	}

	private static int checkTileForEntity(Handler handler, Entity predator, Entity target, int x, int y)
	{
		Rectangle tileRect = new Rectangle(x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);

		for(Entity e : handler.getGame().geteManager().getEntities())
		{
			if(tileRect.intersects(e.getCollisionBounds(0,0)))
			{
				if(e == predator)
					continue;
				if(e instanceof StaticEntity)
					return -1;
			}
			if(tileRect.intersects(target.resolveToTile()))
				return -5;
			if(tileRect.intersects(predator.resolveToTile()))
				return 0;
		}
		if(tileRect.x/64 >= handler.getGame().getWidth() || tileRect.y/64 >= handler.getGame().getWidth()
			|| tileRect.x/64 < 0 || tileRect.y/64 < 0)
			return -1;
		
		if(handler.getLevel().getTile(tileRect.x/64, tileRect.y/64, predator.getLayer()).isSolid())
			return -1;
		
		return 1;
	}

}
