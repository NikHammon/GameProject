package com.base.game.levels;

import java.awt.Graphics;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.ParallaxLayer;
import com.base.game.Utils;
import com.base.game.entity.Entity;
import com.base.game.entity.EntityManager;
import com.base.game.entity.Player;
import com.base.game.tiles.CollisionMap;
import com.base.game.tiles.Tile;

public class Level {
	public static final int DEFAULT_LEVEL_WIDTH = 20,
							DEFAULT_LEVEL_HEIGHT = 20;
		
	private Handler handler;
	private int width, height, layers, numEntities;
	private int[][][] tiles;	//positions for each tile	
	
	private int lastDoorUsed;
	
	private Dungeon dungeon;

	private boolean isQuestFloor = false;

	public Level(Handler handler, String path, Dungeon dungeon) {
		this.handler = handler;	
		this.dungeon = dungeon;
		loadLevel(path);
	}
	
	public void update() {
		handler.getGame().geteManager().update();
	}	
	
	public void render(Graphics g) {
		//tiles only draw in viewport
		int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tile.TILE_WIDTH + 1);
		int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd = (int) Math.min(height, (handler.getCamera().getyOffset() + handler.getHeight()) / Tile.TILE_HEIGHT + 1);

		for(int z = 0; z < layers; z++) {
			for(int y = yStart; y < yEnd; y++) {
				for(int x = xStart; x < xEnd; x++) {
					if(dungeon != null && z == 0 && (tiles[x][y][z] == 14 || tiles[x][y][z] == 15 || tiles[x][y][z] == 16))
						tiles[x][y][z] += 12; // 14 becomes 26 to represent the lower tiles that fade to black in dungeons

					if(tiles[x][y][z] != 0)
						getTile(x,y,z).render(g, (int)(x * Tile.TILE_WIDTH - handler.getCamera().getxOffset()),
												 (int)(y * Tile.TILE_HEIGHT - handler.getCamera().getyOffset()));
				}

				for(Entity e : handler.getGame().geteManager().getEntities()) {
					if(isEntityOnScreen(e, xStart, xEnd, yStart, yEnd)) {
						if(e.isRenderBelowTile()) {
							if(e.getLayer() == z + 1)
								handler.getGame().geteManager().render(e, g);
						}
						else {
							if((e.getY()-20)/Tile.TILE_HEIGHT > y && e.getLayer() == z - 1){
								if(e.getState() == "FALLING") {
									if(e.getDirection() == 7 || e.getDirection() == 0 || e.getDirection() == 1) {
										handler.getGame().geteManager().render(e, g);
									}
								} else
									handler.getGame().geteManager().render(e, g);
							} else if(e.getLayer() == z)// renders all entities
								handler.getGame().geteManager().render(e, g);
						}
					}
				}
			}
		}
	}

	private boolean isEntityOnScreen(Entity e, int xStart, int xEnd, int yStart, int yEnd) {
		return e.getX() + e.getWidth() > xStart * (Tile.TILE_WIDTH - 1) &&
			   e.getX() < xEnd * (Tile.TILE_WIDTH) &&
			   e.getY() + e.getHeight() > yStart * (Tile.TILE_HEIGHT - 1) &&
			   e.getY() < yEnd * (Tile.TILE_HEIGHT);
	}
	
	public Tile getTile(int x, int y, int z) {
		Tile t = null;
		
		if(x < tiles.length && x >= 0 && y < tiles[0].length && y >= 0 && z < tiles[0][0].length && z >= 0)
			t = dungeon.getTile(tiles[x][y][z]);
		
		if(t == null)
			return new Tile(Assets.black, new CollisionMap("7.txt"), 0);
		return t;
	}
	
	int nextTile;
	public void loadLevel(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		layers = Utils.parseInt(tokens[2]);
		numEntities = Utils.parseInt(tokens[3]);
		
		tiles = new int[width][height][layers];
		for(int z = 0; z < layers; z++)
			for(int y = 0; y < height; y++)
				for(int x = 0; x < width; x++) {
					nextTile = Utils.parseInt(tokens[(x + y * width) + (height * width * z) + 4]);
					if(dungeon != null && nextTile == 7 && ThreadLocalRandom.current().nextInt(50) == 1)
						tiles[x][y][z] = 29;
					else
						tiles[x][y][z] = nextTile;
				}
		
		int eData = 0;
		int passes = 0;
		for(int i = 0; i < numEntities; i++) {
			eData = Utils.parseInt(tokens[width * height * layers + 4 + passes]);
			System.out.println(String.format("E DATA: %d", eData));
			if(eData == 4) {
				if(dungeon == null)
					handler.getGame().geteManager().addEntity(Utils.parseInt(tokens[width * height * layers + 4 + passes + 1]), Utils.parseInt(tokens[width * height * layers + 4 + passes + 2]), Utils.parseInt(tokens[width * height * layers + 4 + passes + 3]), Utils.parseInt(tokens[width * height * layers + 4 + passes + 4]));

				handler.getGame().geteManager().addEntity(Utils.parseInt(tokens[width * height * layers + 4 + passes + 1]), Utils.parseInt(tokens[width * height * layers + 4 + passes + 2]), Utils.parseInt(tokens[width * height * layers + 4 + passes + 3]), Utils.parseInt(tokens[width * height * layers + 4 + passes + 4]));
			}
				
			passes+=eData+1;
			
		}
		
		Cliffs aCliff = null;
		if(dungeon != null) {
			for(int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					if(aCliff == null) {
						if(tiles[x][y][0] == 14 || tiles[x][y][0] == 15 || tiles[x][y][0] == 16)
							aCliff = new Cliffs(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
					}
					else if(aCliff != null) {
						if(tiles[x][y][0] != 14 && tiles[x][y][0] != 15 && tiles[x][y][0] != 16) {
							aCliff.setEndX(x * Tile.TILE_WIDTH);
							// dungeon.getpLayer().getCliffs().add(aCliff);
							aCliff = null;
						}
					}
				}
				
				if(aCliff != null) {
					aCliff.setEndX(tiles.length * Tile.TILE_WIDTH);
					// dungeon.getpLayer().getCliffs().add(aCliff);
					aCliff = null;
				}
			}
		}
	}

	public int getLastDoorUsed() {return lastDoorUsed;}
	public void setLastDoorUsed(int lastDoorUsed) {this.lastDoorUsed = lastDoorUsed;}
	public EntityManager geteManager() {return handler.getGame().geteManager();}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	public boolean isQuestFloor() { return isQuestFloor; }
	public void setQuestFloor(boolean isQuestFloor) { this.isQuestFloor = isQuestFloor; }
}
