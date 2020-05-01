package com.base.game.levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.concurrent.ThreadLocalRandom;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Game;
import com.base.game.Handler;

public class WorldMap {
	private Handler handler;
	private boolean active;

	private Animation dungeonMapIcon;

	private enum MapState {
		OPENING, OPEN
	}

	private MapState state;

	private Dungeon currentDungeon;

	public WorldMap(Handler handler) {
		this.handler = handler;
		dungeonMapIcon = new Animation(200, Assets.dungeonMapIcon, 0);
		state = MapState.OPENING;
		currentDungeon = Dungeon.CRAWLY_CAVERN;
	}

	float scaleX = 1250, scaleY = 600, scaleSpeed = 3;
	float xPos = 625, yPos = 300, xDir, yDir;
	float speed = 5, yVarSpeed = -.3f;

	public void update() {
		if (state == MapState.OPENING) {
			scaleX += scaleSpeed * 2.0833;
			xPos += (scaleSpeed * 2.0833) / 2;

			scaleY += scaleSpeed;
			yPos += scaleSpeed / 2;

			partClouds();

			if (scaleY >= 1200)
				state = MapState.OPEN;

		} else if (state == MapState.OPEN) {

			if (yVar + yVarSpeed < -50 || yVar + yVarSpeed > -40)
				yVarSpeed = -yVarSpeed;
			yVar += yVarSpeed;

			xDir = currentDungeon.getWorldMapLocation().x;
			yDir = currentDungeon.getWorldMapLocation().y;
			switch (currentDungeon) {
				case CRAWLY_CAVERN:
					if (handler.getInput().rightPressed)
						currentDungeon = Dungeon.DRAGONBREATH_CAVERN;
					else if (handler.getInput().leftPressed)
						currentDungeon = Dungeon.GALE_ISLE;
					else if (handler.getInput().downPressed)
						currentDungeon = Dungeon.SHOCKWAVE_ABYSS;
					else if (handler.getInput().upPressed)
						currentDungeon = Dungeon.FROSTY_FJORDS;
					break;
				case GALE_ISLE:
					if (handler.getInput().rightPressed)
						currentDungeon = Dungeon.CRAWLY_CAVERN;
					else if (handler.getInput().downPressed)
						currentDungeon = Dungeon.SHOCKWAVE_ABYSS;
					else if (handler.getInput().upPressed)
						currentDungeon = Dungeon.FROSTY_FJORDS;
					break;
				case SHOCKWAVE_ABYSS:
					if (handler.getInput().rightPressed)
						currentDungeon = Dungeon.DRAGONBREATH_CAVERN;
					else if (handler.getInput().leftPressed)
						currentDungeon = Dungeon.GALE_ISLE;
					else if (handler.getInput().upPressed)
						currentDungeon = Dungeon.CRAWLY_CAVERN;
					else if (handler.getInput().downPressed)
						currentDungeon = Dungeon.DARKNIGHT_RIDGE;
					break;
				case DRAGONBREATH_CAVERN:
					if (handler.getInput().leftPressed)
						currentDungeon = Dungeon.CRAWLY_CAVERN;
					else if (handler.getInput().upPressed)
						currentDungeon = Dungeon.FORSAKEN_LAND;
					else if (handler.getInput().rightPressed)
						currentDungeon = Dungeon.PALACE_OF_THE_GODS;
					break;
				case FROSTY_FJORDS:
					if (handler.getInput().leftPressed)
						currentDungeon = Dungeon.GALE_ISLE;
					else if (handler.getInput().rightPressed)
						currentDungeon = Dungeon.FORSAKEN_LAND;
					else if (handler.getInput().downPressed)
						currentDungeon = Dungeon.CRAWLY_CAVERN;
					break;
				case PALACE_OF_THE_GODS:
					if (handler.getInput().leftPressed)
						currentDungeon = Dungeon.CRAWLY_CAVERN;
					else if (handler.getInput().upPressed)
						currentDungeon = Dungeon.FORSAKEN_LAND;
					break;
				case DARKNIGHT_RIDGE:
					if (handler.getInput().leftPressed)
						currentDungeon = Dungeon.GALE_ISLE;
					else if (handler.getInput().upPressed)
						currentDungeon = Dungeon.SHOCKWAVE_ABYSS;
					else if (handler.getInput().rightPressed)
						currentDungeon = Dungeon.DRAGONBREATH_CAVERN;
					break;
				case FORSAKEN_LAND:
					if (handler.getInput().leftPressed)
						currentDungeon = Dungeon.CRAWLY_CAVERN;
					else if (handler.getInput().upPressed)
						currentDungeon = Dungeon.FROSTY_FJORDS;
					else if (handler.getInput().downPressed)
						currentDungeon = Dungeon.DRAGONBREATH_CAVERN;
					else if (handler.getInput().rightPressed)
						currentDungeon = Dungeon.PALACE_OF_THE_GODS;
					break;
			}

			if (Math.abs(xPos) + speed < Math.abs(xDir) || Math.abs(xPos) - speed > Math.abs(xDir))
				xPos += (xDir - xPos) / (Math.abs(xPos - xDir) + Math.abs(yPos - yDir)) * speed;
			if (Math.abs(yPos) + speed < Math.abs(yDir) || Math.abs(yPos) - speed > Math.abs(yDir))
				yPos += (yDir - yPos) / (Math.abs(xPos - xDir) + Math.abs(yPos - yDir)) * speed;

			if (handler.getInput().a) {
				handler.getGame().getGameState().getLevelManager().setCurrentDungeon(currentDungeon);
				handler.getGame().getPlayer().setCurrentDungeon(currentDungeon);
				handler.getGame().getPlayer().setCameraActive(false);
				handler.getGame().getPlayer().setState("IDLE");
				handler.getCamera().setxOffset(510);
				handler.getCamera().setyOffset(2530);
				handler.getGame().getPlayer().setX(0);
				handler.getGame().getPlayer().setY(0);
				handler.getGame().getGameState().getLevelManager().getBaseCamp().setActiveBoat(true);
				reset();
			}
			if (handler.getInput().d && !permSelector) {
				handler.getGame().getPlayer().setForceMove("UP", "UP");
				reset();
			}

			dungeonMapIcon.update();
		}
	}

	float[] cloudPosX = { 0, 50, 100, 150, 200, 250, 0, 50, 100, 150, 200, 250, 0, 50, 100, 150, 200, 250 };
	float[] cloudPosY = { 0, 50, 100, 150, 200, 250, 50, 100, 150, 200, 250, 0, 100, 150, 200, 250, 0, 50 };
	float cloudSpeed = 3.5f;

	private void partClouds() {
		for (int i = 0; i < cloudPosX.length; i++) {
			cloudPosX[i] += (i % 2 == 0 ? -1 : 1) * (cloudSpeed + ThreadLocalRandom.current().nextInt(2));
		}
	}

	private void reset() {
		handler.getGame().getGameState().getLevelManager().getBaseCamp().setState("MAINAREA");
		handler.getGame().getPlayer().setPaused(false);
		permSelector = false;
		active = false;
		state = MapState.OPENING;
		scaleX = 1250;
		scaleY = 600;
		xPos = 625;
		yPos = 300;
	}

	String text;
	float yVar = -45;

	public void render(Graphics g) {
		g.drawImage(Assets.worldMap, (int) -xPos + handler.getWidth() / 2, (int) -yPos + handler.getHeight() / 2,
				(int) scaleX, (int) scaleY, null);

		if (state == MapState.OPENING) {
			for (int i = 0; i < cloudPosX.length; i++) {
				g.drawImage(Assets.mapCloud, (int) cloudPosX[i], (int) cloudPosY[i], null);
			}
		}
		if (state == MapState.OPEN) {
			for (Dungeon d : Dungeon.values()) {
				g.drawImage(Assets.dungeonMapIcon[0], (int) (d.getWorldMapLocation().x - xPos + handler.getWidth() / 2),
						(int) (d.getWorldMapLocation().y - yPos + handler.getHeight() / 2), null);
				if (handler.getBaseCamp().getDungeonsCleared() < 8)
					g.drawImage(Assets.bossIcon, (int) (d.getWorldMapLocation().x - xPos - 8 + handler.getWidth() / 2),
							(int) (d.getWorldMapLocation().y - yPos + yVar + handler.getHeight() / 2), null);
				for (Quest q : handler.getGame().getGameState().getLevelManager().getiInterface().getMyQuests())
					if (q.getLocation().equals(d))
						g.drawImage(Assets.scrollTaken,
								(int) (d.getWorldMapLocation().x - xPos - 8 + handler.getWidth() / 2),
								(int) (d.getWorldMapLocation().y - yPos + yVar + handler.getHeight() / 2), null);
			}

			g.drawImage(dungeonMapIcon.getCurrentFrame(), (int) (xDir - xPos + handler.getWidth() / 2),
					(int) (yDir - yPos + handler.getHeight() / 2), null);

			text = currentDungeon.toString();
			handler.getGame();
			g.setFont(new Font(Game.font, Font.BOLD, 30));
			g.setColor(Color.BLACK);
			g.drawString(text, (handler.getWidth() - g.getFontMetrics().stringWidth(text)) / 2, 100);
			g.setColor(Color.WHITE);
			g.drawString(text, (handler.getWidth() - g.getFontMetrics().stringWidth(text)) / 2 - 2, 98);
		}
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getSelector() {
		return 0;
	}

	boolean permSelector;

	public void setPermSelector(int selector) {
		permSelector = true;
	}

}
