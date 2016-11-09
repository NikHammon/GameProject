package com.base.game.levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class WorldMap 
{
	private Handler handler;
	private boolean active;
	
	private int selector;
	private Animation dungeonMapIcon;
	
	private String state;
	
	public WorldMap(Handler handler)
	{
		this.handler = handler;
		dungeonMapIcon = new Animation(200, Assets.dungeonMapIcon, 0);
		state = "OPENING";
	}
	
	int nextSelector;
	float scaleX = 1250, scaleY = 600, scaleSpeed = 3;
	float xPos = 625, yPos = 300, xDir, yDir;
	float speed = 5, yVarSpeed = -.3f;
	public void update()
	{	
		if(state == "OPENING")
		{
			scaleX += scaleSpeed * 2.0833;
			xPos += (scaleSpeed * 2.0833)/2;
			
			scaleY += scaleSpeed;
			yPos += scaleSpeed/2;
			
			partClouds();
			
			if(scaleY >= 1200)
				state = "OPEN";
			
		}
		else if(state == "OPEN")
		{
			if(yVar + yVarSpeed < -50 || yVar + yVarSpeed > -40)
				yVarSpeed = -yVarSpeed;
			yVar += yVarSpeed;
			switch(selector)
			{
			case 0:
				xDir = 1090;
				yDir = 610;
				if(handler.getInput().rightPressed)
					nextSelector = 3;
				else if(handler.getInput().leftPressed)
					nextSelector = 1;
				else if(handler.getInput().downPressed)
					nextSelector = 2;
				else if(handler.getInput().upPressed)
					nextSelector = 4;
				break;
			case 1:
				xDir = 630;
				yDir = 540;
				if(handler.getInput().rightPressed)
					nextSelector = 0;
				else if(handler.getInput().downPressed)
					nextSelector = 2;
				else if(handler.getInput().upPressed)
					nextSelector = 4;
				break;
			case 2:
				xDir = 910;
				yDir = 770;
				if(handler.getInput().rightPressed)
					nextSelector = 3;
				else if(handler.getInput().leftPressed)
					nextSelector = 1;
				else if(handler.getInput().upPressed)
					nextSelector = 0;
				else if(handler.getInput().downPressed)
					nextSelector = 6;
				break;
			case 3:
				xDir = 1470;
				yDir = 920;
				if(handler.getInput().leftPressed)
					nextSelector = 0;
				else if(handler.getInput().upPressed)
					nextSelector = 7;
				else if(handler.getInput().rightPressed)
					nextSelector = 5;
				break;
			case 4:
				xDir = 1190;
				yDir = 270;
				if(handler.getInput().leftPressed)
					nextSelector = 1;
				else if(handler.getInput().rightPressed)
					nextSelector = 7;
				else if(handler.getInput().downPressed)
					nextSelector = 0;
				break;
			case 5:
				xDir = 1870;
				yDir = 680;
				if(handler.getInput().leftPressed)
					nextSelector = 0;
				else if(handler.getInput().upPressed)
					nextSelector = 7;
				break;
			case 6:
				xDir = 880;
				yDir = 980;
				if(handler.getInput().leftPressed)
					nextSelector = 1;
				else if(handler.getInput().upPressed)
					nextSelector = 2;
				else if(handler.getInput().rightPressed)
					nextSelector = 3;
				break;
			case 7:
				xDir = 1490;
				yDir = 380;
				if(handler.getInput().leftPressed)
					nextSelector = 0;
				else if(handler.getInput().upPressed)
					nextSelector = 4;
				else if(handler.getInput().downPressed)
					nextSelector = 3;
				else if(handler.getInput().rightPressed)
					nextSelector = 5;
				break;
			}
			
			if(nextSelector < handler.getBaseCamp().getDungeonsUnlocked() && !permSelector)
				selector = nextSelector;
			
			if(Math.abs(xPos) + speed < Math.abs(xDir) || Math.abs(xPos) - speed > Math.abs(xDir))
				xPos += (xDir - xPos)/(Math.abs(xPos - xDir) + Math.abs(yPos - yDir)) * speed;
			if(Math.abs(yPos) + speed < Math.abs(yDir) || Math.abs(yPos) - speed > Math.abs(yDir))
				yPos += (yDir - yPos)/(Math.abs(xPos - xDir) + Math.abs(yPos - yDir)) * speed;
			
			if(handler.getInput().a)
			{
				handler.getGame().getGameState().getLevelManager().setCurrentDungeon(selector);
				handler.getGame().getPlayer().setCameraActive(false);
				handler.getGame().getPlayer().setState("IDLE");
				handler.getCamera().setxOffset(510);
				handler.getCamera().setyOffset(2530);
				handler.getGame().getPlayer().setX(0);
				handler.getGame().getPlayer().setY(0);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setActiveBoat(true);
				reset();
			}
			if(handler.getInput().d && !permSelector)
			{
				handler.getGame().getPlayer().setForceMove("UP", "UP");
				reset();
			}
			
			dungeonMapIcon.update();
		}
		
	}
	
	Random rand = new Random();
	float[] cloudPosX = {0, 50, 100, 150, 200, 250, 0 , 50 , 100, 150, 200, 250, 0  , 50 , 100, 150, 200, 250};
	float[] cloudPosY = {0, 50, 100, 150, 200, 250, 50, 100, 150, 200, 250, 0  , 100, 150, 200, 250, 0  , 50 };
	float cloudSpeed = 3.5f;
	private void partClouds()
	{
		for(int i = 0; i < cloudPosX.length; i++)
		{
			if(i%2 == 0)
			{
				cloudPosX[i] -= (cloudSpeed+rand.nextInt(2));
			}
			else
			{
				cloudPosX[i] += (cloudSpeed+rand.nextInt(2));
			}
		}
	}
	
	private void reset()
	{
		float[] cloudPosX = {0, 50, 100, 150, 200, 250, 0 , 50 , 100, 150, 200, 250, 0  , 50 , 100, 150, 200, 250};
		float[] cloudPosY = {0, 50, 100, 150, 200, 250, 50, 100, 150, 200, 250, 0  , 100, 150, 200, 250, 0  , 50 };
		handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("MAINAREA");
		handler.getGame().getPlayer().setPaused(false);	
		permSelector = false;
		active = false;
		state = "OPENING";
		scaleX = 1250;scaleY = 600;
		xPos = 625; yPos = 300;
	}
	
	String text;
	float yVar = -45;
	public void render(Graphics g)
	{
		g.drawImage(Assets.worldMap, (int)-xPos + handler.getWidth()/2, (int)-yPos + handler.getHeight()/2, (int)scaleX, (int)scaleY, null);
		
		if(state == "OPENING")
		{
			for(int i = 0; i < cloudPosX.length; i++)
			{
				g.drawImage(Assets.mapCloud, (int)cloudPosX[i], (int)cloudPosY[i], null);
			}
		}
		if(state == "OPEN")
		{
			switch(handler.getBaseCamp().getDungeonsUnlocked())
			{
			case 8:
				g.drawImage(Assets.dungeonMapIcon[0], (int)(1490 - xPos + handler.getWidth()/2), (int)(380 - yPos + handler.getHeight()/2), null);
				if(handler.getBaseCamp().getDungeonsCleared() < 8)
					g.drawImage(Assets.bossIcon, (int)(1490 - xPos - 8 + handler.getWidth()/2), (int)(380 - yPos + yVar + handler.getHeight()/2), null);
				for(Quest q : handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests())
					if(q.getLocation().equals(handler.getGame().getGameState().getLevelManager().getDungeons().get(7).getName()))
						g.drawImage(Assets.scrollTaken, (int)(1490 - xPos - 8 + handler.getWidth()/2), (int)(380 - yPos + yVar + handler.getHeight()/2), null);
			case 7:
				g.drawImage(Assets.dungeonMapIcon[0], (int)(880 - xPos + handler.getWidth()/2), (int)(980 - yPos + handler.getHeight()/2), null);
				if(handler.getBaseCamp().getDungeonsCleared() < 7)
					g.drawImage(Assets.bossIcon, (int)(880 - xPos - 8 + handler.getWidth()/2), (int)(980 - yPos + yVar + handler.getHeight()/2), null);
				for(Quest q : handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests())
					if(q.getLocation().equals(handler.getGame().getGameState().getLevelManager().getDungeons().get(6).getName()))
						g.drawImage(Assets.scrollTaken, (int)(880 - xPos - 8 + handler.getWidth()/2), (int)(980 - yPos + yVar + handler.getHeight()/2), null);
			case 6:
				g.drawImage(Assets.dungeonMapIcon[0], (int)(1870 - xPos + handler.getWidth()/2), (int)(680 - yPos + handler.getHeight()/2), null);
				if(handler.getBaseCamp().getDungeonsCleared() < 6)
					g.drawImage(Assets.bossIcon, (int)(1870 - xPos - 8 + handler.getWidth()/2), (int)(680 - yPos + yVar + handler.getHeight()/2), null);
				for(Quest q : handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests())
					if(q.getLocation().equals(handler.getGame().getGameState().getLevelManager().getDungeons().get(5).getName()))
						g.drawImage(Assets.scrollTaken, (int)(1870 - xPos - 8 + handler.getWidth()/2), (int)(680 - yPos + yVar + handler.getHeight()/2), null);
			case 5:
				g.drawImage(Assets.dungeonMapIcon[0], (int)(1190 - xPos + handler.getWidth()/2), (int)(270 - yPos + handler.getHeight()/2), null);
				if(handler.getBaseCamp().getDungeonsCleared() < 5)
					g.drawImage(Assets.bossIcon, (int)(1190 - xPos - 8 + handler.getWidth()/2), (int)(270 - yPos + yVar + handler.getHeight()/2), null);
				for(Quest q : handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests())
					if(q.getLocation().equals(handler.getGame().getGameState().getLevelManager().getDungeons().get(4).getName()))
						g.drawImage(Assets.scrollTaken, (int)(1190 - xPos - 8 + handler.getWidth()/2), (int)(270 - yPos + yVar + handler.getHeight()/2), null);
			case 4:
				g.drawImage(Assets.dungeonMapIcon[0], (int)(1470 - xPos + handler.getWidth()/2), (int)(920 - yPos + handler.getHeight()/2), null);
				if(handler.getBaseCamp().getDungeonsCleared() < 4)
					g.drawImage(Assets.bossIcon, (int)(1470 - xPos - 8 + handler.getWidth()/2), (int)(920 - yPos + yVar + handler.getHeight()/2), null);
				for(Quest q : handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests())
					if(q.getLocation().equals(handler.getGame().getGameState().getLevelManager().getDungeons().get(3).getName()))
						g.drawImage(Assets.scrollTaken, (int)(1470 - xPos - 8 + handler.getWidth()/2), (int)(920 - yPos + yVar + handler.getHeight()/2), null);
			case 3:
				g.drawImage(Assets.dungeonMapIcon[0], (int)(910 - xPos + handler.getWidth()/2), (int)(770 - yPos + handler.getHeight()/2), null);
				if(handler.getBaseCamp().getDungeonsCleared() < 3)
					g.drawImage(Assets.bossIcon, (int)(910 - xPos - 8 + handler.getWidth()/2), (int)(770 - yPos + yVar + handler.getHeight()/2), null);
				for(Quest q : handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests())
					if(q.getLocation().equals(handler.getGame().getGameState().getLevelManager().getDungeons().get(2).getName()))
						g.drawImage(Assets.scrollTaken, (int)(910 - xPos - 8 + handler.getWidth()/2), (int)(770 - yPos + yVar + handler.getHeight()/2), null);
			case 2:
				g.drawImage(Assets.dungeonMapIcon[0], (int)(630 - xPos + handler.getWidth()/2), (int)(540 - yPos + handler.getHeight()/2), null);	
				if(handler.getBaseCamp().getDungeonsCleared() < 2)
					g.drawImage(Assets.bossIcon, (int)(630 - xPos - 8 + handler.getWidth()/2), (int)(540 - yPos + yVar + handler.getHeight()/2), null);
				for(Quest q : handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests())
					if(q.getLocation().equals(handler.getGame().getGameState().getLevelManager().getDungeons().get(1).getName()))
						g.drawImage(Assets.scrollTaken, (int)(630 - xPos - 8 + handler.getWidth()/2), (int)(540 - yPos + yVar + handler.getHeight()/2), null);
			case 1:
				g.drawImage(Assets.dungeonMapIcon[0], (int)(1090 - xPos + handler.getWidth()/2), (int)(610 - yPos + handler.getHeight()/2), null);
				if(handler.getBaseCamp().getDungeonsCleared() < 1)
					g.drawImage(Assets.bossIcon, (int)(1090 - xPos - 8 + handler.getWidth()/2), (int)(610 - yPos + yVar + handler.getHeight()/2), null);
				for(Quest q : handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests())
					if(q.getLocation().equals(handler.getGame().getGameState().getLevelManager().getDungeons().get(0).getName()))
						g.drawImage(Assets.scrollTaken, (int)(1090 - xPos - 8 + handler.getWidth()/2), (int)(610 - yPos + yVar + handler.getHeight()/2), null);
				break;
			}
			
			g.drawImage(dungeonMapIcon.getCurrentFrame(), (int)(xDir - xPos + handler.getWidth()/2), (int)(yDir - yPos + handler.getHeight()/2), null);
		
			text = handler.getGame().getGameState().getLevelManager().getDungeons().get(selector).getName();
			g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
			g.setColor(Color.BLACK);
			g.drawString(text, (handler.getWidth() - g.getFontMetrics().stringWidth(text))/2, 100);
			g.setColor(Color.WHITE);
			g.drawString(text, (handler.getWidth() - g.getFontMetrics().stringWidth(text))/2 - 2, 98);
		}
	}

	public boolean isActive() {return active;}
	public void setActive(boolean active) {this.active = active;}

	public int getSelector() {
		return selector;
	}

	boolean permSelector;
	public void setPermSelector(int selector) 
	{
		permSelector = true;
		this.selector = selector;
	}	
	
}
