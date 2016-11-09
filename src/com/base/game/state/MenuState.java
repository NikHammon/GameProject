package com.base.game.state;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Selector;
import com.base.game.Utils;


public class MenuState extends State
{
	private String state;
	private Selector selectorBox;
	public MenuState(Handler handler)
	{
		super(handler);
		state = "TITLESCREEN";
		selectorBox = new Selector(handler.getGame().getWidth() - 60, handler.getGame().getHeight() - 60, 45, 45);
	}
	
	String nextState = "";
	int selector, fileNum;
	@Override
	public void update() 
	{
		selectorBox.update();
		
		if(nextState == "")
		{
			if(state == "TITLESCREEN")
			{	
				if(handler.getInput().a)
				{
					nextState = "LOADSELECTION";
					effects.fade(1);
					selector = 0;
					selectorBox.setHide(true);
					selectorBox.setAll(new Rectangle(handler.getWidth()/2 - 350, handler.getHeight()/8, 700, 150));	
				}
				
			}
			else if(state == "LOADSELECTION")
			{
				if(handler.getInput().a)
				{
					fileNum = selector;
					nextState = "MENUSTATE3";
					effects.fade(1);
					selector = 0;
					selectorBox.setHide(true);
					selectorBox.setAll(new Rectangle(handler.getGame().getWidth()/2 - 450, 400, 400, 100));
					
				}
				else
				{
					selectorBox.setY(handler.getHeight()/8 + 150 * selector);
				}
				if(handler.getInput().d)
				{
					nextState = "TITLESCREEN";
					effects.fade(1);
					selectorBox.setHide(true);
					selectorBox.setAll(new Rectangle(handler.getGame().getWidth() - 60, handler.getGame().getHeight() - 60, 45, 45));
				}
				if(handler.getInput().upPressed)
				{
					if(selector - 1 >= 0)
						selector--;
					else
						selector = 2;
				}
				if(handler.getInput().downPressed)
				{
					if(selector + 1 <= 2)
						selector++;
					else
						selector = 0;
				}	
				
			}
			else if(state == "MENUSTATE3")
			{				
				if(selector == 0)
				{
					selectorBox.setX(handler.getGame().getWidth()/2 - 450);
					selectorBox.setWidth(400);
				}
				else if(selector == 1)
				{
					selectorBox.setX(handler.getGame().getWidth()/2 - 50);
					selectorBox.setWidth(400);
				}
				else
				{
					selectorBox.setX(handler.getGame().getWidth()/2 + 350);
					selectorBox.setWidth(100);
				}
				
				if(handler.getInput().a)
				{
					if(effects.isActiveDBox())
					{
						if(effects.getdBox().answer())
						{
							handler.getGame().getUserData(fileNum).setFile(false);
							nextState = "TITLESCREEN";
							selectorBox.setHide(true);
							selectorBox.setAll(new Rectangle(handler.getGame().getWidth() - 60, handler.getGame().getHeight() - 60, 45, 45));
							effects.fade(1);
						}
					}
					else if(selector == 0)
					{
						nextState = "GAMESTATE";
						selectorBox.setHide(true);
						effects.fade(1);
					}
					else
					{
						effects.displayDialog(1);
					}
				}
				else if(handler.getInput().d)
				{
					if(effects.isActiveDBox())
					{
						effects.getdBox().answer();
					}
					else
					{
						nextState = "TITLESCREEN";
						effects.fade(1);
						selectorBox.setHide(true);
						selectorBox.setAll(new Rectangle(handler.getGame().getWidth() - 60, handler.getGame().getHeight() - 60, 45, 45));
					}
				}
				if(handler.getInput().leftPressed)
				{
					if(selector - 1 < 0)
						selector = 2;
					else
						selector--;
				}
				if(handler.getInput().rightPressed)
				{
					if(selector + 1 > 2)
						selector = 0;
					else
						selector++;
				}	
			}	
		}
		else
		{
			if(effects.getAlpha() == 1)
			{
				if(nextState == "GAMESTATE")
				{
					handler.getGame().startGame(fileNum);
				}
				else
				{
					selectorBox.setHide(false);
					state = nextState;
				}
				effects.fade(0);
			}
			else if(effects.getAlpha() == 0)
				nextState = "";
		}
		
		if(alpha + alphaRate > 1 || alpha + alphaRate < .1)
			alphaRate = -alphaRate;
		
		alpha += alphaRate;
		
	}

	String text;
	float alpha = .1f, alphaRate = .02f;
	@Override
	public void render(Graphics g)
	{
		if(state == "TITLESCREEN")
		{
			g.drawImage(Assets.titleScreen, 0, 0, handler.getWidth(), handler.getHeight(), null);
			
			g.drawImage(Assets.aKey, handler.getGame().getWidth() - 60, handler.getGame().getHeight() - 60, null);
		}
		else if(state == "LOADSELECTION")
		{
			g.drawImage(Assets.titleScreenBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
			
			//Utils.drawFadedImage(g, alpha, Assets.selector700x150, handler.getWidth()/2 - 350, handler.getHeight()/8 + selector * 150, 700, 150);
			if(selector == 0)
			{	
				g.drawImage(Assets.box700x150, handler.getWidth()/2 - 340, handler.getHeight()/8 + 160, 680, 130, null);
				g.drawImage(Assets.box700x150, handler.getWidth()/2 - 340, handler.getHeight()/8 + 310, 680, 130, null);
				
				g.drawImage(Assets.box700x150, handler.getWidth()/2 - 350, handler.getHeight()/8, null);
				
				g.drawImage(Assets.num1, handler.getWidth()/2 - 330, handler.getHeight()/8 + 15, null);
				g.drawImage(Assets.num2, handler.getWidth()/2 - 330, handler.getHeight()/8 + 165, null);
				g.drawImage(Assets.num3, handler.getWidth()/2 - 330, handler.getHeight()/8 + 315, null);
			}
			else if(selector == 1)
			{
				g.drawImage(Assets.box700x150, handler.getWidth()/2 - 340, handler.getHeight()/8 + 10, 680, 130, null);	
				g.drawImage(Assets.box700x150, handler.getWidth()/2 - 340, handler.getHeight()/8 + 310, 680, 130, null);
				
				g.drawImage(Assets.box700x150, handler.getWidth()/2 - 350, handler.getHeight()/8 + 150, null);
				
				g.drawImage(Assets.num1, handler.getWidth()/2 - 330, handler.getHeight()/8 + 15, null);
				g.drawImage(Assets.num2, handler.getWidth()/2 - 330, handler.getHeight()/8 + 165, null);
				g.drawImage(Assets.num3, handler.getWidth()/2 - 330, handler.getHeight()/8 + 315, null);
			}
			else
			{
				g.drawImage(Assets.box700x150, handler.getWidth()/2 - 340, handler.getHeight()/8 + 10, 680, 130, null);
				g.drawImage(Assets.box700x150, handler.getWidth()/2 - 340, handler.getHeight()/8 + 160, 680, 130, null);
				
				g.drawImage(Assets.box700x150, handler.getWidth()/2 - 350, handler.getHeight()/8 + 300, null);
				
				g.drawImage(Assets.num1, handler.getWidth()/2 - 330, handler.getHeight()/8 + 15, null);
				g.drawImage(Assets.num2, handler.getWidth()/2 - 330, handler.getHeight()/8 + 165, null);
				g.drawImage(Assets.num3, handler.getWidth()/2 - 330, handler.getHeight()/8 + 315, null);
			}
			
			
			
			g.setColor(Color.WHITE);
			g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
			
			for(int i = 0; i < 3; i++)
			{
				if(handler.getGame().getUserData(i).isFile())
				{
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
					g.setColor(Color.BLACK);
					g.drawString("FILE " + Integer.toString(i + 1), 302, handler.getHeight()/8 + 72 + i * 150);
					g.setColor(Color.WHITE);
					g.drawString("FILE " + Integer.toString(i + 1), 300, handler.getHeight()/8 + 70 + i * 150);
					
					for(int a = 0; a < handler.getGame().getUserData(i).getTotalHeartCrystals(); a++)
					{
						if(a < handler.getGame().getUserData(i).getActiveHeartCrystals())
							g.drawImage(Assets.heartCrystal, 620 + a *17, handler.getHeight()/8 + 47 + i * 150, null);
						else
							g.drawImage(Assets.usedHeartCrystal, 620 + a *17, handler.getHeight()/8 + 47 + i * 150, null);
					}
					
					g.drawLine(300, handler.getHeight()/8 + 75 + i * 150, 800, handler.getHeight()/8 + 75 + i * 150);
					
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
					
					g.setColor(Color.BLACK);
					g.drawString("Total play time                                 " + handler.getGame().getUserData(i).getTotalPlayTime(), 372, handler.getHeight()/8 + 92 + i * 150);
					g.setColor(new Color(134, 211, 61));
					g.drawString("Total play time                                 " + handler.getGame().getUserData(i).getTotalPlayTime(), 370, handler.getHeight()/8 + 90 + i * 150);
					
				}
				else
				{
					text = "NEW FILE";
					g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
					g.setColor(Color.BLACK);
					g.drawString(text, (handler.getWidth() - g.getFontMetrics().stringWidth(text))/2, handler.getHeight()/8 + 97 + i * 150);
					g.setColor(Color.WHITE);
					g.drawString(text, (handler.getWidth() - g.getFontMetrics().stringWidth(text))/2 - 2, handler.getHeight()/8 + 95 + i * 150);
				}
			}
			
			
		}
		else if(state == "MENUSTATE3")
		{
			g.drawImage(Assets.titleScreenBG, 0, 0, handler.getWidth(), handler.getHeight(), null);
			
			g.drawImage(Assets.box700x150, handler.getGame().getWidth()/2 - 350, handler.getHeight()/8, null);
			
			//Utils.drawFadedImage(g, alpha, Assets.selector400x100, handler.getGame().getWidth()/2 - 450 + selector * 400, 400, 400, 100);
			
			if(selector == 0)
			{
				g.drawImage(Assets.box400x100, handler.getGame().getWidth()/2 - 450, 400, null);
				g.drawImage(Assets.box400x100, handler.getGame().getWidth()/2 - 40, 410, 380, 80, null);
				g.drawImage(Assets.box100x100, handler.getGame().getWidth()/2 + 360, 410, 80, 80, null);
			}
			else if(selector == 1)
			{
				g.drawImage(Assets.box400x100, handler.getGame().getWidth()/2 - 440, 410, 380, 80, null);
				g.drawImage(Assets.box400x100, handler.getGame().getWidth()/2 - 50, 400, null);
				g.drawImage(Assets.box100x100, handler.getGame().getWidth()/2 + 360, 410, 80, 80, null);
			}
			else
			{
				g.drawImage(Assets.box400x100, handler.getGame().getWidth()/2 - 440, 410, 380, 80, null);
				g.drawImage(Assets.box400x100, handler.getGame().getWidth()/2 - 50, 410, 380, 80, null);
				g.drawImage(Assets.box100x100, handler.getGame().getWidth()/2 + 350, 400, null);
			}
			
			
			if(fileNum == 0)
				g.drawImage(Assets.num1, handler.getWidth()/2 - 330, handler.getHeight()/8 + 15, null);
			else if(fileNum == 1)
				g.drawImage(Assets.num2, handler.getWidth()/2 - 330, handler.getHeight()/8 + 15, null);
			else if(fileNum == 2)
				g.drawImage(Assets.num3, handler.getWidth()/2 - 330, handler.getHeight()/8 + 15, null);
			
			if(handler.getGame().getUserData(fileNum).isFile())
			{
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
				g.setColor(Color.BLACK);
				g.drawString("FILE " + Integer.toString(fileNum + 1), 302, handler.getHeight()/8 + 72);
				g.setColor(Color.WHITE);
				g.drawString("FILE " + Integer.toString(fileNum + 1), 300, handler.getHeight()/8 + 70);
				
				for(int a = 0; a < handler.getGame().getUserData(fileNum).getTotalHeartCrystals(); a++)
				{
					if(a < handler.getGame().getUserData(fileNum).getActiveHeartCrystals())
						g.drawImage(Assets.heartCrystal, 620 + a *17, handler.getHeight()/8 + 47, null);
					else
						g.drawImage(Assets.usedHeartCrystal, 620 + a *17, handler.getHeight()/8 + 47, null);
				}
				
				g.drawLine(300, handler.getHeight()/8 + 75, 800, handler.getHeight()/8 + 75);
				
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 15));
				
				g.setColor(Color.BLACK);
				g.drawString("Total play time                                 " + handler.getGame().getUserData(fileNum).getTotalPlayTime(), 372, handler.getHeight()/8 + 92);
				g.setColor(new Color(134, 211, 61));
				g.drawString("Total play time                                 " + handler.getGame().getUserData(fileNum).getTotalPlayTime(), 370, handler.getHeight()/8 + 90);
				
				
			}
			else
			{
				text = "NEW FILE";
				g.setFont(new Font(handler.getGame().font, Font.BOLD, 30));
				g.setColor(Color.BLACK);
				g.drawString(text, (handler.getWidth() - g.getFontMetrics().stringWidth(text))/2, handler.getHeight()/8 + 97);
				g.setColor(Color.WHITE);
				g.drawString(text, (handler.getWidth() - g.getFontMetrics().stringWidth(text))/2 - 2, handler.getHeight()/8 + 95);
			}
			
			g.setFont(new Font(handler.getGame().font, Font.BOLD, 40));
			g.setColor(Color.BLACK);
			g.drawString("START", handler.getGame().getWidth()/2 - 325, 467);
			g.drawString("ERASE", handler.getGame().getWidth()/2 + 92, 467);
			g.setColor(Color.WHITE);
			g.drawString("START", handler.getGame().getWidth()/2 - 327, 465);
			g.drawString("ERASE", handler.getGame().getWidth()/2 + 90, 465);
			g.drawImage(Assets.settingsIcon, handler.getGame().getWidth()/2 + 350, 400, null);
		}
		
		selectorBox.render(g);
		effects.render(g);
	}	
}
