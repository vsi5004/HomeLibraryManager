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
public enum MediaFormat {
    Book("Book"), Magazine("Magazine"), Document("Document"), DVD("DVD"), BLURAY("BLURAY"), VHS("VHS"), CD("CD"), Tape("Tape"), Record("Record"), Other("Other");
    private String value;
    
    private MediaFormat(String value){
        this.value = value;
    }
    
    public String getValue(){
        return this.value;
    }
}
