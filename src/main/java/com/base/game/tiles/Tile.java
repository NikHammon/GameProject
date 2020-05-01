package com.base.game.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

	private BufferedImage texture;
	private int id;
	private CollisionMap cMap;

	public Tile(BufferedImage texture, CollisionMap cMap, int id) {
		this.texture = texture;
		this.id = id;
		this.cMap = cMap;
	}

	public Tile(BufferedImage texture) {
		this.texture = texture;
	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}

	public boolean isSolid() {
		return cMap.isSolid();
	}

	public boolean isNotSolidGround() {
		return !cMap.isSolidGround();
	}

	public int getID() {
		return id;
	}

	public CollisionMap getcMap() {
		return cMap;
	}
}
