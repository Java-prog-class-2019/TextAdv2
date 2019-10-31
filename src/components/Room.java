package components;

public class Room {
	
	private Exits[] exits;
	private Type type;
	
	// Variable
	private String title;
	private String description;
	private String roomType;
	
	private boolean isItem;
	private boolean isShop;
	private boolean isEnemy;

	// Room names
	String[] kRooms = {"Oven Room","Cafe","Pantry","Grease Parlour","Microwave Room","Walk-in Refrigerator","Storage Room","Washroom","Walk-in Freezer","Cleanup Zone","Garbage Disposal","Chef's Pass","Dish Pit","Frying Room"};
	String[] ghRooms = {"Dining Hall","Closet","Hall of Mirrors","Parlour","Sitting Room","Marble Hallway","Washroom","Bedroom","Guest Room","Coat Room","Storage Room","Jewellery Room","Children's Room","Studio","Hall of Treasure"};
	String[] byRooms = {"Flower Garden","Vegetable Patch","Shed","Koi Pond","Deck","Patio","Tennis Court","Basketball Court","Pool","Outhouse","Stone Path","Marble Path","Statue","Memorial","Courtyard","Poolhouse"};
	
	// Random adjectives. 
	String[] adjectives1 = {"dusty", "musty", "creepy", "dark", "dingy", "bright", "living", "mediocre", "bloody", "dangerous", "dirty",
			"nutty", "horrible", "lovely", "nasty", "repulsive", "terrible", "wicked", "hot"};
	String[] adjectives2 = {"depressing","dull","drab","misty","grotesque","smelly","stinky","damp","dry","ugly","putrid","swank","filthy","muddy","shining","foggy","sparkling","crusty","sticky"};
	
	
	public Room() {
    
		
		
		if (isShop) {
			description += " You spot a wary shopkeeper!";
		}

		randomTitle();
		randomDescriptor();
		
	}

	private void randomDescriptor() {
		
		description = "You find yourself in a " + adjectives1[(int)(Math.random()*adjectives1.length)] + " " + adjectives2[(int)(Math.random()*adjectives2.length)] + " section of the " + type.toString() + ".";
		

	}
	
	
	private void randomTitle() {
		
		// Creates a random title for each of the rooms
		// based on the type enum.
		
		if(type == Type.GREATHALL) {
			title = "GREAT HALL: " + ghRooms[(int)(Math.random()*ghRooms.length)];
		}
		
		if(type == Type.KITCHEN) {
			title = "KITCHEN: " + kRooms[(int)(Math.random()*kRooms.length)];
		}
		
		if(type == Type.BACKYARD) {
			title = "BACKYARD: " + byRooms[(int)(Math.random()*byRooms.length)];
		}
		
	}
	
	enum Type {
		
		// If the room is less than or equal too 5. It has the type Grand Hall.
		// If the room is <= 11 and >= 6. It has the type of Kitchen.
		// If the room is <= 17 and >= 12. It is a Backyard type.
		// If the room is 18, it is the boss room. 
		
		BACKYARD,
		KITCHEN,
		GREATHALL,
		BOSS,
		
	}
	
	enum Exits {
		
		// If a room is a multiple of 2 and is not 0 or 18. It has exits north, west and south 
		// If a room has a remainder of 5 from 6, it is a east and south.
		// If a room has a remainder of 3 from 6, it has exits north, east and south.
		// If the number is zero, it will have exits north and west.
		
		NORTH,
		SOUTH,
		WEST,
		EAST,
		
	}

	// ~~~~ Getters and Setters ~~~~ \\
	
	public String getRoomType() {
		return roomType;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setItem(boolean isItem) {
		this.isItem = isItem;
	}
	
	public boolean getIsItem() {
		return isItem;
	}
	
	public void setExits() {
	}
	
}