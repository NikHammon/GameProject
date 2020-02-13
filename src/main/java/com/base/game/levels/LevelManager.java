package com.base.game.levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.base.game.Assets;
import com.base.game.DialogBox;
import com.base.game.Handler;
import com.base.game.InventoryInterface;
import com.base.game.PlayerInterface;
import com.base.game.Utils;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;
import com.base.game.entity.staticEntity.Door;
import com.base.game.tiles.Tile;

public class LevelManager
{
	private Handler handler;
	private PlayerInterface pInterface;
	private InventoryInterface iInterface;
	
	public List<Level> levels;
	public List<Dungeon> dungeons;
	private BaseCamp baseCamp;
	private WorldMap worldMap;
	private Player oldPlayer;
	private int currentLevel, currentDungeon;
	private int spawnX, spawnY, spawnLayer;
	private String state;
	private boolean inDungeon;
	
	public LevelManager(Handler handler)
	{
		this.handler = handler;
		pInterface = new PlayerInterface(handler);
		iInterface = new InventoryInterface(handler);
		
		baseCamp = new BaseCamp(handler);
		worldMap = new WorldMap(handler);
		levels = new ArrayList<Level>();
		dungeons = new ArrayList<Dungeon>();
		inDungeon = false;
	}
	
	public void addLevel(Level level)
	{
		levels.add(level);
	}
	
	public void addDungeon(Dungeon dungeon)
	{
		dungeons.add(dungeon);
	}

	public void setCurrentLevel(int level)
	{
//		for(Entity e : levels.get(level).geteManager().getEntities())
//		{
//			if(e instanceof Door)
//			{
//				if(levels.get(currentLevel).getLastDoorUsed() == ((Door)e).getId())
//				{
//					spawnX = (int)e.getX();
//					spawnY = (int)e.getY();
//				}
//			}
//		}
		currentLevel = level;
		oldPlayer = handler.getLevel().geteManager().getPlayer();
		handler.setLevel(levels.get(level));

		if(oldPlayer.getyMove() <= 0)
			spawnY--;		
		else if(oldPlayer.getyMove() >= 0)
			spawnY++;	
		else if(oldPlayer.getxMove() >= 0)
			spawnX++;
		else if(oldPlayer.getxMove() <= 0)
			spawnX--;
		
		handler.getLevel().geteManager().getPlayer().equip(oldPlayer);
		levels.get(level).spawnPlayer(spawnX, spawnY, spawnLayer);
		
	}
	
//	public void setCurrentLevel(Level level, int spawnX, int spawnY, int spawnLayer)
//	{
//		oldPlayer = handler.getLevel().geteManager().getPlayer();
//		handler.setLevel(level);
//		handler.getLevel().geteManager().getPlayer().equip(oldPlayer);
//		level.spawnPlayer(spawnX, spawnY, spawnLayer);
//	}
//	
//	public void setCurrentLevel(int level, int spawnX, int spawnY, int spawnLayer)
//	{
//		currentLevel = level;	
//		handler.setLevel(levels.get(level));
//		levels.get(level).spawnPlayer(spawnX, spawnY, spawnLayer);
//	}
	
	
	float minAlpha = 0;
	float maxAlpha = 1;
	public void update()
	{	
		if(state == "INTODUNGEON")
		{
			if(handler.getGame().getGameState().getEffects().getState() == "FADEIN")
			{
				if(handler.getGame().getGameState().getEffects().getAlpha() == maxAlpha)
				{
					inDungeon = true;
					dungeons.get(currentDungeon).generateLevel();
					handler.getGame().getGameState().getEffects().displayDungeon(dungeons.get(currentDungeon).getCurrentFloorNum(), dungeons.get(currentDungeon).getName());
				}
			}
			else if(handler.getGame().getGameState().getEffects().getState() == "DUNGEONDISPLAY")
			{
				if(handler.getGame().getGameState().getEffects().getTimer() > 10000)
				{
					handler.getGame().getGameState().getEffects().fade(minAlpha);
				}
			}
			else if(handler.getGame().getGameState().getEffects().getState() == "FADEOUT")
			{
				if(handler.getGame().getGameState().getEffects().getAlpha() == minAlpha)
				{
					handler.getGame().getGameState().getEffects().setState("");
					state = "";
					if(handler.getLevel().isQuestFloor())
						handler.getGame().getGameState().getEffects().displayDialog(7);
				}
			}
		}
		else if(state == "GAMEOVER")
		{
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1 && handler.getGame().getGameState().getEffects().getdBox().isComplete())
			{
				oldPlayer = handler.getGame().getPlayer();
				dungeons.get(currentDungeon).setCurrentFloorNum(0);	
				inDungeon = false;	
				handler.getGame().getGameState().getEffects().fade(0);	
				handler.getBaseCamp().setState("BEDROOM");
				handler.getGame().getPlayer().setX(252);
				handler.getGame().getPlayer().setY(244);
				handler.getBaseCamp().setNPCs();
				handler.getBaseCamp().setBarriers();
				handler.getGame().geteManager().getPlayer().refresh(oldPlayer);
				state = "";
			}
		}

		if(worldMap.isActive())
		{
			worldMap.update();
		}
		else
		{
			if(iInterface.isActive())
				iInterface.update();
			else
			{
				if(inDungeon)
					dungeons.get(currentDungeon).update();
				else
					baseCamp.update();
			}
		
			pInterface.update();
		}
			
		if(handler.getGame().getPlayer().getState() == "DEAD")
		{
			handler.getGame().getGameState().getEffects().displayDialog(0);
			state = "GAMEOVER";
			handler.getGame().getGameState().getEffects().fade(1);			
		}	
		
	}
	
	public void render(Graphics g)
	{	
		if(worldMap.isActive())
		{
			worldMap.render(g);
		}
		else
		{
			if(inDungeon)
				dungeons.get(currentDungeon).render(g);
			else
				baseCamp.render(g);
			
			if(iInterface.isActive())
				iInterface.render(g);
			
			pInterface.render(g);
		}	
		
	}
	
	public void setCurrentDungeon(int dungeon)
	{
		state = "INTODUNGEON";
		currentDungeon = dungeon;
		handler.getGame().getGameState().getEffects().fade(maxAlpha);
	}
	
	public boolean isInDungeon() {return inDungeon;}
	public void setInDungeon(boolean inDungeon) {this.inDungeon = inDungeon;}
	public Level getCurrentLevel(){return levels.get(currentLevel);}
	public Dungeon getCurrentDungeon(){return dungeons.get(currentDungeon);}
	public String getState() {return state;}
	public void setState(String state) {this.state = state;}
	public PlayerInterface getpInterface() {return pInterface;}
	public void setpInterface(PlayerInterface pInterface) {this.pInterface = pInterface;}
	
	public InventoryInterface getiInterface() {
		return iInterface;
	}

	public void setiInterface(InventoryInterface iInterface) {
		this.iInterface = iInterface;
	}

	public int getNumCurrentDungeon(){return currentDungeon;}

	public BaseCamp getBaseCamp() {
		return baseCamp;
	}

	public void setBaseCamp(BaseCamp baseCamp) {
		this.baseCamp = baseCamp;
	}

	public WorldMap getWorldMap() {
		return worldMap;
	}

	public void setWorldMap(WorldMap worldMap) {
		this.worldMap = worldMap;
	}

	public List<Dungeon> getDungeons() {
		return dungeons;
	}

	public void setDungeons(List<Dungeon> dungeons) {
		this.dungeons = dungeons;
	}
	
	
}
