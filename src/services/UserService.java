/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import cerification.beans.User;
import cerification.connexion.Connexion;
import cerification.dao.IUserDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author yassinesalihi
 */
public class UserService implements IUserDao {

   private Connexion connexion;

    public UserService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean addUser(User user) {
        String req = "INSERT INTO user (login, password) VALUES (?, SHA1(?))";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public User findUserByLogin(String login) {
        String req = "SELECT * FROM user WHERE login = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("login"), rs.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean authenticate(String login, String password) {
        String req = "SELECT * FROM user WHERE login = ? AND password = SHA1(?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean userExists(String login) {
        String req = "SELECT * FROM user WHERE login = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Retourne true si l'utilisateur existe, sinon false
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }   

    @Override
    public boolean updatePassword(String login, String newPassword) {
        String req = "UPDATE user SET password = SHA1(?) WHERE login = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, newPassword);
            ps.setString(2, login);
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0; // Retourne true si la mise à jour a réussi, sinon false
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}