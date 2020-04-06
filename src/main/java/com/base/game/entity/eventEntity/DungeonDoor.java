package com.base.game.entity.eventEntity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.staticEntity.StaticEntity;

public class DungeonDoor extends EventEntity
{
	public DungeonDoor(Handler handler, int x, int y, int layer)
	{
		super(handler, x, y, layer, 128, 128);
		renderOrder = 1;
		currentAnimation = new Animation(150, Assets.hole, 1);
		setBounds(new Rectangle(40,40,55,50));
		eventSpace = getCollisionBounds(0, 0);
		setBounds(new Rectangle(0,0,0,0));
	}

	@Override
	public void update() {
		if(handler.getLevel().geteManager().getPlayer().getCollisionBounds(0, 0).intersects(eventSpace)) {
			currentAnimation.update();
			handler.getLevel().geteManager().getPlayer().setDoNotRender(true);
			handler.getLevel().geteManager().getPlayer().setDoNotUpdate(true);
			handler.getGame().getGameState().getLevelManager().setCurrentDungeon(handler.getGame().getPlayer().getCurrentDungeon());
		}
	}

	@Override
	public void render(Graphics g) 
	{
		g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		//g.fillRect((int)(eventSpace.x- handler.getCamera().getxOffset()), (int)(eventSpace.y- handler.getCamera().getyOffset()), eventSpace.width, eventSpace.height);
		
	}
}
