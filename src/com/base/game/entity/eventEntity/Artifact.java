package com.base.game.entity.eventEntity;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Assets;
import com.base.game.Handler;

public class Artifact extends EventEntity
{
	boolean isObtained;
	
	public Artifact(Handler handler, float x, float y, int layer) 
	{
		super(handler, x, y, layer, 64, 64);
		bounds = new Rectangle(20, 14, 20, 46);
		eventSpace = getCollisionBounds(0,0);
		eventSpace.x -= 40;
		eventSpace.y -= 40;
		eventSpace.width += 80;
		eventSpace.height += 80;
	}
	
	@Override
	public void update()
	{	
		if(on)
		{
			handler.getGame().getGameState().getEffects().displayDialog(75);
			isObtained = true;
			if(handler.getGame().getGameState().getEffects().getdBox().isComplete())
			{
				on = false;
			}
		}
	}
	
	@Override
	public void render(Graphics g) 
	{
		super.render(g);	
		g.drawImage(Assets.artifact, (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), 64, 64, null);

	}
	
	public boolean isObtained() {
		return isObtained;
	}

	public void setObtained(boolean isObtained) {
		this.isObtained = isObtained;
	}

	
}
