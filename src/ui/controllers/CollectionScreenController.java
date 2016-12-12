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
import homelibrarymanager.HomeLibraryManager;
import homelibrarymanager.LoggedInUser;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.Collection;
import models.CollectionList;
import models.Literature;
import models.Media;
import models.Movie;
import models.Music;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class CollectionScreenController implements Initializable
{

    @FXML
    private TextField TF_Name;
    @FXML
    private TextArea TA_Description;
    @FXML
    private Label LB_ValidationMessage;
    @FXML
    private Button BT_SaveCollection;
    @FXML
    private Button BT_CancelCollection;
    @FXML
    private TableView<Media> TV_AllMedia;
    @FXML
    private TableColumn<Media, String> TC_AllMediaTitle;
    @FXML
    private TableColumn<Media, String> TC_AllMediaCreator;
    @FXML
    private Button BT_AddToCollection;
    @FXML
    private Button BT_RemoveFromCollection;
    @FXML
    private TableView<Media> TV_CollectionMedia;
    @FXML
    private TableColumn<Media, String> TC_CollectionTitle;
    @FXML
    private TableColumn<Media, String> TC_CollectionCreator;

    private Collection c;
    HomeLibraryManager manager = new HomeLibraryManager();
    private CollectionList collection;
    private ObservableList<Media> allMedia = FXCollections.observableArrayList();
    private ObservableList<Media> collectionMedia = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        TF_Name.setText(c.getName());
        TF_Name.setEditable(false);
        TA_Description.setText(c.getDescription());

        TC_AllMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        TC_AllMediaCreator.setCellValueFactory(new PropertyValueFactory<Media, String>("creator"));
        TC_CollectionTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        TC_CollectionCreator.setCellValueFactory(new PropertyValueFactory<Media, String>("creator"));

        syncCollectionMedia();
        syncAllMedia();

        TV_AllMedia.setItems(allMedia);
        TV_CollectionMedia.setItems(collectionMedia);

    }

    @FXML
    private void HandleBT_SaveCollectionClicked(MouseEvent event) throws Exception
    {

        c.setDescription(TA_Description.getText());
        c.setItems(convertFromObservable());

        //if it's a new collection
        if (!collection.existsInCollections(TF_Name.getText()))
        {
            collection.getAllCollections().add(c);
        }

        collection.writeCollectionsFile();

        Stage stage = (Stage) BT_SaveCollection.getScene().getWindow();
        LB_ValidationMessage.setText("");
        LoggedInUser.setLastPage("Collection");
        manager.gotoMainScreen(stage);

    }

    @FXML
    private void HandleBT_CancelCollectionClicked(MouseEvent event) throws Exception
    {
        Stage stage = (Stage) BT_CancelCollection.getScene().getWindow();
        LB_ValidationMessage.setText("");
        LoggedInUser.setLastPage("Collection");
        manager.gotoMainScreen(stage);
    }

    private ArrayList<Media> convertFromObservable()
    {
        ArrayList mediaList = new ArrayList();
        for (Media m : collectionMedia)
        {
            mediaList.add(m);
        }
        return mediaList;
    }

    public void initEditCollection(Collection edit) throws IOException
    {
        collection = new CollectionList();
        if (collection.getCollectionByName(edit.getName()) == null)
        {
            c = edit;
        } else
        {
            c = collection.getCollectionByName(edit.getName());
        }
    }

    @FXML
    private void HandleBT_AddToCollectionClicked(MouseEvent event)
    {
        Media m = TV_AllMedia.getSelectionModel().getSelectedItem();
        if (m != null)
        {
            collectionMedia.add(m);
            allMedia.remove(m);
        }
    }

    @FXML
    private void HandleBT_RemoveFromCollectionClicked(MouseEvent event)
    {
        Media m = TV_CollectionMedia.getSelectionModel().getSelectedItem();
        if (m != null)
        {
            allMedia.add(m);
            collectionMedia.remove(m);
        }
    }

    private void syncCollectionMedia()
    {
        collectionMedia.clear();
        for (Media m : c.getItems())
        {
            collectionMedia.add(m);
        }
    }

    private void syncAllMedia()
    {
        allMedia.clear();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppMediaJpaController jpaMedia = new AppMediaJpaController(emf);
        List<AppMedia> dbMedia = jpaMedia.findAppMediaEntities();

        for (AppMedia m : dbMedia)
        {
            Media media = transferToMediaModel(m);
            if (!c.inCollectionByTC(media.getTitle(), media.getCreator()))
            {
                allMedia.add(media);
            }
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
