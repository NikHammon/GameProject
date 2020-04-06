package com.base.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.base.game.entity.item.Item;
import com.base.game.levels.Quest;

@SuppressWarnings("serial")
public class UserData implements Serializable
{
	private boolean isFile;
	private int totalHours, totalMins;
	private int playerHealth, wItemNum = -1, sItemNum = -1, dItemNum = -1, money, activeHeartCrystals, totalHeartCrystals;
	private int gameProgress, dungeonsUnlocked, dungeonsCleared, questsCompleted, questTracker;
	private int[] mainItemLevels;
	private boolean[] chestsOpened;
	private List<Item> inventory;
	private List<Quest> myQuests, boardQuests;
	
	public void updateData(Handler handler) {
		isFile = true;
		totalHours = handler.getGame().getGameState().getTotalHours();
		totalMins = handler.getGame().getGameState().getTotalMins();
		playerHealth = handler.getGame().getPlayer().getHealth();
		activeHeartCrystals = handler.getGame().getPlayer().getActiveHeartCrystals();
		totalHeartCrystals = handler.getGame().getPlayer().getTotalHeartCrystals();
		money = Integer.parseInt(handler.getGame().getPlayer().getMoney());
		inventory = handler.getGame().getGameState().getLevelManager().getiInterface().getInventory();
		myQuests = handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests();
		boardQuests = handler.getGame().getGameState().getLevelManager().getBaseCamp().getqBoard().getQuests();
		
		gameProgress = handler.getGame().getGameState().getLevelManager().getBaseCamp().getGameProgress();
		dungeonsUnlocked = handler.getBaseCamp().getDungeonsUnlocked();
		dungeonsCleared = handler.getBaseCamp().getDungeonsCleared();
		
		questsCompleted = handler.getGame().getGameState().getLevelManager().getBaseCamp().getQuestsCompleted();
		questTracker = handler.getGame().getGameState().getLevelManager().getBaseCamp().getQuestTracker();
		
		wItemNum = sItemNum = dItemNum = -1;

		if(handler.getGame().getPlayer().getItemW() != null)
			wItemNum = handler.getGame().getPlayer().getItemW().getID();
		if(handler.getGame().getPlayer().getItemS() != null)
			sItemNum = handler.getGame().getPlayer().getItemS().getID();
		if(handler.getGame().getPlayer().getItemD() != null)
			dItemNum = handler.getGame().getPlayer().getItemD().getID();
		
		chestsOpened = handler.getBaseCamp().getChestsOpened();
	
		
		mainItemLevels = new int[handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems().length];
		for(int i = 0; i < handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems().length; i++)
			mainItemLevels[i] = handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i].getLevel();
	}
	
	public void setData(Handler handler) {
		if(!isFile) {
			totalHours = totalMins = 0;
			wItemNum = sItemNum = dItemNum = -1;
			gameProgress = dungeonsUnlocked = questsCompleted = 0; questTracker = -1;
			handler.getGame().getPlayer().setX(930);
			handler.getGame().getPlayer().setY(480);
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("MAINAREA");
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setNPCs();
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setBarriers();
		}
		else {
			handler.getGame().getGameState().setTotalHours(totalHours);
			handler.getGame().getGameState().setTotalMins(totalMins);
			
			handler.getGame().getPlayer().setHealth(playerHealth);
			handler.getGame().getPlayer().setActiveHeartCrystals(activeHeartCrystals);
			handler.getGame().getPlayer().setTotalHeartCrystals(totalHeartCrystals);
			handler.getGame().getPlayer().setMoney(money);
			
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setGameProgress(gameProgress);
			handler.getBaseCamp().setDungeonsUnlocked(dungeonsUnlocked);
			handler.getBaseCamp().setDungeonsCleared(dungeonsCleared);
			
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setQuestsCompleted(questsCompleted);
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setQuestTracker(questTracker);

			handler.getGame().geteManager().getPlayer().setDirection(4);
			handler.getGame().geteManager().getPlayer().setX(252);
			handler.getGame().geteManager().getPlayer().setY(244);
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("BEDROOM");
			handler.getGame().getGameState().getLevelManager().getBaseCamp().setBarriers();
			
			if(inventory != null)
				handler.getGame().getGameState().getLevelManager().getiInterface().setInventory(inventory);
			else
				handler.getGame().getGameState().getLevelManager().getiInterface().setInventory(new ArrayList<Item>());
			
			if(myQuests != null)
				handler.getGame().getGameState().getLevelManager().getiInterface().setMyQuests(myQuests);
			else
				handler.getGame().getGameState().getLevelManager().getiInterface().setMyQuests(new ArrayList<Quest>());
			
			if(boardQuests != null)
				handler.getGame().getGameState().getLevelManager().getBaseCamp().getqBoard().setQuests(boardQuests);
			else
				handler.getGame().getGameState().getLevelManager().getBaseCamp().getqBoard().setQuests(new ArrayList<Quest>());
			
			if(wItemNum >= 0) {
				handler.getGame().getPlayer().setItemW(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[wItemNum]);
				handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[wItemNum].setEquipped(true);
			}
			if(sItemNum >= 0) {
				handler.getGame().getPlayer().setItemS(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[sItemNum]);
				handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[sItemNum].setEquipped(true);
			}
			if(dItemNum >= 0) {
				handler.getGame().getPlayer().setItemD(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[dItemNum]);
				handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[dItemNum].setEquipped(true);
			}
			
			handler.getBaseCamp().setChestsOpened(chestsOpened);
			
			for(int i = 0; i < mainItemLevels.length; i++)
				handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i].setLevel(mainItemLevels[i]);
		}
	}
	public int getTotalHeartCrystals() {
		return totalHeartCrystals;
	}

	public void setTotalHeartCrystals(int totalHeartCrystals) {
		this.totalHeartCrystals = totalHeartCrystals;
	}

	public int getActiveHeartCrystals() {
		return activeHeartCrystals;
	}

	public void setActiveHeartCrystals(int activeHeartCrystals) {
		this.activeHeartCrystals = activeHeartCrystals;
	}

	public boolean isFile() {
		return isFile;
	}

	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
	
	public String getTotalPlayTime() {
		return (totalMins < 10) ? String.format("%d:0%d", totalHours, totalMins):
								  String.format("%d:%d", totalHours, totalMins);
	}
}
