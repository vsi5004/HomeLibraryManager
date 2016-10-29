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
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class Controls both the main login screen and the pop-up for
 * security questions and password retrieval
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
    @FXML
    private Label LB_QuestionError;
    @FXML
    private Button BT_GetPassword;
    @FXML
    private Button BT_BackToLogin;
    @FXML
    private TextField TF_SecurityAnswer;
    @FXML
    private Label LB_Password;

    HomeLibraryManager manager = new HomeLibraryManager();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void HandleBT_loginClicked(MouseEvent event) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppUserJpaController jpaUser = new AppUserJpaController(emf);
        List<AppUser> users = jpaUser.findAppUserEntities();

        for (AppUser p : users) {
            if (Objects.equals(TF_Username.getText(), p.getUsername()) && Objects.equals(TF_Password.getText(), p.getUserPassword())) {
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
    private void HandleBT_ForgotPasswordClicked(MouseEvent event) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/homelibrarymanager/LoginQuestionScreen.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Password Retrieval");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(BT_ForgotPassword.getScene().getWindow());
        stage.showAndWait();
    }

    @FXML
    private void HandleBT_GetPasswordClicked(MouseEvent event) {
    }

    @FXML
    private void HandleBT_BackToLoginClicked(MouseEvent event) {
        Stage stage=(Stage)BT_BackToLogin.getScene().getWindow();
        stage.close();
    }

}
