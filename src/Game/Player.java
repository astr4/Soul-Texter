package Game;

import java.security.SecureRandom;
import java.util.Scanner;

public  class Player implements InterfaceOfPlayer {
    private String name;
    private int healthPoint;
    private int stamina;
    private int mana;
    private int gold;
    private int lvl;
    private double exp;
    private boolean alive;

    private int maxHealthPoint;
    private int maxStamina;
    private int maxMana;

    private String weapon;
    private int currentWeapon;
    private int hit;

    private int powerHit;
    private int powerAttack;
    private boolean attackType1;
    private boolean energyType1;
    private int armor;

    private String shield;
    private String head;
    private String shoulder;
    private String chest;
    private String pants;
    private String boots;
    private boolean shieldUpped;

    private String currentWeaponDamage;
    private int shieldValue;
    private int headValue;
    private int shoulderValue;
    private int chestValue;
    private int pantsValue;
    private int bootsValue;

    private int staminaPill;
    private int healthPotion;
    private int manaPotion;

    private static int escape;
    private int chance;

    private int criticalHit;
    private boolean critic;

    private int missHit;
    private boolean miss;

    private boolean potionUsege;

    private SecureRandom generator = new SecureRandom();

    private int SecureRandom(int x) {
        return generator.nextInt(x);
    }

    public Player(){
        setAlive(true);
        setExp(0);
        setLvl(getExp());
        setGold(0);

        setWeapon("woodenSword");
        setHead("woodenHelmet");
        setShoulder("woodenShoulder");
        setChest("woodenChest");
        setPants("woodenPants");
        setBoots("woodenBoots");
        setShield("woodenShield");

        setShieldValue(getShield());
        setHeadValue(getHead());
        setShoulderValue(getShoulder());
        setChestValue(getChest());
        setPantsValue(getPants());
        setBootsValue(getBoots());

        setCurrentWeaponDamage(getWeapon());
        setPowerAttack(randomGenerator(50,50));
        setArmor();
        this.attackType1 = true;
        this.energyType1 = true;

        setStaminaPill(0);
        setHealthPotion(0);
        setManaPotion(0);
    }
    private int randomGenerator(int x, int y) {
        return generator.nextInt(y) + x;
    }
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
        if(!(isAlive()))
            SoundEffects.play(SoundEffects.PlayerDies);
    }

    public boolean isPotionUsege() {
        return potionUsege;
    }

    public void setPotionUsege(boolean potionUsege) {
        this.potionUsege = potionUsege;
    }

    public boolean isShieldUpped() {
        return shieldUpped;
    }

    public void setShieldUpped(boolean shieldUpped) {
        this.shieldUpped = shieldUpped;
    }

    public int getMissHit() {
        setMissHit(getChance());
        return missHit;
    }

    public boolean isEnergyType1() {
        return energyType1;
    }

    public void setEnergyType1() {
        if (isEnergyType1())
            this.attackType1 = false;
        else
            this.attackType1 = true;
    }

    public boolean isAttackType1() {
        return attackType1;
    }

    public void setAttackType1() {
        if (isAttackType1())
            this.attackType1 = false;
        else
            this.attackType1 = true;
    }

    public void setMissHit(int missHit) {
        this.missHit = missHit;
        if (criticalHit > 50 && criticalHit < 55)
            setMiss(true);
        else
            setMiss(false);
    }

    public boolean isMiss() {
        return miss;
    }

    public void setMiss(boolean miss) {
        this.miss = miss;
    }

    public boolean isCritic() {
        return critic;
    }

    public void setCritic(boolean critic) {
        this.critic = critic;
    }

    public int getCriticalHit() {
        setCriticalHit(getChance());
        return criticalHit;
    }

    public void setCriticalHit(int criticalHit) {
        this.criticalHit = criticalHit;
        if (criticalHit > 45 && criticalHit < 55)
            setCritic(true);
        else
            setCritic(false);
    }

    public static int getEscape() {
        return escape;
    }

    public void setChance(int x) {
        chance = x;
    }

    public void setEscape(int escape) {
        this.escape = escape;
    }

    public int getChance() {
        setChance(SecureRandom(101));
        return chance;
    }

    public int getLvl() {
        return lvl;
    }
    public void leveled() {
      setHealthPoint(getMaxHealthPoint());
      setStamina(getMaxStamina());
      setMana(getMaxMana());
      SoundEffects.play(SoundEffects.LvlUp);
      System.out.println("LVL UP!");
      System.out.println("Your Lvl is " + getLvl());
      System.out.println("Your Hp: " + getHealthPoint());
      System.out.println("Your Stamina: " + getStamina());
      System.out.println("Your Mana: " + getMana());
    }

    public void setLvl(double exp) {

        if(exp >=0 && exp < 100 && getLvl()!= 1) {
            this.lvl = 1;
            setMaxHealthPoint(200);
            setMaxStamina(10);
            setMaxMana(10);
            setHealthPoint(getMaxHealthPoint());
            setStamina(getMaxStamina());
            setMana(getMaxMana());
        }
       else if(exp >= 100 && exp < 250 &&  getLvl()!= 2) {
            this.lvl = 2;
            setMaxHealthPoint(210);
            setMaxStamina(12);
            setMaxMana(12);
            leveled();
        }
        else if(exp >=250 && exp < 450 && getLvl()!= 3) {
            this.lvl = 3;
            setMaxHealthPoint(220);
            setMaxStamina(14);
            setMaxMana(14);
            leveled();
        }
        else if(exp >=450 && exp < 700 && getLvl()!= 4) {
            this.lvl = 4;
            setMaxHealthPoint(230);
            setMaxStamina(16);
            setMaxMana(16);
            leveled();
        }
        else if(exp >=700 && exp < 1000 && getLvl()!= 5) {
            this.lvl = 5;
            setMaxHealthPoint(240);
            setMaxStamina(18);
            setMaxMana(18);
            leveled();
        }
        else if(exp >=1000 && exp < 1400 && getLvl()!= 6) {
            this.lvl = 6;
            setMaxHealthPoint(250);
            setMaxStamina(20);
            setMaxMana(20);
            leveled();
        }
        else if(exp >=1400 && exp < 1900 && getLvl()!= 7) {
            this.lvl = 7;
            setMaxHealthPoint(260);
            setMaxStamina(22);
            setMaxMana(22);
            leveled();
        }
        else if(exp >=1900 && exp < 2500 && getLvl()!= 8) {
            this.lvl = 8;
            setMaxHealthPoint(270);
            setMaxStamina(24);
            setMaxMana(24);
            leveled();
        }
        else if(exp >=2500 && exp < 3200 && getLvl()!= 9) {
            this.lvl = 9;
            setMaxHealthPoint(280);
            setMaxStamina(26);
            setMaxMana(26);
            leveled();
        }
        else if(exp >=3200 && exp < 4000 && getLvl()!= 10) {
            this.lvl = 10;
            setMaxHealthPoint(290);
            setMaxStamina(30);
            setMaxMana(30);
            leveled();
        }
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public String getCurrentWeaponDamage() {
        setCurrentWeaponDamage(getWeapon());
        return currentWeaponDamage;
    }

    public void setCurrentWeaponDamage(String weapon) {
        if (weapon.equals("woodenSword"))
            this.currentWeaponDamage = Items.getFirstOfWoodenSword() + " - " +Items.getSecondOfWoodenSword();
        if (weapon.equals("copperSword"))
            this.currentWeaponDamage = Items.getFirstOfCopperSword() + " - " +Items.getSecondOfcopperSword();
        if (weapon.equals("ironSword"))
            this.currentWeaponDamage = Items.getFirstOfironSword() + " - " +Items.getSecondOfironSword();
        if (weapon.equals("goldenSword"))
            this.currentWeaponDamage = Items.getFirstOfGoldenSword() + " - " +Items.getSecondOfGoldenSword();
    }
    public int getMaxHealthPoint() {
        return maxHealthPoint;
    }

    public void setMaxHealthPoint(int maxHealthPoint) {
        this.maxHealthPoint = maxHealthPoint;
    }

    public int getMaxStamina() {
        return maxStamina;
    }

    public void setMaxStamina(int maxStamina) {
        this.maxStamina = maxStamina;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getStaminaPill() {
        return staminaPill;
    }

    public void setStaminaPill(int staminaPill) {
        this.staminaPill = staminaPill;
    }

    public int getManaPotion() {
        return manaPotion;
    }

    public void setManaPotion(int manaPotion) {
        this.manaPotion = manaPotion;
    }

    public void setArmor() {

        this.armor = 0;
        this.armor += getHeadValue();
        this.armor += getShoulderValue();
        this.armor += getChestValue();
        this.armor += getPantsValue();
        this.armor += getBootsValue();
    }

    public String getShield() {
        return shield;
    }

    public void setShield(String shield) {
        this.shield = shield;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getArmor() {
        return armor;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana > getMaxMana())
            this.mana = getMaxMana();
        else if(mana < 0)
            this.mana = 0;
        else
            this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPotion() {
        return healthPotion;
    }

    public void setHealthPotion(int healthPotion) {
        this.healthPotion = healthPotion;
    }

    public int getPowerAttack() {
        setPowerAttack(randomGenerator(50,50));
        return powerAttack;
    }

    public void setPowerAttack(int powerAttack) {
        this.powerAttack = powerAttack;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina > getMaxStamina())
            this.stamina = getMaxStamina();
        if(stamina < 0)
            this.stamina = 0;
        else if(stamina <= getMaxStamina())
            this.stamina = stamina;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }

    public void setShoulder(String shoulder) {
        this.shoulder = shoulder;
    }

    public String getShoulder() {
        return shoulder;
    }

    public void setChest(String chest) {
        this.chest = chest;
    }

    public String getChest() {
        return chest;
    }

    public void setPants(String pants) {
        this.pants = pants;
    }

    public String getPants() {
        return pants;
    }

    public void setBoots(String boots) {
        this.boots = boots;
    }

    public String getBoots() {
        return boots;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setCurrentWeapon(int currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public int getCurrentWeapon(String weapon) {

        if (weapon.equals("woodenSword"))
            setCurrentWeapon(Items.getWoodenSword());
        if (weapon.equals("copperSword"))
            setCurrentWeapon(Items.getCopperSword());
        if (weapon.equals("ironSword"))
            setCurrentWeapon(Items.getIronSword());
        if (weapon.equals("goldenSword"))
            setCurrentWeapon(Items.getGoldenSword());

        return currentWeapon;
    }

    public void setHealthPoint(int healthPoint) {
        if (healthPoint > getMaxHealthPoint())
            this.healthPoint = getMaxHealthPoint();
        if(healthPoint < 0)
            this.healthPoint = 0;
        else if(healthPoint <= getMaxHealthPoint())
            this.healthPoint = healthPoint;
    }
    @Override
    public void attack(Player player,Enemy[] enemy, int i){
        if (player.getHealthPoint() > 0) {
            if (player.getStamina() >= 1) {
                getCriticalHit();
                getMissHit();
                if (isCritic() && !isMiss()) {
                    System.out.println("Critical Hit!");
                    Voices.play(Voices.CriticalHit);
                    if (isAttackType1())
                        SoundEffects.play(SoundEffects.PlayerAttack);
                    else
                        SoundEffects.play(SoundEffects.PlayerAttack2);
                    player.setHit(player.getCurrentWeapon(player.getWeapon()) * 2);
                    setAttackType1();
                }
                else {
                    if (!isMiss()) {
                        if (isAttackType1())
                            SoundEffects.play(SoundEffects.PlayerAttack);
                        else
                            SoundEffects.play(SoundEffects.PlayerAttack2);
                        player.setHit(player.getCurrentWeapon(player.getWeapon()));
                        setAttackType1();
                    }
                    else {
                        player.setHit(0);
                        SoundEffects.play(SoundEffects.Missed);
                        Voices.play(Voices.Missed);
                        System.out.println("Missed!");
                    }
                }
                enemy[i].setHealthPoint(enemy[i].getHealthPoint() - player.getHit());   //run-time polymorphism
                player.setStamina(player.getStamina() - 1);
                enemy[i].enemyTakesDamage();    //run-time polymorphism
                System.out.println("You hit " + player.getHit());
                System.out.println("Enemy's health " + enemy[i].getHealthPoint());
            }
            else {
                setEnergyType1();
                if (isEnergyType1()) {
                    System.out.println("Not enough Energy!");
                    Voices.play(Voices.NotEnoughEnergy);
                }
                else {
                    System.out.println("Not enough stamina!");
                    Voices.play(Voices.NotEnoughStamina);
                }
            }
        }
    }
    @Override
    public void attack(Player player, RedTheBoss boss){//Overloaded
        if (player.getHealthPoint() > 0) {
            if (player.getStamina() >= 1) {
                getCriticalHit();
                getMissHit();
                if (isCritic() && !isMiss()) {
                    System.out.println("Critical Hit!");
                    Voices.play(Voices.CriticalHit);
                    if (isAttackType1())
                        SoundEffects.play(SoundEffects.PlayerAttack);
                    else
                        SoundEffects.play(SoundEffects.PlayerAttack2);
                    player.setHit(player.getCurrentWeapon(player.getWeapon()) * 2);
                    setAttackType1();
                } else {
                    if (!isMiss()) {
                        if (isAttackType1())
                            SoundEffects.play(SoundEffects.PlayerAttack);
                        else
                            SoundEffects.play(SoundEffects.PlayerAttack2);
                        player.setHit(player.getCurrentWeapon(player.getWeapon()));
                        setAttackType1();
                    }
                    else {
                        SoundEffects.play(SoundEffects.Missed);
                        Voices.play(Voices.Missed);
                        player.setHit(0);
                        System.out.println("Missed!!");
                    }
                }
                boss.setHealthPoint(boss.getHealthPoint() - player.getHit());
                player.setStamina(player.getStamina() - 1);
                SoundEffects.play(SoundEffects.RedTakesDamage);
                System.out.println("You hit " + player.getHit());
                System.out.println("RED's health " + boss.getHealthPoint());
            } else {
                setEnergyType1();
                if (isEnergyType1()) {
                    System.out.println("Not enough Energy!");
                    Voices.play(Voices.NotEnoughEnergy);
                }
                else {
                    System.out.println("Not enough stamina!");
                    Voices.play(Voices.NotEnoughStamina);
                }
            }
        }
    }
    @Override
    public void attack(Player player, GhostTheHalfBoss halfBoss) {
        if (player.getHealthPoint() > 0) {
            if (player.getStamina() >= 1) {
                if (halfBoss.isInvisible()){
                    player.setHit(0);
                }
                setAttackType1();
                getCriticalHit();
                getMissHit();
                if (isCritic() && !isMiss()) {
                    Voices.play(Voices.CriticalHit);
                    System.out.println("Critical Hit!!");
                    if (isAttackType1())
                        SoundEffects.play(SoundEffects.PlayerAttack);
                    else
                        SoundEffects.play(SoundEffects.PlayerAttack2);
                    player.setHit(player.getCurrentWeapon(player.getWeapon()) * 2);
                    setAttackType1();
                } else {
                    if (!isMiss()) {
                        if (isAttackType1())
                            SoundEffects.play(SoundEffects.PlayerAttack);
                        else
                            SoundEffects.play(SoundEffects.PlayerAttack2);
                        player.setHit(player.getCurrentWeapon(player.getWeapon()));
                        setAttackType1();
                    }
                    else {
                        SoundEffects.play(SoundEffects.Missed);
                        Voices.play(Voices.Missed);
                        player.setHit(0);
                        System.out.println("Missed!!");
                    }
                }
                halfBoss.setHealthPoint(halfBoss.getHealthPoint() - player.getHit());
                player.setStamina(player.getStamina() - 1);
                SoundEffects.play(SoundEffects.GhostTakesDamage);
                System.out.println("You hit " + player.getHit());
                System.out.println("Ghost's health " + halfBoss.getHealthPoint());
            }
            else {
                setEnergyType1();
                if (isEnergyType1()) {
                    System.out.println("Not enough Energy!");
                    Voices.play(Voices.NotEnoughEnergy);
                }
                else {
                    System.out.println("Not enough stamina!");
                    Voices.play(Voices.NotEnoughStamina);
                }
            }
        }
    }
    @Override
    public void powerAttack(Player player, GhostTheHalfBoss halfBoss) {
        if (player.getHealthPoint() > 0) {
            if (player.getMana() >= 5) {
                setAttackType1();
                getCriticalHit();
                getMissHit();
                if (isCritic() && !isMiss()) {
                    Voices.play(Voices.CriticalHit);
                    System.out.println("Critical Hit!!");
                    SoundEffects.play(SoundEffects.PlayerPower);
                    player.setPowerHit(player.getPowerAttack() * 2);
                } else {
                    if (!isMiss()) {
                        SoundEffects.play(SoundEffects.PlayerPower);
                        player.setPowerHit(player.getPowerAttack());
                    }
                    else {
                        SoundEffects.play(SoundEffects.Missed);
                        Voices.play(Voices.Missed);
                        player.setPowerHit(0);
                        System.out.println("Missed!!");
                    }
                }
                halfBoss.setHealthPoint(halfBoss.getHealthPoint() - player.getPowerHit());
                player.setMana(player.getMana() - 5);
                SoundEffects.play(SoundEffects.GhostTakesDamage);
                System.out.println("You hit " + player.getPowerHit());
                System.out.println("Ghost's health " + halfBoss.getHealthPoint());
            } else {
                System.out.println("Not enough Mana!");
                Voices.play(Voices.NotEnoughMana);
            }
        }
    }
    @Override
    public void powerAttack(Player player,Enemy[] enemy, int i){
        if (player.getHealthPoint() > 0) {
            if (player.getMana() >= 5) {
                getCriticalHit();
                getMissHit();
                if (isCritic() && !isMiss()) {
                    Voices.play(Voices.CriticalHit);
                    System.out.println("Critical Hit!");
                    player.setPowerHit(player.getPowerAttack() * 2);
                } else {
                    if (!isMiss()) {
                        SoundEffects.play(SoundEffects.PlayerPower);
                        player.setPowerHit(player.getPowerAttack());
                    }
                    else {
                        SoundEffects.play(SoundEffects.Missed);
                        Voices.play(Voices.Missed);
                        player.setPowerHit(0);
                        System.out.println("Missed!");
                    }
                }
                enemy[i].setHealthPoint(enemy[i].getHealthPoint() - player.getPowerHit());  //run-time polymorphism
                player.setMana(player.getMana() - 5);
                enemy[i].enemyTakesDamage();    //run-time polymorphism
                System.out.println("You hit " + player.getPowerHit());
                System.out.println("Enemy's health " + enemy[i].getHealthPoint());
            } else {
                System.out.println("Not enough Mana!");
                Voices.play(Voices.NotEnoughMana);
            }
        }
    }
    @Override
    public void powerAttack(Player player,RedTheBoss boss) {//Overloaded
        if (player.getHealthPoint() > 0) {
            if (player.getMana() >= 5) {
                getCriticalHit();
                getMissHit();
                if (isCritic() && !isMiss()) {
                    Voices.play(Voices.CriticalHit);
                    System.out.println("Critical Hit!");
                    player.setPowerHit(player.getPowerAttack() * 2);
                } else {
                    if (!isMiss()) {
                        SoundEffects.play(SoundEffects.PlayerPower);
                        player.setPowerHit(player.getPowerAttack());
                    }
                    else {
                        SoundEffects.play(SoundEffects.Missed);
                        Voices.play(Voices.Missed);
                        player.setPowerHit(0);
                        System.out.println("Missed!!");
                    }
                }
                boss.setHealthPoint(boss.getHealthPoint() - player.getPowerHit());
                player.setMana(player.getMana() - 5);
                SoundEffects.play(SoundEffects.RedTakesDamage);
                System.out.println("You hit " + player.getHit());
                System.out.println("Red's health " + boss.getHealthPoint());
            } else {
                System.out.println("Not enough Mana!");
                Voices.play(Voices.NotEnoughMana);
            }
        }
    }
    public void shieldUp(){
        this.armor += getShieldValue();
        setShieldUpped(true);
    }
    public void shieldDown(){
        this.armor -= getShieldValue();
        setShieldUpped(false);
    }
    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getPowerHit() {
        return powerHit;
    }
    public void setPowerHit(int powerHit) {
        this.powerHit = powerHit;
    }
    @Override
    public void wait(Player player){
        player.setHealthPoint(player.getHealthPoint()+10);
        player.setStamina(player.getStamina()+2);
        player.setMana(player.getMana()+2);
        System.out.println("Your Health increased 10");
        System.out.println("Your Stamina increased 2");
        System.out.println("Your Mana increased 2");

        System.out.println("You Shield Upped!");
        player.shieldUp();
        System.out.println(player.getShieldValue() + " Damage absorbed!");
    }

    @Override
    public void run(int gap1, int gap2){
        setEscape(getChance());
        if(getEscape() > gap1 && getEscape() <= gap2) {
            System.out.println("You Escaped");
            SoundEffects.play(SoundEffects.Succesfull);
            Stages.setRun(false);
        }
        else {
            System.out.println("You Failed");
            SoundEffects.play(SoundEffects.Failed);
        }
    }
    @Override
    public void usePotion(Player player){
        Scanner input = new Scanner(System.in);
        System.out.println("You have " + player.getHealthPotion() +" Health Potion");
        System.out.println("You have " + player.getManaPotion() +" Mana Potion");
        System.out.println("You have " + player.getStaminaPill() +" Stamina Pill");
        System.out.println("1 to use Health Potion");
        System.out.println("2 to use Mana Potion");
        System.out.println("3 to use Stamina Pill");
        System.out.println("r to return");
        String choice = input.next();
        SoundEffects.play(SoundEffects.Click);
        switch (choice) {
            case "1":
                if (player.getHealthPotion() >= 1) {
                    player.setHealthPotion(player.getHealthPotion() - 1);
                    SoundEffects.play(SoundEffects.DrinkPotion);
                    player.setHealthPoint(player.getHealthPoint() + Items.getHealthPotion());
                    System.out.println("Your health increased " + Items.getHealthPotion());
                    setPotionUsege(true);
                }
                break;
            case "2":
                if (player.getManaPotion() >= 1) {
                    player.setManaPotion(player.getManaPotion() - 1);
                    SoundEffects.play(SoundEffects.DrinkPotion);
                    player.setMana(player.getMana() + Items.getManaPotion());
                    System.out.println("Your Mana increased " + Items.getManaPotion());
                    setPotionUsege(true);
                }
                break;
            case "3":
                if (player.getStaminaPill() >= 1) {
                    player.setStaminaPill(player.getStaminaPill() - 1);
                    SoundEffects.play(SoundEffects.DrinkPotion);
                    player.setStamina(player.getStamina() + Items.getStaminaPill());
                    System.out.println("Your Stamina increased " + Items.getStaminaPill());
                    setPotionUsege(true);
                }
                break;
           default:
               setPotionUsege(false);
                break;
        }
    }

    @Override
    public void seeAllStats(Player player) {
        System.out.println("Your Level " + player.getLvl());
        System.out.println("Your Experience " + player.getExp());
        System.out.println("Your Health " + player.getHealthPoint());
        System.out.println("Your Stamina " + player.getStamina());
        System.out.println("Your Mana " + player.getMana());
        System.out.println("Your Soul " + player.getGold());
        System.out.println("Your Armor Value " + player.getArmor());
        System.out.println("Your Attack Damage " + player.getCurrentWeaponDamage());
        System.out.println("POTIONS YOU HAVE:");
        System.out.println("stamina pill: "+player.getStaminaPill());
        System.out.println("health potion: "+player.getHealthPotion());
        System.out.println("mana potion: "+player.getManaPotion());
    }

    public void setShieldValue(String shield) {
        if(shield.equals("woodenShield")){
            this.shieldValue = Items.getWoodenShield();
        }
        if(shield.equals("copperShield")){
            this.shieldValue = Items.getCopperShield();
        }
        if (shield.equals("ironShield")) {
            this.shieldValue = Items.getIronShield();
        }
        if (shield.equals("goldenShield")) {
            this.shieldValue = Items.getGoldenShield();
        }
    }
    public  void setHeadValue(String head){
        if(head.equals("woodenHelmet")){
            this.headValue = Items.getWoodenHelmet();
        }
        if(head.equals("copperHelmet")){
            this.headValue = Items.getCopperHelmet();
        }
        if (head.equals("ironHelmet")) {
            this.headValue = Items.getIronHelmet();
        }
        if (head.equals("goldenHelmet")) {
            this.headValue = Items.getGoldenHelmet();
        }
    }
    public void setShoulderValue(String shoulder){
        if (shoulder.equals("woodenShoulder")) {
            this.shoulderValue = Items.getWoodenShoulder();
        }
        if (shoulder.equals("copperShoulder")) {
            this.shoulderValue = Items.getCopperShoulder();
        }
        if (shoulder.equals("ironShoulder")) {
            this.shoulderValue = Items.getIronShoulder();
        }
        if (shoulder.equals("goldenShoulder")) {
            this.shoulderValue = Items.getGoldenShoulder();
        }
    }
    public void setChestValue(String chest){
        if (chest.equals("woodenChest")) {
            this.chestValue = Items.getWoodenChest();
        }
        if (chest.equals("copperChest")) {
            this.chestValue = Items.getCopperChest();
        }
        if (chest.equals("ironChest")) {
            this.chestValue = Items.getIronChest();
        }
        if (chest.equals("goldenChest")) {
            this.chestValue = Items.getGoldenChest();
        }
    }
    public void setPantsValue(String pants) {
        if (pants.equals("woodenPants")){
            this.pantsValue = Items.getWoodenPants();
        }
        if (pants.equals("copperPants")) {
            this.pantsValue = Items.getCopperPants();
        }
        if (pants.equals("ironPants")) {
            this.pantsValue = Items.getIronPants();
        }
        if (pants.equals("goldenPants")) {
            this.pantsValue = Items.getGoldenPants();
        }
    }
    public void setBootsValue(String boots) {
        if (boots.equals("woodenBoots")) {
            this.bootsValue = Items.getWoodenBoots();
        }
        if (boots.equals("copperBoots")) {
            this.bootsValue = Items.getCopperBoots();
        }
        if (boots.equals("ironBoots")) {
            this.bootsValue = Items.getIronBoots();
        }
        if (boots.equals("goldenBoots")) {
            this.bootsValue = Items.getGoldenBoots();
        }
    }
    public int getShieldValue() {
        setShieldValue(getShield());
        return shieldValue;
    }

    public int getHeadValue() {
        setHeadValue(getHead());
        return headValue;
    }

    public int getShoulderValue() {
        setShoulderValue(getShoulder());
        return shoulderValue;
    }

    public int getChestValue() {
        setChestValue(getChest());
        return chestValue;
    }

    public int getPantsValue() {
        setPantsValue(getPants());
        return pantsValue;
    }

    public int getBootsValue() {
        setBootsValue(getBoots());
        return bootsValue;
    }
}
