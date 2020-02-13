package com.base.game.entity.eventEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;
import com.base.game.entity.staticEntity.StaticEntity;
import com.base.game.tiles.Tile;

public class Energy extends DroppedItem
{
	private int energy;

	public Energy(Handler handler, float x, float y, int layer, int energy, int direction) {
		super(handler, x, y, layer, 32, 32, direction);
		setBounds(new Rectangle(4, 3, 24, 25));
		
		eventSpace = getCollisionBounds(0, 0);
		
		renderOrder = 2;
		this.energy = energy;

		currentAnimation = new Animation(300, Assets.energy, 0);

	}

	Player player;
	@Override
	public void update()
	{
		if(state == "SPAWNING")
			spawn();
		
		currentAnimation.update();
		
		if(eventSpace.intersects(handler.getGame().geteManager().getPlayer().getCollisionBounds(0, 0)))
		{
			handler.getGame().geteManager().removeEntity(this);	
			handler.getGame().getPlayer().addHealth(energy);;		
		}
		
		eventSpace = getCollisionBounds(0, 0);
		
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
	}

}