


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
	  	
	  	if(item.getType() == Type.CONSUMABLE) {
	  		System.out.println(item.getSize());
	  		System.out.println(item.getName());
	  	}
		
  	}
	
		
}
