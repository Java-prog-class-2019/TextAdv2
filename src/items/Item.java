package items;

// Java imports
import java.util.Random;


// Main class for creating items. This class is extended by 
public class Item {
	
	// Name of the item
	protected String name;
		
	
	// Custom enums for rarity and armour/weapon types.
	
	Rarity rarity;
	Type type;

	// Stats for all items.
	
	protected int power;
	protected int defence;
	protected int bonusHealth;
	
	// Weapon spesific stat
	
	protected double critChance;
	
	// Armour spesific stat
	
	protected double dodgeChance;

	Random random = new Random();
	
	// ~~~~ Constructor ~~~~ \\
	public Item() {
		
		
		this.getClass().asSubclass(Weapon.class);
	}
	
	// ~~~~ Methods ~~~~ \\
	
	public void genStats() {}

	public void genName() {}
	
	public void genRarity() {}

	public void randomClass() {
		
		
		
	}
	
	// ~~~~ Enums ~~~~ \\  
	
	public enum Rarity {
		COMMON,
		RARE,
		LEGENDARY
	}
	
	public enum Type {
		WEAPON,
		ARMOUR
	}
	
	// ~~~~ Getters and Setters ~~~~ \\ 
	
	public String getName() {
		return this.name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getBonusHealth() {
		return bonusHealth;
	}

	public void setBonusHealth(int bonusHealth) {
		this.bonusHealth = bonusHealth;
	}

	public double getCritChance() {
		return critChance;
	}

	public void setCritChance(double critChance) {
		this.critChance = critChance;
	}

	public double getDodgeChance() {
		return dodgeChance;
	}

	public void setDodgeChance(double dodgeChance) {
		this.dodgeChance = dodgeChance;
	}

	public Rarity getRarity() {
		return rarity;
	}

	public void setRarity(Rarity rarity) {
		this.rarity = rarity;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}
}