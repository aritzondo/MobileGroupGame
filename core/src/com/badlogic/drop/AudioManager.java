package com.badlogic.drop;

public class AudioManager {
    private static AudioManager instance = new AudioManager();
    private static boolean mute = false;

    public enum Sounds{
    }

    private AudioManager(){

    }

    public static AudioManager getInstance() {
        return instance;
    }

    public void play(Sounds sound){
        if(!mute){
            switch(sound){
                default:
                    break;
            }
        }
    }
}
