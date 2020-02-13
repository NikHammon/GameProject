package com.base.game.entity.monsters;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Goblin extends Gremlin
{

	public Goblin(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, level);

		dwnLft = new Animation(125, Assets.goblinDwnLft, 0);
		dwnRgt = new Animation(125, Assets.goblinDwnRgt, 0);
		upLft = new Animation(125, Assets.goblinUpLft, 0);
		upRgt = new Animation(125, Assets.goblinUpRgt, 0);
		
		idleDwnLft = new Animation(175, Assets.goblinIdleDwnLft, 0);
		atkDwnLft = new Animation(100, Assets.goblinAtkDwnLft, 1);
		idleUpLft = new Animation(175, Assets.goblinIdleUpLft, 0);
		atkUpLft = new Animation(100, Assets.goblinAtkUpLft, 1);
		idleDwnRgt = new Animation(175, Assets.goblinIdleDwnRgt, 0);
		atkDwnRgt = new Animation(100, Assets.goblinAtkDwnRgt, 1);
		idleUpRgt = new Animation(175, Assets.goblinIdleUpRgt, 0);
		atkUpRgt = new Animation(100, Assets.goblinAtkUpRgt, 1);
	}

}
