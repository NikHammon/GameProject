package com.base.game.levels;

import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.ParallaxLayer;
import com.base.game.entity.Emitter;
import com.base.game.entity.EntityManager;
import com.base.game.entity.eventEntity.DungeonDoor;
import com.base.game.entity.eventEntity.Vines;
import com.base.game.entity.monsters.Bat;
import com.base.game.entity.monsters.Spider;
import com.base.game.entity.monsters.Starfish;
import com.base.game.entity.staticEntity.Boulder;
import com.base.game.entity.staticEntity.Crate;
import com.base.game.entity.staticEntity.StaticEntity1;
import com.base.game.event.D1Event;
import com.base.game.event.D3Event;
import com.base.game.tiles.CollisionMap;
import com.base.game.tiles.Tile;

public class Dgn3 extends Dungeon
{
	public Dgn3(Handler handler, LevelGenerator levelGenerator, ParallaxLayer pLayer, String name) 
	{
		super(handler, levelGenerator, pLayer, name);
		theme = "D1Theme";
		bossRoom = "D1Boss.txt";
		bossEvent = new D3Event(handler);
		bossFloorNum = 2;
		dgnNum = 3;
	}

	@Override
	public void addEntity(EntityManager eManager, int eNum, int x, int y, int l) 
	{
		super.addEntity(eManager, eNum, x, y, l);
		switch(eNum)
		{
		case 1:	
			if(rand.nextInt(2) == 1)
				eManager.addEntity(new Emitter(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l, "STARFISH", rand.nextInt(2)));
			else 
				eManager.addEntity(new Emitter(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l, "BAT", rand.nextInt(2)));
		break;
		case 2:
			if(rand.nextInt(2) == 1)
				eManager.addEntity(new Emitter(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l, "CRATE", rand.nextInt(2)));
			else 
				eManager.addEntity(new Emitter(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l, "BOULDER", rand.nextInt(2)));
		break;
		case 3:	
			eManager.addEntity(new StaticEntity1(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l));
		break;
		case 9:	
			eManager.addEntity(new Vines(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l));
		break;
		}

	}

	public void addTiles()
	{
		for(int i = 0; i < Assets.D3Tileset.length - 4; i++)
		{
			tiles[i] = new Tile(Assets.D3Tileset[i], new CollisionMap(Integer.toString(i) + ".txt"), i);
		}
		
		tiles[21] = new Tile(Assets.black, new CollisionMap("21.txt"), 21);
		tiles[22] = new Tile(Assets.black, new CollisionMap("22.txt"), 22);
		tiles[23] = new Tile(Assets.black, new CollisionMap("23.txt"), 23);
		tiles[24] = new Tile(Assets.black, new CollisionMap("24.txt"), 24);
		tiles[25] = new Tile(Assets.black, new CollisionMap("25.txt"), 25);
		tiles[26] = new Tile(Assets.D3Tileset[20], new CollisionMap("11.txt"), 26);
		tiles[27] = new Tile(Assets.D3Tileset[21], new CollisionMap("11.txt"), 27);
		tiles[28] = new Tile(Assets.D3Tileset[22], new CollisionMap("11.txt"), 28);	
		tiles[29] = new Tile(Assets.D3Tileset[23], new CollisionMap("7.txt"), 29);
		
	}
	
	@Override
	public Tile getTile(int tileNum) {
		
		return tiles[tileNum];
	}

}
