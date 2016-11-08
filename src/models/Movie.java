package models;

import Enums.MediaFormat;
import Enums.MediaType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ivan
 */
public class Movie extends Media
{

    private String director;
    private String duration;

    public Movie(int newMediaID, String newTitle, MediaType newType, MediaFormat newFormat, int newUserID, String newLoanedTo, String newLoanedDate, String newLocation, String newGenre, int newRating, int newYear, String newDirector, String newDuration)
    {
        super(newMediaID, newTitle, newType, newFormat, newUserID, newLoanedTo, newLoanedDate, newLocation, newGenre, newRating, newYear);
        this.director = newDirector;
        this.duration = newDuration;
        super.setCreator(this.director);
    }

    public void setDirector(String newDirector)
    {
        this.director = newDirector;
    }

    public String getDirector()
    {
        return this.director;
    }

    public void setDuration(String newDuration)
    {
        this.duration = newDuration;
    }

    public String getDuration()
    {
        return this.duration;
    }

    @Override
    public String toString()
    {
        return "Type: " + super.getType() + "Title: " + super.getTitle() + "Director: " + this.director;
    }
}
