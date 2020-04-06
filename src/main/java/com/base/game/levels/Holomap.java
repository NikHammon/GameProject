package com.base.game.levels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.state.Effects;

public class Holomap {
	private Handler handler;
	private Animation playerDot;
	
	public Holomap(Handler handler) {
		this.handler = handler;
		playerDot = new Animation(200, Assets.playerDot, 0);
	}
	
	public void update() {
		playerDot.update();
	}
	
	public void render(Graphics g, LevelGenerator levelGenerator) {
		for(int y = 0; y < 4; y++) {
			for(int x = 0; x < 4; x++) {
				if(levelGenerator.getMyRooms()[x + 1][y + 1].getValue() != 15)
					g.drawImage(Assets.holoMap[levelGenerator.getMyRooms()[x + 1][y + 1].getValue()], (handler.getWidth() - 220) + x * 50, (handler.getHeight() - 240) + y * 50, null);
			}
		}
		
		g.drawImage(playerDot.getCurrentFrame(), (int)(handler.getGame().getPlayer().getX()/30.72 + (handler.getWidth() - 220)), (int)(handler.getGame().getPlayer().getY()/30.72 + (handler.getHeight() - 240)), null);

		g.setFont(new Font(handler.getGame().font, Font.BOLD, 13));
		Effects.drawStringWithShadow(g, String.format("%s F%d", handler.getGame().getPlayer().getCurrentDungeon().toString(), handler.getGame().getPlayer().getCurrentFloor()), Color.WHITE, (handler.getWidth() - 205) - 2, (handler.getHeight() - 30) - 2);
	}
}
