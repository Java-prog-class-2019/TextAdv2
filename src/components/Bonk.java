package components;

public class Bonk {

	boolean playerTurn;
	boolean systemTurn;

	public static void main(String[] args) {

		new Bonk();

	}


	Bonk() {
		init();	

	}

	public void init() {
		System.out.println(" Welcome to Bonk! Type 'help' for a list of commands \n");
		playerTurn = false;
		systemTurn = true;		
	}
}
