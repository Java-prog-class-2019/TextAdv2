package components;


import components.Item.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Bonk {

	//Objects
	Player player = new Player();
	public ArrayList<Room> rooms = new ArrayList<Room>();

	// Global Variables
	boolean playerTurn;
	boolean systemTurn;
	private int currentRoom;	//integer value of the current room
	boolean alive = true;
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

			}

			while(systemTurn) {


			}

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



	public void init() {

		setupRooms();
		setCurrentRoom(0); //starting room
		System.out.println("You have awoken in the great hall of a haunted mansion. You must explore and fight your way out!\n\nWelcome to Bonk! Type 'help' for a list of commands \n");
		enterRoom();

		playerTurn = true;
		systemTurn = false;

	}


	public void chooseAction() {
		if (playerTurn == true) {

		}
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
			System.out.println("List of commands: help, move <n, w, e, s>, pickup <item> and search");
		break;
		case ("shop"):
			//	Bonk.player.getCurrentRoomObj().shop.printShop();
			break;
		case ("move"):
			if(isMob) {
				System.out.println("Nah. Don't even try that on us, who do you think we are?");
			}
			else {
				move(word2);
			}
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

		case("n"):case("north"):case("e"):case("east"):case("s"):case("south"):case("w"):case("west"):
			if(isMob) {
				System.out.println("Nah. Don't even try that on us, who do you think we are?");
			}
			else {
				move(word1);
			}
		break;
		case("attack"): case("strike"): case("hit"): case("smash"):
			if (getCurrentRoomObj().mob.health > 0) {
				player.attack(playerTurn, rooms.get(getCurrentRoomInt()).mob);
			}
			else {
				System.out.println("There is no mob here to attack");
			}
		break;


		default: 
			System.out.println("What?!");

		}
		return false;
	}



	public void move(String dir) {	
		// moves player. First checks if specified movement direction is possible,
		// then either changes the current room, or prints an error message

		switch(dir) {

		case("n"): case("north"):
			if(currentRoom == 18) {
				Bonk.win=true;
				break;
			}
		if(currentRoom % 6 == 5) {
			System.out.println("You can't go that way!");
			break;
		}else {
			currentRoom += 2;
			enterRoom();
			break;
		}

		case("e"): case("east"):
			if(currentRoom % 2 == 0) {
				System.out.println("You can't go that way!");
				break;
			}else {
				currentRoom--;
				enterRoom();
				break;
			}

		case("s"): case("south"):
			if(currentRoom % 6 == 1 || currentRoom == 0) {
				System.out.println("You can't go that way!");   
				break; 				
			}else {
				currentRoom -= 2;
				enterRoom();
				break;
			}

		case("w"): case("west"):
			if(currentRoom % 2 == 1) {
				System.out.println("You can't go that way!");
				break;
			}else {
				currentRoom++;
				enterRoom();
				break;
			}

		default: 
			System.out.println("What?!");	
			break;
		}
		if (Bonk.rooms.get(currentRoom).mob != null) {
		isMob = true;
		}
	}
	
	public void searchRoom() {





	}

	public void printInv() {	//prints out inventory as a vertical list

		if(player.inv.size() == 0) {
			System.out.println("Empty Inventory!");
		}

		for(int i = 0; i < player.inv.size(); i++) {
			System.out.printf("- %s%n", player.inv.get(i).getName());
		}

	}

	public void pickup() {	//picks up item
		if ( getCurrentRoomObj().getIsItem() ) {	//makes sure room has an item

			player.inv.add(getCurrentRoomObj().item);	//adds item to inventory

			System.out.print("You pick up ");		//pickup message		
			System.out.println(getCurrentRoomObj().item.name);	
			getCurrentRoomObj().item.printItem();

			getCurrentRoomObj().setItem(false);		//removes the ite4m from the room	
		}else {
			System.out.println("There is nothing to pick up.");
		}
	}

	//what calls this method?
	void enterRoom(){
		

		// Print Title of the entered room.
		String title = rooms.get(getCurrentRoomInt()).getTitle();

		System.out.println();
		for(int i=0; i < title.length()+4; i++) {			
			System.out.print("-");
		}

		System.out.println("\n| "+ title + " |");

		for(int i=0; i < title.length()+4; i++) {			
			System.out.print("-");			
		}

		System.out.println("\n"+rooms.get(getCurrentRoomInt()).getDescription());

	}
	void setupRooms() {

		for(int i=0; i<19;i++) {	//Creates the rooms and adds them to an ArrayList		
			rooms.add(new Room(i));		

			if(rooms.get(i).roomType.equals("great hall")) {
				playerTurn = true;
				rooms.get(i).mob = new MobGH();
				rooms.get(i).mob.type = MobGH.names[i];				
				rooms.get(i).description += ("\nA " + rooms.get(i).mob.type + " with " + rooms.get(i).mob.health + " health is out to get you, what will you do?");			
			}

			if(rooms.get(i).roomType.equals("kitchen")) {
				playerTurn = true;
				rooms.get(i).mob = new MobK();
				rooms.get(i).mob.type = MobK.names[i-6];
				rooms.get(i).description += ("\nA " + rooms.get(i).mob.type + " is out to get you, what will you do?");	
			}

			if(rooms.get(i).roomType.equals("backyard")) {
				playerTurn = true;
				rooms.get(i).mob = new MobBY();
				rooms.get(i).mob.type = MobBY.names[i-12];
				rooms.get(i).description += ("\nA " + rooms.get(i).mob.type + " is out to get you, what will you do?");	
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
//	public static void setIsMob(boolean isMob) {
//		isMob = isMob;
//	}
}
