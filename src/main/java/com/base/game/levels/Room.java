package com.base.game.levels;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


import com.base.game.Utils;
public class Room {

	
	// these values determine what generations are allowed. different variables for different directions
	protected int up;
	protected int down;
	protected int left;
	protected int right;
	
	protected int[] numValidRooms = {2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,1,/*start special cases*/1,1,1,1};
	// a list of the number of existing templates on file per room type
	
	protected int width = 24;
	protected int height = 24;
	protected int layers = 6;
	private int numEntities = 0;// something nik put in. 
	private boolean startDoorRoom, keyRoom, endDoorRoom, deadEndRoom;
	
	
	protected int[][][] myTiles;// room holds data for its collection of tiles
	
	
	public Room(){//default room has no directional bias.
		up = 0;
		right = 0;
		down = 0;
		left = 0;
		startDoorRoom = false;
		endDoorRoom = false;
	}
	public Room(boolean irrelevant){// constructor to create tiles for boundaries
		up = -1;
		right = -1;
		down = -1;
		left = -1;
		startDoorRoom = false;
		endDoorRoom = false;
	}
	
	//randomly selects a room from a list of options based on room type
	public void selectRoom(Random rng){
		boolean specialCase = false; 
		// indicates whether or not to access alternate file location for special generations
		int myRoom; // to be selected, randomly assigned room

		//checks for special case
		if(startDoorRoom){
			myRoom = select(16,rng);
			specialCase = true;
		}else if(keyRoom){
			myRoom = select(17, rng);
			specialCase = true;
		}else if(endDoorRoom){
			myRoom = select(18, rng);
			specialCase = true;
		}else if(deadEndRoom){
			myRoom = select(19, rng);
			specialCase = true;
		}else{
			myRoom = select(this.getValue(), rng);//choose an integer that represents the room chosen to load
		}
		load(myRoom, this.getValue(), specialCase);
		//uses current value of room to check a corresponding list for number of valid rooms in file.		
	}
	
	public int select(int choice, Random rng){
		if(numValidRooms[choice] != 0){
			return (int)(numValidRooms[choice]*rng.nextDouble());  //return (0) through (max value in list)
		}
		System.out.println("No such text file found.");
		return 0;// 0 means default .txt file
	}
	public void load(int fileName, int roomType, boolean specialCase){
		if(!specialCase){//if normal generation of a room look in the default location under roomMaps.
			try {
				loadLevel(new String("./res/roomMaps/" + roomType + "/" + fileName + ".txt"));
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}else{// special case generation accesses alternate file location
			//only one case can possibly be true
			if(startDoorRoom){
				try {
					System.out.println("loading " + "./res/specialCase/start/" + roomType + "/" + fileName + ".txt");
					
					loadLevel(new String("./res/specialCase/start/" + roomType + "/" + fileName + ".txt"));
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}else if(keyRoom){
				try {
					System.out.println("loading " + "./res/specialCase/key/" + roomType + "/" + fileName + ".txt");

					loadLevel(new String("./res/specialCase/key/" + roomType + "/" + fileName + ".txt"));
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}else if(endDoorRoom){
				try {
					System.out.println("loading " + "./res/specialCase/end/" + roomType + "/" + fileName + ".txt");

					loadLevel(new String("./res/specialCase/end/" + roomType + "/" + fileName + ".txt"));
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}else if(deadEndRoom){
				try {
					System.out.println("loading " + "./res/specialCase/deadEnd/" + roomType + "/" + fileName + ".txt");

					loadLevel(new String("./res/specialCase/deadEnd/" + roomType + "/" + fileName + ".txt"));
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(1);
				}
			}else{
				//??? you messed up and something is wrong.
				System.out.println("File Loading Error: tried to assign a special case where one was not allowed.");
			}
		}
	}
	// needed to make the loadLevel method I grabbed from your code will work.
	String file;
	String[] tokens; 
	public void loadLevel(String path)
	{
		file = loadFileAsString(path);
		tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		layers = Utils.parseInt(tokens[2]);
		numEntities = Utils.parseInt(tokens[3]);
		
		myTiles = new int[width][height][layers];
		
		for(int z = 0; z < layers; z++)
			for(int y = 0; y < height; y++)
				for(int x = 0; x < width; x++)
				{
					myTiles[x][y][z] = Utils.parseInt(tokens[(x + y * width) + (height * width * z) + 4]);
				}
	}
	
	public void writeEntities(FileWriter output, int x, int y)
	{
		int eData = 0;
		int passes = 0;
		for(int i = 0; i < numEntities; i++)
		{
			eData = Utils.parseInt(tokens[width * height * layers + 4 + passes]);
			for(int j = 0; j <= eData; j++)
			{
				try {
					
					if(j == 2)
						output.write(String.valueOf(Utils.parseInt(tokens[width * height * layers + 4 + passes])+x*width) + " ");
					else if(j == 3)
						output.write(String.valueOf(Utils.parseInt(tokens[width * height * layers + 4 + passes])+y*height) + " ");
					else
						output.write(tokens[width * height * layers + 4 + passes] + " ");
					passes++;
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				output.write("\r\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String loadFileAsString(String path)
	{
		StringBuilder builder = new StringBuilder();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null)
				builder.append(line + "\n");
			
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return builder.toString();
	}
	
	public int[][] loadLevel(File input){
		return null;
	}
	
	public void setUp(int newUp){
		up = newUp;
	}
	public int getUp(){
		return up;
	}
	public void setRight(int newRight){
		right = newRight;
	}
	public int getRight(){
		return right;
	}
	public void setDown(int newDown){
		down = newDown;
	}
	public int getDown(){
		return down;
	}
	public void setLeft(int newLeft){
		left = newLeft;
	}
	public int getLeft(){
		return left;
	}
	public int getValue(){
		if(up < 0 && right > 0 && down > 0 && left < 0){
			return 0;
		}
		if(up < 0 && right > 0 && down > 0 && left > 0){
			return 1;
		}
		if(up < 0 && right < 0 && down > 0 && left > 0){
			return 2;
		}
		if(up > 0 && right > 0 && down > 0 && left < 0){
			return 3;
		}
		if(up > 0 && right > 0 && down > 0 && left > 0){
			return 4;
		}
		if(up > 0 && right < 0 && down > 0 && left > 0){
			return 5;
		}
		if(up > 0 && right > 0 && down < 0 && left < 0){
			return 6;
		}
		if(up > 0 && right > 0 && down < 0 && left > 0){
			return 7;
		}
		if(up > 0 && right < 0 && down < 0 && left > 0){
			return 8;
		}
		if(up > 0 && right < 0 && down < 0 && left < 0){
			return 9;
		}
		if(up < 0 && right > 0 && down < 0 && left < 0){
			return 10;
		}
		if(up < 0 && right > 0 && down < 0 && left > 0){
			return 11;
		}
		if(up < 0 && right < 0 && down < 0 && left > 0){
			return 12;
		}
		if(up < 0 && right < 0 && down > 0 && left < 0){
			return 13;
		}
		if(up > 0 && right < 0 && down > 0 && left < 0){
			return 14;
		}
		if(up == 0 && right == 0 && down == 0 && left == 0){
			return 15;
		}
		if(up < 0 && right < 0 && down < 0 && left < 0){
			return 0;
		}
		
		return 0;// else return a value unrecognized. Usually a partially generated segment.
	}
	
	public void generateRoom(long seed, Room target, int upVal, int rightVal, int downVal, int leftVal){
		Random rng = new Random(seed);
		if(upVal == 0){
			target.setUp((int)((rng.nextDouble()*200)-100));
		}else{
			up = upVal;
		}
		if(rightVal == 0){
			target.setRight((int)((rng.nextDouble()*200)-100));
		}else{
			right = rightVal;
		}
		if(downVal == 0){
			target.setDown((int)((rng.nextDouble()*200)-100));
		}else{
			down = downVal;
		}
		if(upVal == 0){
			target.setLeft((int)((rng.nextDouble()*200)-100));
		}else{
			left = leftVal;
		}
	}
	
	public boolean isStartDoorRoom() {
		return startDoorRoom;
	}
	public void setStartDoorRoom(boolean startDoorRoom) {
		this.startDoorRoom = startDoorRoom;
	}
	public boolean isEndDoorRoom() {
		return endDoorRoom;
	}
	public void setEndDoorRoom(boolean endDoorRoom) {
		this.endDoorRoom = endDoorRoom;
	}
	public int[][][] getMyTiles() {return myTiles;}
	public void setMyTiles(int[][][] myTiles) {this.myTiles = myTiles;}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getLayers() {
		return layers;
	}
	public void setLayers(int layers) {
		this.layers = layers;
	}
	public int getNumEntities() {
		return numEntities;
	}
	public void setNumEntities(int numEntities) {
		this.numEntities = numEntities;
	}
	public boolean isDeadEndRoom() {
		return deadEndRoom;
	}
	public void setDeadEndRoom(boolean deadEndRoom) {
		this.deadEndRoom = deadEndRoom;
	}
	public boolean isKeyRoom() {
		return keyRoom;
	}
	public void setKeyRoom(boolean keyRoom) {
		this.keyRoom = keyRoom;
	}
}
