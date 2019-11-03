package components;

import java.util.HashMap;

public class Room {
	
	/***** Instance variables *****/
	private String title;			//Title of the room
	private String description;		//Message that displays when you enter a room
	private boolean visited = false;	//Checks if the room has been visited (so player can't get more items)
	private String roomType;		//Type of the room (3 types based on location)
	private int number;				//Distinguishes different rooms on the map. Features are mostly based on number.
	boolean item;					//Is it an item room?
	boolean enemy;					//Is it an enemy room?
	/*******************************/
	
	
	public Room(int number) {		//Constructor
		

		description=randomDescriptor();
    
		if(number<=6)roomType = "kitchen";
		if(number>=7 && number<=12)roomType = "great hall";
		if(number>=13 && number<=18)roomType = "backyard";
		if(number==19)

		
		if(number%6==0)item=true;
		else item=false;
		
		if(item && !visited) description+=" You spot an item glinting on the ground in front of you.";
		//Next few lines add available exits to the description
		if(number%2==1 && number!=1 && number!=19) description+=" There are exits to the north, west, and south.";
		if(number%6==0) description+=" There are exits to the east and south.";
		if(number%6==2) description+=" There are exits to the north and east";
		if(number%6==4) description+=" There are exits to the north, east, and south.";
		if(number==1) description+=" There are exits to the north and west.";
		
		
	}

	private String randomDescriptor() {		//Creates a random description for each room, based on its pre-set parameters.
		String[] adjectives1 = {"dusty","musty","creepy","dark","dingy","bright","living","mediocre","bloody","dangerous","dirty","nutty","horrible","lovely","nasty","repulsive","terrible","wicked","hot"};
		String[] adjectives2 = {"depressing","dull","drab","misty","grotesque","smelly","stinky","damp","dry","ugly","putrid","swank","filthy","muddy","shining","foggy","sparkling","crusty","sticky"};
		String s;
		
		s = "You find yourself in a " + adjectives1[(int)(Math.random()*adjectives1.length)] + " " + adjectives2[(int)(Math.random()*adjectives2.length)] + " section of the " + roomType + ".";
	
		return s;
	}
	
	
	private String randomTitle() {		//Creates a random title for each room, based on its location.
		String[] kRooms = {"Oven Room","Cafe","Pantry","Grease Parlour","Microwave Room","Walk-in Refrigerator","Storage Room","Washroom","Walk-in Freezer","Cleanup Zone","Garbage Disposal","Chef's Pass","Dish Pit","Frying Room"};
		String[] ghRooms = {"Dining Hall","Closet","Hall of Mirrors","Parlour","Sitting Room","Marble Hallway","Washroom","Bedroom","Guest Room","Coat Room","Storage Room","Jewellery Room","Children's Room","Studio","Hall of Treasure"};
		String[] byRooms = {"Flower Garden","Vegetable Patch","Shed","Koi Pond","Deck","Patio","Tennis Court","Basketball Court","Pool","Outhouse","Stone Path","Marble Path","Statue","Memorial","Courtyard","Poolhouse"};
		String s="";
		

		if(roomType.equals("kitchen")) {
			s = "KITCHEN: " + kRooms[(int)(Math.random()*kRooms.length)];
		}
		if(roomType.equals("great hall")) {
			s = "GREAT HALL: " + ghRooms[(int)(Math.random()*ghRooms.length)];
		}
		if(roomType.equals("backyard")) {
			s = "BACKYARD: " + byRooms[(int)(Math.random()*byRooms.length)];
		}
		
		return s;

	}


/****Getters and Setters***************/
	public String getRoomType() {
		return roomType;
	}

		
	public String getDescription() {
		return description;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	
	public void setVisited() {
		visited = true;
	}
	
}