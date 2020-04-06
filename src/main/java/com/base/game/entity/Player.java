package com.base.game.entity;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.eventEntity.EventEntity;
import com.base.game.entity.item.WingedBoots;
import com.base.game.entity.item.GunLance;
import com.base.game.entity.item.Item;
import com.base.game.entity.item.MainItem;
import com.base.game.entity.item.MonkeyStaff;
import com.base.game.entity.item.Whip;
import com.base.game.levels.Dungeon;

public class Player extends Creature
{	
	private Animation playerDown, playerLeft, playerUp, playerRight, playerDownLeft, playerDownRight, playerUpLeft, playerUpRight;

	private Animation playerDownMonkey, playerLeftMonkey, playerUpMonkey, playerRightMonkey, playerDownLeftMonkey, playerDownRightMonkey, playerUpLeftMonkey, playerUpRightMonkey;

	private Animation playerDownGunLance, playerLeftGunLance, playerRightGunLance, playerUpGunLance, playerDownLeftGunLance, playerDownRightGunLance, playerUpLeftGunLance, playerUpRightGunLance;
	
	private Animation playerFallingDown, playerFallingUp, playerFallingLeft, playerFallingRight;
	private Animation playerFallingDownGBoots, playerFallingLeftGBoots, playerFallingRightGBoots, playerFallingUpGBoots;
	
	private Animation playerClimbing, playerCheering;
	
	private Animation playerDead;
	public Animation playerRise;
	private int activeHeartCrystals, totalHeartCrystals;
	private int money, walletSize;
	
	private List<Item> inventory;
	private MainItem itemW;
	private MainItem itemS;
	private MainItem itemD;
	private MainItem lastItemUsed;
	
	private String name = "ASTER";
	
	private float monkeySpeed, gunLanceSpeed;
	private boolean cameraActive, paused;

	private Dungeon currentDungeon;
	private int currentFloor;
	
	public Player(Handler handler) 
	{
		super(handler, 0, 0, 0, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		setBounds(new Rectangle(23, 46, 18, 18));

		baseSpeed = 5;
		currSpeed = baseSpeed;
		shadowOffsetY = 4;
		shadowOffsetX = 2;
		monkeySpeed = 7;
		gunLanceSpeed = 3;
		myHealth = 10;
		health = myHealth;
		cameraActive = true;
		totalHeartCrystals = activeHeartCrystals = 0;
		walletSize = 200;
		inventory = new ArrayList<Item>();
		
		playerDown = new Animation(125, Assets.playerDown, 0);
		playerUp = new Animation(125, Assets.playerUp, 0);
		playerLeft = new Animation(125, Assets.playerLeft, 0);
		playerRight = new Animation(125, Assets.playerRight, 0);
		playerDownLeft = new Animation(125, Assets.playerDownLeft, 0);
		playerDownRight = new Animation(125, Assets.playerDownRight, 0);
		playerUpLeft = new Animation(125, Assets.playerUpLeft, 0);
		playerUpRight = new Animation(125, Assets.playerUpRight, 0);

		playerDownMonkey = new Animation(100, Assets.playerDownMonkey, 0);
		playerUpMonkey = new Animation(100, Assets.playerUpMonkey, 0);
		playerLeftMonkey = new Animation(100, Assets.playerLeftMonkey, 0);
		playerRightMonkey = new Animation(100, Assets.playerRightMonkey, 0);
		playerDownLeftMonkey = new Animation(100, Assets.playerDownLeftMonkey, 0);
		playerDownRightMonkey = new Animation(100, Assets.playerDownRightMonkey, 0);
		playerUpLeftMonkey = new Animation(100, Assets.playerUpLeftMonkey, 0);
		playerUpRightMonkey = new Animation(100, Assets.playerUpRightMonkey, 0);
		
		playerDownGunLance = new Animation(100, Assets.playerDownGunLance, 0);
		playerUpGunLance = new Animation(100, Assets.playerUpGunLance, 0);
		playerLeftGunLance = new Animation(100, Assets.playerLeftGunLance, 0);
		playerRightGunLance = new Animation(100, Assets.playerRightGunLance, 0);
		playerDownLeftGunLance = new Animation(100, Assets.playerDownLeftGunLance, 0);
		playerDownRightGunLance = new Animation(100, Assets.playerDownRightGunLance, 0);
		playerUpLeftGunLance = new Animation(100, Assets.playerUpLeftGunLance, 0);
		playerUpRightGunLance = new Animation(100, Assets.playerUpRightGunLance, 0);
		
		playerFallingDown = new Animation(150, Assets.playerFallingDown, 0);
		playerFallingUp = new Animation(150, Assets.playerFallingUp, 0);
		playerFallingLeft = new Animation(150, Assets.playerFallingLeft, 0);
		playerFallingRight = new Animation(150, Assets.playerFallingRight, 0);
		
		playerFallingDownGBoots = new Animation(150, Assets.playerFallingDownGBoots, 0);
		playerFallingUpGBoots = new Animation(150, Assets.playerFallingUpGBoots, 0);
		playerFallingLeftGBoots = new Animation(150, Assets.playerFallingLeftGBoots, 0);
		playerFallingRightGBoots = new Animation(150, Assets.playerFallingRightGBoots, 0);
		
		playerClimbing = new Animation(175, Assets.playerClimbing, 0);
		playerCheering = new Animation(150, Assets.playerCheering, 1);
		
		playerDead = new Animation(275, Assets.playerDead, 1);
		playerRise = new Animation(300, Assets.playerRise, 1);
		
		state = "CHASE";
	}

	@Override
	public void update() 
	{				
		super.update();

//		System.out.println(state);
//		System.out.println(handler.getBaseCamp().getQuestTracker());
//		System.out.println(handler.getBaseCamp().getGameProgress());
		checkStatus();
		
		if(recovering)
			recover();
		
		if(state == "CHASE")
			action();
		else if(state == "IDLE")
			idle();
		else if(state == "CLIMBINGUP")
			climbUp();
		else if(state == "CLIMBINGDOWN")
			climbDown();
		else if(state == "FALLING")
			falling();
		else if(state == "GRAPPLING")
			grappling();
		else if(state == "KNOCKBACK")
			knockBack();
		else if(state == "FORCEMOVE")
			forceMove();
		else if(state == "DEAD")
			dead();
		else if(state == "RISE")
			rise();
		else if(state == "CHEERING")
			cheer();
		
		if(health <= 0)
		{
			if(activeHeartCrystals > 0)
			{
				health = 10;
				activeHeartCrystals--;
			}
			else
				state = "DEAD";
		}
		
		if(state == "ITEMW")
			itemW.action();
		else if(state == "ITEMS")
			itemS.action();
		else if(state == "ITEMD")
			itemD.action();
		else
		{
			if(itemW != null)
				itemW.reset();
			if(itemS != null)
				itemS.reset();
			if(itemD != null)
				itemD.reset();
		}
		if(cameraActive)
			handler.getCamera().centerOnEntity(this);
		
		if(state != "FALLING")
		{
			setRenderBelowTile(false);
		}
		
		if(!(lastItemUsed instanceof GunLance || lastItemUsed instanceof Whip || state == "CLIMBINGUP" || state == "CLIMBINGDOWN" || state == "CHEERING"))
		{
			yVar = 0;
			xVar = 0;
		}
		
		if(state == "CLIMBINGUP" || state == "CLIMBINGDOWN" || recovering || state == "DEAD" || state == "RISE" || state == "CHEERING")
			doNotRenderShadow = true;
		else
			doNotRenderShadow = false;
		
	}
	private void idle()
	{
		xMove = 0; 
		yMove = 0;
		
		setCurrentAnimation();
	}
	
	private void action() {
		cameraActive = true;

		bImage = null;
		
		xMove = 0;
		yMove = 0;
		if(!paused && !handler.getGame().getGameState().getEffects().isActiveDBox())
			getInput();
		else
			currentAnimation = null;
		
		setCurrentAnimation();
		
		move();				
	}	
	
	private void cheer() {
		if(playerCheering.isComplete() && handler.getInput().a) {
			state = "CHASE";
			direction = 4;
		}
	}
	
	private void dead() {
		xVar = 0; yVar = 0;
		health = 0;
		xVel = 0;
		yVel = 0;
		renderOrder = 2;
		alpha = -1;
		currentAnimation = playerDead;
		currentAnimation.update();
		playerRise.reset();
	}
	
	public void rise() {
		health = myHealth;
		activeHeartCrystals = 3;
		statusCondition = "";
		renderOrder = 3;
		direction = 5;
		layer = 0;
		currSpeed = baseSpeed;
		currentAnimation = playerRise;
		currentAnimation.update();
		playerDead.reset();
		lastItemUsed = null;
		
		if(currentAnimation.isComplete())
			state = "CHASE";
	}
	
	private void climbUp() {
		yVar = 8;
		layer = 5;
		yMove = 0;
		yMove -= currSpeed/2;
		
		currentAnimation = playerClimbing;
		move();
		
	}
	
	private void climbDown() {
		yVar = 8;
		layer = 5;
		yMove = 0;
		yMove += currSpeed/2;
		
		currentAnimation = playerClimbing;
		move();
		
	}

	public void setFallingAnimation() {
		if(lastItemUsed instanceof WingedBoots) {
			if(direction == 7 || direction == 0 || direction == 1)
				currentAnimation = playerFallingUpGBoots;
			else if(direction == 2)
				currentAnimation = playerFallingRightGBoots;
			else if(direction == 6)
				currentAnimation = playerFallingLeftGBoots;
			else if(direction == 3 || direction == 4 || direction == 5)
				currentAnimation = playerFallingDownGBoots;
		}
		else {
			if(direction == 7 || direction == 0 || direction == 1)
				currentAnimation = playerFallingUp;
			else if(direction == 2)
				currentAnimation = playerFallingRight;
			else if(direction == 6)
				currentAnimation = playerFallingLeft;
			else if(direction == 3 || direction == 4 || direction == 5)
				currentAnimation = playerFallingDown;
		}
	}
		
	private long lastTimeUsedItem;
	private void getInput() {
		if(lastItemUsed instanceof MonkeyStaff) {
			if(handler.getInput().up)
				yMove = -monkeySpeed;	
			if(handler.getInput().down)
				yMove = monkeySpeed;	
			if(handler.getInput().left)
				xMove = -monkeySpeed;
			if(handler.getInput().right)
				xMove = monkeySpeed;
		}
		else if(lastItemUsed instanceof GunLance) {
			if(handler.getInput().up)
				yMove = -gunLanceSpeed;	
			if(handler.getInput().down)
				yMove = gunLanceSpeed;	
			if(handler.getInput().left)
				xMove = -gunLanceSpeed;
			if(handler.getInput().right)
				xMove = gunLanceSpeed;
		}
		else {
			if(handler.getInput().up)
				yMove = -currSpeed;	
			if(handler.getInput().down)
				yMove = currSpeed;	
			if(handler.getInput().left)
				xMove = -currSpeed;
			if(handler.getInput().right)
				xMove = currSpeed;
		}
		
		if(handler.getInput().w && itemW != null) {
			state = "ITEMW";
			lastItemUsed = itemW;
			handler.getGame().getGameState().getLevelManager().getpInterface().setState("ITEMW");
			lastTimeUsedItem = System.currentTimeMillis();
		}
		
		if(handler.getInput().s && itemS != null) {
			state = "ITEMS";
			lastItemUsed = itemS;
			handler.getGame().getGameState().getLevelManager().getpInterface().setState("ITEMS");
			lastTimeUsedItem = System.currentTimeMillis();
		}
		
		if(handler.getInput().d && itemD != null) {
			state = "ITEMD";
			lastItemUsed = itemD;
			handler.getGame().getGameState().getLevelManager().getpInterface().setState("ITEMD");
			lastTimeUsedItem = System.currentTimeMillis();
		}
		
		if(handler.getInput().a) {
			for(Entity e : handler.getGame().geteManager().getEntities())
				if(e instanceof EventEntity && ((EventEntity) e).getEventSpace().intersects(getCollisionBounds(0,0)))
					e.on = true;
		}
		if(handler.getInput().z) {
			handler.getGame().getGameState().getEffects().displayDialog(2);
			
			handler.getGame().saveState();
			
		}
		if(handler.getInput().e) {
			handler.getGame().getGameState().getLevelManager().getiInterface().setActive(true);
		}

	}

	float grplTarX, grplTarY;
	public void setGrappling(float x, float y) {
		state = "GRAPPLING";
		grplTarX = x;
		grplTarY = y;
	}
	
	public void grappling() {
		setFallingAnimation();
		moveTo(grplTarX, grplTarY);
		
		move();
		
		System.out.println(xVel);
		if(xVel == 0 && yVel == 0)
		{
			state = "CHASE";
		}
	}
	
	float alpha = -1;
	float alphaRate = .25f;
	int count;
	public void recover() {
		if(alpha < 0)
			alpha = 0;

		if(alphaRate + alpha > 1 || alphaRate + alpha < 1) {
			alphaRate = -alphaRate;
			count++;
		}
		
		alpha+=alphaRate;
		
		if(count > 30) {
			count = 0;
			recovering = false;
			alpha = -1;
		}
		
	}
	
	
	int yVar;
	int xVar;
	
	@Override
	public void render(Graphics g) {
		super.render(g);
		if(bImage != null) {
			g.drawImage(bImage, (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width + xVar, height + yVar, null);
		}
		else {
			if(alpha != -1){
				if(getCurrentAnimation() != null)		
					Utils.drawFadedImage(g, alpha, currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width + xVar, height + yVar);
				else if(lastItemUsed instanceof MonkeyStaff)
					Utils.drawFadedImage(g, alpha, Assets.playerStationaryMonkey[direction],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height);
				else if(lastItemUsed instanceof GunLance)
					Utils.drawFadedImage(g, alpha, Assets.playerStationaryGunLance[direction],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), 70, 80);
				else
					Utils.drawFadedImage(g, alpha, Assets.playerStationary[direction],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height);
			}
			else if(rVal == 0 && gVal == 0 && bVal == 0) {
				if(getCurrentAnimation() != null)		
					g.drawImage(currentAnimation.getCurrentFrame(), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width + xVar, height + yVar, null);
				else if(lastItemUsed instanceof MonkeyStaff)
					g.drawImage(Assets.playerStationaryMonkey[direction],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
				else if(lastItemUsed instanceof GunLance)
					g.drawImage(Assets.playerStationaryGunLance[direction],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), 70, 80, null);
				else
					g.drawImage(Assets.playerStationary[direction],(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			}
			else {
				if(getCurrentAnimation() != null)		
					g.drawImage(Utils.tintImage(currentAnimation.getCurrentFrame(), rVal, gVal, bVal), (int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width + xVar, height + yVar, null);
				else if(lastItemUsed instanceof MonkeyStaff)
					g.drawImage(Utils.tintImage(Assets.playerStationaryMonkey[direction], rVal, gVal, bVal),(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
				else if(lastItemUsed instanceof GunLance)
					g.drawImage(Utils.tintImage(Assets.playerStationaryGunLance[direction], rVal, gVal, bVal),(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), 70, 80, null);
				else
					g.drawImage(Utils.tintImage(Assets.playerStationary[direction], rVal, gVal, bVal),(int) (x - handler.getCamera().getxOffset()), (int) (y - handler.getCamera().getyOffset()), width, height, null);
			}
		}
		
		if(state == "ITEMW")
			itemW.render(g);
		else if(state == "ITEMS")
			itemS.render(g);
		else if(state == "ITEMD")
			itemD.render(g);
		
		if(expressionAnimation != null)			
			renderExpression(g);
		
//		g.setColor(Color.red);
//		g.fillRect((int)(x + bounds.x - handler.getCamera().getxOffset()), (int)(y + bounds.y - handler.getCamera().getyOffset()), bounds.width, bounds.height);
		
	}	
	
	Animation expressionAnimation;
	int expressionOffsetX, expressionOffsetY;
	public void renderExpression(Graphics g) {
		if(expressionAnimation.isComplete())
			expressionAnimation = null;
		else
		{
			g.drawImage(expressionAnimation.getCurrentFrame(), (int) (x + expressionOffsetX - handler.getCamera().getxOffset()), (int) (y + expressionOffsetY - handler.getCamera().getyOffset()), expressionAnimation.getCurrentFrame().getWidth() * 2, expressionAnimation.getCurrentFrame().getHeight() * 2, null);
			expressionAnimation.update();
		}
	}
	
	public void addHealth(int num) {
		setrVal(200);
		setgVal(150);
		setbVal(150);
		
		if(health + num <= myHealth)
			health+=num;
		else if(activeHeartCrystals < totalHeartCrystals)
		{
			activeHeartCrystals++;
			health = myHealth - health + num;	
		}
		else
			health = myHealth;
	}
	
	public void addHeartCrystal() {
		setrVal(200);
		setgVal(150);
		setbVal(150);
		
		currentAnimation = playerCheering;
		state = "CHEERING";
		handler.getGame().getGameState().getEffects().displayDialog(50);
		yVar = 4;
		
		totalHeartCrystals++;
		activeHeartCrystals = totalHeartCrystals;
		health = 10;		
	}
	
	public void takeDamage(int damage) {
		if(state != "KNOCKBACK") {
			health-=damage;
			recovering = true;
			count = 0;
			alpha = -1;
		}
	}
	
	public void addMoney(int num) {
		setrVal(215);
		setgVal(200);
		setbVal(150);
		
		if(money + num <= walletSize)
			money+=num;
		else
			money = walletSize;
	}
	
	public boolean takeMoney(int num) {
		if(money >= num)
		{
			money-=num;
			return true;
		}
		return false;
	}
	
	public void setCurrentAnimation() {
		if(lastItemUsed instanceof MonkeyStaff)
		{	
			if(yMove > 0 && xMove == 0)
			{
				currentAnimation = playerDownMonkey;
				direction = DOWN;
			}
			else if(yMove < 0 && xMove == 0)
			{
				currentAnimation =  playerUpMonkey;
				direction = UP;
			}
			else if(xMove < 0 && yMove == 0)
			{
				currentAnimation = playerLeftMonkey;
				direction = LEFT;
			}
			else if(xMove > 0 && yMove == 0)
			{
				currentAnimation = playerRightMonkey;
				direction = RIGHT;
			}
			else if(xMove < 0 && yMove > 0)
			{
				currentAnimation = playerDownLeftMonkey;
				direction = DOWNLEFT;
			}
			else if(xMove > 0 && yMove > 0)
			{
				currentAnimation = playerDownRightMonkey;
				direction = DOWNRIGHT;
			}
			else if(xMove < 0 && yMove < 0)
			{
				currentAnimation = playerUpLeftMonkey;
				direction = UPLEFT;
			}
			else if(xMove > 0 && yMove < 0)
			{
				currentAnimation = playerUpRightMonkey;
				direction = UPRIGHT;
			}
			else
				currentAnimation = null;
		
		}
		else if(lastItemUsed instanceof GunLance)
		{	
			if(yMove > 0 && xMove == 0)
			{
				currentAnimation = playerDownGunLance;
				direction = DOWN;
			}
			else if(yMove < 0 && xMove == 0)
			{
				currentAnimation =  playerUpGunLance;
				direction = UP;
			}
			else if(xMove < 0 && yMove == 0)
			{
				currentAnimation = playerLeftGunLance;
				direction = LEFT;
			}
			else if(xMove > 0 && yMove == 0)
			{
				currentAnimation = playerRightGunLance;
				direction = RIGHT;
			}
			else if(xMove < 0 && yMove > 0)
			{
				currentAnimation = playerDownLeftGunLance;
				direction = DOWNLEFT;
			}
			else if(xMove > 0 && yMove > 0)
			{
				currentAnimation = playerDownRightGunLance;
				direction = DOWNRIGHT;
			}
			else if(xMove < 0 && yMove < 0)
			{
				currentAnimation = playerUpLeftGunLance;
				direction = UPLEFT;
			}
			else if(xMove > 0 && yMove < 0)
			{
				currentAnimation = playerUpRightGunLance;
				direction = UPRIGHT;
			}
			else
				currentAnimation = null;
		
		}
		else {
			if(yMove > 0 && xMove == 0) {
				currentAnimation = playerDown;
				direction = DOWN;
			}
			else if(yMove < 0 && xMove == 0) {
				currentAnimation =  playerUp;
				direction = UP;
			}
			else if(xMove < 0 && yMove == 0) {
				currentAnimation = playerLeft;
				direction = LEFT;
			}
			else if(xMove > 0 && yMove == 0) {
				currentAnimation = playerRight;
				direction = RIGHT;
			}
			else if(xMove < 0 && yMove > 0) {
				currentAnimation = playerDownLeft;
				direction = DOWNLEFT;
			}
			else if(xMove > 0 && yMove > 0) {
				currentAnimation = playerDownRight;
				direction = DOWNRIGHT;
			}
			else if(xMove < 0 && yMove < 0) {
				currentAnimation = playerUpLeft;
				direction = UPLEFT;
			}
			else if(xMove > 0 && yMove < 0) {
				currentAnimation = playerUpRight;
				direction = UPRIGHT;
			}
			else
				currentAnimation = null;
		}
	}
	
	public void equip(Player oldPlayer) {
		itemW = oldPlayer.itemW;
		itemS = oldPlayer.itemS;
		itemD = oldPlayer.itemD;
		direction = oldPlayer.direction;
		health = oldPlayer.health;
		activeHeartCrystals = oldPlayer.activeHeartCrystals;
		totalHeartCrystals = oldPlayer.totalHeartCrystals;
		money = oldPlayer.money;
		state = "CHASE";
	}
	
	public void refresh(Player oldPlayer) {
		itemW = oldPlayer.itemW;
		itemS = oldPlayer.itemS;
		itemD = oldPlayer.itemD;
		direction = oldPlayer.direction;
		health = 10;
		activeHeartCrystals = oldPlayer.activeHeartCrystals;
		totalHeartCrystals = oldPlayer.totalHeartCrystals;
		money = oldPlayer.money;
		state = "CHASE";
	}
	
	public void setMainItem(MainItem item, char button) {
		if(button == 'w')
		{
			if(itemW != null)
				itemW.setEquipped(false);
			itemW = item;
		}
		else if(button == 's')
		{
			if(itemS != null)
				itemS.setEquipped(false);
			itemS = item;
		}
		else if(button == 'd')
		{
			if(itemD != null)
				itemD.setEquipped(false);
			itemD = item;
		}
	}
	
	public int getyVar() {return yVar;}
	public void setyVar(int yVar) {this.yVar = yVar;}
	public int getxVar() {return xVar;}
	public void setxVar(int xVar) {this.xVar = xVar;}
	public void setCurrentAnimation(Animation animation){currentAnimation = animation;}	
	public MainItem getItemW() {return itemW;}
	public MainItem getItemS() {return itemS;}
	public MainItem getItemD() {return itemD;}	
	public void setItemW(MainItem itemW) {this.itemW = itemW;}
	public void setItemS(MainItem itemS) {this.itemS = itemS;}
	public void setItemD(MainItem itemD) {this.itemD = itemD;}
	public MainItem getLastItemUsed() {return lastItemUsed;}
	public void setLastItemUsed(MainItem lastItemUsed) {this.lastItemUsed = lastItemUsed;}
	public List<Item> getInventory() {return inventory;}
	public void setInventory(ArrayList<Item> inventory) {this.inventory = inventory;}
	public String getMoney() 
	{
		if(money < 10)
			return "000" + Integer.toString(money);
		else if(money < 100)
			return "00" + Integer.toString(money);
		else if(money < 1000)
			return "0" + Integer.toString(money);
		else
			return Integer.toString(money);
		
	}
	public void setMoney(int money) {this.money = money;}
	public int getWalletSize() {return walletSize;}
	public void setWalletSize(int walletSize) {this.walletSize = walletSize;}

	BufferedImage bImage = null;
	public void setCurrentAnimation(BufferedImage bufferedImage) {bImage = bufferedImage;}
	public long getLastTimeUsedItem() {return lastTimeUsedItem;}
	public void setLastTimeUsedItem(long lastTimeUsedItem) {this.lastTimeUsedItem = lastTimeUsedItem;}
	public boolean isCameraActive() {return cameraActive;}
	public void setCameraActive(boolean cameraActive) {this.cameraActive = cameraActive;}

	public int getActiveHeartCrystals() {
		return activeHeartCrystals;
	}
	public void setActiveHeartCrystals(int numHeartCrystals) {
		this.activeHeartCrystals = numHeartCrystals;
	}

	public int getTotalHeartCrystals() {
		return totalHeartCrystals;
	}
	public void setTotalHeartCrystals(int totalHeartCrystals) {
		this.totalHeartCrystals = totalHeartCrystals;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public boolean isPaused() {
		return paused;
	}
	public void setPaused(boolean paused) {
		this.paused = paused;
	}

	public Dungeon getCurrentDungeon() { return currentDungeon; }
	public int getCurrentFloor() {
		return currentFloor;
	}
	public Animation getExpressionAnimation() {
		return expressionAnimation;
	}
	public void setExpressionAnimation(Animation expressionAnimation, int expressionOffsetX, int expressionOffsetY) {
		this.expressionAnimation = expressionAnimation;
		this.expressionOffsetX = expressionOffsetX;
		this.expressionOffsetY = expressionOffsetY;
	}
	public void setCurrentDungeon(Dungeon d) {
		currentDungeon = d;
	}
	public void setCurrentFloor(int i) {
		currentFloor = i;
	}
}
