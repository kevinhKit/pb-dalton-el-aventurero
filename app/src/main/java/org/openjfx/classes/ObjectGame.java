package org.openjfx.classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public abstract class ObjectGame {
    

    protected int x;
    protected  int y;
    protected int velocity;
    protected  String nameImage;
    protected int width;
    protected  int height;

    public ObjectGame(int x, int y, int velocity, String nameImage){
        super();
        this.x = x;
        this.y = y;
        this.velocity = velocity;
        this.nameImage = nameImage;
    }

    public abstract void paint(GraphicsContext graphics);

    public abstract void move(int unity);

    public abstract Rectangle getRectangle();

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public int getVelocity() {
        return velocity;
    }
    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(Object nameImage) {
        this.nameImage = (String) nameImage;
    } 



}
