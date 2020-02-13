package com.base.game;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Selector 
{
	private float x, y; 
	private int width, height;
	private boolean hide;
	public Selector(float x, float y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.setWidth(width);
		this.setHeight(height);
	}
	
	int rVal = 245, gVal = 210, bVal = 70;
	float xVar, yVar, varSpeed = 1;
	public void update()
	{
		if(xVar > 10 || xVar < 0)
		{
			varSpeed = -varSpeed;
		}
		
		xVar+=varSpeed;
		yVar+=varSpeed;
	}
	
	public void render(Graphics g)
	{
		if(!hide && width != 0 && height != 0)
		{
			g.drawImage(Utils.tintImage(Assets.selectorTLft, rVal, gVal, bVal), (int)(x - xVar), (int)(y - yVar), null);
			g.drawImage(Utils.tintImage(Assets.selectorTRgt, rVal, gVal, bVal), (int)(x + xVar) + width - Assets.selectorTRgt.getWidth(), (int)(y - yVar), null);
			g.drawImage(Utils.tintImage(Assets.selectorBLft, rVal, gVal, bVal), (int)(x - xVar), (int)(y + yVar) + height - Assets.selectorBLft.getHeight(), null);
			g.drawImage(Utils.tintImage(Assets.selectorBRgt, rVal, gVal, bVal), (int)(x + xVar) + width - Assets.selectorBRgt.getWidth(), (int)(y + yVar) + height - Assets.selectorBRgt.getHeight(), null);
		}
	}
	
	public void setAll(Rectangle box)
	{
		x = box.x;
		y = box.y;
		width = box.width;
		height = box.height;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isHide() {
		return hide;
	}

	public void setHide(boolean hide) {
		this.hide = hide;
	}
}
