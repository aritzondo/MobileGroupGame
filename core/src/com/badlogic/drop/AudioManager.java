package com.badlogic.drop;

public class AudioManager {
    private static AudioManager instance = new AudioManager();
    private static boolean mute = false;

    public enum Sounds{
        bgMusic,
        bgMusic2,
        bgMusic4,
        none
    }

    private Sounds currentMusic = Sounds.none;

    private AudioManager(){

    }

    public static AudioManager getInstance() {
        return instance;
    }

    public void play(Sounds sound){
        if(!mute){
            switch(sound){
                case bgMusic:
                    stop(currentMusic);
                    Assets.getInstance().bgMusic.play();
                    currentMusic = Sounds.bgMusic;
                    break;
                case bgMusic2:
                    stop(currentMusic);
                    Assets.getInstance().bgMusic2.play();
                    currentMusic = Sounds.bgMusic2;
                    break;
                case bgMusic4:
                    stop(currentMusic);
                    Assets.getInstance().bgMusic4.play();
                    currentMusic = Sounds.bgMusic4;
                    break;
                default:
                    break;
            }
        }
    }

    public void stop(Sounds sound) {
        switch (sound) {
            case bgMusic:
                Assets.getInstance().bgMusic.stop();
                break;
            case bgMusic2:
                Assets.getInstance().bgMusic2.stop();
                break;
            case bgMusic4:
                Assets.getInstance().bgMusic4.stop();
                break;
            default:
                break;
        }
        currentMusic = Sounds.none;
    }
}
