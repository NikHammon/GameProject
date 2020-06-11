package com.base.game.entity.attacks;

import com.base.game.Animation;
import com.base.game.Assets;

public enum AttackE {
    ELECTROBALL(new Animation(50, Assets.electroBall, 0), 3, 50, 6),
    EXPLOSION(new Animation(150, Assets.explosion, 1), 10, 40, 0),
    FIREBALL(new Animation(100, Assets.fireBall, 0), 10, 40, 10),
    GREENMAGIC(new Animation(100, Assets.greenMagic, 0), 3, 50, 8), ICE(new Animation(150, Assets.ice, 1), 10, 40, 0),
    INK(new Animation(50, Assets.ink, 0), 0, 50, 6), LIGHTNINGSTRIKE(new Animation(150, Assets.lightning, 1), 10, 0, 0),
    LIGHTSLASH(new Animation(50, Assets.lightSlash, 0), 3, 50, 8),
    QUAKE(new Animation(100, Assets.quake, 1), 10, 40, 0), TORNADO(new Animation(50, Assets.tornado, 0), 0, 150, 10);

    private final Animation anim;
    private final int damage;
    private final int knkBack;
    private final int speed;

    AttackE(Animation anim, int damage, int knkBack, int speed) {
        this.anim = anim;
        this.damage = damage;
        this.knkBack = knkBack;
        this.speed = speed;
    }
}