package com.base.game.levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Selector;

public class QuestBoard 
{
	private Handler handler;
	private List<Quest> quests;
	private Selector selectorBox;
	
	private int selectorX, selectorY;
	private boolean active;
	
	public QuestBoard(Handler handler)
	{
		this.handler = handler;
		quests = new ArrayList<Quest>();
		selectorBox = new Selector(90, 80, 340, 100);
		
	}
	
	public void update()
	{
		selectorBox.update();
		
		if(!handler.getGame().getGameState().getEffects().isActiveDBox())
		{
			if(handler.getInput().upPressed && selectorY > 0)
			{
				selectorY--;
			}
			else if(handler.getInput().downPressed && selectorY < Math.min(quests.size(), 3))
			{
				selectorY++;
			}
			else if(handler.getInput().leftPressed && selectorX > 0)
			{
				selectorX--;
			}
			else if(handler.getInput().rightPressed && selectorX < 1 && quests.size() > 4)
			{
				selectorX++;
			}
			
			selectorBox.setX(90 + selectorX * 340);
			
			if(selectorX > 0 && quests.size() - 5 < selectorY)
				selectorY = quests.size() - 5;
				
			selectorBox.setY(80 + selectorY * 100);
			
			if(handler.getInput().a)
			{
				if(selectorX == 0)
				{
					if(handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().size()<8)
					{
						quests.get(selectorY).setTaken(true);
						handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().add(quests.get(selectorY));
					}
					else
					{
						handler.getGame().getGameState().getEffects().displayDialog(4);
					}
				}
				else
				{
					if(handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().size()<8)
					{
						quests.get(selectorY + 4).setTaken(true);
						handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().add(quests.get(selectorY + 4));
					}
					else
					{
						handler.getGame().getGameState().getEffects().displayDialog(4);
					}
				}
			}
		}
	}
	
	
	
	
	String text;
	Color txtColor;
	public void render(Graphics g)
	{
		g.drawImage(Assets.box800x500, 80, 20, null);
		
		text = "QUEST BOARD";
		g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
		g.setColor(Color.BLACK);
		g.drawString(text, 97, 62);
		g.setColor(Color.WHITE);
		g.drawString(text, 95, 60);
		g.drawLine(95, 65, 865, 65);
		
		for(int i = 0; i < Math.min(4, quests.size()); i++)
		{
			if(quests.get(i).isTaken())
			{
				g.drawImage(Assets.scrollTaken, 90, 85 + i*100, null);
				txtColor = new Color(150, 0, 5);
			}
			else
			{
				g.drawImage(Assets.scroll, 90, 85 + i*100, null);
				txtColor = Color.WHITE;
			}
			g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
			g.setColor(txtColor);
			g.drawString(quests.get(i).getTxtLine1(), 125, 100 + i*100);
			g.drawString(quests.get(i).getTxtLine2(), 125, 115 + i*100);
			g.drawString("CLIENT:", 125, 130 + i*100);
			if(!quests.get(i).isTaken())
				g.setColor(new Color(165, 150, 225));
			g.drawString(quests.get(i).getClient(), 250, 130 + i*100);
			g.setColor(txtColor);
			g.drawString("OBJECTIVE:", 125, 145 + i*100);
			g.drawString(quests.get(i).getObjective(), 250, 145 + i*100);		
			g.drawString("LOCATION:", 125, 160 + i*100);
			if(!quests.get(i).isTaken())
				g.setColor(new Color(230, 140, 75));
			g.drawString(quests.get(i).getLocation() + " " + quests.get(i).getFloorNum() + "F", 250, 160 + i*100);
			g.setColor(txtColor);
			g.drawString("DIFFICULTY:", 125, 175 + i*100);
			g.drawString(quests.get(i).getDifficulty(), 250, 175 + i*100);
		}
		
		for(int i = 4; i < quests.size(); i++)
		{
			if(quests.get(i).isTaken())
			{
				g.drawImage(Assets.scrollTaken, 435, 85 + (i-4)*100, null);
				txtColor = new Color(150, 0, 5);
			}
			else
			{
				g.drawImage(Assets.scroll, 435, 85 + (i-4)*100, null);
				txtColor = Color.WHITE;
			}
			g.setColor(txtColor);
			g.drawString(quests.get(i).getTxtLine1(), 470, 100 + (i-4)*100);
			g.drawString(quests.get(i).getTxtLine2(), 470, 115 + (i-4)*100);
			g.drawString("CLIENT:", 470, 130 + (i-4)*100);
			if(!quests.get(i).isTaken())
				g.setColor(new Color(165, 150, 225));
			g.drawString(quests.get(i).getClient(), 595, 130 + (i-4)*100);
			g.setColor(txtColor);
			g.drawString("OBJECTIVE:", 470, 145 + (i-4)*100);
			g.drawString(quests.get(i).getObjective(), 595, 145 + (i-4)*100);
			g.drawString("LOCATION:", 470, 160 + (i-4)*100);
			if(!quests.get(i).isTaken())
				g.setColor(new Color(230, 140, 75));
			g.drawString(quests.get(i).getLocation() + " " + quests.get(i).getFloorNum() + "F", 595, 160 + (i-4)*100);
			g.setColor(txtColor);
			g.drawString("DIFFICULTY:", 470, 175 + (i-4)*100);
			g.drawString(quests.get(i).getDifficulty(), 595, 175 + (i-4)*100);
		}
		
		selectorBox.render(g);
	}
	
	String[]txtLine1Rescue = {"I got lost while exploring...", "I can't find my way back.", "I was defeated in battle.", "I'm so lost in this dungeon.",
								"It's too dangerous to continue.", "I can't go on much longer"};
	
	String[]txtLine2Rescue = {"Please Help!", "You're my only hope!", "Someone, save me!", "Please! I need your help!",
							  "Rescue would be much apprciated", "Rescue me anyone!", "Come find me!", "Save me! Before it's too late!"};

	String[]clientMale = {"Adair", "Aurlius", "Bastian", "Chaniel", "Cassius", "Darius", "Destin", "Eoin", "Evanth", "Fynrick", "Fyodor",
						  "Gareth", "Griffin", "Hadriel", "Ignatius", "Kyler", "Lucien", "Marius", "Mathieu", "Nuriel", "Neirin", "Orion", "Orpheus", 
						  "Perceus", "Peregrine", "Remus", "Rhydderch", "Bastian", "Seraphim", "Thaniel", "Torin", "Urien", "Vasilis", "Xanthus", "Yestin",
						  "Zephyr", "Zorion"};
	String[]clientFemale = {"Alissa", "Alixandra", "Arcadia", "Breena", "Brielle", "Cora", "Cassandra", "Devlyn", "Elysia", "Evadne",
							"Guinevere", "Ginerva", "Hermoine", "Jessalyn", "Kara", "Kyrielle", "Leila", "Lilith", "Maia", "Maylea",
							"Natania", "Nerys", "Nyssa", "Oleisa", "Ozara", "Persephone", "Quintessa", "Quinevere", "Raisa", "Riona",
							"Sarai", "Seraphina", "Thalia", "Tristana", "Vespera", "Xara", "Xylia", "Yadira", "Zaira", "Zora"};

	Random rand = new Random();
	String txtLine1, txtLine2, client, objective, location, difficulty;
	int floorNum;
	int[] floorNums;
	boolean isClientMale;
	public void generateQuests()
	{
		selectorX = 0;selectorY = 0;
		quests.removeAll(quests);
		
		int numOfQuests;
		if(handler.getBaseCamp().getDungeonsUnlocked() < 5)
			numOfQuests = rand.nextInt(3) + 1;
		else
			numOfQuests = rand.nextInt(3) + 5;
		
		for(int i = 0; i < numOfQuests; i++)
		{
			switch(0)
			{
			case 0://rescue case
				if(rand.nextInt(2) == 0)
				{
					client = clientMale[rand.nextInt(clientMale.length)];
					isClientMale = true;
				}
				else
				{
					client = clientFemale[rand.nextInt(clientFemale.length)];
					isClientMale = false;
				}
				txtLine1 = txtLine1Rescue[rand.nextInt(txtLine1Rescue.length)];
				txtLine2 = txtLine2Rescue[rand.nextInt(txtLine2Rescue.length)];
				objective = "RESCUE " + client;
				int dungeon = rand.nextInt(handler.getBaseCamp().getDungeonsUnlocked());
				location = handler.getGame().getGameState().getLevelManager().getDungeons().get(dungeon).getName();
				
				//make sure two quests do not happen on same floor
				floorNums = new int[quests.size() + handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().size()];
				
				for(int a = 0; a < quests.size(); a++)
					floorNums[a] = quests.get(a).getFloorNum();
				for(int b = quests.size(); b < handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().size(); b++)
					floorNums[b] = handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests().get(b - quests.size()).getFloorNum();
				int desiredFloor = rand.nextInt(handler.getGame().getGameState().getLevelManager().getDungeons().get(dungeon).getMaxFloors()) + 1;
				int tries = 0;
				while(Arrays.asList(floorNums).contains(desiredFloor) && tries < 5)
				{
					desiredFloor = rand.nextInt(handler.getGame().getGameState().getLevelManager().getDungeons().get(dungeon).getMaxFloors()) + 1;
					tries++;
				}
				
				floorNum = desiredFloor;
						
				difficulty = "EASY";
				
				quests.add(new Quest(txtLine1, txtLine2, client, objective, location, floorNum, difficulty, isClientMale));
				break;
			}
		}
		
		
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Quest> getQuests() {
		return quests;
	}

	public void setQuests(List<Quest> quests) {
		this.quests = quests;
	}

	
}
