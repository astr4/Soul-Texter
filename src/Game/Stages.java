package Game;
import java.util.Scanner;

public class Stages {

    private static boolean run;

    public static boolean isRun() {
        return run;
    }
    public static void setRun(boolean run) {
        Stages.run = run;
    }

    public static void stage(Enemy[] enemy, Player player,int x, int i) {

        if (player.getHealthPoint() > 0) {
            Scanner input = new Scanner(System.in);
            switch (x) {
                case 1:
                    System.out.println("An Eye of Red coming through you");
                    SoundEffects.play(SoundEffects.EyeSpawn);
                    break;
                case 2:
                    System.out.println("A Red Watcher coming through you");
                    break;
                case 3:
                    System.out.println("A Red CrossBow Man coming through you");
                    break;
                case 4:
                    System.out.println("A Gostic coming through you");
            }
            setRun(true);
            while (enemy[i].getHealthPoint() > 0 && player.getHealthPoint() > 0 && isRun()) {
                System.out.println("Your Health " + player.getHealthPoint());
                System.out.println("Your Stamina " + player.getStamina());
                System.out.println("Your Mana " + player.getMana());
                System.out.println("Enemy's Health " + enemy[i].getHealthPoint());
                System.out.println("To Attack press 1 (1 stamina)");
                System.out.println("To Wait press 2 (10 health,2 stamina, 2 mana)");
                System.out.println("To Run press 3 (run chance = %35 (if you're dying you can try)");
                System.out.println("To Special Power press 4 (5 mana)");
                System.out.println("To Use potion press 5");
                System.out.println("To see all stats press 6");
                int choice4 = 0;
                boolean loop = true;
                do {
                    try {
                        choice4 = input.nextInt();
                        loop = false;
                    }
                    catch (Exception e) {
                        System.err.println("Exception has occurred!!! ");
                        System.err.println(e);
                        System.err.println("try again");
                        input.nextLine();
                    }
                } while(loop);
                SoundEffects.play(SoundEffects.Click);
                switch (choice4) {
                    case 1:
                        player.attack(player, enemy, i);
                        if (player.getStamina() >= 1) {
                            enemy[i].attack(player, enemy, i);  //run-time polymorphism
                            if (enemy[i].getHealthPoint() <= 0) {
                                enemyDied(player, enemy, i);
                            }
                            if (player.getHealthPoint() <= 0) {
                                System.out.println("You are dead");
                                System.out.println("Game over");
                                player.setAlive(false);
                            }
                        }
                        break;
                    case 2:
                        player.wait(player);
                        if (enemy[i].getHealthPoint() > 0)
                            enemy[i].attack(player, enemy, i);  //run-time polymorphism
                        if (enemy[i].getHealthPoint() <= 0) {
                            enemyDied(player, enemy, i);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("You are dead");
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        player.shieldDown();
                        break;
                    case 3:
                        player.run(35, 70);
                        if (isRun())
                            enemy[i].attack(player, enemy, i);  //run-time polymorphism
                        if (enemy[i].getHealthPoint() <= 0) {
                            enemyDied(player, enemy, i);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("You are dead");
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        break;
                    case 4:
                        player.powerAttack(player, enemy, i);
                        if (player.getMana() >= 5) {
                            if (enemy[i].getHealthPoint() > 0)
                                enemy[i].attack(player, enemy, i);  //run-time polymorphism
                            }
                        if (enemy[i].getHealthPoint() <= 0) {
                            enemyDied(player, enemy, i);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("You are dead");
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        break;
                    case 5:
                        player.usePotion(player);
                        if (enemy[i].getHealthPoint() > 0 && player.isPotionUsege())
                            enemy[i].attack(player, enemy, i);  //run-time polymorphism
                        if (enemy[i].getHealthPoint() <= 0) {
                            enemyDied(player, enemy, i);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("You are dead");
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        player.shieldDown();
                        break;
                    case 6:
                        player.seeAllStats(player);
                        break;
                }
            }
            if (enemy[i].getHealthPoint() <=0){
                switch (Driver.eye){
                    case 0:Voices.play(Voices.StageHasBeenCompleted);//Stage1
                        break;
                    case 2:Voices.play(Voices.StageHasBeenCompleted);//Stage2
                        break;
                    case 5:Voices.play(Voices.StageHasBeenCompleted);//Stage3
                        break;
                    case 8:Voices.play(Voices.StageHasBeenCompleted);//Stage4
                        break;
                }
                switch (Driver.watcher){
                    case 2:Voices.play(Voices.StageHasBeenCompleted);//Stage5
                        break;
                    case 5:Voices.play(Voices.StageHasBeenCompleted);//Stage6
                        break;
                    case 7:Voices.play(Voices.StageHasBeenCompleted);//Stage7
                        break;
                    case 10:Voices.play(Voices.StageHasBeenCompleted);//Stage8
                        break;
                }
                switch (Driver.archer){
                    case 6:Voices.play(Voices.StageHasBeenCompleted);//Stage9
                        break;
                }
            }
        }
        else
            BackGroundMusic.areYouDead(player);
    }
    public static void bossStage(Player player,RedTheBoss boss,EyeOfRed[] bossOfEye, RedWatcher[] bossWatcher) {
        if (player.getHealthPoint() > 0) {
            BackGroundMusic.red();
            Voices.play(Voices.RedSpawn);
            Voices.play(Voices.YourSoulisMine);
            Scanner input = new Scanner(System.in);

            System.out.println("Ghost coming through you");
            setRun(true);
            while (boss.getHealthPoint() > 0 && player.getHealthPoint() > 0 && isRun()) {
                System.out.println("Your Health " + player.getHealthPoint());
                System.out.println("Your Stamina " + player.getStamina());
                System.out.println("Your Mana " + player.getMana());
                System.out.println("RED's Health " + boss.getHealthPoint());
                System.out.println("To Attack press 1 (1 stamina)");
                System.out.println("To Wait press 2 (10 health,2 stamina, 2 mana)");
                System.out.println("To Run press 3 (run chance = %2 (Wanna try your chance?)");
                System.out.println("To Special Power press 4 (5 mana)");
                System.out.println("To Use potion press 5");
                System.out.println("To see all stats press 6");
                int choice4 = 0;
                boolean loop = true;
                do {
                    try {
                        choice4 = input.nextInt();
                        loop = false;
                    }
                    catch (Exception e) {
                        System.err.println("Exception has occurred!!! ");
                        System.err.println(e);
                        System.err.println("try again");
                        input.nextLine();
                    }
                } while(loop);
                SoundEffects.play(SoundEffects.Click);
                switch (choice4) {
                    case 1:
                        player.attack(player, boss);
                        if (player.getStamina() >= 1) {
                            boss.bossAttack(player, boss, bossOfEye, bossWatcher);
                            if (boss.getHealthPoint() <= 0) {
                                bossDied(player, boss);
                            }
                            if (player.getHealthPoint() <= 0) {
                                System.out.println("Game over");
                                player.setAlive(false);
                            }
                        }
                        break;
                    case 2:
                        player.wait(player);
                        boss.bossAttack(player, boss, bossOfEye, bossWatcher);
                        System.out.println("RED attacked!");

                        if (boss.getHealthPoint() <= 0) {
                            bossDied(player, boss);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        player.shieldDown();
                        break;
                    case 3:
                        player.run(50, 52);
                        if (isRun())
                            boss.bossAttack(player, boss, bossOfEye, bossWatcher);
                        System.out.println("You Can not Escape From ME!");
                        boss.bossAttack(player, boss, bossOfEye, bossWatcher);
                        System.out.println("RED attacked!");
                        if (boss.getHealthPoint() <= 0) {
                            bossDied(player, boss);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        break;
                    case 4:
                        player.powerAttack(player, boss);
                        if (player.getMana() >= 5) {
                            System.out.println("You hit " + player.getPowerHit());
                            boss.bossAttack(player, boss, bossOfEye, bossWatcher);
                            System.out.println("Boss attacked!");
                        }
                        if (boss.getHealthPoint() <= 0) {
                            bossDied(player, boss);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        break;
                    case 5:
                        player.usePotion(player);
                        boss.bossAttack(player, boss, bossOfEye, bossWatcher);
                        if (boss.getHealthPoint() <= 0) {
                            bossDied(player, boss);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        break;
                    case 6:
                        player.seeAllStats(player);
                        break;
                }
            }
        }
        else
            BackGroundMusic.areYouDead(player);
    }
    public static void halfBossStage(Player player,GhostTheHalfBoss halfBoss,Ghostic[] ghostic) {
        if (player.getHealthPoint() > 0) {
            BackGroundMusic.ghost();
            Voices.play(Voices.GhostSpawnVoice);
            Scanner input = new Scanner(System.in);

            System.out.println("Ghost coming through you");
            Voices.play(Voices.GhostSpawnVoice2);
            setRun(true);
            while (halfBoss.getHealthPoint() > 0 && player.getHealthPoint() > 0 && isRun()) {
                System.out.println("Your Health " + player.getHealthPoint());
                System.out.println("Your Stamina " + player.getStamina());
                System.out.println("Your Mana " + player.getMana());
                System.out.println("Ghost's Health " + halfBoss.getHealthPoint());
                System.out.println("To Attack press 1 (1 stamina)");
                System.out.println("To Wait press 2 (10 health,2 stamina, 2 mana)");
                System.out.println("To Run press 3 (run chance = %2 (Wanna try your chance?)");
                System.out.println("To Special Power press 4 (5 mana)");
                System.out.println("To Use potion press 5");
                System.out.println("To see all stats press 6");
                int choice4 = 0;
                boolean loop = true;
                do {
                    try {
                        choice4 = input.nextInt();
                        loop = false;
                    }
                    catch (Exception e) {
                        System.err.println("Exception has occurred!!! ");
                        System.err.println(e);
                        System.err.println("try again");
                        input.nextLine();
                    }
                } while(loop);
                SoundEffects.play(SoundEffects.Click);
                switch (choice4) {
                    case 1:
                        player.attack(player, halfBoss);
                        if (player.getStamina() >= 1) {
                            halfBoss.bossAttack(player, halfBoss,ghostic);
                            if (halfBoss.getHealthPoint() <= 0) {
                                halfBossDied(player, halfBoss);
                            }
                            if (player.getHealthPoint() <= 0) {
                                System.out.println("Game over");
                                player.setAlive(false);
                            }
                        }
                        break;
                    case 2:
                        player.wait(player);
                        halfBoss.bossAttack(player, halfBoss, ghostic);
                        System.out.println("Ghost attacked!");

                        if (halfBoss.getHealthPoint() <= 0) {
                            halfBossDied(player, halfBoss);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        player.shieldDown();
                        break;
                    case 3:
                        player.run(50, 52);
                        if (isRun())
                            halfBoss.bossAttack(player, halfBoss,ghostic);
                        System.out.println("You Can not Escape From ME!");
                        halfBoss.bossAttack(player, halfBoss, ghostic);
                        System.out.println("Ghost attacked!");
                        if (halfBoss.getHealthPoint() <= 0) {
                            halfBossDied(player, halfBoss);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        break;
                    case 4:
                        player.powerAttack(player, halfBoss);
                        if (player.getMana() >= 5) {
                            System.out.println("You hit " + player.getPowerHit());
                            halfBoss.bossAttack(player, halfBoss, ghostic);
                            System.out.println("Ghost attacked!");
                        }
                        if (halfBoss.getHealthPoint() <= 0) {
                            halfBossDied(player, halfBoss);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        break;
                    case 5:
                        player.usePotion(player);
                        halfBoss.bossAttack(player, halfBoss, ghostic);
                        if (halfBoss.getHealthPoint() <= 0) {
                            halfBossDied(player, halfBoss);
                        }
                        if (player.getHealthPoint() <= 0) {
                            System.out.println("Game over");
                            player.setAlive(false);
                        }
                        break;
                    case 6:
                        player.seeAllStats(player);
                        break;
                }
            }
        }
        else
            BackGroundMusic.areYouDead(player);
    }
    private static void goldDrop(Player player,Enemy enemy[],int i){
        enemy[i].setDrooppedGold( enemy[i].getGoldDrop());
        player.setGold(player.getGold()+enemy[i].getDrooppedGold());
        SoundEffects.play(SoundEffects.Gold);
        System.out.println(enemy[i].getDrooppedGold() + " Gold Dropped!");
    }
    private static void goldDrop(Player player,RedTheBoss boss){//Boss overloaded
        boss.setDrooppedGold( boss.getGoldDrop());
        player.setGold(player.getGold()+boss.getDrooppedGold());
        SoundEffects.play(SoundEffects.Gold);
        System.out.println(boss.getDrooppedGold() + " Gold Dropped!");
    }
    private static void goldDrop(Player player,GhostTheHalfBoss halfBoss){//halfBoss overloaded
        halfBoss.setDrooppedGold( halfBoss.getGoldDrop());
        player.setGold(player.getGold()+halfBoss.getDrooppedGold());
        SoundEffects.play(SoundEffects.Gold);
        System.out.println(halfBoss.getDrooppedGold() + " Gold Dropped!");
    }
    private static void enemyDied(Player player, Enemy enemy[], int i){
        System.out.println("Enemy has been slain!");
        goldDrop(player,enemy,i);
        player.setExp(player.getExp()+enemy[i].getExpDrop());
        SoundEffects.play(SoundEffects.Exp);
        System.out.println(enemy[i].getExpDrop() + "Exp Dropped");
        player.setLvl(player.getExp());
        Voices.play(Voices.EnemyHasBeenSlain);
    }
    private static void bossDied(Player player, RedTheBoss boss){
        boss.setAlive(false);
        Voices.play(Voices.RedDiess);
        SoundEffects.play(SoundEffects.RedDies);
        System.out.println("RED Killed");
        System.out.println("We are in safe, You Won the Game!");
        goldDrop(player,boss);
        player.setExp(player.getExp()+boss.getExpDrop());
        SoundEffects.play(SoundEffects.Exp);
        System.out.println(boss.getExpDrop() + "Exp Dropped");
        player.setLvl(player.getExp());
        Voices.play(Voices.EnemyHasBeenSlain);
    }
    private static void halfBossDied(Player player, GhostTheHalfBoss halfboss){
        Voices.play(Voices.GhostDies);
        System.out.println("Ghost Killed");
        System.out.println("We are in safe, For now");
        goldDrop(player,halfboss);
        player.setExp(player.getExp()+halfboss.getExpDrop());
        SoundEffects.play(SoundEffects.Exp);
        System.out.println(halfboss.getExpDrop() + "Exp Dropped");
        player.setLvl(player.getExp());
        Voices.play(Voices.EnemyHasBeenSlain);
    }
}