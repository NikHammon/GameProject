package com.base.game.tiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CollisionMap {
	private int[][] targets;

	public CollisionMap(String path) {
		targets = new int[32][32];
		try (Scanner scan = new Scanner(new File(String.format("./res/cMaps/%s", path)))) {
			for (int y = 0; y < 32; y++)
				for (int x = 0; x < 32; x++)
					targets[x][y] = scan.nextInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean isSolid() {
		return Arrays.stream(targets).flatMapToInt(Arrays::stream).anyMatch(x -> x != 0);
	}

	public boolean isSolidGround() {
		return !Arrays.stream(targets).flatMapToInt(Arrays::stream).anyMatch(x -> x == 0);
	}

	public int[][] getTargets() {
		return targets;
	}
}
