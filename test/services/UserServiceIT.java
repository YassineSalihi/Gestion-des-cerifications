/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package services;

import cerification.beans.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/* ***************************************
En utilisant ce test inseré par JUnit 
4 test passed, 1 test caused error
peut etre le cas de null
******************************************/

/**
 *
 * @author yassinesalihi
 */
public class UserServiceIT {
    
    public UserServiceIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addUser method, of class UserService.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = null;
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.addUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of findUserByLogin method, of class UserService.
     */
    @Test
    public void testFindUserByLogin() {
        System.out.println("findUserByLogin");
        String login = "";
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.findUserByLogin(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of authenticate method, of class UserService.
     */
    @Test
    public void testAuthenticate() {
        System.out.println("authenticate");
        String login = "";
        String password = "";
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.authenticate(login, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of userExists method, of class UserService.
     */
    @Test
    public void testUserExists() {
        System.out.println("userExists");
        String login = "";
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.userExists(login);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of updatePassword method, of class UserService.
     */
    @Test
    public void testUpdatePassword() {
        System.out.println("updatePassword");
        String login = "";
        String newPassword = "";
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.updatePassword(login, newPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
