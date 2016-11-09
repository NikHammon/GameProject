package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.Artifact;
import com.base.game.entity.eventEntity.NPC.Boy;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Fineas;
import com.base.game.entity.eventEntity.NPC.Girl;
import com.base.game.entity.eventEntity.NPC.Guard;
import com.base.game.entity.eventEntity.NPC.Ken;
import com.base.game.entity.eventEntity.NPC.NPC;
import com.base.game.entity.eventEntity.NPC.NPC12;
import com.base.game.entity.eventEntity.NPC.NPC13;
import com.base.game.entity.eventEntity.NPC.NPC14;
import com.base.game.entity.eventEntity.NPC.NPC15;
import com.base.game.entity.eventEntity.NPC.NPC16;
import com.base.game.entity.eventEntity.NPC.NPC17;
import com.base.game.entity.eventEntity.NPC.Obin;
import com.base.game.entity.eventEntity.NPC.OldMan;
import com.base.game.entity.eventEntity.NPC.Rubel;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.eventEntity.NPC.Serii;
import com.base.game.entity.eventEntity.NPC.Woman;

public class Event19 extends Event
{
	public Event19(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0,0,0,0);
	}

	@Override
	public boolean meetsRequirements(){return false;}
	
	Drace drace = new Drace(handler, 680, 1000, 0);
	Fineas fineas = new Fineas(handler, 790, 960, 0);
	Serii serii = new Serii(handler, 860, 980, 0);
	Rubel rubel = new Rubel(handler, 740, 960, 0);
	Obin obin = new Obin(handler, 870, 1020, 0);
	Sebastian sebastian = new Sebastian(handler, 710, 1040, 2);
	
	NPC[] npcs = {			new OldMan(handler, 610, 1020, 0), new NPC17(handler, 790, 1120, 0), new NPC15(handler, 980, 1010, 0),
			new NPC12(handler, 650, 1050, 0), new NPC16(handler, 600, 1060, 0), new Boy(handler, 940, 1100, 0), new NPC14(handler, 1030, 980, 0), new Woman(handler, 990, 1050, 0),
					new Girl(handler, 680, 1100, 0), new Ken(handler, 730, 1100, 0), new NPC13(handler, 870, 1100, 0)};

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
			
			
			player.setCurrentAnimation(player.playerRise);
			player.setDoNotUpdate(true);
			player.setDoNotRenderShadow(true);
			
			for(NPC npc : npcs)
			{
				handler.getGame().geteManager().addEntity(npc);
				npc.setDirection(0);
				npc.setDoesNotMove(true);
			}
			
			npcs[0].setDirection(2);
			npcs[2].setDirection(6);
			npcs[3].setDirection(2);
			npcs[4].setDirection(2);
			npcs[5].setDirection(6);
			npcs[6].setDirection(6);
			npcs[6].setDirection(6);
			npcs[7].setDirection(6);
			npcs[8].setDirection(2);
			
			handler.getGame().geteManager().addEntity(obin);
			handler.getGame().geteManager().addEntity(serii);
			handler.getGame().geteManager().addEntity(fineas);
			handler.getGame().geteManager().addEntity(rubel);
			handler.getGame().geteManager().addEntity(drace);
			handler.getGame().geteManager().addEntity(sebastian);

			obin.setDoesNotMove(true);
			serii.setDoesNotMove(true);
			fineas.setDoesNotMove(true);
			rubel.setDoesNotMove(true);
			drace.setDoesNotMove(true);
			sebastian.setDoesNotMove(true);
			
			drace.setDirection(2);
			fineas.setDirection(4);
			rubel.setDirection(4);
			serii.setDirection(5);
			sebastian.setDirection(2);
			obin.setDirection(6);

			delay(500);
			break;
		case 1:
			handler.getGame().getGameState().getEffects().displayDialog(152);
			delay(0);
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getGame().getGameState().getEffects().displayDialog(153);
				delay(0);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().displayDialog(154);
				player.playerRise.reset();
				delay(0);
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				if(player.playerRise.isComplete())
				{

					handler.getGame().getGameState().getEffects().displayDialog(155);
					delay(0);
				}
				else
					player.playerRise.update();
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				serii.setExpressionAnimation(shocked, -5, -30);
				handler.getGame().getGameState().getEffects().displayDialog(170);
				delay(0);
			}
			break;
		case 6:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				fineas.setExpressionAnimation(laughing, 10, -30);
				drace.setExpressionAnimation(laughing, 10, -30);
				sebastian.setExpressionAnimation(laughing, 10, -30);
				obin.setExpressionAnimation(laughing, 10, -30);
				rubel.setExpressionAnimation(laughing, 10, -30);
				handler.getGame().getGameState().getEffects().displayDialog(156);
				delay(0);
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().displayDialog(157);
				delay(0);
			}
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				delay(500);
			}
			break;
		case 9:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				player.setDoNotRenderShadow(false);
				player.setDoNotUpdate(false);
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("BEDROOM");
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setNPCs();
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setBarriers();
				handler.getGame().getPlayer().setX(252);
				handler.getGame().getPlayer().setY(244);
				player.setState("CHASE");
				operation = 0;
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(24);
				running = false;		
			}
			break;
		}
	}
}
