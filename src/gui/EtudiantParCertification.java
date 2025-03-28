/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import cerification.beans.Certification;
import cerification.beans.Etudiant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.CertificationService;
import services.EtudiantService;

/**
 *
 * @author yassinesalihi
 */
public class EtudiantParCertification extends javax.swing.JInternalFrame {

    private CertificationService cs;
    private EtudiantService es;
    private DefaultTableModel model;
    private List<Certification> lstCertification = new ArrayList<>(); 

    /**
     * Creates new form EtudiantParCertification
     */
    public EtudiantParCertification() {
        initComponents();
        cs = new CertificationService();
        es = new EtudiantService();
        model = (DefaultTableModel) listeEtudiant.getModel();
        loadCertifications();
        load();
    }
    
    public void loadCertifications(){
        listeCertification.addItem("Choisir une certification");
        for (Certification c : cs.findAll()) {
            lstCertification.add(c);
            listeCertification.addItem(c.getOrganisme()); // j'ai ajouté getOrganisme() temporairerement
        }
        
    }

    public void load() {
        model.setRowCount(0);
        for (Etudiant e : es.findAll()) {
            model.addRow(new Object[]{
                e.getId(),
                e.getNom(),
                e.getPrenom(),
                e.getEmail()
            });
        }
    }
    
     private void loadEtudiantsParCertification(Certification certification) {
        model.setRowCount(0);
        for (Etudiant e : es.findByCertification(certification)) {
            model.addRow(new Object[]{
                e.getId(),
                e.getNom(),
                e.getPrenom(),
                e.getEmail()
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
        listeCertification = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeEtudiant = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Recherche d'étudiant par certification");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));

        listeCertification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeCertificationActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Crystal Clear/22x22/actions/find.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(listeCertification, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(460, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(listeCertification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(152, 152, 152))
        );

        listeEtudiant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom", "Prenom", "E-mail"
            }
        ));
        jScrollPane1.setViewportView(listeEtudiant);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listeCertificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeCertificationActionPerformed
        // TODO add your handling code here:
        int index = listeCertification.getSelectedIndex();
        if (index > 0) {
            Certification selectedCertification = lstCertification.get(index - 1);
            loadEtudiantsParCertification(selectedCertification);
        } else {
            load();
        }
    }//GEN-LAST:event_listeCertificationActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> listeCertification;
    private javax.swing.JTable listeEtudiant;
    // End of variables declaration//GEN-END:variables
}
