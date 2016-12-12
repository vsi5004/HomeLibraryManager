/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import models.Collection;
import models.CollectionList;
import ui.buttons.DeleteCollectionButton;
import ui.buttons.EditCollectionButton;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class CollectionTabController implements Initializable
{

    @FXML
    private TableView<Collection> TV_Collections;
    @FXML
    private TableColumn<Collection, String> TC_Name;
    @FXML
    private TableColumn<Collection, String> TC_Description;
    @FXML
    private TableColumn<Collection, Boolean> TC_Edit;
    @FXML
    private TableColumn<Collection, Boolean> TC_Delete;
    
    private ObservableList<Collection> collectionData = FXCollections.observableArrayList();
    
    CollectionList collections;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        TC_Name.setCellValueFactory(new PropertyValueFactory<Collection, String>("name"));
        TC_Description.setCellValueFactory(new PropertyValueFactory<Collection, String>("description"));
        
        syncCollectionList();
        TV_Collections.setItems(collectionData);

        TC_Edit.setSortable(false);
        TC_Delete.setSortable(false);
        
        addButtonColumn(TC_Edit, true);
        addButtonColumn(TC_Delete, false);
    }    
    
    private void addButtonColumn(TableColumn<Collection, Boolean> TC, Boolean edit)
    {
        TC.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<Collection, Boolean>, ObservableValue<Boolean>>()
        {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Collection, Boolean> p)
            {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        TC.setCellFactory(new Callback<TableColumn<Collection, Boolean>, TableCell<Collection, Boolean>>()
        {
            @Override
            public TableCell<Collection, Boolean> call(TableColumn<Collection, Boolean> p)
            {
                if (edit)
                {
                    return new EditCollectionButton();
                } else
                {
                    return new DeleteCollectionButton(collectionData);
                }
            }

        });
    }


    private void syncCollectionList()
    {
        try
        {
            collections = new CollectionList();
            for(Collection c : collections.getAllCollections()){
                collectionData.add(c);
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
    
}
