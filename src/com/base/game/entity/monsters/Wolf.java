package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.attacks.ElectroBall;

public class Wolf extends Monster
{
	public Wolf(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 88, 80, level);
		
		setBounds(new Rectangle(18, 26, 44, 54));
		baseSpeed = 3.5f;
		currSpeed = baseSpeed;
		myHealth = 30;
		health = myHealth;
		damage = 0;
		reach = 10;
		attackProb = 200;
		
		dwnLft = new Animation(125, Assets.wolfDwnLft, 0);
		dwnRgt = new Animation(125, Assets.wolfDwnRgt, 0);
		upLft = new Animation(125, Assets.wolfUpLft, 0);
		upRgt = new Animation(125, Assets.wolfUpRgt, 0);
		
		idleDwnLft = new Animation(175, Assets.wolfIdleDwnLft, 0);
		atkDwnLft = new Animation(100, Assets.wolfAtkDwnLft, 1);
		idleUpLft = new Animation(175, Assets.wolfIdleUpLft, 0);
		atkUpLft = new Animation(100, Assets.wolfAtkUpLft, 1);
		idleDwnRgt = new Animation(175, Assets.wolfIdleDwnRgt, 0);
		atkDwnRgt = new Animation(100, Assets.wolfAtkDwnRgt, 1);
		idleUpRgt = new Animation(175, Assets.wolfIdleUpRgt, 0);
		atkUpRgt = new Animation(100, Assets.wolfAtkUpRgt, 1);
		
		currentAnimation = idleDwnRgt;
	}

	@Override
	public void update()
	{		
		super.update();
		stateUpdate();
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
//		g.setColor(Color.MAGENTA);
//		g.fillRect((int)(attackBounds.x), (int) (attackBounds.y), attackBounds.width, attackBounds.height);
//		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
	
		
	}


	@Override
	public void attack() 
	{
		if(currentAnimation.isComplete())
		{
			currentAnimation.reset();
			state = "CHASE";
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
	
}
