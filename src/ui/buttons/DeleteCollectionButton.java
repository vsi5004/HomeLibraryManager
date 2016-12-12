/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.buttons;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import models.Collection;


/**
 *
 * @author Ivan
 */
public class DeleteCollectionButton extends TableCell<Collection, Boolean>
{

    final Button cellButton = new Button("Delete");

    public DeleteCollectionButton(ObservableList<Collection> collectionData)
    {

        cellButton.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent t)
            {
                Collection toDelete = (Collection) DeleteCollectionButton.this.getTableView().getItems().get(DeleteCollectionButton.this.getIndex());
                collectionData.remove(toDelete);

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
