package com.base.game.entity.monsters;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.staticEntity.StaticEntity;

public class BodySegment extends Monster
{	
	private int pos;
	private Millipede millipede;
	private BufferedImage[] headDirection;
	private BufferedImage[] tailDirection;
	
	public BodySegment(Handler handler, float x, float y, int pos, Millipede millipede, int layer)
	{
		super(handler, x, y, layer, 48, 48, millipede.getLevel());
		this.pos = pos;
		this.millipede = millipede;
		element = millipede.getElement();
		setBounds(new Rectangle(20, 20, 16, 20));
		
		baseSpeed = 1f;
		currSpeed = baseSpeed;
		health = 1;
		damage = 2;
		harmsOtherMonsters = true;
		setCanBeKnkBack(false);
		
		switch(element)
		{
		case "FIRE":
			dwnLft = new Animation(150, Assets.fireMilliBodyDownLeft, 0);
			dwnRgt = new Animation(150, Assets.fireMilliBodyDownRight, 0);
			upLft = new Animation(150, Assets.fireMilliBodyUpLeft, 0);
			upRgt = new Animation(150, Assets.fireMilliBodyUpRight, 0);
			
			headDirection = Assets.fireMilliHead;
			tailDirection = Assets.fireMilliTail;
		break;
		
		default:
			dwnLft = new Animation(150, Assets.milliBodyDownLeft, 0);
			dwnRgt = new Animation(150, Assets.milliBodyDownRight, 0);
			upLft = new Animation(150, Assets.milliBodyUpLeft, 0);
			upRgt = new Animation(150, Assets.milliBodyUpRight, 0);
			
			headDirection = Assets.milliHead;
			tailDirection = Assets.milliTail;
		}
		
		currentAnimation = dwnLft;
		
		state = "CHASE";
	}

	
	public void update()
	{	
	
	}
	
	float distance;

	public void updateHead()
	{	
		xMove = 0;
		yMove = 0;
		
		if(distance < 32 * millipede.getSize() && distance >= 0)
		{
			xMove += currSpeed;
			yMove += currSpeed;
			millipede.setDisplacementX(-20);
			millipede.setDisplacementY(-20);
		}
		
		else if(distance >= 32 * millipede.getSize() && distance < 64 * millipede.getSize())
		{
			xMove -= currSpeed;
			yMove += currSpeed;
			millipede.setDisplacementX(20);
			millipede.setDisplacementY(-20);
		}
		else if(distance >= 64 * millipede.getSize() && distance < 96 * millipede.getSize())
		{
			xMove -= currSpeed;
			yMove -= currSpeed;
			millipede.setDisplacementX(20);
			millipede.setDisplacementY(20);
		}
		else if(distance >= 96 * millipede.getSize() && distance < 128 * millipede.getSize())
		{
			xMove += currSpeed;
			yMove -= currSpeed;
			millipede.setDisplacementX(-20);
			millipede.setDisplacementY(20);
		}
		else
			distance = 0;
		
		
		distance += currSpeed*2;
	}
	
	public void calcDirection()
	{
		if(xMove < 0 && yMove < 0)
			direction = 3;
		else if(xMove > 0 && yMove < 0)
			direction = 2;
		else if(xMove < 0 && yMove > 0)
			direction = 0;
		else
			direction = 1;
	}
	
	public void updateSegment(float xPos, float yPos)
	{
		if(pos == 0)
			updateHead();
		else
		{
			setCurrentAnimation();
			currentAnimation.update();
			moveTo(xPos + millipede.getDisplacementX(), yPos + millipede.getDisplacementY());	
		}
		attack();
		move();
	}
	
	@Override
	public void attack() 
	{
		//updateAttackBounds();
		//damageEntity();
	}
	
	@Override
	public void render(Graphics g) 
	{
		super.render(g);
		
		calcDirection();
		
		if(pos == 0)
			g.drawImage(headDirection[direction],(int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);
		else if(pos == millipede.getSize() - 1)
			g.drawImage(tailDirection[direction],(int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);
		else
			g.drawImage(currentAnimation.getCurrentFrame(),(int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);
	}

}
