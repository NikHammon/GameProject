package com.base.game.entity.attacks;

import com.base.game.Animation;
import com.base.game.Handler;
import com.base.game.entity.Entity;

import com.base.game.tiles.CollisionMap;
import com.base.game.tiles.Tile;

public abstract class Projectile extends Attack {
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_PROJECTILE_WIDTH = 64, DEFAULT_PROJECTILE_HEIGHT = 64;

	protected float speed;
	protected float xMove, yMove;
	protected float xDir, yDir;

	protected Animation destroy;

	boolean doesNotCollideWithEntity;

	public Projectile(Handler handler, Entity user, float x, float y, int layer, int width, int height, int direction) {
		super(handler, user, x, y, layer, width, height);

		speed = DEFAULT_SPEED;
		this.direction = direction;
		setCanBeKnkBack(false);
		xMove = 0;
		yMove = 0;
		setDirectionOffset();
	}

	public Projectile(Handler handler, Entity user, float x, float y, int layer, int width, int height, float xDir,
			float yDir) {
		super(handler, user, x, y, layer, width, height);

		speed = DEFAULT_SPEED;
		this.xDir = xDir / (Math.abs(xDir) + Math.abs(yDir));
		this.yDir = yDir / (Math.abs(xDir) + Math.abs(yDir));
		direction = -1;
		setCanBeKnkBack(false);
		xMove = 0;
		yMove = 0;
		setDirectionOffset();
	}

	public void update() {
		if (destroy != null && destroy.isComplete()) {
			handler.getGame().geteManager().getEntities().remove(this);
		}

		currentAnimation.update();
		move();
	}

	public void move() {
		xMove = 0;
		yMove = 0;

		if (direction == -1) {
			xMove = xDir * speed;
			yMove = yDir * speed;
		} else if (direction == 0)
			yMove = -speed;
		else if (direction == 1) {
			xMove = (float) (speed / Math.sqrt(2));
			yMove = (float) (-speed / Math.sqrt(2));
		} else if (direction == 2)
			xMove = speed;
		else if (direction == 3) {
			xMove = (float) (speed / Math.sqrt(2));
			yMove = (float) (speed / Math.sqrt(2));
		} else if (direction == 4)
			yMove = speed;
		else if (direction == 5) {
			xMove = (float) (-speed / Math.sqrt(2));
			yMove = (float) (speed / Math.sqrt(2));
		} else if (direction == 6)
			xMove = -speed;
		else if (direction == 7) {
			xMove = (float) (-speed / Math.sqrt(2));
			yMove = (float) (-speed / Math.sqrt(2));
		}

		if (doesNotCollideWithEntity || !getCollidedWith(xMove, 0f).isPresent()
				|| getCollidedWith(xMove, 0f).get() == user || getCollidedWith(xMove, 0f).get() instanceof Attack
						&& ((Attack) getCollidedWith(xMove, 0f).get()).getUser() == user)
			moveX();
		else
			effect(getCollidedWith(xMove, 0f).orElse(null));

		if (doesNotCollideWithEntity || !getCollidedWith(0f, yMove).isPresent()
				|| getCollidedWith(0f, yMove).get() == user || getCollidedWith(0f, yMove).get() instanceof Attack
						&& ((Attack) getCollidedWith(0f, yMove).get()).getUser() == user)
			moveY();
		else
			effect(getCollidedWith(0f, yMove).orElse(null));
	}

	public abstract void effect(Entity e);

	public void moveX() {
		oldPosX = x;
		if (xMove > 0) {
			float tx = (x + xMove + bounds.x + bounds.width);

			if (!collisionWithTile(tx, (y + bounds.y), tx, (y + bounds.y + bounds.height))) {
				x += xMove;
			} else
				destroy();

		} else if (xMove < 0) {
			float tx = (x + xMove + bounds.x);

			if (!collisionWithTile(tx, (y + bounds.y), tx, (y + bounds.y + bounds.height))) {
				x += xMove;
			} else
				destroy();

		}
	}

	public void moveY() {
		oldPosY = y;
		if (yMove < 0) {
			float ty = (y + yMove + bounds.y);

			if (!collisionWithTile((x + bounds.x), ty, (x + bounds.x + bounds.width), ty))
				y += yMove;
			else
				destroy();

		} else if (yMove > 0) {
			float ty = (y + yMove + bounds.y + bounds.height);

			if (!collisionWithTile((x + bounds.x), ty, (x + bounds.x + bounds.width), ty))
				y += yMove;
			else
				destroy();

		}
	}

	public void destroy() {

		if (destroy == null) {
			handler.getGame().geteManager().getEntities().remove(this);
		} else
			currentAnimation = destroy;

	}

	public void setDirectionOffset() {
		if (direction == 0)
			y -= 32;
		if (direction == 1) {
			x += 32;
			y -= 32;
		}
		if (direction == 2)
			x += 32;
		if (direction == 3) {
			x += 32;
			y += 32;
		}
		if (direction == 4)
			y += 44;
		if (direction == 5) {
			x -= 36;
			y += 36;
		}
		if (direction == 6)
			x -= 42;
		if (direction == 7) {
			x -= 32;
			y -= 32;
		}
	}

	CollisionMap cMap1, cMap2;
	int tileX1, tileY1, nwX1, nwY1;
	int tileX2, tileY2, nwX2, nwY2;

	public boolean collisionWithTile(float x1, float y1, float x2, float y2) {
		if (handler.getGame().getGameState().getLevelManager().isInDungeon()) {
			tileX1 = (int) (x1 / Tile.TILE_WIDTH);
			tileY1 = (int) (y1 / Tile.TILE_HEIGHT);
			nwX1 = (int) (x1 - tileX1 * Tile.TILE_WIDTH) / 2;
			nwY1 = (int) (y1 - tileY1 * Tile.TILE_HEIGHT) / 2;
			cMap1 = handler.getLevel().getTile(tileX1, tileY1, layer).getcMap();

			tileX2 = (int) (x2 / Tile.TILE_WIDTH);
			tileY2 = (int) (y2 / Tile.TILE_HEIGHT);
			nwX2 = (int) (x2 - tileX2 * Tile.TILE_WIDTH) / 2;
			nwY2 = (int) (y2 - tileY2 * Tile.TILE_HEIGHT) / 2;
			cMap2 = handler.getLevel().getTile(tileX2, tileY2, layer).getcMap();

			if (nwX1 < 0 || nwX2 < 0 || nwY1 < 0 || nwY2 < 0) {
				return true;
			}

			if (cMap1.getTargets()[nwX1][nwY1] == 1 || cMap2.getTargets()[nwX2][nwY2] == 1) {
				return true;
			} else if (cMap1.getTargets()[nwX1][nwY1] == 0 || cMap2.getTargets()[nwX2][nwY2] == 0) {
				return false;// false means passable
			}
		}

		return false;
	}

}
