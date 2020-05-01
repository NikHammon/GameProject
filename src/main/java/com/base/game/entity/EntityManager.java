package com.base.game.entity;

import java.awt.Graphics;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ThreadLocalRandom;

import com.base.game.Handler;
import com.base.game.entity.eventEntity.DungeonDoor;
import com.base.game.entity.eventEntity.Vines;
import com.base.game.entity.monsters.Millipede;
import com.base.game.tiles.Tile;

public class EntityManager {
	private Handler handler;
	private Player player;
	public List<Entity> entities;

	public EntityManager(Handler handler, Player player) {
		this.setHandler(handler);
		this.setPlayer(player);
		entities = new CopyOnWriteArrayList<>();
		entities.add(player);
	}

	public void removeAllExcept(Entity entityToKeep) {
		entities.removeIf(e -> e != entityToKeep);
	}

	public void update() {
		for (Entity e : entities)
			if (!e.doNotUpdate)
				e.update();

		Collections.sort(entities);
	}

	public void render(Entity e, Graphics g) {
		if (!e.isDoNotRender())
			e.render(g);
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public void addEntity(int eNum, int x, int y, int l) {
		switch (eNum) {
			case 0:
				entities.add(new DungeonDoor(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l));
				break;
			case 1:
				if (ThreadLocalRandom.current().nextInt(2) == 1)
					entities.add(new Emitter(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l, "SPIDER",
							ThreadLocalRandom.current().nextInt(2)));
				else
					entities.add(new Emitter(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l, "BAT",
							ThreadLocalRandom.current().nextInt(2)));
				break;
			case 2:
				entities.add(new Emitter(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l, "BEETLE",
						ThreadLocalRandom.current().nextInt(2)));
				break;
			case 3:
				entities.add(new Millipede(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l,
						ThreadLocalRandom.current().nextInt(9) + 5, ThreadLocalRandom.current().nextInt(2), ""));
				break;
			case 4:
				break;
			case 5:
				if (ThreadLocalRandom.current().nextInt(2) == 1)
					entities.add(new Emitter(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l, "CRATE",
							ThreadLocalRandom.current().nextInt(2)));
				else
					entities.add(new Emitter(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l, "BOULDER",
							ThreadLocalRandom.current().nextInt(2)));
				break;
			case 9:
				entities.add(new Vines(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l));
				break;
		}
	}

	public void removeEntity(Entity e) {
		entities.remove(e);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}

}
