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
	public static final String font = "Times-Roman";
	public static final int SAVE_FILE_COUNT = 3;

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
	private UserData[] userData;

	private EntityManager eManager;
	
	double delta;

	public Game(int width, int height, String title)
	{
		this.width = width;
		this.height = height;
		this.title = title;
		input = new Input();
		userData = new UserData[SAVE_FILE_COUNT];
		for(int i = 0; i < SAVE_FILE_COUNT; ++i)
			userData[i] = new UserData();
		
		init();
	}
	
	public void loadFiles() {
		for(int i = 0; i < SAVE_FILE_COUNT; ++i) {
			try (FileInputStream fis = new FileInputStream(String.format("userData%d.ser", i));
				 ObjectInputStream ois = new ObjectInputStream(fis)) {
				userData[i] = (UserData) ois.readObject();
			}
			catch (FileNotFoundException e){e.printStackTrace();}
			catch (ClassNotFoundException e) {e.printStackTrace();}
			catch (IOException e) {e.printStackTrace();}
		}
	}
	
	public void startGame(int fileNum) {
		this.fileNum = fileNum;
		currentState = gameState;
		gameState.setGameStart(System.currentTimeMillis());
		gameState.getEffects().setAlpha(1);
		gameState.getEffects().fade(0);

		eManager = new EntityManager(handler, new Player(handler));
		userData[fileNum].setData(handler);
	}

	public synchronized void start() {
		if(isRunning)
			return;
		isRunning = true;
		thread = new Thread(this);
		thread.start();//calls run
	}

	public void run() {
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
        while(isRunning) {
    		now = System.nanoTime();
    		delta += (now - lastTime) / timePerTick;
    		timer += now - lastTime;
    		lastTime = now;
    		
        	if(delta >= 1) {
				update();           
	            render();   
	            ticks++;
	            delta--;
        	}
        	
        	if(timer >= 1000000000) {
        		System.out.println(ticks);
        		ticks = 0;
        		timer = 0;
        	}
		}
        
        stop();      
	}
	
	public void init() {
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
	
	public void update() {
		input.update();
		
		if(currentState != null)
			currentState.update();
	}
	
	public void render() {
		bs = window.getCanvas().getBufferStrategy();
		if(bs == null) {
			window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//clearScreen
		g.clearRect(0, 0, width, height);
		
		//draw
		if(currentState != null)
			currentState.render(g);

		bs.show();
		g.dispose();
	}
	
	public synchronized void stop() {
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
	
	public void saveState() {
		userData[fileNum].updateData(handler);
		try (FileOutputStream fos = new FileOutputStream(String.format("userData%d.ser", fileNum));
			 ObjectOutputStream oos = new ObjectOutputStream(fos)){
				oos.writeObject(userData[fileNum]);
		}
		catch (FileNotFoundException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}
	
	public Player getPlayer() {
		return eManager.getPlayer();
	}
	
	public EntityManager geteManager() {
		return eManager;
	}
	
	public Input getInput(){return input;}
	public Camera getCamera(){return camera;}
	public GameState getGameState(){return (GameState) gameState;}
	public int getWidth(){return width;}
	public int getHeight(){return height;}
	public double getDelta(){return delta;}
	public State getCurrentState(){return currentState;}
	public void setCurrentState(State currentState){this.currentState = currentState;}

	public UserData getUserData(int num) {
		return userData[num];
	}
}