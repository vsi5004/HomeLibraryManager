/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homelibrarymanager;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleBT_loginClicked(MouseEvent event) {
    }

    @FXML
    private void HandleBT_NewUserClicked(MouseEvent event) {
    }

    @FXML
    private void HandleBT_ForgotPassword(MouseEvent event) {
    }
    
}
