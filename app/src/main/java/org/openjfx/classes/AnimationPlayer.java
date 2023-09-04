package org.openjfx.classes;

import java.util.ArrayList;
import java.util.HashMap;

import org.openjfx.controllers.FXMLControllerGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class AnimationPlayer extends ObjectGame {

    public static int punctuation = 0;
    private HashMap< String , Animation > animations;
    private String currentAnimation;
    private int lives;
    private int xImage;
    private int yImage;
    private int widthImage;
    private int heightImage;
    private int widthShow = 125;
    private int heightShow = 128;
    private int direction = 1;
    private boolean cron = false;
    private boolean minorlife = false;
    private int a;
    private boolean b = false;
    private int aa;
    private boolean bb = false;
    private int acu;
    private boolean veri;


    public AnimationPlayer(int x, int y, int velocity, String nameImage, int lives, String currentAnimation) {
        super(x, y, velocity, nameImage);
        //TODO Auto-generated constructor stub
        this.lives = lives;
        this.currentAnimation = currentAnimation;
        animations = new HashMap< String , Animation >();
        initializeAnimations();
    }

    
    public void initializeAnimations(){
        Rectangle restLocation1[] = {
            new Rectangle( 64 , 134 , 65 , 68 ) 
        };
        Animation restAnimation1 = new Animation( 0, restLocation1);
        animations.put("descanso1", restAnimation1);

        Rectangle restLocation2[] = {
            new Rectangle( 64 , 0 , 65 , 68 )
        };
        Animation restAnimation2 = new Animation( 0 , restLocation2);
        animations.put("descanso2" , restAnimation2 );

        Rectangle leftLocation[] = {
            new Rectangle( 0 , 72 , 65 , 68 ),
            new Rectangle( 64 , 72 , 65 , 68 ),
            new Rectangle( 128 , 72 , 65 , 68 ),
            new Rectangle( 192 , 72 , 65 , 68 ),
            new Rectangle( 256 , 72 , 65 , 68 ),
            new Rectangle( 320 , 72 , 65 , 68 ),
            new Rectangle( 384 , 72 , 65 , 68 ),
            new Rectangle( 448 , 72 , 65 , 68 ),
            new Rectangle( 512 , 72 , 65 , 68 ),
        };
        Animation leftAnimation = new Animation( 0.1 , leftLocation);
        animations.put("left", leftAnimation);
        //NEXT
        Rectangle rightLocation[] = {
            new Rectangle( 0 , 200 , 65 , 68 ),
            new Rectangle( 64 , 200 , 65 , 68 ),//+1
            new Rectangle( 128 , 200 , 65 , 68 ),
            new Rectangle( 192 , 200 , 65 , 68 ),
            new Rectangle( 256 , 200 , 65 , 68 ),
            new Rectangle( 320 , 200 , 65 , 68 ),//+1
            new Rectangle( 384 , 200 , 65 , 68 ),
            new Rectangle( 448 , 200 , 65 , 68 ),
            new Rectangle( 512 , 200 , 65 , 68 ),
        };
        Animation rightAnimation = new Animation( 0.1 , rightLocation);
        animations.put("right", rightAnimation);
            //NEXT
        Rectangle downLocation[] = {
            new Rectangle( 0 , 134 , 65 , 68 ),
            new Rectangle( 64 , 134 , 65 , 68 ),//+1
            new Rectangle( 128 , 134 , 65 , 68 ),
            new Rectangle( 192 , 134 , 65 , 68 ),
            new Rectangle( 256 , 134 , 65 , 68 ),
            new Rectangle( 320 , 134 , 65 , 68 ),//+1
            new Rectangle( 384 , 134 , 65 , 68 ),
            new Rectangle( 448 , 134 , 65 , 68 ),
            new Rectangle( 512 , 134 , 65 , 68 ),
        };
        Animation downAnimation = new Animation( 0.1 , downLocation);
        animations.put("down", downAnimation);
        //NEXT
        Rectangle upLocation[] = {
            new Rectangle( 0 , 0 , 65 , 68 ),
            new Rectangle( 64 , 0 , 65 , 68 ),//+1
            new Rectangle( 128 , 0 , 65 , 68 ),
            new Rectangle( 192 , 0 , 65 , 68 ),
            new Rectangle( 256 , 0 , 65 , 68 ),
            new Rectangle( 320 ,  0 , 65 , 68 ),//+1
            new Rectangle( 384 , 0 , 65 , 68 ),
            new Rectangle( 448 , 0 , 65 , 68 ),
            new Rectangle( 512 , 0 , 65 , 68 ),
        };
        Animation upAnimation = new Animation( 0.1 , upLocation);
        animations.put("up", upAnimation);
    }


    public void countFrame(double t) {
        Rectangle location = animations.get(currentAnimation).calculateCurrentFrame(t);
        this.xImage = (int)location.getX();
        this.yImage = (int)location.getY();
        this.widthImage = (int)location.getWidth();
        this.heightImage = (int)location.getHeight();
    }

    public void calculateFrame(double t) {
        Rectangle coordenadas = animations.get(currentAnimation).calculateCurrentFrame(t);
        this.xImage = (int)coordenadas.getX();
        this.yImage = (int)coordenadas.getY();
        this.widthImage = (int)coordenadas.getWidth();
        this.heightImage = (int)coordenadas.getHeight();
    }



    // @Override
    // public void paint(GraphicsContext graphics) {
    //     // TODO Auto-generated method stub
    //     // throw new UnsupportedOperationException("Unimplemented method 'paint'");
    //     graphics.drawImage( FXMLControllerGame.images.get(nameImage), xImage, yImage, widthImage, heightImage, x, y, widthShow, heightShow );
    // }






    @Override
    public void move(int unity) {	
        if(y <= 500 && !FXMLControllerGame.collisionObstacleFront) {
            FXMLControllerGame.advance=true;
        }else {
            FXMLControllerGame.advance=false;
        }
        if( y <-68) {
            this.y = 630 ;
        }
        if( y >= 631) {
            this.y = 630 ;
        }
        if( x >= 1000 ) {
            this.x = -100;
        }
        if(FXMLControllerGame.right) {
            this.x += velocity ;
        }
        if(FXMLControllerGame.left) {
            this.x -= velocity;
        }
        if(FXMLControllerGame.up) {
            this.y -= velocity;
        }
        if(FXMLControllerGame.down) {
            this.y += velocity;
        }
        if(!FXMLControllerGame.right && !FXMLControllerGame.left && !FXMLControllerGame.up && !FXMLControllerGame.down) {
            this.currentAnimation = "descanso2";
        }
    }
    public int getPunctuation() {
        return punctuation;
    }
    public int getLives() {
        return lives;
    }
    public void setLives(int lives) {
        this.lives = lives;
    }
    public String getCurrentAnimation() {
        return currentAnimation;
    }
    public void setCurrentAnimation(String currentAnimation) {
        this.currentAnimation = currentAnimation;
    }
    public int getDirection() {
        return direction;
    }
    public void setDirection(int direction) {
        this.direction = direction;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Rectangle getRectangle() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getRectangle'");
        return new Rectangle(x + 49 , y + 30, widthShow - 76, heightShow - 50);
    }

    @Override
    public void paint(GraphicsContext graphics) {
        // Asegúrate de que images es accesible aquí, por ejemplo, usando FXMLControllerGame.images
        // Image currentFrame = FXMLControllerGame.images.get(nameImage);

        // Dibuja la imagen actual en la posición del jugador
        // Utiliza xImage, yImage, widthImage, heightImage para recortar la animación correcta de la hoja de sprites
        graphics.drawImage(FXMLControllerGame.images.get(nameImage), xImage, yImage, widthImage, heightImage, x, y, widthShow, heightShow);



        // graphics.drawImage(new Image(getClass().getResourceAsStream("/org/openjfx/assets/sprites/dalton.png")), 20 , 20);
        // images.put( "personaje" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/scenery/tilemaps.png")));
    }


    public void verifyState(ArrayList<Tile> t1,ArrayList<Tile> t2) {
        if(lives==0) {
        }
    }

    public void verifyCollisionItem(ArrayList<Item> item) {
        for(int i = 0 ; i < item.size() ; i++ ) {
            if(item.get(i).getNameImage().equals("vidat")) {
                if(!item.get(i).isCaught() && this.getRectangle().getBoundsInLocal().intersects(item.get(i).getRectangle().getBoundsInLocal())) {
                    item.get(i).setCaught(true);
                    this.lives = this.lives + item.get(i).getLives();
                }
            }
            if(item.get(i).getNameImage().equals("escudo")) {
                if(!item.get(i).isCaught() && this.getRectangle().getBoundsInLocal().intersects(item.get(i).getRectangle().getBoundsInLocal())) {
                    item.get(i).setCaught(true);
                    AnimationPlayer.punctuation+=5;
                    Tile.nomalMode=false;
                    cron=true;
                }else {

                    if(cron) {
                        chronometer();
                    }	
                }
            }
        }
    }

    public void chronometer() {
        if(!b) {
            a=1;
            //a+=1;
            b=true;
        }else {
            a+=1;
            if(a==516) {
                b=false;
                cron=false;
                Tile.nomalMode=true;
            }
        }
    }

    public void advance() {
        if(bb) {
            aa+=1;
            if(aa==2294) {
                bb=false;
                FXMLControllerGame.collisionObstacleFront=false;
                aa=0;
            }
        }
        if(!bb) {
            aa=1;
            bb=true;
        }
    }
    public void verificarColisionAnimationEnemy(AnimationEnemy e) {
            if(!e.isCaught() && !minorlife && this.getRectangle().getBoundsInLocal().intersects(e.getRectangle().getBoundsInLocal())) {
                if(!cron) {
                    this.lives -= e.getlives();
                    minorlife=true;
                    e.setY(-10);
                    System.out.println("vida perdida");
                }
                if(cron) {
                    e.setCaught(true);
                    AnimationPlayer.punctuation += 20;
                    System.out.println("muerto");
                }
            }
            if(minorlife) {
                cronometrolives();
            }
    }
    public void verificarColisionAnimationEnemy2(ArrayList<AnimationEnemy> e) {
        for(int i=0;i<e.size();i++) {
            if(!e.get(i).isCaught() && !minorlife && this.getRectangle().getBoundsInLocal().intersects(e.get(i).getRectangle().getBoundsInLocal())) {
                if(!cron) {
                    this.lives -= e.get(i).getlives();
                    minorlife=true;
                    int s = e.get(i).getY();
                    e.get(i).setY(s-400);
                    //System.out.println("vida perdida");
                    //e.setCaught(b);(true);
                }
                if(cron) {
                    //this.lives -= e.getlives();
                    //minorlife=true;
                    e.get(i).setCaught(true);
                    AnimationPlayer.punctuation += 20;
                    System.out.println("muerto");
                }
            }
            if(minorlife) {
                cronometrolives();
            }
        }
    }
    public void cronometrolives() {
        if(!veri) {
            acu=1;
            //acu+=1;
            veri=true;
        }else {
            acu+=1;
            if(acu==100) {
                veri=false;
                minorlife=false;
            }
        }
    }


    public void verifyCollisionTile(ArrayList<Tile> tiles) {
        for(int i = 0 ; i < tiles.size() ; i++ ) {
            if(tiles.get(i).getNameImage()=="tile") {
                if( tiles.get(i).getTypeTile() == 3 ) {
//						if(!this.getRectangle().getBoundsInLocal().intersects(tiles.get(i).getRectangle().getBoundsInLocal())) {
//							tiles.get(i).setAvance(true);
//						}
                    if(this.getRectangle().getBoundsInLocal().intersects(tiles.get(i).getRectangle().getBoundsInLocal())) {
                        if((this.getRectangle().getX() <= tiles.get(i).getRectangle().getX() + tiles.get(i).getRectangle().getWidth()) &&
                                (this.getRectangle().getX() >= tiles.get(i).getRectangle().getX() + 25) &&
                                ((this.getRectangle().getY() >= tiles.get(i).getRectangle().getY() - this.getRectangle().getHeight()) &&
                                        this.getRectangle().getY() <= tiles.get(i).getRectangle().getY() + tiles.get(i).getRectangle().getHeight())) {
                            this.x = this.x + velocity;
                            //System.out.println("LADO IZQUIERDO");
                        }
                        if((this.getRectangle().getX() >= (tiles.get(i).getRectangle().getX() - this.getRectangle().getWidth()) &&
                                this.getRectangle().getX() <= (tiles.get(i).getRectangle().getX() - this.getRectangle().getWidth() + 25))&&
                                ((this.getRectangle().getY() >= tiles.get(i).getRectangle().getY() - this.getRectangle().getHeight()) &&
                                        this.getRectangle().getY() <= tiles.get(i).getRectangle().getY() + tiles.get(i).getRectangle().getHeight())) {
                            this.x = this.x- velocity;
                            //System.out.println("LADO DERECHO");
                        }
                        if((this.getRectangle().getY() <= (tiles.get(i).getRectangle().getY() + tiles.get(i).getRectangle().getHeight()) &&
                                this.getRectangle().getY() >= tiles.get(i).getRectangle().getY() + 25) &&
                                (this.getRectangle().getX() >= (tiles.get(i).getRectangle().getX() - this.getRectangle().getWidth()) &&
                                        this.getRectangle().getX() <= (tiles.get(i).getRectangle().getX() + tiles.get(i).getRectangle().getWidth()))) {
                            this.y = this.y + velocity;
                            FXMLControllerGame.collisionObstacleFront=true;//tiles.get(i).setAvance(false);
                        }
                        else {
                        }
                        if((this.getRectangle().getY() >= (tiles.get(i).getRectangle().getY() - this.getRectangle().getHeight()) &&
                                this.getRectangle().getY() <= tiles.get(i).getRectangle().getY() + 25) &&
                                (this.getRectangle().getX() >= (tiles.get(i).getRectangle().getX() - this.getRectangle().getWidth()) &&
                                        this.getRectangle().getX() <= (tiles.get(i).getRectangle().getX() + tiles.get(i).getRectangle().getWidth()))) {
                            this.y = this.y - velocity;
                        }
                                                }else {													
                        if(FXMLControllerGame.collisionObstacleFront==true) {
                            advance();
                        }
                    }
                }
            }
            //SEGUNDO ARREGLO DE TILE (TILE)
            else {
                if(this.getRectangle().getBoundsInLocal().intersects(tiles.get(i).getRectangle().getBoundsInLocal())) {

                    if((this.getRectangle().getX() <= tiles.get(i).getRectangle().getX() + tiles.get(i).getRectangle().getWidth()) &&
                            (this.getRectangle().getX() >= tiles.get(i).getRectangle().getX() + 25) &&
                            ((this.getRectangle().getY() >= tiles.get(i).getRectangle().getY() - this.getRectangle().getHeight()) &&
                                    this.getRectangle().getY() <= tiles.get(i).getRectangle().getY() + tiles.get(i).getRectangle().getHeight())) {
                        this.x = this.x + velocity;
                        //this.y = this.y;
                    }
                    if((this.getRectangle().getX() >= (tiles.get(i).getRectangle().getX() - this.getRectangle().getWidth()) &&
                            this.getRectangle().getX() <= (tiles.get(i).getRectangle().getX() - this.getRectangle().getWidth() + 25))&&
                            ((this.getRectangle().getY() >= tiles.get(i).getRectangle().getY() - this.getRectangle().getHeight()) &&
                                    this.getRectangle().getY() <= tiles.get(i).getRectangle().getY() + tiles.get(i).getRectangle().getHeight())) {
                        this.x = this.x- velocity;
                    }
                    if((this.getRectangle().getY() <= (tiles.get(i).getRectangle().getY() + tiles.get(i).getRectangle().getHeight()) &&
                            this.getRectangle().getY() >= tiles.get(i).getRectangle().getY() + 25) &&
                            (this.getRectangle().getX() >= (tiles.get(i).getRectangle().getX() - this.getRectangle().getWidth()) &&
                                    this.getRectangle().getX() <= (tiles.get(i).getRectangle().getX() + tiles.get(i).getRectangle().getWidth()))) {
                        this.y = this.y + velocity;
                        FXMLControllerGame.collisionObstacleFront=true;
                    }
                    if((this.getRectangle().getY() >= (tiles.get(i).getRectangle().getY() - this.getRectangle().getHeight()) &&
                            this.getRectangle().getY() <= tiles.get(i).getRectangle().getY() + 25) &&
                            (this.getRectangle().getX() >= (tiles.get(i).getRectangle().getX() - this.getRectangle().getWidth()) &&
                                    this.getRectangle().getX() <= (tiles.get(i).getRectangle().getX() + tiles.get(i).getRectangle().getWidth()))) {
                        this.y = this.y - velocity;
                    }		
                }	else {
                    if(FXMLControllerGame.collisionObstacleFront==true) {
                        advance();
                    }
                }
            }
        }
    }

    public void verifyCollisionAnimationEnemy2(ArrayList<AnimationEnemy> e) {
        for(int i=0;i<e.size();i++) {
            if(!e.get(i).isCaught() && !minorlife && this.getRectangle().getBoundsInLocal().intersects(e.get(i).getRectangle().getBoundsInLocal())) {
                if(!cron) {
                    this.lives -= e.get(i).getlives();
                    minorlife=true;
                    int s = e.get(i).getY();
                    e.get(i).setY(s-400);
                    //System.out.println("vida perdida");
                    //e.setCaught(true);
                }
                if(cron) {
                    //this.lives -= e.getlives();
                    //minorlife=true;
                    e.get(i).setCaught(true);
                    AnimationPlayer.punctuation += 20;
                    System.out.println("muerto");
                }
            }
            if(minorlife) {
                cronometrolives();
            }
        }
    }
    
}

