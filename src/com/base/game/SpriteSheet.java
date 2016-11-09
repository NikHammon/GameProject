package com.base.game;
import java.awt.image.BufferedImage;

public class SpriteSheet 
{
	private BufferedImage sheet;
	
	public SpriteSheet(BufferedImage sheet)
	{
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int heigth)
	{
		return sheet.getSubimage(x, y, width, heigth);
	}
}
