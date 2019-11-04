package components;

class MobBY extends Mob{

	public static String names [] = {"Old Tire Swing","LawnMower","Rake", "Baseball Bat","Shovel", "Wheelbarrow"};
	MobBY () {
		genStats();

	}

	public void genStats() {
		power = (int)(Math.random()*4)+3;
		health = (int)(Math.random()*16)+2;
		armour = (int)(Math.random()*3);
		critChance = 0;
		dodgeChance = 0;
	}
}

