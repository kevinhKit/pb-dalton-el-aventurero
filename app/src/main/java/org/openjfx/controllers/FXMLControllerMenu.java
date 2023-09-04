package org.openjfx.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FXMLControllerMenu {

    @FXML
    private Button btnCloseGame;
    @FXML
    private Button btnStartGame;

    public void initialize() {
        btnCloseGame.setOnAction(event -> {
            Stage stage = (Stage) btnCloseGame.getScene().getWindow();
            stage.close();
        });
    }

    @FXML
    public void onBtnCloseGame(){
        System.out.println("Controlador incializado...");
    }

    @FXML
    private void handleStartGame() {
 
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/openjfx/views/game-scene.fxml"));
            Parent gameRoot = loader.load();
            FXMLControllerGame gameController = loader.getController();
    
            Scene gameScene = new Scene(gameRoot);
            Stage stage = (Stage) btnStartGame.getScene().getWindow();
            stage.setScene(gameScene);
    
            // Configura los manejadores de eventos de teclado para la escena del juego
            gameController.setupKeyHandlers(gameScene);
    
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}