/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import homelibrarymanager.HomeLibraryManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class MainScreenController implements Initializable {
    
    private ComboBox<String> CB_MediaType;
    @FXML
    private Button BT_AddMedia;
    @FXML
    private TextField TF_MediaTitle;
    @FXML
    private Button BT_ManageUsers;
    @FXML
    private Button BT_AddUser;
    @FXML
    private Button BT_EditUserInfo;
    @FXML
    private Label LB_Sort;
    @FXML
    private Label LB_Search;
    @FXML
    private Label LB_UserGreeting;
    @FXML
    private Button BT_UserLogOut;
    
    HomeLibraryManager manager = new HomeLibraryManager();
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void HandleBT_AddMediaClicked(MouseEvent event) throws Exception {
        Stage stage = (Stage) BT_AddMedia.getScene().getWindow();
        manager.gotoMediaScreen(stage);
    }

    @FXML
    private void HandleBT_ManageUsersClicked(MouseEvent event) {
    }

    @FXML
    private void HandleBT_AddUserClicked(MouseEvent event) throws Exception {
        Stage stage = (Stage) BT_AddUser.getScene().getWindow();
        manager.gotoUserScreen(stage);
    }

    @FXML
    private void HandleBT_EditUserInfoClicked(MouseEvent event) throws Exception {
        Stage stage = (Stage) BT_EditUserInfo.getScene().getWindow();
        manager.gotoUserScreen(stage);
    }

    @FXML
    private void HandleBT_UserLogOut(MouseEvent event) throws Exception {
        Stage stage = (Stage) BT_UserLogOut.getScene().getWindow();
        manager.gotoLoginScreen(stage);
    }
    
}
