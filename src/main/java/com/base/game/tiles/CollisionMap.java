package com.base.game.tiles;

import com.base.game.Utils;

public class CollisionMap 
{
	private int[][] targets;
	public CollisionMap(String path)
	{
		String file = Utils.loadCMFileAsString(path);
		String[] tokens = file.split("\\s+");
		
		targets = new int[32][32];
		
		for(int y = 0; y < 32; y++)
			for(int x = 0; x < 32; x++)
			{
				targets[x][y] = Utils.parseInt(tokens[(x + y * 32)]);
			}
	}
	
	
	public int[][] getTargets() {return targets;}
	public void setTargets(int[][] targets) {this.targets = targets;}
	
}
