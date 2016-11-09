package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;

public class Turtle extends Monster
{
	public Turtle(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, level);
		
		setBounds(new Rectangle(10, 16, 50, 48));
		baseSpeed = 1.5f;
		currSpeed = baseSpeed;
		myHealth = 12;
		health = myHealth;
		damage = 1;
		attackProb = 1;
		
		dwnLft = new Animation(200, Assets.turtleDwnLft, 0);
		dwnRgt = new Animation(200, Assets.turtleDwnRgt, 0);
		upLft = new Animation(200, Assets.turtleUpLft, 0);
		upRgt = new Animation(200, Assets.turtleUpRgt, 0);

		currentAnimation = dwnLft;
	}

	@Override
	public void update()
	{	
		super.update();
		
		stateUpdate();
	}
	
	public void dying()
	{
		width = 64;height=64;
		lastTime = System.currentTimeMillis();
		state = "DEAD";
	}
	
	public void dead()
	{
		timer += System.currentTimeMillis() - lastTime;
		
		if(timer > 1000000)
		{
			health = myHealth;
			state = "IDLE";
			timer = 0;
			
			if(this instanceof FlyingTurtle)
			{
				width = 90;height = 90;
			}
		}
	}
	
	@Override
	public void render(Graphics g) 
	{
		
		if(state == "DEAD")
		{
			g.drawImage(Assets.turtleInShell[(int)direction/2], (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
		}
		else
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
		}
//		g.setColor(Color.MAGENTA);
//		g.fillRect((int)(attackBounds.x), (int) (attackBounds.y), attackBounds.width, attackBounds.height);
//		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
	
		
	}

	
	@Override
	public void attack() {}
	

	

}
