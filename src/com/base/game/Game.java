package com.base.game;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.base.game.entity.Entity;
import com.base.game.entity.EntityManager;
import com.base.game.entity.Player;
import com.base.game.levels.LevelManager;
import com.base.game.state.GameState;
import com.base.game.state.MenuState;
import com.base.game.state.State;

public class Game implements Runnable
{
	public static final String font = "AR Julian";
	
	private Window window;
	private int width, height;
	private int fileNum;
	private String title;
	
	boolean isRunning = false;	
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	private State currentState;
	private GameState gameState;
	private MenuState menuState;
	
	private Input input;
	private Camera camera;	
	private Handler handler;
	private UserData userData0, userData1, userData2;
	
	double delta;
	
	public Game(int width, int height, String title)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		input = new Input();
		userData0 = new UserData();
		userData1 = new UserData();
		userData2 = new UserData();
		
		init();
		
	}
	
	public void loadFiles()
	{		
		try 
		{	
			FileInputStream fis = new FileInputStream("userData0.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			userData0 = (UserData) ois.readObject();	
			
			fis = new FileInputStream("userData1.ser");
			ois = new ObjectInputStream(fis);
			userData1 = (UserData) ois.readObject();
			
			fis = new FileInputStream("userData2.ser");
			ois = new ObjectInputStream(fis);
			userData2 = (UserData) ois.readObject();
			
			ois.close();
		} 
		catch (FileNotFoundException e){e.printStackTrace();}	
		catch (ClassNotFoundException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
		
		
	}
	
	public void startGame(int fileNum)
	{
		this.fileNum = fileNum;
		currentState = gameState;
		gameState.setGameStart(System.currentTimeMillis());
		gameState.getEffects().setAlpha(1);
		gameState.getEffects().fade(0);
		
		if(fileNum == 0)
			userData0.setData(handler);	
		if(fileNum == 1)
			userData1.setData(handler);	
		if(fileNum == 2)
			userData2.setData(handler);	
	}

	public synchronized void start()
	{
		if(isRunning)
			return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();//calls run
	}

	public void run()
	{
	
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
        while(isRunning) 
        { 	    
    		now = System.nanoTime();
    		delta += (now - lastTime) / timePerTick;
    		timer += now - lastTime;
    		lastTime = now;
    		
        	if(delta >= 1)
        	{
				update();           
	            render();   
	            ticks++;
	            delta--;
        	}
        	
        	if(timer >= 1000000000)
        	{
        		System.out.println(ticks);
        		ticks = 0;
        		timer = 0;
        	}
		}
        
        stop();      
	}
	
	public void init()
	{
		window = new Window(width, height, title);
		
		window.getCanvas().addMouseListener(input);
		window.getCanvas().addMouseMotionListener(input);
		window.getFrame().addKeyListener(input);
		Assets.init();
		
		handler = new Handler(this);
		camera = new Camera(handler, 0, 0);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		currentState = menuState;
		loadFiles();
	}
	
	public void update()
	{
		input.update();
		
		if(currentState != null)
		{
			currentState.update();
		}
		
	}
	
	public void render()
	{	
		bs = window.getCanvas().getBufferStrategy();
		if(bs == null)
		{		
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clearScreen
		g.clearRect(0, 0, width, height);
		
		//draw

		if(currentState != null)
		{
			currentState.render(g);	
			
		}
		
		//draw
		
		bs.show();
		g.dispose();
	}
	
	public synchronized void stop()
	{
		if(!isRunning)
			return;
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveState()
	{
		if(fileNum == 0)
		{
			userData0.updateData(handler);
			try 
			{
				FileOutputStream fos = new FileOutputStream("userData0.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(userData0);
				oos.close();
			} 
			catch (FileNotFoundException e) {e.printStackTrace();} 
			catch (IOException e) {e.printStackTrace();}
		}
		else if(fileNum == 1)
		{
			userData1.updateData(handler);
			try 
			{
				FileOutputStream fos = new FileOutputStream("userData1.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(userData1);
				oos.close();
			} 
			catch (FileNotFoundException e) {e.printStackTrace();} 
			catch (IOException e) {e.printStackTrace();}
		}
		else if(fileNum == 2)
		{
			userData2.updateData(handler);
			try 
			{
				FileOutputStream fos = new FileOutputStream("userData2.ser");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(userData2);
				oos.close();
			} 
			catch (FileNotFoundException e) {e.printStackTrace();} 
			catch (IOException e) {e.printStackTrace();}
		}
		
	}
	
	public Player getPlayer()
	{
		if(gameState.getLevelManager().isInDungeon())
			return gameState.getLevelManager().getCurrentDungeon().getCurrentLevel().geteManager().getPlayer();
		else
			return gameState.getLevelManager().getBaseCamp().geteManager().getPlayer();
	}
	
	public EntityManager geteManager()
	{
		if(gameState.getLevelManager().isInDungeon())
			return gameState.getLevelManager().getCurrentDungeon().getCurrentLevel().geteManager();
		else
			return gameState.getLevelManager().getBaseCamp().geteManager();
	}
	
	public Input getInput(){return input;}
	public Camera getCamera(){return camera;}
	public GameState getGameState(){return (GameState) gameState;}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	public double getDelta(){return delta;}
	public State getCurrentState(){return currentState;}
	public void setCurrentState(State currentState){this.currentState = currentState;}

	public UserData getUserData(int num) 
	{
		if(num == 0)
			return userData0;
		else if(num == 1)
			return userData1;
		else
			return userData2;
	}

	public void setUserData0(UserData userData0) {
		this.userData0 = userData0;
	}

	public void setUserData1(UserData userData1) {
		this.userData1 = userData1;
	}

	public void setUserData2(UserData userData2) {
		this.userData2 = userData2;
	}

}