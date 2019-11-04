package components;

import java.util.ArrayList;
import java.util.Random;

import components.Item.Rarity;
import components.Item.Type;

public class Shop {

	/***********************************/
	public class Buyable{	//Subclass. Each buyable is an item with an assigned price

		Item item;
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
	Item conA = new Item();
	Item conB = new Item();
	Item conC;
	Item conD;


	Random random = new Random();

	public Shop(int roomNum) {	//constructor

		setWeapon(weaponA);
		a = new Buyable(weaponA);
		shopItems.add(a);

		setArmour(armourA);
		b = new Buyable(armourA);
		shopItems.add(b);

		if(roomNum>=17) {
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
			if (chance < 0.5) {
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
		weapon.genWeaponName();
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
		armour.genArmourName();
	}


	public void buy(String s){
		int index = Integer.parseInt(s) - 1;
		if(index>=shopItems.size()) {
			System.out.println("That's not available.");
		}else {
			if(Bonk.player.getCoins()>=shopItems.get(index).price) {
				System.out.println("You bought " + shopItems.get(index).item.name + ". Type \"shop\" to continue shopping.");
				Bonk.player.setCoins(Bonk.player.getCoins()-shopItems.get(index).price);
				Bonk.player.inv.add(shopItems.get(index).item);
				shopItems.remove(index);
			}else {
				System.out.println("You can not afford that.");
			}
		}
	}

	public void printShop() {	//Prints out the contents of the shop in a neat grid, line by line

		if(shopItems.size()==0) {
			System.out.println("There's nothing for sale.");
		}else {

			System.out.println("\t\t\t\t\t\t\t\t\t\t ___         ___   ___");
			System.out.println("\t\t\t\t\t\t\t\t\t\t/   \\ |   | /   \\ |   \\");
			System.out.println("\t\t\t\t\t\t\t\t\t\t\\___  |___| |   | |___/");
			System.out.println("\t\t\t\t\t\t\t\t\t\t    \\ |   | |   | |");
			System.out.println("\t\t\t\t\t\t\t\t\t\t\\___/ |   | \\___/ |");


			for(int i=0; i<184; i++) {
				System.out.print("_");
			}
			System.out.println();

			for(int j = 0; j < 4; j+=3) {
				
				//Line 1
				System.out.printf("|%-60s|%-60s|%-60s|\n", 1 + j + ".", 2 + j + ".", 3 + j + ".");	

				//Line 2
				for(int i=0; i<3; i++) {
					if(shopItems.size() > i + j) {
						System.out.printf("| %-59s", shopItems.get(i + j).item.rarity.toString() + " " + shopItems.get(i + j).item.type.toString() + ":");
					}else {
						System.out.printf("%-61c", '|');
					}
					if(i == 2)System.out.println("|");
				}


				//Line 3
				for(int i=0; i<3; i++) {
					if(shopItems.size() > i + j) {
						System.out.printf("| %-59s", shopItems.get(i + j).item.name);
					}else {
						System.out.printf("%-61c", '|');
					}
					if(i == 2)System.out.println("|");
				}

				//Line 4
				for(int i=0; i<3; i++) {
					if(shopItems.size() > i + j) {
						if(shopItems.get(i + j).item.type==Type.WEAPON) {
							System.out.printf("| %-59s", "Power: " + shopItems.get(i + j).item.power);
						}
						if(shopItems.get(i + j).item.type==Type.ARMOUR) {
							System.out.printf("| %-59s", "Defence: " + shopItems.get(i + j).item.defence);
						}
					}else {
						System.out.printf("%-61c", '|');
					}
					if(i == 2)System.out.println("|");
				}

				//Line 5
				for(int i=0; i<3; i++) {
					if(shopItems.size() > i + j) {
						if(shopItems.get(i + j).item.type==Type.WEAPON) {
							System.out.printf("| %-59s", "Crit Chance: " + shopItems.get(i + j).item.critChance * 100 + "%");
						}
						if(shopItems.get(i + j).item.type==Type.ARMOUR) {
							System.out.printf("| %-59s", "Bonus Health: " + shopItems.get(i + j).item.bonusHealth);
						}
					}else {
						System.out.printf("%-61c", '|');
					}
					if(i == 2)System.out.println("|");
				}

				//Line 6
				for(int i=0; i<3; i++) {
					if(shopItems.size() > i + j) {
						if(shopItems.get(i + j).item.type==Type.WEAPON) {
							System.out.printf("%-61c", '|');
						}
						if(shopItems.get(i + j).item.type==Type.ARMOUR) {
							System.out.printf("| %-59s", "Dodge Chance: " + shopItems.get(i + j).item.dodgeChance * 100 + "%");
						}
					}else {
						System.out.printf("%-61c", '|');
					}
					if(i == 2)System.out.println("|");
				}

				//Line 7
				System.out.printf("|%61c%61c%61c\n", '|', '|', '|');

				//Line 8
				for(int i=0; i<3; i++) {
					if(shopItems.size() > i + j) {
						System.out.printf("| %29s%-30s", "Price: ", shopItems.get(i + j).price + " coins");
					}else {
						System.out.printf("%-61c", '|');
					}
					if(i == 2)System.out.println("|");
				}

				//Bottom Line
				for(int i = 0; i<3 ; i++) {
					System.out.print("|");
					for(int k=0; k<60; k++) {
						System.out.print("_");
					}
				}
				System.out.println("|");
			}
			System.out.println("Coins: " + Bonk.player.getCoins());
		}
	}
}

