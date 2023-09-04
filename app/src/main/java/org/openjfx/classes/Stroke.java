package org.openjfx.classes;

import java.util.ArrayList;

import org.openjfx.controllers.FXMLControllerGame;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Stroke extends ObjectGame{
	private int points;
	private int lives;
	private int xImage;
	private int yImage;
	private int widthImagen;
	private int heightImagen;
	public static String typeStroke ="a";
	private boolean caught = false;
	public Stroke(int x, int y, int velocity, String nameImage, int points, int lives) {
		super(x, y, velocity, nameImage);
		this.points = points;
		this.lives = lives;
										//		switch(typeStroke ) {
										//		case "a":
										//			 xImage=0;
										//			 yImage=0;
										//			 widthImagen=900;
										//			 heightImagen=-800;
										//			 width=50;
										//			 height=50;
										//			break;
										//		case "b":
										//			 xImage=0;
										//			 yImage=46;
										//			 widthImagen=50;
										//			 heightImagen=-46;
										//			 width=50;
										//			 height=46;
										//			break;
										//		}
		 this.xImage=0;
		 this.yImage=0;
		 this.widthImagen=900;
		 this.heightImagen=800;
		 width=30;
		 height=30;
	}
	@Override
	public void paint(GraphicsContext graphics) {
		if(!caught) {
//		graphics.drawImage(FXMLControllerGame.images.get(nameImage), xImage, yImage, widthImagen, heightImagen, x, y , width, height);
//		System.out.println("pintando");
		graphics.drawImage(FXMLControllerGame.images.get(nameImage),xImage,yImage,widthImagen,heightImagen,x,y,width,height);
		//graphics.strokeRect(x+3, y+3,width-6,height-4);
		}
	}
	@Override
	public void move(int y3) {
		if(!caught) {
			this.y-=this.velocity;
		}
	}
	public void verifyCollisionAnimationEnemy(AnimationEnemy e1,int i,ArrayList<Stroke> Strokes) {
		if(!e1.isCaught()&& !caught && this.getRectangle().getBoundsInLocal().intersects(e1.getRectangle().getBoundsInLocal())) {
			e1.setCaught(true);
			caught=true;
			AnimationPlayer.punctuation += this.points;
			Strokes.remove(i);
		}else {
		}
		
	}
	public void verifyCollisionAnimationEnemy2(ArrayList<AnimationEnemy> e1,int z,ArrayList<Stroke> Strokes) {
		for(int i = 0 ; i < e1.size() ; i++ ) {
			if(!e1.get(i).isCaught()&& !caught && this.getRectangle().getBoundsInLocal().intersects(e1.get(i).getRectangle().getBoundsInLocal())) {
				e1.get(i).setCaught(true);
				e1.remove(i);
				caught=true;
				AnimationPlayer.punctuation += this.points;
				Strokes.remove(z);
			}else {
			}
		}		
	}
//	@Override
//	public void pintar(GraphicsContext graphics) {
////		graphics.drawImage(FXMLControllerGame.images.get(nameImage), xImage, yImage, widthImagen, heightImagen, x, y , width, height);
////		System.out.println("pintando");
//		graphics.drawImage(FXMLControllerGame.images.get(nameImage), x-420, y-700);
//	}
//	@Override
//	public void mover(int y3) {
//		//this.y+=this.velocity;
//		
//	}
	@Override
	public Rectangle getRectangle() {
		if( this.nameImage == "bola") {
			return new Rectangle(x+3, y+3,width-6,height-4);
		}
		return null;
	}
	public boolean isCaught() {
		return caught;
	}
	public void setCaught(boolean caught) {
		this.caught = caught;
	}
	public int getpoints() {
		return points;
	}
	public void setpoints(int points) {
		this.points = points;
	}
	public int getlives() {
		return lives;
	}
	public void setlives(int lives) {
		this.lives = lives;
	}
	
	
}
