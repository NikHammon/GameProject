package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Fineas;
import com.base.game.entity.eventEntity.NPC.Obin;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.eventEntity.NPC.Serii;

public class Event14 extends Event
{
	public Event14(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0,0,0,0);
	}

	@Override
	public boolean meetsRequirements(){return false;}
	
	Sebastian sebastian = new Sebastian(handler, 680, 960, 0);
	Serii serii = new Serii(handler, 900, 970, 0);
	Drace drace = new Drace(handler, 730, 910, 0);
	Fineas fineas = new Fineas(handler, 850, 920, 0);
	Obin obin = new Obin(handler, 730, 1470, 0);
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
			
			handler.getGame().geteManager().addEntity(sebastian);
			handler.getGame().geteManager().addEntity(fineas);
			handler.getGame().geteManager().addEntity(serii);
			handler.getGame().geteManager().addEntity(drace);
			handler.getGame().geteManager().addEntity(obin);

			sebastian.setDoesNotMove(true);
			serii.setDoesNotMove(true);
			fineas.setDoesNotMove(true);
			drace.setDoesNotMove(true);
			obin.setDoesNotMove(true);
			
			obin.setDirection(1);
			drace.setDirection(4);
			fineas.setDirection(4);
			sebastian.setDirection(3);
			serii.setDirection(5);

			delay(8000);
			break;
		case 1:
			handler.getGame().getGameState().getEffects().displayDialog(111);
			delay(500);
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				
				player.setForceMove("UP", "UP", "UP", "UP", "UP", "UP");
				obin.setForceMove("UP", "UP", "UP", "UP", "UP", "UP");
				delay(5000);
			}
			break;
		case 3:
			if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				if(player.getState() != "FORCEMOVE")
				{
					player.setState("IDLE");
					handler.getGame().getGameState().getEffects().displayDialog(112);
					delay(500);
				}
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				serii.setDirection(6);
				serii.setExpressionAnimation(embarassed, 35, 10);
				handler.getGame().getGameState().getEffects().displayDialog(113);
				delay(500);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				delay(500);
			}
			break;
		case 6:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(drace);
				eManager.removeEntity(fineas);
				eManager.removeEntity(sebastian);
				eManager.removeEntity(serii);
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
			break;
		}
	}
}
