package com.base.game.entity.eventEntity;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Selector;
import com.base.game.Utils;

public class BlackSmith 
{
	private Handler handler;
	private Selector selectorBox;
	
	private String state;
	private String text;
	private String[] availableText;
	
	public BlackSmith(Handler handler)
	{
		this.handler = handler;
		
		state = "CHOOSEITEM";
		selectorBox = new Selector(0,0,0,0);
		
		text = Utils.readScript(Integer.toString(16));
		availableText = new String[4];
		clearText();
	}
	
	int selectorX, selectorY;
	int itemVarX, itemVarY;
	int index, textLine, selector;
	boolean isComplete;
	StringBuilder sb = new StringBuilder();
	public void update()
	{
		if(state == "CHOOSEITEM")
		{
			if(index >= text.length())
			{
				selectorBox.setAll(new Rectangle(handler.getWidth()/2 + shiftMIX + 100 * selectorX, handler.getHeight() + shiftMIY + 100 * selectorY, 100, 100));
				
				selectorBox.update();
				
				if(handler.getInput().leftPressed)
				{
					if(selectorX <= 0)
						selectorX = 3;
					else
						selectorX--;
				}
				if(handler.getInput().rightPressed)
				{
					if(selectorX >= 3)
						selectorX = 0;
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
				if(handler.getInput().a)
				{
					if(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[selectorX + selectorY*4].getLevel() < 5)
					{
						if(handler.getGame().getPlayer().takeMoney(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[selectorX + selectorY*4].getUpgradeValue()))
							handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[selectorX + selectorY*4].upgrade();
						else
							handler.getGame().getGameState().getEffects().displayDialog(18);
					}
					else
					{
						handler.getGame().getGameState().getEffects().displayDialog(19);
					}
				}
				else if(handler.getInput().d)
				{
					handler.getGame().getGameState().getEffects().displayDialog(17);
					state = "CANCEL";
				}
				
				if(alpha + alphaRate > 1 || alpha + alphaRate < .3)
					alphaRate = -alphaRate;
				
				alpha += alphaRate;
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
		else if(state == "CANCEL")
		{
			if(handler.getGame().getGameState().getEffects().getdBox().isComplete())
			{
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("MAINAREA");
				handler.getGame().getPlayer().setPaused(false);
				state = "CHOOSEITEM";
				index = 0;
				textLine = 0;
				text = Utils.readScript(Integer.toString(16));
				clearText();
			}
		}
	}
	
	float alpha = 1f, alphaRate = .01f;
	int shiftMIX = -130, shiftMIY = -410;
	public void render(Graphics g)
	{
		if(state == "CHOOSEITEM")
		{
			g.drawImage(Assets.dialogBox, 0, handler.getGame().getHeight() - 205, handler.getWidth(), 200, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("American Typewriter", Font.BOLD, 20));
			
			for(int i = 0; i < availableText.length; i++)
				g.drawString(availableText[i], 30, handler.getGame().getHeight() - 150 + i * 30);
			
			
			if(index >= text.length())
			{
				for(int i = 0; i < 4; i++)
				{		
					g.drawImage(Assets.box100x100, handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY, null);
					
					if(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i] != null && handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i].getLevel() > 0)
						Utils.drawFadedImage(g, alpha, Assets.boxGlowBotSect, handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY + 77, 100, 18);
					for(int j = 1; j < Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i].getLevel(), 4); j++)
						Utils.drawFadedImage(g, alpha, Assets.boxGlowMidSect, handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY + 77 - j*18, 100, 18);
					if(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i] != null && handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i].getLevel() == 5)
						Utils.drawFadedImage(g, alpha, Assets.boxGlowTopSect, handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY + 5, 100, 18);
					
					if(selectorY == 0 && selectorX == i && state == "MAINITEMSELECTION")
					{
						if(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i] == null)
							g.drawImage(Assets.itemOutlines[i], handler.getWidth()/2 + i * 100 + shiftMIX - 5, handler.getHeight() + shiftMIY -5, 110, 110, null);
						else 
							g.drawImage(Assets.itemIcons[i], handler.getWidth()/2 + i * 100 + shiftMIX - 5, handler.getHeight() + shiftMIY -5, 110, 110, null);
					}
					else
					{
						if(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i] == null)
							g.drawImage(Assets.itemOutlines[i], handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY, null);
						else 
							g.drawImage(Assets.itemIcons[i], handler.getWidth()/2 + i * 100 + shiftMIX, handler.getHeight() + shiftMIY, null);	
					}
				}
				for(int i = 4; i < 8; i++)
				{
					g.drawImage(Assets.box100x100, handler.getWidth()/2 + (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 100, null);
					
					if(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i] != null && handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i].getLevel() > 0)
						Utils.drawFadedImage(g, alpha, Assets.boxGlowBotSect, handler.getWidth()/2 + (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 177, 100, 18);
					for(int j = 1; j < Math.min(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i].getLevel(), 4); j++)
						Utils.drawFadedImage(g, alpha, Assets.boxGlowMidSect, handler.getWidth()/2 + (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 177 - j*18, 100, 18);
					if(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i] != null && handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i].getLevel() == 5)
						Utils.drawFadedImage(g, alpha, Assets.boxGlowTopSect, handler.getWidth()/2 + (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 105, 100, 18);
					
					if(selectorY == 1 && (selectorX+4) == i && state == "MAINITEMSELECTION")
					{
						if(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i] == null)
							g.drawImage(Assets.itemOutlines[i], handler.getWidth()/2+ (i-4) * 100 + shiftMIX - 5, handler.getHeight() + shiftMIY + 100 - 5, 110, 110, null);
						else
							g.drawImage(Assets.itemIcons[i], handler.getWidth()/2 + (i-4) * 100 + shiftMIX - 5, handler.getHeight() + shiftMIY + 100 - 5, 110, 110, null);
					}
					else
					{
						if(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[i] == null)
							g.drawImage(Assets.itemOutlines[i], handler.getWidth()/2+ (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 100, null);
						else
							g.drawImage(Assets.itemIcons[i], handler.getWidth()/2 + (i-4) * 100 + shiftMIX, handler.getHeight() + shiftMIY + 100, null);
					}
						
				}
				
				g.drawImage(Assets.box200x100, handler.getWidth()/2 + 405 + shiftMIX, handler.getHeight() + shiftMIY + 50, null);
				
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 20));
				g.drawString("PRICE:", handler.getWidth() - 195, handler.getHeight() + shiftMIY + 80);
				
				if(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[selectorX + (selectorY * 4)].getLevel() < 5)
				{
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
					String myText = Integer.toString(handler.getGame().getGameState().getLevelManager().getiInterface().getMainItems()[selectorX + (selectorY * 4)].getUpgradeValue());		
					g.setColor((Integer.parseInt(handler.getGame().getPlayer().getMoney()) >= Integer.parseInt(myText)) ? new Color(90, 255, 140) : new Color(240, 90, 110));
					g.drawString(myText, handler.getWidth() - 100 - g.getFontMetrics().stringWidth(myText)/2, handler.getHeight() + shiftMIY + 115);
				}
				
				selectorBox.render(g);
			}
			
		}
	}
	
	public void clearText()
	{
		for(int i = 0; i < availableText.length; i++)
			availableText[i] = "";
	}
}
