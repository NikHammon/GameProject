package com.base.game.entity.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Player;
import com.base.game.entity.attacks.FireBall;
import com.base.game.entity.attacks.Tornado;

public class GunLance extends MainItem
{
	private Animation attackDownGunLance, attackLeftGunLance, attackRightGunLance, attackUpGunLance, attackDownLeftGunLance, attackDownRightGunLance, attackUpLeftGunLance, attackUpRightGunLance;
	
	public GunLance(Handler handler)
	{
		super(handler);	
		ID = 7;
		
		attackDownGunLance = new Animation(125, Assets.attackDownGunLance, 1);
		attackLeftGunLance = new Animation(125, Assets.attackLeftGunLance, 1);
		attackRightGunLance = new Animation(125, Assets.attackRightGunLance, 1);
		attackUpGunLance = new Animation(125, Assets.attackUpGunLance, 1);
		attackDownLeftGunLance = new Animation(125, Assets.attackDownLeftGunLance, 1);
		attackDownRightGunLance = new Animation(125, Assets.attackDownRightGunLance, 1);
		attackUpLeftGunLance = new Animation(125, Assets.attackUpLeftGunLance, 1);
		attackUpRightGunLance = new Animation(125, Assets.attackUpRightGunLance, 1);
		state = "ACTIVATION";
		
		summaryL1 = "A PORTABLE MORTAR.  THE WEAPONIZED PLASMA IT BELCHES FROM THE DRAGON-HEAD ";
		summaryL2 = "CANNON MELTS FOES ON IMPACT.";
	}

	@Override
	public void action() 
	{	 
		if(state == "ACTIVATION")
			activate();
		else if(state == "FIRING")
		{
			if(player.getCurrentAnimation().isComplete())
			{
				//Utils.playSound("wind.wav");
				handler.getGame().geteManager().addEntity(new FireBall(handler, player, player.getX(), player.getY(), player.getLayer(), player.getDirection()));	
					
				player.getCurrentAnimation().reset();
				player.setState("CHASE");
				state = "ACTIVATION";
			}
		}

	}
	
	public void activate()
	{
		
		player = handler.getGame().geteManager().getPlayer();
		layer = player.getLayer();
		
		player.setxVar(6);
		player.setyVar(16);
		
		if(player.getDirection() == UP)
			player.setCurrentAnimation(attackUpGunLance);
		else if(player.getDirection() == UPRIGHT)
			player.setCurrentAnimation(attackUpRightGunLance);
		else if(player.getDirection() == RIGHT)
			player.setCurrentAnimation(attackRightGunLance);
		else if(player.getDirection() == DOWNRIGHT)
			player.setCurrentAnimation(attackDownRightGunLance);
		else if(player.getDirection() == DOWN)
			player.setCurrentAnimation(attackDownGunLance);
		else if(player.getDirection() == DOWNLEFT)
			player.setCurrentAnimation(attackDownLeftGunLance);
		else if(player.getDirection() == LEFT)
			player.setCurrentAnimation(attackLeftGunLance);
		else
			player.setCurrentAnimation(attackUpLeftGunLance);
		
		state = "FIRING";
	}
	
	@Override
	public void update() 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public BufferedImage getIcon() {
		return Assets.itemIcons[7];
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}
