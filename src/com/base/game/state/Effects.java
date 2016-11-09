package com.base.game.state;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.Random;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.DialogBox;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.eventEntity.NPC.Budaroth;
import com.base.game.tiles.Tile;

public class Effects
{
	private Handler handler;
	private float alpha;
	private String state;
	private String secondState;
	private Animation smoke, lightning;
	
	protected DialogBox dBox;

	public Effects(Handler handler)
	{
		this.handler = handler;
		state = "";
		secondState = "";
		dBox = new DialogBox(handler);
		smoke = new Animation(50, Assets.smokeScreen, 1);
		lightning = new Animation(50, Assets.lightning, 1);
	}

	float opacity;
	public void fade(float opacity)
	{	
		this.opacity = opacity;	
		if(opacity > alpha)
			state = "FADEIN";
		else
			state = "FADEOUT";
		
	}
	
	public void whiteOut(float opacity)
	{	
		this.opacity = opacity;	
		if(opacity > alpha)
			state = "WHITEIN";
		else
			state = "WHITEOUT";
		
	}
	
	int floorNum;
	String name;
	long timer, lastTime;
	public void displayDungeon(int floorNum, String name)
	{
		state = "DUNGEONDISPLAY";		
		this.floorNum = floorNum;
		this.name = name;
		timer = 0;
		lastTime = System.currentTimeMillis();
	}
	
	boolean activeDBox;
	public void displayDialog(int scriptNum)
	{
		activeDBox = true;
		dBox.setScriptNum(scriptNum);
	}
	
	float sunriseAlpha;
	public void sunrise()
	{
		sunriseAlpha = .8f;
		state = "SUNRISE";
	}
	
	
	int selector, dungeonsUnlocked;
	public void selectDungeon(int selector, int dungeonsUnlocked)
	{
		secondState = "DUNGEONSELECTION";
		this.selector = selector;
		this.dungeonsUnlocked = dungeonsUnlocked;
	}
	
	boolean drawRect;
	int x, y, width, height;
	public void drawRectangle(int x, int y, int width, int height)
	{
		drawRect = true;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
	}
	
	boolean renderSmokeScreen;	
	public void smokescreen()
	{
		
		renderSmokeScreen = true;
		smoke.reset();
	}
	
	String tStormState = "";
	int flashColor;
	boolean thunderStorm, lightningStorm, boltActive;
	float thunderAlpha, darkAlpha;
	float thunderAlphaSpeed;
	int boltX,boltY;
	public void thunderStorm()
	{
		tStormState = "INIT";
		thunderStorm = true;
		thunderAlpha = darkAlpha = 0;
		thunderAlphaSpeed = .02f;
	}
	
	boolean forestSceen;
	float budarothAlpha;
	Budaroth budaroth; 
	Random rand = new Random();
	public void render(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g;
		
		if(renderSmokeScreen)
		{
			if(smoke.isComplete())
			{
				renderSmokeScreen = false;
			}
			else
			{
				smoke.update();

				g.drawImage(smoke.getCurrentFrame(), (int)((10 * Tile.TILE_WIDTH - 32) - handler.getCamera().getxOffset()), (int)(12 * Tile.TILE_HEIGHT - 50 - handler.getCamera().getyOffset()), smoke.getCurrentFrame().getWidth() *2, smoke.getCurrentFrame().getHeight() *2, null);
				g.drawImage(smoke.getCurrentFrame(),(int)((13.5f * Tile.TILE_WIDTH - 32) - handler.getCamera().getxOffset()), (int)(12 * Tile.TILE_HEIGHT - 50 - handler.getCamera().getyOffset()), smoke.getCurrentFrame().getWidth() *2, smoke.getCurrentFrame().getHeight() *2, null);
					
			}
			
		}
		
		if(thunderStorm)
		{
			if(tStormState == "INIT")
			{
				darkAlpha += .003;
				
				if(darkAlpha >= .3)
				{
					tStormState = "STORM";
					flashColor = rand.nextInt(400);
					darkAlpha = .3f;
				}
			}
			else if(tStormState == "STORM")
			{
				if(flashColor == 0)
					Utils.drawFadedImage(g2d, thunderAlpha, Assets.yellowLightning, 0, 0, handler.getWidth(), handler.getHeight());
				else if(flashColor == 1)
					Utils.drawFadedImage(g2d, thunderAlpha, Assets.blueLightning, 0, 0, handler.getWidth(), handler.getHeight());
				else if(flashColor == 2)
					Utils.drawFadedImage(g2d, thunderAlpha, Assets.whiteOut, 0, 0, handler.getWidth(), handler.getHeight());
					
				if(flashColor == 0 || flashColor == 1 || flashColor == 2)
				{
					if(thunderAlpha + thunderAlphaSpeed >= .3)
					{
						thunderAlphaSpeed = -thunderAlphaSpeed;
						
					}
					else if(thunderAlpha + thunderAlphaSpeed <= 0)
					{
						thunderAlphaSpeed = -thunderAlphaSpeed;
						flashColor = rand.nextInt(400);
					}
					thunderAlpha += thunderAlphaSpeed;
					darkAlpha -= thunderAlphaSpeed;
				}
				else
				{
					flashColor = rand.nextInt(400);
				}
				
				if(lightningStorm)
				{
					if(!boltActive && rand.nextInt(100) == 0)
					{
						boltActive = true;
						boltX = (rand.nextInt(2) == 1) ? rand.nextInt(handler.getWidth()/2 - 72) : rand.nextInt(handler.getWidth() - 72) + handler.getWidth()/2 + 112;
						boltY = -rand.nextInt(100);
					}
					if(boltActive)
					{
						if(lightning.isComplete())
						{
							boltActive = false;
							lightning.reset();
						}
						else
						{
							lightning.update();
							g.drawImage(lightning.getCurrentFrame(), boltX, boltY, lightning.getCurrentFrame().getWidth()*2, lightning.getCurrentFrame().getHeight()*2, null);
						}
					}
				}
			}
			
			else if(tStormState == "FADE")
			{
				darkAlpha -= .003;
				
				if(darkAlpha <= 0)
				{
					tStormState = "";
					thunderStorm = false;
					darkAlpha = 0;
				}
			}
			
			Utils.drawFadedImage(g2d, darkAlpha, Assets.night, 0, 0, handler.getWidth(), handler.getHeight());
			
			handler.getGame().getGameState().getLevelManager().getpInterface().render(g);
		}
		
		if(forestSceen)
		{
			if(budaroth == null)
				budaroth = new Budaroth(handler, 0, 0, 0);
			g.drawImage(Assets.forestBG, 0, 0, Assets.forestBG.getWidth() * 2, Assets.forestBG.getHeight() * 2,null);
			Utils.drawFadedImage(g, budarothAlpha, budaroth.getCurrentAnimation().getCurrentFrame(), 450, 240, 80, 80);
			if(budarothAlpha > 0)
				budaroth.getCurrentAnimation().update();
		}
		
		if(drawRect)
		{
			g2d.setColor(Color.BLACK);
			g2d.fillRect((int)(x-handler.getCamera().getxOffset()), (int)(y-handler.getCamera().getyOffset()), width, height);
		}
		
		switch(state)
		{
		case "FADEIN":
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
			if(alpha < opacity)
				alpha += .03;
			if(alpha > opacity)
				alpha = opacity;
		break;
		case "FADEOUT":
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
			if(alpha > opacity)
				alpha -= .03;
			if(alpha < opacity)
				alpha = opacity;
		break;
		case "WHITEIN":
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
			if(alpha < opacity)
				alpha += .03;
			if(alpha > opacity)
				alpha = opacity;
		break;
		case "WHITEOUT":
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
			if(alpha > opacity)
				alpha -= .03;
			if(alpha < opacity)
				alpha = opacity;
		break;
		case "DUNGEONDISPLAY":
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
			g.setColor(Color.WHITE);
			g.setFont(new Font(handler.getGame().font, Font.PLAIN, 40));
			g.drawString(name, (handler.getWidth() - g.getFontMetrics().stringWidth(name))/2, 200);
			g.drawString("F" + Integer.toString(floorNum), handler.getWidth()/2 - 15, 245);		
			
			g.drawImage(Assets.selector[0], handler.getWidth()/2 - 48, 280, 96, 96, null);	
			g.drawImage(Assets.elements[handler.getGame().getGameState().getLevelManager().getNumCurrentDungeon() + 1], handler.getWidth()/2 - 48, 280, 96, 96, null);
			
			timer += System.currentTimeMillis() - lastTime;
		break;
		case "SUNRISE":
			Utils.drawFadedImage(g2d, sunriseAlpha, Assets.night, 0, 0, handler.getWidth(), handler.getHeight());
			
			sunriseAlpha -= .005;
			if(sunriseAlpha < 0)
				sunriseAlpha = 0;
			break;
		
		}
		
		switch(secondState)
		{
		case "DUNGEONSELECTION":
			for(int i = 1; i < 5; i++)
			{	
				if(i == selector)
					g.drawImage(Assets.selector[0], 55 + i*120, 190, 96, 96, null);
				if(i > dungeonsUnlocked)
					g.drawImage(Assets.elements[0], 55 + i*120, 190, 96, 96, null);
				else
					g.drawImage(Assets.elements[i], 55 + i*120, 190, 96, 96, null);
			}
			for(int i = 5; i < 9; i++)
			{	
				if(i == selector)
					g.drawImage(Assets.selector[0], 55 + (i-4)*120, 300, 96, 96, null);
				if(i > dungeonsUnlocked)
					g.drawImage(Assets.elements[0], 55 + (i-4)*120, 300, 96, 96, null);
				else
					g.drawImage(Assets.elements[i], 55 + (i-4)*120, 300, 96, 96, null);
			}
		break;
		}
		
		if(activeDBox)
		{
			if(dBox.isComplete())
			{
				activeDBox = false;
				dBox.reset();
			}
			else 
			{
				dBox.update();
				dBox.render(g);
			}

		}
	}
	

	public float getAlpha() {return alpha;}
	public void setAlpha(float alpha) {this.alpha = alpha;}	
	public String getState() {return state;}
	public void setState(String state) {this.state = state;}
	public String getSecondState() {return secondState;}
	public void setSecondState(String secondState) {this.secondState = secondState;}
	public long getTimer() {return timer;}
	public void setTimer(long timer) {this.timer = timer;}
	public DialogBox getdBox() {return dBox;}
	public void setdBox(DialogBox dBox) {this.dBox = dBox;}

	public boolean isActiveDBox() {
		return activeDBox;
	}

	public void setActiveDBox(boolean activeDBox) {
		this.activeDBox = activeDBox;
	}

	public float getSunriseAlpha() {
		return sunriseAlpha;
	}

	public void setSunriseAlpha(float sunriseAlpha) {
		this.sunriseAlpha = sunriseAlpha;
	}

	public boolean isForestSceen() {
		return forestSceen;
	}

	public void setForestSceen(boolean forestSceen) {
		this.forestSceen = forestSceen;
	}

	public float getBudarothAlpha() {
		return budarothAlpha;
	}

	public void setBudarothAlpha(float budarothAlpha) {
		this.budarothAlpha = budarothAlpha;
	}

	public boolean isDrawRect() {
		return drawRect;
	}

	public void setDrawRect(boolean drawRect) {
		this.drawRect = drawRect;
	}

	public boolean isRenderSmokeScreen() {
		return renderSmokeScreen;
	}

	public void setRenderSmokeScreen(boolean renderSmokeScreen) {
		this.renderSmokeScreen = renderSmokeScreen;
	}

	public boolean isThunderStrom() {
		return thunderStorm;
	}

	public void setThunderStrom(boolean thunderStrom) {
		this.thunderStorm = thunderStrom;
	}

	public boolean isLightningStorm() {
		return lightningStorm;
	}

	public void setLightningStorm(boolean lightningStorm) {
		this.lightningStorm = lightningStorm;
	}

	public String gettStormState() {
		return tStormState;
	}

	public void settStormState(String tStormState) {
		this.tStormState = tStormState;
	}
	
	
	
}
