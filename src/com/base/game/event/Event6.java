package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.Ken;

public class Event6 extends Event
{
	public Event6(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(850, 2620, 160, 150);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 6 && handler.getGame().getGameState().getLevelManager().getBaseCamp().getState() == "MAINAREA")
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Cassiopia queen = new Cassiopia(handler, 1000, 2280, 0);
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
			player.setDirection(0);
			handler.getGame().geteManager().addEntity(queen);
			queen.setDoesNotMove(true);
			queen.setForceMove("DOWN", "DOWN", "DOWN");
			delay(500);
			break;
		case 1:
			if(queen.getState() != "FORCEMOVE")
			{
				player.setDirection(1);
				handler.getGame().getGameState().getEffects().displayDialog(56);
				delay(500);
			}
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				queen.setForceMove("RIGHT");
				handler.getGame().getGameState().getEffects().displayDialog(57);
				delay(500);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{			
				handler.getGame().getGameState().getEffects().fade(1);
				delay(500);
			}
			break;
		case 4:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				player.setState("CHASE");
				operation = 0;
				handler.getBaseCamp().setDungeonsUnlocked(2);
				handler.getGame().getGameState().getLevelManager().getWorldMap().setPermSelector(1);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("DUNGEONSELECT");
				handler.getGame().getPlayer().setPaused(false);
				running = false;
			}
			break;
		}
	}
}
