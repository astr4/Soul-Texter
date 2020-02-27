package Game;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Voices {
    //32    Voice
    public static File WelcomeToSoulTexter = new File("./src/Voices/WelcomeToSoulTexter.mp3");
    public static File AreUlookingforSomethingSpesific = new File("./src/Voices/AreUlookingforSomethingSpesific.mp3");
    public static File CriticalFocussedHit = new File("./src/Voices/CriticalFocussedHit.mp3");
    public static File hiStranger = new File("./src/Voices/hiStranger.mp3");
    public static File GhostSpawnVoice = new File("./src/Voices/GhostSpawnVoice.mp3");
    public static File GhostSpawnVoice2 = new File("./src/Voices/GhostSpawnVoice2.mp3");
    public static File GhostDies = new File("./src/Voices/GhostDies.mp3");
    public static File EnemyMissed = new File("./src/Voices/EnemyMissed.mp3");
    public static File WhataNiceName = new File("./src/Voices/WhataNiceName.mp3");
    public static File WannaBuySomethingElse = new File("./src/Voices/WannaBuySomethingElse.mp3");
    public static File UwannaBuySomething = new File("./src/Voices/UwannaBuySomething.mp3");
    public static File SoulTexter = new File("./src/Voices/SoulTexter.mp3");
    public static File SeeYaSoon = new File("./src/Voices/SeeYaSoon.mp3");
    public static File RedSpawn = new File("./src/Voices/RedSpawn.mp3");
    public static File RedDiess = new File("./src/Voices/RedDiess.mp3");
    public static File NotEnoughGold = new File("./src/Voices/NotEnoughGold.mp3");
    public static File NotEnoughEnergy = new File("./src/Voices/NotEnoughEnergy.mp3");
    public static File Missed = new File("./src/Voices/Missed.mp3");
    public static File YouAreHereToVisitMe = new File("./src/Voices/YouAreHereToVisitMe.mp3");
    public static File WhatsOnYourMind = new File("./src/Voices/WhatsOnYourMind.mp3");
    public static File invisible = new File("./src/Voices/invisible.mp3");
    public static File HowAreYa = new File("./src/Voices/HowAreYa.mp3");
    public static File NotEnoughStamina = new File("./src/Voices/NotEnoughStamina.mp3");
    public static File YouNeedToPrepare = new File("./src/Voices/YouNeedToPrepare.mp3");
    public static File StageHasBeenCompleted = new File("./src/Voices/StageHasBeenCompleted.mp3");
    public static File NotEnoughMana = new File("./src/Voices/NotEnoughMana.mp3");
    public static File EnemyHasBeenSlain = new File("./src/Voices/EnemyHasBeenSlain.mp3");
    public static File CriticalHit = new File("./src/Voices/CriticalHit.mp3");
    public static File ArmyOfRedIsComing = new File("./src/Voices/ArmyOfRedIsComing.mp3");
    public static File YouWillBeABunchOfSoul = new File("./src/Voices/YouWillBeABunchOfSoul.mp3");
    public static File WelcomeToTheShop = new File("./src/Voices/WelcomeToTheShop.mp3");
    public static File YourSoulisMine = new File("./src/Voices/YourSoulisMine.mp3");
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
