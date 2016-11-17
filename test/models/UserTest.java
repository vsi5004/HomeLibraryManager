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
public class UserTest extends TestCase {
    
    public UserTest(String testName) {
        super(testName);
    }

    /**
     * Test of getUserName method, of class User.
     */
    public void testGetUserName() {
        System.out.println("getUserName");
        User instance = null;
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserName method, of class User.
     */
    public void testSetUserName() {
        System.out.println("setUserName");
        String newUserName = "";
        User instance = null;
        instance.setUsername(newUserName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getuserID method, of class User.
     */
    public void testGetuserID() {
        System.out.println("getuserID");
        User instance = null;
        String expResult = "";
        String result = instance.getuserID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserPassword method, of class User.
     */
    public void testGetUserPassword() {
        System.out.println("getUserPassword");
        User instance = null;
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserPassword method, of class User.
     */
    public void testSetUserPassword() {
        System.out.println("setUserPassword");
        String newPassword = "";
        User instance = null;
        instance.setPassword(newPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserStatus method, of class User.
     */
    public void testGetUserStatus() {
        System.out.println("getUserStatus");
        User instance = null;
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserStatus method, of class User.
     */
    public void testSetUserStatus() {
        System.out.println("setUserStatus");
        String newStatus = "";
        User instance = null;
        instance.setType(newStatus);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
