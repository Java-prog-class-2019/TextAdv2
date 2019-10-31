package items;

import items.Item.Rarity;

public class Weapon extends Item {
	
	

	
	String CWeapon [] = {"A Dull Crayon", "A Paper Machet Sword", "Twin Blades", "A Scythe of Bad Fortune", "An Old Water Bottle","A Rusty Sword", "A Caveman's Club"};
	String RWeapon [] = {"The Shadow Blade", "The Scythe of Everlasting Power", "Slightly Glimmering Daggers", "A Nutty Axe of Cashews", "Prince Farnsword's Sabre", "A Serrated Dirk"};
	String LWeapon [] = {"A Stick", "A Sharp Crayon", "The Rapier of Drathaar", "The Assault Assegai of Astounding Aptitude", "The Super Sabre of Spite", "A Steel-Toed Boot", "A Havoc-inducing Halberd", "A Razor Scooter" };

	String WModifiers [] = {"Of Powerful Strikes", "Of Great Strikes", "Of Great Power", "Of Critical Damage" };


	public Weapon() {
		
		setType(Type.WEAPON);
		genStats();
		genName();
		
	}

	public void genName() {
		
		if(rarity == Rarity.COMMON) {
			this.setName(CWeapon[(int)(Math.random()*CWeapon.length)]);
		}

		if(rarity == Rarity.RARE && this.getCritChance() == 0) {
			this.setName(RWeapon[(int)(Math.random()*RWeapon.length)]);	
		}

		if(rarity == Rarity.RARE && this.getCritChance() > 0) {
			this.setName(RWeapon[(int)(Math.random()*RWeapon.length)] + WModifiers[(int)(Math.random()*WModifiers.length)]);

		}

		if(rarity == Rarity.LEGENDARY && this.getCritChance() == 0) {
			this.setName(LWeapon[(int)(Math.random()*LWeapon.length)]);		
		}

		if(rarity == Rarity.LEGENDARY && this.getCritChance() > 0) {
			this.setName(LWeapon[(int)(Math.random()*LWeapon.length)] + WModifiers[(int)(Math.random()*WModifiers.length)]); 
		}
	}
	
	public void genStats() {
		
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

}
