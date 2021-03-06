package com.groupfour.patientportal_vgui;

import java.awt.Image;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;
    
/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    static CurrentUser currentUser;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("loginScreen"), 1280, 720);
        stage.setScene(scene);
        stage.setResizable(false);
        
        //Image icon = new Image(getClass().getResourceAsStream("IMG_3300.png"));
        //stage.getIcons().add(icon);
        
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
        
    }

    public static void main(String[] args) {
        launch();
        
    }

}