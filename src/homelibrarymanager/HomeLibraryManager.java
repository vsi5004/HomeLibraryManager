/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homelibrarymanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class HomeLibraryManager extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        gotoLoginScreen(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void gotoMainScreen(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Home Library Manager");
        stage.setScene(scene);
        stage.show();
    }
    
    public void gotoLoginScreen(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Login to Home Library Manager");
        stage.setScene(scene);
        stage.show();
    }
    
    public void gotoUserScreen(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UserScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Home Library Manager User");
        stage.setScene(scene);
        stage.show();
    }
    
    public void gotoMediaScreen(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MediaScreen.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Home Library Manager Media");
        stage.setScene(scene);
        stage.show();
    }
    
}
