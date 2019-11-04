package components;

import java.util.ArrayList;
import java.util.Random;

import components.Item.ConsumableType;
import components.Item.Rarity;
import components.Item.Size;
import components.Item.Type;

public class Shop {

	/***********************************/
	public class Buyable{	//Subclass. Each buyable is an item with an assigned price

		Item item;
		int price=0;

		public Buyable(Item item) {	//constructor
			this.item = item;
			//			this.consumable = consumable;
			if(item.type==Type.WEAPON) {
				price = item.power*2 + (int)(item.critChance*20);
			}
			if(item.type==Type.ARMOUR) {
				price = item.defence*2 + item.bonusHealth*2 + (int)(item.dodgeChance*10);
			}
			if(item.type==Type.CONSUMABLE) {
				if(item.getSize()==Size.SMALL) price = 4;
				if(item.getSize()==Size.MEDIUM) price = 6;
				if(item.getSize()==Size.VENTI) price = 8;
			}
		}
	}
	/***********************************/

	ArrayList<Buyable> shopItems = new ArrayList<Buyable>();
	Buyable a, b, c, d, e, f;
	Item weaponA;
	Item armourA;
	Item weaponB;
	Item armourB;
	Item conA;
	Item conB;
	Item conC;
	Item conD;


	Random random = new Random();

	public Shop(int roomNum) {	//constructor

		weaponA = new Item(Type.WEAPON, setRarity(roomNum));
		a = new Buyable(weaponA);
		shopItems.add(a);

		armourA = new Item(Type.ARMOUR, setRarity(roomNum));
		b = new Buyable(armourA);
		shopItems.add(b);

		if(roomNum>=17) {
			weaponB = new Item(Type.WEAPON, setRarity(roomNum));
			c = new Buyable(weaponB);
			shopItems.add(c);

			armourB = new Item(Type.ARMOUR, setRarity(roomNum));
			d = new Buyable(armourB);
			shopItems.add(d);
		}else {
			conC = new Item(Type.CONSUMABLE, setRarity(roomNum));
			c = new Buyable(conC);
			shopItems.add(c);

			conD = new Item(Type.CONSUMABLE, setRarity(roomNum));
			d = new Buyable(conD);
			shopItems.add(d);
		}
		
		conA = new Item(Type.CONSUMABLE, setRarity(roomNum));
		e = new Buyable(conA);
		shopItems.add(e);
		
		conB = new Item(Type.CONSUMABLE, setRarity(roomNum));
		f = new Buyable(conB);
		shopItems.add(f);
	}


	private Rarity setRarity(int roomNum) {

		double chance = Math.random();

		if(roomNum == 5) {
			if (chance < 0.5) {
				return Rarity.COMMON;
			}else {
				return Rarity.RARE;
			}
		}

		if(roomNum == 11) {
			if(chance < 0.15) {
				return Rarity.LEGENDARY;
			}else if(chance >= 0.15 && chance < 0.65) {
				return Rarity.RARE;
			}else {
				return Rarity.COMMON;
			}
		}


		if(roomNum == 17) {
			if (chance < 0.6) {
				return Rarity.LEGENDARY;
			}else {
				return Rarity.RARE;
			}
		}

		return null;
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
						if(shopItems.get(i + j).item.type==Type.CONSUMABLE) {
							if(shopItems.get(i + j).item.con_type == ConsumableType.FORTITUDE) {
								System.out.printf("| %-59s", "Armour Bonus: " + shopItems.get(i + j).item.armour_bonus);
							}
							if(shopItems.get(i + j).item.con_type == ConsumableType.HEALTH) {
								System.out.printf("| %-59s", "Health Bonus: " + shopItems.get(i + j).item.health_bonus);
							}
							if(shopItems.get(i + j).item.con_type == ConsumableType.RAGE) {
								System.out.printf("| %-59s", "Crit Bonus: " + shopItems.get(i + j).item.crit_bonus);
							}
							if(shopItems.get(i + j).item.con_type == ConsumableType.STRENGTH) {
								System.out.printf("| %-59s", "Power Bonus: " + shopItems.get(i + j).item.power_bonus);
							}
							if(shopItems.get(i + j).item.con_type == ConsumableType.SWIFTNESS) {
								System.out.printf("| %-59s", "Dodge Bonus: " + shopItems.get(i + j).item.dodge_bonus);
							}
							if(shopItems.get(i + j).item.con_type == ConsumableType.UNKNOWN) {
								System.out.printf("| %-59s", "Unknown Effects");
							}
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
						if(shopItems.get(i + j).item.type==Type.CONSUMABLE) {
							System.out.printf("%-61c", '|');
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
						if(shopItems.get(i + j).item.type==Type.CONSUMABLE) {
							System.out.printf("%-61c", '|');
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

