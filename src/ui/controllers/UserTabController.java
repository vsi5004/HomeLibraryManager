/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.controllers;


import dbClasses.AppUser;
import dbClasses.AppUserJpaController;
import java.net.URL;
import java.util.List;
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
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import models.User;
import ui.buttons.DeleteMediaButton;
import ui.buttons.DeleteUserButton;
import ui.buttons.EditMediaButton;
import ui.buttons.EditUserButton;

/**
 * FXML Controller class
 *
 * @author Ivan
 */
public class UserTabController implements Initializable
{

    @FXML
    private TableView<User> TV_Users;
    @FXML
    private TableColumn<User, String> TC_Username;
    @FXML
    private TableColumn<User, String> TC_Type;
    @FXML
    private TableColumn<User, Boolean> TC_Edit;
    @FXML
    private TableColumn<User, Boolean> TC_Delete;

    private ObservableList<User> userData = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        TC_Username.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
        TC_Type.setCellValueFactory(new PropertyValueFactory<User, String>("type"));

        syncUserList();
        TV_Users.setItems(userData);

        TC_Edit.setSortable(false);
        TC_Delete.setSortable(false);
        addButtonColumn(TC_Edit, true);
        addButtonColumn(TC_Delete, false);
    }

    private void addButtonColumn(TableColumn<User, Boolean> TC, Boolean edit)
    {
        TC.setCellValueFactory(
                new Callback<TableColumn.CellDataFeatures<User, Boolean>, ObservableValue<Boolean>>()
        {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<User, Boolean> p)
            {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        TC.setCellFactory(new Callback<TableColumn<User, Boolean>, TableCell<User, Boolean>>()
        {
            @Override
            public TableCell<User, Boolean> call(TableColumn<User, Boolean> p)
            {
                if (edit)
                {
                    return new EditUserButton();
                } else
                {
                    return new DeleteUserButton(userData);
                }
            }

        });
    }

    private void syncUserList()
    {
        userData.clear();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HomeLibraryManagerPU");
        AppUserJpaController jpaUser = new AppUserJpaController(emf);
        List<AppUser> Users = jpaUser.findAppUserEntities();

        for (AppUser u : Users)
        {
            userData.add(new User(u.getUserId(),u.getUsername(),u.getUserPassword(),u.getUserType(),u.getSecurityQuestion(),u.getSecurityAnswer()));
        }
    }

}
