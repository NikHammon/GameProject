package com.base.game.entity.attacks;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.staticEntity.Breakables;

public class LightningSplash extends Attack
{
	public LightningSplash(Handler handler, Entity user, float x, float y, int layer) {
		super(handler, user, x, y, layer, 184, 160);
		currentAnimation =  new Animation(100, Assets.lightningSplash, 1);
		
		damage = 10;
		knockBack = 0;
		renderOrder = 2;
		attackBounds = getCollisionBounds(-handler.getCamera().getxOffset(), -handler.getCamera().getyOffset());
		
		attackBounds.x = attackBounds.x - bounds.width/8;
		attackBounds.y = attackBounds.y - bounds.height/8;
		attackBounds.width = attackBounds.width + bounds.width/4;
		attackBounds.height = attackBounds.height + bounds.height/4;
		
		bounds = new Rectangle(0,0,0,0);
	}

	@Override
	public void update() 
	{	
		currentAnimation.update();
		
		if(currentAnimation.isComplete())
		{
			handler.getGame().geteManager().removeEntity(this);
		}
		
		damageEntity();
	}
	
	public void damageEntity()
	{
		for(Entity e : handler.getGame().geteManager().getEntities())
		{
			if(attackBounds.intersects(e.getCollisionBounds(-handler.getCamera().getxOffset(), -handler.getCamera().getyOffset())))
			{
				if(e.equals(this) || e == user)
					continue;
				else if(e instanceof Breakables)
					e.setState("HIT");
				else if(e instanceof Player)
				{
					Creature c = ((Creature)e);
					c.setrVal(200);
					c.setStatusCondition("PARALYZED");
					c.takeDamage(damage);	
					attackBounds = new Rectangle(0,0,0,0);
				}

			}
		}
	}

	@Override
	public void render(Graphics g) {
		if(getCurrentAnimation() != null)		
			g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		
	}

}
