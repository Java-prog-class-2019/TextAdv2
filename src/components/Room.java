package components;

import java.util.HashMap;

public class Room {
	
	/***** Instance variables *****/
	private String title;																	//Title of the room
	private String description;																//Message that displays when you enter a room
	private String descrItem=" You spot an item glinting on the ground in front of you.";	//Additional description exclusive to item rooms (this had to be separate from description so it could be removed if need be)
	private boolean visited = false;														//Checks if the room has been visited (so player can't get more items)
	private String roomType;																//Type of the room (3 types based on location)
	private int number;																		//Distinguishes different rooms on the map. Features are mostly based on number.
	private boolean isItem=false;															//Is it an item room?
	boolean isShop=false;																	//Is it a shop room?
	private boolean isEnemy;																//Is it an enemy room?
	Item item;																				//Item
	Shop shop;																				//Shop
	/*******************************/
	
	
	public Room(int number) {		//Constructor
		
		this.number=number;
		
		if(number<=5)roomType = "great hall";
		if(number>=6 && number<=11)roomType = "kitchen";
		if(number>=12 && number<=17)roomType = "backyard";
		if(number==18)roomType = "boss";
		if(number%6==5) {
			isShop=true;
			shop = new Shop();
		}
    
		
		title = randomTitle();
		description = randomDescriptor() + exits();

		if(isShop) description+=" You spot a wary shopkeeper! Type \"shop\" to shop.";
		
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
		String[] byRooms = {"Flower Garden","Vegetable Patch","Shed","Koi Pond","Deck","Patio","Tennis Court","Basketball Court","Pool","Outhouse","Stone Path","Marble Path","Statue","Memorial","Courtyard","Poolhouse","Park","Baseball Diamond"};
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
	
	private String exits() {
		String s="";
		
		if(number%2==0 && number!=0 && number!=18) s=" There are exits to the north, west, and south.";
		if(number%6==5) s=" There are exits to the east and south.";
		if(number%6==1) s=" There are exits to the north and east";
		if(number%6==3) s=" There are exits to the north, east, and south.";
		if(number==0) s=" There are exits to the north and west.";
		
		return s;
	}


/****Getters and Setters***************/
	public String getRoomType() {
		return roomType;
	}

		
	public String getDescription() {
		if(isItem) {
			return description + descrItem;
		}
		return description;
	}
	
	
	public String getTitle() {
		return title;
	}
	
	public void setItem(boolean isItem) {
		this.isItem = isItem;
		
		if(isItem) {
			item = new Item();
		}
		if(!isItem) {
			item = null;
		}
	}
	
	public void setVisited() {
		visited = true;
	}
	
	public boolean getIsItem() {
		return isItem;
	}
/**************************************/
}/	}
//	if(number==17) {
//		
//	}
	
/***************************************/
	
	
}