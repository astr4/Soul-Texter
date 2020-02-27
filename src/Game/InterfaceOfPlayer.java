package Game;

public interface InterfaceOfPlayer {

    void attack(Player player, Enemy[] enemy, int i);
    void attack(Player player, RedTheBoss boss);
    void attack(Player player, GhostTheHalfBoss halfBoss);
    void powerAttack(Player player, GhostTheHalfBoss halfBoss);
    void powerAttack(Player player, RedTheBoss boss);
    void powerAttack(Player player, Enemy[] enemy, int i);
    void wait(Player player);
    void run(int gap1, int gap2);
    void usePotion(Player player);
    void seeAllStats(Player player);
}
