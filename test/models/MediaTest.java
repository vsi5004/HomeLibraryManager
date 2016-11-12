/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import Enums.MediaType;
import junit.framework.TestCase;

/**
 *
 * @author Ivan
 */
public class MediaTest extends TestCase
{

    public MediaTest(String testName)
    {
        super(testName);
    }

    /**
     * Test of setTitle method, of class Media.
     */
    public void testSetTitle()
    {
        System.out.println("setTitle");
        String newTitle = "";
        Media instance = null;
        instance.setTitle(newTitle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Media.
     */
    public void testGetTitle()
    {
        System.out.println("getTitle");
        Media instance = null;
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Media.
     */
    public void testGetType()
    {
        System.out.println("getType");
        Media instance = null;
        MediaType expResult = MediaType.Literature;
        MediaType result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocation method, of class Media.
     */
    public void testSetLocation()
    {
        System.out.println("setLocation");
        String newLocation = "";
        Media instance = null;
        instance.setLocation(newLocation);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocation method, of class Media.
     */
    public void testGetLocation()
    {
        System.out.println("getLocation");
        Media instance = null;
        String expResult = "";
        String result = instance.getLocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoanedTo method, of class Media.
     */
    public void testSetLoanedTo()
    {
        System.out.println("setLoanedTo");
        String newLoanedTo = "";
        Media instance = null;
        instance.setLoanedTo(newLoanedTo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoanedTo method, of class Media.
     */
    public void testGetLoanedTo()
    {
        System.out.println("getLoanedTo");
        Media instance = null;
        String expResult = "";
        String result = instance.getLoanedTo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoanedDate method, of class Media.
     */
    public void testSetLoanedDate()
    {
        System.out.println("setLoanedDate");
        String newLoanedDate = "";
        Media instance = null;
        instance.setLoanedDate(newLoanedDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoanedDate method, of class Media.
     */
    public void testGetLoanedDate()
    {
        System.out.println("getLoanedDate");
        Media instance = null;
        String expResult = "";
        String result = instance.getLoanedDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
