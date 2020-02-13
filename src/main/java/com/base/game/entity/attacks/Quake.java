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

public class Quake extends Attack
{
	public Quake(Handler handler, Entity user, float x, float y, int layer) {
		super(handler, user, x, y, layer, 224, 160);
		currentAnimation =  new Animation(100, Assets.quake, 1);
		
		damage = 10;
		knockBack = 40;
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

	@Override
	public void render(Graphics g) {
		if(getCurrentAnimation() != null)		
			g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		
	}

}
