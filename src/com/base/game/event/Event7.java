package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.Artifact;
import com.base.game.entity.eventEntity.Gold;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Guard;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.tiles.Tile;

public class Event7 extends Event
{
	public Event7(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0,0,0,0);
	}

	@Override
	public boolean meetsRequirements(){return false;}
	
	Drace king = new Drace(handler, 680, 900, 0);
	Cassiopia queen = new Cassiopia(handler, 870, 920, 0);
	Sebastian sebastian = new Sebastian(handler, 710, 940, 2);
	Artifact artifact = new Artifact(handler, 790, 930, 2);
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
			player.setCameraActive(true);
			
			handler.getGame().geteManager().addEntity(queen);
			handler.getGame().geteManager().addEntity(king);
			handler.getGame().geteManager().addEntity(sebastian);

			queen.setDoesNotMove(true);
			king.setDoesNotMove(true);
			sebastian.setDoesNotMove(true);
			
			player.setDirection(0);
			king.setDirection(2);
			sebastian.setDirection(2);
			queen.setDirection(6);

			delay(500);
			break;
		case 1:
			handler.getGame().getGameState().getEffects().displayDialog(61);
			delay(500);
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setForceMove("UP");
				delay(500);
			}
			break;
		case 3:
			if(player.getState() != "FORCEMOVE")
			{
				eManager.addEntity(artifact);
				player.setForceMove("DOWN");
				
				delay(500);
			}
			break;
		case 4:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				player.setDirection(0);
				handler.getGame().getGameState().getEffects().displayDialog(62);
				delay(500);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				sebastian.setForceMove("RIGHT");
				delay(500);
			}
			break;
		case 6:
			if(sebastian.getState() != "FORCEMOVE")
			{
				handler.getGame().getGameState().getEffects().displayDialog(63);
				delay(500);
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				sebastian.setForceMove("LEFT");
				delay(500);
			}
			break;
		case 8:
			if(sebastian.getState() != "FORCEMOVE")
			{
				sebastian.setDirection(2);
				handler.getGame().getGameState().getEffects().displayDialog(64);
				delay(500);
			}
			break;
		case 9:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				queen.setForceMove("LEFT");
				delay(500);
			}
			break;
		case 10:
			if(queen.getState() != "FORCEMOVE")
			{
				eManager.removeEntity(artifact);
				queen.setForceMove("RIGHT");
				delay(500);
			}
			break;
		case 11:
			if(queen.getState() != "FORCEMOVE")
			{
				queen.setDirection(6);
				handler.getGame().getGameState().getEffects().displayDialog(65);
				delay(500);
			}
			break;
		case 12:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				delay(500);
			}
			break;
		case 13:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				handler.getGame().getGameState().getEffects().fade(0);
				
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("BEDROOM");
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setNPCs();
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setBarriers();
				handler.getGame().getPlayer().setX(252);
				handler.getGame().getPlayer().setY(244);
				player.setState("CHASE");
				operation = 0;
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setQuestTracker(0);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().getqBoard().generateQuests();
				running = false;		
			}
			break;
		}
		
	}
}
