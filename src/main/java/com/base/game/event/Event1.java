package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.eventEntity.NPC.Ken;

public class Event1 extends Event {
	public Event1(Handler handler) {
		super(handler);
		eventSpace = new Rectangle(930, 480, 150, 150);
	}

	@Override
	public boolean meetsRequirements() {
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 0 && handler.getGame().getGameState().getLevelManager().getBaseCamp().getState() == "MAINAREA") {
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Ken man = new Ken(handler, 1070, 780, 0);
	@Override
	public void run(Graphics g) {
		switch(operation)
		{
		case -1:
			runDelay();
			break;	
		case 0:
			player.setState("IDLE");	
			
			player.playerRise.reset();
			player.setCurrentAnimation(player.playerRise);
			player.setDoNotUpdate(true);	
			player.setDoNotRenderShadow(true);
			handler.getCamera().setxOffset(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2);
			handler.getCamera().setyOffset(1340);
			handler.getGame().getGameState().getEffects().sunrise();

			delay(500);
			break;
		case 1:
			if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				if(handler.getGame().getGameState().getEffects().getSunriseAlpha() == 0)
				{
					
					delay(500);
				}
			}
			break;
		case 2:	
			if(player.playerRise.isComplete())
			{
				player.setDoNotRenderShadow(false);
				player.setDoNotUpdate(false);
				player.setX(player.getX() + 8);
				player.setY(player.getY() - 16);
				player.setDirection(5);
				player.playerRise.reset();
				delay(6000);
			}
			else
				player.playerRise.update();
			break;
		case 3:	
			player.setDirection(4);
			delay(500);
			break;
		case 4:	
			player.setDirection(3);
			delay(6000);
			break;
		case 5:	
			player.setDirection(4);
			eManager.addEntity(man);
			man.setForceMove("UP", "UP", "UP", "UP", "LEFT");
			delay(500);
			break;
		case 6:	
			player.setDirection(5);
			man.setDoesNotMove(true);
			delay(8000);
			break;
		case 7:	
			player.setDirection(4);	
			delay(500);
			break;
		case 8:	
			player.setDirection(3);
			delay(500);
			break;
		case 9:	
			if(man.getState() != "FORCEMOVE")
			{
				handler.getGame().getGameState().getEffects().displayDialog(3);
				delay(500);
			}
			break;
		case 10:	
			if(handler.getGame().getGameState().getEffects().getdBox().isComplete())
			{
				man.setForceMove("LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "DOWN", "DOWN", "DOWN", "DOWN");
				delay(10000);
			}
			break;
		case 11:	
			handler.getGame().getGameState().getEffects().displayDialog(9);
			delay(500);
			break;
		case 12:	
			if(man.getState() != "FORCEMOVE" && handler.getGame().getGameState().getEffects().getdBox().isComplete())
			{
				eManager.removeEntity(man);
				delay(500);
			}
			break;
		case 13:
			player.setState("CHASE");
			operation = 0;
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(1);
			running = false;
			break;
		}
		

		
	}

}
