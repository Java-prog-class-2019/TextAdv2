package components;

class MobK extends Mobs{

	private String names [] = {"Whisk","Faucet","Chef's Knife","Cheese Grater", "Bag of Frozen Peas","Cutting Board"};
	MobK () {
		type = names [(int)(Math.random()*names.length)];
		if (type.equals("Chef's Knife")) {
			bleed = 7;
		}
		power = (int)(Math.random()*3)+1;
		health = (int)(Math.random()*6)+2;
		defence = (int)(Math.random()*3);
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
//				//or print a consumable that is good
		}
	}
}

