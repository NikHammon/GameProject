package com.base.game.entity.eventEntity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Selector;
import com.base.game.Utils;
import com.base.game.entity.item.Item;

public class ShopKeeper
{
	private Handler handler;
	private Selector selectorBox;
	
	private String state;
	private String text;
	private String[] availableText;
	
	private int selector;
	
	private ArrayList<Item> shopItems;
	
	public ShopKeeper(Handler handler) 
	{
		this.handler = handler;
		selectorBox = new Selector(handler.getWidth()-205, handler.getGame().getHeight() - 305, 200, 100);
		shopItems = new ArrayList<Item>();
		generateItems();
		state = "CHOOSEOP";
		
		text = Utils.readScript(Integer.toString(10));
		availableText = new String[4];
		clearText();
	}
	
	int index, textLine, listSelector;
	boolean isComplete;
	StringBuilder sb = new StringBuilder();
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
						handler.getGame().getGameState().getEffects().displayDialog(11);
						state = "CANCEL";
					}
					else if(selector == 1)
					{
						handler.getGame().getGameState().getEffects().displayDialog(13);
						state = "TOSELL";
						top = 0;
						bottom = 15;
					}
					else 
					{
						handler.getGame().getGameState().getEffects().displayDialog(12);
						state = "TOBUY";
						top = 0;
						bottom = 15;
					}
				}
				else if(handler.getInput().d)
				{
					handler.getGame().getGameState().getEffects().displayDialog(11);
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
		else if(state == "TOBUY" && handler.getGame().getGameState().getEffects().getdBox().isComplete())
		{
			if(selectorLocation > Math.max(0, Math.min(shopItems.size()-1, 14)))
				selectorLocation = Math.max(0, Math.min(shopItems.size()-1, 14));
			
			if(listSelector > Math.max(0, shopItems.size()-1))
				listSelector = Math.max(0, shopItems.size()-1);
			
			state = "BUY";
		}
		else if(state == "TOSELL" && handler.getGame().getGameState().getEffects().getdBox().isComplete())
		{
			if(selectorLocation > Math.max(0, Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1, 14)))
				selectorLocation = Math.max(0, Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1, 14));
			
			if(listSelector > Math.max(0, handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1))
				listSelector = Math.max(0, handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1);
			
			state = "SELL";
		}
		else if(state == "BUY" && !handler.getGame().getGameState().getEffects().isActiveDBox())
		{
			selectorBox.update();
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
				if(listSelector < shopItems.size()-1)
				{
					listSelector++;
					selectorLocation++;
				}
				if(listSelector >= bottom && bottom < shopItems.size())
				{
					top++;
					bottom++;	
				}
				if(selectorLocation > Math.max(0, Math.min(shopItems.size()-1, 14)))
					selectorLocation=Math.max(0, Math.min(shopItems.size()-1, 14));
			}
			if(handler.getInput().a)
			{
				if(shopItems.size() > 0)
				{
					if(handler.getGame().getPlayer().takeMoney(shopItems.get(listSelector).getValue()))
					{
						handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().add(shopItems.get(listSelector));
						shopItems.remove(listSelector);
						
						if(listSelector > shopItems.size()-1)
						{
							listSelector--;
							selectorLocation--;
						}
					}
					else
					{
						handler.getGame().getGameState().getEffects().displayDialog(15);
					}
				}
					
			}
			else if(handler.getInput().d)
			{
				state = "CHOOSEOP";
				index = 0;
				textLine = 0;
				text = Utils.readScript(Integer.toString(14));
				clearText();
			}
			
			selectorBox.setAll(new Rectangle(handler.getWidth()/2 + 22 + shiftInvX, 142 + shiftInvY + selectorLocation*20, 356, 20));
			
		}
		else if(state == "SELL")
		{
			selectorBox.setAll(new Rectangle(handler.getWidth()/2 + 22 + shiftInvX, 142 + shiftInvY + selectorLocation*20, 356, 20));
			
			selectorBox.update();
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
				if(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size() > 0)
				{
					handler.getGame().getPlayer().addMoney(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(listSelector).getValue()/5);
					handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().remove(listSelector);	
				}
				if(listSelector > handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size()-1)
				{
					listSelector--;
					selectorLocation--;
				}
					
			}
			else if(handler.getInput().d)
			{
				state = "CHOOSEOP";
				index = 0;
				textLine = 0;
				text = Utils.readScript(Integer.toString(14));
				clearText();
			}
			
			
			
		}
		else if(state == "CANCEL")
		{
			if(handler.getGame().getGameState().getEffects().getdBox().isComplete())
			{
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("MAINAREA");
				handler.getGame().getPlayer().setPaused(false);
				state = "CHOOSEOP";
				index = 0;
				textLine = 0;
				text = Utils.readScript(Integer.toString(10));
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
				
				g.drawString("BUY", handler.getWidth() - 100 - g.getFontMetrics().stringWidth("BUY")/2, handler.getGame().getHeight() - 440);
				g.drawString("SELL", handler.getWidth() - 100 - g.getFontMetrics().stringWidth("SELL")/2, handler.getGame().getHeight() - 340);
				g.drawString("CANCEL", handler.getWidth() - 100 - g.getFontMetrics().stringWidth("CANCEL")/2 , handler.getGame().getHeight() - 240);
				
				selectorBox.render(g);
			}
			
		}
		else if(state == "SELL")
		{
			g.drawImage(Assets.box300x350, handler.getWidth()/2 + shiftInvX, 109  + shiftInvY, null);
			
			if(!handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().isEmpty())
			{
				for(int i = top; i < Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().size(), bottom); i++)
				{
					if(i == selectorLocation)
					{
						g.setColor(Color.BLACK);
						g.setFont(new Font(handler.getGame().font, Font.BOLD, 20));
						g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getName(), handler.getWidth()/2 + 27 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
						g.drawString(Integer.toString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getValue()/5), handler.getWidth()/2 + 347 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
						g.setColor(Color.WHITE);
						g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getName(), handler.getWidth()/2 + 25 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);
						g.setColor(new Color(90, 255, 140));
						g.drawString(Integer.toString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getValue()/5), handler.getWidth()/2 + 345 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);	
					
					}
					else
					{
						g.setColor(Color.BLACK);
						g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
						g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getName(), handler.getWidth()/2 + 32 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
						g.drawString(Integer.toString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getValue()/5), handler.getWidth()/2 + 347 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
						g.setColor(Color.WHITE);
						g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getName(), handler.getWidth()/2 + 30 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);
						g.setColor(new Color(90, 255, 140));
						g.drawString(Integer.toString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(i).getValue()/5), handler.getWidth()/2 + 345 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);	
					}
				}
				
				g.drawImage(Assets.box750x100, 180, handler.getHeight() - 100, null);
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
				g.setColor(Color.WHITE);
				
				g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(listSelector).getSummary()[0], 195, handler.getHeight() - 75);
				g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(listSelector).getSummary()[1], 195, handler.getHeight() - 60);
				g.drawString(handler.getGame().getGameState().getLevelManager().getiInterface().getInventory().get(listSelector).getSummary()[2], 195, handler.getHeight() - 45);
				
				selectorBox.render(g);
			}
		}
		else if(state == "BUY")
		{
			g.drawImage(Assets.box300x350, handler.getWidth()/2 + shiftInvX, 109  + shiftInvY, null);
			if(!shopItems.isEmpty())
			{
				for(int i = top; i < Math.min(shopItems.size(), bottom); i++)
				{
					if(i == selectorLocation)
					{
						g.setColor(Color.BLACK);
						g.setFont(new Font(handler.getGame().font, Font.BOLD, 20));
						g.drawString(shopItems.get(i).getName(), handler.getWidth()/2 + 27 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
						g.drawString(Integer.toString(shopItems.get(i).getValue()), handler.getWidth()/2 + 347 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
						g.setColor((Integer.parseInt(handler.getGame().getPlayer().getMoney()) >= shopItems.get(i).getValue()) ? Color.WHITE : new Color(240, 90, 110));
						g.drawString(shopItems.get(i).getName(), handler.getWidth()/2 + 25 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);
						g.setColor((Integer.parseInt(handler.getGame().getPlayer().getMoney()) >= shopItems.get(i).getValue()) ? new Color(90, 255, 140) : new Color(240, 90, 110));
						g.drawString(Integer.toString(shopItems.get(i).getValue()), handler.getWidth()/2 + 345 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);	
					
					}
					else
					{
						g.setColor(Color.BLACK);
						g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
						g.drawString(shopItems.get(i).getName(), handler.getWidth()/2 + 32 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
						g.drawString(Integer.toString(shopItems.get(i).getValue()), handler.getWidth()/2 + 347 + shiftInvX, 159 + (i - top) * 20 + shiftInvY);
						g.setColor((Integer.parseInt(handler.getGame().getPlayer().getMoney()) >= shopItems.get(i).getValue()) ? Color.WHITE : new Color(240, 90, 110));
						g.drawString(shopItems.get(i).getName(), handler.getWidth()/2 + 30 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);
						g.setColor((Integer.parseInt(handler.getGame().getPlayer().getMoney()) >= shopItems.get(i).getValue()) ? new Color(90, 255, 140) : new Color(240, 90, 110));
						g.drawString(Integer.toString(shopItems.get(i).getValue()), handler.getWidth()/2 + 345 + shiftInvX, 157 + (i - top) * 20 + shiftInvY);	
					}
				}
				
				g.drawImage(Assets.box750x100, 180, handler.getHeight() - 100, null);
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
				g.setColor(Color.WHITE);
				
				g.drawString(shopItems.get(listSelector).getSummary()[0], 195, handler.getHeight() - 75);
				g.drawString(shopItems.get(listSelector).getSummary()[1], 195, handler.getHeight() - 60);
				g.drawString(shopItems.get(listSelector).getSummary()[2], 195, handler.getHeight() - 45);
				
				selectorBox.render(g);
			}
		}
	}
	
	public void clearText()
	{
		for(int i = 0; i < availableText.length; i++)
			availableText[i] = "";
	}

	Random rand = new Random();
	public void generateItems()
	{
		int numOfItems = rand.nextInt(4) + 6;
		
		for(int i = 0; i < numOfItems; i++)
		{
			switch(rand.nextInt(4))
			{
			case 0:
			case 1:
			case 2:
				shopItems.add(new Item("SMALL HEALTH HERB"));
				break;
			case 3:
				shopItems.add(new Item("ANTISERUM"));
				break;
			}
			
		}
	}
	
}
