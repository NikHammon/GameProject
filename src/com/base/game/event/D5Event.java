package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.eventEntity.TreasureChest;
import com.base.game.entity.eventEntity.NPC.Dollface;
import com.base.game.entity.eventEntity.NPC.Obin;
import com.base.game.entity.eventEntity.NPC.Sebastian;
import com.base.game.entity.monsters.D1Boss;
import com.base.game.entity.monsters.D5Boss;
import com.base.game.tiles.Tile;

public class D5Event extends Event
{
	public D5Event(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 16)
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	D5Boss boss = new D5Boss(handler, 12f * Tile.TILE_WIDTH - 36, 14 * Tile.TILE_HEIGHT, 2);
	Obin obin = new Obin(handler, 12f * Tile.TILE_WIDTH - 54, 4 * Tile.TILE_HEIGHT, 2);
	Dollface dollface = new Dollface(handler, 12 * Tile.TILE_WIDTH - 36, 14 * Tile.TILE_HEIGHT, 2);
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
			handler.getGame().geteManager().addEntity(obin);
			obin.setDoesNotMove(true);
			obin.setDirection(0);
			player.setDirection(0);
			delay(500);
			break;
		case 1:
			if(handler.getGame().getGameState().getEffects().getAlpha() <= .5)
			{
				player.setForceMove("UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP", "UP");
				delay(500);
			}
			break;
		case 2:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				handler.getGame().getGameState().getEffects().displayDialog(104);
				delay(500);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				obin.setDirection(4);
				player.setExpressionAnimation(embarassed, 35, 10);
				handler.getGame().getGameState().getEffects().displayDialog(105);
				delay(500);
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setDirection(4);
				player.setExpressionAnimation(shocked, -5, -30);
				obin.setExpressionAnimation(shocked, -5, -30);
				handler.getGame().getGameState().getEffects().displayDialog(106);
				eManager.addEntity(dollface);
				dollface.setDoesNotMove(true);
				dollface.setDirection(0);
				player.setCameraActive(false);
				delay(500);
			}
			break;
		case 5:
			if(handler.getCamera().scrawl(dollface.getX() - handler.getGame().getWidth() / 2 + dollface.getWidth() / 2, dollface.getY() - handler.getGame().getHeight() / 2 + dollface.getHeight() / 2))
			{	
				handler.getGame().getGameState().getEffects().thunderStorm();
				handler.getGame().getGameState().getEffects().setLightningStorm(true);
				player.setForceMove("DOWN", "DOWN", "DOWN", "DOWN", "DOWN");
				delay(500);
			}	
			break;
		case 6:
			if(player.getState() != "FORCEMOVE")
			{
				player.setState("IDLE");
				handler.getGame().getGameState().getEffects().displayDialog(107);
				delay(500);
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
			{	
				eManager.removeEntity(dollface);
				handler.getGame().getGameState().getEffects().setLightningStorm(false);
				eManager.removeEntity(obin);
				eManager.addEntity(boss);
				player.setState("CHASE");
				boss.setState("CHASE");
				delay(500);
			}
			break;
		case 8:
			if(boss.getState() == "DEFEATED")
			{
				eManager.removeEntity(boss);
				handler.getGame().getGameState().getEffects().fade(1);	
				player.setState("IDLE");
				delay(500);
			}
			break;
		case 9:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				player.setX(12 * Tile.TILE_WIDTH - 32);
				player.setY(5 * Tile.TILE_WIDTH);
				player.setDirection(0);
				player.setLayer(2);
				
				eManager.addEntity(dollface);
				handler.getGame().getGameState().getEffects().setLightningStorm(true);
				dollface.setX(12 * Tile.TILE_WIDTH - 36);
				dollface.setY(2 * Tile.TILE_WIDTH);
				dollface.setDirection(4);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(500);
			}
			break;
		case 10:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				handler.getGame().getGameState().getEffects().displayDialog(108);
				delay(500);
			}
			break;
		case 11:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				dollface.attack.reset();
				dollface.setDoNotUpdate(true);
				dollface.setCurrentAnimation(dollface.attack);
				obin.setX(20 * Tile.TILE_WIDTH);
				obin.setY(2 * Tile.TILE_WIDTH);
				eManager.addEntity(obin);
				obin.setForceMove("LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT");
				delay(500);
			}
			break;
		case 12:
			if(dollface.attack.isComplete())
			{
				handler.getGame().getGameState().getEffects().whiteOut(1);
				delay(500);
			}
			else
				dollface.attack.update();
			break;
		case 13:	
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(dollface);
				handler.getGame().getGameState().getEffects().settStormState("FADE");
				handler.getGame().getGameState().getEffects().setLightningStorm(false);
				handler.getGame().getGameState().getEffects().displayDialog(109);
				delay(500);
			}
			break;
		case 14:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().whiteOut(0);
				obin.setForceMove("LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT");
				delay(500);
			}
			break;
		case 15:
			if(obin.getState() != "FORCEMOVE")
			{
				obin.setX(12 * Tile.TILE_WIDTH - 54);
				obin.setY(0 * Tile.TILE_WIDTH);
				obin.setForceMove("DOWN", "DOWN");
				delay(500);
			}
			break;
		case 16:
			if(obin.getState() != "FORCEMOVE")
			{
				handler.getGame().getGameState().getEffects().displayDialog(110);
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
				eManager.removeEntity(obin);

				eManager.addEntity(portal);
				eManager.addEntity(chest);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(500);
			}
			break;
		case 19:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				operation = 0;
				player.setState("CHASE");
				handler.getBaseCamp().setDungeonsCleared(5);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(17);
				running = false;
			}
			break;
		}
	}
}
