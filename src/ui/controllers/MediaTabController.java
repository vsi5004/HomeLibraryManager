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
import models.Literature;
import models.Media;
import models.Movie;
import models.Music;

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
    private TableView<Media> TV_Media;
    @FXML
    private TableColumn<Media, String> TC_Title;
    @FXML
    private TableColumn<Media, String> TC_Creator;
    @FXML
    private TableColumn<Media, MediaType> TC_Type;
    @FXML
    private TableColumn<Media, MediaFormat> TC_Format;
    @FXML
    private TableColumn<Media, Integer> TC_Rating;
    @FXML
    private TableColumn<Media, String> TC_Location;

    private ObservableList<Media> mediaData = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        TC_Title.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        TC_Creator.setCellValueFactory(new PropertyValueFactory<Media, String>("creator"));
        TC_Type.setCellValueFactory(new PropertyValueFactory<Media, MediaType>("type"));
        TC_Format.setCellValueFactory(new PropertyValueFactory<Media, MediaFormat>("format"));
        TC_Rating.setCellValueFactory(new PropertyValueFactory<Media, Integer>("rating"));
        TC_Location.setCellValueFactory(new PropertyValueFactory<Media, String>("location"));

        syncMediaList();
        TV_Media.setItems(mediaData);
    }

    private void syncMediaList()
    {
        mediaData.clear();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppMediaJpaController jpaMedia = new AppMediaJpaController(emf);
        List <AppMedia> Media = jpaMedia.findAppMediaEntities();
        
        for(AppMedia m : Media){
            mediaData.add(transferToMediaModel(m));
        }
    }
    
    //Method that converts database model into program model for display in table
    private Media transferToMediaModel(AppMedia dbMedia){
        if(MediaType.valueOf(dbMedia.getType().toUpperCase()) == MediaType.LITERATURE){
            Literature literature = new Literature(dbMedia.getMediaId(), dbMedia.getTitle(), MediaType.valueOf(dbMedia.getType().toUpperCase()), MediaFormat.valueOf(dbMedia.getFormat().toUpperCase()), dbMedia.getUserId(), dbMedia.getAuthor());
            return literature;
        }
        else if(MediaType.valueOf(dbMedia.getType().toUpperCase()) == MediaType.MOVIE){
            Movie movie = new Movie(dbMedia.getMediaId(), dbMedia.getTitle(), MediaType.valueOf(dbMedia.getType().toUpperCase()), MediaFormat.valueOf(dbMedia.getFormat().toUpperCase()), dbMedia.getUserId(), dbMedia.getDirector());
            return movie;
        }
        else if(MediaType.valueOf(dbMedia.getType().toUpperCase()) == MediaType.MUSIC){
            Music music = new Music(dbMedia.getMediaId(), dbMedia.getTitle(), MediaType.valueOf(dbMedia.getType().toUpperCase()), MediaFormat.valueOf(dbMedia.getFormat().toUpperCase()), dbMedia.getUserId(), dbMedia.getArtist());
            return music;
        }
        
        return null;
    }
}
