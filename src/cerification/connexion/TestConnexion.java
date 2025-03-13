/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cerification.connexion;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnexion { 
/*
    * Juste un simple test pour tester la connexion, grâce à ce
    * Test j'ai fixée l'accée à la connexion
    */
    public static void main(String[] args) {
        Connexion connexion = Connexion.getInstance();
        Connection cn = connexion.getCn();

        if (cn != null) {
            System.out.println("Connexion établie avec succès !");
        } else {
            System.out.println("Échec de la connexion."); 
        }

        // Optionally, try a simple query
        try {
            if (cn != null && !cn.isClosed()) {
                System.out.println("La connexion est active.");
            } else {
                System.out.println("La connexion est fermée.");
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la vérification de la connexion : " + e.getMessage());
        }
    }
}
