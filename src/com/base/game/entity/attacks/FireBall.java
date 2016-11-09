package com.base.game.entity.attacks;

import java.awt.Graphics;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.monsters.Turtle;

public class FireBall extends Projectile
{
	public FireBall(Handler handler, Entity user, float x, float y, int layer, int direction) 
	{
		super(handler, user, x, y, layer, 64, 64, direction);
		speed = 10;
		damage = 10;
		knockBack = 40;
		currentAnimation = new Animation(100, Assets.fireBall, 0);
		destroy = new Animation(50, Assets.blast, 1);
	}
	
	public FireBall(Handler handler, Entity user, float x, float y, int layer, float xDir, float yDir) 
	{
		super(handler, user, x, y, layer, 64, 64, xDir, yDir);
		speed = 10;
		damage = 10;
		knockBack = 40;
		currentAnimation = new Animation(100, Assets.fireBall, 0);
		destroy = new Animation(50, Assets.blast, 1);
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
		speed = 0;
		x -= 72; y -= 72;
		width = 200;height=200;
		destroy();
	}
}
