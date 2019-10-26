package items;

public class Consumables {
	
	
	Type type;
	int health_bonus;
	int power_bonus;
	int crit_bonus;
	int dodge_bonus;
	
	String[] s_names;
	String[] m_names;
	String[] v_names;
	
	public Consumables() {
		
		
	}
	
	public void consume() {
		
		
	}
	
	public void chooseName() {
				
		
	}
	
	public void chooseType() {
		
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
	
	// Size of the consumable/potion.
	enum Size {
		SMALL,
		MEDIUM,
		VENTI
				
	}

}
