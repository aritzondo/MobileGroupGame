package com.badlogic.drop;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class CameraHelper {

    private OrthographicCamera camera;

    CameraHelper(OrthographicCamera camera){
        this.camera = camera;
    }

    public void translate(float x, float y, float z){
        camera.translate(x,y,z);
        camera.update();
    }

    public void translate(Vector3 translation){
        camera.translate(translation);
        camera.update();
    }

    public void rotate(float angle){
        camera.rotate(angle);
        camera.update();
    }

    public void lookAt(Vector3 point){
        camera.lookAt(point);
    }
}
