package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Guard;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.tiles.Tile;

public class Event4 extends Event
{
	public Event4(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0,0,0,0);
	}

	@Override
	public boolean meetsRequirements(){return false;}
	
	Drace king = new Drace(handler, 700, 900, 0);
	Cassiopia queen = new Cassiopia(handler, 850, 920, 0);
	Sebastian sebastian = new Sebastian(handler, 730, 1470, 0);
	@Override
	public void run(Graphics g) 
	{

		switch(operation)
		{
		case -1:
			runDelay();
			break;	
		case 0:
			player.setCameraActive(false);
			player.setState("IDLE");

			handler.getCamera().setxOffset(350);
			handler.getCamera().setyOffset(670);
			
			handler.getGame().geteManager().addEntity(queen);
			handler.getGame().geteManager().addEntity(king);
			handler.getGame().geteManager().addEntity(sebastian);

			queen.setDoesNotMove(true);
			king.setDoesNotMove(true);
			sebastian.setDoesNotMove(true);

			delay(5000);
			break;
		case 1:
			handler.getGame().getGameState().getEffects().displayDialog(44);
			delay(500);
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				king.setDirection(4);
				queen.setDirection(4);
				player.setForceMove("UP", "UP", "UP", "UP", "UP", "UP");
				sebastian.setForceMove("UP", "UP", "UP", "UP", "UP", "UP");
				delay(5000);
			}
			break;
		case 3:
			if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				if(player.getState() != "FORCEMOVE")
				{
					player.setState("IDLE");
					handler.getGame().getGameState().getEffects().displayDialog(45);
					delay(500);
				}
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				sebastian.setDirection(1);
				handler.getGame().getGameState().getEffects().displayDialog(51);
				delay(500);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				king.setDirection(2);
				handler.getGame().getGameState().getEffects().displayDialog(52);
				delay(500);
			}
			break;
		case 6:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				king.setDirection(4);
				handler.getGame().getGameState().getEffects().displayDialog(53);
				delay(500);
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				king.setDirection(2);
				handler.getGame().getGameState().getEffects().displayDialog(54);
				delay(500);
			}
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				queen.setForceMove("UP", "LEFT", "UP");
				handler.getGame().getGameState().getEffects().fade(1);
				delay(500);
			}
			break;
		case 9:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(king);
				eManager.removeEntity(queen);
				eManager.removeEntity(sebastian);
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("BEDROOM");
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setNPCs();
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setBarriers();
				handler.getGame().getPlayer().setX(252);
				handler.getGame().getPlayer().setY(244);
				player.setState("CHASE");
				operation = 0;
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(5);
				running = false;
				
			}
			break;
		}
	}
}
