package com.base.game.entity.item;

import java.io.Serializable;

import com.base.game.InventoryInterface;
import com.base.game.entity.Player;

public class Item implements Serializable {
	private String name;
	private int quantity, value;
	String[] summary;

	public Item(String name) {
		this.setName(name);
		quantity = 1;
		summary = new String[3];
		summary[0] = "";
		summary[1] = "";
		summary[2] = "";

		switch (name) {
			case "SMALL HEALTH HERB":
				value = 100;
				break;
			case "HEALTH HERB":
				value = 200;
				break;
			case "LARGE HEALTH HERB":
				value = 500;
				break;
			case "BURN MEDICINE":
				value = 200;
				break;
			case "DEFROSTER":
				value = 200;
				break;
			case "PARALYSIS CURE":
				value = 200;
				break;
			case "ANTISERUM":
				value = 200;
				break;
			case "PANACEA":
				value = 500;
				break;
		}
	}

	public void use(Player p, InventoryInterface iInterface) {
		switch (name) {
			case "SMALL HEALTH HERB":
				p.addHealth(2);
				break;
		}

		quantity--;

		if (quantity <= 0)
			iInterface.getInventory().remove(this);

	}

	public void increase() {
		quantity++;
	}

	public String[] getSummary() {
		switch (name) {
			case "SMALL HEALTH HERB":
				summary[0] = "HEALS TWO HEALTH BARS";
				break;
			case "HEALTH HERB":
				summary[0] = "HEALS FIVE HEALTH BARS";
				break;
			case "LARGE HEALTH HERB":
				summary[0] = "HEALS TEN HEALTH BARS";
				break;
			case "BURN MEDICINE":
				summary[0] = "HEALS 'BURNED' STATUS CONDITION";
				break;
			case "DEFROSTER":
				summary[0] = "HEALS 'FROZEN' STATUS CONDITION";
				break;
			case "PARALYSIS CURE":
				summary[0] = "HEALS 'PARALYZED' STATUS CONDITION";
				break;
			case "ANTISERUM":
				summary[0] = "HEALS 'POSIONED' STATUS CONDITION";
				break;
			case "PANACEA":
				summary[0] = "HEALS ALL STATUS CONDITIONS";
				break;

		}
		return summary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
