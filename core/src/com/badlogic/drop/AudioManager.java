package com.badlogic.drop;

public class AudioManager {
    private static AudioManager instance = new AudioManager();
    private static boolean mute = false;

    public enum Constants{
    }

    private AudioManager(){

    }

    public static AudioManager getInstance() {
        return instance;
    }

    public void play(Constants cons){
        if(!mute){
            switch(cons){
                default:
                    break;
            }
        }
    }
}
