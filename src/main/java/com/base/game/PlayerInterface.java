package com.base.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;

import com.base.game.entity.item.Gauntlet;

public class PlayerInterface 
{
	private Handler handler;
	private String state;
	
	private boolean active;
	
	public PlayerInterface(Handler handler)
	{
		this.handler = handler;		
		state = "NORMAL";
		active = true;
	}
	
	//int healthToDisplay, hCrystalsToDisplay;
	public void update()
	{
		if(active)
		{
			updateHpBar();
	
			if(state == "ITEMW")
				updateItemW();
			if(state == "ITEMS")
				updateItemS();
			if(state == "ITEMD")
				updateItemD();
		}
	}

	public void render(Graphics g)
	{
		if(active)
		{
			g.drawImage(Assets.hpDisplay, 10, 10, 352, 230, null);
	
			if(handler.getGame().getPlayer().getItemW() != null)
				g.drawImage(handler.getGame().getPlayer().getItemW().getIcon(), 35 - witemWidth/2, 25 - witemHeight/2, 100 + witemWidth, 100 + witemHeight, null);
			if(handler.getGame().getPlayer().getItemS() != null)
				g.drawImage(handler.getGame().getPlayer().getItemS().getIcon(), 0 - sitemWidth/2, 130 - sitemHeight/2, 100 + sitemWidth, 100 + sitemHeight, null);
			if(handler.getGame().getPlayer().getItemD() != null)
				g.drawImage(handler.getGame().getPlayer().getItemD().getIcon(), 100 - ditemWidth/2, 115 - ditemHeight/2, 100 + ditemWidth, 100 + ditemHeight, null);
			
			for(int i = 0; i < handler.getGame().getPlayer().getHealth(); i++)
				g.drawImage(Utils.tintImage(Assets.hpBar, rVal, 50, 50), 140 + i * 17, 57, 21, 23, null);
			
			g.drawImage(Assets.wallet, 180, 110, 32, 32, null);
			g.setColor(Color.BLACK);
			g.setFont(new Font(handler.getGame().font, Font.BOLD, 20));
			g.drawString(handler.getGame().getPlayer().getMoney(), 212, 137);
			g.setColor(Color.WHITE);
			g.drawString(handler.getGame().getPlayer().getMoney(), 210, 135);
			
			switch(handler.getGame().getPlayer().getStatusCondition())
			{
			case "POISONED":
				g.drawImage(Assets.posiIcon, 250, 110, 32, 32, null);
				break;
			case "PARALYZED":
				g.drawImage(Assets.paraIcon, 250, 110, 32, 32, null);
				break;
			case "BURNED":
				g.drawImage(Assets.burIcon, 250, 110, 32, 32, null);
				break;
			case "FROZEN":
				g.drawImage(Assets.freezIcon, 250, 110, 32, 32, null);
				break;
			}
					
			for(int i = 0; i < handler.getGame().getPlayer().getTotalHeartCrystals(); i++)
			{
				if(i < handler.getGame().getPlayer().getActiveHeartCrystals())
					g.drawImage(Assets.heartCrystal, 135 + i * 17, 77, 32, 32, null);
				else
					g.drawImage(Assets.usedHeartCrystal, 135 + i * 17, 77, 32, 32, null);
			}
		}
	}
	
	int witemWidth, witemHeight, sitemWidth, sitemHeight, ditemWidth, ditemHeight;
	
	int increaseRate = 4;

	private void updateItemW()
	{
		witemWidth += increaseRate;
		witemHeight += increaseRate;
		if(witemWidth > 30)
			increaseRate = -increaseRate;
		if(witemWidth <= 0 || witemHeight <= 0)
		{
			witemWidth = 0;
			witemHeight = 0;
			increaseRate = -increaseRate;
			state = "NORMAL";
		}
	}

	private void updateItemS()
	{
		sitemWidth += increaseRate;
		sitemHeight += increaseRate;
		if(sitemWidth > 30)
			increaseRate = -increaseRate;
		if(sitemWidth <= 0 || sitemHeight <= 0)
		{
			sitemWidth = 0;
			sitemHeight = 0;
			increaseRate = -increaseRate;
			state = "NORMAL";
		}
	}

	private void updateItemD()
	{
		ditemWidth += increaseRate;
		ditemHeight += increaseRate;
		if(ditemWidth > 30)
			increaseRate = -increaseRate;
		if(ditemWidth <= 0 || ditemHeight <= 0)
		{
			ditemWidth = 0;
			ditemHeight = 0;
			increaseRate = -increaseRate;
			state = "NORMAL";
		}
	}

	int rVal=150;
	int rRate = 5;
	private void updateHpBar()
	{
		rVal += rRate;
		if(rVal < 150 || rVal + rRate > 250)
			rRate = -rRate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
