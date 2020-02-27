package Game;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Musics {
    public static File entrance1 = new File("./src/Musics/Entrance1.mp3");
    public static File entrance2 = new File ("./src/Musics/Entrance2.mp3");
    public static File market1 = new File("./src/Musics/Market1.mp3");
    public static File market2 = new File("./src/Musics/Market2.mp3");
    public static File ghost1 = new File("./src/Musics/Ghost1.mp3");
    public static File ghost2 = new File("./src/Musics/Ghost2.mp3");
    public static File red1 = new File("./src/Musics/Red1.mp3");
    public static File red2 = new File("./src/Musics/Red2.mp3");
    public static File stageOne1 = new File("./src/Musics/StageOne1.mp3");
    public static File stageOne2 = new File("./src/Musics/StageOne2.mp3");
    public static File stageTwo1 = new File("./src/Musics/StageTwo1.mp3");
    public static File stageTwo2 = new File("./src/Musics/StageTwo2.mp3");
    public static File stageThree1 = new File("./src/Musics/StageThree1.mp3");
    public static File stageThree2 = new File("./src/Musics/StageThree2.mp3");
    public static File youDied1 = new File("./src/Musics/YouDied1.mp3");
    public static File youDied2 = new File("./src/Musics/YouDied2.mp3");
    public static File credits = new File("./src/Musics/Credits.mp3");

    public static void play(File file) {
        try {
            FileInputStream bis = new FileInputStream((file));
            try {
                Player player = new Player(bis);
                player.play();
            }
            catch (JavaLayerException ignored) {
            }
        }
        catch (IOException ignored) {
        }
    }
}