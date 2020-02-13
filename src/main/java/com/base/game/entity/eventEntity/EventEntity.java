package com.base.game.entity.eventEntity;

import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;

public abstract class EventEntity extends Creature
{
	protected Rectangle eventSpace;
	
	public EventEntity(Handler handler, float x, float y, int layer, int width, int height)
	{
		super(handler, x, y, layer, width, height);
		setCanBeKnkBack(false);
	}
	
	public Rectangle getEventSpace() {return eventSpace;}
	public void setEventSpace(Rectangle eventSpace) {this.eventSpace = eventSpace;}		
	
}
