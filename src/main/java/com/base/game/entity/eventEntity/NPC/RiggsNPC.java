package com.base.game.entity.eventEntity.NPC;

import java.awt.Rectangle;

import com.base.game.Animation;
import com.base.game.Assets;
import com.base.game.Handler;

public class RiggsNPC extends NPC {
	public Animation upLft, upRgt, dwnLft, dwnRgt;

	public RiggsNPC(Handler handler, float x, float y, int layer) {
		super(handler, x, y, layer, 100, 100);
		setBounds(new Rectangle(20, 40, 25, 30));

		scriptNum = 207;

		upLft = new Animation(150, Assets.riggsUpLft, 0);
		dwnRgt = new Animation(150, Assets.riggsDwnRgt, 0);
		upRgt = new Animation(150, Assets.riggsUpRgt, 0);
		dwnLft = new Animation(150, Assets.riggsDwnLft, 0);

		currentAnimation = dwnRgt;
	}

	public void setCurrentAnimation(Animation currentAnimation) {
		this.currentAnimation = currentAnimation;

	}

	public void setCurrentAnimation() {
		if (xMove < 0 && yMove > 0)
			currentAnimation = dwnLft;
		else if (xMove > 0 && yMove > 0)
			currentAnimation = dwnRgt;
		else if (xMove < 0 && yMove < 0)
			currentAnimation = upLft;
		else if (xMove > 0 && yMove < 0)
			currentAnimation = upRgt;

	}
}
