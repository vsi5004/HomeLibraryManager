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
    BOOK("Book"), MAGAZINE("Magazine"), DOCUMENT("Document"), DVD("DVD"), BLURAY("Blu-ray"), VHS("VHS"), CD("CD"), TAPE("Tape"), RECORD("Record");
    private String value;
    
    private MediaFormat(String value){
        this.value = value;
    }
    
    public String getValue(){
        return this.value;
    }
}
