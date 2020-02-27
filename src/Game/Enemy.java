package Game;

import java.security.SecureRandom;

public abstract class Enemy implements InterfaceOfEnemy {

    protected int healthPoint;
    protected int attackValue;
    protected int attackFirst;
    protected int attackSecond;
    protected int hit;
    protected int goldDrop;
    protected int drooppedGold;
    protected double expDrop;

    private int criticalHit;
    private boolean critic;

    private int missHit;
    private boolean miss;
    private int chance;

    private SecureRandom generator = new SecureRandom();
    private int randomGenerator(int x, int y) {
        return generator.nextInt(y) + x;
    }
    private int SecureRandom(int x) {
        return generator.nextInt(x);
    }

    public Enemy(int healthPoint, int attackFirst, int attackY, int golX, int goldY, double expDrop ){
        setHealthPoint(healthPoint);
        setAttackFirst(attackFirst);
        setAttackSecond(attackY);
        setAttackValue(randomGenerator((getAttackFirst()),(getAttackSecond() - getAttackFirst())));
        setGoldDrop(golX,goldY);
        setExpDrop(expDrop);
    }

    public abstract void enemyTakesDamage();

    public void setMissHit(int missHit) {
        this.missHit = missHit;
        if (criticalHit > 50 && criticalHit < 55)
            setMiss(true);
        else
            setMiss(false);
    }
    public int getMissHit() {
        setMissHit(getChance());
        return missHit;
    }

    public int getAttackFirst() {
        return attackFirst;
    }

    public void setAttackFirst(int attackX) {
        this.attackFirst = attackX;
    }

    public int getAttackSecond() {
        return attackSecond;
    }

    public void setAttackSecond(int attackSecond) {
        this.attackSecond = attackSecond;
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


    public void setChance(int x) {
        chance = x;
    }


    public int getChance() {
        setChance(SecureRandom(101));
        return chance;
    }

    public double getExpDrop() {
        return expDrop;
    }

    public void setExpDrop(double expDrop) {
        this.expDrop = expDrop;
    }

    public int getGoldDrop() {
        return goldDrop;
    }

    public void setGoldDrop(int x , int y) {
        this.goldDrop = randomGenerator(x,y);
    }

    public void setDrooppedGold(int drooppedGold) {
        this.drooppedGold = drooppedGold;
    }

    public int getDrooppedGold() {
        return drooppedGold;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public int getHit() {
        return hit;
    }

    public int getAttackValue() {
        setAttackValue(randomGenerator((getAttackFirst()),(getAttackSecond() - getAttackFirst())));
        return attackValue;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    public abstract void setHealthPoint(int healthPoint);

    public void attack(Player player,Enemy [] enemy,int i){
        if (enemy[i].getHealthPoint() > 0) {
            getCriticalHit();
            getMissHit();
            if (isCritic() && !isMiss()) {
                System.out.println("Critical Hit!");
                if (player.isShieldUpped())
                    SoundEffects.play(SoundEffects.ShieldUp);
                else
                    SoundEffects.play(SoundEffects.WatcherAttack);
                enemy[i].setHit((enemy[i].getAttackValue() - player.getArmor())*2);
            }
            else {
                if (!isMiss()) {
                    if (player.isShieldUpped())
                        SoundEffects.play(SoundEffects.ShieldUp);
                    else
                        SoundEffects.play(SoundEffects.WatcherAttack);
                    enemy[i].setHit((enemy[i].getAttackValue() - player.getArmor()));
                }
                else {
                    enemy[i].setHit(0);
                    Voices.play(Voices.EnemyMissed);
                    System.out.println("Missed!");
                }
            }
            SoundEffects.play(SoundEffects.PlayerTakesDamage);
            player.setHealthPoint(player.getHealthPoint() - enemy[i].getHit());
            System.out.println("Enemy attacked!");
            System.out.println("Enemy  hit " + enemy[i].getHit());
        }
    }
}
