package components;


import components.Item.Type;
import java.util.ArrayList;

public class Bonk {
	
	//Objects
	static Player player = new Player();
	public static ArrayList<Room> rooms = new ArrayList<Room>();

	// Global Variables
	boolean playerTurn;
	boolean systemTurn;
	boolean alive = true;
	static boolean win = false;

	public static void main(String[] args) { new Bonk(); }


	Bonk() {	// Constructor

		init();
		
		// Main game loop
		
		while(true) {
			while(playerTurn) {
				String command = player.getCommand();
				player.parseCommand(command);
	
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
		player.setCurrentRoom(0); //starting room
		System.out.println("You have awoken in the great hall of a haunted mansion. You must explore and fight your way out!\n\nWelcome to Bonk! Type 'help' for a list of commands \n");
		enterRoom();
		
		playerTurn = true;
		systemTurn = false;

	}
	

	public void chooseAction() {
		if (playerTurn == true) {
			
		}
	}
	



	static void enterRoom(){

		// Print Title of the entered room.
		String title = rooms.get(player.getCurrentRoomInt()).getTitle();
		
		System.out.println();
		for(int i=0; i < title.length()+4; i++) {			
			System.out.print("-");
		}
		
		System.out.println("\n| "+ title + " |");
		
		for(int i=0; i < title.length()+4; i++) {			
			System.out.print("-");			
		}
		
		System.out.println("\n"+rooms.get(player.getCurrentRoomInt()).getDescription());
		
	}
	
	public void setupRooms() {
		
		for(int i=0; i<19;i++) {	//Creates the rooms and adds them to an ArrayList		
			rooms.add(new Room(i));
		}
		
		rooms.get((int)(Math.random()*5)).setItem(true);
		rooms.get((int)(Math.random()*5)+6).setItem(true);
		rooms.get((int)(Math.random()*5)+12).setItem(true);
		

	}

  public void itemStatTest() {
	  	Item item = new Item();
		System.out.println(item.type);
		System.out.println(item.name);
		System.out.println(item.rarity);
		if (item.type == Type.WEAPON) {
      
		  System.out.println("Power: " + item.power);
		  System.out.println("Crit Chance: " + item.critChance);
      
		}
		if (item.type == Type.ARMOUR) {
      
		  System.out.println("Bonus Health: " + item.bonusHealth);
		  System.out.println("Defence: " + item.defence);
		  System.out.println("Dodge Chance: " + item.dodgeChance);
		  System.out.println(" Welcome to Bonk! Type 'help' for a list of commands \n");
      
		}
  }
}
