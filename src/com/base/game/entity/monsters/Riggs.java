package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;

public class Riggs extends BossMonster
{
	public Riggs(Handler handler, float x, float y, int layer)
	{
		super(handler, x, y, layer, 100, 100);
		
		bounds = new Rectangle(27, 28, 15, 34);		
		type = 1;
		baseSpeed = 2.5f;
		currSpeed = baseSpeed;
		myHealth = 10;
		health = myHealth;
		damage = 1;
		attackProb = 1;
		
		dwnLft = new Animation(150, Assets.riggsDwnLft, 0);
		dwnRgt = new Animation(150, Assets.riggsDwnRgt, 0);
		upLft = new Animation(150, Assets.riggsUpLft, 0);
		upRgt = new Animation(150, Assets.riggsUpRgt, 0);
		
		
		currentAnimation = dwnLft;
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
		g.drawImage(currentAnimation.getCurrentFrame(),(int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);
		
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
//		g.fillRect(getAttackBounds(-handler.getCamera().getxOffset(), -handler.getCamera().getyOffset()).x, getAttackBounds(-handler.getCamera().getxOffset(), -handler.getCamera().getyOffset()).y, attackBounds.width, attackBounds.height);
		
	}
	
	

	@Override
	public void attack() {}	
}
