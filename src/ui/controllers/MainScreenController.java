/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import Enums.MediaFormat;
import Enums.MediaType;
import dbClasses.AppMedia;
import homelibrarymanager.HomeLibraryManager;
import homelibrarymanager.LoggedInUser;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class MainScreenController implements Initializable {

    @FXML
    private ComboBox<String> CB_MediaType;
    @FXML
    private Button BT_AddMedia;
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
    @FXML
    private Label LB_AddMediaError;
    
    HomeLibraryManager manager = new HomeLibraryManager();
    
    @FXML
    private Tab TB_Collections;
    @FXML
    private Tab TB_Users;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        LB_UserGreeting.setText("Hello, " + LoggedInUser.getUserName());
    }

    @FXML
    private void HandleBT_AddMediaClicked(MouseEvent event) throws Exception {
        if (CB_MediaType.getValue() != null) {
            Stage stage = (Stage) BT_AddMedia.getScene().getWindow();
            for (MediaType type : MediaType.values()) {
                if (Objects.equals(CB_MediaType.getValue(), type.getValue())) {
                    LoggedInUser.setLastPage("Main");
                    manager.gotoMediaScreen(stage, type);
                }
            }
        }
        else{
            LB_AddMediaError.setText("Select a media type!");
        }

    }

    @FXML
    private void HandleBT_AddUserClicked(MouseEvent event) throws Exception {
        LoggedInUser.setLastPage("Main");
        Stage stage = (Stage) BT_AddUser.getScene().getWindow();
        manager.gotoUserScreen(stage);
    }

    @FXML
    private void HandleBT_EditUserInfoClicked(MouseEvent event) throws Exception {
        LoggedInUser.setLastPage("Main");
        LoggedInUser.setEditCurrent(true);
        Stage stage = (Stage) BT_EditUserInfo.getScene().getWindow();
        manager.gotoUserScreen(stage);
    }

    @FXML
    private void HandleBT_UserLogOut(MouseEvent event) throws Exception {
        LoggedInUser.setLastPage("Main");
        Stage stage = (Stage) BT_UserLogOut.getScene().getWindow();
        manager.gotoLoginScreen(stage);
    }

}
