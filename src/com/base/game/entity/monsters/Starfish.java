package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.Tornado;

public class Starfish extends Monster
{
	public Starfish(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 70, 70, level);
		
		setBounds(new Rectangle(8, 30, 46, 34));
		baseSpeed = 3f;
		currSpeed = baseSpeed;
		damage = 0;
		attackProb = 100;
		health = 20;
		reach = 10;
		
		dwnLft = new Animation(250, Assets.starfishDwnLft, 0);
		dwnRgt = new Animation(250, Assets.starfishDwnRgt, 0);
		upLft = new Animation(250, Assets.starfishUpLft, 0);
		upRgt = new Animation(250, Assets.starfishUpRgt, 0);
		
		atkDwnLft = new Animation(100, Assets.starfishAtkDwnLft, 1);
		atkDwnRgt = new Animation(100, Assets.starfishAtkDwnRgt, 1);
		atkUpLft = new Animation(100, Assets.starfishAtkUpLft, 1);
		atkUpRgt = new Animation(100, Assets.starfishAtkUpRgt, 1);
		
		currentAnimation = dwnLft;
	}

	@Override
	public void update()
	{		
		super.update();
		
		switch(state)
		{
		case "FORCEMOVE":
			forceMove();
			break;
		case "KNOCKBACK":
			knockBack();
			break;
		case "IDLE":
			idle();
			break;
		case "CHASE":
			chase();
			break;
		case "ATTACK":
			attack();
			break;
		case "ATTACKING":
			attacking();
			break;
		case "DYING":
			dying();
			break;	
		}
		
	}
	
	float atkSpeedX;
	float atkSpeedY;
	float atkSpeed = 15;
	@Override
	public void attack() 
	{
		if(target.getX() < x && target.getY() < y)
			currentAnimation = atkUpLft;			
		else if(target.getX() > x && target.getY() < y)
			currentAnimation = atkUpRgt;	
		else if(target.getX() < x && target.getY() > y)
			currentAnimation = atkDwnLft;	
		else
			currentAnimation = atkDwnRgt;
			
		atkSpeedX = (target.getX() - x)/(Math.abs(target.getX() - x) + Math.abs(target.getY() - y)) * atkSpeed;
		atkSpeedY = (target.getY() - y)/(Math.abs(target.getY() - y) + Math.abs(target.getX() - x)) * atkSpeed;
		
		state = "ATTACKING";
		
	}
	
	float atkDist;
	public void attacking()
	{
		xMove = atkSpeedX;
		yMove = atkSpeedY;
		atkDist += Math.abs(atkSpeedX) + Math.abs(atkSpeedY);

		if(atkDist > 200)
		{
			currentAnimation.update();		
		}
		else
		{
			move();
			damageEntity();	
		}
		
		if(currentAnimation.isComplete())
		{
			currentAnimation.reset();
			state = "CHASE";
			atkDist = 0;	
		}
		
		
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
