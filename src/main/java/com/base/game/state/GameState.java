package com.base.game.state;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.ParallaxLayer;
import com.base.game.PlayerInterface;
import com.base.game.UserData;
import com.base.game.levels.Dgn1;
import com.base.game.levels.Dgn2;
import com.base.game.levels.Dgn3;
import com.base.game.levels.Dgn4;
import com.base.game.levels.Dgn5;
import com.base.game.levels.Dgn6;
import com.base.game.levels.Dgn7;
import com.base.game.levels.Dgn8;
import com.base.game.levels.Dungeon;
import com.base.game.levels.Level;
import com.base.game.levels.LevelGenerator;
import com.base.game.levels.LevelManager;
import com.base.game.tiles.Tile;

public class GameState extends State
{
	private LevelManager levelManager;
	private LevelGenerator levelGenerator;
	
	private long gameStart, timer;
	private int totalHours, totalMins;
	
	private int startLevel;
	private int currentLevel;
	private int nextLevel;	
	
	public GameState(Handler handler)
	{
		super(handler);
			
		timer = 0;
		levelManager = new LevelManager(handler);
		
		levelGenerator = new LevelGenerator();

		levelManager.addDungeon(new Dgn1(handler, levelGenerator, new ParallaxLayer(handler, Assets.cloudSheet), "CRAWLY CAVERN"));
		levelManager.addDungeon(new Dgn2(handler, levelGenerator, new ParallaxLayer(handler, Assets.cloudSheet), "GALE ISLE"));
		levelManager.addDungeon(new Dgn3(handler, levelGenerator, new ParallaxLayer(handler, Assets.cloudSheet), "SHOCKWAVE ABYSS"));
		levelManager.addDungeon(new Dgn4(handler, levelGenerator, new ParallaxLayer(handler, Assets.cloudSheet), "DRAGONBREATH CAVERN"));
		levelManager.addDungeon(new Dgn5(handler, levelGenerator, new ParallaxLayer(handler, Assets.cloudSheet), "FROSTY FJORDS"));
		levelManager.addDungeon(new Dgn6(handler, levelGenerator, new ParallaxLayer(handler, Assets.cloudSheet), "PALACE OF THE GODS"));
		levelManager.addDungeon(new Dgn7(handler, levelGenerator, new ParallaxLayer(handler, Assets.cloudSheet), "DARKNIGHT RIDGE"));
		levelManager.addDungeon(new Dgn8(handler, levelGenerator, new ParallaxLayer(handler, Assets.cloudSheet), "FORSAKEN LAND"));

	}
	
	@Override
	public void update()
	{		
		levelManager.update();	

		if(currentLevel != nextLevel)
		{	
			levelManager.setCurrentLevel(nextLevel);
			currentLevel = nextLevel;
		}
		
		timer = System.currentTimeMillis() - gameStart;
		
		if(timer >= 60000)
		{
			totalMins++;
			gameStart = System.currentTimeMillis();
		}
		if(totalMins >= 60)
		{
			totalHours++;
			totalMins = 0;
		}
	}
	

	@Override
	public void render(Graphics g) 
	{
		levelManager.render(g);
		effects.render(g);
	}
	
	

	public int getCurrentLevel() {return currentLevel;}
	public void setCurrentLevel(int currentLevel) {this.currentLevel = currentLevel;}
	public int getNextLevel() {return nextLevel;}
	public void setNextLevel(int nextLevel) {this.nextLevel = nextLevel;}
	public LevelManager getLevelManager() {return levelManager;}
	public void setLevelManager(LevelManager levelManager) {this.levelManager = levelManager;}

	public int getTotalHours() {
		return totalHours;
	}

	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}

	public int getTotalMins() {
		return totalMins;
	}

	public void setTotalMins(int totalMins) {
		this.totalMins = totalMins;
	}

	public long getGameStart() {
		return gameStart;
	}

	public void setGameStart(long gameStart) {
		this.gameStart = gameStart;
	}

			
}
