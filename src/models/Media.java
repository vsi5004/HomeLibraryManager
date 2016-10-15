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
public class Media {
    
    String mediaID;
    String title;
    private int year;
    private String genre;
    private String location;
    private int rating;
    private String loanedTo;
    private String loanedDate;
    private String type;
    
    public Media(String newTitle, String newType, String newLocation){
        this.title = newTitle;
        this.type = newType;
        this.location = newLocation;
    }
    
    public void setTitle(String newTitle){
        this.title = newTitle;
    }
    
    public String getTitle(){
        return this.title;
    }
    public void setType(String newType){
        this.type = newType;
    }
    
    public String getType(){
        return this.type;
    }
    
    public void setLocation(String newLocation){
        this.location = newLocation;
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public void setLoanedTo(String newLoanedTo){
        this.loanedTo = newLoanedTo;
    }
    
    public String getLoanedTo(){
        return this.loanedTo;
    }
    
    public void setLoanedDate(String newLoanedDate){
        this.loanedDate = newLoanedDate;
    }
    
    public String getLoanedDate(){
        return this.loanedDate;
    }
}
