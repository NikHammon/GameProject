package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Rubel;
import com.base.game.entity.eventEntity.NPC.Zaria;

public class Event17 extends Event
{
	public Event17(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(570, 1744, 76, 52);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 21 && handler.getGame().getGameState().getLevelManager().getBaseCamp().getState() == "MAINAREA")
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Zaria zaria = new Zaria(handler, 600, 1820, 0);
	Drace drace = new Drace(handler, 520, 1820, 0);
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
			player.setCameraActive(false);
			eManager.addEntity(zaria);
			eManager.addEntity(drace);
			zaria.setDoesNotMove(true);
			drace.setDoesNotMove(true);
			zaria.setDirection(6);
			drace.setDirection(2);
			delay(500);
			break;
		case 1:
			if(handler.getCamera().scrawl(560 - handler.getGame().getWidth() / 2, 1820 - handler.getGame().getHeight() / 2))
			{
				handler.getGame().getGameState().getEffects().displayDialog(122);
				delay(500);
			}
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				zaria.setDirection(0);
				handler.getGame().getGameState().getEffects().displayDialog(123);
				delay(500);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				drace.setDirection(0);
				handler.getGame().getGameState().getEffects().displayDialog(124);
				delay(500);
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				zaria.setDirection(6);
				handler.getGame().getGameState().getEffects().displayDialog(125);
				delay(500);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				drace.setDirection(2);
				handler.getGame().getGameState().getEffects().displayDialog(126);
				delay(500);
			}
			break;
		case 6:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				zaria.setForceMove("RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT");
				delay(500);
			}
			break;
		case 7:
			if(zaria.getState() != "FORCEMOVE")
			{
				eManager.removeEntity(zaria);
				drace.setDirection(0);
				handler.getGame().getGameState().getEffects().displayDialog(127);
				delay(500);
			}
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				drace.setForceMove("RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT");
				delay(500);
			}
			break;
		case 9:
			if(drace.getState() != "FORCEMOVE" && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				eManager.removeEntity(drace);
				handler.getGame().getGameState().getEffects().displayDialog(128);
				delay(500);
			}
			break;
		case 10:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				operation = 0;
				player.setState("CHASE");
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(22);
				running = false;
			}
			break;
		}
	}
}
