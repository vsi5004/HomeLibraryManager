/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class CollectionTabController implements Initializable
{

    @FXML
    private TableView<?> TV_Collections;
    @FXML
    private TableColumn<?, ?> TC_Name;
    @FXML
    private TableColumn<?, ?> TC_Description;
    @FXML
    private TableColumn<?, ?> TC_Edit;
    @FXML
    private TableColumn<?, ?> TC_Delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
