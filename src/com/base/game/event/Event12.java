package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Fineas;
import com.base.game.entity.eventEntity.NPC.Guard;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.eventEntity.NPC.Serii;

public class Event12 extends Event
{
	public Event12(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0,0,0,0);
	}

	@Override
	public boolean meetsRequirements(){return false;}
	
	Sebastian sebastian = new Sebastian(handler, 900, 970, 0);
	Drace drace = new Drace(handler, 730, 910, 0);
	Fineas fineas = new Fineas(handler, 850, 920, 0);
	Serii serii = new Serii(handler, 730, 1470, 0);
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
			handler.getGame().geteManager().addEntity(drace);
			handler.getGame().geteManager().addEntity(serii);

			sebastian.setDoesNotMove(true);
			fineas.setDoesNotMove(true);
			drace.setDoesNotMove(true);
			serii.setDoesNotMove(true);
			
			serii.setDirection(1);
			drace.setDirection(4);
			fineas.setDirection(4);
			sebastian.setDirection(5);

			delay(5000);
			break;
		case 1:
			handler.getGame().getGameState().getEffects().displayDialog(97);
			delay(500);
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setForceMove("UP", "UP", "UP", "UP", "UP", "UP");
				serii.setForceMove("UP", "UP", "UP", "UP", "UP", "UP");
				delay(5000);
			}
			break;
		case 3:
			if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				if(player.getState() != "FORCEMOVE")
				{
					player.setState("IDLE");
					serii.setDirection(1);
					handler.getGame().getGameState().getEffects().displayDialog(98);
					delay(500);
				}
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setExpressionAnimation(embarassed, 35, 10);
				handler.getGame().getGameState().getEffects().displayDialog(99);
				delay(500);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				drace.setDirection(0);
				fineas.setExpressionAnimation(shocked, -5, -30);
				sebastian.setExpressionAnimation(shocked, -5, -30);
				handler.getGame().getGameState().getEffects().displayDialog(100);
				delay(500);
			}
			break;
		case 6:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				fineas.setDirection(6);
				handler.getGame().getGameState().getEffects().displayDialog(101);
				delay(500);
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				fineas.setDirection(4);
				drace.setDirection(4);
				handler.getGame().getGameState().getEffects().displayDialog(102);
				delay(500);
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
