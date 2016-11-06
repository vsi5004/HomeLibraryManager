/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import Enums.MediaType;
import dbClasses.AppMedia;
import dbClasses.AppMediaJpaController;
import dbClasses.AppUser;
import dbClasses.AppUserJpaController;
import homelibrarymanager.HomeLibraryManager;
import homelibrarymanager.LoggedInUser;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.commons.lang3.StringUtils;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class LiteratureScreenController implements Initializable
{

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
    private TextField TF_Author;
    @FXML
    private TextField TF_Volume;
    @FXML
    private TextField TF_Publisher;
    @FXML
    private TextField TF_Version;
    @FXML
    private TextField TF_Edition;
    @FXML
    private Label LB_ValidationMessage;

    private AppMedia editedMedia = new AppMedia();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }

    @FXML
    private void HandleBT_SaveMediaClicked(MouseEvent event) throws Exception
    {
        if (ValidateFields())
        {
            LB_ValidationMessage.setText("Storing in database, please wait.");

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
            AppMediaJpaController jpaMedia = new AppMediaJpaController(emf);

            if (editedMedia.getMediaId() != null)
            {
                AppMedia media = jpaMedia.findAppMedia(editedMedia.getMediaId());
                media.setType(MediaType.LITERATURE.getValue());
                media.setFormat(CB_Format.getValue().toString());
                media.setTitle(TF_Title.getText());
                media.setAuthor(TF_Author.getText());
                media.setVolume(TF_Volume.getText());
                media.setPublisher(TF_Publisher.getText());
                media.setVersion(TF_Version.getText());
                media.setEdition(TF_Edition.getText());
                media.setGenre(TF_Genre.getText());
                media.setLocation(TF_Location.getText());
                media.setLoanedTo(TF_LoanedTo.getText());
                media.setLoanedDate(TF_LoanedDate.getText());

                if (!StringUtils.isBlank(TF_Rating.getText()))
                {
                    media.setRating(Integer.parseInt(TF_Rating.getText()));
                }

                jpaMedia.edit(media);

            } else
            {
                AppMedia media = new AppMedia();
                media.setType(MediaType.LITERATURE.getValue());
                media.setFormat(CB_Format.getValue().toString());
                media.setTitle(TF_Title.getText());
                media.setAuthor(TF_Author.getText());
                media.setVolume(TF_Volume.getText());
                media.setPublisher(TF_Publisher.getText());
                media.setVersion(TF_Version.getText());
                media.setEdition(TF_Edition.getText());
                media.setGenre(TF_Genre.getText());
                media.setLocation(TF_Location.getText());
                media.setLoanedTo(TF_LoanedTo.getText());
                media.setLoanedDate(TF_LoanedDate.getText());

                if (!StringUtils.isBlank(TF_Rating.getText()))
                {
                    media.setRating(Integer.parseInt(TF_Rating.getText()));
                }

                jpaMedia.create(media);
            }
            gotoLastPage();
        }
    }

    @FXML
    private void HandleBT_CancelMediaClicked(MouseEvent event) throws Exception
    {
        gotoLastPage();
    }

    private void gotoLastPage() throws Exception
    {
        Stage stage = (Stage) BT_CancelMedia.getScene().getWindow();
        LB_ValidationMessage.setText("");
        LoggedInUser.setLastPage("Literature");
        manager.gotoMainScreen(stage);
    }

    private boolean ValidateFields()
    {
        if (TF_Title.getText().isEmpty() || TF_Author.getText().isEmpty() || CB_Format.getValue() == null)
        {
            LB_ValidationMessage.setText("Please fill in Title, Author, and Format fields!");
            return false;
        }
        if (MediaExists(TF_Title.getText(), TF_Author.getText()) && !LoggedInUser.getEditCurrent())
        {
            LB_ValidationMessage.setText("Media item already exists!");
            return false;
        }
        if (!StringUtils.isBlank(TF_Rating.getText()) && !StringUtils.isNumeric(TF_Rating.getText()))
        {
            LB_ValidationMessage.setText("Rating must a number from 1-5!");
            TF_Rating.setText("");
            return false;
        }
        if (!StringUtils.isBlank(TF_Rating.getText()) && (Integer.valueOf(TF_Rating.getText()) < 1 || Integer.valueOf(TF_Rating.getText()) > 5))
        {
            LB_ValidationMessage.setText("Rating must be 1-5!");
            TF_Rating.setText("");
            return false;
        }
        return true;
    }

    private boolean MediaExists(String Title, String Author)
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppMediaJpaController jpaMedia = new AppMediaJpaController(emf);
        List<AppMedia> media = jpaMedia.findAppMediaEntities();

        for (AppMedia m : media)
        {
            if (Objects.equals(Title, m.getTitle()) && Objects.equals(Author, m.getAuthor()))
            {
                return true;
            }
        }
        return false;
    }

    public void initEditMedia(AppMedia media)
    {
        editedMedia = media;
    }
}
