package com.base.game.entity.monsters;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.Explosion;
import com.base.game.entity.attacks.Tornado;

public class SeaMine extends Monster
{
	public SeaMine(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 80, 80, level);
		
		setBounds(new Rectangle(24, 30, 34, 36));
		baseSpeed = 3f;
		currSpeed = baseSpeed;
		damage = 0;
		attackProb = 2;
		myHealth = 20;
		health = myHealth;
		
		dwnLft = new Animation(250, Assets.seaMineDwnLft, 0);
		dwnRgt = new Animation(250, Assets.seaMineDwnRgt, 0);
		upLft = new Animation(250, Assets.seaMineUpLft, 0);
		upRgt = new Animation(250, Assets.seaMineUpRgt, 0);
		
		atkDwnLft = new Animation(300, Assets.seaMineAtkDwnLft, 1);
		atkUpLft = new Animation(300, Assets.seaMineAtkUpLft, 1);
		atkUpRgt = new Animation(300, Assets.seaMineAtkUpRgt, 1);
		
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
			handler.getLevel().geteManager().addEntity(new Explosion(handler, this, x - 40, y - 120, layer));
			handler.getLevel().geteManager().removeEntity(this);
		}
		
		if(target.getX() < x && target.getY() < y)
			currentAnimation = atkUpLft;			
		else if(target.getX() > x && target.getY() < y)
			currentAnimation = atkUpRgt;	
		else if(target.getX() < x && target.getY() > y)
			currentAnimation = atkDwnLft;	
		else
			currentAnimation = atkDwnRgt;
			
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
		
		//g.setColor(Color.red);
		//g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
		
		
	}
	
}
