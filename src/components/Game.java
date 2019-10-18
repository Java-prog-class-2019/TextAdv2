package components;
public class Game {
	
	boolean playerTurn;
	boolean systemTurn;
	
	public static void main(String[] args) {
		
			
				
		Player player = new Player();
		
		while(playerTurn) {
			String command = player.getCommand();
			player.parseCommand(command);
		}
	}
	
	public void init() {
		System.out.printf(" Welcome to Bonk! Type 'help' for a list of commands %n");
		playerTurn = false;
		systemTurn = true;
		
	}
	

}
