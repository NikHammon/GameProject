package com.base.game.entity.attacks;

import java.awt.Color;
import java.awt.Graphics;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.monsters.Turtle;

public class Tornado extends Projectile
{

	public Tornado(Handler handler, Entity user, float x, float y, int layer, int direction) 
	{
		super(handler, user, x, y, layer, 64, 64, direction);
		bounds.x = 10;
		bounds.y = 20;
		bounds.width = 45;
		bounds.height = 40;
		knockBack = 150;
		
		speed = 10;
		currentAnimation = new Animation(50, Assets.tornado, 0);
		destroy = new Animation(50, Assets.tornadoDissapate, 1);
	}
	
	public Tornado(Handler handler, Entity user, float x, float y, int layer, float xDir, float yDir) 
	{
		super(handler, user, x, y, layer, 64, 64, xDir, yDir);
		bounds.x = 10;
		bounds.y = 20;
		bounds.width = 45;
		bounds.height = 40;
		knockBack = 150;
		
		speed = 10;
		currentAnimation = new Animation(50, Assets.tornado, 0);
		destroy = new Animation(50, Assets.tornadoDissapate, 1);
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
		if(e instanceof Turtle && e.getState() == "DEAD")
			((Creature)e).setKnockBack(xMove, yMove, knockBack);	
		
		if(e instanceof Monster && e.canBeKnkBack())
			((Creature)e).setKnockBack(xMove, yMove, knockBack);		
		destroy();
	}
	
}
