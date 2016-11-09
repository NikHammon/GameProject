package com.base.game.entity.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.Tornado;

public class PuppetHands extends MainItem
{
	private List<ShadowPuppet> shuppets;
	
	public PuppetHands(Handler handler)
	{
		super(handler);
		ID = 6;
		speed = 5;
		damage = 3;
		knockBack = 30;
		
		state = "ACTIVATING";
		
		shuppets = new ArrayList<ShadowPuppet>();
		
		summaryL1 = "PUPPETEER GLOVES THAT SUMMON DEMONIC COPIES OF THE USER.";

	}

	@Override
	public void action() 
	{ 
		player = handler.getGame().geteManager().getPlayer();
		
		if(timer == 0)
		{	
			layer = player.getLayer();
			
			player.setCurrentAnimation(Assets.playerGloves[(int)player.getDirection()/2]);
			
			handler.getGame().geteManager().getEntities().removeAll(shuppets);
			shuppets.removeAll(shuppets);
			
			shuppets.add((new ShadowPuppet(handler, player.getCenterPosX(), player.getCenterPosY() - 96, player.getLayer(), 0)));
			shuppets.add((new ShadowPuppet(handler, player.getCenterPosX() + 96, player.getCenterPosY(), player.getLayer(), 2)));
			shuppets.add((new ShadowPuppet(handler, player.getCenterPosX(), player.getCenterPosY() + 96, player.getLayer(), 4)));
			shuppets.add((new ShadowPuppet(handler, player.getCenterPosX() - 96, player.getCenterPosY(), player.getLayer(), 6)));
			
			handler.getGame().geteManager().getEntities().addAll(shuppets);
		}
		timer += System.currentTimeMillis() - player.getLastTimeUsedItem();

		if(timer > 20000)
		{
			timer = 0;
			
			
			
			player.setState("CHASE");
		}
	}


	
	@Override
	public BufferedImage getIcon() {
		return Assets.itemIcons[6];
	}

	@Override
	public void reset()
	{
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g)
	{	

	}
}
