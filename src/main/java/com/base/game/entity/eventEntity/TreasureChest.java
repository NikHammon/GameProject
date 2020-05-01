package com.base.game.entity.eventEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.item.Item;
import com.base.game.entity.item.MainItem;

public class TreasureChest extends EventEntity
{	
	private Item item;
	private MainItem mainItem;
	private String string = "";
	private boolean opened;
	public TreasureChest(Handler handler, float x, float y, int layer, int direction, Item item) {
		super(handler, x, y, layer, 64, 96);
		bounds.x = 0;
		bounds.y = 53;
		bounds.width = 60;
		bounds.height = 28;
		this.layer = layer;
		this.item = item;
		checkDirection(direction);
		
	}
	
	public TreasureChest(Handler handler, float x, float y, int layer, int direction, MainItem mainItem) {
		super(handler, x, y, layer, 64, 96);
		bounds.x = 0;
		bounds.y = 53;
		bounds.width = 60;
		bounds.height = 28;
		this.layer = layer;
		this.mainItem = mainItem;
		checkDirection(direction);
		
	}
	
	public TreasureChest(Handler handler, float x, float y, int layer, int direction, String string) {
		super(handler, x, y, layer, 64, 96);
		bounds.x = 0;
		bounds.y = 53;
		bounds.width = 60;
		bounds.height = 28;
		this.layer = layer;
		this.string = string;
		checkDirection(direction);
		
	}
	
	public void checkDirection(int direction) {
		if(direction == 0) {
			currentAnimation = new Animation(100, Assets.chestUp, 1);
			eventSpace = new Rectangle(getCollisionBounds(0,0).x + 10, getCollisionBounds(0,0).y - 25, bounds.width - 20, bounds.height);
		}
		else if(direction == 1) {
			currentAnimation = new Animation(100, Assets.chestRight, 1);
			eventSpace = new Rectangle(getCollisionBounds(0,0).x - 10, getCollisionBounds(0,0).y + 10, bounds.width - 10, bounds.height);
		}
		else if(direction == 2) {
			currentAnimation = new Animation(100, Assets.chestDown, 1);
			eventSpace = new Rectangle(getCollisionBounds(0,0).x + 10, getCollisionBounds(0,0).y + 20, bounds.width - 20, bounds.height);
		}
		else {
			currentAnimation = new Animation(100, Assets.chestLeft, 1);
			eventSpace = new Rectangle(getCollisionBounds(0,0).x + 20, getCollisionBounds(0,0).y + 10, bounds.width - 10, bounds.height);
		}
	}

	@Override
	public void update() {
		if(on && !opened) {
			currentAnimation.update();
			if(item != null)
				handler.getGame().getGameState().getLevelManager().getiInterface().addItem(item);
			else if(mainItem != null)
				handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[mainItem.getID()] = mainItem;
			else if(string == "HEARTCRYSTAL") {
				//handler.getBaseCamp().getChestsOpened()[handler.getGame().getGameState().getLevelManager().getNumCurrentDungeon()] = true;
				handler.getGame().getPlayer().addHeartCrystal();
			}
			
			mainItem = null;
			item = null;
			string = "";
		}
		
		if(currentAnimation.isComplete())
			opened = true;
		if(opened)
			currentAnimation.setIndex(3);
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
		//g.setColor(Color.red);
		//g.fillRect((int)(eventSpace.x - handler.getCamera().getxOffset()), (int)(eventSpace.y - handler.getCamera().getyOffset()), eventSpace.width, eventSpace.height);
	}

	public boolean isOpened() {
		return opened;
	}

	public void setOpened(boolean opened) {
		this.opened = opened;
	}

	
}
