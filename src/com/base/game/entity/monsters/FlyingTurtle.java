package com.base.game.entity.monsters;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class FlyingTurtle extends Turtle
{

	public FlyingTurtle(Handler handler, float x, float y, int layer, int level) 
	{
		super(handler, x, y, layer, level);
		width = 90;height = 90;
		setBounds(new Rectangle(20, 36, 48, 46));
		dwnLft = new Animation(200, Assets.flyTurtleDwnLft, 0);
		dwnRgt = new Animation(200, Assets.flyTurtleDwnRgt, 0);
		upLft = new Animation(200, Assets.flyTurtleUpLft, 0);
		upRgt = new Animation(200, Assets.flyTurtleUpRgt, 0);
	}

}
