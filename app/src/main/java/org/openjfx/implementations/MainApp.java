package org.openjfx.implementations;

import java.util.HashMap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainApp extends Application {
    private FXMLLoader loaderMenu;
    private FXMLLoader loaderOption;
    private FXMLLoader loaderPunctuation;
    private Parent rootMenu;
    private Parent rootOption;
    private Parent rootPunctuation;
    private Scene sceneMain;
    private Scene sceneOption;
    private Scene scenePunctuation;
    private int widthWindow = 1100;
	private int heightWindow = 700;
    
    


    // private FXMLLoader loaderGame;
    private Group rootGame;
    // private Group rootGame;
    private Scene sceneGame;
    private Canvas canva;
    private GraphicsContext graphic;

    public static HashMap < String , Image> images;



    
    public static void main(String[] args) {
        launch(args);
    }

    
    @Override
    public void start(Stage stage) throws Exception {
        loaderMenu = new FXMLLoader(getClass().getResource("../../../org/openjfx/views/menu-scene.fxml"));
        loaderOption = new FXMLLoader(getClass().getResource("../../../org/openjfx/views/option-scene.fxml"));
        loaderPunctuation = new FXMLLoader(getClass().getResource("../../../org/openjfx/views/punctuation-scene.fxml"));
        rootMenu = loaderMenu.load();
        rootOption = loaderOption.load();
        rootPunctuation = loaderPunctuation.load();
        sceneMain = new Scene(rootMenu, widthWindow, heightWindow);
        sceneOption = new Scene(rootOption, widthWindow, heightWindow);
        scenePunctuation = new Scene(rootPunctuation, widthWindow, heightWindow);
        // scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        rootGame = new Group();
        sceneGame = new Scene(rootGame, widthWindow, heightWindow);
        canva = new Canvas(widthWindow, heightWindow);
        rootGame.getChildren().add(canva);


        stage.setTitle("Dalton el Aventurero");
        stage.setScene(sceneMain);
        // stage.setScene(sceneOption);
        // stage.setScene(scenePunctuation);
        // stage.setScene(sceneGame);
        stage.show();
    }


    public void uploadImages(){
        // images.put("bola-fuego", new Image("../../org/openjfx/assets/items/bola.png"));
    }


    public void initializeComponents(){
        System.out.println("Componentes inicializados...");
    }



}