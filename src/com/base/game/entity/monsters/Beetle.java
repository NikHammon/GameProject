package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Player;

public class Beetle extends Monster
{
	public Beetle(Handler handler, float x, float y, int layer, int level, String element)
	{
		super(handler, x, y, layer, 80, 68, level);
		
		setBounds(new Rectangle(12, 14, 64, 46));
		this.element = element;
		baseSpeed = 3f;
		currSpeed = baseSpeed;
		damage = 0;
		attackProb = 100;
		myHealth = 30;
		health = myHealth;
		reach = 10;
		
		switch(element)
		{
		case "ICE":
			dwnLft = new Animation(250, Assets.iceBeetleDwnLft, 0);
			dwnRgt = new Animation(250, Assets.iceBeetleDwnRgt, 0);
			upLft = new Animation(250, Assets.iceBeetleUpLft, 0);
			upRgt = new Animation(250, Assets.iceBeetleUpRgt, 0);
			
			atkDwnLft = new Animation(100, Assets.iceBeetleDwnLftAtk, 0);
			atkDwnRgt = new Animation(100, Assets.iceBeetleDwnRgtAtk, 0);
			atkUpLft = new Animation(100, Assets.iceBeetleUpLftAtk, 0);
			atkUpRgt = new Animation(100, Assets.iceBeetleUpRgtAtk, 0);
			break;
		default:
			dwnLft = new Animation(250, Assets.beetleDwnLft, 0);
			dwnRgt = new Animation(250, Assets.beetleDwnRgt, 0);
			upLft = new Animation(250, Assets.beetleUpLft, 0);
			upRgt = new Animation(250, Assets.beetleUpRgt, 0);
			
			atkDwnLft = new Animation(100, Assets.beetleDwnLftAtk, 0);
			atkDwnRgt = new Animation(100, Assets.beetleDwnRgtAtk, 0);
			atkUpLft = new Animation(100, Assets.beetleUpLftAtk, 0);
			atkUpRgt = new Animation(100, Assets.beetleUpRgtAtk, 0);
		}
		
		currentAnimation = dwnLft;
	}

	@Override
	public void update()
	{		
		super.update();
		
		stateUpdate();
	}
	
	float atkSpeedX;
	float atkSpeedY;
	float atkSpeed = 10;
	@Override
	public void setAttack() 
	{
		if(target.getX() < x && target.getY() < y)
		{
			currentAnimation = atkUpLft;
			setAttackBounds(new Rectangle(0, 0, 36, 44));
		}
		else if(target.getX() > x && target.getY() < y)
		{
			currentAnimation = atkUpRgt;
			setAttackBounds(new Rectangle(66, 0, 36, 44));
		}
		else if(target.getX() < x && target.getY() > y)
		{
			currentAnimation = atkDwnLft;	
			setAttackBounds(new Rectangle(0, 14, 36, 44));
		}
		else
		{
			currentAnimation = atkDwnRgt;
			setAttackBounds(new Rectangle(66, 14, 36, 44));
		}
			
		atkSpeedX = (target.getX() - x)/(Math.abs(target.getX() - x) + Math.abs(target.getY() - y)) * atkSpeed;
		atkSpeedY = (target.getY() - y)/(Math.abs(target.getY() - y) + Math.abs(target.getX() - x)) * atkSpeed;
		
		state = "ATTACK";
		
	}
	
	float atkDist;
	public void attack()
	{
		xMove = atkSpeedX;
		yMove = atkSpeedY;
		atkDist += Math.abs(atkSpeedX) + Math.abs(atkSpeedY);
		
		if(atkDist > 500)
		{
			state = "CHASE";
			atkDist = 0;	
		}
		else
		{
			move();
			damageEntity();	
		}		
		
	}
	
}
