package Game;

public class EyeOfRed extends Enemy {
    public EyeOfRed() {
        super(60, 35, 45, 20, 10, 27.5);
    }

    public void setHealthPoint(int healthPoint) {
        if (healthPoint > 60)
            this.healthPoint = 60;
        if (healthPoint < 0)
            this.healthPoint = 0;
        else if (healthPoint <= 60)
            this.healthPoint = healthPoint;
    }
    @Override
    public void attack(Player player,Enemy [] enemy,int i){
        if (enemy[i].getHealthPoint() > 0) {
            getCriticalHit();
            getMissHit();
            if (isCritic() && !isMiss()) {
                System.out.println("Critical Hit!");
                Voices.play(Voices.CriticalHit);
                if (player.isShieldUpped())
                    SoundEffects.play(SoundEffects.ShieldUp);
                else
                    SoundEffects.play(SoundEffects.EyeAttack);
                enemy[i].setHit((enemy[i].getAttackValue() - player.getArmor())*2);
            }
            else {
                if (!isMiss()) {
                    if (player.isShieldUpped())
                        SoundEffects.play(SoundEffects.ShieldUp);
                    else
                        SoundEffects.play(SoundEffects.EyeAttack);
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
    @Override
    public void enemyTakesDamage(){
        SoundEffects.play(SoundEffects.GhostTakesDamage);
    }
}

