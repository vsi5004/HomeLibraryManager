/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homelibrarymanager;

import java.io.IOException;
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
        setupScene(stage, "MainScreen.fxml", "Home Library Manager");
    }
    
    public void gotoLoginScreen(Stage stage) throws Exception{
        setupScene(stage, "LoginScreen.fxml", "Login to Home Library Manager");
    }
    
    public void gotoUserScreen(Stage stage) throws Exception{
        setupScene(stage, "UserScreen.fxml", "Home Library Manager User");
    }
    
    public void gotoMediaScreen(Stage stage) throws Exception{
        setupScene(stage, "MediaScreen.fxml", "Home Library Manager Media");
    }
    
    private void setupScene(Stage stage, String Resource, String Title) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(Resource));
        Scene scene = new Scene(root);
        stage.setTitle(Title);
        stage.setScene(scene);
        stage.show();
    }
    
}
