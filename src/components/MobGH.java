package components;
class MobGH extends Mobs {

	private String names [] = {"Spiderling","Clothes Hanger", "Dust Bunny", "Old Floorboard", "Cabinet Door","Carpet"};
	
	//all mob Great Hall Stats
	MobGH () {
		type = names [(int)(Math.random()*names.length)];
		if (type.equals("Spiderling")) {
			poison = 5;
		}
		power = (int)(Math.random()*2)+1;
		health = (int)(Math.random()*4)+2;
		defence = (int)(Math.random()*2);
		critChance = 0;
		dodgeChance = 0;
	}
	
	void dropItems() {
		if (health <= 0) {
			double chance = Math.random();
			if (chance <= 0.2) {
				coin = (int)(Math.random()*3)+1;
			}
			else 
				
				//print an item that is pretty good 
				//or print a consumable that is good
		}
	}
}