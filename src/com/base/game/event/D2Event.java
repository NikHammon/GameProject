package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.Artifact;
import com.base.game.entity.eventEntity.Gold;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.eventEntity.TreasureChest;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.monsters.D1Boss;
import com.base.game.entity.monsters.D2Boss;
import com.base.game.tiles.Tile;

public class D2Event extends Event
{
	public D2Event(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 6)
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Artifact artifact = new Artifact(handler, 12 * Tile.TILE_WIDTH - 32, 6f * Tile.TILE_HEIGHT, 2);
	D2Boss boss = new D2Boss(handler, 12f * Tile.TILE_WIDTH - 100, -1f * Tile.TILE_HEIGHT, 2);
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
			handler.getGame().geteManager().addEntity(artifact);
			artifact.setBounds(new Rectangle(0,0,0,0));
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
			handler.getGame().getGameState().getEffects().displayDialog(58);
			delay(500);
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(artifact.getX() - handler.getGame().getWidth() / 2 + artifact.getWidth() / 2, artifact.getY() - handler.getGame().getHeight() / 2 + artifact.getHeight() / 2))
			{
				handler.getGame().getGameState().getEffects().displayDialog(59);
				eManager.addEntity(boss);
				boss.setState("IDLE");
				delay(500);
			}
			break;
		case 9:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				boss.setForceMove("DOWN", "DOWN", "DOWN", "DOWN");
				delay(500);
			}
			break;
		case 10:
			if(boss.getState() != "FORCEMOVE")
			{
				boss.setState("IDLE");
				handler.getGame().getGameState().getEffects().displayDialog(60);
				delay(500);
			}
			break;
		case 11:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				player.setState("CHASE");
				boss.setState("CHASE");
				eManager.removeEntity(artifact);
				delay(500);
			}
			break;
		case 12:
			if(boss.getState() == "DEFEATED")
			{
				handler.getGame().getGameState().getEffects().fade(1);	
				delay(0);
			}
			break;
		case 13:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(boss);
				
				player.setX(12 * Tile.TILE_WIDTH - 32);
				player.setY(14.5f * Tile.TILE_WIDTH);
				player.setDirection(0);
				eManager.addEntity(chest);
				eManager.addEntity(artifact);
				artifact.setBounds(new Rectangle(20, 14, 20, 46));
				handler.getGame().getGameState().getEffects().fade(0);
				delay(0);
			}
			break;
		case 14:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				delay(0);
			}
			break;
		case 15:
			if(artifact.isObtained() && !handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setState("IDLE");
				delay(500);
			}
			break;
		case 16:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setState("CHASE");
				eManager.removeEntity(artifact);
				eManager.addEntity(portal);
				delay(500);
			}
			break;
		case 17:	
			operation = 0;
			player.setState("CHASE");
			handler.getBaseCamp().setDungeonsCleared(2);
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(7);
			running = false;
			break;
		}
	}
}
