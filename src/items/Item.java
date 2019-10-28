package items;

import java.lang.reflect.Array;
import java.util.Random;

import components.Bonk;

public class Item {

	

	//Weapon descriptor names
	
	// Custom enums for rarity and armour/weapon types.
	Rarity rarity;
	Type type;

	private int power;
	private int defence;
	private int bonusHealth;
	
	private double critChance;
	private double dodgeChance;
	
	private String name;


	Random random = new Random();

	
	
	
	// Item Constructor
	public Item() {
		chooseRarity();
		genStats();
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
		
		if (Bonk.player.getCurrentRoomObj().getTitle().equals("great hall")) {
			if(chance >= 0.8) {
				rarity = rarity.RARE;
			}
			else rarity = rarity.COMMON;
		}
		if (Bonk.player.getCurrentRoomObj().getTitle().equals("kitchen")) {
			if(chance >= 0.2) {
				rarity = rarity.RARE;
			}
			else rarity = rarity.LEGENDARY;
		}
		if (Bonk.player.getCurrentRoomObj().getTitle().equals("backyard")) {
			if(chance >= 0.375) {
				rarity = rarity.RARE;
			}
			else rarity = rarity.LEGENDARY;
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

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getBonusHealth() {
		return bonusHealth;
	}

	public void setBonusHealth(int bonusHealth) {
		this.bonusHealth = bonusHealth;
	}

	public double getCritChance() {
		return critChance;
	}

	public void setCritChance(double critChance) {
		this.critChance = critChance;
	}

	public double getDodgeChance() {
		return dodgeChance;
	}

	public void setDodgeChance(double dodgeChance) {
		this.dodgeChance = dodgeChance;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}