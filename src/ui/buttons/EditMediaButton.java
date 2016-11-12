/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.buttons;

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
import models.Media;

/**
 *
 * @author Ivan
 */
public class EditMediaButton extends TableCell<Media, Boolean> {
    final Button cellButton = new Button("Edit");
    HomeLibraryManager manager = new HomeLibraryManager();
 
    public EditMediaButton(){
 
        cellButton.setOnAction(new EventHandler<ActionEvent>(){
 
            @Override
            public void handle(ActionEvent t) {
                Media toEdit = (Media) EditMediaButton.this.getTableView().getItems().get(EditMediaButton.this.getIndex());
                Stage stage = (Stage) EditMediaButton.this.getScene().getWindow();
                for (MediaType type : MediaType.values()) {
                if (Objects.equals(toEdit.getType().getValue(), type.getValue())) {
                    LoggedInUser.setLastPage("Main");
                    try
                    {
                        manager.gotoMediaScreen(stage, type, toEdit.getMediaID());
                    } catch (Exception ex)
                    {
                        Logger.getLogger(EditMediaButton.class.getName()).log(Level.SEVERE, null, ex);
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
