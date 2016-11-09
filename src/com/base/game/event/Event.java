package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Entity;
import com.base.game.entity.EntityManager;
import com.base.game.entity.Player;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.eventEntity.TreasureChest;
import com.base.game.tiles.Tile;

public abstract class Event 
{
	protected Handler handler;
	protected Rectangle eventSpace;
	
	protected EntityManager eManager;
	protected Player player;
	
	protected String state;
	protected int operation, num;
	protected boolean running;
	
	protected Portal portal;
	protected TreasureChest chest;
	
	protected Animation shocked, suprised, laughing, inquisitive, embarassed, angry;
	
	public Event(Handler handler)
	{
		this.handler = handler;
		shocked = new Animation(50, Assets.shocked, 5);
		suprised = new Animation(150, Assets.suprised, 1);
		laughing = new Animation(150, Assets.laughing, 7);
		inquisitive = new Animation(150, Assets.inquisitive, 1);
		embarassed = new Animation(300, Assets.embarassed, 1);
		angry = new Animation(200, Assets.angry, 3);
		
		portal = new Portal(handler, 12f * Tile.TILE_WIDTH - 64, 12f * Tile.TILE_HEIGHT, 2);
		chest = new TreasureChest(handler, 12f * Tile.TILE_WIDTH - 32, 3 * Tile.TILE_HEIGHT, 2, 2, "HEARTCRYSTAL");
	}
	
	boolean ranOnce;
	
	public abstract boolean meetsRequirements();
	public abstract void run(Graphics g);

	long timer, lastTime;
	int milliseconds, lastOp;
	public void delay(int milliseconds)
	{
		lastOp = operation;
		operation = -1;
		lastTime = System.currentTimeMillis();
		this.milliseconds = milliseconds;
		timer = 0;
	}
	
	public void runDelay()
	{
		timer += System.currentTimeMillis() - lastTime;
		
		if(timer > milliseconds)
		{
			operation= lastOp + 1;
		}
	}
	
	public void complete()
	{
		chest.setOpened(handler.getBaseCamp().getChestsOpened()[handler.getGame().getGameState().getLevelManager().getNumCurrentDungeon()]);
		
		handler.getGame().geteManager().addEntity(chest);
		handler.getGame().geteManager().addEntity(portal);
	}
	
	public Rectangle getEventSpace() {
		return eventSpace;
	}

	public void setEventSpace(Rectangle eventSpace) {
		this.eventSpace = eventSpace;
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	public void setRunning()
	{
		eManager = handler.getGame().geteManager();
		player = handler.getGame().getPlayer();
		running = true;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	public boolean isRanOnce() {
		return ranOnce;
	}
	public void setRanOnce(boolean ranOnce) {
		this.ranOnce = ranOnce;
	}
	public int getOperation() {
		return operation;
	}
	public void setOperation(int operation) {
		this.operation = operation;
	}
	
	
}
