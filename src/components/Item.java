package components;

import java.lang.reflect.Array;
import java.util.Random;

public class Item {

	String CWeapon [] = {"A Dull Crayon", "A Paper Machet Sword", "Twin Blades", "A Scythe of Bad Fortune", "An Old Water Bottle","A Rusty Sword", "A Caveman's Club"};
	String RWeapon [] = {"The Shadow Blade", "The Scythe of Everlasting Power", "Slightly Glimmering Daggers", "A Nutty Axe of Cashews", "Prince Farnsword's Sabre", "A Serrated Dirk"};
	String LWeapon [] = {"A Stick", "A Sharp Crayon", "The Rapier of Drathaar", "The Assault Assegai of Astounding Aptitude", "The Super Sabre of Spite", "A Steel-Toed Boot", "A Havoc-inducing Halberd", "A Razor Scooter" };

	String CArmour [] = {"A Chain Helmet", "A Baseball Cap", "An Old Hoodie", "A Bear Mask", "A Broken Chestplate", "A Brown Paper Bag"};
	String RArmour [] = {"Plate Mail", "Jarvan IV's Helm", "A Sturdy Helm", "Clunky Boots", "A Grayscale Teddy Fresh Colour Block Hoodie" };
	String LArmour [] = {"Kayle's Shining Armor", "The Legendary Helm of Greatness", "A Crazy Zany Wavy Plate", "Glistening Boots", "Shadow Mail"};

	//Weapon descriptor names
	String WNames [] = {"Of Powerful Strikes", "Of Great Strikes", "Of Great Power", "Of Critical Damage" };
	String ANames [] = {"Of Swiftness", "Of Speed", "With Dodging Capabilities", "Of Great Speed"};
	
	int power;
	int defence;
	int bonusHealth;
	double critChance;
	double dodgeChance;


	Random random = new Random();

	String name;
	
	// Custom enums for rarity and armour/weapon types.
	Rarity rarity;
	Type type;

	
	// Item Constructor
	public Item() {
		chooseType();
		chooseRarity();
		genStats();
		makeName();
	}
	
	// Randomizing type along with chance
	public void chooseType() {
		
		// 50% chance to get either a Weapon or Armour
		if (random.nextDouble() >= 0.5) {
			type = Type.WEAPON;
		} else {
			type = Type.ARMOUR;
		}
		
	}


	public void chooseRarity() {

		double chance = random.nextDouble();

		if(chance < 1) {
			rarity = Rarity.COMMON;
			if (chance < 0.5) {
				rarity = Rarity.RARE;
				if (chance < 0.15) {
					rarity = Rarity.LEGENDARY;
				}
			}
		}
	}
	public void genStats() {

		
		if (type == Type.WEAPON) {
			if (rarity == Rarity.COMMON) {
				// Power for common weapons
				// 1 - 3 Power
				power = (int)(Math.random()*3)+1;
				critChance = 0;
			}
			if(rarity == Rarity.RARE) {
				// Power for rare weapons
				// 2 - 5 Power and 5% - 25% Critical Hit Chance
				power = (int)(Math.random()*5)+2;
				critChance = (Math.random()*0.2) +0.05;
			}
			if(rarity == Rarity.LEGENDARY) {
				// Power for legendary weapons
				// 3 - 7 Power and 25% - 75% Critical Hit Chance
				power = (int)(Math.random()*7)+3;
				critChance = (Math.random()*0.5) +0.25;
			}
		}

		if (type == Type.ARMOUR) {
			
			if(rarity == Rarity.COMMON) {
				// Defence and Bonus Health random set
				// Make armour that has a dodge chance to have less of the other stats.
				defence = (int)(Math.random()*1)+1;   
				bonusHealth = (int) (Math.random()*3)+1;
				dodgeChance =0;
			}
			
			if(rarity == Rarity.RARE) {
				
				defence = (int)(Math.random()*3)+1;
				bonusHealth = (int) (Math.random()*5)+2;
				if(Math.random() >= 0.5){
					
					dodgeChance = (Math.random()*0.2)+0.1;
					defence = defence - 1;
					bonusHealth = bonusHealth -1;
				}
			}
			
			if(rarity == Rarity.LEGENDARY) {
				
				defence = (int)(Math.random()*4)+2;
				bonusHealth = (int) (Math.random()*8)+3;
				
				if(Math.random()>=0.5) {
					dodgeChance = (Math.random()*0.3)+0.2;
					defence = defence -1;
					bonusHealth = bonusHealth -3;
				}
			}
		}
	}

	public void makeName() {
		
		//set names for each item, making the name slightly different for each modification on it e.g. dodge or crit chance
		if (type == Type.WEAPON) {
			if(rarity==Rarity.COMMON) {
				name = CWeapon[(int)(Math.random()*CWeapon.length)];
			}
			
			if(rarity==Rarity.RARE&& critChance ==0) {
				name = RWeapon[(int)(Math.random()*RWeapon.length)];		
			}
			
			if(rarity==Rarity.RARE&& critChance > 0) {
				name = RWeapon[(int)(Math.random()*RWeapon.length)] + WNames[(int)(Math.random()*WNames.length)];

			}
			
			if(rarity==Rarity.LEGENDARY&& critChance ==0) {
				name = LWeapon[(int)(Math.random()*LWeapon.length)];		
			}
			
			if(rarity==Rarity.LEGENDARY&& critChance > 0) {
				name = LWeapon[(int)(Math.random()*LWeapon.length)] + WNames[(int)(Math.random()*WNames.length)];

			}
		}
		
		if (type == Type.ARMOUR) {
			if(rarity==Rarity.COMMON) {
				name = CArmour[(int)(Math.random()*CArmour.length)];
			}
			
			if(rarity==Rarity.RARE&& dodgeChance ==0) {
				name = RArmour[(int)(Math.random()*RArmour.length)] ;
			}
			
			if(rarity==Rarity.RARE&& dodgeChance > 0) {
				name = RArmour[(int)(Math.random()*RArmour.length)] + ANames[(int)(Math.random()*ANames.length)];
			}
			
			if(rarity==Rarity.LEGENDARY&& dodgeChance ==0) {
				name = LArmour[(int)(Math.random()*LArmour.length)] ;
			}
			
			if(rarity==Rarity.LEGENDARY&& dodgeChance > 0) {
				name = LArmour[(int)(Math.random()*LArmour.length)] + ANames[(int)(Math.random()*ANames.length)];
			}
		}
	}
	
	//list of rarities in enum

	public enum Rarity {
		
		COMMON,
		RARE,
		LEGENDARY
		
	}

	//list of types in enum not including coins or consumables which are in other classes
	
	public enum Type {
		
		WEAPON,
		ARMOUR
		
	}
	
	
	public String getName() {
		
		return this.name;
		
	}
}