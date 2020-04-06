package com.base.game.state;
import java.awt.Graphics;

import com.base.game.Handler;
import com.base.game.levels.Level;
import com.base.game.levels.LevelGenerator;
import com.base.game.levels.LevelManager;

public class GameState extends State
{
	private LevelManager levelManager;

	private long gameStart, timer;
	private int totalHours, totalMins;
	
	private Level startLevel;
	private Level currentLevel;
	private Level nextLevel;
	
	public GameState(Handler handler) {
		super(handler);
			
		timer = 0;
		levelManager = new LevelManager(handler);
	}
	
	@Override
	public void update() {
		levelManager.update();	

		if(currentLevel != nextLevel) {
			levelManager.setCurrentLevel(nextLevel);
			currentLevel = nextLevel;
		}
		
		timer = System.currentTimeMillis() - gameStart;
		
		if(timer >= 60000) {
			totalMins++;
			gameStart = System.currentTimeMillis();
		}
		if(totalMins >= 60) {
			totalHours++;
			totalMins = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		levelManager.render(g);
		effects.render(g);
	}

	public Level getCurrentLevel() {return currentLevel;}
	public void setCurrentLevel(Level currentLevel) {this.currentLevel = currentLevel;}
	public Level getNextLevel() {return nextLevel;}
	public void setNextLevel(Level nextLevel) {this.nextLevel = nextLevel;}
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
