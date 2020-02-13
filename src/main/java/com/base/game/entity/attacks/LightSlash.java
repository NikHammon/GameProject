package com.base.game.entity.attacks;

import java.awt.Graphics;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;

public class LightSlash extends Projectile
{
	public LightSlash(Handler handler, Entity user, float x, float y, int layer, float xDir, float yDir) 
	{
		super(handler, user, x, y, layer, 32, 32, xDir, yDir);
		damage = 3;
		knockBack = 50;
		
		speed = 8;
		currentAnimation = new Animation(50, Assets.lightSlash, 0);
	}

	

	@Override
	public void render(Graphics g) 
	{
		if(getCurrentAnimation() != null)		
			g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
	
	}

	@Override
	public void effect(Entity e)
	{
		if(e instanceof Creature && e.canBeKnkBack())
		{
			Creature c = ((Creature)e);
			c.takeDamage(damage);
			if(c.getHealth() > 0)
				c.setKnockBack(x, y, knockBack);		
		}
		destroy();
	}
}
