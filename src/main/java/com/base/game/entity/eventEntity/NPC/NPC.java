package com.base.game.entity.eventEntity.NPC;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.DialogBox;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Player;
import com.base.game.entity.eventEntity.EventEntity;
import com.base.game.entity.monsters.Monster;

public class NPC extends EventEntity
{
	protected BufferedImage[] stationary;
	protected Animation lft;
	protected Animation rgt;	
	protected Animation up;
	protected Animation dwn;
	
	protected int scriptNum;
	protected boolean active;
	protected boolean doesNotMove;
 	
	public NPC(Handler handler, float x, float y, int layer, int width, int height) 
	{
		super(handler, x, y, layer, width, height);
		direction = 2;
		
		updateEventSpace();
		
		baseSpeed = currSpeed = 3;
	}

	protected Player player;
	
	@Override
	public void update() 
	{
		updateEventSpace();
		
		if(state == "FORCEMOVE")
			forceMove();
		
		setCurrentAnimation();
		if(currentAnimation != null)
			currentAnimation.update();
		
		checkPlayerResponse();
		
		if(!on && !doesNotMove)
		{
			if(active)
			{		
				timer+= System.currentTimeMillis()-lastTime;
				if(timer > 100000)
				{
					randomMove();
					active = false;
				}	
			}
			else
			{
				timer = 0;
				lastTime = System.currentTimeMillis();
				active = true;
			}
		}
	}
	
	protected int moveProb=4;
	protected boolean moveVert, moveHr;
	private void randomMove()
	{		
		if(ThreadLocalRandom.current().nextInt(moveProb) == 0 && moveVert)
		{
			moveVert = false;
			setForceMove("UP");
		}
		else if(ThreadLocalRandom.current().nextInt(moveProb)==1 && !moveVert)
		{
			moveVert = true;
			setForceMove("DOWN");
		}
		else if(ThreadLocalRandom.current().nextInt(moveProb)==2 && moveHr)
		{
			moveHr = false;
			setForceMove("RIGHT");
		}
		else if(ThreadLocalRandom.current().nextInt(moveProb)==3 && !moveHr)
		{
			moveHr = true;
			setForceMove("LEFT");
		}
	
	}

	public void checkPlayerResponse()
	{

		player = handler.getGame().getPlayer();
		
		if(on)
		{
			xMove = 0;
			yMove = 0;
			state = "";
			if(player.getX() < x && player.getY() < y + bounds.height + 30 && player.getY() > y - 30 && player.getDirection() == RIGHT)
			{
				direction = LEFT;
				handler.getGame().getGameState().getEffects().displayDialog(scriptNum);
				player.setState("IDLE");
			}
			else if(player.getX() > x && player.getY() < y + bounds.height + 30 && player.getY() > y - 30 && player.getDirection() == LEFT)
			{
				direction = RIGHT;
				handler.getGame().getGameState().getEffects().displayDialog(scriptNum);
				player.setState("IDLE");
			}
			else if(player.getY() < y && player.getDirection() == DOWN)
			{
				direction = UP;
				handler.getGame().getGameState().getEffects().displayDialog(scriptNum);
				player.setState("IDLE");
			}
			else if(player.getDirection() == UP)
			{
				direction = DOWN;
				handler.getGame().getGameState().getEffects().displayDialog(scriptNum);
			}
			
			if(handler.getGame().getGameState().getEffects().getdBox().isComplete())
			{
				on = false;
				player.setState("CHASE");
				
				if(scriptNum == 131)
				{
					handler.getBaseCamp().setDungeonsUnlocked(7);
					scriptNum = 132;
				}
			}
			
			
		}
	}

	public void updateEventSpace()
	{
		eventSpace = getCollisionBounds(0,0);
		eventSpace.x -= 40;
		eventSpace.y -= 40;
		eventSpace.width += 80;
		eventSpace.height += 80;
	}
	
	@Override
	public void render(Graphics g) 
	{
		super.render(g);
		
		if(getCurrentAnimation() != null)		
			g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		else 
			g.drawImage(stationary[direction/2],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		
		if(expressionAnimation != null)			
			renderExpression(g);
	}
	
	Animation expressionAnimation;
	int expressionOffsetX, expressionOffsetY;
	public void renderExpression(Graphics g)
	{
		if(expressionAnimation.isComplete())
			expressionAnimation = null;
		else
		{
			g.drawImage(expressionAnimation.getCurrentFrame(), (int) (x + expressionOffsetX- handler.getCamera().getxOffset()), (int) (y + expressionOffsetY - handler.getCamera().getyOffset()), expressionAnimation.getCurrentFrame().getWidth() * 2, expressionAnimation.getCurrentFrame().getHeight() * 2, null);
			expressionAnimation.update();
		}
	}
	public void setCurrentAnimation()
	{		
		if(yMove > 0)
		{
			currentAnimation = dwn;
			direction = DOWN;
		}
		else if(yMove < 0)
		{
			currentAnimation =  up;
			direction = UP;
		}
		else if(xMove < 0)
		{
			currentAnimation = lft;
			direction = LEFT;
		}
		else if(xMove > 0)
		{
			currentAnimation = rgt;
			direction = RIGHT;
		}
		else if(stationary != null)
			currentAnimation = null;

	}

	public boolean isDoesNotMove() {
		return doesNotMove;
	}

	public void setDoesNotMove(boolean doesNotMove) {
		this.doesNotMove = doesNotMove;
	}

	public Animation getExpressionAnimation() {
		return expressionAnimation;
	}

	public void setExpressionAnimation(Animation expressionAnimation, int expressionOffsetX, int expressionOffsetY) 
	{
		this.expressionAnimation = expressionAnimation;
		this.expressionOffsetX = expressionOffsetX;
		this.expressionOffsetY = expressionOffsetY;
	}

	public int getScriptNum() {
		return scriptNum;
	}

	public void setScriptNum(int scriptNum) {
		this.scriptNum = scriptNum;
	}

	
}
