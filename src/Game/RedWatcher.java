package Game;

public class RedWatcher extends Enemy {

    private boolean focused;

    public RedWatcher(){
        super(90,50,60,30,10,55);
    }

    public boolean isFocused() {
        return focused;
    }

    public void setFocused(boolean focused) {
        this.focused = focused;
    }

    @Override
    public void setHealthPoint(int healthPoint) {
        if (healthPoint > 90)
            super.healthPoint = 90;
        if(healthPoint < 0)
            super.healthPoint = 0;
        else if(healthPoint <= 90)
            super.healthPoint = healthPoint;
    }
    public void focus(RedWatcher [] watcher, int i){
        watcher[i].setFocused(true);
    }
    @Override
    public void attack(Player player,Enemy [] enemy,int i) {
        if (enemy[i].getHealthPoint() > 0) {
            if( !(isFocused()) && getChance() <40)
                focus((RedWatcher[]) enemy,i);
            if (isFocused()) {
                System.out.println("Watcher is Focusing...");
            }
            else {
                getCriticalHit();
                getMissHit();
                if (isCritic() && !isMiss()) {
                    Voices.play(Voices.CriticalHit);
                    System.out.println("Critical Hit!");
                    if (player.isShieldUpped())
                        SoundEffects.play(SoundEffects.ShieldUp);
                    else
                        SoundEffects.play(SoundEffects.WatcherAttack);
                    enemy[i].setHit((enemy[i].getAttackValue() - player.getArmor()) * 2);
                    if (isFocused()) {
                        Voices.play(Voices.CriticalFocussedHit);
                        System.out.println("Critical Focused Hit!");
                        if (player.isShieldUpped())
                            SoundEffects.play(SoundEffects.ShieldUp);
                        else
                            SoundEffects.play(SoundEffects.WatcherAttack);
                        enemy[i].setHit((int) ((enemy[i].getAttackValue() - player.getArmor()) * 1.8) * 2);
                    }
                } else {
                    if (!isMiss()) {
                        if (player.isShieldUpped())
                            SoundEffects.play(SoundEffects.ShieldUp);
                        else
                            SoundEffects.play(SoundEffects.WatcherAttack);
                        enemy[i].setHit((enemy[i].getAttackValue() - player.getArmor()));
                        if (isFocused()) {
                            System.out.println("Focused Hit!");
                            if (player.isShieldUpped())
                                SoundEffects.play(SoundEffects.ShieldUp);
                            else
                                SoundEffects.play(SoundEffects.WatcherAttack);
                            enemy[i].setHit((int) ((enemy[i].getAttackValue() - player.getArmor()) * 1.8));
                        }
                    } else {
                        SoundEffects.play(SoundEffects.Missed);
                        Voices.play(Voices.EnemyMissed);
                        enemy[i].setHit(0);
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
    @Override
    public void enemyTakesDamage(){
        SoundEffects.play(SoundEffects.WatcherTakesDamage);
    }
}
