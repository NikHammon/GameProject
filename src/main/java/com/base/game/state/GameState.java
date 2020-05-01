package com.base.game.state;

import java.awt.Graphics;

import com.base.game.Handler;
import com.base.game.entity.EntityManager;
import com.base.game.entity.Player;
import com.base.game.levels.Level;
import com.base.game.levels.LevelManager;

public class GameState extends State {
	private LevelManager levelManager;
	private EntityManager eManager;

	private long gameStart, timer;
	private int totalHours, totalMins;

	private Level startLevel;
	private Level currentLevel;
	private Level nextLevel;

	public GameState(Handler handler) {
		super(handler);
		timer = 0;
		levelManager = new LevelManager(handler);
		eManager = new EntityManager(handler, new Player(handler));
	}

	@Override
	public void update() {
		levelManager.update();

		if (currentLevel != nextLevel) {
			levelManager.setCurrentLevel(nextLevel);
			currentLevel = nextLevel;
		}

		timer = System.nanoTime() - gameStart;

		if (timer >= 60000) {
			totalMins++;
			gameStart = System.nanoTime();
		}
		if (totalMins >= 60) {
			totalHours++;
			totalMins = 0;
		}
	}

	@Override
	public void render(Graphics g) {
		levelManager.render(g);
		effects.render(g);
	}

	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}

	public Level getNextLevel() {
		return nextLevel;
	}

	public void setNextLevel(Level nextLevel) {
		this.nextLevel = nextLevel;
	}

	public LevelManager getLevelManager() {
		return levelManager;
	}

	public EntityManager geteManager() {
		return eManager;
	}

	public Player getPlayer() {
		return eManager.getPlayer();
	}

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
