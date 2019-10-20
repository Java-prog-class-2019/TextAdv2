package components;

import java.util.HashMap;

public class Room {
	
	/***** Instance variables *****/
	private String description;		//Message that displays when you enter a room
	private boolean visited = false;	//Checks if the room has been visited (so player can't get more items)
	private String roomType;		//Type of the room (3 types based on location)
	private int number;				//Distinguishes different rooms on the map. Features are mostly based on number.
	boolean item;					//Is it an item room?
	/*******************************/
	
	
	public Room() {		//Constructor
		
		description = randomDescriptor();
		
		if(number<=6)roomType = "great hall";
		if(number<=6)roomType = "kitchen";
		if(number<=6)roomType = "backyard";
		
		if(number%6==0)item=true;
		else item=false;
	}
	
	

	private String randomDescriptor() {
		String[] adjectives1 = {"dusty","musty","creepy","dark","dingy","bright","living","mediocre","bloody","dangerous","dirty","nutty","horrible","lovely","nasty","repulsive","terrible","wicked"};
		String[] adjectives2 = {"depressing","dull","drab","misty","grotesque","smelly","stinky","damp","dry","ugly","putrid","swank","filthy","muddy","shining","foggy","sparkling","crusty"};

		String s = "You find yourself in a " + adjectives1[(int)(Math.random()*adjectives1.length)] + " " + adjectives2[(int)(Math.random()*adjectives2.length)] + "section of the " + roomType + ".";
		return s;
		
	}


	public String getRoomType() {
		return roomType;
	}


	public String getDescription() {
		return description;
	}


	
	
/************For player class***********/
	
//	if(number%6==0) {
//		
//	}
//	if(number%6==2) {
//		
//	}
//	if(number==1) {
//		
//	}
//	if(number==17) {
//		
//	}
	
/***************************************/
	
	
}