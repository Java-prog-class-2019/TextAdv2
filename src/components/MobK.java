package components;

class MobK extends Mobs{

	private String names [] = {"Whisk","Faucet","Chef's Knife","Cheese Grater", "Bag of Frozen Peas","Cutting Board"};
	MobK () {
		type = names [(int)(Math.random()*names.length)];
		if (type.equals("Spiderling")) {
			poison = 5;
		}
		power = (int)(Math.random()*3)+1;
		health = (int)(Math.random()*6)+2;
		defence = (int)(Math.random()*3);
		critChance = 0;
		dodgeChance = 0;
	}
	
	void dropItems() {
		if (health <= 0) {
			
		}
		
	}
}

