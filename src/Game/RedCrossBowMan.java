package Game;

public class RedCrossBowMan extends Enemy {

    private boolean bowReady;

    public RedCrossBowMan(){
        super(120,75,85,50,10,110);
        setBowReady(true);
    }
    @Override
    public void setHealthPoint(int healthPoint) {
        if (healthPoint > 120)
            this.healthPoint = 120;
        if(healthPoint < 0)
            this.healthPoint = 0;
        else if(healthPoint <= 120)
            this.healthPoint = healthPoint;
    }
    @Override
    public void attack(Player player,Enemy [] enemy,int i){
        if (enemy[i].getHealthPoint() > 0) {
            if (isBowReady()) {
                getCriticalHit();
                getMissHit();
                if (isCritic() && !isMiss()) {
                    if (player.isShieldUpped())
                        SoundEffects.play(SoundEffects.ShieldUp);
                    else
                        SoundEffects.play(SoundEffects.BowmanHit);
                    System.out.println("Critical Hit!");
                    Voices.play(Voices.CriticalHit);
                    enemy[i].setHit((enemy[i].getAttackValue() - player.getArmor()) * 2);
                } else {
                    if (!isMiss()) {
                        if (player.isShieldUpped())
                            SoundEffects.play(SoundEffects.ShieldUp);
                        else
                            SoundEffects.play(SoundEffects.BowmanHit);
                        enemy[i].setHit((enemy[i].getAttackValue() - player.getArmor()));
                    }
                    else {
                        SoundEffects.play(SoundEffects.BowmanMissed);
                        Voices.play(Voices.EnemyMissed);
                        enemy[i].setHit(0);
                        System.out.println("Missed!");
                    }
                }
                SoundEffects.play(SoundEffects.PlayerTakesDamage);
                player.setHealthPoint(player.getHealthPoint() - enemy[i].getHit());
                System.out.println("Enemy attacked!");
                System.out.println("Enemy  hit " + enemy[i].getHit());
                setBowReady(false);
            }
            else {
                System.out.println("Bow is setting up");
                setBowReady(true);
            }
        }
    }

    public boolean isBowReady() {
        return bowReady;
    }

    public void setBowReady(boolean bowReady) {
        this.bowReady = bowReady;
    }
    @Override
    public void enemyTakesDamage(){
        SoundEffects.play(SoundEffects.BowmanTakesDamage);
    }
}
