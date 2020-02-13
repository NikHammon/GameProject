package com.base.game.entity.staticEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.eventEntity.EventEntity;

public class Door extends EventEntity
{
	private String nextRoom;
	private Animation doorOpening, doorClosing;
	
	public Door(Handler handler, int x, int y, int layer, String nextRoom)
	{
		super(handler, x, y, layer, 64, 128);
		this.nextRoom = nextRoom;
		on = false;
		renderOrder = 1;
		
		doorOpening = new Animation(100, Assets.woodDoorOpening, 1);
		doorClosing = new Animation(100, Assets.woodDoorClosing, 1);
		
		eventSpace = new Rectangle(576, 1728, 64, 2);
		
		currentAnimation = doorOpening;
	}
	
	public void update()
	{		
		if(handler.getGame().getPlayer().getCollisionBounds(0,0).intersects(eventSpace) && state == "" && handler.getBaseCamp().getGameProgress() > 2 && !handler.getBaseCamp().isEventRunning())
		{
			handler.getGame().getPlayer().setForceMove("UP");
			handler.getGame().getGameState().getEffects().fade(1);
			state = "OPENING";
		}
		if(state == "OPENING")
		{
			currentAnimation.update();
			
			if(currentAnimation.isComplete())
			{	
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setNextArea(nextRoom);
				currentAnimation = doorClosing;
				doorOpening.reset();
				state = "";
			}
		}
		else if(state == "CLOSING")
		{
			currentAnimation = doorClosing;
			currentAnimation.update();
			
			if(currentAnimation.isComplete())
			{	
				currentAnimation = doorOpening;
				doorClosing.reset();
				state = "";
			}
		}
		
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);		
	}

}
