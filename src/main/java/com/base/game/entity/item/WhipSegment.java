package com.base.game.entity.item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.staticEntity.StaticEntity;

public class WhipSegment extends Monster
{
	private int pos;
	private float playerPosX;
	private float playerPosY;
	private int myDirection;
	private boolean isFinished;
	private Animation currentHeadAnimation;
	
	private Animation whipHeadDwnRgt, whipHeadDwnLft, whipHeadUpLft, whipHeadUpRgt;
	private Animation whipHeadDwnRgt2, whipHeadDwnLft2, whipHeadUpLft2, whipHeadUpRgt2;

	
	public WhipSegment(Handler handler, float x, float y, int layer, int pos, int direction)
	{
		super(handler, x, y, layer, 48, 48, 0);
		this.pos = pos;
		myDirection = direction;
		damage = 1;
		
		if(myDirection == 0)
		{
			this.y -= 20;
			this.x += 10;
			renderOrder = 1;
		}
		else if(myDirection == 1)
		{
			this.y -= 10;
			this.x += 45;
		}
		else if(myDirection == 2)
		{
			this.x += 10;
		}
		else 
		{
			this.y -= 15;
			this.x -= 65;
		}
		playerPosX = this.x;
		playerPosY = this.y;
		
//		attackBounds.x = (int) this.x;
//		attackBounds.y = (int) this.y;
		attackBounds.width = 20;
		attackBounds.height = 20;
		
		//setBounds(new Rectangle((int) this.x, (int) this.y, 20, 20));
		
		
		baseSpeed = 6;
		currSpeed = baseSpeed;
		health = 1;
		damage = 2;
		knockBack = 100;

		harmsOtherMonsters = true;
		
		whipHeadDwnRgt = new Animation(150, Assets.whipHeadDwnRgt, 0);
		whipHeadDwnLft = new Animation(150, Assets.whipHeadDwnLft, 0);
		whipHeadUpRgt = new Animation(150, Assets.whipHeadUpRgt, 0);
		whipHeadUpLft = new Animation(150, Assets.whipHeadUpLft, 0);
		
		whipHeadDwnRgt2 = new Animation(150, Assets.whipHeadDwnRgt2, 0);
		whipHeadDwnLft2 = new Animation(150, Assets.whipHeadDwnLft2, 0);
		whipHeadUpRgt2 = new Animation(150, Assets.whipHeadUpRgt2, 0);
		whipHeadUpLft2 = new Animation(150, Assets.whipHeadUpLft2, 0);
		
		state = "";
	}

	
	public void update()
	{	
	
	}
	
	public void updateSegment(float xPos, float yPos)
	{	
		if(myDirection == 0)
		{		
			moveTo(xPos, yPos + 10);

		}
		
		else if(myDirection == 1)
		{
			moveTo(xPos - 10, yPos);

		}
		else if(myDirection == 2)
		{	
			moveTo(xPos, yPos - 10);

		}
		else if(myDirection == 3)
		{
			moveTo(xPos + 10, yPos);

		}
		
		if(x + xMove < playerPosX && myDirection == 1)
			xMove = 0;
		else if(y + yMove < playerPosY && myDirection == 2)
			yMove = 0;
		else if(x + xMove > playerPosX && myDirection == 3)
			xMove = 0;
		else if(y + yMove > playerPosY && myDirection == 0)
			yMove = 0;
	
		if(xMove == 0 && yMove == 0)
			isFinished = true;
		else
			isFinished = false;
		
		move();
		attack();
	
	}

	public void updateTail()
	{
		moveTo(playerPosX, playerPosY);
		move();
		attack();
	}
	
	public void updateHead()
	{	

		if(myDirection == 0)
		{
			if(handler.getInput().right)
			{
				xMove = this.currSpeed/3;
				currentHeadAnimation = whipHeadUpRgt2;
			}
			else if(handler.getInput().left)
			{
				xMove = -this.currSpeed/3;
				currentHeadAnimation = whipHeadUpLft2;
			}
			else if(currentAnimation == null)
				currentHeadAnimation = whipHeadUpRgt2;
			
			yMove = -currSpeed;
		}
		
		else if(myDirection == 1)
		{
			if(handler.getInput().down)
			{
				yMove = this.currSpeed/3;
				currentHeadAnimation = whipHeadDwnRgt;
			}
			else if(handler.getInput().up)
			{
				yMove = -this.currSpeed/3;
				currentHeadAnimation = whipHeadUpRgt;
			}
			else if(currentAnimation == null)
				currentHeadAnimation = whipHeadUpRgt;
			
			xMove = currSpeed;
		}
		
		if(myDirection == 2)
		{
			if(handler.getInput().right)
			{
				xMove = this.currSpeed/3;
				currentHeadAnimation = whipHeadDwnRgt2;
			}
			else if(handler.getInput().left)
			{
				xMove = -this.currSpeed/3;
				currentHeadAnimation = whipHeadDwnLft2;
			}
			else if(currentAnimation == null)
				currentHeadAnimation = whipHeadDwnRgt2;
			
			yMove = currSpeed;
		}
		
		else if(myDirection == 3)
		{
			if(handler.getInput().down)
			{
				yMove = this.currSpeed/3;
				currentHeadAnimation = whipHeadDwnLft;
			}
			else if(handler.getInput().up)
			{
				yMove = -this.currSpeed/3;
				currentHeadAnimation = whipHeadUpLft;
			}
			else if(currentAnimation == null)
				currentHeadAnimation = whipHeadUpLft;
			
			xMove = -currSpeed;
		}

		//System.out.println(x + " " + y);
		move();
		attack();
		currentHeadAnimation.update();
		
	}
	boolean terminate;
	@Override
	public void attack() 
	{
		attackBounds = getCollisionBounds(0, 0);
		for(Entity e : handler.getGame().geteManager().getEntities())
		{
			if(attackBounds.intersects(e.getCollisionBounds(0, 0)))
			{
				if(e instanceof WhipSegment)
					continue;
				if(e instanceof StaticEntity)
				{
					handler.getGame().getPlayer().setGrappling(x, y);
					terminate = true;
				}
				else if(e instanceof Monster && ((Monster) e).getStatusCondition() != "PARALYZED")
				{
					Creature c = ((Creature)e);
					Utils.playSound("shock");
					c.takeDamage(damage);
					if(c.getHealth() > 0)
						c.setStatusCondition("PARALYZED");
					
				}
			}
		}
	}
	
	@Override
	public void render(Graphics g) 
	{
		if(pos == 0 && currentHeadAnimation != null)
			g.drawImage(currentHeadAnimation.getCurrentFrame(),(int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);
		else if(pos == 29)
			g.drawImage(Assets.whipTail[myDirection],(int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);
		else if(pos < 5 && myDirection % 2 == 0)
			g.drawImage(Assets.whipBodyFins[myDirection],(int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()),(width - pos*3), height, null);
		else if(myDirection % 2 == 0)
			g.drawImage(Assets.whipBody[myDirection],(int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()),(width - pos*3), height, null);
		else if(pos < 5)
			g.drawImage(Assets.whipBodyFins[myDirection],(int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()),width, (height - pos*3), null);
		else 
			g.drawImage(Assets.whipBody[myDirection],(int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()),width, (height - pos*3), null);
		//g.setColor(Color.red);
		//g.fillRect((int)(x + attackBounds.x - handler.getCamera().getxOffset()), (int)(y + attackBounds.y - handler.getCamera().getyOffset()), attackBounds.width, attackBounds.height);
	
	}


	public boolean isFinished() {
		return isFinished;
	}


	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}


	public boolean isTerminate() {
		return terminate;
	}


	public void setTerminate(boolean terminate) {
		this.terminate = terminate;
	}
	
	
}
