package Game;

import java.security.SecureRandom;

public class Items {
    private static SecureRandom generator = new SecureRandom();
    private static int woodenSword;
    private static int copperSword;
    private static int ironSword;
    private static int goldenSword;

    private static int firstOfWoodenSword = 19;
    private static int secondOfWoodenSword = 25;
    private static int firstOfCopperSword = 24;
    private static int secondOfCopperSword = 30;
    private static int firstOfIronSword = 29;
    private static int secondOfIronSword = 35;
    private static int firstOfGoldenSword =34;
    private static int secondOfGoldenSword =40;

    private static int woodenHelmet = 3;
    private static int woodenShoulder = 3;
    private static int woodenChest = 5;
    private static int woodenPants = 4;
    private static int woodenBoots = 3;
    private static int woodenShield = 4;

    private static int copperHelmet = 4;
    private static int copperShoulder = 4;
    private static int copperChest = 6;
    private static int copperPants = 5;
    private static int copperBoots = 4;
    private static int copperShield = 5;

    private static int ironHelmet = 5;
    private static int ironShoulder = 5;
    private static int ironChest = 7;
    private static int ironPants = 6;
    private static int ironBoots = 5;
    private static int ironShield = 6;

    private static int goldenHelmet = 6;
    private static int goldenShoulder = 6;
    private static int goldenChest = 8;
    private static int goldenPants = 7;
    private static int goldenBoots = 6;
    private static int goldenShield = 7;


    private static int staminaPill = 5;
    private static int healthPotion = 50;
    private static int manaPotion = 5;

    private static int randomGenerator(int x, int y) {
        return generator.nextInt(y) + x;
    }

    public static int getFirstOfCopperSword() {
        return firstOfCopperSword;
    }

    public static int getSecondOfcopperSword() {
        return secondOfCopperSword;
    }

    public static int getFirstOfironSword() {
        return firstOfIronSword;
    }

    public static int getSecondOfironSword() {
        return secondOfIronSword;
    }

    public static int getFirstOfGoldenSword() {
        return firstOfGoldenSword;
    }

    public static int getSecondOfGoldenSword() {
        return secondOfGoldenSword;
    }

    public static int getFirstOfWoodenSword() {
        return firstOfWoodenSword;
    }

    public static int getSecondOfWoodenSword() {
        return secondOfWoodenSword;
    }

    public static int getWoodenSword() {
        woodenSword = (randomGenerator(getFirstOfWoodenSword(),(getSecondOfWoodenSword()-getFirstOfWoodenSword())));
        return woodenSword;
    }

    public static int getCopperSword() {
        copperSword = (randomGenerator(getFirstOfCopperSword(),(getSecondOfcopperSword()- getFirstOfCopperSword())));
        return copperSword;
    }

    public static int getIronSword() {
        ironSword = (randomGenerator(getFirstOfironSword(),(getSecondOfironSword()-getFirstOfironSword())));
        return ironSword;
    }

    public static int getGoldenSword() {
        goldenSword = (randomGenerator(getFirstOfGoldenSword(),(getSecondOfGoldenSword()-getFirstOfGoldenSword())));
        return goldenSword;
    }

    public static int getWoodenHelmet() {
        return woodenHelmet;
    }

    public static int getWoodenShoulder() {
        return woodenShoulder;
    }

    public static int getWoodenChest() {
        return woodenChest;
    }

    public static int getWoodenPants() {
        return woodenPants;
    }

    public static int getWoodenBoots() {
        return woodenBoots;
    }


    public static int getWoodenShield() {
        return woodenShield;
    }

    public static int getCopperHelmet() {
        return copperHelmet;
    }

    public static int getCopperShoulder() {
        return copperShoulder;
    }

    public static int getCopperChest() {
        return copperChest;
    }

    public static int getCopperPants() {
        return copperPants;
    }

    public static int getCopperBoots() {
        return copperBoots;
    }

    public static int getCopperShield() {
        return copperShield;
    }

    public static int getIronHelmet() {
        return ironHelmet;
    }

    public static int getIronShoulder() {
        return ironShoulder;
    }

    public static int getIronChest() {
        return ironChest;
    }

    public static int getIronPants() {
        return ironPants;
    }

    public static int getIronBoots() {
        return ironBoots;
    }

    public static int getIronShield() {
        return ironShield;
    }

    public static int getGoldenHelmet() {
        return goldenHelmet;
    }

    public static int getGoldenShoulder() {
        return goldenShoulder;
    }

    public static int getGoldenChest() {
        return goldenChest;
    }
    public static int getGoldenPants() {
        return goldenPants;
    }

    public static int getGoldenBoots() {
        return goldenBoots;
    }

    public static int getGoldenShield() {
        return goldenShield;
    }

    public static int getStaminaPill() {
        return staminaPill;
    }

    public static int getHealthPotion() {
        return healthPotion;
    }

    public static int getManaPotion() {
        return manaPotion;
    }
}