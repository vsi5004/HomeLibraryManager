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
public class Literature extends Media
{

    private String author;
    private String volume;
    private String publisher;
    private String version;
    private String edition;

    public Literature(int newMediaID, String newTitle, MediaType newType, MediaFormat newFormat, int newUserID, String newLoanedTo, String newLoanedDate, String newLocation, String newGenre, int newRating, int newYear, String newAuthor, String newVolume, String newPublisher, String newVersion, String newEdition)
    {
        super(newMediaID, newTitle, newType, newFormat, newUserID, newLoanedTo, newLoanedDate, newLocation, newGenre, newRating, newYear);
        this.author = newAuthor;
        this.volume = newVolume;
        this.publisher = newPublisher;
        this.version = newVersion;
        this.edition = newEdition;
        super.setCreator(this.author);
    }

    public String getAuthor()
    {
        return this.author;
    }
    
    public String getVolume(){
        return this.volume;
    }

    @Override
    public String toString()
    {
        return "Type: " + super.getType() + "Title: " + super.getTitle() + "Author: " + this.getAuthor();
    }

    public String getPublisher()
    {
        return this.publisher;
    }

    public String getVersion()
    {
        return this.version;
    }

    public String getEdition()
    {
        return this.edition;
    }
}
