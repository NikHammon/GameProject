package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.attacks.ElectroBall;
import com.base.game.entity.attacks.GreenMagic;

public class LgtMagi extends Monster
{
	private Animation warpDwnLft, warpDwnRgt, warpUpLft, warpUpRgt; 
	
	public LgtMagi(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 70, 70, level);
		
		setBounds(new Rectangle(18, 32, 28, 32));
		baseSpeed = 3.5f;
		currSpeed = baseSpeed;
		myHealth = 30;
		health = myHealth;
		damage = 0;
		reach = 10;
		attackProb = 200;
		
		dwnLft = new Animation(125, Assets.lgtMagiDwnLft, 0);
		dwnRgt = new Animation(125, Assets.lgtMagiDwnRgt, 0);
		upLft = new Animation(125, Assets.lgtMagiUpLft, 0);
		upRgt = new Animation(125, Assets.lgtMagiUpRgt, 0);
		
		atkDwnLft = new Animation(100, Assets.lgtMagiAtkDwnLft, 1);
		atkUpLft = new Animation(100, Assets.lgtMagiAtkUpLft, 1);
		atkDwnRgt = new Animation(100, Assets.lgtMagiAtkDwnRgt, 1);
		atkUpRgt = new Animation(100, Assets.lgtMagiAtkUpRgt, 1);
		
		warpDwnLft = new Animation(100, Assets.lgtMagiWarpDwnLft, 1);
		warpUpLft = new Animation(100, Assets.lgtMagiWarpUpLft, 1);
		warpDwnRgt = new Animation(100, Assets.lgtMagiWarpDwnRgt, 1);
		warpUpRgt = new Animation(100, Assets.lgtMagiWarpUpRgt, 1);
		
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

	int attackCount = -1;
	int maxAttackTimes;
	@Override
	public void attack() 
	{
		if(attackCount < 0)
		{
			maxAttackTimes=rand.nextInt(6) + 3;
			attackCount ++;
		}
		if(currentAnimation.isComplete())
		{
			handler.getGame().geteManager().addEntity(new GreenMagic(handler, this, x, y, layer, target.getX()-x, target.getY()-y));
			currentAnimation.reset();
			setAttack();
			attackCount++;
		}
		
		
			
		damageEntity();	
		
		if(attackCount > maxAttackTimes)
		{
			state = "CHASE";
			attackCount = -1;
		}
	}
}
