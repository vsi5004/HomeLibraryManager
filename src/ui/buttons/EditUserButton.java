/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.buttons;

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
import models.User;

/**
 *
 * @author Ivan
 */
public class EditUserButton extends TableCell<User, Boolean>
{

    final Button cellButton = new Button("Edit");
    HomeLibraryManager manager = new HomeLibraryManager();

    public EditUserButton()
    {

        cellButton.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent t)
            {
                User toEdit = (User) EditUserButton.this.getTableView().getItems().get(EditUserButton.this.getIndex());
                Stage stage = (Stage) EditUserButton.this.getScene().getWindow();
                LoggedInUser.setLastPage("Main");
                try
                {
                    manager.gotoUserScreen(stage, toEdit.getUserID());
                } catch (Exception ex)
                {
                    Logger.getLogger(EditUserButton.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    //Display button if the row is not empty
    @Override
    protected void updateItem(Boolean t, boolean empty)
    {
        super.updateItem(t, empty);
        if (!empty)
        {
            setGraphic(cellButton);
        } else
        {
            setGraphic(null);
        }
    }
}
