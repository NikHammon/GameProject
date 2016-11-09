package com.base.game.entity.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.Quake;
import com.base.game.entity.attacks.Tornado;

public class WingedBoots extends MainItem
{
	private Animation bootsUp;
	private Animation bootsDwn;
	private Animation bootsRgt;
	private Animation bootsLft;
	
	public WingedBoots(Handler handler)
	{
		super(handler);	
		ID = 5;
		speed = 5;
		
		bootsUp = new Animation(75, Assets.playerGBootsUp, 0);
		bootsDwn = new Animation(75, Assets.playerGBootsDwn, 0);
		bootsRgt = new Animation(75, Assets.playerGBootsRgt, 0);
		bootsLft = new Animation(75, Assets.playerGBootsLft, 0);
		
		summaryL1 = "WINGED BOOTS THAT ALLOW THE USER TO FLY THROUGH THE AIR.  HEAVENLY ENERGY";
		summaryL2 = "IS RELEASED UPON TAKEOFF THAT CAN DISPERSE LARGE GROUPS OF ENEMIES.";
	}

	float xSpeed, ySpeed;
	@Override
	public void action() 
	{	
		player = handler.getGame().getPlayer();
		
		if(distance == 0)
		{
			handler.getGame().geteManager().getEntities().add(new Quake(handler, player, player.getCenterPosX() - 56, player.getCenterPosY() - 40, player.getLayer()));
			if(player.getDirection() == UP)
			{
				player.setCurrentAnimation(bootsUp);
				ySpeed = -speed;
				xSpeed = 0;
			}
			if(player.getDirection() == 1)
			{
				player.setCurrentAnimation(bootsUp);
				ySpeed = (float) (-speed/Math.sqrt(2));
				xSpeed = (float) (speed/Math.sqrt(2));
			}
			if(player.getDirection() == 2)
			{
				player.setCurrentAnimation(bootsRgt);
				ySpeed = 0;
				xSpeed = speed;
			}
			if(player.getDirection() == 3)
			{
				player.setCurrentAnimation(bootsRgt);
				ySpeed = (float) (speed/Math.sqrt(2));
				xSpeed = (float) (speed/Math.sqrt(2));
			}
			if(player.getDirection() == 4)
			{
				player.setCurrentAnimation(bootsDwn);
				ySpeed = speed;
				xSpeed = 0;
			}
			if(player.getDirection() == 5)
			{
				player.setCurrentAnimation(bootsDwn);
				ySpeed = (float) (speed/Math.sqrt(2));
				xSpeed = (float) (-speed/Math.sqrt(2));
			}
			if(player.getDirection() == 6)
			{
				player.setCurrentAnimation(bootsLft);
				ySpeed = 0;
				xSpeed = -speed;
			}
			if(player.getDirection() == 7)
			{
				player.setCurrentAnimation(bootsLft);
				ySpeed = (float) (-speed/Math.sqrt(2));
				xSpeed = (float) (-speed/Math.sqrt(2));
			}
			if(!player.isHoldLastPos())
			{
				player.setHoldLastPos(true);
				player.setLastPosX(player.resolveToTile().x);
				player.setLastPosY(player.resolveToTile().y - 20);
				player.setLastLayer(player.getLayer());
			}
		}
		
		if(xSpeed == 0)
		{
			if(handler.getInput().left)
				xSpeed = -speed/2;
			else if(handler.getInput().right)
				xSpeed = speed/2;
		}
		else if(ySpeed == 0)
		{
			if(handler.getInput().up)
				ySpeed = -speed/2;
			else if(handler.getInput().down)
				ySpeed = speed/2;
		}
		
		player.setyMove(ySpeed);
		player.setxMove(xSpeed);
		
		distance += Math.abs(xSpeed) + Math.abs(ySpeed);
		
		if(!stopped)
			player.move();
		else
		{
			player.setxVel(0);
			player.setyVel(0);
		}
		
		if(distance > 360)
		{
			distance = 0;

			player.setState("CHASE");
			player.setxMove(xSpeed);
			player.setyMove(ySpeed);
			
			player.move();
			
			if(player.getState() != "FALLING")
			{
				if(player.getxVel() == 0)
					player.setxMove(-xSpeed);
				if(player.getyVel() == 0)
					player.setyMove(-ySpeed);
				
				player.move();
			}
			
			player.setHoldLastPos(false);
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
		return Assets.itemIcons[5];
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
