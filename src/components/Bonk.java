package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import components.Item.ConsumableType;
import components.Item.Type;

public class Bonk {

	//Objects
	static Player player = new Player();
	public static ArrayList<Room> rooms = new ArrayList<Room>(); //List of all the rooms in the game

	// Global Variables
	boolean playerTurn;
	private int currentRoom;	//integer value of the current room
	static boolean alive = true;
	static boolean win = false;
	static boolean isMob = true;		//Is there a (living) enemy in the room?



	public static void main(String[] args) { 
		new Bonk(); 
	}


	Bonk() {	// Constructor

		init();

		// Main game loop

		while(true) {
			while(playerTurn) {
				String command = getCommand();
				this.parseCommand(command);
				if(!alive) {	// Death message
					System.out.println("You died! :(\nGame Over");
					System.exit(0);
				}
				if(win) {	// Player 
					System.out.println("CONGRATULATIONS!\nYou have escaped and won the game!");
					System.exit(0);
				}
			}
		}
	}



	public void init() {	//Initialization method. Sets up the game

		setupRooms();
		setCurrentRoom(0); //starting room
		System.out.println("You have awoken in the great hall of a haunted mansion. You must explore and fight your way out!\n\nWelcome to Bonk! Type 'help' for a list of commands \n");	//Starting text
		enterRoom();

		playerTurn = true;
	}


	public String getCommand() {	//uses scanner to get command

		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		if(text.length() == 0) text = "QwErTy";
		return text;

	}

	public boolean parseCommand(String text) {	//Language parser

		text = text.toLowerCase().trim();

		String words[] = text.split(" ");

		ArrayList<String> wordlist = new ArrayList<String>(Arrays.asList(words));


		String word1 = wordlist.get(0);
		String word2 = "";
		


		if (wordlist.size() > 1) {
			word2 = wordlist.get(1);
		}
		
		if(word1.equals("pick") && word2.equals("up")) word1 = "pickup";

		switch (word1) {	//Switch case statement to determine what action to perform based on the first one or two words in the command

		case ("help"):	//Help prints out a list of basic commands
			System.out.println("List of commands: help, move <n, w, e, s>, pickup and search");
		break;

		case("buy"):	//Buys an item from the shop
			if(getCurrentRoomObj().isShop) {
				if (word2 == "") {
					System.out.println("Lemme know what you wanna buy...");
					break;
				}else {
					getCurrentRoomObj().shop.buy(word2);
					break;
				}
			}else {
				System.out.println("There's no shop here...");
				break;
			}

		case ("shop"):	//Displays the shop and its contents
			if(getCurrentRoomObj().isShop) {
				getCurrentRoomObj().shop.printShop();
			}else {
				System.out.println("There's no shop here...");
			}
		break;

		case ("move"):	//Moves the player to a different room
			if(isMob) {
				System.out.println("Nah. Don't even try that on us, who do you think we are?");
				break;
			}
			else {
				move(word2);
				break;
			}

		case ("inv"): case("i"): case("inventory"):	//Displays the player's inventory
			printInv();
		break;

		case ("pickup"):	//Picks up the item from the current room, if there is one
			pickup();
		break;

		case ("say"):	//Prints whatever the user types
			for(int i = 1; i < wordlist.size(); i++) {
				System.out.print(wordlist.get(i) + " ");
			}
		break;

		case ("search"):	//Re-prints room description
			searchRoom();
		break;

		case("n"): case("north"): case("e"): case("east"): case("s"): case("south"): case("w"): case("west"):	//Moves the player to a different room
			if(isMob) {
				// If there is still a mob in the room, you aren't allowed to move.
				System.out.println("Nah. Don't even try that on us, who do you think we are?");
				break;
			}
			else {

				move(word1);
				break;

			}

		case("attack"): case("strike"): case("hit"): case("smash"):	//Attacks the mob in the player's current room
			if (getCurrentRoomObj().mob.health > 0) {
				player.attack(playerTurn, rooms.get(getCurrentRoomInt()).mob);
			}
			else {
				System.out.println("There is no mob here to attack");
			}
		break;
		case("consume"): case("eat"): case("drink"): case("use"):	//Uses consumable
			consume(word2);
		break;

		case("equip"):	//equips item from inventory
			if(word2 == "") {
				System.out.println("Nuh-uh. You've gotta type equip, then a number.");
			}else {
				equip(word2);
			}
		break;
		default: 
			System.out.println("What?!");	//Default statement prints any time the command is not recognized or supported
			break;
		}
		return false;
	}


	private void consume(String word2) {	//Consumes item from inventory
		int index = Integer.parseInt(word2)-1;
		if(player.inv.get(index).getType() == Type.CONSUMABLE) {
			ConsumableType consumetype = player.inv.get(index).getConsumeType();
			switch(consumetype) {
				case HEALTH:
					player.health += player.inv.get(index).health_bonus;
					System.out.println("You consumed the " + player.inv.get(index).name);
					player.inv.remove(index);
					break;
					
				case FORTITUDE:
					player.armour += player.inv.get(index).armour_bonus;
					System.out.println("You consumed the " + player.inv.get(index).name);
					player.inv.remove(index);
					break;
					
				case UNKNOWN:
					player.health += player.inv.get(index).health_bonus;
					System.out.println("You consumed the " + player.inv.get(index).name);
					player.inv.remove(index);
					break;
					
				case STRENGTH:
					player.power += player.inv.get(index).power_bonus;
					System.out.println("You consumed the " + player.inv.get(index).name);
					player.inv.remove(index);
					break;
					
				case RAGE:
					player.critChance += player.inv.get(index).crit_bonus;
					System.out.println("You consumed the " + player.inv.get(index).name);
					player.inv.remove(index);
					break;
					
				case SWIFTNESS:
					player.dodgeChance += player.inv.get(index).dodge_bonus;
					System.out.println("You consumed the " + player.inv.get(index).name);
					player.inv.remove(index);
					break;
					
				default:
					System.out.println("Cannot consume that...");
			}
		}
	}

	public void equip(String item){	//Equips item
		for(char a : item.toCharArray()) {	//This loop makes sure the player has entered a number
			if(a < 48 || a > 57) {
				System.out.println("Nuh-uh. You've gotta type equip, then an appropriate number.");
				return;
			}
		}
		int index = Integer.parseInt(item) - 1;	//integer value of the item to be equipped
		if(player.inv.size() > index && index > -1) {	//Makes sure index is a valid value
			if(player.inv.get(index).type == Type.WEAPON) {	//Checks item type, and if one is already equipped. Removes old item and equips new one.
				if(player.currentWeapon == null) {

					System.out.println("You equipped " + player.inv.get(index).name + ".");
					player.currentWeapon = player.inv.get(index);
					player.applyStats(player.currentWeapon);
					player.inv.remove(player.inv.get(index));
					return;

				} else {

					System.out.println("You equipped " + player.inv.get(index).name + ".");
					player.removeStats(player.currentWeapon);
					player.inv.add(player.currentWeapon);
					player.currentWeapon=player.inv.get(index);
					player.applyStats(player.currentWeapon);
					player.inv.remove(player.inv.get(index));
					return;

				}
			}

			if(player.inv.get(index).type == Type.ARMOUR){

				if(player.currentArmour == null) {

					System.out.println("You equipped " + player.inv.get(index).name + ".");
					player.currentArmour = player.inv.get(index);
					player.applyStats(player.currentArmour);
					player.inv.remove(player.inv.get(index));
					return;

				} else {

					System.out.println("You equipped " + player.inv.get(index).name + ".");
					player.removeStats(player.currentArmour);
					player.inv.add(player.currentArmour);
					player.currentArmour=player.inv.get(index);
					player.applyStats(player.currentArmour);
					player.inv.remove(player.inv.get(index));
					return;

				}
			}

			if(player.inv.get(index).type == Type.CONSUMABLE){

				System.out.println("You can't equip consumables.");

			}
		}else {

			System.out.println("You can't do that.");

		}
	}

	public void move(String dir) {	

		/* moves player. First checks if specified movement direction is possible,
		 then either changes the current room, or prints an error message*/

		switch(dir) {

		case("n"): case("north"):
			if(currentRoom == 18) {

				Bonk.win=true;
				break;

			}
		if(currentRoom % 6 == 5) {

			System.out.println("You can't go that way!");
			break;

		} else {

			currentRoom += 2;
			enterRoom();
			break;

		}

		case("e"): case("east"):
			if(currentRoom % 2 == 0) {

				System.out.println("You can't go that way!");
				break;

			} else {

				currentRoom--;
				enterRoom();
				break;

			}

		case("s"): case("south"):
			if(currentRoom % 6 == 1 || currentRoom == 0) {

				System.out.println("You can't go that way!");   
				break;

			} else {

				currentRoom -= 2;
				enterRoom();
				break;

			}

		case("w"): case("west"):
			if(currentRoom % 2 == 1) {

				System.out.println("You can't go that way!");
				break;

			} else {

				currentRoom++;
				enterRoom();
				break;

			}

		default: 

			System.out.println("You gotta be more specific...");	
			break;

		}


		if (rooms.get(currentRoom).mob.health > 0) {

			isMob = true;

		}
	}


	public void searchRoom() {   //Prints room description
		System.out.println("\n" + rooms.get(getCurrentRoomInt()).getDescription());
	}

	public void printInv() {	//prints out inventory as a vertical list
		//Coins
		System.out.println("\n" + player.getCoins() + " coins.\n");

		//Equipped Items
		if(player.currentWeapon == null && player.currentArmour == null) {
			System.out.println("Nothing Equipped.");
		}
		if(player.currentWeapon != null) {
			System.out.println("Current Weapon = " + player.currentWeapon.name);
		}
		if(player.currentArmour != null) {
			System.out.println("Current Armour = " + player.currentArmour.name);
		}
		//stats print
		System.out.println("Power: " + player.power);
		System.out.println("Armour: " + player.armour);
		System.out.println("Health: " + player.health);
		System.out.println("Dodge Chance: " + player.dodgeChance);
		System.out.println("Crit Chance: " + player.critChance);
		//Equipped Items
		if(player.currentWeapon==null && player.currentArmour==null) {
			System.out.println("\nNothing Equipped.");
		}

		//Other Items
		if(player.inv.size() == 0) {
			System.out.println("\nEmpty Inventory.");
		}else {
			for(int i = 0; i < player.inv.size(); i++) {
				System.out.printf(i+1 + ". %s (%s)%n", player.inv.get(i).getName(), player.inv.get(i).type.toString());
			}
		}
	}

	public void pickup() {	//picks up item
		if ( getCurrentRoomObj().getIsItem() ) {	//makes sure room has an item

			player.inv.add(getCurrentRoomObj().item);	//adds item to inventory

			System.out.print("You pick up ");		//pickup message		
			System.out.println(getCurrentRoomObj().item.name);	
			getCurrentRoomObj().item.printItem();

			getCurrentRoomObj().setItem(false);		//removes the item from the room	
		}else {
			System.out.println("There is nothing to pick up.");
		}
	}


	void enterRoom() {

		// Print Title and description of the entered room.
		String title = rooms.get(getCurrentRoomInt()).getTitle();
		System.out.println();
		for(int i=0; i < title.length()+4; i++) {			
			System.out.print("-");
		}

		System.out.println("\n| "+ title + " |");

		for(int i=0; i < title.length()+4; i++) {			
			System.out.print("-");			
		}

		System.out.println("\n" + rooms.get(getCurrentRoomInt()).getDescription());

	}

	void setupRooms() {

		for(int i = 0; i < 19; i++) {	//Creates the rooms and adds them to an ArrayList		
			rooms.add(new Room(i));		

			if(rooms.get(i).roomType.equals("great hall")) {
				playerTurn = true;
				rooms.get(i).mob = new MobGH();
				rooms.get(i).mob.type = MobGH.names[i];
				rooms.get(i).isMob = true;
				rooms.get(i).descrMob = ("\nA " + rooms.get(i).mob.type + " with " + rooms.get(i).mob.health + " health is out to get you, what will you do?");			
			}

			if(rooms.get(i).roomType.equals("kitchen")) {
				playerTurn = true;
				rooms.get(i).mob = new MobK();
				rooms.get(i).mob.type = MobK.names[i-6];
				rooms.get(i).isMob = true;
				rooms.get(i).descrMob = ("\nA " + rooms.get(i).mob.type + " with " + rooms.get(i).mob.health + " health is out to get you, what will you do?");	
			}

			if(rooms.get(i).roomType.equals("backyard")) {
				playerTurn = true;
				rooms.get(i).mob = new MobBY();
				rooms.get(i).mob.type = MobBY.names[i-12];
				rooms.get(i).isMob = true;
				rooms.get(i).descrMob = ("\nA " + rooms.get(i).mob.type + " with " + rooms.get(i).mob.health + " health is out to get you, what will you do?");	
			}
		}

		rooms.get((int)(Math.random()*5)).setItem(true);
		rooms.get((int)(Math.random()*5)+6).setItem(true);
		rooms.get((int)(Math.random()*5)+12).setItem(true);
	}


	/*******getters and setters*************************/ 
	public void setCurrentRoom(int currentRoom) {
		this.currentRoom = currentRoom;
	}

	public Room getCurrentRoomObj() {
		return rooms.get(currentRoom);
	}

	public int getCurrentRoomInt() {
		return currentRoom;
	}

	public boolean getIsMob() {
		return isMob;
	}

	public static void setIsAlive (boolean isAlive) {
		alive = isAlive;
	}

}
