package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;

public class Bat extends Monster
{
	public Bat(Handler handler, float x, float y, int layer, int level, String element)
	{
		super(handler, x, y, layer, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, level);
		setBounds(new Rectangle(12, 24, 36, 28));
		this.element = element;
		
		
		type = 1;
		baseSpeed = 3.5f;
		myHealth = 10;
		health = myHealth;
		currSpeed = baseSpeed;
		damage = 1;
		attackProb = 1;
		
		switch(element)
		{
		case "FIRE":
			dwnLft = new Animation(100, Assets.fireBatLeft, 0);
			dwnRgt = new Animation(100, Assets.fireBatRight, 0);
			upLft = new Animation(100, Assets.fireBatLeft, 0);
			upRgt = new Animation(100, Assets.fireBatRight, 0);
			break;
		default:
			dwnLft = new Animation(100, Assets.batLeft, 0);
			dwnRgt = new Animation(100, Assets.batRight, 0);
			upLft = new Animation(100, Assets.batLeft, 0);
			upRgt = new Animation(100, Assets.batRight, 0);
		}
		
		currentAnimation = dwnLft;
	}

	@Override
	public void update()
	{	
		super.update();
		
		stateUpdate();
	}
	
	@Override
	public void attack(){}

}
