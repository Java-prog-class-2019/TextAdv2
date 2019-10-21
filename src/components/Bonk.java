package components;


import java.util.ArrayList;


public class Bonk {

	boolean playerTurn;
	boolean systemTurn;
	Player player = new Player();

	ArrayList<Room> rooms = new ArrayList<Room>();

	public static void main(String[] args) {

		new Bonk();

	}


	Bonk() {

		init();
		enterRoom();
		while(playerTurn) {
			String command = player.getCommand();
			player.parseCommand(command);

		}

		//while(systemTurn) {


		//}
	}
	public void init() {

		for(int i=1; i<20;i++) {			
			rooms.add(new Room(i));
		}

		player.setCurrentRoom(1); //starting room
		System.out.println(" Welcome to Bonk! Type 'help' for a list of commands \n");
		playerTurn = false;
		systemTurn = true;

		//		for(Room r:rooms) {
		//			System.out.println(r.getDescription());
		//		}

	}


	void enterRoom(){


		String title = rooms.get(player.getCurrentRoom()).getTitle();
		for(int i=0; i < title.length()+4; i++) {
			System.out.print("¬");
		}
		System.out.println("\n| "+title + " |");
		for(int i=0; i < title.length()+4; i++) {
			System.out.print("¬");
		}
		
		System.out.println();
		System.out.println(rooms.get(player.getCurrentRoom()).getDescription());
		
	}




}
