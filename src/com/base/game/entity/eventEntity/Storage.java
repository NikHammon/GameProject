package com.base.game.entity.eventEntity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Selector;
import com.base.game.Utils;
import com.base.game.entity.item.Item;

public class Storage 
{
	private Handler handler;
	private Selector selectorBox;
	
	private String state;
	private String text;
	private String[] availableText;
	
	private int selector;
	
	private ArrayList<Item> storageItems;
	private int storageGold = 1234;
	
	public Storage(Handler handler) 
	{
		this.handler = handler;
		selectorBox = new Selector(handler.getWidth()-205, handler.getGame().getHeight() - 305, 200, 100);
		setStorageItems(new ArrayList<Item>());
		state = "CHOOSEOP";
		
		text = Utils.readScript(Integer.toString(160));
		availableText = new String[4];
		clearText();
		
	}
	
	int digit;
	int index, textLine, listSelector;
	boolean isComplete;
	boolean storing = true;boolean withdrawing = true;
	StringBuilder sb = new StringBuilder();
	Item registerItem, registerItemToInventory;
	public void update()
	{
		if(state == "CHOOSEOP")
		{
			if(index >= text.length())
			{
				selectorBox.update();
				
				if(selector == 0)
					selectorBox.setAll(new Rectangle(handler.getWidth()-205, handler.getGame().getHeight() - 305, 200, 100));
				else if(selector == 1)	
					selectorBox.setAll(new Rectangle(handler.getWidth()-205, handler.getGame().getHeight() - 405, 200, 100));
				else
					selectorBox.setAll(new Rectangle(handler.getWidth()-205, handler.getGame().getHeight() - 505, 200, 100));
				
				if(handler.getInput().downPressed)
				{
					if(selector <= 0)
						selector = 2;
					else
						selector--;
				}
				else if(handler.getInput().upPressed)
				{
					if(selector >= 2)
						selector = 0;
					else
						selector++;
				}
				if(handler.getInput().a)
				{
					if(selector == 0)
					{
						handler.getGame().getGameState().getEffects().displayDialog(161);
						state = "CANCEL";
					}
					else if(selector == 1)
					{
						handler.getGame().getGameState().getEffects().displayDialog(163);
						state = "TOITEMS";
						top = 0;
						bottom = 15;
					}
					else 
					{
						handler.getGame().getGameState().getEffects().displayDialog(162);
						state = "TOMONEY";
						top = 0;
						bottom = 15;
					}
				}
				else if(handler.getInput().d)
				{
					handler.getGame().getGameState().getEffects().displayDialog(161);
					state = "CANCEL";
				}
			}
			else
			{
				
				if(text.charAt(index) == '-')
				{
					sb.setLength(0);//clears stringBuilder
					textLine++;
					index++;
				}
				else
				{
					availableText[textLine] = sb.append(text.charAt(index)).toString();
				}
				
				index++;
				
			}
		}
		else if(state == "TOMONEY" && handler.getGame().getGameState().getEffects().getdBox().isComplete())
			state = "MONEY";
		else if(state == "TOITEMS" && handler.getGame().getGameState().getEffects().getdBox().isComplete())
		{
			storing = true;
			if(selectorLocation > Math.max(0, Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1, 14)))
				selectorLocation = Math.max(0, Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1, 14));
			
			if(listSelector > Math.max(0, handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1))
				listSelector = Math.max(0, handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1);
			
			state = "ITEMS";	
		}
		else if(state == "MONEY" && !handler.getGame().getGameState().getEffects().isActiveDBox())
		{
			selectorBox.update();
			
			if(withdrawing)
			{
				if(handler.getInput().upPressed)
				{
					if(Integer.parseInt(handler.getGame().getPlayer().getMoney()) > Math.pow(10, digit) && 9999 >= storageGold + Math.pow(10, digit))
					{
						if(handler.getGame().getPlayer().takeMoney((int) Math.pow(10, digit)));
							storageGold+=Math.pow(10, digit);
					}
				}
				else if(handler.getInput().downPressed)
				{
					if(storageGold > Math.pow(10, digit) && handler.getGame().getPlayer().getWalletSize() >= Integer.parseInt(handler.getGame().getPlayer().getMoney()) + Math.pow(10, digit))
					{
						handler.getGame().getPlayer().addMoney((int) Math.pow(10, digit));
						storageGold-=Math.pow(10, digit);
					}

				}
				else if(handler.getInput().rightPressed)
				{
					if(digit <= 0)
					{
						digit = 3;
						withdrawing = false;
					}
					else
						digit--;					
				}
				else if(handler.getInput().leftPressed)
				{
					if(digit < 3)
					{
						digit++;
					}				
				}
				selectorBox.setAll(new Rectangle(handler.getWidth()/2 - 115 - digit * 40, handler.getGame().getHeight()/2 - 40, 50, 80));
			}
			else
			{
				if(handler.getInput().upPressed)
				{
					if(storageGold > Math.pow(10, digit) && handler.getGame().getPlayer().getWalletSize() >= Integer.parseInt(handler.getGame().getPlayer().getMoney()) + Math.pow(10, digit))
					{
						handler.getGame().getPlayer().addMoney((int) Math.pow(10, digit));
						storageGold-=Math.pow(10, digit);
					}
				}
				else if(handler.getInput().downPressed)
				{
					
					if(Integer.parseInt(handler.getGame().getPlayer().getMoney()) > Math.pow(10, digit) && 9999 >= storageGold + Math.pow(10, digit))
					{
						if(handler.getGame().getPlayer().takeMoney((int) Math.pow(10, digit)));
							storageGold+=Math.pow(10, digit);
					}
				}
				else if(handler.getInput().rightPressed)
				{
					if(digit > 0)
					{
						digit--;				
					}
					
				}
				else if(handler.getInput().leftPressed)
				{
					if(digit < 3)
					{
						digit++;
					}
					else
					{
						digit = 0;
						withdrawing = true;
					}
				}
				selectorBox.setAll(new Rectangle(handler.getWidth()/2 + 185 - digit * 40, handler.getGame().getHeight()/2 - 40, 50, 80));
			}
			if(handler.getInput().d)
			{
				state = "CHOOSEOP";
				index = 0;
				textLine = 0;
				text = Utils.readScript(Integer.toString(160));
				clearText();
			}
			
			
			
		}
		else if(state == "ITEMS")
		{
			selectorBox.update();
			if(storing)
			{
				selectorBox.setAll(new Rectangle(handler.getWidth()/2 + 22 + shiftInvX, 142 + shiftInvY + selectorLocation*20, 356, 20));
				
				if(handler.getInput().downPressed)
				{
					if(listSelector < handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1)
					{
						listSelector++;
						selectorLocation++;
					}
					if(listSelector >= bottom && bottom < handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size())
					{
						top++;
						bottom++;	
					}
					if(selectorLocation > Math.max(0, Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1, 14)))
						selectorLocation=Math.max(0, Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1, 14));
				}
				
				if(handler.getInput().a)
				{
					if(!handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().isEmpty())
					{
						registerItem = handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(listSelector);
						handler.getGame().getGameState().getLevelManager().getiInterface().removeItem(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(listSelector));	
					}
					if(listSelector > handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1)
					{
						listSelector--;
						selectorLocation--;
					}
						
				}
			}
			else
			{
				selectorBox.setAll(new Rectangle(handler.getWidth()/2 + 22 + shiftInvX - 400, 142 + shiftInvY + selectorLocation*20, 356, 20));
				
				if(handler.getInput().downPressed)
				{
					if(listSelector < storageItems.size()-1)
					{
						listSelector++;
						selectorLocation++;
					}
					if(listSelector >= bottom && bottom < storageItems.size())
					{
						top++;
						bottom++;	
					}
					if(selectorLocation > Math.max(0, Math.min(storageItems.size()-1, 14)))
						selectorLocation=Math.max(0, Math.min(storageItems.size()-1, 14));
				}
				
				if(handler.getInput().a)
				{
					if(!storageItems.isEmpty())
					{
						registerItemToInventory = storageItems.get(listSelector);	
						removeItem(storageItems.get(listSelector));	
					}
					if(listSelector > storageItems.size()-1)
					{
						listSelector--;
						selectorLocation--;
					}
						
				}
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
			else if(handler.getInput().leftPressed || handler.getInput().rightPressed)
			{
				if(storing && !storageItems.isEmpty())
				{
					if(selectorLocation > Math.max(0, Math.min(storageItems.size()-1, 14)))
						selectorLocation=Math.max(0, Math.min(storageItems.size()-1, 14));
					
					if(listSelector > storageItems.size()-1)
						listSelector = storageItems.size()-1;
					
						storing = false;
				}
				else if(!handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().isEmpty())
				{
					if(selectorLocation > Math.max(0, Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1, 14)))
						selectorLocation=Math.max(0, Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1, 14));
					
					if(listSelector > handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1)
						listSelector = handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1;
					
					storing = true;
				}
			}
			else if(handler.getInput().d)
			{
				state = "CHOOSEOP";
				index = 0;
				textLine = 0;
				text = Utils.readScript(Integer.toString(160));
				clearText();
			}
			
			if(registerItem != null)
			{
				addItem(registerItem);
				registerItem = null;
			}
			
			if(registerItemToInventory != null)
			{
				handler.getGame().getGameState().getLevelManager().getiInterface().addItem(registerItemToInventory);
				registerItemToInventory = null;
			}
			
		}
		else if(state == "CANCEL")
		{
			if(handler.getGame().getGameState().getEffects().getdBox().isComplete())
			{
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setStoring(false);
				handler.getGame().getPlayer().setPaused(false);
				handler.getGame().getGameState().getLevelManager().getpInterface().setActive(true);
				state = "CHOOSEOP";
				index = 0;
				textLine = 0;
				text = Utils.readScript(Integer.toString(160));
				clearText();
			}
		}
		
		if(listSelector < 0)
			listSelector = 0;
		
		if(selectorLocation < 0)
			selectorLocation = 0;
			
	}
	int top, bottom, selectorLocation;
	int shiftInvX = 0, shiftInvY = -35;
	public void render(Graphics g)
	{
		if(state == "CHOOSEOP")
		{
			g.drawImage(Assets.dialogBox, 0, handler.getGame().getHeight() - 205, handler.getWidth(), 200, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("American Typewriter", Font.BOLD, 20));
			
			for(int i = 0; i < availableText.length; i++)
				g.drawString(availableText[i], 30, handler.getGame().getHeight() - 150 + i * 30);
			
			
			if(index >= text.length())
			{
				g.drawImage(Assets.box200x100, handler.getWidth()-205, handler.getGame().getHeight() - 505, null);
				g.drawImage(Assets.box200x100, handler.getWidth()-205, handler.getGame().getHeight() - 405, null);
				g.drawImage(Assets.box200x100, handler.getWidth()-205, handler.getGame().getHeight() - 305, null);
				
				g.setFont(new Font("American Typewriter", Font.BOLD, 30));
				
				g.drawString("GOLD", handler.getWidth() - 100 - g.getFontMetrics().stringWidth("GOLD")/2, handler.getGame().getHeight() - 440);
				g.drawString("ITEMS", handler.getWidth() - 100 - g.getFontMetrics().stringWidth("ITEMS")/2, handler.getGame().getHeight() - 340);
				g.drawString("CANCEL", handler.getWidth() - 100 - g.getFontMetrics().stringWidth("CANCEL")/2 , handler.getGame().getHeight() - 240);
				
				selectorBox.render(g);
			}
			
		}
		else if(state == "ITEMS")
		{
			g.drawImage(Assets.box300x350, handler.getWidth()/2 + shiftInvX, 109  + shiftInvY, null);
			
			for(int i = top; i < Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size(), bottom); i++)
			{
				if(i == selectorLocation && storing)
				{
					g.setColor(Color.BLACK);
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 20));
					g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getName(), handler.getWidth()/2 + 27 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
					g.drawString("x" + Integer.toString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getQuantity()), handler.getWidth()/2 + 347 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
					g.setColor(Color.WHITE);
					g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getName(), handler.getWidth()/2 + 25 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);
					g.drawString("x" + Integer.toString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getQuantity()), handler.getWidth()/2 + 345 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);	
				
				}
				else
				{
					g.setColor(Color.BLACK);
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
					g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getName(), handler.getWidth()/2 + 32 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
					g.drawString("x" + Integer.toString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getQuantity()), handler.getWidth()/2 + 347 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
					g.setColor(Color.WHITE);
					g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getName(), handler.getWidth()/2 + 30 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);
					g.drawString("x" + Integer.toString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getQuantity()), handler.getWidth()/2 + 345 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);	
				}
			}
			
			g.drawImage(Assets.box300x350, handler.getWidth()/2 + shiftInvX - 400, 109  + shiftInvY, null);
			
			for(int i = top; i < Math.min(storageItems.size(), bottom); i++)
			{
				if(i == selectorLocation && !storing)
				{
					g.setColor(Color.BLACK);
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 20));
					g.drawString(storageItems.get(i).getName(), handler.getWidth()/2 + 27 + shiftInvX - 400, 159 + (i - top) * 20 + shiftInvY);
					g.drawString("x" + Integer.toString(storageItems.get(i).getQuantity()), handler.getWidth()/2 + 347 + shiftInvX - 400, 159 + (i - top) * 20 + shiftInvY);
					g.setColor(Color.WHITE);
					g.drawString(storageItems.get(i).getName(), handler.getWidth()/2 + 25 + shiftInvX - 400, 157 + (i - top) * 20 + shiftInvY);
					g.drawString("x" + Integer.toString(storageItems.get(i).getQuantity()), handler.getWidth()/2 + 345 + shiftInvX - 400, 157 + (i - top) * 20 + shiftInvY);	
				
				}
				else
				{
					g.setColor(Color.BLACK);
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
					g.drawString(storageItems.get(i).getName(), handler.getWidth()/2 + 32 + shiftInvX - 400, 159 + (i - top) * 20 + shiftInvY);
					g.drawString("x" + Integer.toString(storageItems.get(i).getQuantity()), handler.getWidth()/2 + 347 + shiftInvX - 400, 159 + (i - top) * 20 + shiftInvY);
					g.setColor(Color.WHITE);
					g.drawString(storageItems.get(i).getName(), handler.getWidth()/2 + 30 + shiftInvX - 400, 157 + (i - top) * 20 + shiftInvY);
					g.drawString("x" + Integer.toString(storageItems.get(i).getQuantity()), handler.getWidth()/2 + 345 + shiftInvX - 400, 157 + (i - top) * 20 + shiftInvY);	
				}
			}
			
			
			g.drawImage(Assets.box750x100, 100, handler.getHeight() - 100, null);
			g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
			g.setColor(Color.WHITE);
			if(!storing && !storageItems.isEmpty())
			{
				g.drawString(storageItems.get(listSelector).getSummary()[0], 115, handler.getHeight() - 75);
				g.drawString(storageItems.get(listSelector).getSummary()[1], 115, handler.getHeight() - 60);
				g.drawString(storageItems.get(listSelector).getSummary()[2], 115, handler.getHeight() - 45);
			}
			else if(!handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().isEmpty())
			{
				g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(listSelector).getSummary()[0], 115, handler.getHeight() - 75);
				g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(listSelector).getSummary()[1], 115, handler.getHeight() - 60);
				g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(listSelector).getSummary()[2], 115, handler.getHeight() - 45);
				
			}
			
			selectorBox.render(g);
		}
		else if(state == "MONEY")
		{
			g.drawImage(Assets.box200x100, handler.getWidth()/2 - 250, handler.getHeight()/2 - 50, null);
			g.drawImage(Assets.box200x100, handler.getWidth()/2  + 50, handler.getHeight()/2 - 50, null);
			
			g.setFont(new Font(handler.getGame().font, Font.BOLD, 50));
			g.setColor(Color.WHITE);
			
			for(int i = 3; i >= 0; i--)
				g.drawString(getPlayerGoldDigit(i), handler.getWidth()/2 + 90 + i * 40 - g.getFontMetrics().stringWidth(getPlayerGoldDigit(i))/2, handler.getGame().getHeight()/2 + 20);
			
			for(int i = 0; i < 4; i++)
				g.drawString(getStorageGoldDigit(i), handler.getWidth()/2 - 210 + i * 40 - g.getFontMetrics().stringWidth(getStorageGoldDigit(i))/2, handler.getGame().getHeight()/2 + 20);
			
			
			
			selectorBox.render(g);
		}
	}
	
	public void addItem(Item item)
	{
		for(Item i : storageItems)
		{
			if(item.getName().equals(i.getName()))
			{
				i.setQuantity(i.getQuantity()+1);		
				return;
			}
		}
		
		storageItems.add(item);
		
	}
	
	public void removeItem(Item item)
	{	
		for(Item i : storageItems)
		{
			if(item.getName().equals(i.getName()))
			{	
				if(i.getQuantity() <= 1)
					storageItems.remove(i);
				else
					i.setQuantity(i.getQuantity()-1);
				return;
			}
		}
	}
	
	public String getStorageGoldDigit(int digit)
	{
		if(digit == 3 && storageGold > 0)
			return Integer.toString(storageGold % 10);
		else if(digit == 2 && storageGold > 10)
			return Integer.toString(storageGold/10 % 10);
		else if(digit == 1 && storageGold > 100)
			return Integer.toString(storageGold/100 % 10);
		else if(storageGold > 1000)
			return Integer.toString(storageGold/1000 % 10);
		else
			return "0";
	}
	
	public String getPlayerGoldDigit(int digit)
	{

		if(digit == 3 && Integer.parseInt(handler.getGame().getPlayer().getMoney()) > 0)
			return Integer.toString(Integer.parseInt(handler.getGame().getPlayer().getMoney()) % 10);
		else if(digit == 2 && Integer.parseInt(handler.getGame().getPlayer().getMoney()) > 10)
			return Integer.toString(Integer.parseInt(handler.getGame().getPlayer().getMoney())/10 % 10);
		else if(digit == 1 && Integer.parseInt(handler.getGame().getPlayer().getMoney()) > 100)
			return Integer.toString(Integer.parseInt(handler.getGame().getPlayer().getMoney())/100 % 10);
		else if(Integer.parseInt(handler.getGame().getPlayer().getMoney()) > 1000)
			return Integer.toString(Integer.parseInt(handler.getGame().getPlayer().getMoney())/1000 % 10);
		else 
			return "0";
	}
	
	public void clearText()
	{
		for(int i = 0; i < availableText.length; i++)
			availableText[i] = "";
	}

	public int getStorageGold() {
		return storageGold;
	}

	public void setStorageGold(int storageGold) {
		this.storageGold = storageGold;
	}

	public ArrayList<Item> getStorageItems() {
		return storageItems;
	}

	public void setStorageItems(ArrayList<Item> storageItems) {
		this.storageItems = storageItems;
	}
}
