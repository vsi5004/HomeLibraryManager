/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import homelibrarymanager.HomeLibraryManager;
import homelibrarymanager.LoggedInUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Collection;
import models.CollectionList;

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

    private Collection c;
    HomeLibraryManager manager = new HomeLibraryManager();
    private CollectionList collection;
    @FXML
    private TableView<?> TV_AllMedia;
    @FXML
    private Button BT_AddToCollection;
    @FXML
    private Button BT_RemoveFromCollection;
    @FXML
    private TableView<?> TV_CollectionMedia;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        TF_Name.setText(c.getName());
        TF_Name.setEditable(false);
        TA_Description.setText(c.getDescription());

    }

    @FXML
    private void HandleBT_SaveCollectionClicked(MouseEvent event) throws Exception
    {

        //if it's a new collection
        if (!collection.existsInCollections(TF_Name.getText()))
        {
            collection.getAllCollections().add(c);
        } else
        {//if collection already exists
            c.setDescription(TA_Description.getText());
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
    }

    @FXML
    private void HandleBT_RemoveFromCollectionClicked(MouseEvent event)
    {
    }

}
