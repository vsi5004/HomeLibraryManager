package models;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ivan
 */
public class Movie extends Media{
    
    private String director;
    private String duration;

    public Movie(String newTitle, String newType, String newLocation, String newDirector, String newDuration) {
        super(newTitle, newType, newLocation);
        this.director = newDirector;
        this.duration = newDuration;
    }
    
    public void setDirector(String newDirector){
        this.director = newDirector;
    }
    
    public String getDirector(){
        return this.director;
    }
    
    public void setDuration(String newDuration){
        this.duration = newDuration;
    }
    
    public String getDuration(){
        return this.duration;
    }
    
    @Override
    public String toString(){
        return "ID: " + this.mediaID + "Title: "+ this.title + "Director: "+ this.director;
    }
}
