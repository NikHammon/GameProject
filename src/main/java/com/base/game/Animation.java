package com.base.game;

import java.awt.image.BufferedImage;

public class Animation 
{
	private int speed, index, cycles, cycleCounter = 1;
	private long lastTime, timer;
	private boolean complete;
	private BufferedImage[] frames;

	public Animation(int speed, BufferedImage[] frames, int cycles)
	{
		this.speed = speed;
		this.frames = frames;
		index = -1;
		this.cycles = cycles;
		complete = false;
	}
	
	public void update()
	{
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if(cycles == 0)
		{
			if(timer > speed)
			{
				index++;
				timer = 0;
				if(index >= frames.length)
					index = 0;
			}
		}
		
		else
		{
			if(timer > speed)
			{
				if(index < frames.length-1)
					index++;
				else if(cycles == cycleCounter)
				{
					complete = true;
					cycleCounter = 1;
				}
				else
				{
					cycleCounter++;
					index = 0;
				}
				timer = 0;
			}
		}
	}
	
	

	public BufferedImage getCurrentFrame()
	{		
		if(index >= 0)
			return frames[index];		
		else
			return frames[0];
	}
	
	public void reset()
	{
		index = -1;
		complete = false;
	}
	
	public boolean isAlmostComplete()
	{
		if(index >= frames.length - 1)
			return true;
		return false;
	}
	
	public int getCurrentIndex(){return index;}
	public boolean isComplete() {return complete;}
	public void setComplete(boolean complete) {this.complete = complete;}
	
	public int getCycles() {
		return cycles;
	}

	public void setCycles(int cycles) {
		this.cycles = cycles;
	}

	public int getIndex() {return index;}
	public void setIndex(int index) {this.index = index;}
	
}
