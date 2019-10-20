package components;


public class Bonk {
	
	boolean playerTurn;
	boolean systemTurn;
	Player player = new Player();
	
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
		System.out.println(" Welcome to Bonk! Type 'help' for a list of commands \n");
		playerTurn = true;
		systemTurn = false;
		// Setup Rooms/Map
		for(int i = 0; i < 18; i++) {
			
			
			
		}
		
				
	}
		

}
