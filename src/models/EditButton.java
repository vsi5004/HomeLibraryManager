/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Enums.MediaType;
import homelibrarymanager.HomeLibraryManager;
import homelibrarymanager.LoggedInUser;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class EditButton extends TableCell<Media, Boolean> {
    final Button cellButton = new Button("Edit");
    HomeLibraryManager manager = new HomeLibraryManager();
 
    public EditButton(){
 
        cellButton.setOnAction(new EventHandler<ActionEvent>(){
 
            @Override
            public void handle(ActionEvent t) {
                Media toEdit = (Media) EditButton.this.getTableView().getItems().get(EditButton.this.getIndex());
                Stage stage = (Stage) EditButton.this.getScene().getWindow();
                for (MediaType type : MediaType.values()) {
                if (Objects.equals(toEdit.getType().getValue(), type.getValue())) {
                    LoggedInUser.setLastPage("Main");
                    try
                    {
                        manager.gotoMediaScreen(stage, type, toEdit.getMediaID());
                    } catch (Exception ex)
                    {
                        Logger.getLogger(EditButton.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            }
        });
    }
 
    //Display button if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty) {
        super.updateItem(t, empty);
        if(!empty){
            setGraphic(cellButton);
        }
    }
}
