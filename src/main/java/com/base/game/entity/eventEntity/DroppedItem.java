package com.base.game.entity.eventEntity;

import com.base.game.Handler;

public abstract class DroppedItem extends EventEntity
{
	protected float speed;
	protected float distance, maxDist;
	protected float xMove, yMove;
	
	public DroppedItem(Handler handler, float x, float y, int layer, int width, int height, int direction) {
		super(handler, x, y, layer, width, height);
		this.direction = direction;
		state = "SPAWNING";
		speed = 10;
		
		maxDist = rand.nextInt(120) + 90;
	}
	

	public void spawn()
	{
		xMove = 0;
		yMove = 0;
		
		if(direction == 0)
			yMove = -speed;
		else if(direction == 1)
		{
			xMove = (float) (speed / Math.sqrt(2));
			yMove = (float) (-speed / Math.sqrt(2));
		}
		else if(direction == 2)
			xMove = speed;
		else if(direction == 3)
		{
			xMove = (float) (speed / Math.sqrt(2));
			yMove = (float) (speed / Math.sqrt(2));
		}
		else if(direction == 4)
			yMove = speed;
		else if(direction == 5)
		{
			xMove = (float) (-speed / Math.sqrt(2));
			yMove = (float) (speed / Math.sqrt(2));
		}
		else if(direction == 6)
			xMove = -speed;
		else if(direction == 7)
		{
			xMove = (float) (-speed / Math.sqrt(2));
			yMove = (float) (-speed / Math.sqrt(2));
		}
		
		if(getCollidedWith(xMove, 0f) == null)
			moveX();

		if(getCollidedWith(0f, yMove) == null )
			moveY();
		
		distance += Math.abs(xMove) + Math.abs(yMove);
		
		if(distance > maxDist)
		{
			state = "";
		}

	}
	
	public void moveX()
	{	
		oldPosX = x;
		if(xMove > 0)//right
		{
			float tx = (x + xMove + bounds.x + bounds.width);
			
			if(!collisionWithTile(tx, (y + bounds.y), tx, (y + bounds.y + bounds.height)))
			{
				x += xMove;
			}

		}
		else if(xMove < 0)//left
		{
			float tx = (x + xMove + bounds.x);
			
			if(!collisionWithTile(tx, (y + bounds.y), tx, (y + bounds.y + bounds.height)))
			{
				x += xMove;
			}

		}
	}
	
	public void moveY()
	{
		oldPosY = y;
		if(yMove < 0)//up
		{			
			float ty = (y + yMove + bounds.y);
			
			if(!collisionWithTile((x + bounds.x), ty, (x + bounds.x + bounds.width), ty))
			{
				y += yMove;	
			}

		}
		else if(yMove > 0)//down
		{	
			float ty = (y + yMove + bounds.y + bounds.height);
			
			if(!collisionWithTile((x + bounds.x), ty, (x + bounds.x + bounds.width), ty))
			{
				y += yMove;
			}

		}
	}

}
