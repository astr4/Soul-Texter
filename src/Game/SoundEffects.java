package Game;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SoundEffects {

    public static File PlayerAttack = new File("./src/SoundEffect/PlayerAttack.mp3");
    public static File PlayerPower = new File("./src/SoundEffect/PlayerPower.mp3");
    public static File PlayerAttack2 = new File("./src/SoundEffect/PlayerAttack2.mp3");
    public static File ShieldUp = new File("./src/SoundEffect/ShieldUp.mp3");
    public static File Click = new File("./src/SoundEffect/Click.mp3");
    public static File DrinkPotion = new File("./src/SoundEffect/DrinkPotion.mp3");

    public static File RedRegular = new File("./src/SoundEffect/RedRegular.mp3");
    public static File Succesfull = new File("./src/SoundEffect/Succesfull.mp3");
    public static File Failed = new File("./src/SoundEffect/Failed.mp3");

    public static File LvlUp = new File("./src/SoundEffect/LvlUp.mp3");
    public static File Exp = new File("./src/SoundEffect/Exp.mp3");
    public static File Gold = new File("./src/SoundEffect/Gold.mp3");

    public static File Missed = new File("./src/SoundEffect/Missed.mp3");


    public static File RedFireballs = new File("./src/SoundEffect/RedFireballs.mp3");
    public static File GhostAttack = new File("./src/SoundEffect/GhostAttack.mp3");

    public static File BowmanHit  = new File("Users/astr4/Documents/IdeaProjects/SoulTexterVersion0.3/src/SoundEffect/BowmanHit.mp3");
    public static File BowmanMissed  = new File("Users/astr4/Documents/IdeaProjects/SoulTexterVersion0.3/src/SoundEffect/BowmanMissed.mp3");

    public static File EyeAttack = new File("./src/SoundEffect/EyeAttack.mp3");

    public static File EyeSpawn = new File("./src/SoundEffect/EyeSpawn.mp3");

    public static File PlayerTakesDamage = new File("./src/SoundEffect/PlayerTakesDmage.mp3");
    public static File WatcherTakesDamage = new File("./src/SoundEffect/WatcherTakesDamage.mp3");
    public static File RedTakesDamage = new File("./src/SoundEffect/RedTakesDamage.mp3");
    public static File GhostTakesDamage = new File("Users/astr4/Documents/IdeaProjects/SoulTexterVersion0.3/src/SoundEffect/GhostTakesDamage.mp3");
    public static File BowmanTakesDamage = new File("Users/astr4/Documents/IdeaProjects/SoulTexterVersion0.3/src/SoundEffect/BowmanTakesDamage.mp3");

    public static File PlayerDies = new File("Users/astr4/Documents/IdeaProjects/SoulTexterVersion0.3/src/SoundEffect/PlayerDies.mp3");
    public static File RedDies = new File("Users/astr4/Documents/IdeaProjects/SoulTexterVersion0.3/src/SoundEffect/RedDies.mp3");
    public static File WatcherAttack  = new File("Users/astr4/Documents/IdeaProjects/SoulTexterVersion0.3/src/SoundEffect/WatcherAttack.mp3");

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