package org.openjfx.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Comparator;
import javax.swing.JOptionPane;
import java.io.File;
import java.util.Collections;







import org.openjfx.classes.AnimationEnemy;
import org.openjfx.classes.AnimationPlayer;
import org.openjfx.classes.GameBackground;
import org.openjfx.classes.Item;
import org.openjfx.classes.Punctuation;
import org.openjfx.classes.Stroke;
import org.openjfx.classes.Tile;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXMLControllerGame {
	private boolean gamePaused = false;
    private int widthWindow = 1100 ;
	private int heightWindow = 700 ;
    public static boolean right;
	public static boolean left;
	public static boolean up;
	public static boolean down;
	public static boolean advance = false;
	public static boolean collisionObstacleFront = false;
    public static HashMap< String , Image > images; 
    private AnimationTimer animationTimer;
	private ArrayList<Tile> tiles;
	private ArrayList<Tile> tile2;
	private ArrayList<Item> items;
	private ArrayList<Item> item2;
	private ArrayList<Stroke> strokes;
	private ArrayList<AnimationEnemy> enemies;
	public static HashMap< String, Image> imagenes;
    private AnimationPlayer animationPlayer;
    private GameBackground background;
    private int x = 0;
    private int y = 0;
	private boolean isGameOver = false;

    private int tilemaps[][] = {
        {3,1,1,3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,3,3,3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3},
        {3,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,13,3}
    
    };

    private int enemigo[][]= {
        {0,0,1,0,0,0,0,0,0,2,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0}
};
private int scenerioItem[][]= {
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,1},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {1,0,0,0,0,0,0,0,0,0,0,0}
};
private int scenerioItem2[][]= {
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {2,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,2}
};
private int tilemap2[][] = {
        {0,0,0,0,1,0,2,0,3,0,2,0,3,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,1,0,0,1,0,0,1,0,0,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,1,0,0,1,0,0,1,0,0,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,1,0,0,1,0,0,1,0,0,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,1,0,0,1,0,0,1,0,0,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,1,0,0,1,0,0,1,0,0,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,1,0,0,1,0,0,1,0,0,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,1,0,1,0,0,1,0,0,1,0,0,1,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };

    @FXML
    private Canvas canvas;

    private GraphicsContext graphics;

    @FXML
    public void initialize() {
        start();
    }


    public void start(){
        initializeComponents();
    }

    public void initializeComponents(){
        canvas.setWidth(widthWindow);
        canvas.setHeight(heightWindow);
        graphics = canvas.getGraphicsContext2D();
        animationPlayer = new AnimationPlayer( 180 , 600 , 3 , "personaje" , 3 , "descanso2" );
        background = new GameBackground(50 , 0 ,  1 , "fuego" , "fuego2");
        images = new HashMap< String , Image >();
        strokes = new ArrayList<Stroke>();
        loadImages();
        initializeObjectGame();
        cycleGame();
    }

    public void loadImages(){
        images.put( "fuego" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/scenery/LIENZO1.png")));
        images.put( "fuego2" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/scenery/LIENZO2.png")));
        images.put( "tile" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/scenery/tilemaps.png")));
        images.put( "tile2" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/scenery/arboles.png")));
        images.put( "personaje" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/sprites/Dalton.png")));
        images.put( "rey" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/sprites/rey.png")));
        images.put( "yaser" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/sprites/yaser.png")));
        images.put( "escudo" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/items/proteccion.png")));
        images.put( "bola" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/items/bola.png")));
        images.put( "vidat" , new Image(getClass().getResourceAsStream("/org/openjfx/assets/items/corazon.png")));
    }

    public void initializeObjectGame(){
		tiles = new ArrayList<Tile>();
		for ( int i = 0 ; i < tilemaps.length ; i++ ) {
			for( int j = 0 ; j < tilemaps[i].length ; j++ ) {
				if(tilemaps[i][j]!=0) {
					this.tiles.add(new Tile ( tilemaps[i][j], j*50 ,i*50 , 2, "tile", 50, 50));				
				}
			}
		}
		tile2 = new ArrayList<Tile>();
		for ( int i = 0 ; i < tilemap2.length ; i++ ) {
			for( int j = 0 ; j < tilemap2[i].length ; j++ ) {
				if(tilemap2[i][j]!=0) {
					this.tile2.add(new Tile ( tilemap2[i][j], j*80 ,i*100 , 2, "tile2", 80, 100));
				}
			}
		}
		items = new ArrayList<Item>();
		for ( int i = 0 ; i < scenerioItem.length ; i++ ) {
			for( int j = 0 ; j < scenerioItem[i].length ; j++ ) {
				if(scenerioItem[i][j]!=0) {
						this.items.add(new Item ( scenerioItem[i][j],94 + j*80 ,i*100 , 4, "vidat", 0, 1));
				}
			}
		}
		item2 = new ArrayList<Item>();
		for ( int i = 0 ; i < scenerioItem2.length ; i++ ) {
			for( int j = 0 ; j < scenerioItem2[i].length ; j++ ) {
				if(scenerioItem2[i][j]!=0) {
						this.item2.add(new Item ( scenerioItem2[i][j],94 + j*80 ,i*100 , 4, "escudo", 0, 1));
				}
			}
		}
		enemies = new ArrayList<AnimationEnemy>();
		for ( int i = 0 ; i < enemigo.length ; i++ ) {
			for( int j = 0 ; j < enemigo[i].length ; j++ ) {
				if(enemigo[i][j]==1) {
						this.enemies.add(new AnimationEnemy (j*100 , i*110 , 2 , "rey" , 1 , "down" ));
				}
				if(enemigo[i][j]==2) {
					this.enemies.add(new AnimationEnemy (j*100 , i*110-200 , 2 , "yaser" , 1 , "up" ));
			}
			}
		}
    }


    public void setupKeyHandlers(Scene scene) {

        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case RIGHT:
                    right = true;
                    animationPlayer.setCurrentAnimation("right");
                    x += 10;
                    break;
                case LEFT:
                    left = true;
                    animationPlayer.setCurrentAnimation("left");
                    x -= 10;
                    break;
                case UP:
                    up = true;
                    animationPlayer.setCurrentAnimation("up");
                    y -= 10;
                    break;
                case DOWN:
                    down = true;
                    animationPlayer.setCurrentAnimation("down");
                    y += 10;
                    break;
                case SPACE:
                    strokes.add(new Stroke(animationPlayer.getX() + 50,
                            animationPlayer.getY(),
                            3,
                            "bola",
                            20,
                            1));
                    break; 
				case P:
				case ESCAPE:
					togglePause();
					break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case RIGHT:
                    right = false;
                    break;
                case LEFT:
                    left = false;
                    break;
                case UP:
                    up = false;
                    break;
                case DOWN:
                    down = false;
                    break;
                case SPACE:
                    animationPlayer.setVelocity(3);
                    break;
            }
        });
    }

    public void cycleGame(){
        long initialTime = System.nanoTime();
        animationTimer = new AnimationTimer() {
            @Override
            public void handle(long currentTime){
				double t = (currentTime - initialTime) / 1000000000.0;
				if (!isGameOver) {
					updateState(t);
					show();
				} else {
					graphics.fillText("VIDAS : " + animationPlayer.getLives(), 100, 100);
				}
            }
        };
		animationTimer.start();
    }

    public void updateState(Double t){
		if(animationPlayer.getLives() == -1) {
			endGame();
			updatePunctuation(animationPlayer.getPunctuation());
		} else {
			animationPlayer.verifyState(tiles, tile2);
			background.move(animationPlayer.getY());
			animationPlayer.verifyCollisionItem(items);
			animationPlayer.verifyCollisionItem(item2);
			animationPlayer.verifyCollisionTile(tiles);
			animationPlayer.verificarColisionAnimationEnemy2(enemies);
			animationPlayer.verifyCollisionTile(tile2);
			animationPlayer.calculateFrame(t);
			for(int i = 0 ; i < enemies.size() ; i++ ) {
				enemies.get(i).calculateFrame(t);
			}
			for(int i = 0 ; i < enemies.size() ; i++ ) {
				enemies.get(i).verifyCollisionTile(tiles);
				enemies.get(i).verifyCollisionTile(tile2);
			}
			for(int i = 0 ; i < enemies.size() ; i++ ) {
				enemies.get(i).verifyCollisionTile(tile2);
			}
			for(int i = 0 ; i < strokes.size() ; i++ ) {
				strokes.get(i).verifyCollisionAnimationEnemy2(enemies, i, strokes);
			}
			animationPlayer.move(tiles.get(tiles.size()-1).getY());
			for(int i = 0 ; i < enemies.size() ; i++ ) {
				enemies.get(i).chase(animationPlayer);
				enemies.get(i).move(0);
			}
			for(int i = 0 ; i < tiles.size() ; i++ ) {
				int u=(tiles.size()-14);
					tiles.get(i).move(animationPlayer.getY());
				if(2<tiles.size()) {
					if(tiles.get(i).getY()<-80) {
						tiles.remove(i);
					}
				}
				if(2<tiles.size()) {
					int mas=50;
					if(tiles.get(u).getY()<600+mas) {
						this.tiles.add(new Tile ( 3, 0 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 50 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 100 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 150 ,650 +mas, 2, "tile", 50, 50));					
						this.tiles.add(new Tile ( 13, 100 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 150 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 200 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 250 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 300 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 350 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 400 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 450 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 500 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 550 ,650 +mas, 2, "tile", 50, 50));					
						this.tiles.add(new Tile ( 13, 600 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 650 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 700 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 750 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 800 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 850 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 900 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 950 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 13, 1000 ,650 +mas, 2, "tile", 50, 50));
						this.tiles.add(new Tile ( 3, 1050 ,650 +mas, 2, "tile", 50, 50));
					}
				}
			}
			for(int i = 0 ; i < tile2.size() ; i++ ) {
				int u=(tile2.size()-1);
					tile2.get(i).move(animationPlayer.getY());
				if(2<tile2.size()) {
					if(tile2.get(i).getY()<-80) {
						tile2.remove(i);
					}
				}
	
				if(2<tile2.size()) {
					if(tile2.get(u).getY()+200<=700) {
						this.tile2.add(new Tile ( 1, 80 ,720 , 2, "tile2", 80, 100));
						this.tile2.add(new Tile ( 1, 240 ,720 , 2, "tile2", 80, 100));
						this.tile2.add(new Tile ( 1, 480 ,720 , 2, "tile2", 80, 100));
						this.tile2.add(new Tile ( 1, 720 ,720 , 2, "tile2", 80, 100));
						this.tile2.add(new Tile ( 1, 960 ,720 , 2, "tile2", 80, 100));
	
					}
				}
				if(enemies.size()==0) {
					this.enemies.add(new AnimationEnemy (100 , -800 , 2 , "rey" , 1 , "down" ));
					this.enemies.add(new AnimationEnemy (300 , -200 , 2 , "yaser" , 1 , "down" ));
				}
				if(tile2.get(u).getY()<=700) {
				}
			}
			for(int i = 0 ; i < tile2.size() ; i++ ) {
				tile2.get(i).move(animationPlayer.getY());
			}
			for(int i = 0 ; i < items.size() ; i++ ) {
				items.get(i).move(animationPlayer.getY());
			}
			for(int i = 0 ; i < item2.size() ; i++ ) {
				item2.get(i).move(animationPlayer.getY());
			}
			for(int i = 0 ; i < strokes.size() ; i++ ) {
				strokes.get(i).move(animationPlayer.getY());
				if(strokes.get(i).getY()<-30) {
					strokes.remove(i);
				}
			}
		}

    }


    public void show(){
        background.paint(graphics);
		for(int i = 0 ; i < tiles.size() ; i++ ) {
			tiles.get(i).paint(graphics);
		}
		for(int i = 0 ; i < tile2.size() ; i++ ) {
			tile2.get(i).paint(graphics);
		}
		for(int i = 0 ; i < items.size() ; i++ ) {
			items.get(i).paint(graphics);
		}
		for(int i = 0 ; i < item2.size() ; i++ ) {
			item2.get(i).paint(graphics);
		}

		for(int i = 0 ; i < strokes.size() ; i++ ) {
			strokes.get(i).paint(graphics);
		}
		for(int i = 0 ; i < enemies.size() ; i++ ) {
			enemies.get(i).paint(graphics);
		}
		animationPlayer.paint(graphics);
		graphics.setFill(Color.AQUA);
		graphics.fillRect(7, 10, 100, 15);
		graphics.setFill(Color.BLACK);
		graphics.fillText("VIDAS : " + animationPlayer.getLives(), 32, 22);
		graphics.setFill(Color.AZURE);
		graphics.fillRect(110, 10, 150, 15);
		graphics.setFill(Color.BLACK);
		graphics.fillText("PUNTUACION : " + animationPlayer.punctuation, 135, 22);
		
    }

	private void togglePause() {
		if (gamePaused) {
			resumeGame();
		} else {
			pauseGame();
		}
		gamePaused = !gamePaused;
	}
	
	private void pauseGame() {
		animationTimer.stop();
		showPauseMenu();
	}
	
	private void resumeGame() {
		animationTimer.start();
		hidePauseMenu();
	}
	
	private void showPauseMenu() {
	}
	
	private void hidePauseMenu() {
	}


	private ArrayList<Punctuation> readPunctuations() {
        ArrayList<Punctuation> punctuations = new ArrayList<>();
        try {
            File file = new File("punctuation.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    punctuations.add(new Punctuation(parts[0], Integer.parseInt(parts[1])));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return punctuations;
    }

    private void writePunctuations(ArrayList<Punctuation> punctuations) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("punctuation.csv"));
            for (Punctuation p : punctuations) {
                writer.write(p.getName() + "," + p.getScore() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void updatePunctuation(int currentScore) {
		ArrayList<Punctuation> punctuations = readPunctuations();
		System.out.println("Current score: " + currentScore);
		System.out.println("Number of saved scores: " + punctuations.size());
	
		Collections.sort(punctuations, Comparator.comparing(Punctuation::getScore).reversed());
	
		if (punctuations.size() < 10 || currentScore > punctuations.get(punctuations.size() - 1).getScore()) {
			System.out.println("Showing JOptionPane");
			String playerName = JOptionPane.showInputDialog("¡Nuevo récord! Ingresa tu nombre:");
			if (playerName != null && !playerName.isEmpty()) {
				punctuations.add(new Punctuation(playerName, currentScore));
			}
		} else {
			System.out.println("JOptionPane not shown");
		}
	
		Collections.sort(punctuations, Comparator.comparing(Punctuation::getScore).reversed());
		if (punctuations.size() > 10) {
			punctuations = new ArrayList<>(punctuations.subList(0, 10));
		}
	
		writePunctuations(punctuations);
	}
	

	private void endGame() {
		isGameOver = true;
		// animationTimer.stop();	
	}

	public void showMainMenu() {
		ArrayList<Punctuation> punctuations = readPunctuations();
	}


	public void  gameOver(){
		Font originalFont = graphics.getFont();
		Color originalFillColor = (Color) graphics.getFill();


		String text = "GAME OVER";
		double paddingBlock = 20;
		double paddingInline = 30;
		Font font = new Font("Arial", 32);
		graphics.setFont(font);

		Text tempText = new Text(text);
		tempText.setFont(font);
		double textWidth = tempText.getBoundsInLocal().getWidth();
		double textHeight = tempText.getBoundsInLocal().getHeight();

		double bgX = 100 - paddingInline;
		double bgY = 100 - textHeight - paddingBlock + tempText.getBoundsInLocal().getMaxY();
		double bgWidth = textWidth + paddingInline * 2;
		double bgHeight = textHeight + paddingBlock * 2;


		graphics.setFill(Color.BLACK);
		graphics.fillRect(bgX, bgY, bgWidth, bgHeight);


		graphics.setFill(Color.WHITE);
		graphics.fillText(text, 100, 100);

		graphics.setFont(originalFont);
		graphics.setFill(originalFillColor);
	}
	

    
}




