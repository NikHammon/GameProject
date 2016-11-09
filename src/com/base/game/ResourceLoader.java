package com.base.game;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ResourceLoader
{	
	public static BufferedImage loadTexture(String fileName)
	{
		try {
			return ImageIO.read(new File("./res/textures/" + fileName));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
}
