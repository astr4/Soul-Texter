package Game;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class BackGroundMusic implements Runnable{
    public static volatile AtomicInteger counter = new AtomicInteger(1);
    private volatile static boolean run = true;
    public static boolean isRun() {
        return run;
    }
    public static void setRun(boolean run) {
        BackGroundMusic.run = run;
    }
    public static void start(){
        setRun(true);
    }
    public static void terminate(){
        setRun(false);
    }

    public static void entrance(){
        counter.set(2);
    }
    public static void stageOne(){
        counter.set(3);
        counter.set(4);
    }
    public static void stageTwo(){
        counter.set(5);
        counter.set(6);
    }
    public static void stageThree(){
        counter.set(7);
        counter.set(8);
    }
    public static void market(){
        counter.set(9);
        counter.set(10);
    }
    public static void ghost(){
        counter.set(11);
        counter.set(12);
    }
    public static void red(){
        counter.set(13);
        counter.set(14);
    }
    public static void areYouDead(Player player){
        Scanner input = new Scanner(System.in);
        if (!(player.isAlive())) {
            counter.set(15);
            counter.set(16);
            int x = input.nextInt();
            counter.set(17);
            System.out.println("Game design: Ayberk Ortancalar");
            System.out.println("Consept and Code: Ayberk Ortancalar");
            System.out.println("Sound Effects: Ayberk Ortancalar / Övgü Çimen / Esra Melike Ersoy");
            System.out.println("Voices: Ayberk Ortancalar");
            System.out.println("Musics: Ayberk Ortancalar");
            System.out.println("Market Design: Ayberk Ortancalar / Övgü Çimen");
            System.out.println("Thanks to Eren Kılıç ");
            System.out.println("Third-Party: JavaZoom Library");
        }
    }
    public static void credits(RedTheBoss boss){
        if (!(boss.isAlive())) {
            counter.set(17);
            System.out.println("Game design: Ayberk Ortancalar");
            System.out.println("Consept and Code: Ayberk Ortancalar");
            System.out.println("Sound Effects: Ayberk Ortancalar");
            System.out.println("Voices: Ayberk Ortancalar");
            System.out.println("Musics: Ayberk Ortancalar");
            System.out.println("Market Design: Ayberk Ortancalar");
            System.out.println("Third-Party: JavaZoom Library");
        }
    }
    @Override
    public void run() {
        while (isRun()){
            switch (counter.get()) {
                case 1:
                    Musics.play(Musics.entrance1);
                    break;
                case 2:
                    Musics.play(Musics.entrance2);
                    break;
                case 3:
                    Musics.play(Musics.stageOne1);
                    break;
                case 4:
                    Musics.play(Musics.stageOne2);
                    break;
                case 5:
                    Musics.play(Musics.stageTwo1);
                    break;
                case 6:
                    Musics.play(Musics.stageTwo2);
                    break;
                case 7:
                    Musics.play(Musics.stageThree1);
                    break;
                case 8:
                    Musics.play(Musics.stageThree2);
                    break;
                case 9:
                    Musics.play(Musics.market1);
                    break;
                case 10:
                    Musics.play(Musics.market2);
                    break;
                case 11:
                    Musics.play(Musics.ghost1);
                    break;
                case 12:
                    Musics.play(Musics.ghost2);
                    break;
                case 13:
                    Musics.play(Musics.red1);
                    break;
                case 14:
                    Musics.play(Musics.red2);
                    break;
                case 15:
                    Musics.play(Musics.youDied1);
                    break;
                case 16:
                    Musics.play(Musics.youDied2);
                    break;
                case 17:
                    Musics.play(Musics.credits);
                    break;
                default:
                    break;
            }
        }
    }
}
