package com.base.game.levels;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.base.game.*;
import com.base.game.tiles.Tile;

public class LevelManager {
	private Handler handler;
	private PlayerInterface pInterface;
	private InventoryInterface iInterface;
	private LevelGenerator levelGenerator;

	public List<Level> levels;
	private Level currentLevel;
	private BaseCamp baseCamp;
	private WorldMap worldMap;
	private Dungeon currentDungeon;
	private int spawnX, spawnY, spawnLayer;
	private String state;
	private boolean inDungeon;
	private Holomap holoMap;

	public LevelManager(Handler handler) {
		this.handler = handler;
		pInterface = new PlayerInterface(handler);
		iInterface = new InventoryInterface(handler);
		levelGenerator = new LevelGenerator();

		baseCamp = new BaseCamp(handler);
		worldMap = new WorldMap(handler);
		levels = new ArrayList<Level>();
		inDungeon = false;
		holoMap = new Holomap(handler);
	}

	public void setCurrentLevel(Level level) {
		currentLevel = level;
		handler.setLevel(level);
	}

	float minAlpha = 0;
	float maxAlpha = 1;

	public void update() {
		if (state == "INTODUNGEON") {
			if (handler.getGame().getGameState().getEffects().getState() == "FADEIN") {
				if (handler.getGame().getGameState().getEffects().getAlpha() == maxAlpha) {
					inDungeon = true;
					generateLevel();
					handler.getGame().getGameState().getEffects()
							.displayDungeon(handler.getGame().getPlayer().getCurrentFloor(), currentDungeon.toString());
				}
			} else if (handler.getGame().getGameState().getEffects().getState() == "DUNGEONDISPLAY") {
				if (handler.getGame().getGameState().getEffects().getTimer() > 10000)
					handler.getGame().getGameState().getEffects().fade(minAlpha);
			} else if (handler.getGame().getGameState().getEffects().getState() == "FADEOUT") {
				if (handler.getGame().getGameState().getEffects().getAlpha() == minAlpha) {
					handler.getGame().getGameState().getEffects().setState("");
					state = "";
					// if(handler.getLevel().isQuestFloor())
					// handler.getGame().getGameState().getEffects().displayDialog(7);
				}
			}
		} else if (state == "GAMEOVER") {
			if (handler.getGame().getGameState().getEffects().getAlpha() == 1
					&& handler.getGame().getGameState().getEffects().getdBox().isComplete()) {
				handler.getGame().getPlayer().setCurrentFloor(0);
				inDungeon = false;
				handler.getGame().getGameState().getEffects().fade(0);
				handler.getBaseCamp().setState("BEDROOM");
				handler.getGame().getPlayer().setX(252);
				handler.getGame().getPlayer().setY(244);
				handler.getBaseCamp().setNPCs();
				handler.getBaseCamp().setBarriers();
				state = "";
			}
		}

		if (worldMap.isActive())
			worldMap.update();
		else {
			if (iInterface.isActive())
				iInterface.update();
			else {
				if (inDungeon) {
					currentLevel.update();
					holoMap.update();
				} else
					baseCamp.update();
			}
			pInterface.update();
		}

		if (handler.getGame().getPlayer().getState() == "DEAD") {
			handler.getGame().getGameState().getEffects().displayDialog(0);
			state = "GAMEOVER";
			handler.getGame().getGameState().getEffects().fade(1);
		}
	}

	public void render(Graphics g) {
		if (worldMap.isActive()) {
			worldMap.render(g);
		} else {
			if (inDungeon) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, handler.getWidth(), handler.getHeight());
				currentLevel.render(g);
				holoMap.render(g, levelGenerator);
			} else
				baseCamp.render(g);

			if (iInterface.isActive())
				iInterface.render(g);

			pInterface.render(g);
		}
	}

	public void setCurrentDungeon(Dungeon dungeon) {
		state = "INTODUNGEON";
		currentDungeon = dungeon;
		handler.getGame().getGameState().getEffects().fade(maxAlpha);
	}

	public void generateLevel() {

		handler.getGame().geteManager().removeAllExcept(handler.getGame().getPlayer());

		levelGenerator.setElements();

		while (!levelGenerator.path()) {// tests if pathing is possible, if not possible, assigns a random seed and goes
										// from there repeating assignment of random seeds until a valid map exists.
			levelGenerator = new LevelGenerator();
			levelGenerator.setElements();
		}
		levelGenerator.seek();
		levelGenerator.toTextFile("./res/levels", "Dgn1.txt");

		currentLevel = new Level(handler, "Dgn1.txt", currentDungeon);

		handler.getGame().getGameState().getEffects().fade(minAlpha);

		handler.getGame().getPlayer().setCurrentFloor(handler.getGame().getPlayer().getCurrentFloor() + 1);

		handler.setLevel(currentLevel);

		// handler.getLevel().setQuestFloor(generatedQuestFloor);
		// generatedQuestFloor = false;
		handler.getGame().getPlayer().setX((levelGenerator.getStartX() + 11) * Tile.TILE_WIDTH);
		handler.getGame().getPlayer().setY((levelGenerator.getStartY() + 11) * Tile.TILE_HEIGHT);
		handler.getGame().getPlayer().setLayer(2);
		handler.getGame().getPlayer().setState("CHASE");
		Utils.playSound(handler.getGame().getPlayer().getCurrentDungeon().getTheme());
	}

	public boolean isInDungeon() {
		return inDungeon;
	}

	public void setInDungeon(boolean inDungeon) {
		this.inDungeon = inDungeon;
	}

	public Level getCurrentLevel() {
		return currentLevel;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public PlayerInterface getpInterface() {
		return pInterface;
	}

	public void setpInterface(PlayerInterface pInterface) {
		this.pInterface = pInterface;
	}

	public InventoryInterface getiInterface() {
		return iInterface;
	}

	public void setiInterface(InventoryInterface iInterface) {
		this.iInterface = iInterface;
	}

	public BaseCamp getBaseCamp() {
		return baseCamp;
	}

	public void setBaseCamp(BaseCamp baseCamp) {
		this.baseCamp = baseCamp;
	}

	public WorldMap getWorldMap() {
		return worldMap;
	}

	public void setWorldMap(WorldMap worldMap) {
		this.worldMap = worldMap;
	}

}
