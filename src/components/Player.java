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
	double critChance;



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
			System.out.println("You attack a " + mob.type + " with "+ mob.health + " health");
			if (Math.random() <= critChance) {
				mob.setHealth(power*2 - mob.armour);
				System.out.println("YOU CRITICALLY STRIKE THE MOB FOR " +  (power*2 - mob.armour) + " DAMAGE!");
				System.out.println("The mob's health drops to " + mob.health);
				playerTurn = false;
			}
			else {
				mob.setHealth(power-mob.armour);
				System.out.println("You hit the mob for " + (power - mob.armour) + " damage");
				System.out.println("The mob's health drops to " + mob.health);
				playerTurn = false;
			}
			
			if (mob.health > 0 && playerTurn == false) {
				if (armour > mob.power) {
					if (health <= 0) {
						health = 0;
					}
					System.out.println("Your health drops to " + health );
					playerTurn = true;
				}
				else {	
					health = health - mob.power + armour;
					if (health <= 0) {
						health = 0;
					}
					System.out.println("\nYour health drops to " + health);
					playerTurn = true;
				}
				if (health <= 0) {
					Bonk.setIsAlive(false);
				}
			}

			if (mob.health <= 0) {
				Bonk.isMob = false;
				System.out.println("\nYou have successfully defeated the mob and can now advance to the next room.");
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