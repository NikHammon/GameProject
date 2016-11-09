package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Player;

public class Hippo extends Monster
{
	public Hippo(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, 120, 104, level);
		
		setBounds(new Rectangle(4, 32, 112, 62));
		baseSpeed = 3f;
		currSpeed = baseSpeed;
		damage = 0;
		attackProb = 10;
		health = 20;
		knockBack = 200;
		reach = 10;
		
		dwnLft = new Animation(250, Assets.hippoDwnLft, 0);
		dwnRgt = new Animation(250, Assets.hippoDwnRgt, 0);
		upLft = new Animation(250, Assets.hippoUpLft, 0);
		upRgt = new Animation(250, Assets.hippoUpRgt, 0);
		
		atkDwnLft = new Animation(300, Assets.hippoAtkDwnLft, 1);
		atkDwnRgt = new Animation(300, Assets.hippoAtkDwnRgt, 1);
		atkUpLft = new Animation(300, Assets.hippoAtkUpLft, 1);
		atkUpRgt = new Animation(300, Assets.hippoAtkUpRgt, 1);
		
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
			//handler.getLevel().geteManager().addEntity(new Tornado(handler, this, x, y, layer, player.getX()-x, player.getY()-y));
			currentAnimation.reset();
			state = "CHASE";
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
