package com.base.game.entity.eventEntity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;
import com.base.game.entity.eventEntity.NPC.NPC;
import com.base.game.levels.Quest;

public class QuestEntity extends NPC
{
	private Quest quest;
	private int entityNum;
	
	public QuestEntity(Handler handler, float x, float y, int layer, Quest quest)
	{
		super(handler, x, y, layer, 70, 70);
		this.quest = quest;
		
		entityNum = rand.nextInt(Assets.questNPCsMaleDwn.length);
		
		scriptNum = 8;
	}

	@Override
	public void render(Graphics g) 
	{
		if(quest.isClientMale())
		{
			if(direction == 0)
				g.drawImage(Assets.questNPCsMaleUp[entityNum],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			else if(direction == 2)
				g.drawImage(Assets.questNPCsMaleRgt[entityNum],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			else if(direction == 4)
				g.drawImage(Assets.questNPCsMaleDwn[entityNum],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			else
				g.drawImage(Assets.questNPCsMaleLft[entityNum],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);		
		}
		else
		{
			if(direction == 0)
				g.drawImage(Assets.questNPCsFemaleUp[entityNum],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			else if(direction == 2)
				g.drawImage(Assets.questNPCsFemaleRgt[entityNum],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			else if(direction == 4)
				g.drawImage(Assets.questNPCsFemaleDwn[entityNum],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			else
				g.drawImage(Assets.questNPCsFemaleLft[entityNum],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);		
		}
	}
	
	public void checkPlayerResponse()
	{
		xMove = 0;
		yMove = 0;
		player = handler.getLevel().geteManager().getPlayer();
		
		if(state == "ACTIVE")
		{
			if(handler.getGame().getGameState().getEffects().getdBox().isComplete())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				state = "REWARD";
			}
		}
		else if(state == "REWARD")
		{
			state = "ESCAPE";
		}
		else if(state == "ESCAPE")
		{
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				handler.getGame().getGameState().getEffects().fade(0);
				state = "ESCAPED";
				doNotRender = true;
			}
		}
		else if(state == "ESCAPED")
		{
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().remove(quest);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().addQuest();
				handler.getGame().geteManager().addEntity(new Portal(handler, x, y, 2));
				handler.getGame().geteManager().removeEntity(this);
			}
		}

		else if(on)
		{
			
			state = "ACTIVE";
			
			if(player.getX() < x && player.getY() < y + bounds.height + 30 && player.getY() > y - 30 && player.getDirection() == RIGHT)
				direction = LEFT;
			else if(player.getX() > x && player.getY() < y + bounds.height + 30 && player.getY() > y - 30 && player.getDirection() == LEFT)
				direction = RIGHT;
			else if(player.getY() < y && player.getDirection() == DOWN)
				direction = UP;
			else if(player.getDirection() == UP)
				direction = DOWN;
			
			handler.getGame().getGameState().getEffects().getdBox().setSpeaker(quest.getClient());
			handler.getGame().getGameState().getEffects().displayDialog(scriptNum);
			doesNotMove = true;
			on = false;
		}
		
		
	}
	private void randomMove()
	{		
		if(!doesNotMove)
		{
			if(rand.nextInt(moveProb) == 0 && moveVert)
			{
				moveVert = false;
				setDirection(0);
			}
			else if(rand.nextInt(moveProb)==1 && !moveVert)
			{
				moveVert = true;
				setDirection(4);
			}
			else if(rand.nextInt(moveProb)==2 && moveHr)
			{
				moveHr = false;
				setDirection(2);
			}
			else if(rand.nextInt(moveProb)==3 && !moveHr)
			{
				moveHr = true;
				setDirection(6);
			}
		}
	
	}

}
