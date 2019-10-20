package components;

import components.Item.Type;

public class Bonk {

	boolean playerTurn;
	boolean systemTurn;

	public static void main(String[] args) {

		new Bonk();

	}


	Bonk() {
		init();	

	}
	

	public void init() {
		Room room = new Room();
		String description = room.getDescription();
		System.out.println(description);
		Item item = new Item();
		System.out.println(item.type);
		System.out.println(item.name);
		System.out.println(item.rarity);
		if (item.type == Type.WEAPON) {
		System.out.println("Power: " + item.power);
		System.out.println("Crit Chance: " + item.critChance);
		}
		if (item.type == Type.ARMOUR) {
		System.out.println("Bonus Health: " + item.bonusHealth);
		System.out.println("Defence: " + item.defence);
		System.out.println("Dodge Chance: " + item.dodgeChance);
		System.out.println(" Welcome to Bonk! Type 'help' for a list of commands \n");
		}
		playerTurn = false;
		systemTurn = true;		
	}
}
