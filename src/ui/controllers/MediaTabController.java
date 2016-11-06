/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import Enums.MediaFormat;
import Enums.MediaType;
import dbClasses.AppMedia;
import dbClasses.AppMediaJpaController;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    @FXML
    private TableColumn<AppMedia, String> TC_Location;

    private ObservableList<AppMedia> mediaData = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        TC_Title.setCellValueFactory(new PropertyValueFactory<AppMedia, String>("title"));
        TC_Creator.setCellValueFactory(new PropertyValueFactory<AppMedia, String>("creator"));
        TC_Type.setCellValueFactory(new PropertyValueFactory<AppMedia, MediaType>("type"));
        TC_Format.setCellValueFactory(new PropertyValueFactory<AppMedia, MediaFormat>("format"));
        TC_Rating.setCellValueFactory(new PropertyValueFactory<AppMedia, Integer>("rating"));
        TC_Location.setCellValueFactory(new PropertyValueFactory<AppMedia, String>("location"));

        syncMediaList();
        TV_Media.setItems(mediaData);
    }

    private void syncMediaList()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppMediaJpaController jpaMedia = new AppMediaJpaController(emf);
        List <AppMedia> Media = jpaMedia.findAppMediaEntities();
        mediaData = FXCollections.observableArrayList(Media);
    }
}
