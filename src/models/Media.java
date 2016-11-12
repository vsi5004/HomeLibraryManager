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
public class Media
{

    private int mediaID;
    private int userID;
    private String title;
    private int year;
    private String genre;
    private String location;
    private int rating = 0;
    private String loanedTo;
    private String loanedDate;
    private MediaType type;
    private MediaFormat format;
    private String creator;

    public Media(int newMediaID, String newTitle, MediaType newType, MediaFormat newFormat, int newUserID)
    {
        this.mediaID = newMediaID;
        this.title = newTitle;
        this.type = newType;
        this.userID = newUserID;
        this.format = newFormat;
    }

    public void setYear(int newYear)
    {
        this.year = newYear;
    }
    
    public String getGenre(){
        return this.genre;
    }
    
    public void setGenre(String newGenre){
        this.genre = newGenre;
    }
    
    public int getYear(){
        return this.year;
    }

    public void setFormat(MediaFormat newFormat)
    {
        this.format = newFormat;
    }

    public void setCreator(String newCreator)
    {
        this.creator = newCreator;
    }

    public String getCreator()
    {
        return this.creator;
    }

    public int getMediaID()
    {
        return this.mediaID;
    }

    public MediaFormat getFormat()
    {
        return this.format;
    }

    public void setTitle(String newTitle)
    {
        this.title = newTitle;
    }

    public String getTitle()
    {
        return this.title;
    }

    public MediaType getType()
    {
        return this.type;
    }

    public void setLocation(String newLocation)
    {
        this.location = newLocation;
    }

    public String getLocation()
    {
        return this.location;
    }

    public void setLoanedTo(String newLoanedTo)
    {
        this.loanedTo = newLoanedTo;
    }

    public String getLoanedTo()
    {
        return this.loanedTo;
    }

    public void setLoanedDate(String newLoanedDate)
    {
        this.loanedDate = newLoanedDate;
    }

    public String getLoanedDate()
    {
        return this.loanedDate;
    }

    public int getRating()
    {
        return rating;
    }

    public void setRating(int rating)
    {
        this.rating = rating;
    }
}
