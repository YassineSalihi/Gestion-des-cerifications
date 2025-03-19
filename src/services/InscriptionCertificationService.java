/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import cerification.beans.Certification;
import cerification.beans.Etudiant;
import cerification.beans.InscriptionCertification;
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
public class InscriptionCertificationService implements IDao<InscriptionCertification> {

    private Connexion connexion;
    private CertificationService cs;
    private EtudiantService es;

    public InscriptionCertificationService() {
        connexion = Connexion.getInstance();
        cs = new CertificationService();
        es = new EtudiantService();
    }

    @Override
    public boolean create(InscriptionCertification o) {
        String req = "INSERT INTO InscriptionCertification (certification_id, etudiant_id) VALUES (?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getCertification().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(InscriptionCertification o) {
        String req = "DELETE FROM InscriptionCertification WHERE certification_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getCertification().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(InscriptionCertification o) {
        String req = "UPDATE InscriptionCertification SET certification_id = ? WHERE etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getCertification().getId());
            ps.setInt(2, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la mise à jour de l'inscription : " + ex.getMessage());
        }
        return false;
    }

    @Override
    public InscriptionCertification findById(int id) {
        // Cette méthode n'est pas applicable car InscriptionCertification n'a pas d'ID unique.
        return null;
    }

    @Override
    public List<InscriptionCertification> findAll() {
        List<InscriptionCertification> inscriptions = new ArrayList<>();
        String req = "SELECT * FROM InscriptionCertification";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Certification certification = cs.findById(rs.getInt("certification_id"));
                Etudiant etudiant = es.findById(rs.getInt("etudiant_id"));
                inscriptions.add(new InscriptionCertification(certification, etudiant));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return inscriptions;
    }

    public Iterable<InscriptionCertification> findByCertification(Certification certification) {
        List<InscriptionCertification> result = new ArrayList<>();
        for (InscriptionCertification ic : findAll()) {
            if (ic.getCertification().getId() == certification.getId()) { // Comparaison par ID
                result.add(ic);
            }
        }
        return result;
    }

}
