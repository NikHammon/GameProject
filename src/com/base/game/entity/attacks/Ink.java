package com.base.game.entity.attacks;

import java.awt.Graphics;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.monsters.Turtle;

public class Ink extends Projectile
{
	public Ink(Handler handler, Entity user, float x, float y, int layer, float xDir, float yDir) 
	{
		super(handler, user, x, y, layer, 64, 64, xDir, yDir);
		bounds.x = 10;
		bounds.y = 20;
		bounds.width = 45;
		bounds.height = 40;
		knockBack = 50;
		
		speed = 6;
		currentAnimation = new Animation(50, Assets.ink, 0);
		//destroy = new Animation(50, Assets.tornadoDissapate, true);
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
			c.setStatusCondition("CONFUSED");
			c.takeDamage(damage);
			if(c.getHealth() > 0)
				c.setKnockBack(x, y, knockBack);		
		}
		destroy();
	}
}
