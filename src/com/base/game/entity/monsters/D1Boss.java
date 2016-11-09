package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.attacks.Ink;

public class D1Boss extends BossMonster
{
	public D1Boss(Handler handler, float x, float y, int layer)
	{
		super(handler, x, y, layer, 160, 120);
		
		setBounds(new Rectangle(36, 30, 54, 46));
		currSpeed = baseSpeed = 3f;
		health = myHealth = 20;
		damage = 0;
		attackProb = 100;
		reach = 10;
			
		dwnLft = new Animation(250, Assets.b1DwnLft, 0);
		dwnRgt = new Animation(250, Assets.b1DwnRgt, 0);
		upLft = new Animation(250, Assets.b1UpLft, 0);
		upRgt = new Animation(250, Assets.b1UpRgt, 0);
		
		atkDwnLft = new Animation(200, Assets.b1AtkDwnLft, 1);
		atkDwnRgt = new Animation(200, Assets.b1AtkDwnRgt, 1);
		atkUpLft = new Animation(200, Assets.b1AtkUpLft, 1);
		atkUpRgt = new Animation(200, Assets.b1AtkUpRgt, 1);
		
		currentAnimation = dwnLft;
	}

	
	boolean attacked;

	@Override
	public void attack() 
	{
		if(currentAnimation.getIndex()>2 && !attacked)
		{
			handler.getLevel().geteManager().addEntity(new Ink(handler, this, x, y, layer, target.getX()-x, target.getY()-y));
			attacked = true;
		}

		if(currentAnimation.isComplete())
		{
			currentAnimation.reset();
			state = "CHASE";
			attacked = false;
		}

		
		if(target.getX() < x && target.getY() < y)
			currentAnimation = atkUpLft;			
		else if(target.getX() > x && target.getY() < y)
			currentAnimation = atkUpRgt;	
		else if(target.getX() < x && target.getY() > y)
			currentAnimation = atkDwnLft;	
		else
			currentAnimation = atkDwnRgt;
			
		damageEntity();	
	}
	
	@Override
	public void render(Graphics g) 
	{
		
		if(rVal == 0 && gVal == 0 && bVal == 0)
		{
			if(getCurrentAnimation() != null)		
				g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		}
		else 
		{
			if(getCurrentAnimation() != null)		
				g.drawImage(Utils.tintImage(currentAnimation.getCurrentFrame(), rVal, bVal, gVal), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		}
		
	}

}