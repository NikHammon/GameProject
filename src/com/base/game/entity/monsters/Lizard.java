package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Player;

public class Lizard extends Monster
{
	public Lizard(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 120, 120, level);
		
		setBounds(new Rectangle(24, 36, 46, 52));
		baseSpeed = 4.5f;
		currSpeed = baseSpeed;
		myHealth = 30;
		health = myHealth;
		
		damage = 0;
		attackProb = 2;
		
		
		dwnLft = new Animation(100, Assets.lizardDwnLft, 0);
		dwnRgt = new Animation(100, Assets.lizardDwnRgt, 0);
		upLft = new Animation(100, Assets.lizardUpLft, 0);
		upRgt = new Animation(100, Assets.lizardUpRgt, 0);
		
		atkDwnLft = new Animation(75, Assets.lizardAtkDwnLft, 1);
		atkDwnRgt = new Animation(75, Assets.lizardAtkDwnRgt, 1);
		atkUpLft = new Animation(75, Assets.lizardAtkUpLft, 1);
		atkUpRgt = new Animation(75, Assets.lizardAtkUpRgt, 1);
		
		currentAnimation = dwnLft;
	}

	@Override
	public void update()
	{	
		super.update();
		
		stateUpdate();
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
//		if(reachRect != null)
//		{
			//g.fillRect(reachRect.x, reachRect.y, reachRect.width, reachRect.height);
			//g.fillRect(targetBounds.x, targetBounds.y, targetBounds.width, targetBounds.height);
//		}
		
	}
	
}
