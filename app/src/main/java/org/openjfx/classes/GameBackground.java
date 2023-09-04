package org.openjfx.classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class GameBackground extends ObjectGame{

    private String nameImage2;
    private int y2 = -700;


    public GameBackground(int x, int y, int velocity, String nameImage, String nameImage2){
        super(x, y, velocity, nameImage2);
        this.nameImage2 = nameImage2;
    }


    @Override
    public void paint(GraphicsContext graphics) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'paint'");
        // graphics.drawImage(Game.images.get(nameImage), x, y);
        // graphics.drawImage(Game.images.get(nameImage2), x, y2);
    }


    @Override
    public void move(int unity) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'move'");
        // if( y >= 700) {
        //     y = -700;
        // }
        // if( y2 >= 700) {
        //     y2 = -700;
        // }
        // if(Game.up && unity <= 500) {
        //     y += velocity;
        //     y2 += velocity;
        // }


        
    }


    @Override
    public Rectangle getRectangle() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getRectangle'");
        return null;
    }

    



}
