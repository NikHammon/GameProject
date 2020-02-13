package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.attacks.Tornado;
import com.base.game.entity.staticEntity.Ooze;

public class Slime extends Monster
{	
	public Slime(Handler handler, float x, float y, int layer, int level)
	{
		super(handler, x, y, layer, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT, level);
		
		setBounds(new Rectangle(12, 28, 44, 34));

		type = 1;
		baseSpeed = 2f;
		currSpeed = baseSpeed;
		myHealth = 15;
		health = myHealth;
		damage = 1;
		sight = 20;
		reach = 20;
		attackProb = 20;
		
		dwnLft = new Animation(100, Assets.slimeDwnLft, 0);
		dwnRgt = new Animation(100, Assets.slimeDwnRgt, 0);
		upLft = new Animation(100, Assets.slimeUpLft, 0);
		upRgt = new Animation(100, Assets.slimeUpRgt, 0);
		
		currentAnimation = dwnLft;
	}

	@Override
	public void update()
	{	
		super.update();
		System.out.println(state);
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
		handler.getGame().geteManager().addEntity(new Ooze(handler, x, y, layer));	
		state = "CHASE";	
	}
	@Override
	public void attack(){}
	
	
	
	
}
