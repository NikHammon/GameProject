package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.eventEntity.TreasureChest;
import com.base.game.entity.eventEntity.NPC.Fairy;
import com.base.game.entity.eventEntity.NPC.Guard;
import com.base.game.entity.eventEntity.NPC.Ken;
import com.base.game.entity.eventEntity.NPC.NPC;
import com.base.game.entity.eventEntity.NPC.NPC12;
import com.base.game.entity.eventEntity.NPC.NPC13;
import com.base.game.entity.eventEntity.NPC.NPC14;
import com.base.game.entity.eventEntity.NPC.NPC15;
import com.base.game.entity.eventEntity.NPC.NPC16;
import com.base.game.entity.eventEntity.NPC.NPC17;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.monsters.D1Boss;
import com.base.game.tiles.Tile;

public class D6Event extends Event
{
	public D6Event(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 19)
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	D1Boss boss = new D1Boss(handler, 12f * Tile.TILE_WIDTH, 12f * Tile.TILE_HEIGHT, 2);
	Fairy fairy = new Fairy(handler, 12 * Tile.TILE_WIDTH - 26, 0 * Tile.TILE_HEIGHT, 2);
	
	NPC[] npcs = {			new Fairy(handler, 9 * Tile.TILE_WIDTH - 26, -.5f * Tile.TILE_HEIGHT, 0), new Fairy(handler, 10 * Tile.TILE_WIDTH - 26, -.5f * Tile.TILE_HEIGHT, 0), new Fairy(handler, 14 * Tile.TILE_WIDTH - 26, -.5f * Tile.TILE_HEIGHT, 0),
			new Fairy(handler, 8 * Tile.TILE_WIDTH - 26, 0 * Tile.TILE_HEIGHT, 0), new Fairy(handler, 9.5f * Tile.TILE_WIDTH - 26, 0 * Tile.TILE_HEIGHT, 0), new Fairy(handler, 14.5f * Tile.TILE_WIDTH - 26, 0 * Tile.TILE_HEIGHT, 0), new Fairy(handler, 16 * Tile.TILE_WIDTH - 26, 0 * Tile.TILE_HEIGHT, 0),
					new Fairy(handler, 10 * Tile.TILE_WIDTH - 26, .5f * Tile.TILE_HEIGHT, 0), new Fairy(handler, 14 * Tile.TILE_WIDTH - 26, .5f * Tile.TILE_HEIGHT, 0), new Fairy(handler, 15 * Tile.TILE_WIDTH - 26, .5f * Tile.TILE_HEIGHT, 0)};

	
	@Override
	public void run(Graphics g) 
	{
		switch(operation)
		{
		case -1:
			runDelay();
			break;	
		case 0:	
			handler.getGame().geteManager().addEntity(boss);
			boss.setState("IDLE");
			player.setState("IDLE");
			delay(500);
			break;
		case 1:
			if(handler.getGame().getGameState().getEffects().getAlpha() <= .5)
			{
				player.setForceMove("UP", "UP");
				delay(500);
			}
			break;
		case 2:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				player.setCameraActive(false);
				player.setDirection(7);
				delay(4000);
			}
			break;
		case 3:
			player.setDirection(0);
			delay(500);
			break;
		case 4:
			player.setDirection(1);
			delay(4000);
			break;
		case 5:
			player.setDirection(0);
			delay(500);
			break;
		case 6:
			player.setDirection(7);
			delay(4000);
			break;
		case 7:
			player.setDirection(0);
			handler.getGame().getGameState().getEffects().displayDialog(118);
			delay(500);
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(boss.getX() - handler.getGame().getWidth() / 2 + boss.getWidth() / 2, boss.getY() - handler.getGame().getHeight() / 2 + boss.getHeight() / 2))
			{
				handler.getGame().getGameState().getEffects().displayDialog(119);
				eManager.addEntity(boss);
				boss.setState("IDLE");
				delay(500);
			}
			break;
		case 9:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				player.setState("CHASE");
				boss.setState("CHASE");
				delay(500);
			}
			break;
		case 10:
			if(boss.getState() == "DEFEATED")
			{
				handler.getGame().getGameState().getEffects().fade(1);	
				player.setState("IDLE");
				delay(500);
			}
			break;
		case 11:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(boss);
				
				eManager.addEntity(fairy);
				
				for(NPC npc : npcs)
				{
					handler.getGame().geteManager().addEntity(npc);
				}
				
				fairy.setDoesNotMove(true);

				player.setX(12 * Tile.TILE_WIDTH - 32);
				player.setY(4f * Tile.TILE_WIDTH);
				player.setDirection(0);

				handler.getGame().getGameState().getEffects().fade(0);
				delay(500);
			}
			break;
		case 12:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				player.setForceMove("UP", "UP");
				delay(500);
			}
			break;
		case 13:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				handler.getGame().getGameState().getEffects().displayDialog(120);
				delay(500);
			}
			break;
		case 14:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				fairy.setForceMove("DOWN");
				delay(500);
			}
			break;
		case 15:
			if(fairy.getState() != "FORCEMOVE")
			{
				handler.getGame().getGameState().getEffects().displayDialog(121);
				player.setExpressionAnimation(shocked, -5, -30);
				delay(500);
			}
			break;
		case 16:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);	
				delay(500);
			}
			break;
		case 17:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(fairy);

				player.setX(12 * Tile.TILE_WIDTH - 32);
				player.setY(6f * Tile.TILE_WIDTH);
				player.setDirection(0);
				
				eManager.addEntity(chest);
				eManager.addEntity(portal);

				handler.getGame().getGameState().getEffects().fade(0);
				delay(500);
			}
			break;
		case 18:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				operation = 0;
				player.setState("CHASE");
				handler.getBaseCamp().setDungeonsCleared(6);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setQuestTracker(0);
				running = false;
			}
			break;
		}
	}
}
