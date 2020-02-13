package com.base.game.entity;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.attacks.Attack;
import com.base.game.entity.eventEntity.DroppedItem;
import com.base.game.entity.eventEntity.Energy;
import com.base.game.entity.eventEntity.Gold;
import com.base.game.entity.eventEntity.HeartCrystal;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.eventEntity.NPC.Dollface;
import com.base.game.entity.eventEntity.NPC.NPC;
import com.base.game.entity.eventEntity.NPC.Obin;
import com.base.game.entity.item.Item;
import com.base.game.entity.item.MainItem;
import com.base.game.entity.item.WhipSegment;
import com.base.game.entity.monsters.BossMonster;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.staticEntity.Barrier;
import com.base.game.tiles.Tile;

public abstract class Entity 
{	
	public static final int UP = 0;
	public static final int UPRIGHT = 1;
	public static final int RIGHT = 2;
	public static final int DOWNRIGHT = 3;
	public static final int DOWN = 4;
	public static final int DOWNLEFT = 5;
	public static final int LEFT = 6;
	public static final int UPLEFT = 7;

	public static final int NO_DIRECTION = 8;
	
	protected int direction;
	protected int knockBack;
	protected int level;
	protected String state;
	protected String statusCondition;

	protected Handler handler;
	protected float x, y;
	protected float oldPosX, oldPosY;
	protected float centerPosX, centerPosY;
	
	protected int width, height, layer;
	protected int id;
	
	protected int rVal, bVal, gVal;
	
	protected boolean on;
	protected boolean doNotRender;
	protected boolean doNotUpdate;
	protected boolean canBeKnkBack;
	protected boolean renderBelowTile;
	protected Rectangle bounds;
	protected Rectangle attackBounds;
	protected int renderOrder;//higher renders last or is seen on top
	
	protected Animation currentAnimation;
	
	protected long timer, lastTime;
	
	protected Random rand;
	
	public Entity(Handler handler, float x, float y, int layer, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.layer = layer;
		this.handler = handler;
		
		bounds = new Rectangle(0, 0, width, height);
		
		centerPosX = x + bounds.x + bounds.width/2;
		centerPosY = y + bounds.y + bounds.height/2;
		
		oldPosX = x;
		oldPosY = y;
		renderOrder = 3;
		setCanBeKnkBack(true);
		id = 0;
		on = false;
		state = "";
		statusCondition = "";
		
		rand = new Random();
	}

	public abstract void update();
	
	protected int shadowOffsetY, shadowOffsetX;
	protected boolean doNotRenderShadow;
	public void render(Graphics g)
	{
		if(!doNotRenderShadow)
			g.drawImage(Assets.shadow, (int) (x - shadowOffsetX - handler.getCamera().getxOffset()), (int) (y + height - 12 - shadowOffsetY - handler.getCamera().getyOffset()), 64, 24, null);
	}
	
	public void fadeTint()
	{
		if(rVal > 0)
			rVal -= 5;
		else
			rVal = 0;
		if(gVal > 0)
			gVal -= 5;
		else
			gVal = 0;
		if(bVal > 0)
			bVal -= 5;
		else
			bVal = 0;
	}
	
	int numItemsDropped;
	public void dropItem()
	{
		numItemsDropped = 8;
		ArrayList<Integer> dirs = new ArrayList<Integer>();
		switch(level)
		{
		default:	
			while(numItemsDropped > 0)
			{
				int item = rand.nextInt(6);
				
				int dir = rand.nextInt(8);
				while(dirs.contains(dir))
					dir = rand.nextInt(8);
				
				dirs.add(dir);
				
				if(item >= 1 && item <= 2)
				{
					if(rand.nextInt(3) == 0)
					{
						handler.getGame().geteManager().addEntity(new Energy(handler, x, y, layer, 2, dir));
					}
					else
					{
						handler.getGame().geteManager().addEntity(new Energy(handler, x, y, layer, 1, dir));
						
					}
				}
				else if(item >= 3 && item <= 5)
				{
					if(rand.nextInt(3) == 0)
					{
						handler.getGame().geteManager().addEntity(new Gold(handler, x, y, layer, 2, dir));
					}
					else
					{
						handler.getGame().geteManager().addEntity(new Gold(handler, x, y, layer, 5, dir));
					}
				}
				
				numItemsDropped--;
			}
			
			break;
		}
	}
	
	boolean recovering = false;
	protected boolean damagesPlayerOnImpact, isWalkable;
	public Entity getCollidedWith(float xOffset, float yOffset)
	{
		for(Entity e : handler.getGame().geteManager().entities)
		{	
			if(e.equals(this))
				continue;
			if(e.isRecovering() || recovering)
				continue;
			if(e instanceof WhipSegment || this instanceof WhipSegment)
				continue;
			if(e instanceof DroppedItem || this instanceof DroppedItem || e instanceof Portal || this instanceof Portal)
				continue;
			if(e.getLayer() != layer)
				continue;
			if(this instanceof MainItem && e instanceof Player)
				continue;
			if(this instanceof NPC && e instanceof Barrier)
				continue;
			if(this instanceof Obin && e instanceof Dollface)
				continue;
			if((e instanceof Player || this instanceof Player) && (damagesPlayerOnImpact || e.isDamagesPlayerOnImpact()) && e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
			{
				if(this instanceof Player)
					e.damageEntity(this);
				else
					damageEntity(e);
				continue;
			}
			if(isWalkable || e.isWalkable)
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))//checks rectangle
				return e;
		}
		return null;
	}
	
	public void damageEntity(Entity e){};
	
//	public boolean collisionWithTile(float x, float y)
//	{	
//		if(this instanceof Creature)
//			return handler.getLevel().getTile((int)(x/Tile.TILE_WIDTH), (int)(y/Tile.TILE_HEIGHT), layer).checkCollision(x, y, (Creature)this);
//		else if(this instanceof Attack)
//			return handler.getLevel().getTile((int)(x/Tile.TILE_WIDTH), (int)(y/Tile.TILE_HEIGHT), layer).checkAttackCollision(x, y, (Attack)this);
//		else 
//			return false;
//	}
	
	public Rectangle getCollisionBounds(float xOffset, float yOffset)
	{
		return new Rectangle((int)(x + bounds.x + xOffset), (int)(y + bounds.y + yOffset), bounds.width, bounds.height);
	}
	
	public Rectangle getAttackBounds(float xOffset, float yOffset)
	{
		return new Rectangle((int)(x + attackBounds.x + xOffset), (int)(y + attackBounds.y + yOffset), attackBounds.width, attackBounds.height);
	}
	
	public Rectangle resolveToTile()
	{
		int myPosX =(int)x + bounds.x + bounds.width/2;
		int myPosY = (int)y + bounds.y + bounds.height/2;
		
		return new Rectangle((myPosX - (myPosX % 64)), (myPosY - (myPosY % 64)), Tile.TILE_WIDTH, Tile.TILE_HEIGHT);	
	}
	
	public Rectangle getBounds() {return bounds;}
	public void setBounds(Rectangle bounds) {this.bounds = bounds;}
	public float getX() {return x;}
	public void setX(float x) {this.x = x;}
	public float getY() {return y;}
	public void setY(float y) {this.y = y;}
	public int getWidth() {return width;}
	public void setWidth(int width) {this.width = width;}
	public int getHeight() {return height;}
	public void setHeight(int height) {this.height = height;}
	public Animation getCurrentAnimation(){return currentAnimation;}
	public String getState() {return state;}
	public void setState(String state) {this.state = state;}
	public float getCenterPosX() {return centerPosX;}
	public void setCenterPosX(float centerPosX) {this.centerPosX = centerPosX;}
	public float getCenterPosY() {return centerPosY;}
	public void setCenterPosY(float centerPosY) {this.centerPosY = centerPosY;}
	public Rectangle getAttackBounds() {return attackBounds;}
	public void setAttackBounds(Rectangle attackBounds) {this.attackBounds = attackBounds;}
	public int getrVal() {return rVal;}
	public void setrVal(int rVal) {this.rVal = rVal;}
	public int getbVal() {return bVal;}
	public void setbVal(int bVal) {this.bVal = bVal;}
	public int getgVal() {return gVal;}
	public void setgVal(int gVal) {this.gVal = gVal;}	
	public int getLayer() {return layer;}
	public void setLayer(int layer) {this.layer = layer;}

	public boolean isDoNotRender() {
		return doNotRender;
	}

	public void setDoNotRender(boolean doNotRender) {
		this.doNotRender = doNotRender;
	}

	public boolean isDoNotUpdate() {
		return doNotUpdate;
	}

	public void setDoNotUpdate(boolean doNotUpdate) {
		this.doNotUpdate = doNotUpdate;
	}
	
	public String getStatusCondition() {
		return statusCondition;
	}

	public void setStatusCondition(String statusCondition) {
		this.statusCondition = statusCondition;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public boolean canBeKnkBack() {
		return canBeKnkBack;
	}

	public void setCanBeKnkBack(boolean canBeKnkBack) {
		this.canBeKnkBack = canBeKnkBack;
	}

	public boolean isRenderBelowTile() {
		return renderBelowTile;
	}

	public void setRenderBelowTile(boolean renderBelowTile) {
		this.renderBelowTile = renderBelowTile;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isRecovering() {
		return recovering;
	}

	public void setRecovering(boolean recovering) {
		this.recovering = recovering;
	}

	public boolean isDamagesPlayerOnImpact() {
		return damagesPlayerOnImpact;
	}

	public void setDamagesPlayerOnImpact(boolean damagesPlayerOnImpact) {
		this.damagesPlayerOnImpact = damagesPlayerOnImpact;
	}

	public boolean isWalkable() {
		return isWalkable;
	}

	public void setWalkable(boolean isWalkable) {
		this.isWalkable = isWalkable;
	}

	public boolean isDoNotRenderShadow() {
		return doNotRenderShadow;
	}

	public void setDoNotRenderShadow(boolean doNotRenderShadow) {
		this.doNotRenderShadow = doNotRenderShadow;
	}
	
	
			
}
