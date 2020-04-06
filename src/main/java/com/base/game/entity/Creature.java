package com.base.game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.item.WingedBoots;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.item.MonkeyStaff;
import com.base.game.entity.item.ShadowPuppet;
import com.base.game.entity.item.WhipSegment;
import com.base.game.entity.monsters.Monster;
import com.base.game.tiles.CollisionMap;
import com.base.game.tiles.Tile;

public abstract class Creature extends Entity
{
	public static final int DEFAULT_HEALTH = 10;

	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 64,
							DEFAULT_CREATURE_HEIGHT = 64;
	
	
	protected int oldLayer;
	
	protected int health;
	protected int myHealth;
	
	protected float currSpeed;
	protected float baseSpeed;

	protected float xMove, yMove, xVel, yVel;	
	
	protected float lastPosX, lastPosY, fallSpeedX, fallSpeedY, fallSpeedG;//variables for falling
	protected int lastLayer;//variables for falling
	
	protected boolean canFly;
	protected boolean collided;
	protected boolean hasPath;
	protected int stunDuration;//how many update ticks to stun something
	protected int stunThreshold;// how many update ticks to update right before a stun is applied (so creature can go flying back)
	
	// following status variables not currently in use 
	protected int slowDuration;// how many update ticks something will be slowed for (or sped up... hmm...)
	protected int bleedDuration;//update ticks to bleed
	protected int silenceDuration;//update ticks a unit cannot cast spells
	protected int fearDuration;// update ticks a unit can only run away from player
	
	public Creature(Handler handler, float x, float y, int layer, int width, int height) 
	{
		super(handler, x, y, layer, width, height);
		myHealth = DEFAULT_HEALTH;
		baseSpeed = DEFAULT_SPEED;

		currSpeed = baseSpeed;
		health = myHealth;
		xMove = 0;
		yMove = 0;
		
		attackBounds = new Rectangle(0,0,0,0);
		stunDuration = 0;
		collided = false;
		hasPath = false;
	}

	public void update()
	{
		centerPosX = x - bounds.x + bounds.width/2;
		centerPosY = y + bounds.height/2;
		
		if(currentAnimation != null && state != "RECOVERING")
			currentAnimation.update();

	}
	
	public void checkStatus()
	{
		switch(statusCondition)
		{
		case "POISONED":
			poisoned();
			break;
		case "PARALYZED":
			paralyzed();
			break;
		case "BURNED":
			burned();
			break;
		case "FROZEN":
			frozen();
			break;
		case "CONFUSED":
			confused();
			break;
			
		default:
			fadeTint();
		}
		
		if(rVal <=0)//so colors are never outside expected parameters
			rVal = 0;
		else if(rVal >= 255)
			rVal = 255;
		if(bVal <=0)
			bVal = 0;
		else if(bVal >= 255)
			bVal = 255;
		if(gVal <=0)
			gVal = 0;
		else if(gVal >= 255)
			gVal = 255;
		
	}
	
	public void takeDamage(int damage)
	{
		if(state != "KNOCKBACK")
		{
			health-=damage;
			rVal = 200;	
		}
	}
	
	public void recover()
	{
		state = "RECOVERING";
		if(health < 0)
		{
			rVal+=10;
			bVal+=10;
			gVal+=10;
		}

		if(rVal == 0)
		{
			state = "CHASE";
		}
	}
	
	int confuRate = 10;
	int confuFactor = 1;
	public void confused()
	{		
		confuFactor = -1;
		if(gVal + confuRate < 0 || gVal + confuRate > 255)
		{
			confuRate = -confuRate;
			count++;		
		}
		rVal+= confuRate/3;
		bVal+= confuRate*3;
		gVal+= confuRate;
		
		if(count > 10)
		{
			statusCondition = "";
			count = 0;
			confuFactor = 1;
		}
	}
	
	int posiRate = 10;
	public void poisoned()
	{		
		currSpeed = baseSpeed/2;
		if(gVal + posiRate < 0 || gVal + posiRate > 255)
		{
			posiRate = -posiRate;
			count++;
			if(count % 3 == 0)
				health--;
		}
		rVal = 0;
		bVal = 0;
		gVal+= posiRate;
		
		if(count > 10)
		{
			statusCondition = "";
			currSpeed = baseSpeed;
			count = 0;
		}
	}
	
	int burnRate = 20;
	public void burned()
	{		
		currSpeed = baseSpeed*2;
		if(rVal + burnRate < 0 || rVal + burnRate > 255)
		{
			burnRate = -burnRate;
			count++;
			if(count % 3 == 0)
				health--;
		}
		rVal += burnRate;
		bVal = 0;
		gVal += burnRate;
		
		if(count > 10)
		{
			statusCondition = "";
			currSpeed = baseSpeed;
			count = 0;
		}
	}
	
	int paraRate = 20;
	int count;
	public void paralyzed()
	{		
		currSpeed = 0;
		if(rVal + paraRate < 0 || rVal + paraRate > 255)
		{
			paraRate = -paraRate;
			count++;
		}
		rVal+= paraRate;
		gVal+= paraRate;
		bVal+= paraRate;
		
		if(count > 10)
		{
			state = "CHASE";
			statusCondition = "";
			count = 0;
			currSpeed = baseSpeed;
		}
	}
	
	int frezRate = 20;
	public void frozen()
	{		
		currSpeed = 0;
		if(rVal + frezRate < 0 || rVal + frezRate > 255)
		{
			frezRate = -frezRate;
			count++;
		}
		rVal+= frezRate/2;
		gVal+= frezRate/2;
		bVal+= frezRate;
		
		if(count > 10)
		{
			state = "CHASE";
			statusCondition = "";
			count = 0;
			currSpeed = baseSpeed;
		}
	}
	
	
	
	public void move()
	{	
		oldPosX = x;
		oldPosY = y;
		
		xMove *= confuFactor;
		yMove *= confuFactor;
		
		if(xMove != 0 && yMove != 0 && state != "FALLING")
		{
			xMove /= Math.sqrt(2);
			yMove /= Math.sqrt(2);
		}	
			
		if(getCollidedWith(xMove, 0f) == null)
			moveX();
		else
			collided = true;
		if(getCollidedWith(0f, yMove) == null)
			moveY();				
		else
			collided = true;
		
		xVel = x - oldPosX;
		yVel = y - oldPosY;

		oldLayer = layer;
	}
	
	int index;
	float distance = 0;
	float distUp;
	float distDown;
	float distRgt;
	float distLft;
	
	String[] moves;
	public void setForceMove(String... strings)
	{
		moves = strings;
		state = "FORCEMOVE";
		distUp = (y + bounds.y + bounds.height) - (resolveToTile().y + 64);
		distDown = (resolveToTile().y - (y + bounds.y));
		distRgt = (resolveToTile().x) - (x + bounds.x);
		distLft = (x + bounds.x + bounds.width) - (resolveToTile().x + 64);
		
		if(distUp > 0)
			yMove -= distUp + 1;
		if(distDown > 0)
			yMove += distDown + 1;
		if(distRgt > 0)
			xMove += distRgt + 1;
		if(distLft > 0)
			xMove -= distLft + 1;
	}
	
	public void forceMove()
	{	
		xMove = 0;
		yMove = 0;
		
		if(distance >= 64)
		{
			distance = 0;
			index++;
		}
		
		if(moves != null && index < moves.length)
		{
			if(moves[index] == "UP")
				yMove = -currSpeed;
			
			else if(moves[index] == "DOWN")
				yMove = currSpeed;

			else if(moves[index] == "RIGHT")
				xMove = currSpeed;

			else if(moves[index] == "LEFT")
				xMove = -currSpeed;	

			distance += Math.abs(xMove) + Math.abs(yMove);
			move();
		}
		else
		{
			index = 0;
			hasPath = false;
			state = "CHASE";
		}		
		
		if(this instanceof Player)
			((Player)this).setCurrentAnimation();
		else if(this instanceof Monster)
			((Monster)this).setCurrentAnimation();
			
		if(currentAnimation != null)
			currentAnimation.update();
		
	}
	
	public void moveTo(float pointX, float pointY)
	{
		xMove = 0;
		yMove = 0;
		if(!(pointX - currSpeed/2 <= x  && x <= pointX + currSpeed/2))
		{
			if(pointX > x)//right
			{
				xMove += currSpeed;
				direction = RIGHT;
			}
			if(pointX < x)//left
			{
				xMove -= currSpeed;	
				direction = LEFT;
			}
		}
		if(!(pointY - currSpeed/2 <= y && y <= pointY + currSpeed/2))
		{
			if(pointY > y)//down
			{
				yMove += currSpeed;
				direction = DOWN;
			}
			if(pointY < y)//up
			{
				yMove -= currSpeed;	
				direction = UP;
			}
		}
		
	}
	
	public void moveX()
	{	
		if(xMove > 0)//right
		{
			float tx = (x + xMove + bounds.x + bounds.width);
			
			if(!collisionWithTile(tx, (y + bounds.y), tx, (y + bounds.y + bounds.height)))
			{
				x += xMove;
				collided = false;
			}
			else		
				collided = true;
		}
		else if(xMove < 0)//left
		{
			float tx = (x + xMove + bounds.x);
			
			if(!collisionWithTile(tx, (y + bounds.y), tx, (y + bounds.y + bounds.height)))
			{
				x += xMove;
				collided = false;
			}
			else
				collided = true;
		}
	}
	
	public void moveY()
	{
		if(yMove < 0)//up
		{			
			float ty = (y + yMove + bounds.y);
			
			if(!collisionWithTile((x + bounds.x), ty, (x + bounds.x + bounds.width), ty))
			{
				y += yMove;	
				collided = false;
			}
			else
				collided = true;
		}
		else if(yMove > 0)//down
		{	
			float ty = (y + yMove + bounds.y + bounds.height);
			
			if(!collisionWithTile((x + bounds.x), ty, (x + bounds.x + bounds.width), ty))
			{
				y += yMove;
				collided = false;
			}
			else		
				collided = true;
		}
	}

	boolean holdLastPos;
	public void setFalling()
	{
		state = "FALLING";
		if(this instanceof Player)
			((Player)this).setFallingAnimation();
		
		if(!holdLastPos)
		{
			lastPosX = resolveToTile().x;
			lastPosY = resolveToTile().y - 20;

			lastLayer = layer;
			
			if(direction == 7 || direction == 0 || direction == 1)
			{
				setRenderBelowTile(true);
			}
				
			holdLastPos = true;

		}
		
		fallSpeedG = 10;
		fallSpeedY = yMove;
		fallSpeedX = xMove*2;
		
		if(handler.getLevel().getTile((int)lastPosX/Tile.TILE_WIDTH, (int)(lastPosY + 20)/Tile.TILE_HEIGHT, lastLayer).isNotSolidGround())
		{
			if(xMove < 0)
				lastPosX += Tile.TILE_WIDTH;
			else if(xMove > 0)
				lastPosX -= Tile.TILE_WIDTH;
			if(yMove < 0)
				lastPosY += Tile.TILE_HEIGHT;
			else if(yMove > 0)
				lastPosY -= Tile.TILE_HEIGHT;
		}
		
	}
	
	int fallDist;
	protected void falling()
	{	
		yMove = 0;
		xMove = 0;

		yMove = fallSpeedY + fallSpeedG;
		xMove = fallSpeedX;
			
		fallSpeedY-=fallSpeedY/20;
		fallSpeedX-=fallSpeedX/5;
		
		move();
		
		fallDist += Math.abs(fallSpeedG);

		if(fallDist >= 64)
		{
			layer--;
			fallDist = 0;	
		}
		
		if(layer < 0)
		{
			x = lastPosX;
			y = lastPosY;
			layer = lastLayer;
			lastPosX = lastPosY = fallDist = 0;	
			takeDamage(1);
			state = "CHASE";
			holdLastPos = false;
		}

	}
	
	int moved;
	float knkBackDist, knkBackSpeedX, knkBackSpeedY;
	float knkBackSpeed = 32;
	public void setKnockBack(float colliderX, float colliderY, float knockBackDist)
	{
		if(state != "FALLING")
			state = "KNOCKBACK";
		
		attackBounds = new Rectangle(0,0,0,0);

		knkBackSpeedX = (x-colliderX)/(Math.abs((x-colliderX)) + Math.abs((y-colliderY))) * knkBackSpeed;
		knkBackSpeedY = (y-colliderY)/(Math.abs((x-colliderX)) + Math.abs((y-colliderY))) * knkBackSpeed;

		this.knkBackDist = knockBackDist;
		moved = 0;
		
	}
	
	Rectangle temp;
	public void knockBack()
	{	
		xMove = knkBackSpeedX;
		yMove = knkBackSpeedY;
		move();
		moved += Math.abs(knkBackSpeedX) + Math.abs(knkBackSpeedY);

		if(moved > knkBackDist)
		{
			moved = 0;
			currSpeed = baseSpeed;

			if(this instanceof Player)
			{
				state = "CHASE";
				recovering = true;
			}
			else
				state = "RECOVERING";		
		}
		
	}
	
	CollisionMap cMap1, cMap2;
	int tileX1, tileY1, nwX1, nwY1;
	int tileX2, tileY2, nwX2, nwY2;
	
	boolean hasJumped;
	public boolean collisionWithTile(float x1, float y1, float x2, float y2) {
		if(!handler.getGame().getGameState().getLevelManager().isInDungeon())
			return false;
			
		tileX1 = (int)(x1/Tile.TILE_WIDTH);
		tileY1 = (int)(y1/Tile.TILE_HEIGHT);
		nwX1 = (int)(x1 - tileX1 * Tile.TILE_WIDTH)/2;
		nwY1 = (int)(y1 - tileY1 * Tile.TILE_HEIGHT)/2;
		cMap1 = handler.getLevel().getTile(tileX1, tileY1, layer).getcMap();

		tileX2 = (int)(x2/Tile.TILE_WIDTH);
		tileY2 = (int)(y2/Tile.TILE_HEIGHT);
		nwX2 = (int)(x2 - tileX2 * Tile.TILE_WIDTH)/2;
		nwY2 = (int)(y2 - tileY2 * Tile.TILE_HEIGHT)/2;
		cMap2 = handler.getLevel().getTile(tileX2, tileY2, layer).getcMap();

		if(nwX1 < 0 || nwX2 < 0 || nwY1 < 0 || nwY2 < 0)
		{
			if(state == "CHASE")
				setFalling();
			return false;
		}
		
		if(cMap1.getTargets()[nwX1][nwY1] == 1 || cMap2.getTargets()[nwX2][nwY2] == 1)
		{
			if(this instanceof ShadowPuppet)
				((ShadowPuppet)this).destroy();
			
			if(state == "FALLING")
			{
				return false;
			}
			else
				return true;
		}
		else if(cMap1.getTargets()[nwX1][nwY1] == 0 || cMap2.getTargets()[nwX2][nwY2] == 0)
		{
			if(state == "FALLING" && layer != lastLayer)
			{
				if(this instanceof Player)
				{
					holdLastPos = false;
					state = "CHASE";
					fallDist = 0;	
				}
				else
				{
					state = "CHASE";
					fallDist = 0;
				}
				
			}
			return false;//false means passable
		} 
		
		if(this instanceof ShadowPuppet)
				((ShadowPuppet)this).destroy();
		
		if(this instanceof WhipSegment)
			return false;
		
		if(this.canFly)
			return false;
		
		//so you can't kill yourself after you beat a boss
		if(handler.getGame().getGameState().getLevelManager().isInDungeon() && handler.getBaseCamp().getDungeonsCleared() > handler.getGame().getGameState().getLevelManager().getNumCurrentDungeon())
			if(handler.getGame().getPlayer().getCurrentFloor() == handler.getGame().getPlayer().getCurrentDungeon().getBossFloor())
				return true;

		
		if(!(this instanceof Player))
			return true;
		
		if(state == "CHASE" || state == "KNOCKBACK")
		{	
			if(yMove < 0)
			{
				tileY1 = (int)((y1 + bounds.height/3)/Tile.TILE_HEIGHT);
				nwY1 = (int)((y1 + bounds.height/3) - tileY1 * Tile.TILE_HEIGHT)/2;
				
				tileY2 = (int)((y2 + bounds.height/3)/Tile.TILE_HEIGHT);
				nwY2 = (int)((y2 + bounds.height/3) - tileY2 * Tile.TILE_HEIGHT)/2;
			}
			else if(yMove > 0)
			{
				tileY1 = (int)((y1 - bounds.height/3)/Tile.TILE_HEIGHT);
				nwY1 = (int)((y1 - bounds.height/3) - tileY1 * Tile.TILE_HEIGHT)/2;
				
				tileY2 = (int)((y2 - bounds.height/3)/Tile.TILE_HEIGHT);
				nwY2 = (int)((y2 - bounds.height/3) - tileY2 * Tile.TILE_HEIGHT)/2;
			}
			if(xMove < 0)
			{
				tileX1 = (int)((x1 + bounds.width/2)/Tile.TILE_WIDTH);
				nwX1 = (int)((x1 + bounds.width/2) - tileX1 * Tile.TILE_WIDTH)/2;
				
				tileX2 = (int)((x2 + bounds.width/2)/Tile.TILE_WIDTH);
				nwX2 = (int)((x2 + bounds.width/2) - tileX2 * Tile.TILE_WIDTH)/2;
			}
			else if(xMove > 0)
			{
				tileX1 = (int)((x1 - bounds.width/2)/Tile.TILE_WIDTH);
				nwX1 = (int)((x1 - bounds.width/2) - tileX1 * Tile.TILE_WIDTH)/2;
				
				tileX2 = (int)((x2 - bounds.width/2)/Tile.TILE_WIDTH);
				nwX2 = (int)((x2 - bounds.width/2) - tileX2 * Tile.TILE_WIDTH)/2;
			}
				
			cMap1 = handler.getLevel().getTile(tileX1, tileY1, layer).getcMap();
			cMap2 = handler.getLevel().getTile(tileX2, tileY2, layer).getcMap();
			
			if(cMap1.getTargets()[nwX1][nwY1] == 2 && cMap2.getTargets()[nwX2][nwY2] == 2)
			{
				setFalling();
			}
		}
		return false;
	}
	
	public void addHealth(int num)
	{
		setrVal(200);
		setgVal(150);
		setbVal(150);
		
		if(health + num <= myHealth)
			health+=num;
		else
			health = myHealth;
	}
	
	public int getStunDuration(){return stunDuration;}
	public void setStunDuration(int newStunDuration){stunDuration = newStunDuration;}
	public void setStunThreshold(int stunThreshold) {this.stunThreshold = stunThreshold;}
	public int getStunThreshold(){return stunThreshold;}
	public float getxMove() {return xMove;}
	public void setxMove(float xMove) {this.xMove = xMove;}
	public float getyMove() {return yMove;}
	public void setyMove(float yMove) {this.yMove = yMove;}
	public int getHealth() {return health;}
	public void setHealth(int health) {this.health = health;}
	public float getSpeed() {return currSpeed;}
	public void setSpeed(float speed) {this.currSpeed = speed;}	
	public boolean isStoppedByEnemy() {return collided;}
	public void setStoppedByEnemy(boolean stoppedByEnemy) {this.collided = stoppedByEnemy;}
	public int getDirection() {return direction;}
	public void setDirection(int direction) {this.direction = direction;}
	public float getXSlope(){return oldPosX - x;}
	public float getYSlope(){return oldPosY - y;}
	public float getxVel() {return xVel;}
	public void setxVel(float xVel) {this.xVel = xVel;}
	public float getyVel() {return yVel;}
	public void setyVel(float yVel) {this.yVel = yVel;}
	public float getLastPosX() {return lastPosX;}
	public void setLastPosX(float lastPosX) {this.lastPosX = lastPosX;}
	public float getLastPosY() {return lastPosY;}
	public void setLastPosY(float lastPosY) {this.lastPosY = lastPosY;}	
	public int getLastLayer() {return lastLayer;}
	public void setLastLayer(int lastLayer) {this.lastLayer = lastLayer;}
	public boolean isHoldLastPos() {return holdLastPos;}
	public void setHoldLastPos(boolean holdLastPos) {this.holdLastPos = holdLastPos;}
}
