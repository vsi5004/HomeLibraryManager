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
    private Label LB_SecurityQuestion;
    @FXML
    private Button BT_GetPassword;
    @FXML
    private Button BT_BackToLogin;
    @FXML
    private TextField TF_SecurityAnswer;
    @FXML
    private Label LB_Password;

    HomeLibraryManager manager = new HomeLibraryManager();
    private AppUser user = new AppUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void HandleBT_loginClicked(MouseEvent event) throws Exception {
        if (getAppUser(TF_Username.getText()) && Objects.equals(TF_Password.getText(), user.getUserPassword())) {

            Stage stage = (Stage) BT_Login.getScene().getWindow();
            LoggedInUser.getInstance();
            LoggedInUser.setInfo(user.getUserId(), user.getUsername(), user.getUserType());
            manager.gotoMainScreen(stage);

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
        if (getAppUser(TF_Username.getText())) {

            LB_LoginError.setText("");

            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/homelibrarymanager/LoginQuestionScreen.fxml"));
            Parent root = (Parent) loader.load();
            LoginScreenController controller = (LoginScreenController) loader.getController();

            stage.setScene(new Scene(root));
            stage.setTitle("Password Retrieval");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(BT_ForgotPassword.getScene().getWindow());
            controller.setPasswordRetrievalScreen(stage, user); // or what you want to do
            stage.showAndWait();
        }
        else {
            TF_Username.clear();
            TF_Password.clear();
            LB_LoginError.setText("Your Username wasn't found in the database!");
        }
    }

    @FXML
    private void HandleBT_GetPasswordClicked(MouseEvent event) {
        if(Objects.equals(TF_SecurityAnswer.getText().toUpperCase(),user.getSecurityAnswer().toUpperCase())){
            LB_Password.setText(user.getUserPassword());
        }
        else{
            LB_Password.setText("");
            TF_SecurityAnswer.setText("");
            LB_QuestionError.setText("Your answer is incorrect!");
        }
    }

    @FXML
    private void HandleBT_BackToLoginClicked(MouseEvent event) {
        Stage stage = (Stage) BT_BackToLogin.getScene().getWindow();
        stage.close();
    }

    private void setPasswordRetrievalScreen(Stage stage, AppUser u) {
        user = u;
        LB_SecurityQuestion.setText(user.getSecurityQuestion());
    }

    private boolean getAppUser(String Username) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppUserJpaController jpaUser = new AppUserJpaController(emf);
        List<AppUser> users = jpaUser.findAppUserEntities();

        for (AppUser p : users) {
            if (Objects.equals(Username, p.getUsername())) {
                user = p;
                return true;
            }
        }
        return false;
    }

}
