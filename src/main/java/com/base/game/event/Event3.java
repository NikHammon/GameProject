package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.Ken;

public class Event3 extends Event
{
	public Event3(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(50, 1050, 2, 264);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 2 && handler.getGame().getGameState().getLevelManager().getBaseCamp().getState() == "MAINAREA")
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Cassiopia queen = new Cassiopia(handler, 230, 1070, 0);
	Ken man = new Ken(handler, 1830, 1560, 0);
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
			handler.getGame().geteManager().addEntity(queen);
			queen.setDoesNotMove(true);
			queen.setDirection(6);
			delay(500);
			break;
		case 1:
			if(player.getState() != "FORCEMOVE")
			{
				player.setForceMove("RIGHT");
				delay(500);
			}
			break;
		case 2:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				handler.getGame().getGameState().getEffects().displayDialog(33);
				delay(500);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				queen.setForceMove("RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN");
				player.setForceMove("RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN", "DOWN");
				delay(500);
			}
			break;
		case 4:
			if(player.getState() != "FORCEMOVE")
			{
				queen.setDirection(6);
				player.setDirection(6);
				handler.getGame().getGameState().getEffects().displayDialog(34);
				player.setState("IDLE");
				player.setCameraActive(false);
				delay(500);
			}
			break;
		case 5:	
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(60, 1420))
			{
				handler.getGame().getGameState().getEffects().displayDialog(35);
				delay(500);
			}
			break;
		case 6:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getLevelManager().getiInterface().setState("QUESTSELECTION");
				handler.getGame().getGameState().getLevelManager().getiInterface().setActive(true);
				handler.getGame().getGameState().getLevelManager().getiInterface().setDisableInput(true);
				delay(500);
			}
			break;
		case 7:
			handler.getGame().getGameState().getLevelManager().getiInterface().render(g);
			if(handler.getInput().a)
			{
				handler.getGame().getGameState().getLevelManager().getiInterface().setActive(false);
				handler.getGame().getGameState().getLevelManager().getiInterface().setDisableInput(false);
				handler.getGame().getGameState().getEffects().displayDialog(36);
				delay(500);
			}
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				
				player.setCameraActive(true);
				queen.setForceMove("RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT");
				player.setForceMove("RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT", "RIGHT");
				delay(500);
			}
			break;
		case 9:
			if(player.getState() != "FORCEMOVE")
			{
				queen.setDirection(6);
				player.setDirection(7);
				player.setState("IDLE");
				player.setCameraActive(false);
				handler.getGame().getGameState().getEffects().displayDialog(37);
				delay(500);
			}
			break;
		case 10:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				queen.setDirection(0);
				player.setDirection(1);
				handler.getGame().getGameState().getEffects().displayDialog(38);
				delay(500);
			}
			break;
		case 11:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(500, 1680))
			{
				queen.setDirection(4);
				player.setDirection(5);
				handler.getGame().getGameState().getEffects().displayDialog(39);
				delay(500);
			}
			break;
		case 12:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().displayDialog(40);
				delay(500);
			}
			break;
		case 13:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				queen.setDirection(4);
				player.setDirection(1);
				handler.getGame().getGameState().getEffects().displayDialog(41);
				delay(500);
			}
			break;
		case 14:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().geteManager().addEntity(man);
				man.setDoesNotMove(true);
				man.setForceMove("LEFT", "LEFT", "LEFT", "LEFT");
				delay(500);
			}
			break;
		case 15:
			if(man.getState() != "FORCEMOVE")
			{
				man.setState("IDLE");
				queen.setDirection(2);
				player.setDirection(2);
				handler.getGame().getGameState().getEffects().displayDialog(42);

				delay(500);
			}
			break;
		case 16:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setDirection(1);
				queen.setDirection(4);
				handler.getGame().getGameState().getEffects().displayDialog(43);
				delay(500);
			}
			break;
		case 17:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setCameraActive(true);
				player.setForceMove("LEFT", "LEFT", "LEFT", "DOWN", "DOWN", "DOWN");
				handler.getGame().getGameState().getEffects().fade(1);
				delay(10000);	
			}
			break;
		case 18:
			player.setState("CHASE");
			operation = 0;
			eManager.removeEntity(man);
			eManager.removeEntity(queen);
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(3);
			handler.getBaseCamp().setDungeonsUnlocked(1);
			handler.getGame().getGameState().getLevelManager().getWorldMap().setPermSelector(0);
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("DUNGEONSELECT");
			handler.getGame().getPlayer().setPaused(false);
			
			running = false;
			break;
		}
	}
			
}
