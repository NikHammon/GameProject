package com.base.game.entity.attacks;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.staticEntity.Breakables;
import com.base.game.entity.staticEntity.StaticEntity;

public class Explosion extends Attack
{

	public Explosion(Handler handler, Entity user, float x, float y, int layer) {
		super(handler, user, x, y, layer, 160, 200);
		bounds = new Rectangle(0,0,0,0);
		setAttackBounds(new Rectangle(20, 124, 100, 76));
		currentAnimation =  new Animation(150, Assets.explosion, 1);
		
		damage = 10;
		knockBack = 40;		
		
	}

	@Override
	public void update() 
	{	
		currentAnimation.update();
		
		if(currentAnimation.isComplete())
		{
			handler.getLevel().geteManager().removeEntity(this);
		}
		
		damageEntity();
	}

	@Override
	public void render(Graphics g) {
		if(getCurrentAnimation() != null)		
			g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		
	}

}
