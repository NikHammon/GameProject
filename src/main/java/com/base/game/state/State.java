package com.base.game.state;

import java.awt.Graphics;

import com.base.game.Handler;

public abstract class State {
	protected Handler handler;
	protected Effects effects;

	public State(Handler handler) {
		this.handler = handler;
		effects = new Effects(handler);
	}

	public abstract void update();

	public abstract void render(Graphics g);

	public Effects getEffects() {
		return effects;
	}

	public void setEffects(Effects effects) {
		this.effects = effects;
	}
}
