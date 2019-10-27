package components;

class MobBY extends Mobs{

	public static String names [] = {"Old Tire Swing","LawnMower","Rake", "Baseball Bat","Shovel", "Wheelbarrow"};
	MobBY () {
		genStats();

	}

	public void genStats() {
		power = (int)(Math.random()*4)+1;
		health = (int)(Math.random()*10)+2;
		defence = (int)(Math.random()*3);
		critChance = 0;
		dodgeChance = 0;
	}
}

