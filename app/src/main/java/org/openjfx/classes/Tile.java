package org.openjfx.classes;

import org.openjfx.controllers.FXMLControllerGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tile extends ObjectGame{

    
    public static boolean nomalMode = true;
    public static boolean advance = true;
    private int xImage;
    private int yImage;
    private int widthImage;
    private int heightImage;
    private int typeTile;


    public Tile(int typeTile ,int x, int y, int velocity, String nameImage, int width, int height) {
        super(x, y, velocity, nameImage);
        //TODO Auto-generated constructor stub
        this.height = height;
        this.width = width;
        this.typeTile = typeTile;
        if(this.nameImage == "tile") {
			switch(typeTile){
			case 1:
				xImage=557;
				yImage=59;
				widthImage = 40;
				heightImage = 40;
				break;
			case 13:
				xImage=557;
				yImage=19;
				widthImage = 40;
				heightImage = 40;
				break;
			case 2:
				xImage=319;
				yImage=60;
				widthImage = 40;
				heightImage = 40;
				break;
			case 3:
				xImage=477;
				yImage=60;
				widthImage = 40;
				heightImage = 40;
				break;
			case 4:
				xImage=398;
				yImage=60;
				widthImage = 40;
				heightImage = 40;
				break;
			case 5:
				xImage=318;
				yImage=20;
				widthImage = 40;
				heightImage = 40;
				break;
			case 6:
				xImage=358;
				yImage=20;
				widthImage = 40;
				heightImage = 40;
				break;
			case 7:	
				xImage=557;
				yImage=179;
				widthImage = 40;
				heightImage = -40;
				break;	
			case 8:	
				xImage=555;
				yImage=99;
				widthImage = 40;
				heightImage = 40;
				break;
			case 9:
				xImage=557;
				yImage=119;
				widthImage = 40;
				heightImage = 40;
				break;
			case 10:
				xImage=557;
				yImage=139;
				widthImage = 40;
				heightImage = 40;
				break;
			case 11:
				xImage=557;
				yImage=159;
				widthImage = 40;
				heightImage = 40;
				break;
			case 12:
				xImage=479;//519,792
				yImage=763+30;
				widthImage = 40;
				heightImage = -30;
				break;
			case 14:
				xImage=319;
				yImage=258+30;
				widthImage = 40;
				heightImage = -30;
				break;
			case 15:
				xImage=478;
				yImage=258;
				widthImage = 39;
				heightImage = -30;
				break;

			case 16:
				xImage=398;
				yImage=256;
				widthImage = 40;
				heightImage = -30;
				break;

			case 17:
				xImage=437;
				yImage=438+4;
				widthImage = 40;
				heightImage = 30;
				break;

			case 18:
				xImage=557;
				yImage=442;
				widthImage = 40;
				heightImage = 30;
				break;
			case 19:
				xImage=478;
				yImage=438;
				widthImage = 40;
				heightImage = -30;
				break;


//			case 11:		//CAMBIAR POR UN TILE CORRECTO
//				xImage=597;
//				yImage=99;
//				widthImage = 40;
//				heightImage = -40;
//				break;
//			case 11:		//CAMBIAR POR UN TILE CORRECTO
//				xImage=597;
//				yImage=199;
//				widthImage = 40;
//				heightImage = -40;
//				break;
			}
        }
        if(this.nameImage == "tile2") {
			switch(typeTile){
			case 1:
				xImage=0;
				yImage=50;
				widthImage = 48;
				heightImage = -50;
				break;
			case 2:
				xImage=48;
				yImage=50;
				widthImage = 48;
				heightImage = -50;
				break;
			case 3:
				xImage=96;
				yImage=50;
				widthImage = 48;
				heightImage = -50;
				break;
			}
		}

    }


    @Override
    public void paint(GraphicsContext graphics) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'paint'");
        graphics.drawImage(FXMLControllerGame.images.get(nameImage), xImage, (nomalMode&&nameImage=="tile")?yImage:50, widthImage, heightImage, x, -y + 700 , width, -height);
		graphics.setStroke(Color.WHITE);

		if( nameImage == "tile2" ) {
			//graphics.strokeRect( x +10, -y + 700 -height, width-15-2 , height -10-3);
			//graphics.strokeOval(400, 400, 80, 100);
		}
    }

    public static boolean isNormalMode() {
		return nomalMode;
	}

    public static void setNormalMode(boolean nomalMode) {
		Tile.nomalMode = nomalMode;
	}


    @Override
    public void move(int unity) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'move'");
        if(FXMLControllerGame.up && FXMLControllerGame.advance) {// Y APARTE QUE advance==FALSE Y LISTO CREO JEJEJE//y3 <= 500
            y-=this.velocity;
        }
    }

    public final int getxImage() {
		return xImage;
	}

	public final void setxImage(int xImage) {
		this.xImage = xImage;
	}

	public final int getyImage() {
		return yImage;
	}

	public final void setyImage(int yImage) {
		this.yImage = yImage;
	}

	public final int getTypeTile() {
		return typeTile;
	}

	public final void setTypeTile(int typeTile) {
		this.typeTile = typeTile;
	}
	
	public boolean isAdvance() {
		return advance;
	}

	public void setAdvance(boolean advance) {
		Tile.advance = advance;
	}


    @Override
    public Rectangle getRectangle() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getRectangle'");
        if( nameImage == "tile") {
            //	//if( typeTile == 0 ) {
                    return new Rectangle( x , -y + 700 -height, width , height );
                }
        
                return new Rectangle(  x +10, -y + 700 -height, width-15-2 , height -10-3);//(x , -y + 700 -height, width , height -10);
    }
    


}
