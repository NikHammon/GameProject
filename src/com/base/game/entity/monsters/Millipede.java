package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Handler;
import com.base.game.entity.EntityManager;

public class Millipede extends Monster
{
	private int size;
	private BodySegment[] body;
	private int displacementX;
	private int displacementY;

	public Millipede(Handler handler, float x, float y, int layer, int size, int level, String element)
	{
		super(handler, x, y, layer, 48, 48, level);
		setBounds(new Rectangle(0,0,0,0));
		this.size = size;
		this.element = element;
		setCanBeKnkBack(false);
	}
	
	@Override
	public void update()
	{	
		if(body == null)
		{
			body = new BodySegment[size];
			
			for(int i = 0; i < size; i++)
			{
				body[i] = new BodySegment(handler, x - i * 26, y + i * 18, i, this, layer);
				handler.getGame().geteManager().addEntity(body[i]);
			}
		}
		
		if(state == "KNOCKBACK")
			state = "CHASE";
		if(body.length <= 0)
			state = "DEAD";
		else
		{
			for(int i = size-1; i >= 0; i--)
			{	
				if(i-1 >= 0)
					body[i].updateSegment(body[i-1].getX(), body[i-1].getY());	
				else
					body[i].updateSegment(0,0);
			}
		}	
		
	}
	
	@Override
	public void render(Graphics g) 
	{

	}
	
	public int getDisplacementX() {return displacementX;}
	public void setDisplacementX(int displacementX) {this.displacementX = displacementX;}
	public int getDisplacementY() {return displacementY;}
	public void setDisplacementY(int displacementY) {this.displacementY = displacementY;}
	public int getSize() {return size;}
	public void setSize(int size) {this.size = size;}
		

	@Override
	public void attack() {}
		
}
