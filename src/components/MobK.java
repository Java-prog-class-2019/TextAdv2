package components;

class MobK extends Mob{	//Subclass of mob. Has floor specific names and stats.

	public static String names [] = {"Whisk","Faucet","Chef's Knife","Cheese Grater", "Bag of Frozen Peas","Cutting Board"};
	
	MobK () {
		genStats();
	}

	public void genStats() {
		power = (int)(Math.random()*3)+2;
		health = (int)(Math.random()*12)+2;
		armour = (int)(Math.random()*3);
		critChance = 0;
		dodgeChance = 0;
	}
	
}


