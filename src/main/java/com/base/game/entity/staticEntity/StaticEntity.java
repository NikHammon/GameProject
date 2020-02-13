package com.base.game.entity.staticEntity;

import java.awt.image.BufferedImage;

import com.base.game.Handler;
import com.base.game.entity.Entity;

public abstract class StaticEntity extends Entity
{
	protected BufferedImage myImage;
	
	public StaticEntity(Handler handler, float x, float y, int layer, int width, int height)
	{
		super(handler, x, y, layer, width, height);
		setCanBeKnkBack(false);
	}
	
	public void updateAttackBounds()
	{
		attackBounds = getCollisionBounds(-handler.getCamera().getxOffset(), -handler.getCamera().getyOffset());
		
		attackBounds.x = attackBounds.x - 3;
		attackBounds.y = attackBounds.y - 3;
		attackBounds.width = attackBounds.width + 6;
		attackBounds.height = attackBounds.height + 6;

	}
	
	public BufferedImage getMyImage() {
		return myImage;
	}

	public void setMyImage(BufferedImage myImage) {
		this.myImage = myImage;
	}
}
