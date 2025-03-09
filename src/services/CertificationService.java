/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import cerification.beans.Certification;
import cerification.connexion.Connexion;
import cerification.dao.IDao;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author yassinesalihi
 */
public class CertificationService implements IDao<Certification>{
    
    private Connexion connexion;

    @Override
    public boolean create(Certification o) {
         String req = "INSERT INTO Certification ( id, nom, organisme, cout) VALUES (null, ?, ?, ?)";
         try{
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getOrganisme());
            ps.setDouble(3, o.getCout());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
        }

        @Override
        public boolean delete(Certification o) {
         String req = "DELETE FROM Certification WHERE id = ?";
         try{
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
        }

        @Override
        public boolean update(Certification o) {
            String req = "UPDATE Certification set nom = ?, organisme = ?, cout = ? WHERE id = ?";
            try {
        
                PreparedStatement ps = connexion.getCn().prepareStatement(req);
                ps.setString(1, o.getNom());
                ps.setString(2, o.getOrganisme());
                ps.setDouble(3, o.getCout());
                ps.setInt(4, o.getId());
                ps.executeUpdate();
                return true;
                
              }catch (SQLException ex) {
                System.out.println(ex.getMessage());
              }
            return false;
        }

        @Override
        public Certification findById(int id) {
             String req = "SELECT * FROM Certification WHERE id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Certification(rs.getInt("id"), rs.getString("nom"), rs.getString("organisme"), rs.getDouble("cout"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
        }

        @Override
        public List<Certification> findAll() {
            List<Certification> certifications = new ArrayList<>();
        String req = "SELECT * FROM Certification";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                certifications.add(new Certification(rs.getInt("id"), rs.getString("nom"), rs.getString("organisme"), rs.getDouble("cout")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return certifications;
        }
         
 }



