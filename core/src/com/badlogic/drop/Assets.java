package com.badlogic.drop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by aritz on 06/03/2018.
 */

public class Assets {
    /*
    *private
     */
    //single instance of the class
    private static final Assets instance = new Assets();
    // Constant rows and columns of the sprite sheet
    private static final int FRAME_COLS = 6, FRAME_ROWS = 5;
    private static final int PLAYER_COLS = 3, PLAYER_ROWS = 2;
    /*
    *public
     */
    //Atlas
    public TextureAtlas cloudAtlas;
    //Texture
    public Texture walkSheet;
    public Texture playerSheet;
    public Texture playerShootSheet;
    //Animation
    public Animation<TextureRegion> cloudAnimation;
    public Animation<TextureRegion> walkAnimation;
    public Animation<TextureRegion> playerIdle;
    public Animation<TextureRegion> playerRight;
    public Animation<TextureRegion> playerLeft;
    public Animation<TextureRegion> playerShoot;
    public Sound laserShoot;


    private Assets(){
        walkAnimation = loadWalkAnimation();
        loadPlayerShip();
        loadPlayerShoot();
        cloudAtlas = new TextureAtlas(Gdx.files.internal("cloudAtlas.atlas"));
        cloudAnimation = loadCloudAnimation();
        laserShoot = Gdx.audio.newSound(Gdx.files.internal("laser_shoot.wav"));
    }

    public static Assets getInstance(){
        return instance;
    }

    public Animation<TextureRegion> loadWalkAnimation(){
        // Load the sprite sheet as a Texture
        walkSheet = new Texture(Gdx.files.internal("walk.png"));

        // Use the split utility method to create a 2D array of TextureRegions. This is
        // possible because this sprite sheet contains frames of equal size and they are
        // all aligned.
        TextureRegion[][] tmp = TextureRegion.split(walkSheet,
                walkSheet.getWidth() / FRAME_COLS,
                walkSheet.getHeight() / FRAME_ROWS);

        // Place the regions into a 1D array in the correct order, starting from the top
        // left, going across first. The Animation constructor requires a 1D array.
        TextureRegion[] walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        int index = 0;
        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index++] = tmp[i][j];
            }
        }
        Animation<TextureRegion> animation = new Animation<TextureRegion>(0.025f, walkFrames);
        return animation;
    }

    public void loadPlayerShip(){
        playerSheet = new Texture(Gdx.files.internal("ship.png"));

        TextureRegion[][] tmp = TextureRegion.split(playerSheet, playerSheet.getWidth()/PLAYER_COLS , playerSheet.getHeight()/PLAYER_ROWS);
        TextureRegion[] playerFrames = new TextureRegion[PLAYER_COLS * PLAYER_ROWS];
        int index = 0;
        for(int i = 0; i< PLAYER_ROWS; i++){
            for(int j = 0; j < PLAYER_COLS; j++){
                playerFrames[index++] = tmp[i][j];
            }
        }
        TextureRegion[] playerIdleFrames = new TextureRegion[2];
        playerIdleFrames[0] = playerFrames[1];
        playerIdleFrames[1] = playerFrames[4];
        TextureRegion[] playerRightFrames = new TextureRegion[2];
        playerRightFrames[0] = playerFrames[2];
        playerRightFrames[1] = playerFrames[5];
        TextureRegion[] playerLeftFrames = new TextureRegion[2];
        playerLeftFrames[0] = playerFrames[0];
        playerLeftFrames[1] = playerFrames[3];
        playerIdle = new Animation<TextureRegion>(0.25f, playerIdleFrames);
        playerRight = new Animation<TextureRegion>(0.25f, playerRightFrames);
        playerLeft = new Animation<TextureRegion>(0.25f, playerLeftFrames);


    }

    private Animation<TextureRegion> loadCloudAnimation(){
        Array<TextureAtlas.AtlasRegion> regions = cloudAtlas.findRegions("cloud");
        Animation<TextureRegion> animation = new Animation(0.5f,regions);
        return animation;
    }

    private void loadPlayerShoot(){
        playerShootSheet = new Texture(Gdx.files.internal("shoot.png"));

    TextureRegion[][] tmp = TextureRegion.split(playerShootSheet,playerShootSheet.getWidth() / 2,playerShootSheet .getHeight());

        TextureRegion[] playerShootFrames = new TextureRegion[2];
        for (int i = 0; i < 2; i++) {
            playerShootFrames[i] = tmp[0][i];
        }
        playerShoot = new Animation<TextureRegion>(0.15f, playerShootFrames);
    }
}
