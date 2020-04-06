package com.base.game.entity.eventEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Player;

public class Portal extends EventEntity
{
	private int event;
	
	public Portal(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 128, 128);
		eventSpace = getCollisionBounds(0, 0);
		renderOrder = 2;
		currentAnimation = new Animation(100, Assets.portal, 0);
	}
	
	Player oldPlayer;
	public void update()
	{
		currentAnimation.update();
		if(handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(eventSpace))
		{
			switch(event)
			{
			case -1:
				handler.getGame().getPlayer().setState("IDLE");
				event++;
				break;
			case 0:
				handler.getGame().getGameState().getEffects().fade(1);
				
				if(handler.getGame().getGameState().getEffects().getAlpha() == 1)
					event++;
				break;
			case 1:
				oldPlayer = handler.getGame().getPlayer();
				// handler.getGame().getGameState().getLevelManager().getDungeons().get(handler.getGame().getGameState().getLevelManager().getNumCurrentDungeon()).setCurrentFloorNum(0);
				handler.getGame().getGameState().getLevelManager().setInDungeon(false);
				handler.getGame().getGameState().getEffects().fade(0);
				
				if(handler.getBaseCamp().getQuestTracker() == -1)
				{
					if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 4)
					{
						handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("CASTLEAREA");
						handler.getGame().getPlayer().setX(800);
						handler.getGame().getPlayer().setY(1480);
						handler.getGame().getGameState().getLevelManager().getBaseCamp().getEvents().get(3).setRunning();
					}
					else if(handler.getBaseCamp().getGameProgress() == 7)
					{
						handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("CASTLEAREA");
						handler.getGame().getPlayer().setX(800);
						handler.getGame().getPlayer().setY(990);
						handler.getGame().getGameState().getLevelManager().getBaseCamp().getEvents().get(6).setRunning();
					}
					else if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 11)
					{
						handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("MAINAREA");
						handler.getGame().getPlayer().setX(860);
						handler.getGame().getPlayer().setY(2600);
						handler.getGame().getGameState().getLevelManager().getBaseCamp().getEvents().get(9).setRunning();
					}
					else if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 14)
					{
						handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("CASTLEAREA");
						handler.getGame().getPlayer().setX(800);
						handler.getGame().getPlayer().setY(1480);
						handler.getGame().getGameState().getLevelManager().getBaseCamp().getEvents().get(11).setRunning();
					}
					else if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 17)
					{
						handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("CASTLEAREA");
						handler.getGame().getPlayer().setX(800);
						handler.getGame().getPlayer().setY(1480);
						handler.getGame().getGameState().getLevelManager().getBaseCamp().getEvents().get(13).setRunning();
					}
					else if(handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress() == 22)
					{
						handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("MAINAREA");
						handler.getGame().getPlayer().setX(1000);
						handler.getGame().getPlayer().setY(2600);
						handler.getGame().getGameState().getLevelManager().getBaseCamp().getEvents().get(17).setRunning();
					}
					else
					{
						handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("BEDROOM");
						handler.getGame().getPlayer().setX(252);
						handler.getGame().getPlayer().setY(244);
					}
				}
				else
				{
					handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("BEDROOM");
					handler.getGame().getPlayer().setX(252);
					handler.getGame().getPlayer().setY(244);
				}
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setBarriers();
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setNPCs();
				handler.getGame().geteManager().getPlayer().equip(oldPlayer);
				event = -1;
				break;
			}
		}
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
		
	}

}
