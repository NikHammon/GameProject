package com.base.game.entity.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Player;
import com.base.game.entity.monsters.BodySegment;

public class Whip extends MainItem
{
	private Animation whipUp;
	private Animation whipRgt;
	private Animation whipDwn;
	private Animation whipLft;
	
	private WhipSegment[] body;
	
	public Whip(Handler handler)
	{
		super(handler);
		ID = 2;
		state = "";
		whipDwn = new Animation(100, Assets.whipDwn, 1);
		whipUp = new Animation(100, Assets.whipUp, 1);
		whipLft = new Animation(100, Assets.whipLft, 1);
		whipRgt = new Animation(100, Assets.whipRgt, 1);
		
		state = "ACTIVATION";
		
		summaryL1 = "A WHIP IN THE FORM OF AN ELECTRIFYING SEA CREATURE.  IT CAN BE USED TO PULL";
		summaryL2 = "THE USER OVER GORGES OR STUN ENEMIES WITH CRAKLING ELECTRICITY.";
	}

	public void activate()
	{
		timer = 0;
		lastTime = System.currentTimeMillis();
		player = handler.getGame().geteManager().getPlayer();
		
		Utils.playSound("whip");
		
		player.setxVar(18);
		player.setyVar(12);
		
		layer = player.getLayer();
		if((int)player.getDirection()/2 == 0)
			player.setCurrentAnimation(whipUp);
		else if((int)player.getDirection()/2 == 1)
			player.setCurrentAnimation(whipRgt);
		else if((int)player.getDirection()/2 == 2)
			player.setCurrentAnimation(whipDwn);
		else
			player.setCurrentAnimation(whipLft);	
		
		state = "WHIP";
	}
	
	public void whipping()
	{
		if(player.getCurrentAnimation().isAlmostComplete())
		{
			body = new WhipSegment[10];
			for(int i = 0; i < body.length; i++)
			{
				body[i] = new WhipSegment(handler, player.getCenterPosX() + 30, player.getCenterPosY() + 35, player.getLayer(), i, player.getDirection()/2);
				handler.getGame().geteManager().addEntity(body[i]);
			}
			
			state = "EXTEND";
		}	
	}
	
	public void extend()
	{
		for(int i = body.length-1; i >= 0; i--)
		{
			if(i-1 >= 0)
				body[i].updateSegment(body[i-1].getX(), body[i-1].getY());	
			else
				body[0].updateHead();
		}
		
		if(timer > 20000)
		{
			state = "EXTENDED";
		}
	}
	
	public void extended()
	{
		if(timer > 20000)
		{
			state = "RECOIL";
		}
	}
	
	public void recoil()
	{
		for(int i = 0; i < body.length; i++)
		{
			if(body[i].isFinished())
			{
				handler.getGame().geteManager().removeEntity(body[i]);
			}
			else
			{
				if(i+1 < body.length)
					body[i].updateSegment(body[i+1].getX(), body[i+1].getY());	
				else
					body[i].updateTail();
			}
		}	
	}
	
	@Override
	public void action() 
	{
		
		if(state == "ACTIVATION")
			activate();
		else if(state == "WHIP")
			whipping();
		else if(state == "EXTEND")
			extend();
		else if(state == "EXTENDED")
			extended();
		else if(state == "RECOIL")
			recoil();
		
		player.getCurrentAnimation().update();

		timer += System.currentTimeMillis() - lastTime;

//		for(int i = 0; i < body.length; i++)
//		{
//			if(body[i].isTerminate())
//			{
//				reset();
//			}
//		}
		
		if(timer > 50000)
		{
			state = "ACTIVATION";
			timer = 0;
			player.setxVar(0);
			player.setyVar(0);
			for(int i = 0; i < body.length; i++)
				handler.getGame().geteManager().removeEntity(body[i]);
			player.getCurrentAnimation().reset();
			player.setState("CHASE");
		}
		
	}
	
	@Override
	public void reset() 
	{	
		state = "ACTIVATION";
		timer = 0;

		if(player != null)
		{
			player.setxVar(0);
			player.setyVar(0);
		}
		
		if(body != null)
			for(int i = 0; i < body.length; i++)
				handler.getGame().geteManager().removeEntity(body[i]);
		whipUp.reset();
		whipDwn.reset();
		whipLft.reset();
		whipRgt.reset();
		
	}

	@Override
	public BufferedImage getIcon() 
	{
		return Assets.itemIcons[2];
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	

}
