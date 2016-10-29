/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author Ivan
 */
public enum MediaType {
    LITERATURE("Literature"), MUSIC("Music"), MOVIE("Movie");
    private String value;
    
    private MediaType(String value){
        this.value = value;
    }
    
    public String getValue(){
        return this.value;
    }
}
