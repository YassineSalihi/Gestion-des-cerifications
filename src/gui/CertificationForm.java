/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package gui;

import cerification.beans.Certification;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.CertificationService;

/**
 *
 * @author yassinesalihi
 */
public class CertificationForm extends javax.swing.JInternalFrame {

    private CertificationService cs; // importation ajoutée
    private DefaultTableModel model;
    private static int id;

    /**
     * Creates new form CertificationForm
     */
    public CertificationForm() {
        initComponents();
        this.setTitle("Gestion des Certifications");
        cs = new CertificationService();
        model = (DefaultTableModel) listeCertifications.getModel();
        load();
    }

    public void load() {
        model.setRowCount(0);
        for (Certification c : cs.findAll()) {
            model.addRow(new Object[]{c.getId(), c.getNom(), c.getOrganisme(), c.getCout()});
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNom = new javax.swing.JTextField();
        txtOrganisme = new javax.swing.JTextField();
        txtCout = new javax.swing.JTextField();
        bnAdd = new javax.swing.JButton();
        bnDelete = new javax.swing.JButton();
        bnUpdate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeCertifications = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Gestion des certifications");
        setPreferredSize(new java.awt.Dimension(600, 450));

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gestion des certifications", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("C059", 0, 15), java.awt.Color.darkGray)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 200));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nom :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        jLabel2.setText("Organisme :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 95, -1, -1));

        jLabel3.setText("Cout :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 155, -1, -1));

        txtNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomActionPerformed(evt);
            }
        });
        jPanel1.add(txtNom, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 37, 135, -1));
        jPanel1.add(txtOrganisme, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 92, 135, -1));
        jPanel1.add(txtCout, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 152, 135, -1));

        bnAdd.setBackground(new java.awt.Color(0, 153, 102));
        bnAdd.setText("Ajouter");
        bnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnAddActionPerformed(evt);
            }
        });
        jPanel1.add(bnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 37, 99, -1));

        bnDelete.setBackground(new java.awt.Color(255, 51, 0));
        bnDelete.setText("Supprimer");
        bnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(bnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 92, -1, -1));

        bnUpdate.setBackground(new java.awt.Color(0, 102, 204));
        bnUpdate.setText("Modifier");
        bnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(bnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(468, 152, 99, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Crystal Clear/22x22/actions/agt_family.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 20, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Crystal Clear/22x22/actions/edit_user.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Crystal Clear/22x22/devices/usbpendrive_mount.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("List.selectionForeground"));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des certifications", javax.swing.border.TitledBorder.LEADING, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        listeCertifications.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Nom", "Organisme", "Cout"
            }
        ));
        listeCertifications.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listeCertificationsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listeCertifications);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnAddActionPerformed
        String nom = txtNom.getText().toString();
        String organisme = txtOrganisme.getText().toString();
        double cout = Double.parseDouble(txtCout.getText().toString());
        if (cs.create(new Certification(nom, organisme, cout))) {
            JOptionPane.showMessageDialog(this, "Certification Ajoutée! :)");
            load();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur de l'ajout du certificat. *_*");
        }

    }//GEN-LAST:event_bnAddActionPerformed

    // TODO : id 2 cannot be deleted
    //Cannot delete or update a parent row: a foreign key constraint fails (`CertificationDB`.`InscriptionCertification`, CONSTRAINT `InscriptionCertification_ibfk_1` FOREIGN KEY (`certification_id`) REFERENCES `Cer
    // TODO : renomer /* Fixed */
    private void bnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDeleteActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment supprimer cette certification ?");
        if (response == 0) {
            cs.delete(cs.findById(id));
            load();
        }
    }//GEN-LAST:event_bnDeleteActionPerformed

    private void listeCertificationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listeCertificationsMouseClicked
        id = Integer.parseInt(model.getValueAt(listeCertifications.getSelectedRow(), 0).toString());

        txtNom.setText(model.getValueAt(listeCertifications.getSelectedRow(), 1).toString());
        txtOrganisme.setText(model.getValueAt(listeCertifications.getSelectedRow(), 2).toString());
        txtCout.setText(model.getValueAt(listeCertifications.getSelectedRow(), 3).toString());

    }//GEN-LAST:event_listeCertificationsMouseClicked

    private void bnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnUpdateActionPerformed
        int response = JOptionPane.showConfirmDialog(this, "Voulez vous vraiment modifier cette certification?");
        if (response == 0) {
            String nom = txtNom.getText().toString();
            String organisme = txtOrganisme.getText().toString();
            double cout = Double.parseDouble(txtCout.getText().toString());
            if (cs.update(new Certification(id, nom, organisme, cout))) {
                JOptionPane.showMessageDialog(this, "Certification modifiée! ;)");
                load();
            } else {
                JOptionPane.showMessageDialog(this, "Erreur de la modification du certificat. *_*");
            }
        }

    }//GEN-LAST:event_bnUpdateActionPerformed

    private void txtNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnAdd;
    private javax.swing.JButton bnDelete;
    private javax.swing.JButton bnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeCertifications;
    private javax.swing.JTextField txtCout;
    private javax.swing.JTextField txtNom;
    private javax.swing.JTextField txtOrganisme;
    // End of variables declaration//GEN-END:variables
}
