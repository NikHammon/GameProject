package com.base.game.entity.attacks;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.staticEntity.StaticEntity;

public class GreenMagic extends Projectile
{
	public GreenMagic(Handler handler, Entity user, float x, float y, int layer, float xDir, float yDir) 
	{
		super(handler, user, x, y, layer, 16, 16, xDir, yDir);
		damage = 3;
		knockBack = 50;
		
		speed = 8;
		currentAnimation = new Animation(100, Assets.greenMagic, 0);
		destroy = new Animation(50, Assets.greenFire, 1);
		doesNotCollideWithEntity = true;
		
		maxDist = rand.nextInt(250) + 100;
	}

	int distance, maxDist;
	boolean exploded = false;
	public void update()
	{
		super.update();
		distance += speed;
		
		if(distance > maxDist && !exploded)
		{
			exploded = true;
			doesNotCollideWithEntity = false;
			speed = 0;
			x -= 8; y -= 152;
			width = 64;height=160;
			currentAnimation = destroy;
			setAttackBounds(new Rectangle(10, 124, 44, 36));
		}
		else if(exploded)
		{
			for(Entity e : handler.getGame().geteManager().getEntities())
			{
				if(getAttackBounds(0,0).intersects(e.getCollisionBounds(0,0)))
				{
					if(e.equals(this) || e.isRecovering())
						continue;
					else if(e instanceof Monster)
						continue;
					else if(e instanceof Creature)
					{
						Creature c = ((Creature)e);
						c.takeDamage(damage);
						
						if(c.getHealth() > 0)
							c.setKnockBack(x, y, knockBack);
						
					}
				}
			}
		}
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

	}
}
