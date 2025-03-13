
import cerification.beans.Certification;
import cerification.beans.Etudiant;
import cerification.beans.InscriptionCertification;
import java.util.List;
import services.CertificationService;
import services.EtudiantService;
import services.InscriptionCertificationService;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yassinesalihi
 */
public class TestCertificationFinal {
    
     public static void main(String[] args) {
        CertificationService cs = new CertificationService();
        EtudiantService es = new EtudiantService();
        InscriptionCertificationService ics = new InscriptionCertificationService();

        System.out.println("===== Création des Certifications =====");
        cs.create(new Certification("Java OCP", "Oracle", 300.0));
        cs.create(new Certification("PMP", "PMI", 500.0));

        Certification certification = cs.findById(1);
        if (certification != null) {
            System.out.println("Certification trouvée : " + certification.getNom());
        }

        certification.setCout(350.0);
        cs.update(certification);
        System.out.println("Coût de la certification mis à jour : " + cs.findById(1).getCout());

        System.out.println("\n===== Liste des Certifications =====");
        List<Certification> certifications = cs.findAll();
        for (Certification c : certifications) {
            System.out.println(c.getNom() + " - " + c.getOrganisme() + " - " + c.getCout());
        }

        System.out.println("\n===== Création des Étudiants =====");
        es.create(new Etudiant("Linus", "Torvalds", "unix@linux.open"));
        es.create(new Etudiant("Terry", "Davis", "templeos@real.com"));

        Etudiant etudiant = es.findById(1);
        if (etudiant != null) {
            System.out.println("Étudiant trouvé : " + etudiant.getNom() + " " + etudiant.getPrenom());
        }

        etudiant.setEmail("unix-like.new@example.com");
        es.update(etudiant);
        System.out.println("Email de l'étudiant mis à jour : " + es.findById(1).getEmail());

        System.out.println("\n===== Liste des Étudiants =====");
        List<Etudiant> etudiants = es.findAll();
        for (Etudiant e : etudiants) {
            System.out.println(e.getNom() + " " + e.getPrenom() + " - " + e.getEmail());
        }

        System.out.println("\n===== Inscription des Étudiants aux Certifications =====");
        ics.create(new InscriptionCertification(cs.findById(1), es.findById(1)));
        ics.create(new InscriptionCertification(cs.findById(2), es.findById(2)));

        System.out.println("\n===== Liste des Inscriptions =====");
        List<InscriptionCertification> inscriptions = ics.findAll();
        for (InscriptionCertification ic : inscriptions) {
            System.out.println("Inscription : " + ic.getEtudiant().getNom() + " est inscrit à " + ic.getCertification().getNom());
        }

        System.out.println("\n===== Mise à jour d'une inscription =====");
        InscriptionCertification inscriptionToUpdate = ics.findAll().get(0);
        inscriptionToUpdate.setCertification(cs.findById(2)); // Changer la certification
        ics.update(inscriptionToUpdate);
        System.out.println("Mise à jour : " + inscriptionToUpdate.getEtudiant().getNom() + " est maintenant inscrit à " + inscriptionToUpdate.getCertification().getNom());

        System.out.println("\n===== Suppression d'une inscription =====");
        InscriptionCertification inscriptionToDelete = ics.findAll().get(0);
        ics.delete(inscriptionToDelete);
        System.out.println("Inscription supprimée : " + inscriptionToDelete.getEtudiant().getNom() + " - " + inscriptionToDelete.getCertification().getNom());

        System.out.println("\n===== Inscriptions restantes =====");
        for (InscriptionCertification ic : ics.findAll()) {
            System.out.println("Inscription : " + ic.getEtudiant().getNom() + " est inscrit à " + ic.getCertification().getNom());
        }
    }
}
