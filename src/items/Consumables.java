package items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Consumables {
	
	
	Type type;
	Size size;
	String name;
	
	int health_bonus;
	int power_bonus;
	double crit_bonus;
	double dodge_bonus;
		
	Random random = new Random();
	
	String[] item_names = {"Apple", "Orange", "Potion", "Draught", 
			"Elixir", "Brew", "Remedy", "Cordial", "Mixture"};
	
	public Consumables() {
		chooseSize();
		generateEffect();
		generateName();
	}
	
	public void consume() {
		System.out.println("No eating yet.");
		
	}
	
	public void generateEffect() {
		
		int rand_type = random.nextInt(7);
		
		ArrayList<Type> types = new ArrayList<Type>(Arrays.asList(Type.values()));
		
		type = types.get(rand_type);
	
	}
	
	public void chooseSize() {
		
		double rand_double = random.nextDouble();
		
		if(rand_double > 0.5) {
			size = Size.SMALL;
		}
		
		if(rand_double > 0.2 && rand_double < 0.5) {
			size = Size.MEDIUM;
		}
		
		if(rand_double < 0.2) {
			size = Size.VENTI;
		}
	}
	
	
	public void generateName() {
				
		switch(size){
			case SMALL:
				name += "Small ";
				break;

			case MEDIUM:
				name += "Medium ";
				break;

			case VENTI:
				name += "Venti ";
				break;

		}
		
		switch(type) {
			case HEALTH:
				name += "Healing ";
				break;
				
			case FORTITUDE:
				name += "Fortifying ";
				break;

			case UNKNOWN:
				name += "Mysterious ";
				break;

			case STRENGTH:
				name += "Strengthening ";
				break;

			case SWIFTNESS:
				name += "Quickening ";
				break;

			case RAGE:
				name += "Enraging ";
				break;

		}
		
		int rand_item = random.nextInt(item_names.length);
		
		name += item_names[rand_item];
		
	}
	
	// Enum for types/effects the consumable will create.
	enum Type {
		HEALTH,
		FORTITUDE,
		UNKNOWN,
		STRENGTH,
		SWIFTNESS,
		RAGE
	}
	
	// Size of the consumable.
	enum Size {
		SMALL,
		MEDIUM,
		VENTI
				
	}
	
	

}
