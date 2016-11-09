package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.eventEntity.TreasureChest;
import com.base.game.entity.eventEntity.NPC.Budaroth;
import com.base.game.entity.eventEntity.NPC.Dollface;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.eventEntity.NPC.Serii;
import com.base.game.entity.monsters.D1Boss;
import com.base.game.entity.monsters.D4Boss;
import com.base.game.tiles.Tile;

public class D4Event extends Event
{
	public D4Event(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 13)
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Budaroth budaroth = new Budaroth(handler, 10f * Tile.TILE_WIDTH - 40, 12f * Tile.TILE_HEIGHT, 2);
	Dollface dollface = new Dollface(handler, 13.5f * Tile.TILE_WIDTH - 36, 8f * Tile.TILE_HEIGHT, 2);
	D4Boss boss = new D4Boss(handler, 12f * Tile.TILE_WIDTH - 120, 5f * Tile.TILE_HEIGHT, 2);
	Serii serii = new Serii(handler, 13 * Tile.TILE_WIDTH, 20 * Tile.TILE_HEIGHT, 2);
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
			handler.getGame().geteManager().addEntity(serii);
			serii.setDoesNotMove(true);
			serii.setDoNotRenderShadow(true);
			serii.rise.reset();
			serii.setCurrentAnimation(serii.rise);
			serii.setDoNotUpdate(true);
			serii.setDirection(5);
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
				handler.getGame().getGameState().getEffects().displayDialog(89);
				delay(0);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setDirection(0);
				eManager.addEntity(budaroth);
				budaroth.setDoesNotMove(true);
				player.setCameraActive(false);
				delay(0);
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(budaroth.getX() - handler.getGame().getWidth() / 2 + budaroth.getWidth() / 2, budaroth.getY() - handler.getGame().getHeight() / 2 + budaroth.getHeight() / 2))
			{
				player.setDirection(0);
				handler.getGame().getGameState().getEffects().displayDialog(90);
				delay(0);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setForceMove("UP", "UP", "UP", "UP", "UP", "UP", "UP");
				delay(0);
			}
			break;
		case 6:
			if(player.getState() != "FORCEMOVE")
			{ 
				player.setState("IDLE");
				if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
				{
					player.setDirection(7);
					eManager.removeEntity(serii);
					handler.getGame().getGameState().getEffects().displayDialog(91);
					delay(0);
				}
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setExpressionAnimation(shocked, -5, -30);
				handler.getGame().getGameState().getEffects().displayDialog(92);
				delay(0);
			}
			break;
		case 8:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				eManager.addEntity(dollface);
				dollface.setDoesNotMove(true);
				dollface.setForceMove("DOWN", "DOWN", "DOWN", "DOWN");
				delay(0);
			}
			break;
		case 9:
			if(dollface.getState() != "FORCEMOVE")
			{
				player.setDirection(1);
				handler.getGame().getGameState().getEffects().displayDialog(93);
				delay(0);
			}
			break;
		case 10:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setDirection(7);
				handler.getGame().getGameState().getEffects().displayDialog(94);	
				delay(0);
			}
			break;
		case 11:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				eManager.addEntity(boss);
				boss.setState("IDLE");
				player.setDirection(0);
				
				delay(0);
			}
			break;
		case 12:
			if(handler.getCamera().scrawl(boss.getX() - handler.getGame().getWidth() / 2 + boss.getWidth() / 2, boss.getY() - handler.getGame().getHeight() / 2 + boss.getHeight() / 2))
			{
				handler.getGame().getGameState().getEffects().displayDialog(95);	
				
				delay(0);
			}
			break;
		case 13:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{
				handler.getGame().getGameState().getEffects().displayDialog(96);
				delay(0);
			}
			break;
		case 14:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().smokescreen();
				delay(0);
			}
			break;
		case 15:
			if(!handler.getGame().getGameState().getEffects().isRenderSmokeScreen())
			{
				eManager.removeEntity(budaroth);
				eManager.removeEntity(dollface);
				player.setState("CHASE");
				boss.setState("CHASE");
				delay(0);
			}
			break;
		case 16:
			if(boss.getState() == "DEFEATED")
			{
				eManager.removeEntity(boss);
				
				player.setState("IDLE");
				handler.getGame().getGameState().getEffects().fade(1);
				delay(0);
			}
			break;
		case 17:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				player.setX(12 * Tile.TILE_WIDTH - 32);
				player.setY(14.5f * Tile.TILE_WIDTH);
				player.setDirection(0);
				eManager.addEntity(portal);
				eManager.addEntity(chest);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(0);
			}
		case 18:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				operation = 0;
				player.setState("CHASE");
				handler.getBaseCamp().setDungeonsCleared(4);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(14);
				running = false;
			}
			break;
		}
		
	}
}
