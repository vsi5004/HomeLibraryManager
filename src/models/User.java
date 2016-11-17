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
public class User {
    private int userID;
    private String Username;
    private String Password;
    private String SecurityQ;
    private String SecurityA;
    private String Type;
    
    public User(int newUserID, String newUserName, String newUserPassword, String newUserStatus, String newSQ, String newSA){
        this.userID = newUserID;
        this.Username = newUserName;
        this.Password = newUserPassword;
        this.SecurityQ = newSQ;
        this.SecurityA = newSA;
        this.Type = newUserStatus;
    }
    
    public String getUsername(){
        return Username;
    }
    
    public String getPassword(){
        return Password;
    }
    
    public String getType(){
        return Type;
    }

    public int getUserID()
    {
        return userID;
    }

    public String getSecurityQ()
    {
        return SecurityQ;
    }

    public String getSecurityA()
    {
        return SecurityA;
    }
}
