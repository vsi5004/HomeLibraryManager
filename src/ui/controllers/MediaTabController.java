/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import Enums.MediaFormat;
import Enums.MediaType;
import dbClasses.AppMedia;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class MediaTabController implements Initializable
{

    @FXML
    private Tab TB_Media;
    @FXML
    private TableView<AppMedia> TV_Media;
    @FXML
    private TableColumn<AppMedia, String> TC_Title;
    @FXML
    private TableColumn<AppMedia, String> TC_Creator;
    @FXML
    private TableColumn<AppMedia, MediaType> TC_Type;
    @FXML
    private TableColumn<AppMedia, MediaFormat> TC_Format;
    @FXML
    private TableColumn<AppMedia, Integer> TC_Rating;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    
    
}
