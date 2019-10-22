package components;


import java.util.ArrayList;


public class Bonk {

	boolean playerTurn;
	boolean systemTurn;
	boolean alive = true;
	boolean win = false;
	static Player player = new Player();

	public static ArrayList<Room> rooms = new ArrayList<Room>();

	public static void main(String[] args) {

		new Bonk();

	}


	Bonk() {	//Constructor

		init();
		
		while(alive && !win) {
			while(playerTurn) {
				String command = player.getCommand();
				player.parseCommand(command);

			}

			while(systemTurn) {


			}
		}
	}
	
	
	public void init() {

		for(int i=0; i<19;i++) {	//Creates the rooms and adds them to an ArrayList		
			rooms.add(new Room(i));
		}

		player.setCurrentRoom(0); //starting room
		System.out.println(" Welcome to Bonk! Type 'help' for a list of commands \n");
		playerTurn = true;
		systemTurn = false;
		
		rooms.get((int)(Math.random()*5)).setItem();
		rooms.get((int)(Math.random()*5)+6).setItem();
		rooms.get((int)(Math.random()*5)+12).setItem();

		
		enterRoom();

//				for(Room r:rooms) {
//					System.out.println(r.getDescription());
//				}

	}


	static void enterRoom(){


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
	
//	public Room getRoom() {
//		return rooms<player.getCurrentRoom()>;
//	}




}
