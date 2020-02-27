package Game;

import java.util.Scanner;

public class Driver {
    public static int eye = 0, watcher = 0, archer = 0;
    public static int bossOfEye=0, bossOfWatcher = 0, ghostic = 0;
    public static void main(String[] args){
        System.out.println("Soul Texter");
        (new Thread(new BackGroundMusic())).start();
        BackGroundMusic.entrance();

        Voices.play(Voices.SoulTexter);
        Scanner input = new Scanner(System.in);
        System.out.println("Press any key to start!");//waiting music
        String start = input.next();
        SoundEffects.play(SoundEffects.Click);
        if (start != null) {//music change
            Voices.play(Voices.ArmyOfRedIsComing);
            Market.setFirst(true);
            Player player = new Player();
            EyeOfRed[] eye_of_red = new EyeOfRed[10]; //Eye of Reds
            for (int i = 0; i < eye_of_red.length; i++) {
                eye_of_red[i] = new EyeOfRed();
            }
            RedWatcher[] red_watcher = new RedWatcher[12]; //Red Watchers
            for (int i = 0; i < red_watcher.length; i++) {
                red_watcher[i] = new RedWatcher();
            }
            RedCrossBowMan[] red_archer = new RedCrossBowMan[7]; //Red Crossbow mans
            for (int i = 0; i < red_archer.length; i++) {
                red_archer[i] = new RedCrossBowMan();
            }
            GhostTheHalfBoss halfBoss = new GhostTheHalfBoss();//Half Boss object
            RedTheBoss boss = new RedTheBoss();//Boss object
            Ghostic[] ghostic = new Ghostic[20]; //Half Boss's spawn creatures
            for (int i = 0; i < ghostic.length; i++) {
                ghostic[i] = new Ghostic();
            }
            EyeOfRed[] bossOfEye = new EyeOfRed[20];//Boss's spawn mobs
            for (int i = 0; i < bossOfEye.length; i++) {
                bossOfEye[i] = new EyeOfRed();
            }
            RedWatcher[] bossWatcher = new RedWatcher[20];//Boss's spawn mobs
            for (int i = 0; i < bossWatcher.length; i++) {
                bossWatcher[i] = new RedWatcher();
            }
            if (player.isAlive()) {
                BackGroundMusic.stageOne();
                System.out.println("Stages 1");//Stages 1
            }
            Stages.stage(eye_of_red, player, 1, eye);//fight music
            ++eye;
            Market.market(player);
            if (player.isAlive()) {
                BackGroundMusic.stageOne();
                System.out.println("Stages 2");//Stages 2
            }
            Stages.stage(eye_of_red, player, 1, eye);
            ++eye;
            Stages.stage(eye_of_red, player, 1, eye);
            ++eye;
            Market.market(player);
            if (player.isAlive()) {
                BackGroundMusic.stageOne();
                System.out.println("Stages 3");//Stages 3
            }
            Stages.stage(eye_of_red, player, 1, eye);
            ++eye;
            Stages.stage(eye_of_red, player, 1, eye);
            ++eye;
            Stages.stage(eye_of_red, player, 1, eye);
            ++eye;
            Market.market(player);
            if (player.isAlive()) {
                BackGroundMusic.stageTwo();
                System.out.println("Stages 4");//Stages 4
            }
            Stages.stage(eye_of_red, player, 1, eye);
            ++eye;
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Stages.stage(eye_of_red, player, 1, eye);
            ++eye;
            Market.market(player);
            if (player.isAlive()) {
                System.out.println("Stages 5");//Stages 5
                BackGroundMusic.stageTwo();
            }
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Stages.stage(eye_of_red, player, 1, eye);
            ++eye;
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Market.market(player);
            if (player.isAlive()){
                System.out.println("Stages 6"); //Stages 6
                BackGroundMusic.stageTwo();
            }
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Market.market(player);
            if (player.isAlive()) {
                BackGroundMusic.stageThree();
                System.out.println("Stages 7");//Stages 7
                Voices.play(Voices.YouNeedToPrepare);
            }
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Stages.stage(red_archer, player, 3, archer);
            ++archer;
            Stages.stage(eye_of_red, player, 2, eye);
            ++eye;
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Market.market(player);
            if (player.isAlive()) {
                BackGroundMusic.stageThree();
                System.out.println("Stages 8");//Stages 8
            }
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Stages.stage(red_archer, player, 3, archer);
            ++archer;
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Stages.stage(red_archer, player, 3, archer);
            ++archer;
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Market.market(player);
            if (player.isAlive()) {
                BackGroundMusic.stageThree();
                System.out.println("Stages 9");//Stages 9
            }
            Stages.stage(red_archer, player, 3, archer);
            ++archer;
            Stages.stage(red_archer, player, 3, archer);
            ++archer;
            Stages.stage(red_watcher, player, 2, watcher);
            ++watcher;
            Stages.stage(red_archer, player, 3, archer);
            ++archer;
            Stages.stage(red_archer, player, 3, archer);
            ++archer;
            Market.market(player);
            Stages.halfBossStage(player, halfBoss, ghostic);//Half Boss stage
            if (player.isAlive()) {
                System.out.println("Final Stages: The End is Coming(!)");//Boss level
                Stages.bossStage(player, boss, bossOfEye, bossWatcher);
            }
            BackGroundMusic.credits(boss);//Credits
            }//New bosses will be coming soon.
	//Stages.stage(ChamperFire,player,x,3,y);
    }
}
