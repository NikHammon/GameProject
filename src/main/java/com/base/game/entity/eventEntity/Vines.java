package com.base.game.entity.eventEntity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.entity.Player;
import com.base.game.entity.staticEntity.StaticEntity;
import com.base.game.tiles.Tile;

public class Vines extends EventEntity
{
	private int lyHeight;

	public Vines(Handler handler, float x, float y, int layer) {
		super(handler, x, y, layer, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		setBounds(new Rectangle(18, -20, 30, 92));
		
		eventSpace = getCollisionBounds(0, 0);
		setBounds(new Rectangle(0,0,0,0));
		
		renderOrder = 1;
		this.layer = layer;
		this.lyHeight = 1;
	}

	int tempLayer;
	Player player;

	@Override public void update() {
		player = handler.getLevel().geteManager().getPlayer();
		
		if(!on && player.getState() == "CHASE" && player.getCollisionBounds(0,0).intersects(eventSpace)) {
			tempLayer = player.getLayer();
			if(player.getyMove() > 0)
				player.setState("CLIMBINGDOWN");
			else
				player.setState("CLIMBINGUP");
			
			on = true;
		}
		else if(on && !player.getCollisionBounds(0,0).intersects(eventSpace))
		{
			if(player.getState() == "CLIMBINGDOWN") {
				player.setState("CHASE");
				player.setLayer(tempLayer - lyHeight);
			}
			else if(player.getState() == "CLIMBINGUP") {
				player.setState("CHASE");
				player.setLayer(tempLayer + lyHeight);
			}
			on = false;
			
		}
	}
	

	@Override public void render(Graphics g) {
		g.drawImage(Assets.vines, (int) (x - handler.getCamera().getxOffset()),(int) (y - handler.getCamera().getyOffset()), width, height, null);
	}
}
