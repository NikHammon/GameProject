package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.tiles.Tile;

public class Spider extends Monster
{
	public Spider(Handler handler, float x, float y, int layer, int level, String element)
	{
		super(handler, x, y, layer, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, level);
		
		bounds = new Rectangle(27, 28, 15, 34);		
		this.element = element;
		shadowOffsetY = 8;
		type = 1;
		baseSpeed = 2.5f;
		currSpeed = baseSpeed;
		myHealth = 10;
		health = myHealth;
		damage = 1;
		attackProb = 1;
		
		switch(element)
		{
		case "ICE":
			dwnLft = new Animation(150, Assets.iceSpiderLeft, 0);
			dwnRgt = new Animation(150, Assets.iceSpiderRight, 0);
			upLft = new Animation(150, Assets.iceSpiderLeft, 0);
			upRgt = new Animation(150, Assets.iceSpiderRight, 0);
			break;
		default:
			dwnLft = new Animation(150, Assets.spiderLeft, 0);
			dwnRgt = new Animation(150, Assets.spiderRight, 0);
			upLft = new Animation(150, Assets.spiderLeft, 0);
			upRgt = new Animation(150, Assets.spiderRight, 0);
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
	public void attack() {}	
	
}
