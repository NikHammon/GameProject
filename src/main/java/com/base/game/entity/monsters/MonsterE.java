package com.base.game.entity.monsters;

public enum MonsterE {
    BAT(1, 10, 3.5f), GREMLIN(1, 15, 3.5f), SLIME(1, 15, 2f), SPIDER(1, 10, 2.5f);

    private int damage;
    private int health;
    private float speed;

    MonsterE(int damage, int health, float speed) {
        this.damage = damage;
        this.health = health;
        this.speed = speed;
    }
}