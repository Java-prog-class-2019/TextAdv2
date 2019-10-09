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
        genStats();

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

        /* TODO:
            Add stat generation based on rarity. Make sure to
            generate stats for weapons and armour differently
            ( i.e. armour should't give power and weapons
            shouldn't give armour )
        */

        if (type == Type.WEAPON) {




        }

        if (type == Type.ARMOUR) {

        }

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
