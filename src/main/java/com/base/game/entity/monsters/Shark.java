package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.concurrent.ThreadLocalRandom;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.ElectroBall;
import com.base.game.entity.attacks.Tornado;
import com.base.game.tiles.Tile;

public class Shark extends Monster
{	
	public Shark(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 110, 110, level);
		
		setBounds(new Rectangle(18, 34, 56, 54));
		baseSpeed = 3.5f;
		currSpeed = baseSpeed;
		myHealth = 30;
		health = myHealth;
		damage = 0;
		reach = 10;
		attackProb = 200;
		
		dwnLft = new Animation(125, Assets.sharkDwnLft, 0);
		dwnRgt = new Animation(125, Assets.sharkDwnRgt, 0);
		upLft = new Animation(125, Assets.sharkUpLft, 0);
		upRgt = new Animation(125, Assets.sharkUpRgt, 0);
		
		idleDwnLft = new Animation(175, Assets.sharkIdleDwnLft, 0);
		atkDwnLft = new Animation(100, Assets.sharkAtkDwnLft, 1);
		idleUpLft = new Animation(175, Assets.sharkIdleUpLft, 0);
		atkUpLft = new Animation(100, Assets.sharkAtkUpLft, 1);
		idleDwnRgt = new Animation(175, Assets.sharkIdleDwnRgt, 0);
		atkDwnRgt = new Animation(100, Assets.sharkAtkDwnRgt, 1);
		idleUpRgt = new Animation(175, Assets.sharkIdleUpRgt, 0);
		atkUpRgt = new Animation(100, Assets.sharkAtkUpRgt, 1);
		
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
//		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
	
		
	}

	int attackCount = -1;
	int maxAttackTimes;
	@Override
	public void attack() 
	{
		if(attackCount < 0)
		{
			maxAttackTimes= ThreadLocalRandom.current().nextInt(6) + 3;
			attackCount ++;
		}
		if(currentAnimation.isComplete())
		{
			handler.getGame().geteManager().addEntity(new ElectroBall(handler, this, x, y, layer, target.getX()-x, target.getY()-y));
			currentAnimation.reset();
			attackCount++;
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
		
		if(attackCount > maxAttackTimes)
		{
			state = "CHASE";
			attackCount = -1;
		}
	}
	
}
