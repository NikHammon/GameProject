package com.base.game.levels;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.ParallaxLayer;
import com.base.game.Utils;
import com.base.game.entity.EntityManager;
import com.base.game.entity.Player;
import com.base.game.entity.eventEntity.DungeonDoor;
import com.base.game.entity.eventEntity.QuestEntity;
import com.base.game.event.Event;
import com.base.game.tiles.Tile;

public abstract class Dungeon
{
	protected Handler handler;
	protected LevelGenerator levelGenerator;
	protected Holomap hMap;
	
	protected ParallaxLayer pLayer;
	protected String name;
	protected String theme, bossRoom;
	protected int currentFloorNum, bossFloorNum, maxFloors, dgnNum;//maxFloor is one less than actually not counting boss floor
	protected boolean generatedQuestFloor;
	
	protected Event bossEvent;
	
	public Tile[] tiles = new Tile[256];
	
	Random rand = new Random();
	public Dungeon(Handler handler, LevelGenerator levelGenerator, ParallaxLayer pLayer, String name)
	{
		this.handler = handler;
		this.levelGenerator = levelGenerator;
		this.pLayer = pLayer;
		this.name = name;
		hMap = new Holomap(handler);
		maxFloors = 1;
		
		addTiles();
	}
	
	Level currentLevel;
	long lastTime, timer;
	Player oldPlayer;
	public void generateLevel()
	{
		currentFloorNum++;
		
		if(currentFloorNum == bossFloorNum)		
		{
			oldPlayer = handler.getGame().getPlayer();
				
			currentLevel = new Level(handler, bossRoom, this);
			handler.setLevel(currentLevel);
	
			currentLevel.spawnPlayer(12 * Tile.TILE_WIDTH - 32, 23 * Tile.TILE_HEIGHT, 2);
			
			currentLevel.geteManager().getPlayer().equip(oldPlayer);

			if(handler.getBaseCamp().getDungeonsCleared() >= dgnNum)
			{
				bossEvent.complete();
			}
			if(bossEvent.meetsRequirements() && !bossEvent.isRunning())
			{
				bossEvent.setOperation(0);
				bossEvent.setRunning(true);
			}
			
		}
		else
		{
			levelGenerator.setElements();
	
			while(!levelGenerator.path()){//tests if pathing is possible, if not possible, assigns a random seed and goes from there repeating assignment of random seeds until a valid map exists.
				levelGenerator = new LevelGenerator();
				levelGenerator.setElements();
			}
			levelGenerator.seek();
			levelGenerator.toTextFile("./res/levels", "Dgn1.txt");
			
			if(currentFloorNum == 1)//needed bc is inDungeon is true at this point
				oldPlayer = handler.getGame().getGameState().getLevelManager().getBaseCamp().geteManager().getPlayer();
			else
				oldPlayer = handler.getGame().getPlayer();
				
			currentLevel = new Level(handler, "Dgn1.txt", this);
			handler.setLevel(currentLevel);
	
			handler.getLevel().setQuestFloor(generatedQuestFloor);
			generatedQuestFloor = false;
			currentLevel.spawnPlayer((levelGenerator.getStartX() + 11) * Tile.TILE_WIDTH, (levelGenerator.getStartY() + 11) * Tile.TILE_HEIGHT, 2);
			
			currentLevel.geteManager().getPlayer().equip(oldPlayer);
			Utils.playSound(theme);
		}
	}
	
	public void update()
	{
		currentLevel.update();		
		hMap.update(levelGenerator);
	}
	
	public void render(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
		
		currentLevel.render(g);
		
		if(currentFloorNum != bossFloorNum)
			hMap.render(g, levelGenerator);
		
		if(bossEvent.isRunning())
			bossEvent.run(g);
	}
	
	public void addEntity(EntityManager eManager, int eNum, int x, int y, int l)
	{
		switch(eNum)
		{
		case 0:	
			eManager.addEntity(new DungeonDoor(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l));
		break;
		case 6:	
			for(int i = 0; i < handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().size(); i++)
			{
				if(handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().get(i).getLocation().equals(name))
				{
					if(handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().get(i).getFloorNum() == currentFloorNum)
					{
						eManager.addEntity(new QuestEntity(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l, handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().get(i)));
						generatedQuestFloor = true;
					}
				}
			}
			break;
		}
	}
	
	public abstract void addTiles();
	public abstract Tile getTile(int tileNum);	
	public Level getCurrentLevel() {return currentLevel;}
	public void setCurrentLevel(Level currentLevel) {this.currentLevel = currentLevel;}
	public int getCurrentFloorNum() {return currentFloorNum;}
	public void setCurrentFloorNum(int currentFloorNum) {this.currentFloorNum = currentFloorNum;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public ParallaxLayer getpLayer() {return pLayer;}
	public void setpLayer(ParallaxLayer pLayer) {this.pLayer = pLayer;}

	public boolean isGeneratedQuestFloor() {
		return generatedQuestFloor;
	}

	public void setGeneratedQuestFloor(boolean generatedQuestFloor) {
		this.generatedQuestFloor = generatedQuestFloor;
	}

	public int getMaxFloors() {
		return maxFloors;
	}

	public void setMaxFloors(int maxFloors) {
		this.maxFloors = maxFloors;
	}

	public int getBossFloorNum() {
		return bossFloorNum;
	}

	public void setBossFloorNum(int bossFloorNum) {
		this.bossFloorNum = bossFloorNum;
	}

	public int getDgnNum() {
		return dgnNum;
	}

	public void setDgnNum(int dgnNum) {
		this.dgnNum = dgnNum;
	}
	
	
}
