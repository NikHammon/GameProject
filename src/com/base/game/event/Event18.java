package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Guard;
import com.base.game.entity.eventEntity.NPC.Obin;
import com.base.game.entity.eventEntity.NPC.Rubel;
import com.base.game.entity.eventEntity.NPC.Sebastian;

public class Event18 extends Event
{
	public Event18(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0,0,0,0);
	}

	@Override
	public boolean meetsRequirements(){return false;}
	
	Obin obin = new Obin(handler, 900, 1960, 0);
	Rubel rubel = new Rubel(handler, 1080, 1960, 0);
	Drace drace = new Drace(handler, 1000, 1940, 0);
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

			handler.getCamera().setxOffset(556);
			handler.getCamera().setyOffset(1690);
			
			handler.getGame().geteManager().addEntity(drace);
			drace.setDirection(4);
			drace.setDoesNotMove(true);

			delay(5000);
			break;
		case 1:
			handler.getGame().getGameState().getEffects().displayDialog(139);
			delay(500);
			break;
		case 2:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{				
				player.setForceMove("UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP");
				delay(5000);
			}
			break;
		case 3:
			if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				if(player.getState() != "FORCEMOVE")
				{
					player.setState("IDLE");
					handler.getGame().getGameState().getEffects().displayDialog(140);
					delay(500);
				}
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				delay(500);
			}
			break;
		case 5:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.addEntity(obin);
				obin.setDoesNotMove(true);
				obin.setDirection(4);
				eManager.addEntity(rubel);
				rubel.setDoesNotMove(true);
				rubel.setDirection(4);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(0);
			}
			break;
		case 6:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				player.setDirection(7);
				handler.getGame().getGameState().getEffects().displayDialog(141);
				delay(0);
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				drace.setExpressionAnimation(shocked, -5, -30);
				obin.setExpressionAnimation(shocked, -5, -30);
				handler.getGame().getGameState().getEffects().displayDialog(142);
				delay(0);
			}
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setDirection(1);
				handler.getGame().getGameState().getEffects().displayDialog(143);
				delay(0);
			}
			break;
		case 9:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				delay(0);
			}
			break;
		case 10:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(drace);
				eManager.removeEntity(obin);
				eManager.removeEntity(rubel);
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("BEDROOM");
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setNPCs();
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setBarriers();
				handler.getGame().getPlayer().setX(252);
				handler.getGame().getPlayer().setY(244);
				player.setState("CHASE");
				operation = 0;
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(23);
				handler.getBaseCamp().setDungeonsUnlocked(8);
				running = false;
				
			}
			break;
		}
	}
}
