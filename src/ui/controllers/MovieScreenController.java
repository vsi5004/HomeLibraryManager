/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import homelibrarymanager.HomeLibraryManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class MovieScreenController implements Initializable {

    HomeLibraryManager manager = new HomeLibraryManager();
    @FXML
    private ComboBox<?> CB_Format;
    @FXML
    private TextField TF_Title;
    @FXML
    private TextField TF_Genre;
    @FXML
    private TextField TF_Location;
    @FXML
    private TextField TF_Rating;
    @FXML
    private TextField TF_LoanedTo;
    @FXML
    private TextField TF_LoanedDate;
    @FXML
    private Button BT_SaveMedia;
    @FXML
    private Button BT_CancelMedia;
    @FXML
    private TextField TF_Director;
    @FXML
    private TextField TF_Duration;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void HandleBT_SaveMediaClicked(MouseEvent event) {
    }

    @FXML
    private void HandleBT_CancelMediaClicked(MouseEvent event) {
    }
    
}
