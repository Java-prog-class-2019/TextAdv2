package components;

import java.lang.reflect.Array;
import java.util.Random;

import components.Item.Type;

public class Mobs {

	int power;
	int defence;
	int health;
	double dodgeChance;
	double critChance;
	String type;

	String mobTypesGH [] = {"Spiderling","Clothes Hanger", "Dust Bunny", "Old Floorboard", "Cabinet Door","Carpet"};
	String mobTypesK [] = {"Whisk","Faucet","Chef's Knife","Cheese Grater", "Bag of Frozen Peas","Cutting Board"};
	String mobTypesB [] = {"Old Tire Swing","LawnMower","Rake", "Baseball Bat","Shovel", "Wheelbarrow"};

	public Mobs() {
		chooseType();
		genStats();
		dropItems();
	}

	public void chooseType() {
		Room room = new Room();
		if (room.getRoomType() == "great hall") {
			type = mobTypesGH [(int)(Math.random()*mobTypesGH.length)];
		}
		if (room.getRoomType() == "kitchen") {	
			type = mobTypesK [(int)(Math.random()*mobTypesK.length)];
		}
		if (room.getRoomType() == "backyard") {
			type = mobTypesB [(int)(Math.random()*mobTypesB.length)];
		}
	}

	public void genStats() {
		Room room = new Room();
		if (room.getRoomType() == "great hall") {
			for (int i = 0; i <6; i++) {
				if (type == mobTypesGH[i]) {
					power = (int)(Math.random()*2)+1;
					health = (int)(Math.random()*4)+2;
					defence = (int)(Math.random()*2);
					critChance = 0;
					dodgeChance = 0;
				}
						
			}
		}
		if (room.getRoomType() == "kitchen") {
			for (int i = 0; i <6; i++) {
				if (type == mobTypesGH[i]) {
					power = (int)(Math.random()*2)+1;
					health = (int)(Math.random()*4)+2;
					defence = (int)(Math.random()*2);
					critChance = 0;
					dodgeChance = 0;
				}
						
			}
		}
		if (room.getRoomType() == "backyard") {
			for (int i = 0; i <6; i++) {
				if (type == mobTypesGH[i]) {
					power = (int)(Math.random()*2)+1;
					health = (int)(Math.random()*4)+2;
					defence = (int)(Math.random()*2);
					critChance = 0;
					dodgeChance = 0;
				}
						
			}
		}
	}

	public void dropItems() {
	}

}
