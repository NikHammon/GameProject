package com.base.game.levels;

import com.base.game.Assets;
import com.base.game.ParallaxLayer;
import com.base.game.entity.Entity;
import com.base.game.tiles.CollisionMap;
import com.base.game.tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public enum Dungeon {
    CRAWLY_CAVERN(2, new Point(1090, 610), "D1Theme", Assets.elements[1], Assets.DungeonTileSets[0],
            new String[]{"SPIDER", "BAT", "BEETLE", "MILI"}, "D1Boss.txt"),
    GALE_ISLE(1, new Point(630, 540),"D1Theme", Assets.elements[2], Assets.DungeonTileSets[1],
            new String[]{"SLIME", "GREMLIN"}, "D1Boss.txt"),
    SHOCKWAVE_ABYSS(1, new Point(910, 770),"D1Theme", Assets.elements[3], Assets.DungeonTileSets[2],
            new String[]{"STARFISH", "BAT"}, "D1Boss.txt"),
    DRAGONBREATH_CAVERN(1, new Point(1470, 920),"D1Theme", Assets.elements[4], Assets.DungeonTileSets[3],
            new String[]{"SPIDER", "BAT"}, "D1Boss.txt"),
    FROSTY_FJORDS(1, new Point(1190, 270),"D1Theme", Assets.elements[5], Assets.DungeonTileSets[4],
            new String[]{"SPIDER", "BAT"}, "D1Boss.txt"),
    PALACE_OF_THE_GODS(1, new Point(1870, 680),"D1Theme", Assets.elements[6], Assets.DungeonTileSets[5],
            new String[]{"SPIDER", "BAT"}, "D1Boss.txt"),
    DARKNIGHT_RIDGE(1, new Point(880, 980),"D1Theme", Assets.elements[7], Assets.DungeonTileSets[6],
            new String[]{"SPIDER", "BAT"}, "D1Boss.txt"),
    FORSAKEN_LAND(1, new Point(1490, 380),"D1Theme", Assets.elements[8], Assets.DungeonTileSets[7],
            new String[]{"SPIDER", "BAT"}, "D1Boss.txt");

    private final int bossFloor;
    private final Point worldMapLocation;
    private final String theme;
    private final Image symbol;
    private final BufferedImage[] tileSet;
    private final String[] enemies;
    private final String bossRoom;
    private final List<Tile> tiles;

    Dungeon(int bossFloor, Point worldMapLocation, String theme, BufferedImage symbol, BufferedImage[] tileSet, String[] enemies, String bossRoom) {
        this.bossFloor = bossFloor;
        this.worldMapLocation = worldMapLocation;
        this.theme = theme;
        this.symbol = symbol;
        this.tileSet = tileSet;
        this.enemies = enemies;
        this.bossRoom = bossRoom;
        this.tiles = IntStream.range(0, tileSet.length)
                              .mapToObj(i -> new Tile(tileSet[i], new CollisionMap(String.format("%d.txt", i)), i))
                              .collect(toList());
    }

    public int getBossFloor() {
        return bossFloor;
    }
    public Point getWorldMapLocation() { return worldMapLocation; }
    public Image getSymbol() { return symbol; }
    public Tile getTile(int tile) {
        return tiles.get(tile);
    }
    public String getTheme() { return theme; }
}

