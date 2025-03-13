/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cerification.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author yassinesalihi
 */
public class Connexion {
    private static Connexion instance = null;
    private Connection cn = null;
    
    private final String url = "jdbc:mysql://localhost:3306/CertificationDB";
    private final String login = "root";
    private final String password = "ph/axo>vJe;789"; //FIXED : mon mot de passe est ajouté.
    
    // Constructeur privé pour empêcher l'instanciation directe
    private Connexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introuvable");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
     // Méthode d'accès à l'instance unique (avec synchronisation pour éviter les problèmes de concurrence)
    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }
    
     // Méthode pour obtenir la connexion
    public Connection getCn() {
        return cn;
    }
    
}
