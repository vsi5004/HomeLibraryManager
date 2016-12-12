/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.buttons;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import models.Collection;
import models.CollectionList;


/**
 *
 * @author Ivan
 */
public class DeleteCollectionButton extends TableCell<Collection, Boolean>
{

    final Button cellButton = new Button("Delete");
    private CollectionList collection;

    public DeleteCollectionButton(ObservableList<Collection> collectionData)
    {

        cellButton.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent t)
            {
                Collection toDelete = (Collection) DeleteCollectionButton.this.getTableView().getItems().get(DeleteCollectionButton.this.getIndex());
                collectionData.remove(toDelete);
                try
                {
                    collection = new CollectionList();
                    collection.removeByName(toDelete.getName());
                } catch (IOException ex)
                {
                    Logger.getLogger(DeleteCollectionButton.class.getName()).log(Level.SEVERE, null, ex);
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
