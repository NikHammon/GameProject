package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.Tornado;
import com.base.game.tiles.Tile;

public class Bird extends Monster
{
	public Bird(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 96, 90, level);
		setBounds(new Rectangle(16, 42, 62, 48));
		baseSpeed = 3.5f;
		currSpeed = baseSpeed;
		myHealth = 20;
		health = myHealth;
		damage = 0;
		attackProb = 200;
		reach = 3;
		
		dwnLft = new Animation(50, Assets.birdDwnLft, 0);
		dwnRgt = new Animation(50, Assets.birdDwnRgt, 0);
		upLft = new Animation(50, Assets.birdUpLft, 0);
		upRgt = new Animation(50, Assets.birdUpRgt, 0);
		
		atkDwnLft = new Animation(250, Assets.birdAtkDwnLft, 1);
		atkDwnRgt = new Animation(250, Assets.birdAtkDwnRgt, 1);
		atkUpLft = new Animation(250, Assets.birdAtkUpLft, 1);
		atkUpRgt = new Animation(250, Assets.birdAtkUpRgt, 1);
		
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
			handler.getLevel().geteManager().addEntity(new Tornado(handler, this, x, y, layer, target.getX()-x, target.getY()-y));
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
