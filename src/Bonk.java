import java.util.ArrayList;

import components.Room;
import items.Item;
import items.Item.Type;
import util.Utility;

public class Bonk {

	public Player player = new Player();
	public ArrayList<Room> rooms = new ArrayList<Room>();

	// Global Variables
	boolean playerTurn;
	boolean systemTurn;
	boolean alive = true;
	boolean win = false;


	public static void main(String[] args) { new Bonk(); }


	Bonk() {
		// Constructor
		//Objects
		
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
		player.setCurrentRoom(1); // Starting room
		System.out.println("You have awoken in the great hall of a haunted mansion. You must explore and fight your way out!\n\nWelcome to Bonk! Type 'help' for a list of commands \n");
		playerTurn = true;
		systemTurn = false;

	}
	
	public void setupRooms() {
		
		for(int i=0; i<19;i++) {	//Creates the rooms and adds them to an ArrayList		
			rooms.add(new Room());
		}
		
		rooms.get((int)(Math.random()*5)).setItem(true);
		rooms.get((int)(Math.random()*5)+6).setItem(true);
		rooms.get((int)(Math.random()*5)+12).setItem(true);
		

	}

  public void itemStatTest() {
	  	Item item = new Item();
		System.out.println(item.getType());
		System.out.println(item.getName());
		System.out.println(item.getRarity());
		if (item.getType() == Type.WEAPON) {
      
		  System.out.println("Power: " + item.getPower());
		  System.out.println("Crit Chance: " + item.getCritChance());
      
		}
		if (item.getType() == Type.ARMOUR) {
      
		  System.out.println("Bonus Health: " + item.getBonusHealth());
		  System.out.println("Defence: " + item.getDefence());
		  System.out.println("Dodge Chance: " + item.getDodgeChance());
		  System.out.println(" Welcome to Bonk! Type 'help' for a list of commands \n");
      
		}
  	}
}
