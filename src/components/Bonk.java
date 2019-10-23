package components;


import components.Item.Type;
import java.util.ArrayList;

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
