package Bonk.Framework;

import java.util.Random;

public class Item {


    int power;
    int armour;
    double critChance;
    double dodgeChance;


    Random random = new Random();

    String name;

    Rarity rarity;
    Type type;

    public Item() {
        chooseType();
        chooseRarity();

    }

    public void chooseType() {
        if (random.nextDouble() >= 0.5) {
            type = Type.WEAPON;
        } else {
            type = Type.ARMOUR;
        }
    }

    public void chooseRarity() {

        double chance = random.nextDouble();

        if(chance < 0.7) {
            rarity = Rarity.COMMON;
            if (chance < 0.4) {
                rarity = Rarity.RARE;
                if (chance < 0.1) {
                    rarity = Rarity.LEGENDARY;
                }
            }
        }
    }

    public void genStats() {

    }

    public enum Rarity {
        COMMON,
        RARE,
        LEGENDARY
    }

    public enum Type {
        WEAPON,
        ARMOUR

    }



}
