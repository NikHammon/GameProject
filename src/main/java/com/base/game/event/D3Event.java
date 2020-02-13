package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.eventEntity.TreasureChest;
import com.base.game.entity.eventEntity.NPC.CrawfordNPC;
import com.base.game.entity.eventEntity.NPC.RiggsNPC;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.monsters.Crawford;
import com.base.game.entity.monsters.D1Boss;
import com.base.game.entity.monsters.Riggs;
import com.base.game.tiles.Tile;

public class D3Event extends Event
{
	public D3Event(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 10)
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Crawford crawfordBoss = new Crawford(handler, 10.5f * Tile.TILE_WIDTH - 30, 12.5f * Tile.TILE_HEIGHT, 2);
	Riggs riggsBoss = new Riggs(handler, 13.5f * Tile.TILE_WIDTH - 50, 12f * Tile.TILE_HEIGHT, 2);
	CrawfordNPC crawford = new CrawfordNPC(handler, 10.5f * Tile.TILE_WIDTH - 30, 12.5f * Tile.TILE_HEIGHT, 2);
	RiggsNPC riggs = new RiggsNPC(handler, 13.5f * Tile.TILE_WIDTH - 50, 12f * Tile.TILE_HEIGHT, 2);
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
			handler.getGame().geteManager().addEntity(riggs);
			handler.getGame().geteManager().addEntity(crawford);
			crawford.setDoesNotMove(true);
			riggs.setDoesNotMove(true);
			
			crawford.setDirection(1);
			riggs.setDirection(7);
			
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
				handler.getGame().getGameState().getEffects().displayDialog(70);
				delay(500);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				crawford.setDirection(7);
				riggs.setDirection(1);
				delay(1000);
			}
			break;
		case 4:
			crawford.setDirection(5);
			riggs.setDirection(3);
			delay(1000);
			break;
		case 5:
			crawford.setDirection(3);
			riggs.setDirection(5);
			delay(1000);
			break;
		case 6:
			handler.getGame().getGameState().getEffects().displayDialog(71);
			delay(500);
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setState("CHASE");
				eManager.removeEntity(crawford);
				eManager.removeEntity(riggs);
				eManager.addEntity(crawfordBoss);
				eManager.addEntity(riggsBoss);
				crawfordBoss.setState("CHASE");
				riggsBoss.setState("CHASE");
				delay(500);
			}
			break;
		case 8:
			if(crawfordBoss.getState() == "DEFEATED" && riggsBoss.getState() == "DEFEATED")
			{
				handler.getGame().getGameState().getEffects().fade(1);	
				player.setState("IDLE");
				delay(500);
			}
			break;
		case 9:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(crawfordBoss);
				eManager.removeEntity(riggsBoss);
				
				handler.getGame().geteManager().addEntity(riggs);
				handler.getGame().geteManager().addEntity(crawford);
				crawford.setDoesNotMove(true);
				riggs.setDoesNotMove(true);
				
				player.setX(12 * Tile.TILE_WIDTH - 32);
				player.setY(14.5f * Tile.TILE_WIDTH);
				player.setDirection(0);
				eManager.addEntity(portal);
				eManager.addEntity(chest);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(500);
			}
			break;
		case 10:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				handler.getGame().getGameState().getEffects().displayDialog(72);
				delay(500);
			}
			break;
		case 11:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				operation = 0;
				player.setState("CHASE");
				handler.getBaseCamp().setDungeonsCleared(3);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(11);
				running = false;
			}
			break;
		}
	}
}
