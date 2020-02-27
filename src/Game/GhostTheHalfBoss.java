package Game;

import java.security.SecureRandom;

public class GhostTheHalfBoss extends Enemy {
    private SecureRandom generator2 = new SecureRandom();
    private int bossAttackType;
    private int bossAttackChance;
    private SecureRandom generator1 = new SecureRandom();
    private int ghosticI = 0 ;
    public boolean invisible;

    public GhostTheHalfBoss(){
        super(300,70,80,150,75,500);
        setInvisible(false);
    }
    @Override
    public void setHealthPoint(int healthPoint){
        if (healthPoint > 300)
            this.healthPoint = 300;
        if(healthPoint < 0)
            this.healthPoint = 0;
        else if(healthPoint <= 300)
            this.healthPoint = healthPoint;
    }

    public boolean isInvisible() {
        return invisible;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
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

    public  void setBossAttackChance(int bossAttackType) {
        bossAttackChance = bossAttackType;
    }

    public int getBossAttackType() {
        if (getBossAttackChance()<=50)
            setBossAttackType(1);
        else if (getBossAttackChance()>50 && getBossAttackChance()<=85)
            setBossAttackType(2);
        else if(getBossAttackChance()>85 && getBossAttackChance()<=100)
            setBossAttackType(3);
        return bossAttackType;
    }


    public  void setBossAttackType(int bossAttackType) {
        this.bossAttackType = bossAttackType;
    }

    public void regularAttack(Player player,GhostTheHalfBoss halfBoss){
        SoundEffects.play(SoundEffects.GhostAttack);
        halfBoss.setHit((halfBoss.getAttackValue() - player.getArmor()));
        player.setHealthPoint(player.getHealthPoint() - halfBoss.getHit());
        SoundEffects.play(SoundEffects.PlayerTakesDamage);
        System.out.println("RED regulars hit " + halfBoss.getHit());
        System.out.println("Your Health: " + player.getHealthPoint());
    }
    public void invisble(Player player, GhostTheHalfBoss halfBoss){
        Voices.play(Voices.invisible);
        halfBoss.setInvisible(true);
    }
    public void bossAttack(Player player, GhostTheHalfBoss halfBoss, Ghostic[] ghostic) {
        if (halfBoss.getHealthPoint() > 0) {
            switch (getBossAttackType()) {
                case 1:
                    regularAttack(player,halfBoss);
                    halfBoss.setInvisible(false);
                    break;
                case 2:
                    invisble(player,halfBoss);
                    break;
                case 3:
                    Stages.stage(ghostic, player, 1, ghosticI);
                    ++Driver.ghostic;
                    ++ghosticI;
                    halfBoss.setInvisible(false);
                    break;
            }
        }
    }
    @Override
    public void enemyTakesDamage(){
        SoundEffects.play(SoundEffects.GhostTakesDamage);
    }
}
