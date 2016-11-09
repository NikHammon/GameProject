package com.base.game.entity.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.Tornado;

public class Tessen extends MainItem 
{
	public Tessen(Handler handler)
	{
		super(handler);	
		ID = 1;
		
		summaryL1 = "A TESSEN THAT WHIP UP MIGHTY STORMS.  THE TEMPESTS IT CREATES CAN BLOW";
		summaryL2 = "ENEMIES BACK GREAT DISTANCES.";
	}

	@Override
	public void action() 
	{ 
		player = handler.getGame().getPlayer();
		
		if(timer == 0)
		{	
			layer = player.getLayer();
			Utils.playSound("wind");
			handler.getGame().geteManager().addEntity(new Tornado(handler, this, player.getX(), player.getY(), player.getLayer(), player.getDirection()));	
			player.setCurrentAnimation(Assets.tessen[(int)player.getDirection()/2]);
			
		}
		
		timer += System.currentTimeMillis() - player.getLastTimeUsedItem();

		if(timer > 2000)
		{
			timer = 0;
			player.setState("CHASE");
		}
	}

	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public BufferedImage getIcon() 
	{
		return Assets.itemIcons[1];
	}
	@Override
	public void render(Graphics g) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
}
