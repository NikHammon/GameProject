package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Rubel;
import com.base.game.entity.eventEntity.NPC.Sebastian;

public class Event15 extends Event
{
	public Event15(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(570, 1744, 76, 52);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 18 && handler.getGame().getGameState().getLevelManager().getBaseCamp().getState() == "MAINAREA")
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Rubel rubel = new Rubel(handler, 730, 1480, 0);
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
			eManager.addEntity(rubel);
			rubel.setDoesNotMove(true);
			rubel.setForceMove("DOWN", "DOWN", "DOWN", "LEFT");
			delay(500);
			break;
		case 1:
			if(rubel.getState() != "FORCEMOVE")
			{
				player.setDirection(2);
				if(handler.getCamera().scrawl(rubel.getX() - handler.getGame().getWidth() / 2 + rubel.getWidth() / 2, rubel.getY() - handler.getGame().getHeight() / 2 + rubel.getHeight() / 2))
				{
					handler.getGame().getGameState().getEffects().displayDialog(114);
					delay(500);
				}
			}
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				rubel.setExpressionAnimation(embarassed, 35, 10);
				handler.getGame().getGameState().getEffects().displayDialog(115);
				delay(500);
				
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				rubel.setForceMove("LEFT");
				delay(500);
			}
			break;
		case 4:
			if(rubel.getState() != "FORCEMOVE")
			{
				handler.getGame().getGameState().getEffects().displayDialog(116);
				delay(500);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				rubel.setForceMove("RIGHT");
				delay(500);
			}
			break;
		case 6:
			if(rubel.getState() != "FORCEMOVE")
			{
				handler.getGame().getGameState().getEffects().displayDialog(117);
				rubel.setDirection(6);
				delay(500);
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				operation = 0;
				player.setState("CHASE");
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(19);
				handler.getBaseCamp().setDungeonsUnlocked(6);
				running = false;
			}
			break;
		}
	}
}
