package com.base.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import com.base.game.tiles.CollisionMap;

public class CollisionMapTest {

    @Test
    public void testCollisionMap() {
        for (int cMapNum = 0; cMapNum <= 29; ++cMapNum) {
            int[][] targets = new int[32][32];
            try (Scanner scan = new Scanner(new File(String.format("./res/cMaps/%d.txt", cMapNum)))) {
                for (int y = 0; y < 32; y++)
                    for (int x = 0; x < 32; x++)
                        targets[x][y] = scan.nextInt();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            CollisionMap cMap = new CollisionMap(String.format("%d.txt", cMapNum));
            assertEquals(cMap.getTargets().length, targets.length);
            for (int i = 0; i < targets.length; ++i)
                assertTrue(Arrays.equals(targets[i], cMap.getTargets()[i]));
        }
    }

    @Test
    public void testIsSolid() {
        CollisionMap cMap = new CollisionMap("3.txt");
        assertTrue(cMap.isSolid());
        CollisionMap cMap2 = new CollisionMap("7.txt");
        assertFalse(cMap2.isSolid());
    }

    @Test
    public void testIsSolidGround() {
        CollisionMap cMap = new CollisionMap("3.txt");
        assertFalse(cMap.isSolidGround());
        CollisionMap cMap2 = new CollisionMap("7.txt");
        assertFalse(cMap2.isSolidGround());
    }
}