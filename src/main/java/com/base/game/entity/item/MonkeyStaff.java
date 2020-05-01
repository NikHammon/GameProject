package com.base.game.entity.item;

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
import com.base.game.entity.monsters.Monster;
import com.base.game.entity.staticEntity.StaticEntity;

public class MonkeyStaff extends MainItem {
	// animations...
	private Animation staffAtkUp, staffAtkDwn, staffAtkRgt, staffAtkLft;
	private Animation jumpUp, jumpDwn, jumpLft, jumpRgt;

	public MonkeyStaff(Handler handler) {
		super(handler);
		ID = 3;
		damage = 1;
		knockBack = 30;
		speed = 8;

		staffAtkUp = new Animation(100, Assets.staffAtkUp, 1);
		staffAtkDwn = new Animation(100, Assets.staffAtkDwn, 1);
		staffAtkRgt = new Animation(100, Assets.staffAtkRgt, 1);
		staffAtkLft = new Animation(100, Assets.staffAtkLft, 1);

		jumpUp = new Animation(100, Assets.staffAtkUp, 0);
		jumpDwn = new Animation(100, Assets.staffAtkDwn, 0);
		jumpRgt = new Animation(100, Assets.staffAtkRgt, 0);
		jumpLft = new Animation(100, Assets.staffAtkLft, 0);

		summaryL1 = "THIS STAFF HAS THE MAGICAL ABILITY TO TURN ITS USER INTO A MONKEY.";
	}

	@Override
	public void action() {
		player = handler.getGame().geteManager().getPlayer();

		layer = player.getLayer();
		bounds = player.getCollisionBounds(0, 0);
		if ((int) player.getDirection() / 2 == 0) {
			player.setCurrentAnimation(staffAtkUp);
			bounds.x -= 25;
			bounds.y -= 30;
			bounds.height = 30;
			bounds.width = 75;
		} else if ((int) player.getDirection() / 2 == 1) {
			player.setCurrentAnimation(staffAtkRgt);
			bounds.x += 20;
			bounds.y -= 40;
			bounds.height = 80;
			bounds.width = 30;
		} else if ((int) player.getDirection() / 2 == 2) {
			player.setCurrentAnimation(staffAtkDwn);
			bounds.x -= 25;
			bounds.y += 10;
			bounds.height = 30;
			bounds.width = 75;
		} else {
			player.setCurrentAnimation(staffAtkLft);
			bounds.x -= 20;
			bounds.y -= 40;
			bounds.height = 80;
			bounds.width = 30;
		}

		if (player.getCurrentAnimation().isComplete()) {
			player.getCurrentAnimation().reset();
			player.setState("CHASE");
			setBounds(new Rectangle(0, 0, 0, 0));
		}

		if (player.getCurrentAnimation().getCurrentIndex() >= 2)
			damageEnemy();
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
				if (c.getrVal() < 190)
					c.takeDamage(damage);
				c.setrVal(200);
				if (c.getHealth() > 0 && c.canBeKnkBack()) {
					Utils.playSound("punch");
					c.setKnockBack((float) (bounds.x + bounds.getWidth()), (float) (bounds.y - bounds.height),
							knockBack);
				}
			}
		}
	}

	@Override
	public BufferedImage getIcon() {
		return Assets.itemIcons[3];
	}

	@Override
	public void reset() {

	}

	@Override
	public void update() {

	}

	@Override
	public void render(Graphics g) {

	}
}
