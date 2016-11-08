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
public class Music extends Media
{

    private String artist;
    private String album;
    private int trackNumber;

    public Music(int newMediaID, String newTitle, MediaType newType, MediaFormat newFormat, int newUserID, String newLoanedTo, String newLoanedDate, String newLocation, String newGenre, int newRating, int newYear, String newArtist, String newAlbum, int newTrackNumber)
    {
        super(newMediaID, newTitle, newType, newFormat, newUserID, newLoanedTo, newLoanedDate, newLocation, newGenre, newRating, newYear);
        this.artist = newArtist;
        this.album = newAlbum;
        this.trackNumber = newTrackNumber;
        super.setCreator(this.artist);
    }

    @Override
    public String toString()
    {
        return "Type: " + super.getType() + "Title: " + super.getTitle() + "Artist: " + this.getArtist();
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public String getAlbum()
    {
        return album;
    }

    public void setAlbum(String album)
    {
        this.album = album;
    }

    public int getTrackNumber()
    {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber)
    {
        this.trackNumber = trackNumber;
    }

}
