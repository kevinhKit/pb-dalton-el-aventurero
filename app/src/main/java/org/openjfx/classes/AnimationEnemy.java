package org.openjfx.classes;

import java.util.ArrayList;
import java.util.HashMap;

import org.openjfx.controllers.FXMLControllerGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class AnimationEnemy extends ObjectGame{
	private int tipoEnemigo;
	private int lives;
	private HashMap< String , Animation > animations;
	private int xImagen;
	private int yImagen;
	private int widthImage;
	private int heightImage;
	private int widthShow;
	private int heightShow;
	private String currentAnimation;
	private int direction = 1;
	//private boolean cron=false;
	private boolean caught = false;
	private int a;
	boolean b=false;
		public AnimationEnemy(int x, int y, int velocity, String nameImage, int lives, String currentAnimation) {
			super(x, y, velocity, nameImage);
			this.lives = lives;
			this.currentAnimation = currentAnimation;
			animations = new HashMap< String , Animation >();
			inictializeAnimations();
			if(this.nameImage == "rey") {
				widthShow = 100 ;
				heightShow = 110 ;
			}
			if(this.nameImage == "yaser") {
				widthShow = 100 ;
				heightShow = 110 ;
			}
		}
		public void inictializeAnimations(){
			if(nameImage=="rey") {
				Rectangle locationLeft[] = {
						new Rectangle( 5 , 64 , 53 , 64 ),
						new Rectangle( 67+3 , 64 , 53 , 64 ),
						new Rectangle( 131+3 , 64 , 53 , 64 ),
				};
				Animation animationLeft = new Animation( 0.2 , locationLeft);
				animations.put("left", animationLeft);
				//NEXT
				Rectangle loationRight[] = {
						new Rectangle( 5 , 128 , 55 , 64 ),
						new Rectangle( 67+3 , 128 , 55 , 64 ),
						new Rectangle( 131+3 , 128 , 55 , 64 ),
				};
				Animation animationRight = new Animation( 0.2 , loationRight);
				animations.put("right", animationRight);
					//NEXT
				Rectangle locationDown[] = {
					new Rectangle( 5 , 0 , 53 , 64 ),
					new Rectangle( 67+3 , 0 , 53 , 64 ),
					new Rectangle( 131+3, 0 , 53 , 64 ),

				};
				Animation animationDown = new Animation( 0.2 , locationDown);
				animations.put("down", animationDown);
				//NEXT
				Rectangle locationUp[] = {
						new Rectangle( 5 , 192 , 55 , 65 ),
						new Rectangle( 67+3 , 192 , 55 , 65 ),
						new Rectangle( 131+3 , 192 , 55 , 65 ),
				};
				Animation animationUp = new Animation( 0.2 , locationUp);
				animations.put("up", animationUp);
			}
			if(nameImage=="yaser") {
				Rectangle locationLeft[] = {
						new Rectangle( 0 , 79 , 73 , 79 ),
						new Rectangle( 79+6 , 79 , 73 , 79 ),
						new Rectangle( 161 , 79 , 73 , 79 ),
				};
				Animation animationLeft = new Animation( 0.2 , locationLeft);
				animations.put("left", animationLeft);
				//NEXT
				Rectangle loationRight[] = {
						new Rectangle( 0 , 159 , 73 , 79 ),
						new Rectangle( 79 , 159 , 73 , 79 ),
						new Rectangle( 161 , 159 , 73 , 79 ),
				};
				Animation animationRight = new Animation( 0.2 , loationRight);
				animations.put("right", animationRight);
					//NEXT
				Rectangle locationDown[] = {
						new Rectangle( 0 , 0 , 73 , 79 ),
						new Rectangle( 79+2 , 0 , 73 , 79 ),
						new Rectangle( 161 , 0 , 73 , 79 ),

				};
				Animation animationDown = new Animation( 0.2 , locationDown);
				animations.put("down", animationDown);
				//NEXT
				Rectangle locationUp[] = {
						new Rectangle( 0 , 239 , 73 , 79 ),
						new Rectangle( 79+2 , 239 , 73 , 79 ),
						new Rectangle( 161 , 239 , 73 , 79 ),
				};
				Animation animationUp = new Animation( 0.2 , locationUp);
				animations.put("up", animationUp);
			}
		}
		public void calculateFrame(double t) {
			Rectangle location = animations.get(currentAnimation).calculateCurrentFrame(t);
			this.xImagen = (int)location.getX();
			this.yImagen = (int)location.getY();
			this.widthImage = (int)location.getWidth();
			this.heightImage = (int)location.getHeight();
		}
		
		//METODOS SOBREESCRITOS POR HERENCIA Y ABSTRACCION
		@Override
		public void paint(GraphicsContext graphics) {
			if(!caught) {
			graphics.drawImage( FXMLControllerGame.images.get(nameImage), xImagen, yImagen, widthImage, heightImage, x, y, widthShow, heightShow );
			//graphics.strokeRect(x+10+10, y+5, widthShow-25-10-7, heightShow-20-5);
			//graphics.strokeRect( x + 29 , y + 10 + 10 , widthShow -34 -29, heightShow -20 - 10 -10 );
			}
		}
		@Override
		public void move(int y3) {	
			if(FXMLControllerGame.up && FXMLControllerGame.advance) {// Y APARTE QUE advance==FALSE Y LISTO CREO JEJEJE//y3 <= 500
				y+=velocity;
			}
		}
		public int getlives() {
			return lives;
		}
		public void setlives(int lives) {
			this.lives = lives;
		}
		public String getcurrentAnimation() {
			return currentAnimation;
		}
		public void setcurrentAnimation(String currentAnimation) {
			this.currentAnimation = currentAnimation;
		}
		public int direction() {
			return direction;
		}
		public void direction(int direction) {
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
			return new Rectangle(x+10+10, y+5, widthShow-25-10-7, heightShow-20-5);//x+10, y, widthShow-25, heightShow-20);
		}
		
		public void verifyCollisionItem(ArrayList<Item> item) {
		}
		public void verifyCollisionTile2(ArrayList<Tile> tiles) {
		}
		public void verifyCollisionTile(ArrayList<Tile> tiles) {
			if(!caught) {
				for(int i = 0 ; i < tiles.size() ; i++ ) {
					if(tiles.get(i).getNameImage()=="tile") {
						if( tiles.get(i).getTypeTile() == 3 ) {
							if(this.getRectangle().getBoundsInLocal().intersects(tiles.get(i).getRectangle().getBoundsInLocal())) {		
								int jx = (int) this.getRectangle().getX();
								int jy = (int)this.getRectangle().getY();
								int jw = (int)this.getRectangle().getWidth();
								int jh = (int)this.getRectangle().getHeight();
								int tx = (int)tiles.get(i).getRectangle().getX();
								int ty = (int)tiles.get(i).getRectangle().getY();
								int tw = (int)tiles.get(i).getRectangle().getWidth();
								int th = (int)tiles.get(i).getRectangle().getHeight();
//								System.out.println(jx);
//								System.out.println(jy);
//								System.out.println(tx);
//								System.out.println(ty);
								if((jx <= tx + tw) &&
										(jx >= tx + 25) &&
										((jy >= ty - th) &&
												jy <= ty + th)) {
									this.x = this.x + velocity;
									//this.y = this.y;
									//System.out.println("LADO IZQUIERDO");
								}
								if((jx >= (tx - tw) &&
										jx <= (tx - jw + 25))&&
										((jy >= ty - jh) &&
												jy <= ty + th)) {
									this.x = this.x- velocity;
									//this.y = this.y;
									//System.out.println("LADO DERECHO");
								}
//								if((jy <= (ty + th) &&
//										jy >= ty + 25) &&
//										(jx >= (tx - jw) &&
//												jx <= (tx + tw))) {
//									this.y = this.y + velocity;
//								}
								if((jy >= (ty - jh) &&
										jy <= ty + 25) &&
										(jx >= (tx - jw) &&
												jx <= (tx + tw))) {
									this.y = this.y - velocity;
								}	
							}
						}
					}
					else{
						if(this.getRectangle().getBoundsInLocal().intersects(tiles.get(i).getRectangle().getBoundsInLocal())) {
							tiles.remove(i);
						}
						
					}
				}
			}
		}
//		public void cronometro() {
//			if(!b) {
//				a=1;
//				a+=1;
//				b=true;
//			}else {
//				a+=1;
//				if(a==133546) {
//					System.out.println("hora");
//					b=false;
//					cron=false;
//					Tile.modoNormal=true;
//				}
//			}
//
//			System.out.println(a);
//		}
		public void chase(AnimationPlayer p1) {
			if(!caught) {
				if(this.getRectangle().getX()>(p1.getRectangle().getX()+p1.getRectangle().getWidth()-20)) {
					this.x-=velocity;
					currentAnimation="left";
				}
				if((this.getRectangle().getX()+this.getRectangle().getWidth())<p1.getRectangle().getX()+20) {
					this.x+=velocity;
					currentAnimation="right";
				}
				if((this.getRectangle().getX()<=(p1.getRectangle().getX()+p1.getRectangle().getWidth()-20))&&
						((this.getRectangle().getX()+this.getRectangle().getWidth())>=p1.getRectangle().getX()+20)) {
					if(this.getRectangle().getY()<p1.getRectangle().getY()) {
						this.y+=velocity;
						currentAnimation="down";
					}
					if(this.getRectangle().getY()>p1.getRectangle().getY()) {
						this.y-=velocity;
						currentAnimation="up";
					}
				}
			}
		}
		public boolean isCaught() {
			return caught;
		}
		public void setCaught(boolean caught) {
			this.caught = caught;
		}
		public int getTypeEmeny() {
			return tipoEnemigo;
		}
		public void setTypeEnemy(int tipoEnemigo) {
			this.tipoEnemigo = tipoEnemigo;
		}

		
}
