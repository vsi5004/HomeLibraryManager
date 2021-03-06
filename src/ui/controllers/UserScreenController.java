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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
public class UserScreenController implements Initializable
{

    HomeLibraryManager manager = new HomeLibraryManager();
    @FXML
    private TextField TF_UserName;
    @FXML
    private TextField TF_UserPassword;
    @FXML
    private TextArea TA_SecurityQuestion;
    @FXML
    private TextField TF_SecurityQuestionAnswer;
    @FXML
    private ComboBox<?> CB_UserType;
    @FXML
    private Button BT_SaveUser;
    @FXML
    private Button BT_CancelUser;
    @FXML
    private Label LB_ValidationMessage;

    private AppUser editedUser = new AppUser();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        LB_ValidationMessage.setText("");
        CB_UserType.setVisible(true);
        if (editedUser.getUsername() != null)
        {
            TF_UserName.setText(editedUser.getUsername());
            TF_UserPassword.setText(editedUser.getUserPassword());
            TA_SecurityQuestion.setText(editedUser.getSecurityQuestion());
            TF_SecurityQuestionAnswer.setText(editedUser.getSecurityAnswer());
            CB_UserType.setVisible(false);
        }
    }

    @FXML
    private void HandleBT_SaveUserClicked(MouseEvent event) throws Exception
    {

        if (ValidateFields())
        {
            LB_ValidationMessage.setText("Storing in database, please wait.");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
            AppUserJpaController jpaUser = new AppUserJpaController(emf);

            if (editedUser.getUsername() != null)
            {
                editedUser.setUsername(TF_UserName.getText());
                editedUser.setUserPassword(TF_UserPassword.getText());
                editedUser.setSecurityQuestion(TA_SecurityQuestion.getText());
                editedUser.setSecurityAnswer(TF_SecurityQuestionAnswer.getText());
                jpaUser.edit(editedUser);

            } else
            {
                AppUser user = new AppUser();
                user.setUsername(TF_UserName.getText());
                user.setUserPassword(TF_UserPassword.getText());
                user.setSecurityQuestion(TA_SecurityQuestion.getText());
                user.setSecurityAnswer(TF_SecurityQuestionAnswer.getText());
                user.setUserType(CB_UserType.getValue().toString().toUpperCase());
                jpaUser.create(user);
            }
            gotoLastPage();
        }
    }

    @FXML
    private void HandleBT_CancelUserClicked(MouseEvent event) throws Exception
    {
        gotoLastPage();
    }

    private void gotoLastPage() throws Exception
    {
        Stage stage = (Stage) BT_CancelUser.getScene().getWindow();
        LB_ValidationMessage.setText("");
        if (LoggedInUser.getLastPage().equals("Login"))
        {
            LoggedInUser.setLastPage("User");
            manager.gotoLoginScreen(stage);
        } else
        {
            LoggedInUser.setLastPage("User");
            //LoggedInUser.setEditCurrent(false);
            manager.gotoMainScreen(stage);
        }
    }

    private boolean ValidateFields()
    {
        if (TF_UserName.getText().isEmpty() || TF_UserPassword.getText().isEmpty() || TA_SecurityQuestion.getText().isEmpty() || TF_SecurityQuestionAnswer.getText().isEmpty() || (CB_UserType.isVisible() && CB_UserType.getValue() == null))
        {
            LB_ValidationMessage.setText("Please fill in all fields!");
            return false;
        }
        if (UsernameExists(TF_UserName.getText()) && editedUser.getUsername() == null)
        {
            LB_ValidationMessage.setText("Username already taken! Please pick another one.");
            return false;
        }
        return true;
    }

    private boolean UsernameExists(String Username)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppUserJpaController jpaUser = new AppUserJpaController(emf);
        List<AppUser> users = jpaUser.findAppUserEntities();

        for (AppUser p : users)
        {
            if (Objects.equals(Username, p.getUsername()))
            {
                return true;
            }
        }
        return false;
    }

    public void initEditUser(int editUserID)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppUserJpaController jpaUser = new AppUserJpaController(emf);
        editedUser = jpaUser.findAppUser(editUserID);
    }
}
