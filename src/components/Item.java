package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Item {

	String CWeapon [] = {"Dull Crayon", "Paper Machet Sword", "Twin Blades", "Scythe of Bad Fortune", "Old Water Bottle","Rusty Sword", "Caveman's Club"};
	String RWeapon [] = {"Shadow Blade", "Powerful Scythe", "Slightly Glimmering Daggers", "Sir Cashwes Nutty Axe", "Prince Farnsword's Sabre", "Serrated Dirk"};
	String LWeapon [] = {"Stick", "Sharp Crayon", "Draathar Rapier", "Astoundingly Apt African Assegai", "Spiteful Super Sabre", "Steel Toed Boot", "Havoc-inducing Halberd", "Razor Scooter" };

	String CArmour [] = {"Chain Helmet", "Baseball Cap", "Old Hoodie", "Bear Mask", "Broken Chestplate", "Paper Bag"};
	String RArmour [] = {"Plate Mail", "Jarvan IV's Helm", "Sturdy Helm", "Clunky Boots", "Grayscale Teddy Fresh Colour Block Hoodie" };
	String LArmour [] = {"Kayle's Shining Armor", "Garens Great Garish Garments", "Crazy Zany Wavy Platey Mail", "Glistening Boots", "Shadow Mail"};

	String WNames [] = {"Of Powerful Strikes", "Of Great Strikes", "Of Great Power", "Of Critical Damage" };
	String ANames [] = {"Of Swiftness", "Of Speed", "With Dodging Capabilities", "Of Great Speed"};

	String Container_Names [] = {"Apple", "Orange", "Mixture", "Elixir", "Brew", "Tupperware Container", "Remedy", "Draught", "Potion"};

	// Stats for weapons.
	int power;
	double critChance;

	int defence;
	int bonusHealth;
	double dodgeChance;

	// Consumable stats
	int health_bonus;
	int power_bonus;
	int armour_bonus;
	double crit_bonus;
	double dodge_bonus;

	Random random = new Random();

	String name = "";

	Rarity rarity;
	Type type;
	Size size;
	ConsumableType con_type;


	public Item() {

		chooseType();
		chooseRarity();

		if(type == Type.CONSUMABLE) {

			chooseSize();
			generateEffect();
			genConsumeName();
			genConsumableStats();

		}

		if(type == Type.ARMOUR) {
			genArmourName();
			genStats();
		}

		if(type == Type.WEAPON) {
			genWeaponName();
			genStats();
		}


	}

	// Shop class constuctor! 
	public Item(Type type, Rarity rarity) {
		this.type = type;
		this.rarity = rarity;
		if(type == Type.CONSUMABLE) {

			chooseSize();
			generateEffect();
			genConsumeName();
			genConsumableStats();

		}

		if(type == Type.ARMOUR) {
			genArmourName();
			genStats();
		}

		if(type == Type.WEAPON) {
			genWeaponName();
			genStats();
		}

	}

	private void genConsumableStats() {

		if(size == Size.SMALL) {
			switch(con_type) {
			case HEALTH:
				health_bonus += 2;
				break;

			case FORTITUDE:
				armour_bonus += 2;		
				break;

			case UNKNOWN:
				health_bonus += -2;
				break;

			case STRENGTH:
				power_bonus += 2;
				break;

			case SWIFTNESS:
				// 10 percent increase for dodgeChance.
				dodge_bonus += 0.10;
				break;

			case RAGE:
				crit_bonus += 0.10;
				break;
			}

		}

		if(size == Size.MEDIUM) {

			switch(con_type) {
			case HEALTH:
				health_bonus += 2;
				break;

			case FORTITUDE:
				armour_bonus += 2;		
				break;

			case UNKNOWN:
				crit_bonus += -0.10;
				break;

			case STRENGTH:
				power_bonus += 2;
				break;

			case SWIFTNESS:
				// 30 percent increase for dodgeChance.
				dodge_bonus += 0.30;
				break;

			case RAGE:
				crit_bonus += 0.30;
				break;
			}

		}

		if(size == Size.VENTI) {

			switch(con_type) {
			case HEALTH:
				health_bonus += 2;
				break;

			case FORTITUDE:
				armour_bonus += 2;		
				break;

			case UNKNOWN:
				health_bonus += -2;
				break;

			case STRENGTH:
				power_bonus += 2;
				break;

			case SWIFTNESS:
				// 10 percent increase for dodgeChance.
				dodge_bonus += 0.10;
				break;

			case RAGE:
				crit_bonus += 0.10;
				break;
			}
		}
	}

	public void chooseType() {

		double chance = random.nextDouble();

		if ( chance >= 0.333) {
			type = Type.WEAPON;
		}
		if ( chance >= 0.666  && chance <= 0.333  ) {
			type = Type.ARMOUR;
		}
		if ( chance < 0.666) {
			type = Type.CONSUMABLE;
		}
	}

	public void chooseRarity() {

		double chance = random.nextDouble();

		if(chance < 1) {
			rarity = Rarity.LEGENDARY;
			if (chance < 0.5) {
				rarity = Rarity.RARE;
				if (chance < 0.15) {
					rarity = Rarity.COMMON;
				}
			}
		}
	}

	public void genStats() {

		if (type == Type.WEAPON) {
			if (rarity == Rarity.COMMON) {

				power = (int)(Math.random()*3)+1;
				critChance = 0;

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
				dodgeChance = 0;

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

	public void genWeaponName() {

		if(rarity == Rarity.COMMON) {
			name = CWeapon[(int)(Math.random()*CWeapon.length)];
		}
		if(rarity == Rarity.RARE && critChance ==0) {
			name = RWeapon[(int)(Math.random()*RWeapon.length)];		
		}
		if(rarity == Rarity.RARE && critChance > 0) {
			name = RWeapon[(int)(Math.random()*RWeapon.length)] + WNames[(int)(Math.random()*WNames.length)];

		}
		if(rarity == Rarity.LEGENDARY && critChance == 0) {
			name = LWeapon[(int)(Math.random()*LWeapon.length)];		
		}
		if(rarity == Rarity.LEGENDARY && critChance > 0) {
			name = LWeapon[(int)(Math.random()*LWeapon.length)] + WNames[(int)(Math.random()*WNames.length)];

		}
	}

	public void genArmourName() {

		if(rarity==Rarity.COMMON) {
			name = CArmour[(int)(Math.random()*CArmour.length)];
		}
		if(rarity==Rarity.RARE && dodgeChance ==0) {
			name = RArmour[(int)(Math.random()*RArmour.length)] ;
		}
		if(rarity==Rarity.RARE && dodgeChance > 0) {
			name = RArmour[(int)(Math.random()*RArmour.length)] + ANames[(int)(Math.random()*ANames.length)];
		}
		if(rarity==Rarity.LEGENDARY&& dodgeChance ==0) {
			name = LArmour[(int)(Math.random()*LArmour.length)] ;
		}
		if(rarity==Rarity.LEGENDARY&& dodgeChance > 0) {
			name = LArmour[(int)(Math.random()*LArmour.length)] + ANames[(int)(Math.random()*ANames.length)];
		}


	}

	public void genConsumeName() {



		switch(size){
		case SMALL:
			name += "Small ";
			break;

		case MEDIUM:
			name += "Medium ";
			break;

		case VENTI:
			name += "Venti ";
			break;

		}


		int rand_item = random.nextInt(Container_Names.length);

		name += Container_Names[rand_item] + " of ";

		switch(con_type) {

		case HEALTH:
			name += "Healing ";
			break;

		case FORTITUDE:
			name += "Fortifying ";
			break;

		case UNKNOWN:
			name += "Mysterious ";
			break;

		case STRENGTH:
			name += "Strengthening ";
			break;

		case SWIFTNESS:
			name += "Quickening ";
			break;

		case RAGE:
			name += "Enraging ";
			break;

		}



	}

	public void generateEffect() {

		int rand_type = random.nextInt(6);

		ArrayList<ConsumableType> consumabletypes = new ArrayList<ConsumableType>(Arrays.asList(ConsumableType.values()));

		con_type = consumabletypes.get(rand_type);

	}

	public void chooseSize() {

		double rand_double = random.nextDouble();

		if(rand_double > 0.5) {
			size = Size.SMALL;
		}

		if(rand_double > 0.2 && rand_double < 0.5) {
			size = Size.MEDIUM;
		}

		if(rand_double < 0.2) {
			size = Size.VENTI;
		}
	}






	public enum Rarity {
		COMMON,
		RARE,
		LEGENDARY
	}

	public enum Type {
		WEAPON,
		ARMOUR,
		CONSUMABLE
	}

	public enum ConsumableType {
		HEALTH,
		FORTITUDE,
		UNKNOWN,
		STRENGTH,
		SWIFTNESS,
		RAGE
	}

	enum Size {
		SMALL,
		MEDIUM,
		VENTI

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

	public Size getSize() {
		return size;
	}






}