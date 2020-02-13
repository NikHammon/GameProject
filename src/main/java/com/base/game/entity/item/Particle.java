package com.base.game.entity.item;

import java.awt.Graphics;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.HitSwitch;
import com.base.game.entity.attacks.Ice;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.staticEntity.StaticEntity;

public class Particle extends Entity
{
	
	public Particle(Handler handler, float x, float y, int layer) {
		super(handler, x, y, layer, 32, 32);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	public void raiseIce()
	{
		handler.getGame().geteManager().addEntity(new Ice(handler, handler.getGame().getPlayer(), x, y, layer));
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.split[0], (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		
	}

}
