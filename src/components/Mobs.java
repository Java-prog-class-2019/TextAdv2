package components;

import java.lang.reflect.Array;
import java.util.Random;

public class Mobs {

	int power;
	int defence;
	double dodgeChance;
	
	String name;
	Rarity rarity;

	public Mob() {
		chooseType();
		genStats();
		dropItems();
	}
	
	public void chooseType() {
	}
	
	public void genStats() {
	}
	
	public void dropItems() {
	}
	
}
