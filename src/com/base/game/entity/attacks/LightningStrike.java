package com.base.game.entity.attacks;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;
import com.base.game.entity.staticEntity.Breakables;

public class LightningStrike extends Attack
{
	public LightningStrike(Handler handler, Entity user, float x, float y, int layer) {
		super(handler, user, x, y, layer, 144, 244);
		currentAnimation =  new Animation(150, Assets.lightning, 1);
		doNotRenderShadow = false;
		damage = 10;
		knockBack = 0;
		renderOrder = 2;
		
		attackBounds = new Rectangle(20, 180, 100, 60);		
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
		else if(currentAnimation.getCurrentIndex() > 1)
			damageEntity();
	}
	
	public void damageEntity()
	{
		for(Entity e : handler.getGame().geteManager().getEntities())
		{
			if(attackBounds.intersects(e.getCollisionBounds(0,0)))
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
