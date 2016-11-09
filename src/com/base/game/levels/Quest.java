package com.base.game.levels;

import java.io.Serializable;

public class Quest implements Serializable
{
	private String txtLine1, txtLine2, client, objective, location, difficulty;
	private int floorNum;
	private boolean isClientMale;
	private boolean isTaken;

	public Quest(String txtLine1, String txtLine2, String client, String objective, String location, int floorNum, String difficulty, boolean isClientMale)
	{
		this.txtLine1 = txtLine1;
		this.txtLine2 = txtLine2;
		this.client = client;
		this.objective = objective;
		this.location = location;
		this.floorNum = floorNum;
		this.difficulty = difficulty;
		this.isClientMale = isClientMale;
	}

	public String getTxtLine1() {
		return txtLine1;
	}

	public void setTxtLine1(String txtLine1) {
		this.txtLine1 = txtLine1;
	}

	public String getTxtLine2() {
		return txtLine2;
	}

	public void setTxtLine2(String txtLine2) {
		this.txtLine2 = txtLine2;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public int getFloorNum() {
		return floorNum;
	}

	public void setFloorNum(int floorNum) {
		this.floorNum = floorNum;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	
	public boolean isClientMale() {
		return isClientMale;
	}

	public void setClientMale(boolean isClientMale) {
		this.isClientMale = isClientMale;
	}

	public boolean isTaken() {
		return isTaken;
	}

	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	
	
}
