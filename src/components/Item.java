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

	int power;
	int defence;
	int bonusHealth;
	double critChance;
	double dodgeChance;


	Random random = new Random();

	String name;

	Rarity rarity;
	Type type;

	public Item() {
		chooseType();
		chooseRarity();
		genStats();
		makeName();
	}
	
	public void makeName() {
		if (type == Type.WEAPON) {
			if(rarity==Rarity.COMMON) {
				name = CWeapon[(int)(Math.random()*CWeapon.length)];
			}
			if(rarity==Rarity.RARE) {
				name = RWeapon[(int)(Math.random()*RWeapon.length)];
			}
			if(rarity==Rarity.LEGENDARY) {
				name = LWeapon[(int)(Math.random()*LWeapon.length)];
			}
		}
		if (type == Type.ARMOUR) {
			if(rarity==Rarity.COMMON) {
				name = CArmour[(int)(Math.random()*CArmour.length)];
			}
			if(rarity==Rarity.RARE) {
				name = RArmour[(int)(Math.random()*RArmour.length)];
			}
			if(rarity==Rarity.LEGENDARY) {
				name = LArmour[(int)(Math.random()*LArmour.length)];
			}
		}
	}

	public void chooseType() {
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

		/* TODO:
            Add stat generation based on rarity. Make sure to
            generate stats for weapons and armour differently
            ( i.e. armour should't give power and weapons
            shouldn't give armour )
		 */

		if (type == Type.WEAPON) {
			if (rarity == Rarity.COMMON) {
				power = (int)(Math.random()*3)+1;
				critChance =0;
			}
			if(rarity == Rarity.RARE) {
				power = (int)(Math.random()*5)+2;
				critChance = (Math.random()*0.2) +0.05;
			}
			if(rarity == Rarity.LEGENDARY) {
				power = (int)(Math.random()*7)+3;
				critChance= (Math.random()*0.5) +0.25;
			}
		}

		if (type == Type.ARMOUR) {
			if(rarity == Rarity.COMMON) {
				defence = (int)(Math.random()*1)+1;   
				bonusHealth = (int) (Math.random()*3)+1;
				dodgeChance=0;
			}
			if(rarity == Rarity.RARE) {
				defence = (int)(Math.random()*3)+1;
				bonusHealth = (int) (Math.random()*5)+2;
				if(Math.random()>=0.5){
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

	public enum Rarity {
		COMMON,
		RARE,
		LEGENDARY
	}

	public enum Type {
		WEAPON,
		ARMOUR

	}
	
	
	public String getName() {
		return this.name;
	}


}