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
import ui.controllers.LoginScreenController;
import ui.controllers.MainScreenController;
import ui.controllers.MediaScreenController;
import ui.controllers.UserScreenController;

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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        MainScreenController controller = (MainScreenController) loader.getController();
        setupScene(stage, "Home Library Manager", loader);
    }
    
    public void gotoLoginScreen(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginScreen.fxml"));
        LoginScreenController controller = (LoginScreenController) loader.getController();
        setupScene(stage, "Login to Home Library Manager", loader);
    }
    
    public void gotoUserScreen(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("UserScreen.fxml"));
        UserScreenController controller = (UserScreenController) loader.getController();
        setupScene(stage, "Home Library Manager User", loader);
    }
    
    public void gotoMediaScreen(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MediaScreen.fxml"));
        MediaScreenController controller = (MediaScreenController) loader.getController();
        setupScene(stage, "Home Library Manager Media", loader);
    }
    
    private void setupScene(Stage stage, String Title, FXMLLoader loader) throws IOException{
        Parent root = (Parent) loader.load();
        Scene scene = new Scene(root);
        stage.setTitle(Title);
        stage.setScene(scene);
        stage.show();
    }
    
}
