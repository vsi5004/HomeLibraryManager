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
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.DeleteButton;
import models.EditButton;
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
    public TableView<Media> TV_Media;
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
    @FXML
    private TableColumn<Media, Boolean> TC_Edit;
    @FXML
    private TableColumn<Media, Boolean> TC_Delete;

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

        TC_Edit.setSortable(false);
        TC_Delete.setSortable(false);
        addButtonColumn(TC_Edit, true);
        addButtonColumn(TC_Delete, false);
    }

    private void addButtonColumn(TableColumn<Media, Boolean> TC, Boolean edit)
    {
        TC.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Media, Boolean>, ObservableValue<Boolean>>()
        {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Media, Boolean> p)
            {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        TC.setCellFactory(new Callback<TableColumn<Media, Boolean>, TableCell<Media, Boolean>>()
        {
            @Override
            public TableCell<Media, Boolean> call(TableColumn<Media, Boolean> p)
            {
                if (edit)
                {
                    return new EditButton();
                } else
                {
                    return new DeleteButton();
                }
            }

        });
    }

    private void syncMediaList()
    {
        mediaData.clear();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppMediaJpaController jpaMedia = new AppMediaJpaController(emf);
        List<AppMedia> Media = jpaMedia.findAppMediaEntities();

        for (AppMedia m : Media)
        {
            mediaData.add(transferToMediaModel(m));
        }
    }

    //Method that converts database model into program model for display in table
    private Media transferToMediaModel(AppMedia dbMedia)
    {
        if (MediaType.valueOf(dbMedia.getType()) == MediaType.Literature)
        {
            Literature literature = new Literature(dbMedia.getMediaId(), dbMedia.getTitle(), MediaType.valueOf(dbMedia.getType()), MediaFormat.valueOf(dbMedia.getFormat()), dbMedia.getUserId(), dbMedia.getAuthor());
            literature.setGenre(dbMedia.getGenre());
            literature.setEdition(dbMedia.getEdition());
            literature.setLoanedDate(dbMedia.getLoanedDate());
            literature.setLoanedTo(dbMedia.getLoanedTo());
            literature.setLocation(dbMedia.getLocation());
            literature.setPublisher(dbMedia.getPublisher());
            if (dbMedia.getRating() != null)
            {
                literature.setRating(dbMedia.getRating());
            }
            literature.setVersion(dbMedia.getVersion());
            literature.setVolume(dbMedia.getVolume());
            if (dbMedia.getYear() != null)
            {
                literature.setYear(dbMedia.getYear());
            }
            return literature;
        } else if (MediaType.valueOf(dbMedia.getType()) == MediaType.Movie)
        {
            Movie movie = new Movie(dbMedia.getMediaId(), dbMedia.getTitle(), MediaType.valueOf(dbMedia.getType()), MediaFormat.valueOf(dbMedia.getFormat()), dbMedia.getUserId(), dbMedia.getDirector());
            movie.setDuration(dbMedia.getDuration());
            movie.setGenre(dbMedia.getGenre());
            movie.setLoanedDate(dbMedia.getLoanedDate());
            movie.setLoanedTo(dbMedia.getLoanedTo());
            movie.setLocation(dbMedia.getLocation());
            if (dbMedia.getRating() != null)
            {
                movie.setRating(dbMedia.getRating());
            }
            if (dbMedia.getYear() != null)
            {
                movie.setYear(dbMedia.getYear());
            }
            return movie;
        } else if (MediaType.valueOf(dbMedia.getType()) == MediaType.Music)
        {
            Music music = new Music(dbMedia.getMediaId(), dbMedia.getTitle(), MediaType.valueOf(dbMedia.getType()), MediaFormat.valueOf(dbMedia.getFormat()), dbMedia.getUserId(), dbMedia.getArtist());
            return music;
        }

        return null;
    }

}
