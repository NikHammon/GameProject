package com.base.game.levels;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class LevelGenerator {
	//variables to store coordinates of all three special points: Start, End, and Key
	int startX;
	int startY;
	int endX;
	int endY;
	int keyX;
	int keyY;
	
	boolean hasReachedEnd;
	boolean hasReachedKey;
	final double CHANCE_TO_CONNECT = 0.9;//DEFAULT 0.9, might want to change, 4's are super rare rn
	// default room size is 4 by 4 surrounded by map boundaries that prevent pathing outside the 4x4 grid
	public Room[][] myRooms = {{new Room(true), new Room(true), new Room(true), new Room(true), new Room(true), new Room(true)},
						{new Room(true), new Room(),     new Room(),     new Room(),     new Room(),     new Room(true)},
						{new Room(true), new Room(),     new Room(),     new Room(),     new Room(),     new Room(true)},
						{new Room(true), new Room(),     new Room(),     new Room(),     new Room(),     new Room(true)},
						{new Room(true), new Room(),     new Room(),     new Room(),     new Room(),     new Room(true)},
						{new Room(true), new Room(true), new Room(true), new Room(true), new Room(true), new Room(true)}};
	// default java object for random number generation
	Random rng = new Random();

	//lists to track current possibilities for next tile generation. "Active" tiles are not generated tiles that border unconnected connections
	ArrayList<Integer> activeX = new ArrayList<Integer>();
	ArrayList<Integer> activeY = new ArrayList<Integer>();
	// optional constructor that accepts seeds for random number generation
	public LevelGenerator(long seed){
		rng.setSeed(seed);
		}
	public LevelGenerator(){
	//this needs to be blank for reasons
	}
	
	// generates locations of three special points
	public void setElements(){
		hasReachedEnd = false;
		hasReachedKey = false;
		Room[][] myTempRooms = {{new Room(true), new Room(true), new Room(true), new Room(true), new Room(true), new Room(true)},
				{new Room(true), new Room(),     new Room(),     new Room(),     new Room(),     new Room(true)},
				{new Room(true), new Room(),     new Room(),     new Room(),     new Room(),     new Room(true)},
				{new Room(true), new Room(),     new Room(),     new Room(),     new Room(),     new Room(true)},
				{new Room(true), new Room(),     new Room(),     new Room(),     new Room(),     new Room(true)},
				{new Room(true), new Room(true), new Room(true), new Room(true), new Room(true), new Room(true)}};
		myRooms = myTempRooms;
		//to reset myRooms when generating many levels from one object
		boolean[][] openPoints =   {{true,true,true,true},
									{true,true,true,true},
									{true,true,true,true},
									{true,true,true,true}};
		//start start point generation
		System.out.println("Generating Start Point...");
		
		// generates a random number between 0 and 11 inclusive
		int choice = (int)(rng.nextDouble()*12);
		System.out.println("Selecting case " + choice + "...");
		// uses randomly selected number to designate start coordinates from 12 options
		//each option for the start position nullifies future options for spawning such that any new key element room cannot be adjacent to the start room
		switch(choice){
		case 0: startX = 1;
				startY = 1;
				openPoints[0][0] = false;
				openPoints[0][1] = false;
				openPoints[1][0] = false;
				openPoints[1][1] = false;
				break;
		case 1: startX = 2;
				startY = 1;
				openPoints[1][0] = false;
				openPoints[0][0] = false;
				openPoints[1][1] = false;
				openPoints[2][0] = false;
				openPoints[0][1] = false;
				openPoints[2][1] = false;
				break;
		case 2: startX = 3;
				startY = 1;
				openPoints[2][0] = false;
				openPoints[1][0] = false;
				openPoints[2][1] = false;
				openPoints[3][0] = false;
				openPoints[1][1] = false;
				openPoints[3][1] = false;
				break;
		case 3: startX = 4;
				startY = 1;
				openPoints[3][0] = false;
				openPoints[2][0] = false;
				openPoints[3][1] = false;
				openPoints[2][1] = false;
				break;
		case 4: startX = 4;
				startY = 2;
				openPoints[3][1] = false;
				openPoints[3][0] = false;
				openPoints[2][1] = false;
				openPoints[3][2] = false;
				openPoints[2][0] = false;
				openPoints[2][2] = false;
				break;
		case 5: startX = 4;
				startY = 3;
				openPoints[3][2] = false;
				openPoints[3][1] = false;
				openPoints[2][2] = false;
				openPoints[3][3] = false;
				openPoints[2][1] = false;
				openPoints[2][3] = false;
				break;
		case 6: startX = 4;
				startY = 4;
				openPoints[3][3] = false;
				openPoints[3][2] = false;
				openPoints[2][3] = false;
				openPoints[2][2] = false;
				break;
		case 7: startX = 3;
				startY = 4;
				openPoints[2][3] = false;
				openPoints[3][3] = false;
				openPoints[2][2] = false;
				openPoints[1][3] = false;
				openPoints[3][2] = false;
				openPoints[1][2] = false;
				break;
		case 8: startX = 2;
				startY = 4;
				openPoints[1][3] = false;
				openPoints[0][3] = false;
				openPoints[1][2] = false;
				openPoints[2][3] = false;
				openPoints[2][2] = false;
				openPoints[0][2] = false;
				break;
		case 9: startX = 1;
				startY = 4;
				openPoints[0][3] = false;
				openPoints[0][2] = false;
				openPoints[1][3] = false;
				openPoints[1][2] = false;
				break;
		case 10:startX = 1;
				startY = 3;
				openPoints[0][2] = false;
				openPoints[0][1] = false;
				openPoints[1][2] = false;
				openPoints[0][3] = false;
				openPoints[1][1] = false;
				openPoints[1][3] = false;
				break;
		case 11:startX = 1;
				startY = 2;
				openPoints[0][1] = false;
				openPoints[0][0] = false;
				openPoints[1][1] = false;
				openPoints[0][2] = false;
				openPoints[1][0] = false;
				openPoints[1][2] = false;
				break;
		default: System.out.println("What are you even DOING with the level generation?");
		}
		System.out.println("Start point is at: (" + (startX-1) + ", " + (startY-1) + ")");
		myRooms[startX][startY].setStartDoorRoom(true);//telling the start point that it is the start.
		//start end point generation
		System.out.println("Generating End Point...");
				
		// print updated map
		System.out.println();
		dispPoints(openPoints);
		System.out.println();
		
		//these lists will store viable locations for generation of end point
		int[] possibleX = new int[12];
		int[] possibleY = new int[12];
		
		//count tracks the remaining number of spaces that can be used to generate the end point
		int count = 0;
		
		//nested for loop counts the number of "true" values in the array openPoints
		//also adds locations of "true" values to the two lists
		for(int row = 0; row < 4; row++){
			for(int col = 0; col < 4; col++){
				if(openPoints[row][col]){
					possibleX[count] = row;
					possibleY[count] = col;
					count++;
				}
			}
		}
		//no more switch case
		int endChoice = (int)(rng.nextDouble()*count);
		//end point coordinates are randomly assigned from list of possible choices
		endX = possibleX[endChoice];
		endY = possibleY[endChoice];
		//based off selection, invalidating tiles adjacent so the key placement is not too close (same 1 tile requirement)
		//(if statements check that invalidation process will not give out of bounds exception)
		openPoints[endX][endY] = false;
		if(endX > 0 && endY > 0){
			openPoints[endX-1][endY] = false;
			openPoints[endX][endY-1] = false;
			openPoints[endX-1][endY-1] = false;
		}
		if(endX > 0 && endY < 3){
			openPoints[endX-1][endY] = false;
			openPoints[endX][endY+1] = false;
			openPoints[endX-1][endY+1] = false;
		}
		if(endX < 3 && endY > 0){
			openPoints[endX+1][endY] = false;
			openPoints[endX][endY-1] = false;
			openPoints[endX+1][endY-1] = false;
		}
		if(endX < 3 && endY < 3){
			openPoints[endX+1][endY] = false;
			openPoints[endX][endY+1] = false;
			openPoints[endX+1][endY+1] = false;
		}
		
		System.out.println("End point is at: (" + endX + ", " + endY + ")");
		myRooms[endX+1][endY+1].setEndDoorRoom(true);//telling the end point that it is the end.
		System.out.println();
		dispPoints(openPoints);
		System.out.println();	
		
		// start key point generation
		System.out.println("Generating Key Point...");
		//these lists will store viable locations for generation of key point
		
		//reusing same variables and reusing code;
			possibleX = new int[12];
			possibleY = new int[12];
			//count tracks the remaining number of spaces that can be used to generate the key point
			count = 0;
			//nested for loop counts the number of "true" values in the array openPoints
			//also adds locations of "true" values to the two reused lists
			for(int row = 0; row < 4; row++){
				for(int col = 0; col < 4; col++){
					if(openPoints[row][col]){
						possibleX[count] = row;
						possibleY[count] = col;
						count++;
					}
				}
			}
			
			int keyChoice = (int)(rng.nextDouble()*count);
			//key point coordinates are randomly assigned from list of possible choices
			keyX = possibleX[keyChoice];
			keyY = possibleY[keyChoice];
			
			//systematic invalidation, again
			openPoints[keyX][keyY] = false;
			if(keyX > 0){
				openPoints[keyX-1][keyY] = false;
			}
			if(keyY > 0){
				openPoints[keyX][keyY-1] = false;
			}
			if(keyX < 3){
				openPoints[keyX+1][keyY] = false;
			}
			if(keyY < 3){
				openPoints[keyX][keyY+1] = false;
			}
			
			System.out.println("Key point is at: (" + keyX + ", " + keyY + ")");
			myRooms[keyX+1][keyY+1].setKeyRoom(true);//telling the key point that it is the key.
			System.out.println();
			dispPoints(openPoints);
			System.out.println();
	}
	// hard coded to only accept 4 by 4 boolean arrays
	// this method displays ONLY the special point generation possibilities map
	public void dispPoints(boolean[][] input){
		for(int row = 0; row < 4; row++){
			for(int col = 0; col < 4; col++){
				if(input[col][row]){// this weird orientation accounts for the difference between array default numbering and our coordinate system
					System.out.print("1 ");
				}else{
					System.out.print("0 ");
				}
			}
		System.out.println();
		}
	}
	public boolean path(){
		//apparently all my special points besides the start values were 1 too low.
		keyX++;
		keyY++;
		endX++;
		endY++;
		//first few lines are for specific generation of start room.
		makeActive(startX,startY - 1);
		makeActive(startX,startY + 1);
		makeActive(startX - 1,startY);
		makeActive(startX + 1,startY);
		myRooms[startX][startY].setUp(1);
		myRooms[startX][startY].setRight(1);
		myRooms[startX][startY].setDown(1);
		myRooms[startX][startY].setLeft(1);
		int count = 0;
		
		//core loop
		while(activeX.size() > 0 && activeY.size() > 0){
			count++;
			System.out.println("Path Generation Step " + count);
			removeActive();
		//	dispPath();
			enhancedDispPath();
		}

		//recovery options
		if(!hasReachedEnd || !hasReachedKey){
			return false;// failed to path
		}else{
			return true;// successfully created path
		}
	}
	public void makeActive(int x, int y){
		if(x >= 1 && x <= 4 && y >= 1 && y <= 4){
			activeX.add(x);
			activeY.add(y);	
		}else{
			//do nothing, a point that was tested is invalid.
		}
		
	}
	//randomly remove a term from both active lists
	// before removing term, generate a path for that term and update it's neighbors after creating that path
	public void removeActive(){
		if(activeX.size() > 0 && activeY.size() > 0){
			int toRemove = (int)(rng.nextDouble()*activeX.size());
			// printing out all values in both active lists
			System.out.print("Active Tiles:");
			for(int i = 0; i < activeX.size();  i++){
				System.out.print("(" + activeX.get(i) + ", " + activeY.get(i) + ")   ");
			}
			System.out.println();
			System.out.println("Selected Tile: (" + activeX.get(toRemove) + ", " + activeY.get(toRemove) + ")");
			
			//creates path (see method below)
			boolean test = generatePath(activeX.get(toRemove), activeY.get(toRemove));
			
			//updates adjacent tiles before point is removed from active list
			//updateAdjacentTiles(activeX.get(toRemove), activeY.get(toRemove));
			//final removal from active list
			System.out.println("hasReachedEnd at (" + endX + ", " + endY + "): " + hasReachedEnd + "   hasReachedKey at (" + keyX + ", " + keyY+ "): " + hasReachedKey);
			System.out.println("Special Case Reached: " + test);
			
			//finally removing the selected point from the active lists
			activeX.remove(toRemove);
			activeY.remove(toRemove);
		}
	}
	
	public boolean generatePath(int x, int y){
		// returns an irrelevant boolean value so that way once a special case is reached it exits the method
		
		// PROTOCOL NO 1 - Reflection
		// MOST PRIORITY
		
		//checks adjacent tiles for imposed values and assigns them as need be
		//looks left and if there is a required value that it should assign, it will assign it
		if((myRooms[x-1][y].getRight() != 0)&&(myRooms[x][y].getLeft() == 0)){
			System.out.println("Overwriting (" + x +", " + y + ")'s LEFT value of " + myRooms[x][y].getLeft() + " with " + myRooms[x-1][y].getRight());
			myRooms[x][y].setLeft(myRooms[x-1][y].getRight());
		}
		//looks right for required value
		if((myRooms[x+1][y].getLeft() != 0)&&(myRooms[x][y].getRight() == 0)){
			System.out.println("Overwriting (" + x +", " + y + ")'s RIGHT value of " + myRooms[x][y].getRight() + " with " + myRooms[x+1][y].getLeft());
			myRooms[x][y].setRight(myRooms[x+1][y].getLeft());
		}
		//looks up for required value
		if((myRooms[x][y-1].getDown() != 0)&&(myRooms[x][y].getUp() == 0)){
			System.out.println("Overwriting (" + x +", " + y + ")'s UP value of " + myRooms[x][y].getUp() + " with " + myRooms[x][y-1].getDown());
			myRooms[x][y].setUp(myRooms[x][y-1].getDown());
		}
		//looks down for a required value
		if((myRooms[x][y+1].getUp() != 0)&&(myRooms[x][y].getDown() == 0)){
			System.out.println("Overwriting (" + x +", " + y + ")'s DOWN value of " + myRooms[x][y].getDown() + " with " + myRooms[x][y+1].getUp());
			myRooms[x][y].setDown(myRooms[x][y+1].getUp());
		}
		
		// PROTOCOL NO 2 - Special Case
		// check if tile generating exists next to an ungenerated key or exit tile and force it to path there and only there
		// custom generation occurs if that is the case, bypasses active list to make the one connection and refuses all others.
		if(!hasReachedEnd){	
			//checking if near end point
			if(((x) == endX)&&((y) == endY)){
				//should be impossible to generate this tile first
				System.out.println("Map Gen Error: Cannot connect to end point while at end point.");
			}else if(((x-1) == endX)&&((y) == endY)){
				//generating from right
				myRooms[x][y].setLeft(1);
				myRooms[endX][endY].setUp(-1);
				myRooms[endX][endY].setRight(1);
				myRooms[endX][endY].setDown(-1);
				myRooms[endX][endY].setLeft(-1);
				hasReachedEnd = true;
				generatePath(x,y);// this line is here because otherwise the custom generation doesn't fully take care of active tile's connections
				return true;
				
			}else if(((x+1) == endX)&&((y) == endY)){
				//generating from left
				myRooms[x][y].setRight(1);
				myRooms[endX][endY].setUp(-1);
				myRooms[endX][endY].setRight(-1);
				myRooms[endX][endY].setDown(-1);
				myRooms[endX][endY].setLeft(1);
				hasReachedEnd = true;
				generatePath(x,y);
				return true;
			}else if(((x) == endX)&&((y-1) == endY)){
				//generating from below
				myRooms[x][y].setUp(1);
				myRooms[endX][endY].setUp(-1);
				myRooms[endX][endY].setRight(-1);
				myRooms[endX][endY].setDown(1);
				myRooms[endX][endY].setLeft(-1);
				hasReachedEnd = true;
				generatePath(x,y);
				return true;
			}else if(((x) == endX)&&((y+1) == endY)){
				//generating from above
				myRooms[x][y].setDown(1);
				myRooms[endX][endY].setUp(1);
				myRooms[endX][endY].setRight(-1);
				myRooms[endX][endY].setDown(-1);
				myRooms[endX][endY].setLeft(-1);
				hasReachedEnd = true;
				generatePath(x,y);
				return true;
			}
		}
		if(!hasReachedKey){
			//checking if near key point
			if(((x) == keyX)&&((y) == keyY)){
				//should be impossible to generate this tile first
				System.out.println("Map Gen Error: Cannot connect to key point while at key point.");
			}else if(((x-1) == keyX)&&((y) == keyY)){
				//generating from right
				myRooms[x][y].setLeft(1);
				myRooms[keyX][keyY].setUp(-1);
				myRooms[keyX][keyY].setRight(1);
				myRooms[keyX][keyY].setDown(-1);
				myRooms[keyX][keyY].setLeft(-1);
				hasReachedKey = true;
				generatePath(x,y);
				return true;
			}else if(((x+1) == keyX)&&((y) == keyY)){
				//generating from left
				myRooms[x][y].setRight(1);
				myRooms[keyX][keyY].setUp(-1);
				myRooms[keyX][keyY].setRight(-1);
				myRooms[keyX][keyY].setDown(-1);
				myRooms[keyX][keyY].setLeft(1);
				hasReachedKey = true;
				generatePath(x,y);
				return true;
			}else if(((x) == keyX)&&((y-1) == keyY)){
				//generating from below
				myRooms[x][y].setUp(1);
				myRooms[keyX][keyY].setUp(-1);
				myRooms[keyX][keyY].setRight(-1);
				myRooms[keyX][keyY].setDown(1);
				myRooms[keyX][keyY].setLeft(-1);
				hasReachedKey = true;
				generatePath(x,y);
				return true;
			}else if(((x) == keyX)&&((y+1) == keyY)){
				//generating from above
				myRooms[x][y].setDown(1);
				myRooms[keyX][keyY].setUp(1);
				myRooms[keyX][keyY].setRight(-1);
				myRooms[keyX][keyY].setDown(-1);
				myRooms[keyX][keyY].setLeft(-1);
				hasReachedKey = true;
				generatePath(x,y);
				return true;
			}
		}
		// PROTOCOL NO 3 - No Random Dead Ends
		// if there is only one randomly generating segment out of four, guarantee it connects and add next tile to active list.
		
		// if only random connection is up
		if((myRooms[x][y].getUp() == 0)&&(myRooms[x][y].getRight() != 0) && (myRooms[x][y].getDown() != 0) && (myRooms[x][y].getLeft() != 0)){
			System.out.println("Forced to connect UP from: (" + x + ", " + y + ")");
			myRooms[x][y].setUp(1);
			makeActive(x, y-1);
			
			//if only right
		}else if((myRooms[x][y].getUp() != 0)&&(myRooms[x][y].getRight() == 0) && (myRooms[x][y].getDown() != 0) && (myRooms[x][y].getLeft() != 0)){
			System.out.println("Forced to connect RIGHT from: (" + x + ", " + y + ")");
			myRooms[x][y].setRight(1);
			makeActive(x+1,y);
			
			//if only down
		}else if((myRooms[x][y].getUp() != 0)&&(myRooms[x][y].getRight() != 0) && (myRooms[x][y].getDown() == 0) && (myRooms[x][y].getLeft() != 0)){
			System.out.println("Forced to connect DOWN from: (" + x + ", " + y + ")");
			myRooms[x][y].setDown(1);
			makeActive(x,y+1);
			
			//if only left
		}else if((myRooms[x][y].getUp() != 0)&&(myRooms[x][y].getRight() != 0) && (myRooms[x][y].getDown() != 0) && (myRooms[x][y].getLeft() == 0)){
			System.out.println("Forced to connect LEFT from: (" + x + ", " + y + ")");
			myRooms[x][y].setLeft(1);
			makeActive(x-1,y);
		}
		
		// PROTOCOL NO 4 - Random Generation
		// generate a value for any 0 values and add necessary tiles to the active list
		// note: should be most commonly occurring protocol, if possible
		int connectionsToGenerate = 0;// used to enforce the no dead end spawning rule
		final int MIN_NUM_CONNECTIONS = 1;// if generating many tiles there will be at least these many guaranteed positive generations
		// assigning value to connectionsToGenerate
		if(myRooms[x][y].getUp() == 0){
			connectionsToGenerate ++;
		}
		if(myRooms[x][y].getRight() == 0){
			connectionsToGenerate ++;
		}
		if(myRooms[x][y].getDown() == 0){
			connectionsToGenerate ++;
		}
		if(myRooms[x][y].getLeft() == 0){
			connectionsToGenerate ++;
		}
		
		//checking for random connection points and assigning values as need be
		if(myRooms[x][y].getUp() == 0){
			if(rng.nextDouble() < CHANCE_TO_CONNECT && connectionsToGenerate > MIN_NUM_CONNECTIONS){
				System.out.println("Assigning (" + x + ", " + y + ") an UP value: -10");
				myRooms[x][y].setUp(-10);
				connectionsToGenerate--;
			}else{
				System.out.println("Assigning (" + x + ", " + y + ") an UP value: 10");
				myRooms[x][y].setUp(10);
				makeActive((x),(y-1));
				connectionsToGenerate--;
			}
		}
		if(myRooms[x][y].getRight() == 0){
			if(rng.nextDouble() < CHANCE_TO_CONNECT && connectionsToGenerate > MIN_NUM_CONNECTIONS){
				System.out.println("Assigning (" + x + ", " + y + ") a RIGHT value: -10");
				myRooms[x][y].setRight(-10);
				connectionsToGenerate--;
			}else{
				System.out.println("Assigning (" + x + ", " + y + ") a RIGHT value: 10");
				myRooms[x][y].setRight(10);
				makeActive((x+1),(y));
				connectionsToGenerate--;
			}
		}
		if(myRooms[x][y].getDown() == 0){
			if(rng.nextDouble() < CHANCE_TO_CONNECT && connectionsToGenerate > MIN_NUM_CONNECTIONS){
				System.out.println("Assigning (" + x + ", " + y + ") a DOWN value: -10");
				myRooms[x][y].setDown(-10);
				connectionsToGenerate--;
			}else{
				System.out.println("Assigning (" + x + ", " + y + ") a DOWN value: 10");
				myRooms[x][y].setDown(10);
				makeActive((x),(y+1));
				connectionsToGenerate--;
			}
		}
		if(myRooms[x][y].getLeft() == 0){
			if(rng.nextDouble() < CHANCE_TO_CONNECT && connectionsToGenerate > MIN_NUM_CONNECTIONS){
				System.out.println("Assigning (" + x + ", " + y + ") a LEFT value: -10");
				myRooms[x][y].setLeft(-10);
				connectionsToGenerate--;
			}else{
				System.out.println("Assigning (" + x + ", " + y + ") a LEFT value: 10");
				myRooms[x][y].setLeft(10);
				makeActive((x-1),(y));
				connectionsToGenerate--;
			}
		}
		return false;
	}
	
	public void dispPath(int given[][]){
		for(int row = 0; row < 4; row++){
			for(int col = 0; col < 4; col++){
				if(given[col][row] < 10 && given[col][row] >= 0){
					System.out.print(given[col][row] + "  ");
				}else{
					System.out.print(given[col][row] + " ");
				}
			}
		System.out.println();
		}
	}
	public void enhancedDispPath(){
		for(int i = 0; i < 4; i++){
			//creates a temporary list to store a row of Rooms that are then going to be sent to a helping display method
			Room tempList[] = new Room[4];
			//assigns a value to the tempList
				for(int col = 0; col < 4; col++){
						tempList[col] = myRooms[col+1][i+1];// to grab the meaningful tiles and send them in the right order, to helping method
				}			
			helpingDisplayMethod(tempList);
		}
	}
	public void seek(){//identifies significant dead ends
		int myTrail[][] = {{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1},{-1,-1,-1,-1}};
		myTrail[startX-1][startY-1] = 0;
		if(startX-1 > 0){
			myTrail[startX-1-1][startY-1] = 1;
		}
		if(startX-1 < 3){
			myTrail[startX-1+1][startY-1] = 1;
		}
		if(startY-1 > 0){
			myTrail[startX-1][startY-1-1] = 1;
		}
		if(startY-1 < 3){
			myTrail[startX-1][startY-1+1] = 1;
		}
		int currentNum = 1;
		while(trailContains(currentNum,myTrail)){
			
			//this nested for loop structure is intended to check adjacent connections to tiles with currentNum as its value and update them to currentNum + 1
			for(int row = 0; row < 4; row ++){
				for(int col = 0; col < 4; col++){
					//only actually do anything on the currentNum tiles
					if(myTrail[row][col] == currentNum){
						// if there is a tile to grab left of current position
						if(row > 0){
							//if there is a connection right from this left tile AND this tile doesn't already have a value assigned
							if(myRooms[row+1-1][col+1].getRight() > 0 && myTrail[row-1][col] == -1){
								myTrail[row-1][col] = currentNum + 1;
							}
						}
						// if there is a tile to grab right of current position
						if(row < 3){
							//if there is a connection left from this left tile AND this tile doesn't already have a value assigned
							if(myRooms[row+1+1][col+1].getLeft() > 0 && myTrail[row+1][col] == -1){
								myTrail[row+1][col] = currentNum + 1;
							}
						}
						// if there is a tile to grab above current position
						if(col > 0){
							//if there is a connection down from this left tile AND this tile doesn't already have a value assigned
							if(myRooms[row+1][col+1-1].getDown() > 0 && myTrail[row][col-1] == -1){
								myTrail[row][col-1] = currentNum + 1;
							}
						}
						// if there is a tile to grab left of current position
						if(col < 3){
							//if there is a connection right from this left tile AND this tile doesn't already have a value assigned
							if(myRooms[row+1][col+1+1].getUp() > 0 && myTrail[row][col+1] == -1){
								myTrail[row][col+1] = currentNum + 1;
							}
						}
					}
				}
			}
			currentNum++;
		}
	//	dispPath(myTrail);
		int keyVal = myTrail[keyX-1][keyY-1];
		int endVal = myTrail[endX-1][endY-1];
		
		for(int row = 0; row < 4; row++){
			for(int col = 0; col < 4; col++){
				if((myTrail[row][col] > keyVal) //larger than key path distance
						&& (myTrail[row][col] > endVal) //and larger than end path distance
						&& (// and an end type tile
								(myRooms[row+1][col+1].getValue()==9)
						||		(myRooms[row+1][col+1].getValue()==10)
						||		(myRooms[row+1][col+1].getValue()==12)
						||		(myRooms[row+1][col+1].getValue()==13)
						)){
					myRooms[row+1][col+1].setDeadEndRoom(true);
					System.out.println("Dead end at: (" + (row+1) + ", " + (col+1) + ")");
				}
			}
		}
	}
	
	//checks a given 4 by 4 integer array for the presence of an integer value
	boolean trailContains (int currentNum, int list[][]){
		for(int row = 0; row < 4; row ++){
			for(int col = 0; col < 4; col++){
				if(list[row][col] == currentNum){
					return true;
				}
			}
		}
		return false;
	}
	
	public void helpingDisplayMethod(Room givenRow[]){
		// this loop will print only the upper values on the top lines
		System.out.print("  ");
		for(int i = 0; i < givenRow.length; i++){
			if(givenRow[i].getUp() > 0){
				System.out.print("| ");
			}else{
				System.out.print("  ");
			}
			
			System.out.print("     ");
		}
		System.out.println();
		for(int i = 0; i < givenRow.length; i++){
			if(givenRow[i].getLeft() > 0){
				System.out.print("-");
			}else{
				System.out.print(" ");
			}
			
			System.out.print(" ");
			if(givenRow[i].getValue() >= 0 && givenRow[i].getValue() < 10){
				System.out.print(givenRow[i].getValue() + " ");
			}else{
				System.out.print(givenRow[i].getValue());
			}
			
			System.out.print(" ");
			
			if(givenRow[i].getRight() > 0){
				System.out.print("-");
			}else{
				System.out.print(" ");
			}
			
			System.out.print(" ");
		}
		System.out.println();
		System.out.print("  ");
		for(int i = 0; i < givenRow.length; i++){
			if(givenRow[i].getDown() > 0){
				System.out.print("| ");
			}else{
				System.out.print("  ");
			}
			
			System.out.print("     ");
		}
		
		System.out.println();
	}
	
	
	public void toTextFile(String outputLocation, String levelName){
		File outputFile = new File(outputLocation + "\\" + levelName);
		
		try {
			FileWriter output = new FileWriter(outputFile);
		
	//assign every room a value.	
		for(int row = 1; row < 5; row++){
			for(int col = 1; col < 5; col++){
				myRooms[col][row].selectRoom(rng);
			}
		}

		int totalEntities = 0;
		for(int a = 1; a < myRooms[0].length - 1; a++)
		{
			for(int b = 1; b < myRooms.length - 1; b++)
			{
				totalEntities += myRooms[a][b].getNumEntities();
			}
		}
		
		output.write(myRooms[0][0].width*4 + " " + myRooms[0][0].height*4 + " " + myRooms[0][0].layers + " " + totalEntities);
		output.write("\r\n");
		
		for(int l = 0; l < myRooms[1][1].layers; l++)
		{
			for(int j = 1; j < myRooms.length-1; j ++)
			{
				for(int y = 0; y < myRooms[1][1].getMyTiles().length; y ++)
				{			
					for(int i = 1; i < myRooms.length-1; i++)
					{
						for(int x = 0; x < myRooms[i][j].getMyTiles().length; x ++)
						{
							if(myRooms[i][j].getMyTiles()[x][y][l] > -1 && myRooms[i][j].getMyTiles()[x][y][l] < 10){
//								System.out.print(myRooms[i][j].getMyTiles()[x][y][l] + "  ");
								output.write(myRooms[i][j].getMyTiles()[x][y][l] + "  ");
							}else{
//								System.out.print(myRooms[i][j].getMyTiles()[x][y][l] + " ");
								output.write(myRooms[i][j].getMyTiles()[x][y][l] + " ");
							}
						
						}
						
					}
					//System.out.println();
					output.write("\r\n");
				}
			}
			output.write("\r\n\r\n\r\n");
			//System.out.println();
			//System.out.println();
		}
		
		for(int a = 1; a < myRooms[0].length-1; a++)
		{
			for(int b = 1; b < myRooms.length-1; b++)
			{
				myRooms[a][b].writeEntities(output, a-1, b-1);
			}
		}
	
		output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public int getStartX() {return (startX-1)*24;}//???????
	public int getStartY() {return (startY-1)*24;}//!!!!!!!
	public int getEndX() {return endX;}
	public int getEndY() {return endY;}
	public int getKeyX() {return keyX;}
	public int getKeyY() {return keyY;}
	public Room[][] getMyRooms() {return myRooms;}
	public void setMyRooms(Room[][] myRooms) {this.myRooms = myRooms;}

}