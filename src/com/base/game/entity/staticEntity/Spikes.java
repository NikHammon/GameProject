package com.base.game.entity.staticEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.monsters.Monster;
import com.base.game.tiles.Tile;

public class Spikes extends StaticEntity
{	
	private int damage, knockBack;
	private Animation up, down;
	
	public Spikes(Handler handler, float x, float y, int layer, int id) 
	{
		super(handler, x, y, layer, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		bounds.x = 11;
		bounds.y = 9;
		bounds.width = 42;
		bounds.height = 34;
		damage = 1;
		knockBack = 100;
		this.id = id;
		renderOrder = 1;
		damagesPlayerOnImpact = true;
		
		up = new Animation(150, Assets.spikesUp, 1);
		down = new Animation(150, Assets.spikesDown, 1);
		
		currentAnimation = down;
	}

	@Override
	public void update()
	{
		currentAnimation.update();
		if(on != false)
		{
			currentAnimation = down;
			up.reset();
			damagesPlayerOnImpact = false;
			isWalkable = true;
		}
		else
		{
			currentAnimation = up;
			down.reset();
			damagesPlayerOnImpact = true;
			isWalkable = false;
		}
	}

	@Override
	public void render(Graphics g)
	{
		g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
//		g.setColor(Color.magenta);
//		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
	}

	public boolean isActive(){return on;}
	public void setActive(boolean active) {this.on = active;}

	public void damageEntity(Entity e)
	{
		Creature c = ((Creature)e);
		c.takeDamage(damage);
		
		if(c.getHealth() > 0)
			c.setKnockBack((c.getX()-x)/3, (c.getY()-y)/3, knockBack);
	}
		
}
