package Game;

import java.security.SecureRandom;

public class RedTheBoss extends Enemy {
    private  SecureRandom generator2 = new SecureRandom();
    private int fireball;
    private int fireBallHit;
    private int bossAttackType;
    private int bossAttackChance;
    private SecureRandom generator1 = new SecureRandom();
    private boolean alive;
    private int eye = 0, watcher = 0;

    public RedTheBoss(){
        super(500,95,105,200,100,1000);
        setAlive(true);
    }
    @Override
    public void setHealthPoint(int healthPoint){
        if (healthPoint > 500)
            this.healthPoint = 500;
        if(healthPoint < 0)
            this.healthPoint = 0;
        else if(healthPoint <= 500)
            this.healthPoint = healthPoint;
    }
    private int SecureRandom(int x) {
        return generator1.nextInt(x);
    }
    private int randomGenerator(int x, int y) {
        return generator2.nextInt(x)+y;
    }
    public  int getBossAttackChance() {
        setBossAttackChance(SecureRandom(101));
        return bossAttackChance;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public  void setBossAttackChance(int bossAttackType) {
        bossAttackChance = bossAttackType;
    }

    public int getBossAttackType() {
        if (getBossAttackChance()<=50)
            setBossAttackType(1);
        else if (getBossAttackChance()>50 && getBossAttackChance()<=70)
            setBossAttackType(2);
        else if(getBossAttackChance()>70 && getBossAttackChance()<=85)
            setBossAttackType(3);
        else if (getBossAttackChance()>85 && getBossAttackChance()<=100)
            setBossAttackType(4);
        return bossAttackType;
    }

    public int getFireball() {
        setFireball(randomGenerator(70,30));
        return fireball;
    }
    public void setFireball(int fireball) {
        this.fireball = fireball;
    }

    public int getFireBallHit() {
        return fireBallHit;
    }

    public void setFireBallHit(int fireBallHit) {
        this.fireBallHit = fireBallHit;
    }

    public  void setBossAttackType(int bossAttackType) {
        this.bossAttackType = bossAttackType;
    }

    public void regularAttack(Player player,RedTheBoss boss){
        SoundEffects.play(SoundEffects.RedRegular);
        boss.setHit((boss.getAttackValue() - player.getArmor()));
        player.setHealthPoint(player.getHealthPoint() - boss.getHit());
        SoundEffects.play(SoundEffects.PlayerTakesDamage);
        System.out.println("RED regulars hit " + boss.getHit());
        System.out.println("Your Health: " + player.getHealthPoint());
    }
    public void fireBall(Player player,RedTheBoss boss){
        Voices.play(Voices.YouWillBeABunchOfSoul);
        SoundEffects.play(SoundEffects.RedFireballs);
        boss.setFireBallHit(getFireball()- player.getArmor());
        player.setHealthPoint(player.getHealthPoint() - boss.getFireBallHit());
        SoundEffects.play(SoundEffects.PlayerTakesDamage);
        System.out.println("RED  trows Fireball " + boss.getFireBallHit());
        System.out.println("Your Health: " + player.getHealthPoint());
    }

    public void bossAttack(Player player, RedTheBoss boss, EyeOfRed[] boss_of_eye, RedWatcher[] boss_of_watcher) {
        if (boss.getHealthPoint() > 0) {
            switch (getBossAttackType()) {
                case 1:
                    regularAttack(player, boss);
                    break;
                case 2:
                    fireBall(player, boss);
                    break;
                case 3:
                    Stages.stage(boss_of_eye, player, 1, eye);
                    ++Driver.bossOfEye;
                    ++eye;
                    break;
                case 4:
                    Stages.stage(boss_of_watcher, player, 2, watcher);
                    ++Driver.bossOfWatcher;
                    ++watcher;
                    break;
            }
        }
    }
    @Override
    public void enemyTakesDamage(){
        SoundEffects.play(SoundEffects.RedTakesDamage);
    }
}
