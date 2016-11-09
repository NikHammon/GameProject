package com.base.game;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Utils 
{
	public static String loadFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("./res/levels/" + path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public static String loadCMFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("./res/cMaps/" + path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	 
	public static String readScript(String scriptNum)
	{
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("./res/scripts/" + scriptNum + ".txt"));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public static void playSound(String path)
	{
		try {
	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("./res/audio/" + path + ".wav").getAbsoluteFile());
	        Clip clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	        clip.start();
	    } catch(Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}
	
	public static int parseInt(String number)
	{
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	
	public static BufferedImage tintImage(Image original, int r, int g, int b){
	    int width = original.getWidth(null);
	    int height = original.getHeight(null);
	    BufferedImage tinted = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    Graphics2D graphics = (Graphics2D) tinted.getGraphics();
	    graphics.drawImage(original, 0, 0, width, height, null);
	    Color c = new Color(r,g,b,128);
	    Color n = new Color(0,0,0,0);
	    BufferedImage tint = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
	    for(int i = 0 ; i < width ; i++){
	        for(int j = 0 ; j < height ; j++){
	            if(tinted.getRGB(i, j) != n.getRGB()){
	                tint.setRGB(i, j, c.getRGB());
	            }
	        }
	    }
	    graphics.drawImage(tint, 0, 0, null);
	    graphics.dispose();
	    return tinted;
	}
	
	public static void drawFadedImage(Graphics g, float alpha, BufferedImage b, int x, int y, int width, int height)
	{
		if(alpha < 0)
			alpha = 0;
		else if(alpha > 1)
			alpha = 1;
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.drawImage(b, x, y, width, height, null);
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));

	}

}	