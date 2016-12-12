/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Ivan
 */
public class Collection implements Serializable
{
    private String ID;
    private String Name;
    private String Description;
    private ArrayList <Media> Items = new ArrayList <> ();
    
    public Collection(String name, String desc){
        this.ID = UUID.randomUUID().toString();
        this.Name = name;
        this.Description = desc;
    }
    
    public boolean inCollectionByTC(String title, String creator){
        for(Media m: Items){
            if(m.getTitle().equalsIgnoreCase(title) && m.getCreator().equalsIgnoreCase(creator)){
                return true;
            }
        }
        return false;
    }

    public String getID()
    {
        return ID;
    }

    public String getName()
    {
        return Name;
    }

    public String getDescription()
    {
        return Description;
    }

    public void setDescription(String Description)
    {
        this.Description = Description;
    }

    public ArrayList <Media> getItems()
    {
        return Items;
    }

    public void setItems(ArrayList <Media> Items)
    {
        this.Items = Items;
    }
}
