package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.Entity;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Fineas;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.eventEntity.NPC.Serii;

public class Event9 extends Event
{
	public Event9(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(570, 1720, 76, 52);
	}

	@Override
	public boolean meetsRequirements()
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 8 && handler.getGame().getGameState().getLevelManager().getBaseCamp().getState() == "MAINAREA")
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Sebastian sebastian = new Sebastian(handler, 460, 1820, 0);
	Serii serii = new Serii(handler, 1250, 1880, 0);
	Fineas fineas = new Fineas(handler, 1230, 1930, 0);
	Cassiopia cassiopia = new Cassiopia(handler, 1150, 1810, 0);
	Drace drace = new Drace(handler, 1070, 1910, 0);
	@Override
	public void run(Graphics g) 
	{
		switch(operation)
		{
		case -1:
			runDelay();
			break;	
		case 0:		
			player.setState("IDLE");			
			player.setDirection(5);
			eManager.addEntity(sebastian);
			sebastian.setDirection(1);
			sebastian.setDoesNotMove(true);
			delay(500);
			break;
		case 1:
			player.setCameraActive(false);
			if(handler.getCamera().scrawl(sebastian.getX() - handler.getGame().getWidth() / 2 + sebastian.getWidth() / 2, sebastian.getY() - handler.getGame().getHeight() / 2 + sebastian.getHeight() / 2))
			{
				handler.getGame().getGameState().getEffects().displayDialog(66);
				delay(0);
			}
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				eManager.addEntity(fineas);
				eManager.addEntity(serii);
				eManager.addEntity(cassiopia);
				eManager.addEntity(drace);
				
				fineas.setDoesNotMove(true);
				serii.setDoesNotMove(true);
				cassiopia.setDoesNotMove(true);
				drace.setDoesNotMove(true);
				
				fineas.setDirection(6);
				serii.setDirection(6);
				cassiopia.setDirection(4);
				drace.setDirection(2);
				
				player.setCameraActive(true);
				sebastian.setForceMove("RIGHT", "RIGHT");
				delay(0);
			}
			break;
		case 3:
			if(sebastian.getState() != "FORCEMOVE")
			{
				sebastian.setForceMove("RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT");
				player.setForceMove("DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT");
				delay(0);
			}
			break;
		case 4:
			if(player.getState() != "FORCEMOVE")
			{
				sebastian.setDirection(3);
				player.setDirection(1);
				player.setState("IDLE");
				handler.getGame().getGameState().getEffects().displayDialog(67);
				delay(0);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().displayDialog(76);
				delay(0);
			}
			break;
		case 6:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				serii.setDirection(5);
				serii.setExpressionAnimation(shocked, -5, -30);
				handler.getGame().getGameState().getEffects().displayDialog(68);
				delay(0);
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				serii.setDirection(4);
				handler.getGame().getGameState().getEffects().displayDialog(77);
				delay(0);
			}
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				fineas.setDirection(0);
				handler.getGame().getGameState().getEffects().displayDialog(78);
				delay(0);
			}
			break;
		case 9:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				fineas.setDirection(6);
				handler.getGame().getGameState().getEffects().displayDialog(79);
				delay(0);
			}
			break;
		case 10:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				delay(500);
			}
			break;
		case 11:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(drace);
				eManager.removeEntity(cassiopia);
				eManager.removeEntity(fineas);
				sebastian.setX(440);
				sebastian.setY(1820);
				sebastian.setDirection(1);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(500);
			}
			break;
		case 12:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				serii.setDirection(5);
				serii.setExpressionAnimation(angry, 35, -5);
				handler.getGame().getGameState().getEffects().displayDialog(69);
				delay(500);
			}
			break;
		case 13:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setState("CHASE");
				operation = 0;
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(10);
				handler.getBaseCamp().setDungeonsUnlocked(3);
				running = false;
			}
			break;
		}
	}
}
