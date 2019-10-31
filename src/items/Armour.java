package items;

import items.Item.Rarity;
import items.Item.Type;

public class Armour extends Item{
	
	String CArmour [] = {"A Chain Helmet", "A Baseball Cap", "An Old Hoodie", "A Bear Mask", "A Broken Chestplate", "A Brown Paper Bag"};
	String RArmour [] = {"Plate Mail", "Jarvan IV's Helm", "A Sturdy Helm", "Clunky Boots", "A Grayscale Teddy Fresh Colour Block Hoodie" };
	String LArmour [] = {"Kayle's Shining Armor", "The Legendary Helm of Greatness", "A Crazy Zany Wavy Plate", "Glistening Boots", "Shadow Mail"};
	
	String AModifiers [] = {"Of Swiftness", "Of Speed", "With Dodging Capabilities", "Of Great Speed"};

	
	public Armour() {
		
		setType(Type.ARMOUR);
		genStats();
		genName();
	}
	
	
	@Override
	public void genName() {
		
		//Gene created this name generation.
		if(rarity == Rarity.COMMON) {
			setName(CArmour[(int)(Math.random()*CArmour.length)]);
		}
		
		if(rarity == Rarity.RARE && this.getDodgeChance() == 0) {
			setName(RArmour[(int)(Math.random()*RArmour.length)]);
		}
		
		if(rarity == Rarity.RARE && this.getDodgeChance() > 0) {
			setName(RArmour[(int)(Math.random()*RArmour.length)] + AModifiers[(int)(Math.random()*AModifiers.length)]);
		}
		
		if(rarity == Rarity.LEGENDARY && this.getDodgeChance() ==0) {
			setName(LArmour[(int)(Math.random()*LArmour.length)]);
		}
		
		if(rarity == Rarity.LEGENDARY && this.getDodgeChance() > 0) {
			setName(LArmour[(int)(Math.random()*LArmour.length)] + AModifiers[(int)(Math.random()*AModifiers.length)]);
		}
	}
	
	@Override
	public void genStats() {
		
		if(rarity == Rarity.COMMON) {
			
			
			defence = (int)(Math.random()*1)+1;   
			bonusHealth = (int) (Math.random()*3)+1;
			dodgeChance =0;
			
		}
		
		if(rarity == Rarity.RARE) {
			
			defence = (int)(Math.random() * 3 ) + 1;
			bonusHealth = (int) (Math.random() * 5 ) + 2;
			
			if(Math.random() >= 0.5){
				
				dodgeChance = (Math.random() * 0.2 ) + 0.1;
				defence = defence - 1;
				bonusHealth = bonusHealth -1;
				
			}
		}
		
		if(rarity == Rarity.LEGENDARY) {
			
			defence = (int)(Math.random() * 4 ) + 2;
			bonusHealth = (int) (Math.random() * 8 ) + 3;
			
			if(Math.random() >= 0.5) {
				
				dodgeChance = (Math.random()* 0.3 ) + 0.2;
				defence = defence - 1;
				bonusHealth = bonusHealth - 3;
				
			}
		}
	}
}
