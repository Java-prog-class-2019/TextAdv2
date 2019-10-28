package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import components.Item.Type;

public class Player {

	String name;
	private int currentRoom;						//integer value of the current room
	ArrayList<Item> inv = new ArrayList<Item>();	//inventory
	private int coins = 0;
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

	public void applyStats(Item item) {
		dodgeChance += item.dodgeChance;
		critChance += item.critChance;
		power += item.power;
		armour += item.power;

	}

	public void removeStats(Item item) {
		dodgeChance -= item.dodgeChance;
		critChance -= item.critChance;
		power -= item.power;
		armour -= item.defence;

	}

	public String getCommand() {	//uses scanner to get command

		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		if(text.length() == 0) text = "QwErTy";
		return text;

	}

	public boolean parseCommand(String text) {	//Language parser

		text = text.toLowerCase().trim();
		text.replace("pick up", "pickup");

		String words[] = text.split(" ");

		ArrayList<String> wordlist = new ArrayList<String>(Arrays.asList(words));


		String word1 = wordlist.get(0);
		String word2 = "";


		if (wordlist.size() > 1) {
			word2 = wordlist.get(1);
		}

		switch (word1) {

		case ("help"):
			System.out.println("List of commands: help, pickup, equip <1, 2, 3, etc.>, search, move <n, w, e, s>, etc.");
		break;
		case ("shop"):
			Bonk.player.getCurrentRoomObj().shop.printShop();
		break;
		case ("move"):
			move(word2);
		break;
		case ("inv"): case("i"): case("inventory"):
			printInv();
		break;
		case ("pickup"):
			pickup();
		case ("say"):
			System.out.println(word2);
		break;
		case ("search"):
			searchRoom();
		break;
		case ("equip"):
			equip(word2);
		break;
		case("n"): case("north"): case("e"): case("east"): case("s"): case("south"): case("w"): case("west"):
			move(word1);
		break;

		default: 
			System.out.println("What?!");

		}
		return false;
	}



	public void move(String dir) {	
		//moves player. First checks if specified movement direction is possible,
		//then either changes the current room, or prints an error message

		switch(dir) {

		case("n"): case("north"):
			if(currentRoom==18) {
				Bonk.win=true;
				break;
			}
		if(currentRoom%6==5) {
			System.out.println("You can't go that way!");
			break;
		}else {
			currentRoom+=2;
			Bonk.enterRoom();
			break;
		}

		case("e"): case("east"):
			if(currentRoom%2==0) {
				System.out.println("You can't go that way!");
				break;
			}else {
				currentRoom--;
				Bonk.enterRoom();
				break;
			}

		case("s"): case("south"):
			if(currentRoom%6==1 || currentRoom==0) {
				System.out.println("You can't go that way!");   
				break; 				
			}else {
				currentRoom-=2;
				Bonk.enterRoom();
				break;
			}

		case("w"): case("west"):
			if(currentRoom%2==1) {
				System.out.println("You can't go that way!");
				break;
			}else {
				currentRoom++;
				Bonk.enterRoom();
				break;
			}

		default: 
			System.out.println("What?!");	
			break;
		}

	}

	public void searchRoom() {    	
		System.out.println("\n" + Bonk.rooms.get(Bonk.player.getCurrentRoomInt()).getDescription());
	}

	public void printInv() {	//prints out inventory as a vertical list

		if(currentWeapon==null && currentArmour==null) {
			System.out.println("Nothing Equipped.");
		}
		if(currentWeapon!=null) {
			System.out.println("Current Weapon = " + currentWeapon.name);
		}
		if(currentArmour!=null) {
			System.out.println("Current Armour = " + currentArmour.name);
		}
		
		if(inv.size() == 0) {
			System.out.println("\nEmpty Inventory.");
		}else {
			System.out.println("\nInventory:");
		}

		for(int i = 0; i < inv.size(); i++) {
			System.out.printf(i+1 + ". %s (%s)%n", inv.get(i).getName(), inv.get(i).type.toString());
		}

	}


	public void pickup() {	//picks up item



		if ( getCurrentRoomObj().getIsItem() ) {	//makes sure room has an item

			pickupItem(getCurrentRoomObj().item);	//adds item to inventory

			System.out.print("You pick up ");		//pickup message		
			System.out.println(getCurrentRoomObj().item.name);	
			getCurrentRoomObj().item.printItem();

			getCurrentRoomObj().setItem(false);		//removes the ite4m from the room	
		}else {
			System.out.println("There is nothing to pick up.");
		}
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
				if(currentArmour==null) {
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
	public void setCurrentRoom(int currentRoom) {
		this.currentRoom = currentRoom;
	}

	public Room getCurrentRoomObj() {
		return Bonk.rooms.get(currentRoom);
	}

	public int getCurrentRoomInt() {
		return currentRoom;
	}

	public void setCoins(int coins) {
		this.coins=coins;
	}

	public int getCoins() {
		return coins;
	}
	/***************************************************/
}