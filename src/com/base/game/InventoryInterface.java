package com.base.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import com.base.game.entity.item.Amulet;
import com.base.game.entity.item.Gauntlet;
import com.base.game.entity.item.WingedBoots;
import com.base.game.levels.Quest;
import com.base.game.entity.item.GunLance;
import com.base.game.entity.item.Item;
import com.base.game.entity.item.MainItem;
import com.base.game.entity.item.MonkeyStaff;
import com.base.game.entity.item.PuppetHands;
import com.base.game.entity.item.Tessen;
import com.base.game.entity.item.Whip;

public class InventoryInterface 
{
	private Handler handler;
	private Selector selectorBox;
	private boolean active;
	private boolean disableInput;
	private String state;
	
	private MainItem[] mainItems;
	private List<Item> inventory;
	private List<Quest> myQuests;
	
	public InventoryInterface(Handler handler)
	{
		this.handler = handler;
		mainItems = new MainItem[8];
		mainItems[0] = new Gauntlet(handler);
		mainItems[1] = new Tessen(handler);
		mainItems[2] = new Whip(handler);
		mainItems[3] = new MonkeyStaff(handler);
		mainItems[4] = new Amulet(handler);
		mainItems[5] = new WingedBoots(handler);
		mainItems[6] = new PuppetHands(handler);
		mainItems[7] = new GunLance(handler);
		
		inventory = new ArrayList<Item>();
		addItem(new Item("SMALL HEALTH HERB"));
		addItem(new Item("HEALTH HERB"));
		addItem(new Item("LARGE HEALTH HERB"));
		addItem(new Item("BURN MEDICINE"));
		addItem(new Item("DEFROSTER"));
		addItem(new Item("PARALYSIS CURE"));
		addItem(new Item("ANTISERUM"));
		addItem(new Item("PANACEA"));
		addItem(new Item("DEFROSTER"));
		
		myQuests = new ArrayList<Quest>(); 
		
		selectorBox= new Selector(0,0,0,0);
		
		state = "MAINITEMSELECTION";
		top = 0;
		bottom = 15;
	}

	int selectorX, selectorY, listSelector;
	int itemVarX, itemVarY;
	public void update() 
	{
		selectorBox.update();

		if(!disableInput)
		{
			if(state == "MAINITEMSELECTION")
			{
				selectorBox.setAll(new Rectangle(handler.getWidth()/2 + shiftMIX + 100 * selectorX, handler.getHeight() + shiftMIY + 100 * selectorY, 100, 100));
				
				if(handler.getInput().leftPressed)
				{
					if(selectorX <= 0)
					{
						state = "QUESTSELECTION";
					}
					else
						selectorX--;
				}
				if(handler.getInput().rightPressed)
				{
					if(selectorX >= 3)
					{
						state = "ITEMSELECTION";
					}
					else
						selectorX++;
				}
				if(handler.getInput().upPressed)
				{
					if(selectorY <= 0)
						selectorY = 1;
					else
						selectorY--;
				}
				if(handler.getInput().downPressed)
				{
					if(selectorY >= 1)
						selectorY = 0;
					else
						selectorY++;
				}
				
				if(handler.getInput().w)
					equipMainItem('w');	
				else if(handler.getInput().s)
					equipMainItem('s');	
				else if(handler.getInput().d)
					equipMainItem('d');	
				
			}
			else if(state =="ITEMSELECTION")
			{
				selectorBox.setAll(new Rectangle(handler.getWidth()/2 + 22 + shiftInvX, 142 + shiftInvY + selectorLocation*20, 356, 20));
				
				if(handler.getInput().leftPressed)
				{
					state = "MAINITEMSELECTION";
					selectorX = 3;
				}
				if(handler.getInput().rightPressed)
				{
					state = "QUESTSELECTION";
					selectorX = 0;
				}
				
				if(handler.getInput().upPressed)
				{
					if(listSelector > 0)
					{
						listSelector--;
						selectorLocation--;
					}
					if(listSelector <= top && top > 0)
					{
						top--;
						bottom--;
					}
				}
				if(handler.getInput().downPressed)
				{
					if(listSelector < inventory.size()-1)
					{
						listSelector++;
						selectorLocation++;
					}
					if(listSelector >= bottom && bottom < inventory.size())
					{
						top++;
						bottom++;	
					}
					if(selectorLocation > Math.max(0, Math.min(inventory.size()-1, 14)))
						selectorLocation=Math.max(0, Math.min(inventory.size()-1, 14));
				}
				if(handler.getInput().a)
				{
					if(inventory.size() > 0)
					{
						inventory.get(listSelector).use(handler.getGame().getPlayer(), this);
						if(listSelector > inventory.size()-1)
						{
							listSelector--;
							selectorLocation--;
						}
					}
				}
				
			}
			else if(state == "QUESTSELECTION")
			{
				selectorBox.setAll(new Rectangle(70, handler.getHeight() - 104, 100, 100));
				
				if(!handler.getGame().getGameState().getEffects().isActiveDBox())
				{
					if(handler.getInput().leftPressed)
					{
						state = "ITEMSELECTION";
					}
					else if(handler.getInput().rightPressed)
					{
						state = "MAINITEMSELECTION";
						selectorX = 0;
					}	
					
					if(handler.getInput().a)
					{
						if(myQuests.size() > 0)
						{
							handler.getGame().getGameState().getLevelManager().getpInterface().setActive(false);
							state = "QUESTVIEW";
							selectorBox.setWidth(340);
							selectorBox.setHeight(100);
						}
						else
						{
							handler.getGame().getGameState().getEffects().displayDialog(6);
						}
					}
				}
				
			}
			else if(state == "QUESTVIEW")
			{
				if(!handler.getGame().getGameState().getEffects().isActiveDBox())
				{
					if(handler.getInput().d || myQuests.size() == 0)
					{
						handler.getGame().getGameState().getLevelManager().getpInterface().setActive(true);
						state = "QUESTSELECTION";
					}
					if(handler.getInput().upPressed && selectorY > 0)
					{
						selectorY--;
					}
					else if(handler.getInput().downPressed && selectorY < Math.min(myQuests.size()-1, 3))
					{
						selectorY++;
					}
					else if(handler.getInput().leftPressed && selectorX > 0)
					{
						selectorX--;
					}
					else if(handler.getInput().rightPressed && selectorX < 1 && myQuests.size() > 3)
					{
						selectorX++;
					}
				}
				if(handler.getInput().a)
				{
					if(handler.getGame().getGameState().getEffects().isActiveDBox())
					{
						if(handler.getGame().getGameState().getEffects().getdBox().answer())
						{
							if(selectorX == 0)
							{
								myQuests.remove(selectorY);
							}
							else
							{
								myQuests.remove(selectorY + 4);
							}
						}	
					}
					else 
						handler.getGame().getGameState().getEffects().displayDialog(5);	
				}
			
				selectorBox.setX(90 + selectorX * 340);
				
				if(selectorX > 0 && myQuests.size() - 5 < selectorY)
					selectorY = myQuests.size() - 5;
					
				selectorBox.setY(80 + selectorY * 100);
				
				
			}
			
		}
		
		if(listSelector < 0)
			listSelector = 0;
		
		if(selectorLocation < 0)
			selectorLocation = 0;
		
		if(alpha + alphaRate > 1 || alpha + alphaRate < .1)
			alphaRate = -alphaRate;
		
		alpha += alphaRate;
		
		
		if(handler.getInput().e && state != "QUESTVIEW" && !handler.getGame().getGameState().getEffects().isActiveDBox())
			active = false;
	}

	float alpha = .1f, alphaRate = .05f;
	int top, bottom, selectorLocation;
	int shiftInvX = 50, shiftInvY = -35;
	int shiftMIX = -380, shiftMIY = -340;
	String text;
	public void render(Graphics g) 
	{
		g.drawImage(Assets.box440x240, handler.getWidth()/2 - 20 + shiftMIX, handler.getHeight() - 22 + shiftMIY, null);	
		g.drawImage(Assets.box300x350, handler.getWidth()/2 + shiftInvX, 109  + shiftInvY, null);

		for(int i = top; i < Math.min(inventory.size(), bottom); i++)
		{
			if(i == selectorLocation && state == "ITEMSELECTION")
			{
				g.setColor(Color.BLACK);
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 20));
				g.drawString(inventory.get(i).getName(), handler.getWidth()/2 + 27 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
				g.drawString('x' + Integer.toString(inventory.get(i).getQuantity()), handler.getWidth()/2 + 347 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
				g.setColor(Color.WHITE);
				g.drawString(inventory.get(i).getName(), handler.getWidth()/2 + 25 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);
				g.drawString('x' + Integer.toString(inventory.get(i).getQuantity()), handler.getWidth()/2 + 345 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);	
			
			}
			else
			{
				g.setColor(Color.BLACK);
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
				g.drawString(inventory.get(i).getName(), handler.getWidth()/2 + 32 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
				g.drawString('x' + Integer.toString(inventory.get(i).getQuantity()), handler.getWidth()/2 + 347 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
				g.setColor(Color.WHITE);
				g.drawString(inventory.get(i).getName(), handler.getWidth()/2 + 30 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);
				g.drawString('x' + Integer.toString(inventory.get(i).getQuantity()), handler.getWidth()/2 + 345 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);	
			}
		}
		for(int i = 0; i < 4; i++)
		{		
			g.drawImage(Assets.box100x100, handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY, null);
			
			if(mainItems[i] != null && mainItems[i].getLevel() > 0)
				Utils.drawFadedImage(g, alpha, Assets.boxGlowBotSect, handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY + 77, 100, 18);
			for(int j = 1; j < Math.min(mainItems[i].getLevel(), 4); j++)
				Utils.drawFadedImage(g, alpha, Assets.boxGlowMidSect, handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY + 77 - j*18, 100, 18);
			if(mainItems[i] != null && mainItems[i].getLevel() == 5)
				Utils.drawFadedImage(g, alpha, Assets.boxGlowTopSect, handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY + 5, 100, 18);
			
			if(selectorY == 0 && selectorX == i && state == "MAINITEMSELECTION")
			{
				if(mainItems[i] == null)
					g.drawImage(Assets.itemOutlines[i], handler.getWidth()/2 + i * 100 + shiftMIX - 5, handler.getHeight() + shiftMIY -5, 110, 110, null);
				else if(!mainItems[i].isEquipped())
					g.drawImage(Assets.itemIcons[i], handler.getWidth()/2 + i * 100 + shiftMIX - 5, handler.getHeight() + shiftMIY -5, 110, 110, null);
				else
					g.drawImage(Assets.itemsInUse[i], handler.getWidth()/2 + i * 100 + shiftMIX - 5, handler.getHeight() + shiftMIY -5, 110, 110, null);
					
			}
			else
			{
				if(mainItems[i] == null)
					g.drawImage(Assets.itemOutlines[i], handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY, null);
				else if(!mainItems[i].isEquipped())
					g.drawImage(Assets.itemIcons[i], handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY, null);
				else
					g.drawImage(Assets.itemsInUse[i], handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY, null);
			
			}
		}
		for(int i = 4; i < 8; i++)
		{
			g.drawImage(Assets.box100x100, handler.getWidth()/2 + (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 100, null);
			
			if(mainItems[i] != null && mainItems[i].getLevel() > 0)
				Utils.drawFadedImage(g, alpha, Assets.boxGlowBotSect, handler.getWidth()/2 + (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 177, 100, 18);
			for(int j = 1; j < Math.min(mainItems[i].getLevel(), 4); j++)
				Utils.drawFadedImage(g, alpha, Assets.boxGlowMidSect, handler.getWidth()/2 + (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 177 - j*18, 100, 18);
			if(mainItems[i] != null && mainItems[i].getLevel() == 5)
				Utils.drawFadedImage(g, alpha, Assets.boxGlowTopSect, handler.getWidth()/2 + (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 105, 100, 18);
			
			
			if(selectorY == 1 && (selectorX+4) == i && state == "MAINITEMSELECTION")
			{
				if(mainItems[i] == null)
					g.drawImage(Assets.itemOutlines[i], handler.getWidth()/2+ (i-4) * 100 + shiftMIX - 5, handler.getHeight() + shiftMIY + 100 - 5, 110, 110, null);
				if(!mainItems[i].isEquipped())
					g.drawImage(Assets.itemIcons[i], handler.getWidth()/2 + (i-4) * 100 + shiftMIX - 5, handler.getHeight() + shiftMIY + 100 - 5, 110, 110, null);
				else
					g.drawImage(Assets.itemsInUse[i], handler.getWidth()/2+ (i-4) * 100 + shiftMIX - 5, handler.getHeight() + shiftMIY + 100 - 5, 110, 110, null);
			}
			else
			{
				if(mainItems[i] == null)
					g.drawImage(Assets.itemOutlines[i], handler.getWidth()/2+ (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 100, null);
				if(!mainItems[i].isEquipped())
					g.drawImage(Assets.itemIcons[i], handler.getWidth()/2 + (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 100, null);
				else
					g.drawImage(Assets.itemsInUse[i], handler.getWidth()/2+ (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 100, null);
			}
				
		}
		
		g.drawImage(Assets.box100x100, 70, handler.getHeight() - 104, null);
		g.drawImage(Assets.scrollTaken, 95, handler.getHeight() - 79, 64, 64, null);
		
		g.drawImage(Assets.box750x100, 180, handler.getHeight() - 100, null);
		g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
		
		if(state == "MAINITEMSELECTION")
		{
			if(selectorY == 0)
			{
				if(mainItems[selectorX] != null)
				{
					g.drawString(mainItems[selectorX].getSummaryL1(), 195, handler.getHeight() - 75);
					g.drawString(mainItems[selectorX].getSummaryL2(), 195, handler.getHeight() - 60);
					g.drawString(mainItems[selectorX].getSummaryL3(), 195, handler.getHeight() - 45);
				}
			}
			else
			{
				if(mainItems[selectorX + 4] != null)
				{
					g.drawString(mainItems[selectorX + 4].getSummaryL1(), 195, handler.getHeight() - 75);
					g.drawString(mainItems[selectorX + 4].getSummaryL2(), 195, handler.getHeight() - 60);
					g.drawString(mainItems[selectorX + 4].getSummaryL3(), 195, handler.getHeight() - 45);
				}
			}
		}
		else if(state == "ITEMSELECTION" && !inventory.isEmpty())
		{
			g.drawString(inventory.get(listSelector).getSummary()[0], 195, handler.getHeight() - 75);
			g.drawString(inventory.get(listSelector).getSummary()[1], 195, handler.getHeight() - 60);
			g.drawString(inventory.get(listSelector).getSummary()[2], 195, handler.getHeight() - 45);
		}
		else if(state == "QUESTSELECTION")
		{
			g.drawString("OPEN QUEST LOG", 195, handler.getHeight() - 75);
		}
		
		if(state == "QUESTVIEW")
		{
			g.drawImage(Assets.box800x500, 80, 20, null);
			
			text = "QUEST LOG";
			g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
			g.setColor(Color.BLACK);
			g.drawString(text, 97, 62);
			g.setColor(Color.WHITE);
			g.drawString(text, 95, 60);
			g.drawLine(95, 65, 865, 65);
			
			for(int i = 0; i < Math.min(myQuests.size(), 4); i++)
			{
				g.drawImage(Assets.scrollTaken, 90, 85 + i*100, null);
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
				g.setColor(Color.WHITE);
				g.drawString(myQuests.get(i).getTxtLine1(), 125, 100 + i*100);
				g.drawString(myQuests.get(i).getTxtLine2(), 125, 115 + i*100);
				g.drawString("CLIENT:", 125, 130 + i*100);
				g.setColor(new Color(165, 150, 225));
				g.drawString(myQuests.get(i).getClient(), 250, 130 + i*100);
				g.setColor(Color.WHITE);
				g.drawString("OBJECTIVE:", 125, 145 + i*100);
				g.drawString(myQuests.get(i).getObjective(), 250, 145 + i*100);		
				g.drawString("LOCATION:", 125, 160 + i*100);
				g.setColor(new Color(230, 140, 75));
				g.drawString(myQuests.get(i).getLocation() + " " + myQuests.get(i).getFloorNum() + "F", 250, 160 + i*100);
				g.setColor(Color.WHITE);
				g.drawString("DIFFICULTY:", 125, 175 + i*100);
				g.drawString(myQuests.get(i).getDifficulty(), 250, 175 + i*100);
			}
			
			for(int i = 4; i < myQuests.size(); i++)
			{
				g.drawImage(Assets.scrollTaken, 435, 85 + (i-4)*100, null);
				g.setColor(Color.WHITE);
				g.drawString(myQuests.get(i).getTxtLine1(), 470, 100 + (i-4)*100);
				g.drawString(myQuests.get(i).getTxtLine2(), 470, 115 + (i-4)*100);
				g.drawString("CLIENT:", 470, 130 + (i-4)*100);
				g.setColor(new Color(165, 150, 225));
				g.drawString(myQuests.get(i).getClient(), 595, 130 + (i-4)*100);
				g.setColor(Color.WHITE);
				g.drawString("OBJECTIVE:", 470, 145 + (i-4)*100);
				g.drawString(myQuests.get(i).getObjective(), 595, 145 + (i-4)*100);
				g.drawString("LOCATION:", 470, 160 + (i-4)*100);
				g.setColor(new Color(230, 140, 75));
				g.drawString(myQuests.get(i).getLocation() + " " + myQuests.get(i).getFloorNum() + "F", 595, 160 + (i-4)*100);
				g.setColor(Color.WHITE);
				g.drawString("DIFFICULTY:", 470, 175 + (i-4)*100);
				g.drawString(myQuests.get(i).getDifficulty(), 595, 175 + (i-4)*100);
			}
		}
		
		selectorBox.render(g);
	}
	
	public void equipMainItem(char button)
	{
		if(selectorY == 0 && !mainItems[selectorX].isEquipped())
		{
			handler.getGame().getPlayer().setMainItem(mainItems[selectorX], button);
			mainItems[selectorX].setEquipped(true);
		}
		else if(selectorY == 1 && !mainItems[selectorX + 4].isEquipped())
		{
			handler.getGame().getPlayer().setMainItem(mainItems[selectorX + 4], button);
			mainItems[selectorX + 4].setEquipped(true);
		}
	}
	
	public void addItem(Item item)
	{
		for(Item i : inventory)
		{
			if(item.getName().equals(i.getName()))
			{
				i.setQuantity(i.getQuantity()+1);			
				return;
			}
		}
		
		inventory.add(item);		
	}
	
	public void removeItem(Item item)
	{	
		for(Item i : inventory)
		{
			if(item.getName().equals(i.getName()))
			{
				if(i.getQuantity() <= 1)
					inventory.remove(i);
				else
					i.setQuantity(i.getQuantity()-1);
				return;
			}
		}
	}

	public boolean isActive() {return active;}
	public void setActive(boolean active) {this.active = active;}
	public MainItem[] getMainItems() {return mainItems;}
	public void setMainItems(MainItem[] mainItems) {this.mainItems = mainItems;}
	public List<Item> getInventory() {return inventory;}
	public void setInventory(List<Item> inventory) {this.inventory = inventory;}
	public List<Quest> getMyQuests() {return myQuests;}
	public void setMyQuests(List<Quest> myQuests) {this.myQuests = myQuests;}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isDisableInput() {
		return disableInput;
	}

	public void setDisableInput(boolean disableInput) {
		this.disableInput = disableInput;
	}
	
}
