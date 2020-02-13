package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.eventEntity.TreasureChest;
import com.base.game.entity.eventEntity.NPC.Cassiopia;
import com.base.game.entity.eventEntity.NPC.Ken;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.monsters.D1Boss;
import com.base.game.entity.monsters.Spider;
import com.base.game.tiles.Tile;

public class D1Event extends Event
{
	public D1Event(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 3)
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	D1Boss boss = new D1Boss(handler, 12f * Tile.TILE_WIDTH - 120, 12f * Tile.TILE_HEIGHT, 2);
	Sebastian sebastian = new Sebastian(handler, 13 * Tile.TILE_WIDTH, 20 * Tile.TILE_HEIGHT, 2);
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
			handler.getGame().geteManager().addEntity(sebastian);
			sebastian.setDoesNotMove(true);
			sebastian.setDoNotRenderShadow(true);
			sebastian.rise.reset();
			sebastian.setCurrentAnimation(sebastian.rise);
			sebastian.setDoNotUpdate(true);
			sebastian.setDirection(5);
			delay(500);
			break;
		case 1:
			if(handler.getGame().getGameState().getEffects().getAlpha() <= .5)
			{
				player.setForceMove("UP");
				delay(500);
			}
			break;
		case 2:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				player.setDirection(1);
				handler.getGame().getGameState().getEffects().displayDialog(46);
				delay(500);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setDirection(4);
				eManager.addEntity(boss);
				player.setCameraActive(false);
				handler.getGame().getGameState().getEffects().displayDialog(47);
				delay(500);
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(boss.getX() - handler.getGame().getWidth() / 2 + boss.getWidth() / 2, boss.getY() - handler.getGame().getHeight() / 2 + boss.getHeight() / 2))
			{
				player.setDirection(0);
				handler.getGame().getGameState().getEffects().displayDialog(48);
				delay(500);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				player.setState("CHASE");
				boss.setState("CHASE");
				delay(0);
			}
			break;
		case 6:
			if(boss.getState() == "DEFEATED")
			{
				handler.getGame().getGameState().getEffects().fade(1);	
				player.setState("IDLE");
				player.setCameraActive(false);
				delay(0);
			}
			break;
		case 7:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(boss);
				
				player.setX(10 * Tile.TILE_WIDTH);
				player.setY(14.5f * Tile.TILE_WIDTH);
				player.setDirection(3);
				eManager.addEntity(portal);
				eManager.addEntity(chest);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(0);
			}
			break;
		case 8:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				delay(0);
			}
			break;
		case 9:
			if(handler.getCamera().scrawl(chest.getX() - handler.getGame().getWidth() / 2 + chest.getWidth() / 2, chest.getY() - handler.getGame().getHeight() / 2 + chest.getHeight() / 2))
			{
				delay(2000);
			}
			break;
		case 10:
			if(handler.getCamera().scrawl(sebastian.getX() - handler.getGame().getWidth() / 2 + sebastian.getWidth() / 2, sebastian.getY() - handler.getGame().getHeight() / 2 + sebastian.getHeight() / 2))
			{
				
				if(sebastian.rise.isComplete())
				{
					sebastian.rise.reset();
					sebastian.setDoNotRenderShadow(false);
					sebastian.setDoNotUpdate(false);
					if(player.getX() < sebastian.getX())
					{
						sebastian.setDirection(7);
						player.setDirection(3);
					}
					else
					{
						sebastian.setDirection(1);
						player.setDirection(5);
					}
					handler.getGame().getGameState().getEffects().displayDialog(49);
					delay(0);
				}
				else
					sebastian.rise.update();
				
			}
			break;
		case 11:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				sebastian.setForceMove("UP", "UP", "UP", "UP", "UP");
				delay(0);
			}
			break;
		case 12:
			if(sebastian.getState() != "FORCEMOVE")
			{
				eManager.removeEntity(sebastian);
				delay(0);
			}
			break;
		case 13:
			if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				operation = 0;
				player.setState("CHASE");
				handler.getBaseCamp().setDungeonsCleared(1);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(4);
				running = false;
			}
			break;
		}
	}
}
