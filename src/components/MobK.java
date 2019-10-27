package components;

class MobK extends Mobs{

	private String names [] = {"Whisk","Faucet","Chef's Knife","Cheese Grater", "Bag of Frozen Peas","Cutting Board"};
	MobK () {
		genStats();
		chooseName();
	}

	public void genStats() {

		power = (int)(Math.random()*3)+1;
		health = (int)(Math.random()*6)+2;
		defence = (int)(Math.random()*3);
		critChance = 0;
		dodgeChance = 0;
	}

	public void chooseName() {
		type = names[Bonk.player.getCurrentRoomInt()-6];
	}
}


