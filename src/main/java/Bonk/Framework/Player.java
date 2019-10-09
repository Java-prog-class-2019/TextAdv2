package Bonk.Framework;

import java.util.HashMap;

public class Player {

    String name;
    HashMap<String, Item> inv;

    public Player() {


    }

    public void addItem(Item item) {
        inv.put(item.name, item);
        applyStats(item);
    }

    public void removeItem() {

    }

    public void applyStats(Item item) {}

    public void removeStats() {}
}
