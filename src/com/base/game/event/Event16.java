package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Ken;
import com.base.game.entity.eventEntity.NPC.Shadow;

public class Event16 extends Event
{
	public Event16(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(252, 244, 200, 200);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 20 && handler.getGame().getGameState().getLevelManager().getBaseCamp().getState() == "BEDROOM")
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Shadow shadow = new Shadow(handler, 252, 350, 0);
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
			handler.getCamera().setxOffset(0);
			handler.getCamera().setyOffset(0);
			player.setDirection(4);
			
			shadow.setDirection(0);
			shadow.setDoesNotMove(true);
			shadow.setDoNotUpdate(true);
			shadow.shadowIn.reset();
			shadow.setCurrentAnimation(shadow.shadowIn);

			delay(500);
			break;
		case 1:
			if(handler.getCamera().scrawl(0, shadow.getY() - handler.getGame().getHeight() / 2 + shadow.getHeight() / 2))
			{
				eManager.addEntity(shadow);
				delay(500);
				
			}
			break;
		case 2:
			if(shadow.shadowIn.isComplete())
			{
				shadow.setDoNotUpdate(false);
				handler.getGame().getGameState().getEffects().displayDialog(129);
				delay(500);
			}
			else
				shadow.shadowIn.update();
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				shadow.setCurrentAnimation(shadow.shadowOut);
				shadow.shadowOut.reset();
				handler.getGame().getGameState().getEffects().displayDialog(130);
				shadow.setDoNotUpdate(true);
				delay(500);
			}
			break;
		case 4:
			if(shadow.shadowOut.isComplete())
			{
				eManager.removeEntity(shadow);
				delay(500);
			}
			else
				shadow.shadowOut.update();
			break;
		case 5:
			if(handler.getCamera().scrawl(0, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				operation = 0;
				player.setState("CHASE");
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(21);
				running = false;
			}
			break;
		}
	}
}
