package components;


import java.util.ArrayList;


public class Bonk {
	
	boolean playerTurn;
	boolean systemTurn;

	int currentRoom=1;
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

	public void init() {
		for(int i=1; i<20;i++) {
			Room r = new Room(i);
			rooms.add(r);
		}
		System.out.println(" Welcome to Bonk! Type 'help' for a list of commands \n");
		playerTurn = false;
		systemTurn = true;

		for(Room r:rooms) {
			System.out.println(r.getDescription());
		}
	
	}
	
	void enterRoom(){
		System.out.println(rooms.get(currentRoom).getDescription());

	}
	
	public void init() {
		System.out.println(" Welcome to Bonk! Type 'help' for a list of commands \n");
		playerTurn = true;
		systemTurn = false;
		// Setup Rooms/Map
		for(int i = 0; i < 18; i++) {
			
			
			
		}
		
				
	}
		

}
