package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.eventEntity.Artifact;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.eventEntity.TreasureChest;
import com.base.game.entity.eventEntity.NPC.Budaroth;
import com.base.game.entity.eventEntity.NPC.CrawfordNPC;
import com.base.game.entity.eventEntity.NPC.Fairy;
import com.base.game.entity.eventEntity.NPC.NPC;
import com.base.game.entity.eventEntity.NPC.RiggsNPC;
import com.base.game.entity.eventEntity.NPC.Shadow;
import com.base.game.entity.monsters.Crawford;
import com.base.game.entity.monsters.D1Boss;
import com.base.game.entity.monsters.Riggs;
import com.base.game.tiles.Tile;

public class D7Event extends Event
{
	public D7Event(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 22)
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}
	
	Budaroth budaroth = new Budaroth(handler, 12f * Tile.TILE_WIDTH, 12f * Tile.TILE_HEIGHT, 2);
	D1Boss boss = new D1Boss(handler, 12f * Tile.TILE_WIDTH - 32, 12f * Tile.TILE_HEIGHT, 2);
	Shadow[] shadows = {new Shadow(handler, 9.5f * Tile.TILE_WIDTH - 32, 10.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 10.5f * Tile.TILE_WIDTH - 32, 10.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 11.5f * Tile.TILE_WIDTH - 32, 10.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 12.5f * Tile.TILE_WIDTH - 32, 10.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 13.5f * Tile.TILE_WIDTH - 32, 10.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 14.5f * Tile.TILE_WIDTH - 32, 10.5f * Tile.TILE_HEIGHT, 2),
									new Shadow(handler, 10 * Tile.TILE_WIDTH - 32, 11.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 11f * Tile.TILE_WIDTH - 32, 11.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 12f * Tile.TILE_WIDTH - 32, 11.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 13f * Tile.TILE_WIDTH - 32, 11.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 14f * Tile.TILE_WIDTH - 32, 11.5f * Tile.TILE_HEIGHT, 2),
												new Shadow(handler, 10.5f * Tile.TILE_WIDTH - 32, 12.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 11.5f * Tile.TILE_WIDTH - 32, 12.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 12.5f * Tile.TILE_WIDTH - 32, 12.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 13.5f * Tile.TILE_WIDTH - 32, 12.5f * Tile.TILE_HEIGHT, 2),
																new Shadow(handler, 11 * Tile.TILE_WIDTH - 32, 13.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 12 * Tile.TILE_WIDTH - 32, 13.5f * Tile.TILE_HEIGHT, 2), new Shadow(handler, 13 * Tile.TILE_WIDTH - 32, 13.5f * Tile.TILE_HEIGHT, 2)};

	@Override
	public void run(Graphics g) 
	{
		switch(operation)
		{
		case -1:
			runDelay();
			break;	
		case 0:	
			for(Shadow shadow : shadows)
			{
				eManager.addEntity(shadow);
				shadow.setDirection(4);
				shadow.setDoesNotMove(true);
			}

			player.setState("IDLE");
			delay(500);
			break;
		case 1:
			if(handler.getGame().getGameState().getEffects().getAlpha() <= .5)
			{
				player.setForceMove("UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP");
				delay(500);
			}
			break;
		case 2:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				handler.getGame().getGameState().getEffects().displayDialog(133);
				delay(500);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setState("CHASE");
				for(Shadow shadow : shadows)
				{
					shadow.setCurrentAnimation(shadow.shadowOut);
					shadow.shadowOut.reset();
					shadow.setDoNotUpdate(true);
				}
				eManager.addEntity(boss);
				boss.setState("CHASE");
				delay(500);
			}
			break;
		case 4:
			if(shadows[0].shadowOut.isComplete())
			{
				for(Shadow shadow : shadows)
				{
					eManager.removeEntity(shadow);
				}
				delay(500);
			}
			else
				for(Shadow shadow : shadows)
					shadow.shadowOut.update();
		case 5:
			if(boss.getState() == "DEFEATED")
			{
				handler.getGame().getGameState().getEffects().fade(1);	
				player.setState("IDLE");
				delay(500);
			}
			break;
		case 6:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(boss);
				for(Shadow shadow : shadows)
				{
					shadow.setDoesNotMove(true);
					shadow.setDoNotUpdate(true);
					shadow.shadowIn.reset();
					shadow.setCurrentAnimation(shadow.shadowIn);
					eManager.addEntity(shadow);
				}
				
				player.setX(12 * Tile.TILE_WIDTH - 32);
				player.setY(14.5f * Tile.TILE_WIDTH);
				player.setDirection(0);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(0);
			}
			break;
		case 7:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				if(shadows[0].shadowIn.isComplete())
				{
					for(Shadow shadow : shadows)
					{
						shadow.setDoNotUpdate(false);
					}
					handler.getGame().getGameState().getEffects().displayDialog(134);
					delay(0);
				}
				else
					for(Shadow shadow : shadows)
						shadow.shadowIn.update();
				
			}
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setExpressionAnimation(embarassed, 35, 10);
				handler.getGame().getGameState().getEffects().displayDialog(135);
				delay(500);
			}
			break;
		case 9:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);	
				delay(500);
			}
			break;
		case 10:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				handler.getGame().getGameState().getEffects().fade(0);	
				delay(0);
			}
			break;
		case 11:
			handler.getGame().getGameState().getEffects().setForestSceen(true);
			
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				handler.getGame().getGameState().getEffects().displayDialog(136);
				delay(0);
			}
			break;
		case 12:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				delay(0);
			}
			break;
		case 13:
			if(handler.getGame().getGameState().getEffects().getBudarothAlpha() >= 1)
			{
				handler.getGame().getGameState().getEffects().displayDialog(137);
				delay(0);
			}
			else
			{	
				handler.getGame().getGameState().getEffects().setBudarothAlpha((float) (handler.getGame().getGameState().getEffects().getBudarothAlpha() + .01)); 
			}
			break;
		case 14:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				delay(0);
			}
			break;
		case 15:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				handler.getGame().getGameState().getEffects().setForestSceen(false);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(0);
			}
			break;
		case 16:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				handler.getGame().getGameState().getEffects().displayDialog(138);
				delay(500);
			}
			break;
		case 17:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				delay(500);
			}
			break;
		case 18:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				for(Shadow shadow : shadows)
				{
					eManager.removeEntity(shadow);
				}
				eManager.addEntity(chest);
				eManager.addEntity(portal);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(500);
			}
			break;
		case 19:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				operation = 0;
				player.setState("CHASE");
				handler.getBaseCamp().setDungeonsCleared(7);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(22);
				running = false;
			}
			break;
		}
	}
}
