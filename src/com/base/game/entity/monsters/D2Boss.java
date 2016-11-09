package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.attacks.Ink;

public class D2Boss extends BossMonster
{
	public D2Boss(Handler handler, float x, float y, int layer)
	{
		super(handler, x, y, layer, 200, 200);
		
		setBounds(new Rectangle(36, 30, 54, 46));
		currSpeed = baseSpeed = 3f;
		health = myHealth = 20;
		damage = 0;
		attackProb = 100;
		reach = 10;
		canFly = true;
		renderOrder = 5;
			
		dwnLft = new Animation(250, Assets.b2DwnLft, 0);
		dwnRgt = new Animation(250, Assets.b2DwnRgt, 0);
		upLft = new Animation(250, Assets.b2UpLft, 0);
		upRgt = new Animation(250, Assets.b2UpRgt, 0);
		
		atkDwnLft = new Animation(200, Assets.b2AtkDwnLft, 1);
		atkDwnRgt = new Animation(200, Assets.b2AtkDwnRgt, 1);
		atkUpLft = new Animation(200, Assets.b2AtkUpLft, 1);
		atkUpRgt = new Animation(200, Assets.b2AtkUpRgt, 1);
		
		currentAnimation = dwnLft;
	}

	@Override
	public void update()
	{	
		super.update();
		
		stateUpdate();
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
