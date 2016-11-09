package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Sebastian;

public class Event11 extends Event
{
	public Event11(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(570, 1744, 76, 52);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 12 && handler.getGame().getGameState().getLevelManager().getBaseCamp().getState() == "MAINAREA")
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Drace drace = new Drace(handler, 560, 1820, 0);
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
			eManager.addEntity(drace);
			drace.setDirection(0);
			drace.setDoesNotMove(true);
			delay(500);
			break;
		case 1:
			if(handler.getCamera().scrawl(drace.getX() - handler.getGame().getWidth() / 2 + drace.getWidth() / 2, drace.getY() - handler.getGame().getHeight() / 2 + drace.getHeight() / 2))
			{
				handler.getGame().getGameState().getEffects().displayDialog(88);
				delay(500);
			}
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				drace.setForceMove("RIGHT", "RIGHT", "RIGHT", "RIGHT", "UP", "UP", "UP", "UP", "UP");
				delay(500);
			}
			break;
		case 3:
			if(drace.getState() != "FORCEMOVE")
			{
				eManager.removeEntity(drace);
				delay(500);
			}
			break;
		case 4:
			if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				operation = 0;
				player.setState("CHASE");
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(13);
				handler.getBaseCamp().setDungeonsUnlocked(4);
				running = false;
			}
			break;
		}
	}
}
