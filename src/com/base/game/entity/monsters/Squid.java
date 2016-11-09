package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.Ink;
import com.base.game.entity.attacks.Tornado;

public class Squid extends Monster
{
	public Squid(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 96, 96, level);
		
		setBounds(new Rectangle(36, 30, 54, 46));
		baseSpeed = 3f;
		currSpeed = baseSpeed;
		myHealth = 20;
		health = myHealth;
		damage = 0;
		attackProb = 100;
		health = 20;
		reach = 10;
			
		dwnLft = new Animation(250, Assets.squidDwnLft, 0);
		dwnRgt = new Animation(250, Assets.squidDwnRgt, 0);
		upLft = new Animation(250, Assets.squidUpLft, 0);
		upRgt = new Animation(250, Assets.squidUpRgt, 0);
		
		atkDwnLft = new Animation(200, Assets.squidAtkDwnLft, 1);
		atkDwnRgt = new Animation(200, Assets.squidAtkDwnRgt, 1);
		atkUpLft = new Animation(200, Assets.squidAtkUpLft, 1);
		atkUpRgt = new Animation(200, Assets.squidAtkUpRgt, 1);
		
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
		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
		
		
	}

}
