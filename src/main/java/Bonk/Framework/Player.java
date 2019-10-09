package Bonk.Framework;

import java.util.HashMap;

public class Player {

    String name;
    HashMap<String, Item> inv;

    // Stats (1-10 [Inclusive])
    int dmg;
    int def;

    int dodge;
    int crit;



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

    public void applyStats(Item item) {}

    public void removeStats(Item item) {}
}
