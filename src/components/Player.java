package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import items.Item;

public class Player {

    String name;
    private int currentRoom;						//integer value of the current room
    ArrayList<Item> inv = new ArrayList<Item>();	//inventory
	
    
    // Hard Stats
    int power;
    int armour;
    int bonusHealth;

    //Soft Stats
    double dodgeChance;
    double critChance;



    public Player() {

    }

   public void pickupItem() {
	   
    }

    public void dropItem(Item item) {
        inv.remove(item);
        System.out.println("You dropped" + item.getName());

    }

    public void applyStats(Item item) { 
    	
        dodgeChance += item.getDodgeChance();
        critChance += item.getCritChance();
        power += item.getPower();
        armour += item.getDefence();

    }

    public void removeStats(Item item) {
    	
    	dodgeChance -= item.getDodgeChance();
    	critChance -= item.getCritChance();
    	power -= item.getPower();
    	armour -= item.getDefence();

    }

    public String getCommand() {	// uses scanner to get command

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        if(text.length() == 0) text = "QwErTy";
        return text;

    }

    // Parse commands to 
    public boolean parseCommand(String text) {
        text = text.toLowerCase().trim();
        
        String words[] = text.split(" ");
        ArrayList<String> wordlist = new ArrayList<String>(Arrays.asList(words));

        switch (wordlist.get(0)) {

            case ("help"):
                System.out.println("List of commands: help, move <n, w, e, s>, pickup <item> and search");
                break;
                
            case ("move"):
                move(wordlist.get(1));
            	break;
            	
            case ("inv"): case("i"): case("inventory"):
                printInv();
            	break;
            	
            case ("pickup"):
            	pickupItem();
            	break;
            	
            case ("say"):
            	System.out.println(wordlist.get(1));
            	break;
            	
            case ("search"):
            	searchRoom();
            	break;
            	
            case("n"):case("north"):case("e"):case("east"):case("s"):case("south"):case("w"):case("west"):
            	move(wordlist.get(0));
            	break;
            	
            default: 
            	System.out.println("What?!");
            	break;

        }
        return false;
    }

    
    
    public void move(String dir) {
    	
    	// Moves player. First checks if specified movement direction is possible,
    	// then either changes the current room, or prints an error message
    	
    	switch(dir) {
    		
    		case("n"): case("north"):
    			if(currentRoom==18) {
    				break;
    			}
    			if(currentRoom%6==5) {
    				System.out.println("You can't go that way!");
    				break;
    			}else {
    				currentRoom+=2;
    				break;
    			}
    		
    		case("e"): case("east"):
    			if(currentRoom%2==0) {
    				System.out.println("You can't go that way!");
    				break;
    			}else {
    				currentRoom--;
    				break;
    			}
    			
    		case("s"): case("south"):
    			if(currentRoom%6==1 || currentRoom==0) {
    				System.out.println("You can't go that way!");   
    				break; 				
    			}else {
    				currentRoom-=2;
    				break;
    			}
    			
    		case("w"): case("west"):
    			if(currentRoom%2==1) {
    				System.out.println("You can't go that way!");
    				break;
    			}else {
    				currentRoom++;
    				break;
    			}
    			
    		 default: 
             	System.out.println("What?!");	
				break;
    	}
    	    	
    }
    
    public void searchRoom() {
    	
    }

    // Inventory Command
    public void printInv() {
    	
    	if(inv.size() == 0) {
    		System.out.println("Empty Inventory!");
    	}
    	
    	for(int i = 0; i < inv.size(); i++) {
    		System.out.printf("- %s%n", inv.get(i).getName());
    	}

    }
    
    // ~~~~ Getters and Setters ~~~~ \\
    public Player getPlayer() {
    	return this;
    }
    
    public void setCurrentRoom(int currentRoom) {
    	this.currentRoom = currentRoom;
    }
    
    public int getCurrentRoomInt() {
    	return currentRoom;
    }

}