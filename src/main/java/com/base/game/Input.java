package com.base.game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements KeyListener, MouseMotionListener, MouseListener 
{	
	private boolean[] keys, keysReleased, keysClicked, mouse, mouseReleased, mouseClicked;
	public boolean up, down, left, right, upPressed, downPressed, leftPressed, rightPressed, a, w, s, d, z, spaceBar, e;
	public boolean leftClick, rightClick;
	
	public int lastKey, lastButton;
	
	public int xPos, yPos;
	
	public Input()
	{
		keys = new boolean[256];
		keysReleased = new boolean[256];
		keysClicked = new boolean[256];
		
		mouse = new boolean[4];
		mouseReleased = new boolean[4];
		mouseClicked = new boolean[4];
	}
	
	public void update()
	{
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		
		upPressed = keysClicked[KeyEvent.VK_UP];
		downPressed = keysClicked[KeyEvent.VK_DOWN];
		leftPressed = keysClicked[KeyEvent.VK_LEFT];
		rightPressed = keysClicked[KeyEvent.VK_RIGHT];
		
		a = keysClicked[KeyEvent.VK_A];
		w = keysClicked[KeyEvent.VK_W];
		s = keysClicked[KeyEvent.VK_S];
		d = keysClicked[KeyEvent.VK_D];
		z = keysClicked[KeyEvent.VK_Z];
		e = keysClicked[KeyEvent.VK_E];
		spaceBar = keysClicked[KeyEvent.VK_SPACE];
		
		leftClick = mouseClicked[MouseEvent.BUTTON1];
		rightClick = mouseClicked[MouseEvent.BUTTON3];
		
		keysClicked[lastKey] = false;
		mouseClicked[lastButton] = false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		keys[e.getKeyCode()] = true;
		keysReleased[e.getKeyCode()] = false;
	}
	
	public void keyDown(KeyEvent e)
	{
		if(keys[e.getKeyCode()] && keysReleased[e.getKeyCode()])
		{
			keysClicked[e.getKeyCode()] = true;
			lastKey = e.getKeyCode();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keysReleased[e.getKeyCode()] = true;
		keyDown(e);
		keys[e.getKeyCode()] = false;				
	}

	@Override
	public void keyTyped(KeyEvent e){}
	@Override
	public void mouseClicked(MouseEvent e){}
	@Override
	public void mouseEntered(MouseEvent e){}
	@Override
	public void mouseExited(MouseEvent e){}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		mouse[e.getButton()] = true;
		mouseReleased[e.getButton()] = false;
	}

	public void mouseDown(MouseEvent e)
	{
		if(mouse[e.getButton()] && mouseReleased[e.getButton()])
		{
			mouseClicked[e.getButton()] = true;
			lastButton = e.getButton();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e)
	{
		mouseReleased[e.getButton()] = true;
		mouseDown(e);
		mouse[e.getButton()] = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) 
	{
		
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		xPos = e.getX();
		yPos = e.getY();
	}
	
}


