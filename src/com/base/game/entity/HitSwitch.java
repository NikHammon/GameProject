package com.base.game.entity;

import com.base.game.Assets;
import com.base.game.Handler;

public class HitSwitch extends Switch
{		
	public HitSwitch(Handler handler, float x, float y, int layer, int id) {
		super(handler, x, y, layer, id);
		bounds.x = 10;
		bounds.y = 32;
		bounds.width = 36;
		bounds.height = 22;
		switchOn = Assets.switchOn;
		switchOff = Assets.switchOff;
		
	}
	
}
