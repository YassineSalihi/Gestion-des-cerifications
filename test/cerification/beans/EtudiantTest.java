
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package cerification.beans;

import org.junit.Test;
import static org.junit.Assert.*;

public class EtudiantTest {
    
    @Test
    public void testGetId() {
        Etudiant instance = new Etudiant(1, "John", "Doe", "john.doe@example.com");
        int expectedId = 1;
        int result = instance.getId();
        assertEquals(expectedId, result);
    }

    @Test
    public void testSetId() {
        Etudiant instance = new Etudiant("John", "Doe", "john.doe@example.com");
        instance.setId(5);
        assertEquals(5, instance.getId());
    }

    @Test
    public void testGetNom() {
        Etudiant instance = new Etudiant(1, "John", "Doe", "john.doe@example.com");
        String expectedName = "John";
        assertEquals(expectedName, instance.getNom());
    }

    @Test
    public void testSetNom() {
        Etudiant instance = new Etudiant(1, "John", "Doe", "john.doe@example.com");
        instance.setNom("Michael");
        assertEquals("Michael", instance.getNom());
    }

    @Test
    public void testGetPrenom() {
        Etudiant instance = new Etudiant(1, "John", "Doe", "john.doe@example.com");
        assertEquals("Doe", instance.getPrenom());
    }

    @Test
    public void testSetPrenom() {
        Etudiant instance = new Etudiant(1, "John", "Doe", "john.doe@example.com");
        instance.setPrenom("Smith");
        assertEquals("Smith", instance.getPrenom());
    }

    @Test
    public void testGetEmail() {
        Etudiant instance = new Etudiant(1, "John", "Doe", "john.doe@example.com");
        assertEquals("john.doe@example.com", instance.getEmail());
    }

    @Test
    public void testSetEmail() {
        Etudiant instance = new Etudiant(1, "John", "Doe", "john.doe@example.com");
        instance.setEmail("michael.smith@example.com");
        assertEquals("michael.smith@example.com", instance.getEmail());
    }
}

