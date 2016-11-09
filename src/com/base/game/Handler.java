package com.base.game;

import com.base.game.levels.BaseCamp;
import com.base.game.levels.Level;
import com.base.game.levels.LevelManager;

public class Handler
{
	private Game game;
	private Level level;
	public Handler(Game game)
	{
		this.game = game;
	}

	public int getWidth(){return game.getWidth();}	
	public int getHeight(){return game.getHeight();}	
	public Input getInput(){return game.getInput();}	
	public Camera getCamera(){return game.getCamera();}
	public Game getGame() {return game;}
	public void setGame(Game game) {this.game = game;}
	public Level getLevel() {return level;}
	public void setLevel(Level level) {this.level = level;}	
	public BaseCamp getBaseCamp() {return game.getGameState().getLevelManager().getBaseCamp();}	
	
}
