package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Item {

	String CWeapon [] = {"A Dull Crayon", "A Paper Machet Sword", "Twin Blades", "A Scythe of Bad Fortune", "An Old Water Bottle","A Rusty Sword", "A Caveman's Club"};
	String RWeapon [] = {"The Shadow Blade", "The Scythe of Everlasting Power", "Slightly Glimmering Daggers", "A Nutty Axe of Cashews", "Prince Farnsword's Sabre", "A Serrated Dirk"};
	String LWeapon [] = {"A Stick", "A Sharp Crayon", "The Rapier of Drathaar", "The Astounding Apt Assault Assegai", "The Super Sabre of Spite", "A Steel-Toed Boot", "A Havoc-inducing Halberd", "A Razor Scooter" };

	String CArmour [] = {"A Chain Helmet", "A Baseball Cap", "An Old Hoodie", "A Bear Mask", "A Broken Chestplate", "A Brown Paper Bag"};
	String RArmour [] = {"Plate Mail", "Jarvan IV's Helm", "A Sturdy Helm", "Clunky Boots", "A Grayscale Teddy Fresh Colour Block Hoodie" };
	String LArmour [] = {"Kayle's Shining Armor", "The Legendary Helm of Greatness", "A Crazy Zany Wavy Plate", "Glistening Boots", "Shadow Mail"};


	String WNames [] = {"Of Powerful Strikes", "Of Great Strikes", "Of Great Power", "Of Critical Damage" };
	String ANames [] = {"Of Swiftness", "Of Speed", "With Dodging Capabilities", "Of Great Speed"};

	String Container_Names [] = {"Apple", "Orange", "Mixture", "Elixir", "Brew", "Tupperware Container", "Remedy", "Draught", "Potion"};
  
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


	
	// Item Constructor
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
				health_bonus += 3;
				break;

			case FORTITUDE:
				armour_bonus += 3;		
				break;

			case UNKNOWN:
				crit_bonus += -0.10;
				break;

			case STRENGTH:
				power_bonus += 3;
				break;

			case SWIFTNESS:
				// 20 percent increase for dodgeChance.
				dodge_bonus += 0.20;
				break;

			case RAGE:
				crit_bonus += 0.20;
				break;
			}

		}

		if(size == Size.VENTI) {

			switch(con_type) {
			case HEALTH:
				health_bonus += 4;
				break;

			case FORTITUDE:
				armour_bonus += 4;		
				break;

			case UNKNOWN:
				health_bonus += -2;
				break;

			case STRENGTH:
				power_bonus += 4;
				break;

			case SWIFTNESS:
				// 10 percent increase for dodgeChance.
				dodge_bonus += 0.30;
				break;

			case RAGE:
				crit_bonus += 0.30;
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
		
		if (type == Type.ARMOUR) {
			if(rarity==Rarity.COMMON) {
				name = CArmour[(int)(Math.random()*CArmour.length)];
			}
			
			if(rarity == Rarity.RARE && dodgeChance ==0) {
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
	}
	
	public void printItem(){	//Prints out the item name along with important stats
		String tempNames[] = name.split(" ");
		ArrayList<String> nameList = new ArrayList<String>(Arrays.asList(tempNames));
		if(nameList.get(0).equals("A") || nameList.get(0).equals("An") || nameList.get(0).equals("The")) {
			nameList.remove(0);
		}
		
		System.out.print("\n" + rarity + " " + type + ": ");
		for(String s:nameList) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		if(type == Type.WEAPON) {
			System.out.printf("Power:\t\t%d\n",power);
			System.out.printf("Crit Chance:\t%d%%\n",(int)(critChance*100));
		}
		if(type == Type.ARMOUR) {
			System.out.printf("Defence:\t%d\n",defence);
			System.out.printf("Bonus Health:\t%d\n",bonusHealth);
			System.out.printf("Dodge chance:\t%d%%\n",(int)(dodgeChance*100));
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