package com.base.game.event;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.Player;
import com.base.game.entity.eventEntity.Portal;
import com.base.game.entity.eventEntity.TreasureChest;
import com.base.game.entity.eventEntity.NPC.Budaroth;
import com.base.game.entity.eventEntity.NPC.CrawfordNPC;
import com.base.game.entity.eventEntity.NPC.Dollface;
import com.base.game.entity.eventEntity.NPC.Drace;
import com.base.game.entity.eventEntity.NPC.Guardian;
import com.base.game.entity.eventEntity.NPC.Rubel;
import com.base.game.entity.eventEntity.NPC.Serii;
import com.base.game.entity.monsters.D1Boss;
import com.base.game.entity.monsters.D8Boss;
import com.base.game.entity.staticEntity.Beam;
import com.base.game.entity.staticEntity.Genoblade;
import com.base.game.tiles.Tile;

public class D8Event extends Event
{
	public D8Event(Handler handler)
	{
		super(handler);
		eventSpace = new Rectangle(0, 0, 0, 0);
	}

	@Override
	public boolean meetsRequirements() 
	{
		if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 23)
		{
			eManager = handler.getGame().geteManager();
			player = handler.getGame().getPlayer();
			return true;
		}
		
		return false;
	}

	Genoblade gBlade = new Genoblade(handler, 12f * Tile.TILE_WIDTH - 45, 7f * Tile.TILE_HEIGHT, 2);
	Beam beam = new Beam(handler, 12f * Tile.TILE_WIDTH - 32, 8.5f * Tile.TILE_HEIGHT, 2);
	Guardian guardian = new Guardian(handler, 12f * Tile.TILE_WIDTH - 100, 12f * Tile.TILE_HEIGHT, 2);
	D8Boss boss = new D8Boss(handler, 12f * Tile.TILE_WIDTH, 12f * Tile.TILE_HEIGHT, 2);
	Portal portal = new Portal(handler, 12f * Tile.TILE_WIDTH - 64, 12f * Tile.TILE_HEIGHT, 2);
	TreasureChest chest = new TreasureChest(handler, 12f * Tile.TILE_WIDTH - 32, 4 * Tile.TILE_HEIGHT, 2, 2, "HEARTCRYSTAL");
	Budaroth budaroth = new Budaroth(handler, 13 * Tile.TILE_WIDTH, 20 * Tile.TILE_HEIGHT, 2);
	Drace drace = new Drace(handler, 13 * Tile.TILE_WIDTH-36, 20.5f * Tile.TILE_HEIGHT, 2);
	Rubel rubel = new Rubel(handler, 11 * Tile.TILE_WIDTH-36, 20.5f * Tile.TILE_HEIGHT, 2);
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
			handler.getGame().geteManager().addEntity(budaroth);
			handler.getGame().geteManager().addEntity(gBlade);
			budaroth.setDoesNotMove(true);
			budaroth.setCurrentAnimation(budaroth.dwnLft);
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
				handler.getGame().getGameState().getEffects().displayDialog(144);
				delay(500);
			}
			break;
		case 3:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setDirection(0);
				eManager.addEntity(guardian);
				guardian.setDoesNotMove(true);
				boss.setState("IDLE");
				player.setCameraActive(false);
				delay(500);
			}
			break;
		case 4:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getCamera().scrawl(guardian.getX() - handler.getGame().getWidth() / 2 + guardian.getWidth() / 2, guardian.getY() - handler.getGame().getHeight() / 2 + guardian.getHeight() / 2))
			{
				handler.getGame().getGameState().getEffects().displayDialog(145);
				delay(500);
			}
			break;
		case 5:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setForceMove("UP", "UP", "UP", "UP", "UP", "UP", "UP");
				delay(500);
			}
			break;
		case 6:
			if(player.getState() != "FORCEMOVE")
			{ 
				player.setState("IDLE");
				if(handler.getCamera().scrawl(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2, player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2))
				{
					eManager.removeEntity(budaroth);
					player.setDirection(7);
					handler.getGame().getGameState().getEffects().displayDialog(146);
					delay(500);
				}
			}
			break;
		case 7:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setState("CHASE");
				eManager.removeEntity(guardian);
				eManager.addEntity(boss);
				boss.setState("CHASE");
				delay(500);
			}
			break;
		case 8:
			if(boss.getState() == "DEFEATED")
			{
				handler.getGame().getGameState().getEffects().fade(1);	
				player.setState("IDLE");
				delay(500);
			}
			break;
		case 9:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(boss);
				
				handler.getGame().geteManager().addEntity(guardian);
				guardian.setDoesNotMove(true);
				
				player.setX(12 * Tile.TILE_WIDTH);
				player.setY(14.5f * Tile.TILE_WIDTH);
				player.setDirection(7);
				handler.getGame().getGameState().getEffects().fade(0);
				delay(0);
			}
			break;
		case 10:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				handler.getGame().getGameState().getEffects().displayDialog(147);
				delay(0);
			}
			break;
		case 11:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				player.setExpressionAnimation(shocked, -5, -30);
				handler.getGame().getGameState().getEffects().displayDialog(148);
				delay(0);
			}
			break;
		case 12:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				eManager.addEntity(budaroth);
				budaroth.setCurrentAnimation(budaroth.upLft);
				budaroth.setForceMove("UP", "UP", "UP", "UP", "UP", "UP");
				delay(0);
			}
			break;
		case 13:
			if(budaroth.getState() != "FORCEMOVE")
			{
				handler.getGame().getGameState().getEffects().displayDialog(149);
				player.setCameraActive(false);
				delay(0);
			}
			break;
		case 14:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				guardian.setCurrentAnimation(guardian.upLft);
				eManager.addEntity(beam);
				delay(0);	
			}
			break;
		case 15:
			if(handler.getCamera().scrawl(gBlade.getX() - handler.getGame().getWidth() / 2 + gBlade.getWidth() / 2, gBlade.getY() - handler.getGame().getHeight() / 2 + gBlade.getHeight() / 2))
			{
				gBlade.genobladeDest.reset();
				gBlade.setCurrentAnimation(gBlade.genobladeDest);
				delay(0);
			}
			break;
		case 16:
			if(gBlade.genobladeDest.isComplete())
			{
				handler.getGame().getGameState().getEffects().whiteOut(1);
				handler.getGame().getGameState().getEffects().displayDialog(150);
				delay(0);
			}
			break;
		case 17:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox() && handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(budaroth);
				eManager.removeEntity(guardian);
				eManager.removeEntity(beam);
				eManager.removeEntity(gBlade);
				player.setX(player.getX() - 32);
				player.setCurrentAnimation(player.playerRise);
				player.setDoNotUpdate(true);
				player.setDoNotRenderShadow(true);
				eManager.addEntity(drace);
				drace.setDoesNotMove(true);
				eManager.addEntity(rubel);
				rubel.setDoesNotMove(true);
				
				handler.getCamera().setxOffset(player.getX() - handler.getGame().getWidth() / 2 + player.getWidth() / 2);
				handler.getCamera().setyOffset(player.getY() - handler.getGame().getHeight() / 2 + player.getHeight() / 2);
				
				handler.getGame().getGameState().getEffects().whiteOut(0);
				delay(0);
			}
			break;
		case 18:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 0)
			{
				drace.setForceMove("UP", "UP", "UP", "UP", "UP");
				rubel.setForceMove("UP", "UP", "UP", "UP", "UP");
				delay(0);
			}
			break;
		case 19:
			if(drace.getState() != "FORCEMOVE")
			{
				handler.getGame().getGameState().getEffects().displayDialog(151);
				delay(0);
			}
			break;
		case 20:
			if(!handler.getGame().getGameState().getEffects().isActiveDBox())
			{
				handler.getGame().getGameState().getEffects().fade(1);
				delay(0);
			}
			break;
		case 21:
			if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
			{
				eManager.removeEntity(drace);
				eManager.removeEntity(rubel);
				eManager.addEntity(chest);
				eManager.addEntity(portal);
				operation = 0;
				player.setState("CHASE");
				handler.getBaseCamp().setDungeonsCleared(8);
				handler.getGame().getGameState().getLevelManager().setInDungeon(false);
				handler.getGame().getGameState().getLevelManager().getDungeons().get(handler.getGame().getGameState().getLevelManager().getNumCurrentDungeon()).setCurrentFloorNum(0);
				handler.getGame().geteManager().getPlayer().equip(player);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("CASTLEAREA");
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setNPCs();
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setBarriers();
				handler.getGame().getPlayer().setX(800);
				handler.getGame().getPlayer().setY(1050);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().getEvents().get(18).setRunning();
				running = false;
				delay(0);
			}
			break;
		}
	}
}
