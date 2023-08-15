package com.example.assignment1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create a new instance of your GUI class and set it as the root of the scene
        BasketballPlayerGUI basketballPlayerGUI = new BasketballPlayerGUI();
        Scene scene = new Scene(basketballPlayerGUI.createMainScene(), 800, 600);

        // Set the scene and show the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Basketball Player Data");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
