package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import components.Item.Type;

public class Player {

	String name = "Billy";
  
	ArrayList<Item> inv = new ArrayList<Item>();	//inventory
	private int coins = 15;
	Item currentWeapon;
	Item currentArmour;


	// Hard Stats
	int power=3;
	int armour=0;
	int health=15;
	int bonusHealth=0;

	//Soft Stats
	double dodgeChance=0.0;
	double critChance=0.0;



	public Player() {

	}

	public void pickupItem(Item item) {	//adds item to inventory
		
		inv.add(item);
		
	}

	public void dropItem(Item item) {	//removes item from inventory
		
		inv.remove(item);

	}

	public void applyStats(Item item) {	//changes the player's stats to accommodate for a newly equipped item
		dodgeChance += item.dodgeChance;
		critChance += item.critChance;
		power += item.power;
		armour += item.power;
		health += item.bonusHealth;
	}

	public void removeStats(Item item) {	//changes the player's stats to accommodate for a newly unequipped item
		dodgeChance -= item.dodgeChance;
		critChance -= item.critChance;
		power -= item.power;
		armour -= item.defence;
		health -= item.bonusHealth;
	}
	
	
	public void equip(String item){
		int index = (int)(item.charAt(0))-49;
		if(inv.size()>index) {
			if(inv.get(index).type==Type.WEAPON) {
				if(currentWeapon==null) {
					System.out.println("You equipped " + inv.get(index).name + ".");
					currentWeapon=inv.get(index);
					applyStats(currentWeapon);
					inv.remove(inv.get(index));
				}else {
					System.out.println("You equipped " + inv.get(index).name + ".");
					removeStats(currentWeapon);
					inv.add(currentWeapon);
					currentWeapon=inv.get(index);
					applyStats(currentWeapon);
					inv.remove(inv.get(index));
				}
			}else{
				if(currentArmour == null) {
					System.out.println("You equipped " + inv.get(index).name + ".");
					currentArmour=inv.get(index);
					applyStats(currentArmour);
					inv.remove(inv.get(index));
				}else {
					System.out.println("You equipped " + inv.get(index).name + ".");
					removeStats(currentArmour);
					inv.add(currentArmour);
					currentArmour=inv.get(index);
					applyStats(currentArmour);
					inv.remove(inv.get(index));
				}
			}
		}else {
			System.out.println("You can't do that.");
		}
	}

	/*******getters and setters*************************/ 
	
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