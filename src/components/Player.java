package components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Player {

    String name;
    private int currentRoom;
    ArrayList<Item> inv = new ArrayList<Item>();
	
    
    // Hard Stats
    int power;
    int armour;
    int bonusHealth;

    //Soft Stats
    double dodgeChance;
    double critChance;



    public Player() {

    }

   public void pickupItem(Item item) {
        inv.add(item);
    }

    public void dropItem(Item item) {
        inv.remove(item);

    }

    public void applyStats(Item item) {
        dodgeChance += item.dodgeChance;
        critChance += item.critChance;
        power += item.power;
        armour += item.power;

    }

    public void removeStats(Item item) {
        dodgeChance -= item.dodgeChance;
        critChance -= item.critChance;
        power -= item.power;
        armour -= item.defence;

    }

    public String getCommand() {

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        if(text.length() == 0) text = "QwErTy";
        return text;

    }

    public boolean parseCommand(String text) {

        text = text.toLowerCase().trim();

        String words[] = text.split(" ");

        ArrayList<String> wordlist = new ArrayList<String>(Arrays.asList(words));


        String word1 = wordlist.get(0);
        String word2 = "";


        if (wordlist.size() > 1) {
            word2 = wordlist.get(1);
        }

        /*
        Word One Commands
        - say
        - move
        - pickup
        - search
         */

        switch (word1) {

            case ("help"):
                System.out.println("List of commands: help, move <n, w, e, s>, pickup <item> and search");
                break;
            case ("move"):
                move(word2);
            	break;
            case ("inv"):
                printInv();
            	break;
            case ("say"):
            	System.out.println(word2);
            	break;
            case ("search"):
            	searchRoom();
            	break;
            case("n"):case("north"):case("e"):case("east"):case("s"):case("south"):case("w"):case("west"):
            	move(word1);
            	break;
            	
            default: 
            	System.out.println("What?!");

        }
        return false;
    }

    public void move(String dir) {
    	
    	switch(dir) {
    		
    		case("n"): case("north"):
    			if(currentRoom%6==5) {
    				System.out.println("You can't go that way!");
    				break;
    			}else {
    				currentRoom+=2;
    				Bonk.enterRoom();
    				break;
    			}
    		
    		case("e"): case("east"):
    			if(currentRoom%2==0) {
    				System.out.println("You can't go that way!");
    				break;
    			}else {
    				currentRoom--;
    				Bonk.enterRoom();
    				break;
    			}
    			
    		case("s"): case("south"):
    			if(currentRoom%6==1 || currentRoom==0) {
    				System.out.println("You can't go that way!");   
    				break; 				
    			}else {
    				currentRoom-=2;
    				Bonk.enterRoom();
    				break;
    			}
    			
    		case("w"): case("west"):
    			if(currentRoom%2==1) {
    				System.out.println("You can't go that way!");
    				break;
    			}else {
    				currentRoom++;
    				Bonk.enterRoom();
    				break;
    			}
    			
    		 default: 
             	System.out.println("What?!");	
				break;
    	}
    	    	
    }

    public void printInv() {
    	
    	if(inv.size() == 0) {
    		System.out.println("Empty Inventory!");
    	}
    	
    	for(int i = 0; i < inv.size(); i++) {
    		System.out.printf("%s", inv.get(i).getName());
    	}

    }
    
    public void searchRoom() {
    	
    	
    	
    	
    }
    
    
    public void setCurrentRoom(int currentRoom) {
    	this.currentRoom = currentRoom;
    }
    
    public int getCurrentRoom(){
    	return currentRoom;
    }
}