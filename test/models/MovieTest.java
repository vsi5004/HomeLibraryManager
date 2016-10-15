/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import junit.framework.TestCase;

/**
 *
 * @author Ivan
 */
public class MovieTest extends TestCase {
    
    public MovieTest(String testName) {
        super(testName);
    }

    /**
     * Test of setDirector method, of class Movie.
     */
    public void testSetDirector() {
        System.out.println("setDirector");
        String newDirector = "";
        Movie instance = null;
        instance.setDirector(newDirector);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDirector method, of class Movie.
     */
    public void testGetDirector() {
        System.out.println("getDirector");
        Movie instance = null;
        String expResult = "";
        String result = instance.getDirector();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDuration method, of class Movie.
     */
    public void testSetDuration() {
        System.out.println("setDuration");
        String newDuration = "";
        Movie instance = null;
        instance.setDuration(newDuration);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDuration method, of class Movie.
     */
    public void testGetDuration() {
        System.out.println("getDuration");
        Movie instance = null;
        String expResult = "";
        String result = instance.getDuration();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Movie.
     */
    public void testToString() {
        System.out.println("toString");
        Movie instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
