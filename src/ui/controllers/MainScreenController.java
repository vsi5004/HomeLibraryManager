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
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

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
    @FXML
    private Button BT_Search;
    //@FXML
    //private ComboBox<String> CB_SearchField;
    @FXML
    private TextField TF_SearchTerm;
    
    HomeLibraryManager manager = new HomeLibraryManager();
    String searchTerm;
    
    @FXML
    private Tab TB_Collections;
    @FXML
    private Tab TB_Media;
    @FXML
    private Tab TB_Users;
    @FXML
    private TextField TF_CollectionName;
    @FXML
    private TextArea TA_CollectionDesc;
    @FXML
    private Label LB_AddCollectionError;
    @FXML
    private Button BT_AddCollection;
    @FXML
    private ChoiceBox<?> CB_SearchField;

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
        //LoggedInUser.setEditCurrent(true);
        Stage stage = (Stage) BT_EditUserInfo.getScene().getWindow();
        manager.gotoUserScreen(stage, LoggedInUser.getUserID());
    }

    @FXML
    private void HandleBT_UserLogOut(MouseEvent event) throws Exception {
        LoggedInUser.setLastPage("Main");
        Stage stage = (Stage) BT_UserLogOut.getScene().getWindow();
        manager.gotoLoginScreen(stage);
    }
    
    @FXML
    private void BT_SearchClicked(MouseEvent event) throws Exception {
        searchTerm = TF_SearchTerm.getText();
        System.out.println("Search clicked " + TF_SearchTerm.getText());
        if (TF_SearchTerm.getText() != null) 
        {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/homelibrarymanager/MediaTab.fxml"));
            Parent root = (Parent) loader.load();
            MediaTabController controller = (MediaTabController) loader.getController();
            controller.syncMediaList(searchTerm);

            stage.setScene(new Scene(root));
            stage.setTitle("Results for " + "type" + TF_SearchTerm.getText());
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(BT_Search.getScene().getWindow());
            stage.showAndWait();
        }
        else 
        {
            System.out.println("Null search term");
        }
    }

    @FXML
    private void HandleBT_AddCollectionClicked(MouseEvent event)
    {
    }

}
