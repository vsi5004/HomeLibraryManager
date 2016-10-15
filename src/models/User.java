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
    private String userID;
    private String userName;
    private String userPassword;
    private String userStatus;
    
    public User(String newUserID, String newUserName, String newUserPassword, String newUserStatus){
        this.userID = newUserID;
        this.userName = newUserName;
        this.userPassword = newUserPassword;
        this.userStatus = newUserStatus;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public void setUserName(String newUserName){
        userName = newUserName;
    }
    
    public String getuserID(){
        return userID;
    }
    
    public String getUserPassword(){
        return userPassword;
    }
    
    public void setUserPassword(String newPassword){
        userPassword = newPassword;
    }
    
    public String getUserStatus(){
        return userStatus;
    }
    
    public void setUserStatus(String newStatus){
        userStatus = newStatus;
    }
}
