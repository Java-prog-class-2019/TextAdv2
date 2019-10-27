package components;

import java.util.ArrayList;
import java.util.Random;

import components.Item.Rarity;
import components.Item.Type;

public class Shop {

	/***********************************/
	public class Buyable{	//Subclass. Each buyable is an item with an assigned price

		Item item;
		//		Consumable consumable;
		int price=0;

		public Buyable(Item item/*, Consumable consumable*/) {	//constructor
			this.item = item;
			//			this.consumable = consumable;
			if(item.type==Type.WEAPON) {
				price = item.power*2 + (int)(item.critChance*20);
			}
			if(item.type==Type.ARMOUR) {
				price = item.defence*2 + item.bonusHealth*2 + (int)(item.dodgeChance*10);
			}
		}
	}
	/***********************************/

	ArrayList<Buyable> shopItems = new ArrayList<Buyable>();
	Buyable a, b, c, d, e, f;
	Item weaponA = new Item();
	Item armourA = new Item();
	Item weaponB;
	Item armourB;

	//	Consumable a;
	//	Consumable b;
	//	if(Bonk.player.getCurrentRoomInt()!=17) {
	//	Consumable c;
	//	Consumable d;
	//	}
	Random random = new Random();

	public Shop() {	//constructor

		setWeapon(weaponA);
		a = new Buyable(weaponA);
		shopItems.add(a);

		setArmour(armourA);
		b = new Buyable(armourA);
		shopItems.add(b);

		if(Bonk.player.getCurrentRoomInt()==17) {
			weaponB = new Item();
			setWeapon(weaponB);
			c = new Buyable(weaponB);
			shopItems.add(c);
			
			armourB = new Item();
			setArmour(armourB);
			d = new Buyable(armourB);
			shopItems.add(d);
		}else {
			
		}

	}


	private void setWeapon(Item weapon){	//Sets the stats for the weapon
		weapon.type = Type.WEAPON;

		double chance = random.nextDouble();

		if(Bonk.player.getCurrentRoomInt()==5) {
			weapon.rarity = Rarity.COMMON;
			if (chance < 0.3) {
				weapon.rarity = Rarity.RARE;
			}

		}

		if(Bonk.player.getCurrentRoomInt()==11) {
			weapon.rarity = Rarity.COMMON;
			if (chance < 0.65) {
				weapon.rarity = Rarity.RARE;
				if (chance < 0.15) {
					weapon.rarity = Rarity.LEGENDARY;
				}
			}

		}


		if(Bonk.player.getCurrentRoomInt()==17) {
			weapon.rarity = Rarity.RARE;
			if (chance < 0.4) {
				weapon.rarity = Rarity.LEGENDARY;
			}


		}

		weapon.genStats();
		weapon.makeName();
	}

	private void setArmour(Item armour) {	//Sets the stats for the armour
		armour.type = Type.ARMOUR;

		double chance = random.nextDouble();

		if(Bonk.player.getCurrentRoomInt()==5) {
			armour.rarity = Rarity.COMMON;
			if (chance < 0.3) {
				armour.rarity = Rarity.RARE;
			}
		}

		if(Bonk.player.getCurrentRoomInt()==11) {
			armour.rarity = Rarity.COMMON;
			if (chance < 0.65) {
				armour.rarity = Rarity.RARE;
				if (chance < 0.15) {
					armour.rarity = Rarity.LEGENDARY;
				}
			}
		}

		if(Bonk.player.getCurrentRoomInt()==17) {
			armour.rarity = Rarity.RARE;
			if (chance < 0.4) {
				armour.rarity = Rarity.LEGENDARY;
			}
		}

		armour.genStats();
		armour.makeName();
	}

	public void printShop() {
		
		System.out.println("\t\t\t\t\t\t\t\t\t\t ___         ___   ___");
		System.out.println("\t\t\t\t\t\t\t\t\t\t/   \\ |   | /   \\ |   \\");
		System.out.println("\t\t\t\t\t\t\t\t\t\t\\___  |___| |   | |___/");
		System.out.println("\t\t\t\t\t\t\t\t\t\t    \\ |   | |   | |");
		System.out.println("\t\t\t\t\t\t\t\t\t\t\\___/ |   | \\___/ |");
		
		
		for(int i=0; i<184; i++) {
			System.out.print("-");
		}

		System.out.printf("%n|%-60d|%-60d|%-60d|", 1, 2, 3);


		System.out.printf("%n| %s %s:", a.item.rarity, a.item.type);
		for(int i=0; i<57 - a.item.rarity.toString().length() - a.item.type.toString().length(); i++) {
			System.out.print(" ");
		}
		System.out.printf("| %s %s:", b.item.rarity, b.item.type);
		for(int i=0; i<57 - b.item.rarity.toString().length() - b.item.type.toString().length(); i++) {
			System.out.print(" ");
		}
		System.out.println("|");
		//		System.out.printf("| %s %s:", c.item.rarity.toString(), c.item.type.toString());
		//		for(int i=0; i<60-c.item.rarity.toString().length() + c.item.type.toString().length(); i++) {
		//			System.out.print(" ");
		//		}


		System.out.printf("%n%s",a.item.getName());

		System.out.println();
		for(int i=0; i<184; i++) {
			System.out.print("-");
		}

		System.out.println();
		for(int i=0; i<184; i++) {
			System.out.print("-");
		}
	}
}

