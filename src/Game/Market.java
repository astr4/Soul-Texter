package Game;

import java.security.SecureRandom;
import java.util.Scanner;

public class Market {
    private static boolean first;
    private static SecureRandom generator = new SecureRandom();
    private static int chance;
    private static int possibility;
    private static int SecureRandom(int x) {
        return generator.nextInt(x);
    }
    private static int z = 0;
    public static int getChance() {
        setChance(SecureRandom(101));
        return chance;
    }

    public static void setChance(int chance) {
        Market.chance = chance;
    }

    public static int getPossibility() {
        return possibility;
    }

    public static void setPossibility(int possibility) {
        Market.possibility = possibility;
    }


    //Prices
    private static final int PRICE_OF_COPPER_SWORD = 50;
    private static final int PRICE_OF_IRON_SWORD = 100;
    private static final int PRICE_OF_GOLDEN_SWORD = 150;

    private static final int PRICE_OF_COPPER_HELMET = 25;
    private static final int PRICE_OF_COPPER_SHOULDER = 25;
    private static final int PRICE_OF_COPPER_CHEST = 35;
    private static final int PRICE_OF_COPPER_PANTS = 30;
    private static final int PRICE_OF_COPPER_BOOTS = 20;

    private static final int PRICE_OF_IRON_HELMET = 50;
    private static final int PRICE_OF_IRON_SHOULDER = 50;
    private static final int PRICE_OF_IRON_CHEST = 65;
    private static final int PRICE_OF_IRON_PANTS = 60;
    private static final int PRICE_OF_IRON_BOOTS = 45;

    private static final int PRICE_OF_GOLDEN_HELMET = 75;
    private static final int PRICE_OF_GOLDEN_SHOULDER = 75;
    private static final int PRICE_OF_GOLDEN_CHEST = 95;
    private static final int PRICE_OF_GOLDEN_PANTS = 90;
    private static final int PRICE_OF_GOLDEN_BOOTS = 70;

    private static final int PRICE_OF_STAMINA_PILL = 5;
    private static final int PRICE_OF_HEALTH_POTION = 15;
    private static final int PRICE_OF_MANA_POTION = 10;

    private static final int PRICE_OF_COPPER_SHIELD = 50;
    private static final int PRICE_OF_IRON_SHIELD = 100;
    private static final int PRICE_OF_GOLDEN_SHIELD = 150;

    public static int getPriceOfCOPPER_SWORD() {
        return PRICE_OF_COPPER_SWORD;
    }
    public static int getPriceOfIRON_SWORD() {
        return PRICE_OF_IRON_SWORD;
    }
    public static int getPriceOfGOLDEN_SWORD() {
        return PRICE_OF_GOLDEN_SWORD;
    }
    public static int getPriceOfCOPPER_SHIELD() {
        return PRICE_OF_COPPER_SHIELD;
    }
    public static int getPriceOfIRON_SHIELD() {
        return PRICE_OF_IRON_SHIELD;
    }
    public static int getPriceOfGOLDEN_SHIELD() {
        return PRICE_OF_GOLDEN_SHIELD;
    }
    public static int getPriceOfCOPPER_HELMET(){
        return PRICE_OF_COPPER_HELMET;
    }
    public static int getPriceOfCOPPER_SHOULDER(){
        return PRICE_OF_COPPER_SHOULDER;
    }
    public static int getPriceOfCOPPER_CHEST(){
        return PRICE_OF_COPPER_CHEST;
    }
    public static int getPriceOfCOPPER_PANTS(){
        return PRICE_OF_COPPER_PANTS;
    }
    public static int getPriceOfCOPPER_BOOTS(){
        return PRICE_OF_COPPER_BOOTS;
    }
    public static int getPriceOfIRON_HELMET(){
        return PRICE_OF_IRON_HELMET;
    }
    public static int getPriceOfIRON_SHOULDER(){
        return PRICE_OF_IRON_SHOULDER;
    }
    public static int getPriceOfIRON_CHEST(){
        return PRICE_OF_IRON_CHEST;
    }
    public static int getPriceOfIRON_PANTS(){
        return PRICE_OF_IRON_PANTS;
    }
    public static int getPriceOfIRON_BOOTS(){
        return PRICE_OF_IRON_BOOTS;
    }
    public static int getPriceOfGOLDEN_HELMET(){
        return PRICE_OF_GOLDEN_HELMET;
    }
    public static int getPriceOfGOLDEN_SHOULDER(){
        return PRICE_OF_GOLDEN_SHOULDER;
    }
    public static int getPriceOfGOLDEN_CHEST(){
        return PRICE_OF_GOLDEN_CHEST;
    }
    public static int getPriceOfGOLDEN_PANTS(){
        return PRICE_OF_GOLDEN_PANTS;
    }
    public static int getPriceOfGOLDEN_BOOTS(){
        return PRICE_OF_GOLDEN_BOOTS;
    }
    public static int getPriceOfStaminaPill() {
        return PRICE_OF_STAMINA_PILL;
    }
    public static int getPriceOfHealth_POTION() {
        return PRICE_OF_HEALTH_POTION;
    }
    public static int getPriceOfMANA_POTION() {
        return PRICE_OF_MANA_POTION;
    }

    public static boolean isFirst() {
        return first;
    }

    public static void setFirst(boolean first) {
        Market.first = first;
    }

    public static void currentEquipment(Player player){

        System.out.println("CURRENT EQUIPMENT:");

        System.out.println(player.getWeapon()+" attack: "+player.getCurrentWeaponDamage());
        System.out.println(player.getShield()+" defence: "+player.getShieldValue());

        System.out.println(player.getHead()+" defence: "+ player.getHeadValue());
        System.out.println(player.getShoulder()+" defence: "+player.getShoulderValue());
        System.out.println(player.getChest()+" defence: "+player.getChestValue());
        System.out.println(player.getPants()+" defence: "+player.getPantsValue());
        System.out.println(player.getBoots()+" defence: "+player.getBootsValue());
        System.out.println("Total armor"+" defence: "+player.getArmor());
        System.out.println("POTIONS YOU HAVE:");
        System.out.println("stamina pill: "+player.getStaminaPill());
        System.out.println("health potion: "+player.getHealthPotion());
        System.out.println("mana potion: "+player.getManaPotion());

        System.out.println("You Have " + player.getGold() + " Soul(Gold)");
    }
    public static void market(Player player) {
        Scanner input = new Scanner(System.in);
        if (player.getHealthPoint() > 0) {
            BackGroundMusic.market();
            Voices.play(Voices.WelcomeToTheShop);;
            if(isFirst()){
                Voices.play(Voices.hiStranger);
                System.out.println("Enter your name: ");
                String name = input.next();
                player.setName(name);
                System.out.println("Welcome " + player.getName());
                Voices.play(Voices.WhataNiceName);
                Voices.play(Voices.WelcomeToSoulTexter);
                setFirst(false);
            }
            int i = 0;
            boolean okay = true;
            while (okay) {
                currentEquipment(player);
                if (i == 0) {
                    System.out.println("Do you want to buy something? Y/N");//sound
                    if (z % 2 == 0)
                        Voices.play(Voices.UwannaBuySomething);
                    if (z % 2 == 1)
                        Voices.play(Voices.YouAreHereToVisitMe);
                    z++;
                    ++i;
                }
                else {
                    System.out.println("Do you want to buy something else? Y/N");//sound
                    Voices.play(Voices.WannaBuySomethingElse);
                    ++i;
                }
                String answer = input.next();
                if (answer.equals("n") || answer.equals("N") || answer.equals("No") || answer.equals("NO") || answer.equals("no"))
                    break;
                else {
                    setPossibility(getChance());
                    if (getPossibility()>=0 && getPossibility() <=33){
                        Voices.play(Voices.HowAreYa);
                    }
                    if (getPossibility()>33 && getPossibility() <=66){
                        Voices.play(Voices.AreUlookingforSomethingSpesific);
                    }
                    if (getPossibility()>66 && getPossibility() <=100) {
                        Voices.play(Voices.WhatsOnYourMind);
                    }
                    System.out.println("Welcome to Shop!");
                    System.out.println("1 for Weapons");
                    System.out.println("2 for Armors");
                    System.out.println("3 for Potions");
                    System.out.println("4 for Shields");
                    System.out.println("5 to quit");

                    /////////////////////////   EXCEPTION HANDLING
                    int choice = 0;
                    boolean loopChoice = true;
                    do {
                        try {
                            choice = input.nextInt();
                            loopChoice = false;
                        }
                        catch (Exception e) {
                            System.err.println("Exception has occurred!!! ");
                            System.err.println(e);
                            System.err.println("try again");
                            input.nextLine();
                        }
                    } while(loopChoice);
                    switch (choice) {
                        case 1:
                            weapons();

                           //   EXCEPTION HANDLING
                            int weapon = 0;
                            boolean weaponLoop = true;
                            do {
                                try {
                                    weapon = input.nextInt();
                                    weaponLoop = false;
                                }
                                catch (Exception e) {
                                    System.err.println("Exception has occurred!!! ");
                                    System.err.println(e);
                                    System.err.println("try again");
                                    input.nextLine();
                                }
                            } while(weaponLoop);

                            switch (weapon) {
                                case 1:
                                    if (player.getGold() >= getPriceOfCOPPER_SWORD()) {
                                        player.setGold(player.getGold() - getPriceOfCOPPER_SWORD());
                                        player.setWeapon("copperSword");
                                        player.setCurrentWeaponDamage("copperSword");
                                        System.out.println("you bought copper sword");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;

                                case 2:
                                    if (player.getGold() >= getPriceOfIRON_SWORD()) {
                                        player.setGold(player.getGold() - getPriceOfIRON_SWORD());
                                        player.setWeapon("ironSword");
                                        player.setCurrentWeaponDamage("ironSword");
                                        System.out.println("you bought iron sword");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 3:
                                    if (player.getGold() >= getPriceOfGOLDEN_SWORD()) {
                                        player.setGold(player.getGold() - getPriceOfGOLDEN_SWORD());
                                        player.setWeapon("goldenSword");
                                        player.setCurrentWeaponDamage("goldenSword");
                                        System.out.println("you bought golden sword");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    }
                                    else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                default:
                                    System.out.println("invalid choice");
                            }
                            break;

                        case 2:
                            armors();

                          //   EXCEPTION HANDLING
                            int armor = 0;
                            boolean armorLoop = true;
                            do {
                                try {
                                    armor = input.nextInt();
                                    armorLoop = false;
                                }
                                catch (Exception e) {
                                    System.err.println("Exception has occurred!!! ");
                                    System.err.println(e);
                                    System.err.println("try again");
                                    input.nextLine();
                                }
                            } while(armorLoop);

                            switch (armor) {
                                case 1:
                                    if (player.getGold() >= getPriceOfCOPPER_HELMET()) {
                                        player.setGold(player.getGold() - getPriceOfCOPPER_HELMET());
                                        player.setHead("copperHelmet");
                                        player.setHeadValue("copperHelmet");
                                        player.setArmor();
                                        System.out.println("you bought copper helmet");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    }
                                    else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 2:
                                    if (player.getGold() >= getPriceOfCOPPER_SHOULDER()) {
                                        player.setGold(player.getGold() - getPriceOfCOPPER_SHOULDER());
                                        player.setShoulder("copperShoulder");
                                        player.setShoulderValue("copperShoulder");
                                        player.setArmor();
                                        System.out.println("you bought copper shoulder");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 3:
                                    if (player.getGold() >= getPriceOfCOPPER_CHEST()) {
                                        player.setGold(player.getGold() - getPriceOfCOPPER_CHEST());
                                        player.setChest("copperChest");
                                        player.setChestValue("copperChest");
                                        player.setArmor();
                                        System.out.println("you bought copper chest");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 4:
                                    if (player.getGold() >= getPriceOfCOPPER_PANTS()) {
                                        player.setGold(player.getGold() - getPriceOfCOPPER_PANTS());
                                        player.setPants("copperPants");
                                        player.setPantsValue("copperPants");
                                        player.setArmor();
                                        System.out.println("you bought copper pants");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 5:
                                    if (player.getGold() >= getPriceOfCOPPER_BOOTS()) {
                                        player.setGold(player.getGold() - getPriceOfCOPPER_BOOTS());
                                        player.setBoots("copperBoots");
                                        player.setBootsValue("copperBoots");
                                        player.setArmor();
                                        System.out.println("you bought copper boots");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 6:
                                    if (player.getGold() >= getPriceOfIRON_HELMET()) {
                                        player.setGold(player.getGold() - getPriceOfIRON_HELMET());
                                        player.setHead("ironHelmet");
                                        player.setHeadValue("ironHelmet");
                                        player.setArmor();
                                        System.out.println("you bought iron helmet");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 7:
                                    if (player.getGold() >= getPriceOfIRON_SHOULDER()) {
                                        player.setGold(player.getGold() - getPriceOfIRON_SHOULDER());
                                        player.setShoulder("ironShoulder");
                                        player.setShoulderValue("ironShoulder");
                                        player.setArmor();
                                        System.out.println("you bought iron shoulder");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 8:
                                    if (player.getGold() >= getPriceOfIRON_CHEST()) {
                                        player.setGold(player.getGold() - getPriceOfIRON_CHEST());
                                        player.setChest("ironChest");
                                        player.setChestValue("ironChest");
                                        player.setArmor();
                                        System.out.println("you bought iron chest");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 9:
                                    if (player.getGold() >= getPriceOfIRON_PANTS()) {
                                        player.setGold(player.getGold() - getPriceOfIRON_PANTS());
                                        player.setPants("ironPants");
                                        player.setPantsValue("ironPants");
                                        player.setArmor();
                                        System.out.println("you bought iron pants");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 10:
                                    if (player.getGold() >= getPriceOfIRON_BOOTS()) {
                                        player.setGold(player.getGold() - getPriceOfIRON_BOOTS());
                                        player.setBoots("ironBoots");
                                        player.setBootsValue("ironBoots");
                                        player.setArmor();
                                        System.out.println("you bought iron boots");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 11:
                                    if (player.getGold() >= getPriceOfGOLDEN_HELMET()) {
                                        player.setGold(player.getGold() - getPriceOfGOLDEN_HELMET());
                                        player.setHead("goldenHelmet");
                                        player.setHeadValue("goldenHelmet");
                                        player.setArmor();
                                        System.out.println("you bought golden helmet");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 12:
                                    if (player.getGold() >= getPriceOfGOLDEN_SHOULDER()) {
                                        player.setGold(player.getGold() - getPriceOfGOLDEN_SHOULDER());
                                        player.setShoulder("goldenShoulder");
                                        player.setShoulderValue("goldenShoulder");
                                        player.setArmor();
                                        System.out.println("you bought golden shoulder");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 13:
                                    if (player.getGold() >= getPriceOfGOLDEN_CHEST()) {
                                        player.setGold(player.getGold() - getPriceOfGOLDEN_CHEST());
                                        player.setChest("goldenChest");
                                        player.setChestValue("goldenChest");
                                        player.setArmor();
                                        System.out.println("you bought golden chest");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 14:
                                    if (player.getGold() >= getPriceOfGOLDEN_PANTS()) {
                                        player.setGold(player.getGold() - getPriceOfGOLDEN_PANTS());
                                        player.setPants("goldenPants");
                                        player.setPantsValue("goldenPants");
                                        player.setArmor();
                                        System.out.println("you bought golden pants");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 15:
                                    if (player.getGold() >= getPriceOfGOLDEN_BOOTS()) {
                                        player.setGold(player.getGold() - getPriceOfGOLDEN_BOOTS());
                                        player.setBoots("goldenBoots");
                                        player.setBootsValue("goldenBoots");
                                        player.setArmor();
                                        System.out.println("you bought golden boots");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;

                                default:
                                    System.out.println("invalid choice");
                            }
                            break;
                        case 3:
                            potions();

                            /////////////////////////   EXCEPTION HANDLING
                            int potion = 0;
                            boolean potionLoop = true;
                            do {
                                try {
                                    potion = input.nextInt();
                                    potionLoop = false;
                                } catch (Exception e) {
                                    System.err.println("Exception has occurred!!! ");
                                    System.err.println(e);
                                    System.err.println("try again");
                                    input.nextLine();
                                }
                            } while(potionLoop);
                            /////////////////////////

                            switch (potion) {
                                case 1:
                                    if (player.getGold() >= getPriceOfStaminaPill()) {
                                        player.setGold(player.getGold() - getPriceOfStaminaPill());
                                        player.setStaminaPill(player.getStaminaPill() + 1);
                                        System.out.println("you bought stamina pill");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 2:
                                    if (player.getGold() >= getPriceOfHealth_POTION()) {
                                        player.setGold(player.getGold() - getPriceOfHealth_POTION());
                                        player.setHealthPotion(player.getHealthPotion() + 1);
                                        System.out.println("you bought health potion");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 3:
                                    if (player.getGold() >= getPriceOfMANA_POTION()) {
                                        player.setGold(player.getGold() - getPriceOfMANA_POTION());
                                        player.setManaPotion(player.getManaPotion() + 1);
                                        System.out.println("you bought mana potion");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    } else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;

                                default:
                                    System.out.println("invalid choice");
                            }
                            break;

                        case 4:
                            shields();

                            /////////////////////////   EXCEPTION HANDLING
                            int shield = 0;
                            boolean shieldLoop = true;
                            do {
                                try {
                                    shield = input.nextInt();
                                    shieldLoop = false;
                                } catch (Exception e) {
                                    System.err.println("Exception has occurred!!! ");
                                    System.err.println(e);
                                    System.err.println("try again");
                                    input.nextLine();
                                }
                            } while(shieldLoop);

                            switch (shield) {
                                case 1:
                                    if (player.getGold() >= getPriceOfCOPPER_SHIELD()) {
                                        player.setGold(player.getGold() - getPriceOfCOPPER_SHIELD());
                                        player.setShield("copperShield");
                                        player.setShieldValue("copperShield");
                                        System.out.println("you bought copper shield");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    }
                                    else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 2:
                                    if (player.getGold() >= getPriceOfIRON_SHIELD()) {
                                        player.setGold(player.getGold() - getPriceOfIRON_SHIELD());
                                        player.setShield("ironShield");
                                        player.setShieldValue("ironShield");
                                        System.out.println("you bought iron shield");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    }
                                    else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;
                                case 3:
                                    if (player.getGold() >= getPriceOfGOLDEN_SHIELD()) {
                                        player.setGold(player.getGold() - getPriceOfGOLDEN_SHIELD());
                                        player.setShield("goldenShield");
                                        player.setShieldValue("goldenShield");
                                        System.out.println("you bought golden shield");
                                        SoundEffects.play(SoundEffects.Gold);
                                        Voices.play(Voices.SeeYaSoon);
                                    }
                                    else {
                                        System.out.println("not enough gold");
                                        Voices.play(Voices.NotEnoughGold);
                                    }
                                    break;

                                default:
                                    System.out.println("invalid choice");
                            }
                            break;
                        case 5:
                            okay = false;
                            break;
                        default:
                            System.out.println("invalid choice");
                    }
                }
            }
        }
    }
    private static void weapons(){
        System.out.printf("%-25s%-20s%-10s%n","WEAPONS","ATTACK VALUE","COINS");
        System.out.printf("%-25s%-20s%-10s%n","1>>>copper sword",Items.getFirstOfCopperSword()+"-"+Items.getSecondOfcopperSword(),getPriceOfCOPPER_SWORD()+" §");
        System.out.printf("%-25s%-20s%-10s%n","2>>>iron sword",Items.getFirstOfironSword()+"-"+Items.getSecondOfironSword(),getPriceOfIRON_SWORD()+" §");
        System.out.printf("%-25s%-20s%-10s%n","3>>>golden sword",Items.getFirstOfGoldenSword()+"-"+Items.getSecondOfGoldenSword(),getPriceOfGOLDEN_SWORD()+" §");
    }
    private static void armors(){

        System.out.printf("%-25s%-20s%-10s%n","COPPER ARMORS","DEFENCE VALUE","COINS");
        System.out.printf("%-25s%-20s%-10s%n","1>>>copper helmet",Items.getCopperHelmet(),getPriceOfCOPPER_HELMET()+" §");
        System.out.printf("%-25s%-20s%-10s%n","2>>>copper shoulder",Items.getCopperShoulder(),getPriceOfCOPPER_SHOULDER()+" §");
        System.out.printf("%-25s%-20s%-10s%n","3>>>copper chest",Items.getCopperChest(),getPriceOfCOPPER_CHEST()+" §");
        System.out.printf("%-25s%-20s%-10s%n","4>>>copper pants",Items.getCopperPants(),getPriceOfCOPPER_PANTS()+" §");
        System.out.printf("%-25s%-20s%-10s%n","5>>>copper boots",Items.getCopperBoots(),getPriceOfCOPPER_BOOTS()+" §");


        System.out.printf("%-25s%-20s%-10s%n","IRON ARMORS","DEFENCE VALUE","COINS");
        System.out.printf("%-25s%-20s%-10s%n","6>>>iron helmet",Items.getIronHelmet(),getPriceOfIRON_HELMET()+" §");
        System.out.printf("%-25s%-20s%-10s%n","7>>>iron shoulder",Items.getIronShoulder(),getPriceOfIRON_SHOULDER()+" §");
        System.out.printf("%-25s%-20s%-10s%n","8>>>iron chest",Items.getIronChest(),getPriceOfIRON_CHEST()+" §");
        System.out.printf("%-25s%-20s%-10s%n","9>>>iron pants",Items.getIronPants(),getPriceOfIRON_PANTS()+" §");
        System.out.printf("%-25s%-20s%-10s%n","10>>>iron boots",Items.getIronBoots(),getPriceOfIRON_BOOTS()+" §");


        System.out.printf("%-25s%-20s%-10s%n","GOLDEN ARMORS","DEFENCE VALUE","COINS");
        System.out.printf("%-25s%-20s%-10s%n","11>>>golden helmet",Items.getGoldenHelmet(),getPriceOfGOLDEN_HELMET()+" §");
        System.out.printf("%-25s%-20s%-10s%n","12>>>golden shoulder",Items.getGoldenShoulder(),getPriceOfGOLDEN_SHOULDER()+" §");
        System.out.printf("%-25s%-20s%-10s%n","13>>>golden chest",Items.getGoldenChest(),getPriceOfGOLDEN_CHEST()+" §");
        System.out.printf("%-25s%-20s%-10s%n","14>>>golden pants",Items.getGoldenPants(),getPriceOfGOLDEN_PANTS()+" §");
        System.out.printf("%-25s%-20s%-10s%n","15>>>golden boots",Items.getGoldenBoots(),getPriceOfGOLDEN_BOOTS()+" §");
    }
    private static void potions(){
        System.out.printf("%-25s%-20s%-10s%n","POTIONS","EFFECT ","COINS");
        System.out.printf("%-25s%-20s%-10s%n","1>>>stamina pill",Items.getStaminaPill(),getPriceOfStaminaPill()+" §");
        System.out.printf("%-25s%-20s%-10s%n","2>>>health potion",Items.getHealthPotion(),getPriceOfHealth_POTION()+" §");
        System.out.printf("%-25s%-20s%-10s%n","3>>>mana potion",Items.getManaPotion(),getPriceOfMANA_POTION()+" §");
    }
    private static void shields(){
        System.out.printf("%-25s%-20s%-10s%n","SHIELDS","DEFENCE VALUE","COINS");
        System.out.printf("%-25s%-20s%-10s%n","1>>>copper shield",Items.getCopperShield(),getPriceOfCOPPER_SHIELD()+" §");
        System.out.printf("%-25s%-20s%-10s%n","2>>>iron shield",Items.getIronShield(),getPriceOfIRON_SHIELD()+" §");
        System.out.printf("%-25s%-20s%-10s%n","3>>>golden shield",Items.getGoldenShield(),getPriceOfGOLDEN_SHIELD()+" §");
    }
}
