package com.base.game.entity.staticEntity;

import java.awt.Graphics;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;
import com.base.game.tiles.Tile;

public class Ooze extends StaticEntity
{
	public Ooze(Handler handler, float x, float y, int layer) {
		super(handler, x, y, layer, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		renderOrder = 1;
		damagesPlayerOnImpact = true;
		isWalkable = true;
		currentAnimation = new Animation(150, Assets.ooze, 1);
	}

	int duration = 0;
	@Override
	public void update()
	{
		currentAnimation.update();	
		
		if(currentAnimation.isComplete())
		{
			duration++;
			currentAnimation.reset();
		}
		
		if(duration > 5)
		{
			handler.getGame().geteManager().getEntities().remove(this);
		}
	}
	
	public void damageEntity(Entity e)
	{
		e.setStatusCondition("POISONED");
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
	}
}
