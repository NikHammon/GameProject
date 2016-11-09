package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.LightSlash;
import com.base.game.entity.attacks.Slash;
import com.base.game.tiles.Tile;

public class Gremlin extends Monster
{	
	public Gremlin(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, level);
		
		setBounds(new Rectangle(16, 22, 28, 28));
		baseSpeed = 3.5f;
		currSpeed = baseSpeed;
		
		myHealth = 15;
		reach = 10;
		
		damage = 1;
		
		attackProb = 50;
		
		dwnLft = new Animation(125, Assets.gremlinDwnLft, 0);
		dwnRgt = new Animation(125, Assets.gremlinDwnRgt, 0);
		upLft = new Animation(125, Assets.gremlinUpLft, 0);
		upRgt = new Animation(125, Assets.gremlinUpRgt, 0);
		
		idleDwnLft = new Animation(175, Assets.gremlinIdleDwnLft, 0);
		atkDwnLft = new Animation(100, Assets.gremlinAtkDwnLft, 1);
		idleUpLft = new Animation(175, Assets.gremlinIdleUpLft, 0);
		atkUpLft = new Animation(100, Assets.gremlinAtkUpLft, 1);
		idleDwnRgt = new Animation(175, Assets.gremlinIdleDwnRgt, 0);
		atkDwnRgt = new Animation(100, Assets.gremlinAtkDwnRgt, 1);
		idleUpRgt = new Animation(175, Assets.gremlinIdleUpRgt, 0);
		atkUpRgt = new Animation(100, Assets.gremlinAtkUpRgt, 1);
		
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
		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
	
		
	}
	
	public void setAttack()
	{
		if(target.getX() < x && target.getY() < y)
			currentAnimation = atkUpLft;			
		else if(target.getX() > x && target.getY() < y)
			currentAnimation = atkUpRgt;	
		else if(target.getX() < x && target.getY() > y)
			currentAnimation = atkDwnLft;	
		else
			currentAnimation = atkDwnRgt;
		
		state = "ATTACK";
	}

	boolean attacked = false;
	@Override
	public void attack() 
	{
		if(currentAnimation.isComplete())
		{
			currentAnimation.reset();
			attacked = false;
			state = "CHASE";
		}
		
		if(!attacked && currentAnimation.getCurrentIndex() == 4)
		{
			handler.getGame().geteManager().addEntity(new Slash(handler, this, x, y, layer, target.getX()-x, target.getY()-y));
			attacked = true;
		}
			
		damageEntity();	
	}
	
	public void setCurrentAnimation()
	{
		if(state == "IDLE" && idleDwnLft != null)
		{
			if(xMove < 0 && yMove > 0)
			{
				currentAnimation = idleDwnLft;
				//setBounds(new Rectangle(10, 22, 28, 40));
			}
			else if(xMove > 0 && yMove > 0)
			{
				currentAnimation =  idleDwnRgt;
				//setBounds(new Rectangle(24, 22, 28, 40));
			}
			else if(xMove < 0 && yMove < 0)
			{
				currentAnimation = idleUpLft;
				//setBounds(new Rectangle(6, 18, 28, 40));
			}
			else if(xMove > 0 && yMove < 0)
			{
				currentAnimation = idleUpRgt;
				//setBounds(new Rectangle(30, 18, 28, 40));
			}
		}
		
		if(state == "CHASE")
		{
			if(xMove < 0 && yMove > 0)
			{
				currentAnimation = dwnLft;
				//setBounds(new Rectangle(10, 22, 28, 40));
			}
			else if(xMove > 0 && yMove > 0)
			{
				currentAnimation =  dwnRgt;
				//setBounds(new Rectangle(24, 22, 28, 40));
			}
			else if(xMove < 0 && yMove < 0)
			{
				currentAnimation = upLft;
				//setBounds(new Rectangle(6, 18, 28, 40));
			}
			else if(xMove > 0 && yMove < 0)
			{
				currentAnimation = upRgt;
				//setBounds(new Rectangle(30, 18, 28, 40));
			}
		}
	}
	
}
