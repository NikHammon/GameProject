package com.base.game.entity;

import java.awt.Graphics;

import com.base.game.Handler;
import com.base.game.entity.monsters.Bat;
import com.base.game.entity.monsters.Beetle;
import com.base.game.entity.monsters.Bird;
import com.base.game.entity.monsters.Gremlin;
import com.base.game.entity.monsters.SeaMine;
import com.base.game.entity.monsters.Shark;
import com.base.game.entity.monsters.Slime;
import com.base.game.entity.monsters.Spider;
import com.base.game.entity.monsters.Squid;
import com.base.game.entity.monsters.Starfish;
import com.base.game.entity.staticEntity.Boulder;
import com.base.game.entity.staticEntity.Crate;

public class Emitter extends Entity
{
	String type;
	private Entity myEntity;
	private int respawnTime;
	private int level;
	
	public Emitter(Handler handler, float x, float y, int layer, String type, int level)
	{
		super(handler, x, y, layer, 0, 0);
		this.type = type;
		this.level = level;
		
		respawnTime = 50000000;
		fitEntity();
		state = "";
	}

	public void fitEntity()
	{
		switch(type)
		{
		case "SPIDER":
			myEntity = new Spider(handler, x, y, layer, level, "");
		break;	
		case "BAT":
			myEntity = new Bat(handler, x, y, layer, level, "");
		break;
		case "BEETLE":
			myEntity = new Beetle(handler, x, y, layer, level, "");
		break;
		case "SLIME":
			myEntity = new Slime(handler, x, y, layer, level);
		break;
		case "GREMLIN":
			myEntity = new Gremlin(handler, x, y, layer, level);
		break;
		case "BIRD":
			myEntity = new Bird(handler, x, y, layer, level);
		break;
		case "STARFISH":
			myEntity = new Starfish(handler, x, y, layer, level);
		break;
		case "SHARK":
			myEntity = new Shark(handler, x, y, layer, level);
		break;
		case "SQUID":
			myEntity = new Squid(handler, x, y, layer, level);
		break;
		case "SEAMINE":
			myEntity = new SeaMine(handler, x, y, layer, level);
		break;
		case "CRATE":
			myEntity = new Crate(handler, x, y, layer, level);
		break;
		case "BOULDER":
			myEntity = new Boulder(handler, x, y, layer, level);
		break;
		}
		
	}
	
	@Override
	public void update() 
	{
		if(state == "")
		{
			handler.getLevel().geteManager().addEntity(myEntity);
			state = "SPAWNED";
		}
		
		if(state == "SPAWNED")
		{
			state = "DEAD";
			for(Entity e : handler.getLevel().geteManager().entities)
			{
				if(e == myEntity)
					state = "SPAWNED";
			}
		}
		
		if(state == "DEAD")
		{
			timer = 0;
			lastTime = System.currentTimeMillis();
			state = "RESPAWN";
		}
		
		if(state == "RESPAWN")
		{
			timer += System.currentTimeMillis() - lastTime;
			
			if(timer > respawnTime)
			{
				//myEntity.reset(x, y, layer);
				handler.getLevel().geteManager().addEntity(myEntity);
				state = "SPAWNED";
			}
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

}
