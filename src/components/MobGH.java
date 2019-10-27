package components;
class MobGH extends Mobs {

	private String names [] = {"Spiderling","Clothes Hanger", "Dust Bunny", "Old Floorboard", "Cabinet Door","Carpet"};

	//all mob Great Hall Stats
	MobGH () {
		genStats();
		chooseName();
	}

	public void genStats() {
		power = (int)(Math.random()*2)+1;
		health = (int)(Math.random()*4)+2;
		defence = (int)(Math.random()*2);
		critChance = 0;
		dodgeChance = 0;
	}

	public void chooseName() {
		type = names[Bonk.player.getCurrentRoomInt()];
	}
}
