/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import cerification.beans.Certification;
import cerification.beans.InscriptionCertification;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.CertificationService;
import services.InscriptionCertificationService;

/**
 *
 * @author yassinesalihi
 */
public class InscriptionParCertification extends javax.swing.JInternalFrame {

    private CertificationService cs;
    private InscriptionCertificationService ics;
    private DefaultTableModel model;
    private List<Certification> lstCertification = new ArrayList<>();

    /**
     * Creates new form InscriptionParCertification
     */
    public InscriptionParCertification() {
        initComponents();
        ics = new InscriptionCertificationService();
        cs = new CertificationService();
        model = (DefaultTableModel) tableInscription.getModel(); // FIX : Mauvais modèle sur la mauvaise JTable
        loadCertifications();
        loadAllInscriptions();
    }

    public void loadCertifications() {
        comboCertification.addItem("Choisir une certification");
        for (Certification c : cs.findAll()) {
            lstCertification.add(c);
            comboCertification.addItem(c.getOrganisme());
        }
    }

    private void loadAllInscriptions() {
        model.setRowCount(0);
        for (InscriptionCertification ic : ics.findAll()) {
            model.addRow(new Object[]{
                ic.getCertification().getOrganisme(),
                ic.getEtudiant().getNom(),
                ic.getEtudiant().getPrenom(),
                ic.getEtudiant().getEmail()
            });
        }
    }

    // Charger les inscriptions par certification sélectionnée
    private void loadInscriptionsParCertification(Certification certification) {
        model.setRowCount(0);
        for (InscriptionCertification ic : ics.findByCertification(certification)) {
            model.addRow(new Object[]{
                ic.getCertification().getOrganisme(),
                ic.getEtudiant().getNom(),
                ic.getEtudiant().getPrenom(),
                ic.getEtudiant().getEmail()
            });
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
        comboCertification = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInscription = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(800, 570));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        comboCertification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCertificationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(comboCertification, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(comboCertification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        tableInscription.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Organisme de certification", "Nom du participant"
            }
        ));
        jScrollPane1.setViewportView(tableInscription);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboCertificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCertificationActionPerformed
        // TODO add your handling code here:
        int index = comboCertification.getSelectedIndex();
        if (index > 0) {
            Certification selectedCertification = lstCertification.get(index - 1);
            loadInscriptionsParCertification(selectedCertification);
        } else {
            loadAllInscriptions();
        }
    }//GEN-LAST:event_comboCertificationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCertification;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableInscription;
    // End of variables declaration//GEN-END:variables
}
