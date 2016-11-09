package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.CrawfordNPC;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Fineas;
import com.base.game.entity.eventEntity.NPC.RiggsNPC;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.eventEntity.NPC.Serii;
import com.base.game.entity.monsters.Crawford;
import com.base.game.entity.monsters.Riggs;
import com.base.game.tiles.Tile;

public class Event10 extends Event
{
	public Event10(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0,0,0,0);
		num = 10;
	}

	@Override
	public boolean meetsRequirements(){return false;}

	Sebastian sebastian = new Sebastian(handler, 750, 2320, 0);
	Serii serii = new Serii(handler, 1000, 2360, 0);
	Fineas fineas = new Fineas(handler, 950, 2300, 0);
	Drace drace = new Drace(handler, 720, 2360, 0);
	CrawfordNPC crawford = new CrawfordNPC(handler, 820, 2620, 2);
	RiggsNPC riggs = new RiggsNPC(handler, 900, 2600, 2);
	@Override
	public void run(Graphics g) 
	{
		switch(operation)
		{
		case -1:
			runDelay();
			break;	
		case 0:	
			player.setCameraActive(true);
			player.setForceMove("UP", "UP");
			crawford.setForceMove("UP", "UP");
			riggs.setForceMove("UP", "UP");
			player.setDirection(0);
			handler.getGame().geteManager().addEntity(crawford);
			crawford.setDoesNotMove(true);
			crawford.setDirection(1);
			handler.getGame().geteManager().addEntity(riggs);
			riggs.setDoesNotMove(true);
			riggs.setDirection(7);
			handler.getGame().geteManager().addEntity(drace);
			drace.setDoesNotMove(true);
			drace.setDirection(2);
			handler.getGame().geteManager().addEntity(sebastian);
			sebastian.setDoesNotMove(true);
			sebastian.setDirection(3);
			handler.getGame().geteManager().addEntity(fineas);
			fineas.setDoesNotMove(true);
			fineas.setDirection(6);
			handler.getGame().geteManager().addEntity(serii);
			serii.setDoesNotMove(true);
			serii.setDirection(5);
			
			delay(500);
			break;
		case 1:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				handler.getGame().getGameState().getEffects().displayDialog(73);
				delay(500);
			}
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				fineas.setDirection(4);
				handler.getGame().getGameState().getEffects().displayDialog(74);
				delay(500);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				fineas.setExpressionAnimation(shocked, -5, -30);
				handler.getGame().getGameState().getEffects().displayDialog(80);
				delay(500);
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				serii.setDirection(6);
				handler.getGame().getGameState().getEffects().displayDialog(81);
				delay(500);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				fineas.setExpressionAnimation(shocked, -5, -30);
				handler.getGame().getGameState().getEffects().displayDialog(82);
				delay(500);
			}
			break;
		case 6:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				drace.setDirection(4);
				handler.getGame().getGameState().getEffects().displayDialog(83);
				delay(500);
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				crawford.setDirection(7);
				handler.getGame().getGameState().getEffects().displayDialog(84);
				delay(500);
			}
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				crawford.setExpressionAnimation(shocked, -5, -30);
				crawford.setDirection(1);
				riggs.setExpressionAnimation(shocked, -5, -30);
				handler.getGame().getGameState().getEffects().displayDialog(85);
				delay(500);
			}
			break;
		case 9:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				drace.setDirection(2);
				handler.getGame().getGameState().getEffects().displayDialog(87);
				delay(500);
			}
			break;
		case 10:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
				{
					eManager.removeEntity(serii);
					handler.getGame().getGameState().getEffects().fade(0);
					delay(500);
				}		
			}
			break;
		case 11:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				drace.setDirection(4);
				handler.getGame().getGameState().getEffects().displayDialog(86);
				delay(500);
			}
			break;
		case 12:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
				{
					eManager.removeEntity(fineas);
					eManager.removeEntity(drace);
					eManager.removeEntity(crawford);
					eManager.removeEntity(riggs);
					eManager.removeEntity(sebastian);
					handler.getGame().getGameState().getEffects().fade(0);
					handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("BEDROOM");
					handler.getGame().getGameState().getLevelManager().getBaseCamp().setNPCs();
					handler.getGame().getGameState().getLevelManager().getBaseCamp().setBarriers();
					handler.getGame().getPlayer().setX(252);
					handler.getGame().getPlayer().setY(244);
					player.setState("CHASE");
					operation = 0;
					handler.getGame().getGameState().getLevelManager().getBaseCamp().setQuestTracker(0);
					running = false;
				}
			}
			break;
		}
	}
}
