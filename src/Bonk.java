


import java.util.ArrayList;

import components.Player;
import components.Room;
import items.Item;
import items.Item.Type;

public class Bonk {

	boolean playerTurn;
	boolean systemTurn;
	Player player = new Player();
	
	int currentRoom = 1;
	ArrayList<Room> rooms = new ArrayList<Room>();
	
	public static void main(String[] args) {

		new Bonk();
	
	}
	
	Bonk() {

		init();
		
		itemStatTest();
		
		while(playerTurn) {
			String command = player.getCommand();
			player.parseCommand(command);
			
		}
		
		while(systemTurn) {
			
			
		}
    
	}
  
	public void init() {
		for(int i=1; i<20;i++) {
			Room r = new Room(i);
			rooms.add(r);
		}
		System.out.println("Welcome to Bonk! Type 'help' for a list of commands \n");
		playerTurn = false;
		systemTurn = true;

		for(Room r:rooms) {
			System.out.println(r.getDescription());
		}
	
	}
	
	public void enterRoom(){
		System.out.println(rooms.get(currentRoom).getDescription());

	}

  public void itemStatTest() {
	  //Item 
	  	Item item = new Item();
	  	
		System.out.println(item.getType().toString());
		System.out.println(item.getName());
		System.out.println(item.getRarity().toString());
		
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
