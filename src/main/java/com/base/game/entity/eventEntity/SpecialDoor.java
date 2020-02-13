package com.base.game.entity.eventEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Arrays;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Entity;

public class SpecialDoor extends EventEntity
{
	private int selector = 1;
	
	public SpecialDoor(Handler handler, int x, int y, int layer)
	{
		super(handler, x, y, layer, 192, 192);
		on = false;
		eventSpace = getCollisionBounds(0, 0);
		setBounds(new Rectangle(0,0,0,0));
	}
	
	public void update()
	{		
		//System.out.println(state);
		if(handler.getGame().getPlayer().getCollisionBounds(0, 0).intersects(eventSpace) && on)
		{
			state = "DUNGEONSELECTION";
			handler.getGame().getGameState().getEffects().fade(.5f);
			on = false;
			handler.getGame().geteManager().getPlayer().setState("IDLE");
		}
		
		if(!handler.getGame().geteManager().getPlayer().getCollisionBounds(0, 0).intersects(eventSpace))
		{
			state = null;
			on = true;
			selector = 1;
		}
		
		if(state == "DUNGEONSELECTION")
		{
			handler.getGame().getGameState().getEffects().selectDungeon(selector, handler.getBaseCamp().getDungeonsUnlocked());
			
			if(handler.getInput().a)
			{				
				if(selector <= handler.getBaseCamp().getDungeonsUnlocked())
				{
					state = "SELECTED";
					handler.getGame().getGameState().getEffects().setSecondState("");
				}
			}
			else if(handler.getInput().d)
			{
				state = null;
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getGame().getGameState().getEffects().setSecondState("");
				handler.getGame().geteManager().getPlayer().moveTo(handler.getLevel().geteManager().getPlayer().getX(), handler.getLevel().geteManager().getPlayer().getY() - 64);
				handler.getGame().getGameState().getEffects().setAlpha(0);
				handler.getGame().geteManager().getPlayer().setForceMove("UP");		
			}
			else if(handler.getInput().leftPressed && selector > 1)
				selector--;
			else if(handler.getInput().rightPressed && selector < Assets.elements.length-1)
				selector++;
		}
		else if(state == "SELECTED")
		{
			handler.getGame().geteManager().getPlayer().setForceMove("DOWN", "DOWN", "DOWN");
			handler.getGame().getGameState().getLevelManager().setCurrentDungeon(selector-1);
			state = null;
		}
	}

	
	@Override
	public void render(Graphics g) 
	{	
		//g.setColor(Color.red);
		//g.fillRect((int)(eventSpace.x -handler.getCamera().getxOffset()), (int)(eventSpace.y -handler.getCamera().getyOffset()), eventSpace.width, eventSpace.height);	
		
	}
	
}
