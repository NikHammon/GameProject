package com.base.game.entity.attacks;

import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.staticEntity.Breakables;

public abstract class Attack extends Entity
{
	protected int damage;
	protected Entity user;
	
	public Attack(Handler handler, Entity user, float x, float y, int layer, int width, int height) 
	{
		super(handler, x, y, layer, width, height);
		this.user = user;
		doNotRenderShadow = true;
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
				else if(e instanceof Monster)
				{
					Creature c = ((Creature)e);
					c.setrVal(200);
					c.takeDamage(damage);
					if(c.getHealth() > 0)
						c.setKnockBack(x, y, knockBack);
					
				}

			}
		}
	}
	
	public Entity getUser() {
		return user;
	}


	public void setUser(Entity user) {
		this.user = user;
	}


}
