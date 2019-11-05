package components;

class MobGH extends Mob {	//Subclass of mob. Has floor specific names and stats.

	public static String names [] = {"Spiderling", "Clothes Hanger", "Dust Bunny", "Old Floorboard", "Cabinet Door", "Carpet"};

	MobGH () {
		genStats();
	}

	public void genStats() {
		power = (int)(Math.random()*2)+1;
		health = (int)(Math.random()*7)+1;
		armour = (int)(Math.random());
		critChance = 0;
		dodgeChance = 0;
	}
	
}
