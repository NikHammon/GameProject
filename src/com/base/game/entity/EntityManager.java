package com.base.game.entity;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import com.base.game.Handler;

public class EntityManager 
{
	private Handler handler;
	private Player player;
	public List<Entity> entities;
	private Comparator<Entity> Sorter = new Comparator<Entity>(){
		@Override
		public int compare(Entity a, Entity b)
		{
			if(a.renderOrder < b.renderOrder)
				return -1;
			else if(b.renderOrder < a.renderOrder)
				return 1;
			
			else if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
				return -1;
			else
				return 1;
		}
	};
	
	public EntityManager(Handler handler, Player player)
	{
		this.setHandler(handler);
		this.setPlayer(player);
		entities = new CopyOnWriteArrayList<Entity>();
		entities.add(player);
	}
	
	public void update()
	{
		for(int i = 0; i < entities.size(); i++)
		{
			if(!entities.get(i).doNotUpdate)
			{
				entities.get(i).update();
			}
//			//lot of Creature specific references, therefore surround this with a test of Creature.
//			else if(entities.get(i) instanceof Creature){
//				
//				//STUN HANDLING  (must make stunned entity have a doNotUpdate value of false)
//				
//				//first, lower stun threshold but let Creature move
//				if (((Creature) entities.get(i)).getStunThreshold() > 0)
//				{
//					//decrements the creature's stun threshold (temporary stun immunity) by 1
//					((Creature) entities.get(i)).setStunThreshold((((Creature) entities.get(i)).getStunThreshold())-1);
//					entities.get(i).update();
//				//then, run stun time and don't let Creature move
//				}else if(((Creature) entities.get(i)).getStunDuration() > 0)
//				{
//					//decrements the creature's stun time by 1
//					((Creature) entities.get(i)).setStunDuration((((Creature) entities.get(i)).getStunDuration())-1);
//				}
//				//and, finally, free it from hitstun hell
//				else
//				{
//					entities.get(i).setDoNotUpdate(false);
//				}
//			}
		}
		entities.sort(Sorter);
	}

	public void render(Entity e, Graphics g)
	{	
		if(!e.isDoNotRender())
			e.render(g);	
	}
	
	public void addEntity(Entity e)
	{
		entities.add(e);
	}
	
	Random rand = new Random();
	public void addEntity(int eNum, int x, int y, int l)
	{

		switch(eNum)
		{
//		case 4:	
//			entities.add(new Girl(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l));
//			break;
//		case 7:	
//			entities.add(new SpecialDoor(handler, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT, l));//only one case, allows entrance to any dungeon
//			break;
		}
		
	}
	
	public void removeEntity(Entity e)
	{
		entities.remove(e);
	}
	
	
	
	public Handler getHandler() {return handler;}
	public void setHandler(Handler handler) {this.handler = handler;}
	public Player getPlayer() {return player;}
	public void setPlayer(Player player) {this.player = player;}
	public List<Entity> getEntities() {return entities;}
	public void setEntities(ArrayList<Entity> entities) {this.entities = entities;}
			
}
