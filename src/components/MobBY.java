package components;

class MobBY extends Mobs{

	private String names [] = {"Old Tire Swing","LawnMower","Rake", "Baseball Bat","Shovel", "Wheelbarrow"};
	MobBY () {
		type = names [(int)(Math.random()*names.length)];
		if (type.equals("Spiderling")) {
			poison = 5;
		}
		power = (int)(Math.random()*4)+1;
		health = (int)(Math.random()*8)+2;
		defence = (int)(Math.random()*4);
		critChance = 0;
		dodgeChance = 0;
	}
	
	void dropItems() {
		if (health <= 0) {
			
		}
	}
}

