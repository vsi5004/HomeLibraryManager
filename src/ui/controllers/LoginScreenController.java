/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import dbClasses.AppUser;
import dbClasses.AppUserJpaController;
import homelibrarymanager.HomeLibraryManager;
import homelibrarymanager.LoggedInUser;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class LoginScreenController implements Initializable {
    @FXML
    private TextField TF_Username;
    @FXML
    private PasswordField TF_Password;
    @FXML
    private Label LB_LoginError;
    @FXML
    private Button BT_Login;
    @FXML
    private Button BT_NewUser;
    @FXML
    private Button BT_ForgotPassword;
    
    HomeLibraryManager manager = new HomeLibraryManager();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LB_LoginError.setText("");
    }    

    @FXML
    private void HandleBT_loginClicked(MouseEvent event) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppUserJpaController jpaUser = new AppUserJpaController(emf);
        List<AppUser> users = jpaUser.findAppUserEntities();

        for (AppUser p : users) {
            if(Objects.equals(TF_Username.getText(), p.getUsername()) && Objects.equals(TF_Password.getText(), p.getUserPassword())){
                Stage stage = (Stage) BT_Login.getScene().getWindow();
                LoggedInUser.getInstance();
                LoggedInUser.setInfo(p.getUserId(), p.getUsername(), p.getUserType());
                manager.gotoMainScreen(stage);
                break;
            }     
        }
        TF_Password.clear();
        LB_LoginError.setText("Your Username or Password doesn't match!");
    }

    @FXML
    private void HandleBT_NewUserClicked(MouseEvent event) throws Exception {
        LoggedInUser.getInstance();
        LoggedInUser.setLastPage("Login");
        Stage stage = (Stage) BT_Login.getScene().getWindow();
        manager.gotoUserScreen(stage);
    }

    @FXML
    private void HandleBT_ForgotPassword(MouseEvent event) {
    }
    
}
