package components;

public class Consumables {
	
	Type type;
	int health_bonus;
	int power_bonus;
	int crit_bonus;
	int dodge_bonus;
	
	
	public Consumables() {
		
		
	}
	
	public void consume() {
		
		
		
	}
	
	enum Type {
		HEALTH,
		FORTITUDE,
		UNKNOWN,
		STRENGTH,
		SWIFTNESS,
		RAGE
		
	}
	
	enum Size {
		SMALL,
		MEDIUM,
		VENTI
				
	}

}
