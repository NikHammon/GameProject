package com.base.game.entity;

import com.base.game.Assets;
import com.base.game.Handler;

public class PressureSwitch extends Switch
{
	
	public PressureSwitch(Handler handler, float x, float y, int layer, int id) {
		super(handler, x, y, layer, id);
		bounds.x = 10;
		bounds.y = 32;
		bounds.width = 36;
		bounds.height = 22;
		switchOn = Assets.switchOn;
		switchOff = Assets.switchOff;
		
		renderOrder = 1;
	}

	
	Entity activeEntity;
	@Override
	public void update()
	{
		for(Entity e : handler.getLevel().geteManager().entities)
		{
			if(e == this)
				continue;
			if(e.getCollisionBounds(0, 0).intersects(getCollisionBounds(0,0)))
			{
				activeEntity = e;
				on = true;
			}
		}
		if(activeEntity != null && !(activeEntity.getCollisionBounds(0, 0).intersects(getCollisionBounds(0,0))))
			on = false;
			
		super.update();
	}

}
