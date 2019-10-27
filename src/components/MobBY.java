package components;

class MobBY extends Mobs{

	private String names [] = {"Old Tire Swing","LawnMower","Rake", "Baseball Bat","Shovel", "Wheelbarrow"};
	MobBY () {
		genStats();
		chooseName();
	}

	public void genStats() {

		power = (int)(Math.random()*4)+1;
		health = (int)(Math.random()*10)+2;
		defence = (int)(Math.random()*3);
		critChance = 0;
		dodgeChance = 0;
	}

	public void chooseName() {
		type = names[Bonk.player.getCurrentRoomInt()-12];
	}
}

