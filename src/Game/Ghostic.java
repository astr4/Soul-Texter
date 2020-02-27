package Game;

public class Ghostic extends Enemy {
    public Ghostic(){
        super(50,25,35,20,10 ,25);
    }

    public void setHealthPoint(int healthPoint) {
        if (healthPoint > 50)
            this.healthPoint = 50;
        if(healthPoint < 0)
            this.healthPoint = 0;
        else if(healthPoint <= 50)
            this.healthPoint = healthPoint;
    }
    @Override
    public void attack(Player player,Enemy [] enemy,int i) {
        if (enemy[i].getHealthPoint() > 0) {
            getCriticalHit();
            getMissHit();
            if (isCritic() && !isMiss()) {
                Voices.play(Voices.CriticalHit);
                System.out.println("Critical Hit!");
                if (player.isShieldUpped())
                    SoundEffects.play(SoundEffects.ShieldUp);
                else
                    SoundEffects.play(SoundEffects.GhostAttack);
                enemy[i].setHit((enemy[i].getAttackValue() - player.getArmor()) * 2);
            } else {
                if (!isMiss()) {
                    if (player.isShieldUpped())
                        SoundEffects.play(SoundEffects.ShieldUp);
                    else
                        SoundEffects.play(SoundEffects.GhostAttack);
                    enemy[i].setHit((enemy[i].getAttackValue() - player.getArmor()));
                } else {
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
    @Override
    public void enemyTakesDamage(){
        SoundEffects.play(SoundEffects.GhostTakesDamage);
    }
}
