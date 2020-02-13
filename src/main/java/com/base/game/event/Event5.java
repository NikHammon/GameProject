package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Ken;
import com.base.game.entity.eventEntity.NPC.Sebastian;

public class Event5 extends Event
{
	public Event5(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(570, 1744, 76, 52);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 5 && handler.getGame().getGameState().getLevelManager().getBaseCamp().getState() == "MAINAREA")
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Sebastian sebastian = new Sebastian(handler, 460, 1820, 0);
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
			player.setDirection(5);
			eManager.addEntity(sebastian);
			sebastian.setDirection(1);
			sebastian.setDoesNotMove(true);
			delay(500);
			break;
		case 1:
			if(handler.getCamera().scrawl(sebastian.getX() - handler.getGame().getWidth() / 2 + sebastian.getWidth() / 2, sebastian.getY() - handler.getGame().getHeight() / 2 + sebastian.getHeight() / 2))
			{
				handler.getGame().getGameState().getEffects().displayDialog(55);
				delay(500);
			}
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				operation = 0;
				player.setState("CHASE");
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(6);
				running = false;
			}
			break;
		}
	}
	
}
