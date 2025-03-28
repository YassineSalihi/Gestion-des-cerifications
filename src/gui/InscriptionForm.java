/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import cerification.beans.Certification;
import cerification.beans.Etudiant;
import cerification.beans.InscriptionCertification;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CertificationService;
import services.EtudiantService;
import services.InscriptionCertificationService;

//import java.util.List;
/**
 *
 * @author yassinesalihi
 */
public class InscriptionForm extends javax.swing.JInternalFrame {

    private InscriptionCertificationService ics;
    private EtudiantService es;
    private CertificationService cs;
    private DefaultTableModel model;
    private List<Etudiant> lstEtudiant = new ArrayList<>(); // FIX : String problem.
    private List<Certification> lstCertification = new ArrayList<>();

    /**
     * Creates new form InscriptionForm
     */
    public InscriptionForm() {
        initComponents();
        /*listeEtudiant.setModel(new javax.swing.DefaultComboBoxModel<>()); // Liste vide
        listeCertification.setModel(new javax.swing.DefaultComboBoxModel<>()); // Liste vide*/
        ics = new InscriptionCertificationService();
        es = new EtudiantService();
        cs = new CertificationService();
        model = (DefaultTableModel) listeInscriptions.getModel();
        load();
        loadEtudiants();
        loadCertifications();
     
    }

       public void load() {
        model.setRowCount(0);
        for (InscriptionCertification ic : ics.findAll()) {
            model.addRow(new Object[]{
                ic.getCertification().getOrganisme(),
                ic.getEtudiant().getNom()
            });
        }
    }
    
    public void loadEtudiants() {
        listeEtudiant.addItem("Choisir un étudiant");
        for (Etudiant e : es.findAll()) {
            lstEtudiant.add(e);
            listeEtudiant.addItem(e.getNom() + " --- " + e.getPrenom()+ " --- " + e.getEmail()); // j'ai ajouté temporairerement;
        }
    }
    
    public void loadCertifications() {
        listeCertification.addItem("Choisir une certification");
        for (Certification c : cs.findAll()) {
            lstCertification.add(c);
            listeCertification.addItem(c.getOrganisme() + " | " + c.getNom()); // j'ai ajouté getOrganisme() temporairerement
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bnAdd = new javax.swing.JButton();
        listeCertification = new javax.swing.JComboBox<>();
        listeEtudiant = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeInscriptions = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Inscription");
        setMinimumSize(new java.awt.Dimension(600, 450));
        setPreferredSize(new java.awt.Dimension(600, 450));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Geston des inscriptions"));

        bnAdd.setText("S'inscrire");
        bnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAddActionPerformed(evt);
            }
        });

        listeEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeEtudiantActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Crystal Clear/22x22/actions/search.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Crystal Clear/22x22/actions/search.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(602, 602, 602)
                        .addComponent(bnAdd))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listeEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(296, 296, 296)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(listeCertification, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(250, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(listeCertification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(listeEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(131, 131, 131)
                .addComponent(bnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
        );

        listeInscriptions.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Organisme de certificats", "Nom d'étudiants"
            }
        ));
        jScrollPane1.setViewportView(listeInscriptions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listeEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeEtudiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listeEtudiantActionPerformed

    private void bnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddActionPerformed
        // TODO add your handling code here:

        //Etudiant selectedEtudiant = (Etudiant) listeEtudiant.getSelectedItem();
        Etudiant selectedEtudiant = lstEtudiant.get(listeEtudiant.getSelectedIndex() - 1);
        Certification selectedCertification = lstCertification.get(listeCertification.getSelectedIndex() - 1);
        //Certification selectedCertification = (Certification) listeCertification.getSelectedItem();

        if (selectedEtudiant != null && selectedCertification != null ) {
            if (ics.create(new InscriptionCertification(selectedCertification, selectedEtudiant))) {
                JOptionPane.showMessageDialog(this, "Inscription ajoutée avec succès");
                load();
            } else {
                JOptionPane.showMessageDialog(this, "Erreur lors de l'ajout");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
        }
    }//GEN-LAST:event_bnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listeCertification;
    private javax.swing.JComboBox<String> listeEtudiant;
    private javax.swing.JTable listeInscriptions;
    // End of variables declaration//GEN-END:variables
}
