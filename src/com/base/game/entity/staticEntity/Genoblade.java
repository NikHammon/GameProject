package com.base.game.entity.staticEntity;

import java.awt.Graphics;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Genoblade extends StaticEntity
{
	public Animation genoblade, genobladeDest;
	public Genoblade(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 90, 220);
		genoblade = new Animation(150, Assets.genoblade, 0);
		genobladeDest = new Animation(300, Assets.genobladeDest, 1);
		currentAnimation = genoblade;
	}

	@Override
	public void update() 
	{
		currentAnimation.update();
	}

	public void setCurrentAnimation(Animation currentAnimation) 
	{
		this.currentAnimation = currentAnimation;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);	
	}

}
