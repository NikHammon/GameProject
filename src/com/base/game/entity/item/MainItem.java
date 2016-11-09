package com.base.game.entity.item;

import java.awt.image.BufferedImage;

import com.base.game.Handler;
import com.base.game.entity.Entity;
import com.base.game.entity.Player;

public abstract class MainItem extends Entity
{
	protected Player player;
	
	protected int knockBack; //presumably value to do with how much knockback an Item applies to its targets
	protected int damage;// damage value of an item
	protected float speed; // ?
	protected int distance;// ?
	protected boolean stopped;// boolean value that tells code that an action is already in progress
	
	protected int ID, level;
	protected boolean isEquipped;
	protected String summaryL1, summaryL2, summaryL3;
	
	public MainItem(Handler handler) 
	{
		super(handler, 0, 0, 0, 0, 0);
		ID = -1;
		summaryL1 = "";
		summaryL2 = "";
		summaryL3 = "";
	}
	
	public int getUpgradeValue()
	{
		switch(level)
		{
		case 0:
			return 2;
		case 1:
			return 5;
		case 2:
			return 10;
		case 3:
			return 20;
		case 4:
			return 50;
		}
		return 0;
	}
	
	public void upgrade()
	{
		level++;
	}

	public abstract void action();
	public void secondAction(){};
	public abstract BufferedImage getIcon();
	public abstract void reset();
	public int getID() {return ID;}
	public void setID(int iD) {ID = iD;}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isEquipped() {
		return isEquipped;
	}

	public void setEquipped(boolean isEquipped) {
		this.isEquipped = isEquipped;
	}

	public String getSummaryL1() {
		return summaryL1;
	}

	public void setSummaryL1(String summary) {
		this.summaryL1 = summary;
	}

	public String getSummaryL2() {
		return summaryL2;
	}

	public void setSummaryL2(String summaryL2) {
		this.summaryL2 = summaryL2;
	}

	public String getSummaryL3() {
		return summaryL3;
	}

	public void setSummaryL3(String summaryL3) {
		this.summaryL3 = summaryL3;
	}
	
	
}
