package com.base.game.event;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Guard;
import com.base.game.entity.eventEntity.NPC.Ken;
import com.base.game.entity.eventEntity.NPC.NPC;
import com.base.game.entity.eventEntity.NPC.NPC12;
import com.base.game.entity.eventEntity.NPC.NPC13;
import com.base.game.entity.eventEntity.NPC.NPC14;
import com.base.game.entity.eventEntity.NPC.NPC15;
import com.base.game.entity.eventEntity.NPC.NPC16;
import com.base.game.entity.eventEntity.NPC.NPC17;
import com.base.game.entity.eventEntity.NPC.RoyalGuard;

public class Event2 extends Event
{
	public Event2(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(768, 1458, 128, 2);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 1 && handler.getGame().getGameState().getLevelManager().getBaseCamp().getState() == "CASTLEAREA")
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	NPC[] npcs = {			new Guard(handler, 640, 1070, 0), new NPC17(handler, 790, 1050, 0), new NPC15(handler, 970, 1070, 0),
					new NPC12(handler, 550, 1120, 0), new NPC16(handler, 730, 1080, 0), new Guard(handler, 900, 1090, 0), new NPC14(handler, 1070, 1080, 0),
							new Guard(handler, 670, 1140, 0), new Ken(handler, 790, 1160, 0), new NPC13(handler, 980, 1150, 0)};
	
	
	Cassiopia queen = new Cassiopia(handler, 800, 800, 0);
	Drace king = new Drace(handler, 800, 820, 0);
	@Override
	public void run(Graphics g) 
	{
		switch(operation)
		{
		case -1:
			runDelay();
			break;	
		case 0:
			for(NPC npc : npcs)
			{
				handler.getGame().geteManager().addEntity(npc);
				npc.setDirection(0);
				npc.setDoesNotMove(true);
			}
			delay(500);
			break;
		case 1:
			if(player.getState() != "FORCEMOVE")
			{
				player.setForceMove("UP", "UP", "RIGHT", "UP");
				delay(500);
			}
			break;
		case 2:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				player.setCameraActive(false);
				delay(500);
			}
			break;
		case 3:
			if(handler.getCamera().scrawl(352, 742))
			{
				g.setColor(Color.black);
				g.fillRect(802, 768, 62, 82);
				delay(3000);
			}
			break;
		case 4:
			handler.getGame().geteManager().addEntity(king);
			//handler.getGame().getGameState().getEffects().drawRectangle(800, 768, 64, 84);
			king.setDoesNotMove(true);
			king.setForceMove("DOWN");
			delay(500);
			break;
		case 5:
			if(king.getState() != "FORCEMOVE")
			{
				king.setForceMove("DOWN", "RIGHT");
				handler.getGame().geteManager().addEntity(queen);
				queen.setDoesNotMove(true);
				queen.setForceMove("DOWN", "DOWN", "LEFT");
				delay(500);
			}
			break;
		case 6:
			if(king.getState() != "FORCEMOVE")
			{
				king.setDirection(4);
				delay(500);
			}
			break;
		case 7:
			
			if(queen.getState() != "FORCEMOVE")
			{
				//handler.getGame().getGameState().getEffects().setDrawRect(false);
				queen.setDirection(4);
				handler.getGame().getGameState().getEffects().displayDialog(21);
				
				delay(500);
			}
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				queen.setForceMove("RIGHT", "RIGHT");
				delay(500);
			}
			break;
		case 9:
			if(queen.getState() != "FORCEMOVE")
			{
				handler.getGame().getGameState().getEffects().displayDialog(22);
				delay(0);
			}
			break;
		case 10:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				npcs[0].setExpressionAnimation(shocked, -5, -30);
				npcs[2].setExpressionAnimation(shocked, -5, -30);
				npcs[3].setExpressionAnimation(shocked, -5, -30);
				npcs[6].setExpressionAnimation(shocked, -5, -30);
				if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
				{
					player.setExpressionAnimation(embarassed, 35, 10);
					handler.getGame().getGameState().getEffects().displayDialog(23);
					delay(500);
				}
			}
			break;
		case 11:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setForceMove("UP", "UP");
				delay(500);
			}
			break;
		case 12:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				player.setDirection(4);
				player.setExpressionAnimation(angry, 10, -10);
				handler.getGame().getGameState().getEffects().displayDialog(24);
				handler.getCamera().setSpeed(5);
				delay(500);
			}
			break;
		case 13:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				if(handler.getCamera().scrawl(npcs[0].getX() - handler.getGame().getWidth() / 2 + npcs[0].getWidth() / 2, npcs[0].getY() - handler.getGame().getHeight() / 2 + npcs[0].getHeight() / 2))
				{
					npcs[0].setDirection(2);
					handler.getGame().getGameState().getEffects().displayDialog(25);
					delay(500);
				}
			}
			break;	
		case 14:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				if(handler.getCamera().scrawl(npcs[6].getX() - handler.getGame().getWidth() / 2 + npcs[6].getWidth() / 2, npcs[6].getY() - handler.getGame().getHeight() / 2 + npcs[6].getHeight() / 2))
				{
					npcs[6].setDirection(6);
					handler.getGame().getGameState().getEffects().displayDialog(26);
					delay(500);
				}
			}
			break;	
		case 15:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				if(handler.getCamera().scrawl(npcs[7].getX() - handler.getGame().getWidth() / 2 + npcs[7].getWidth() / 2, npcs[7].getY() - handler.getGame().getHeight() / 2 + npcs[7].getHeight() / 2))
				{
					npcs[7].setDirection(2);
					handler.getGame().getGameState().getEffects().displayDialog(27);
					delay(500);
				}
			}
			break;	
		case 16:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
				{
					handler.getGame().getGameState().getEffects().displayDialog(28);
					npcs[0].setDirection(0);
					npcs[6].setDirection(0);
					npcs[7].setDirection(0);
					delay(500);
				}
			}
			break;
		case 17:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				if(handler.getCamera().scrawl(npcs[3].getX() - handler.getGame().getWidth() / 2 + npcs[3].getWidth() / 2, npcs[3].getY() - handler.getGame().getHeight() / 2 + npcs[3].getHeight() / 2))
				{
					npcs[3].setDirection(2);
					handler.getGame().getGameState().getEffects().displayDialog(29);
					delay(500);
				}
			}
			break;
		case 18:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				if(handler.getCamera().scrawl(npcs[9].getX() - handler.getGame().getWidth() / 2 + npcs[9].getWidth() / 2, npcs[9].getY() - handler.getGame().getHeight() / 2 + npcs[9].getHeight() / 2))
				{
					npcs[9].setDirection(6);
					handler.getGame().getGameState().getEffects().displayDialog(30);
					delay(500);
				}
			}
			break;
		case 19:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				delay(500);
			}
			break;
		case 20:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				for(NPC npc : npcs)
					handler.getGame().geteManager().removeEntity(npc);
				queen.setX(800);
				queen.setY(920);
				queen.setDirection(4);
				king.setDirection(6);
				player.setX(768);
				player.setY(980);
				handler.getCamera().setxOffset(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2);
				handler.getCamera().setyOffset(player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2);
				player.setDirection(2);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(500);
			}
			break;
		case 21:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				handler.getGame().getGameState().getEffects().displayDialog(31);
				delay(500);
			}
			break;
		case 22:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				king.setForceMove("DOWN", "DOWN", "DOWN", "DOWN", "DOWN");
				delay(500);
			}
			break;
		case 23:
			if(king.getState() != "FORCEMOVE")
			{
				handler.getGame().geteManager().removeEntity(king);
				player.setDirection(1);
				handler.getGame().getGameState().getEffects().displayDialog(32);
				delay(500);
			}
			break;
		case 24:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				queen.setForceMove("DOWN", "DOWN", "DOWN", "DOWN", "DOWN");
				delay(500);
			}
			break;
		case 25:
			if(queen.getState() != "FORCEMOVE")
			{
				handler.getGame().geteManager().removeEntity(queen);
				delay(500);
			}
			break;
		case 26:
			player.setState("CHASE");
			operation = 0;
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(2);
			running = false;
			break;
		
		}
		
	}
}
