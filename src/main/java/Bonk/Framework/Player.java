package Bonk.Framework;

import java.util.HashMap;

public class Player {

    String name;
    HashMap<String, Item> inv;

    // Hard Stats
    int power;
    int armour;

    //Soft Stats
    double dodgeChance;
    double critChance;



    public Player() {

    }

    public void addItem(Item item) {
        inv.put(item.name, item);
        applyStats(item);
    }

    public void removeItem(Item item) {
        inv.remove(item.name, item);
        removeStats(item);

    }

    public void applyStats(Item item) {
        dodgeChance += item.dodgeChance;
        critChance += item.critChance;
        power += item.power;
        armour += item.power;

    }

    public void removeStats(Item item) {
        dodgeChance -= item.dodgeChance;
        critChance -= item.critChance;
        power -= item.power;
        armour -= item.armour;

    }
}
