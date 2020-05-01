package com.base.game.entity.item;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class Amulet extends MainItem {
	// animations...
	private Animation playerUpShine;
	private Animation playerDownShine;
	private Animation playerRightShine;
	private Animation playerLeftShine;

	private Animation split, join;

	private ArrayList<Particle> particles;

	public Amulet(Handler handler) {
		super(handler);
		ID = 4;
		speed = 5;
		damage = 3;
		knockBack = 30;

		playerUpShine = new Animation(150, Assets.playerUpShine, 1);
		playerDownShine = new Animation(150, Assets.playerDownShine, 1);
		playerRightShine = new Animation(150, Assets.playerRightShine, 1);
		playerLeftShine = new Animation(150, Assets.playerLeftShine, 1);

		split = new Animation(100, Assets.split, 1);
		join = new Animation(100, Assets.join, 1);

		particles = new ArrayList<Particle>();

		state = "ACTIVATING";

		summaryL1 = "AN AMULET THAT ALLOWS ITS USER TO TELEPORT.  DEADLY ICE CRYSTALS ARE DRAWN";
		summaryL2 = "UP IN ITS WAKE THAT REND FOES TO PIECES.";
	}

	private float xMove, yMove;

	@Override
	public void action() {
		player = handler.getGame().getPlayer();
		layer = player.getLayer();

		if (state == "ACTIVATING") {

			if ((int) player.getDirection() / 2 == 0) {
				player.setCurrentAnimation(playerUpShine);
				yMove = -speed;
				xMove = 0;
			} else if ((int) player.getDirection() / 2 == 1) {
				player.setCurrentAnimation(playerRightShine);
				xMove = speed;
				yMove = 0;
			} else if ((int) player.getDirection() / 2 == 2) {
				player.setCurrentAnimation(playerDownShine);
				yMove = speed;
				xMove = 0;
			} else {
				player.setCurrentAnimation(playerLeftShine);
				xMove = -speed;
				yMove = 0;
			}

			if (player.getCurrentAnimation().isComplete()) {
				state = "LAYPATH";

				player.setHoldLastPos(true);
				player.setLastPosX(player.resolveToTile().x);
				player.setLastPosY(player.resolveToTile().y - 20);
				player.setLastLayer(player.getLayer());

				x = player.getCollisionBounds(0, 0).x;
				y = player.getCollisionBounds(0, 0).y;
			}
		} else if (state == "LAYPATH") {
			if (handler.getInput().up) {
				yMove = -speed;
				xMove = 0;
			} else if (handler.getInput().down) {
				yMove = speed;
				xMove = 0;
			} else if (handler.getInput().right) {
				xMove = speed;
				yMove = 0;
			} else if (handler.getInput().left) {
				xMove = -speed;
				yMove = 0;
			}

			x += xMove;
			y += yMove;

			distance += Math.abs(xMove) + Math.abs(yMove);

			if (distance > 20) {
				particles.add(new Particle(handler, x, y, layer));
				distance = 0;
			}

			if (particles.size() > 20) {
				state = "TELEPORTING";
			}
			player.setCameraActive(false);
			handler.getCamera().centerOnEntity(this);
		} else if (state == "TELEPORTING") {

			if (split.isComplete()) {

				for (Particle p : particles)
					p.raiseIce();
				particles.removeAll(particles);
				player.setX(x);
				player.setY(y);
				player.setCurrentAnimation(join);

				if (join.isComplete()) {
					playerDownShine.reset();
					playerUpShine.reset();
					playerRightShine.reset();
					playerLeftShine.reset();

					split.reset();
					join.reset();

					state = "ACTIVATING";
					player.setState("CHASE");
					player.setCameraActive(true);

					player.setxMove(xMove);
					player.setyMove(yMove);

					player.move();

					if (player.getxVel() == 0 && player.getyVel() == 0) {
						player.setX(player.getLastPosX());
						player.setY(player.getLastPosY());

						player.setrVal(200);
						handler.getGame().getPlayer().takeDamage(damage);
					}

					player.setHoldLastPos(false);
				}
			}

			else {
				player.setCurrentAnimation(split);
			}
		}

	}

	@Override
	public BufferedImage getIcon() {
		return Assets.itemIcons[4];
	}

	@Override
	public void reset() {
		particles.removeAll(particles);

		playerDownShine.reset();
		playerUpShine.reset();
		playerRightShine.reset();
		playerLeftShine.reset();

		split.reset();
		join.reset();

		state = "ACTIVATING";
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {
		for (Particle p : particles)
			p.render(g);
	}
}
