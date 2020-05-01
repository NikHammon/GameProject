package com.base.game.entity.item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;
import com.base.game.Utils;
import com.base.game.entity.Creature;
import com.base.game.entity.Entity;
import com.base.game.entity.HitSwitch;
import com.base.game.entity.Player;
import com.base.game.entity.monsters.D5Boss;
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.staticEntity.StaticEntity;

public class Gauntlet extends MainItem {
	// animations...
	private Animation gThrustDownLeft;
	private Animation gThrustDownRight;
	private Animation gThrustUpLeft;
	private Animation gThrustUpRight;

	public Gauntlet(Handler handler) {
		super(handler);
		ID = 0;
		speed = 12;// default 14
		damage = 3;
		knockBack = 50;// no longer affects knkBack speed

		gThrustDownLeft = new Animation(100, Assets.gThrustDownLeft, 1);
		gThrustDownRight = new Animation(100, Assets.gThrustDownRight, 1);
		gThrustUpLeft = new Animation(100, Assets.gThrustUpLeft, 1);
		gThrustUpRight = new Animation(100, Assets.gThrustUpRight, 1);

		summaryL1 = "A GAUNTLET THAT CARRIES THE FORCE OF A GIANT'S FIST.  A SINGLE THRUST IS ";
		summaryL2 = "ENOUGH TO SEND THE USER CAREENING OVER GREAT PRECIPICES.";
	}

	float xSpeed, ySpeed;
	int boundsOffsetX, boundsOffsetY;

	public void action() {
		if (distance == 0)// distance could refer to distance moved by an action. The thrust of the
							// gauntlet in this case.
		{
			Utils.playSound("swoosh");
			player = handler.getGame().geteManager().getPlayer();
			stopped = false;
			player.setxMove(0);
			player.setyMove(0);

			layer = player.getLayer();

			gThrustUpRight.reset();
			gThrustDownRight.reset();
			gThrustDownLeft.reset();
			gThrustUpLeft.reset();

			if (player.getDirection() == 0) {
				player.setCurrentAnimation(gThrustUpRight);
				ySpeed = -speed;
				xSpeed = 0;
				boundsOffsetX = -5;
				boundsOffsetY = -60;
			}
			if (player.getDirection() == 1) {
				player.setCurrentAnimation(gThrustUpRight);
				ySpeed = (float) (-speed / Math.sqrt(2));
				xSpeed = (float) (speed / Math.sqrt(2));
				boundsOffsetX = 30;
				boundsOffsetY = -45;
			}
			if (player.getDirection() == 2) {
				player.setCurrentAnimation(gThrustDownRight);
				ySpeed = 0;
				xSpeed = speed;
				boundsOffsetX = 40;
				boundsOffsetY = -15;
			}
			if (player.getDirection() == 3) {
				player.setCurrentAnimation(gThrustDownRight);
				ySpeed = (float) (speed / Math.sqrt(2));
				xSpeed = (float) (speed / Math.sqrt(2));
				boundsOffsetX = 30;
				boundsOffsetY = 15;
			}
			if (player.getDirection() == 4) {
				player.setCurrentAnimation(gThrustDownLeft);
				ySpeed = speed;
				xSpeed = 0;
				boundsOffsetX = -5;
				boundsOffsetY = 20;
			}
			if (player.getDirection() == 5) {
				player.setCurrentAnimation(gThrustDownLeft);
				ySpeed = (float) (speed / Math.sqrt(2));
				xSpeed = (float) (-speed / Math.sqrt(2));
				boundsOffsetX = -25;
				boundsOffsetY = 15;
			}
			if (player.getDirection() == 6) {
				player.setCurrentAnimation(gThrustUpLeft);
				ySpeed = 0;
				xSpeed = -speed;
				boundsOffsetX = -45;
				boundsOffsetY = -15;
			}
			if (player.getDirection() == 7) {
				player.setCurrentAnimation(gThrustUpLeft);
				ySpeed = (float) (-speed / Math.sqrt(2));
				xSpeed = (float) (-speed / Math.sqrt(2));
				boundsOffsetX = -40;
				boundsOffsetY = -50;
			}
			if (!player.isHoldLastPos()) {
				player.setHoldLastPos(true);
				player.setLastPosX(player.resolveToTile().x);
				player.setLastPosY(player.resolveToTile().y - 20);
				player.setLastLayer(player.getLayer());
			}
		}

		player.setyMove(ySpeed);
		player.setxMove(xSpeed);

		bounds = player.getCollisionBounds(boundsOffsetX, boundsOffsetY);
		bounds.width = 40;
		bounds.height = 40;
		distance += speed;

		if (!stopped)
			player.move();
		else {
			player.setxVel(0);
			player.setyVel(0);
		}
		if (player.getCurrentAnimation() != null)
			player.getCurrentAnimation().update();

		damageEnemy();

		if (distance > 280)// will go 140 pixels before stopping
		{
			distance = 0;

			player.setState("CHASE");
			player.setxMove(xSpeed);
			player.setyMove(ySpeed);

			player.move();

			if (player.getState() != "FALLING") {
				if (player.getxVel() == 0)
					player.setxMove(-xSpeed);
				if (player.getyVel() == 0)
					player.setyMove(-ySpeed);

				player.move();
			}

			player.setHoldLastPos(false);

			setBounds(new Rectangle(0, 0, 0, 0));
		}
	}

	public void damageEnemy() {
		Entity e = getCollidedWith(0, 0).orElse(null);
		if (e != null) {
			if (e instanceof StaticEntity) {
				stopped = true;
				e.setState("HIT");
			} else if (e instanceof HitSwitch) {
				HitSwitch s = ((HitSwitch) e);
				s.setOn(!s.isOn());
				stopped = true;
			} else if (e instanceof Monster) {
				Creature c = ((Creature) e);
				c.takeDamage(damage);
				if (c.getHealth() > 0 && c.canBeKnkBack()) {
					Utils.playSound("punch");
					c.setKnockBack((float) (bounds.x + bounds.width / 2), (float) (bounds.y - bounds.height / 2),
							knockBack);
				}
			}
		}
	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {

	}

	@Override
	public BufferedImage getIcon() {
		return Assets.itemIcons[0];

	}

	@Override
	public void reset() {
		distance = 0;
		setBounds(new Rectangle(0, 0, 0, 0));
	}
}
