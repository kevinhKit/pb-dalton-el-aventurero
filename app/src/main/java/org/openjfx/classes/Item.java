package org.openjfx.classes;

import org.openjfx.controllers.FXMLControllerGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Item extends ObjectGame{
    private int points;
    private int lives;
    private int xImage;
    private int yImage;
    private int widthImagen;
    private int heightImagen;
    private boolean caught = false;
    
    //private int typeItem;
    
        public Item(int typeItem ,int x, int y, int velocity, String nameImage, int points, int lives) {
        super(x, y, velocity, nameImage);
        this.points = points;
        this.lives = lives;
        //this.typeItem = typeItem;
        if(nameImage=="vidat") {
            switch(typeItem) {
                case 1:
                     xImage=0;
                     yImage=46;
                     widthImagen=50;
                     heightImagen=-46;
                     width=50;
                     height=46;
                    break;
            }
        }
        if(nameImage=="escudo") {
            switch(typeItem) {
            case 2:
                 xImage=0;
                 yImage=500;
                 widthImagen=444;
                 heightImagen=-460;
                 width=50;
                 height=46;
                break;
            }
        }
    }
    
        @Override
        public void paint(GraphicsContext graficos) {
            if(!caught) {
                graficos.drawImage(FXMLControllerGame.images.get(nameImage), xImage, yImage,widthImagen,heightImagen,x,-y+700,width,-height);
            }
            //graficos.strokeOval(x, -y+700-height, width, height);
        }
    
        @Override
        public void move(int y3) {
            if(FXMLControllerGame.up && FXMLControllerGame.advance) {
                this.y -= this.velocity;
            }
            
        }
        @Override
        public Rectangle getRectangle() {
            if( this.nameImage == "vidat") {
                return new Rectangle(x, -y+700-height, width, height);
            }
            return new Rectangle(x, -y+700-height, width, height);
        }
    
        public int getPoints() {
            return points;
        }
    
        public void setPoints(int points) {
            this.points = points;
        }
    
        public int getLives() {
            return lives;
        }
    
        public void setLives(int lives) {
            this.lives = lives;
        }
    
        public boolean isCaught() {
            return caught;
        }
    
        public void setCaught(boolean caught) {
            this.caught = caught;
        }
        
        
    }
    