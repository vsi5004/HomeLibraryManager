/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homelibrarymanager;

/**
 * This singleton stores the user info for the logged in user
 * @author Ivan Iakimenko
 */
public class LoggedInUser {

   private static LoggedInUser instance = null;
   private static String UserName;
   private static int UserID;
   private static String UserType;
   private static String LastPage;
   
   private LoggedInUser() {
      // Exists only to defeat instantiation.
   }

   public static LoggedInUser getInstance() {
      if(instance == null) {
         instance = new LoggedInUser();
      }
      return instance;
   }
   
   public Object clone() throws CloneNotSupportedException
  {
    throw new CloneNotSupportedException(); 
    // that'll teach 'em
  }
   
   public static void setInfo(int userID, String userName, String userType){
       UserID = userID;
       UserName = userName;
       UserType = userType;
   }
   
   public static void setLastPage(String CurrentPage){
       LastPage = CurrentPage;
   }
   
   public static String getLastPage(){
       return LastPage;
   }
   
   public static String getUserName(){
       return UserName;
   }
}