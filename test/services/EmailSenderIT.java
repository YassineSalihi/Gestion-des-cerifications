/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package services;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yassinesalihi
 */
public class EmailSenderIT {

    public EmailSenderIT() {
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
     * Test of sendEmail method, of class EmailSender.
     */
    @Test
    public void testSendEmail() {
        /*System.out.println("sendEmail");
        String to = "";
        String subject = "";
        String messageText = "";
        EmailSender.sendEmail(to, subject, messageText);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
        System.out.println("sendEmail");*/
        String to = "y.salihi7457@uca.ac.ma"; 
        String subject = "Test Email";
        String messageText = "Ceci est un email de test JUnit";

        boolean result = EmailSender.sendEmail(to, subject, messageText);
        assertTrue("L'email doit être envoyé correctement", result);

    }

}
