package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {

	String name;
	ArrayList<Item> inv = new ArrayList<Item>();	//inventory
	private int coins = 0;


	// Hard Stats
	int power = 5;
	int armour;
	int health = 15;
	int bonusHealth;

	//Soft Stats
	double dodgeChance;
	double critChance = 1;



	public Player() {

	}

	public void dropItem(Item item) {	//removes item from inventory
		inv.remove(item);
	}

	public void applyStats(Item item) {
		dodgeChance += item.dodgeChance;
		critChance += item.critChance;
		power += item.power;
		armour += item.power;
	}

	public void removeStats(Item item) {
		dodgeChance -= item.dodgeChance;
		critChance -= item.critChance;
		power -= item.power;
		armour -= item.defence;
	}

	


	public void attack(boolean playerTurn, Mob mob) {
		if (playerTurn == true) {
			System.out.println("You attack a " + mob.type + " with "+ mob.getHealth() + " health");
			if (Math.random() <= critChance) {
				mob.setHealth(mob.health - power*2 + mob.armour );
				System.out.println("YOU CRITICALLY STRIKE THE MOB FOR " +  (power*2 - mob.getArmour()) + " DAMAGE!");
				System.out.println("The mob's health drops to " + mob.health);
			}
			else {
				mob.setHealth(mob.health - power + mob.getArmour());
				System.out.println("The mob's health drops to " + mob.getHealth());
			}
		}
	}


	

	
	public void setCoins(int coins) {
		this.coins=coins;
	}

	public int getCoins() {
		return coins;
	}
	/***************************************************/
}