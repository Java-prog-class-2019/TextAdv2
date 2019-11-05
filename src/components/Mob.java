package components;
class Mob {	//Parent class for the subclasses of mobs
	
	/***Mob's Stats***/
	int power;
	int armour;
	int health;
	double dodgeChance;
	double critChance;
	String type = "";
	/*****************/
	
	
	/***Getters and Setters***/
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getArmour() {
		return armour;
	}
	public void setArmour(int armour) {
		this.armour = armour;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {		
		this.health -= health;
		if (this.health < 0) this.health = 0;
	}
	public double getDodgeChance() {
		return dodgeChance;
	}
	public void setDodgeChance(double dodgeChance) {
		this.dodgeChance = dodgeChance;
	}
	public double getCritChance() {
		return critChance;
	}
	public void setCritChance(double critChance) {
		this.critChance = critChance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/*************************/
}

