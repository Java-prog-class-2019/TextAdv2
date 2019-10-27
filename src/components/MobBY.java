package components;

class MobBY extends Mobs{

	private String names [] = {"Old Tire Swing","LawnMower","Rake", "Baseball Bat","Shovel", "Wheelbarrow"};
	MobBY () {
		type = names [(int)(Math.random()*names.length)];
		if (type.equals("Baseball Bat") | type.equals("Shovel")) {
			confusion = 5;
		}
		if (type.equals("Wheelbarrow")) {
			bleed = 9;
		}
		power = (int)(Math.random()*4)+1;
		health = (int)(Math.random()*8)+2;
		defence = (int)(Math.random()*4);
		critChance = 0;
		dodgeChance = 0;
	}
	
	void dropItems() {
		if (health <= 0) {
			double chance = Math.random();
			if (chance <= 0.2) {
				coin = (int)(Math.random()*3)+1;
			}
//			else 
//				
//				//print an item that is pretty good 
				//or print a consumable that is good
		}
	}
}

