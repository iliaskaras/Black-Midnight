/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.ui_forTests;

import blackMidnight.controller.IStoreChooserForReservationController;
import blackMidnight.controller.StoreChooserForReservationController;
import blackMidnight.controller_forTests.StoreChooserForReservationController_forTests;
import blackMidnight.model.Store;
import blackMidnight.model_forTests.Store_Test;
import blackMidnight.ui.CreateReservationForm;
import blackMidnight.ui.MainFormUser;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ilias
 */
public class StoreChooserForReservationForm_forTests extends javax.swing.JFrame {

    /**
     * Creates new form StoreChooserForReservationForm_forTests
     */
    public StoreChooserForReservationForm_forTests() throws Exception{
        initComponents();
        Update_Table();
    }
    
     public StoreChooserForReservationForm_forTests(String username) throws Exception {
        initComponents();
        usernameText.setText(username);
        Update_Table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openHoursText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Stores = new javax.swing.JTable();
        storeNamelbl = new javax.swing.JLabel();
        CancelReservation = new javax.swing.JButton();
        storeText = new javax.swing.JTextField();
        CreateReservation = new javax.swing.JButton();
        openHourslbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        storeInformationsText = new javax.swing.JTextArea();
        usernameText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        openHoursText.setName("openHoursText"); // NOI18N

        Stores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Store Name", "Available Seats", "Address", "Telephone"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Stores.setName("Stores"); // NOI18N
        Stores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Stores);

        storeNamelbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        storeNamelbl.setText("Store's name");

        CancelReservation.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        CancelReservation.setText("Cancel Reservation");
        CancelReservation.setName("CancelReservation"); // NOI18N
        CancelReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelReservationActionPerformed(evt);
            }
        });

        storeText.setName("storeText"); // NOI18N

        CreateReservation.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        CreateReservation.setText("Create Reservation");
        CreateReservation.setName("CreateReservation"); // NOI18N
        CreateReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateReservationActionPerformed(evt);
            }
        });

        openHourslbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        openHourslbl.setText("Open Hours");

        storeInformationsText.setColumns(20);
        storeInformationsText.setRows(5);
        storeInformationsText.setName("storeInformationsText"); // NOI18N
        jScrollPane2.setViewportView(storeInformationsText);

        usernameText.setEnabled(false);
        usernameText.setName("usernameText"); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Username");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CreateReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CancelReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(openHourslbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(openHoursText))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(storeNamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(storeText)))))
                .addContainerGap(156, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(openHourslbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(openHoursText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(storeNamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(storeText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Update_Table() throws Exception{
        StoreChooserForReservationController_forTests storeChooserForReservation = new StoreChooserForReservationController_forTests();
           
        List<Store_Test> stores;
        stores = storeChooserForReservation.getStores();
        DefaultTableModel dt = (DefaultTableModel)Stores.getModel();
        
        try{ 
            for(Store_Test store : stores){
                dt.addRow(new Object[]{store.getNameOfStore(),store.getNumberOfSeats(),store.getStoreAddress(),store.getStorePhone()});
            }
            
            
        }catch (Exception e){
           System.out.println("Connection to Store Database failed!"+e);
        }
    
    }
    
    private void StoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StoresMouseClicked

        try{
            StoreChooserForReservationController_forTests storeDetails = new StoreChooserForReservationController_forTests();
            int row = Stores.getSelectedRow();
            String Table_click = (Stores.getModel().getValueAt(row,0).toString());
            storeText.setText(Table_click);

            List<Store_Test> storeInformations = new ArrayList<Store_Test>();
            List<Store_Test> storeOpenHours = new ArrayList<Store_Test>();

            storeInformations = storeDetails.getStoreDetails(Stores.getModel().getValueAt(row,0).toString(), Stores.getModel().getValueAt(row,2).toString());
            storeInformationsText.setText(storeInformations.iterator().next().getStoreDetails().toString());
            storeOpenHours = storeDetails.getStoresOpenHours(Stores.getModel().getValueAt(row,0).toString(), Stores.getModel().getValueAt(row,2).toString());
            openHoursText.setText(storeOpenHours.iterator().next().getOpenHours().toString());
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);

        }
    }//GEN-LAST:event_StoresMouseClicked

    private void CancelReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelReservationActionPerformed
        // TODO add your handling code here:
        try {
            MainFormUser_forTests main = new MainFormUser_forTests(usernameText.getText());
            main.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(CreateReservationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_CancelReservationActionPerformed

    private void CreateReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateReservationActionPerformed

        //CreateReservationForm rFormFinal = new CreateReservationForm(storeText.getText().toString());
        CreateReservationForm_forTests rFormFinal = new CreateReservationForm_forTests(storeText.getText().toString(),openHoursText.getText().toString(),usernameText.getText());

        if(storeText.getText().toString().equals("")){
            JOptionPane.showMessageDialog(null, "You haven't selected a store name!");
        } else{
            rFormFinal.setVisible(true);
            this.dispose();
        }

        try {
            Update_Table();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }

    }//GEN-LAST:event_CreateReservationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StoreChooserForReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoreChooserForReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoreChooserForReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoreChooserForReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new StoreChooserForReservationForm_forTests().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(StoreChooserForReservationForm_forTests.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelReservation;
    private javax.swing.JButton CreateReservation;
    private javax.swing.JTable Stores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField openHoursText;
    private javax.swing.JLabel openHourslbl;
    private javax.swing.JTextArea storeInformationsText;
    private javax.swing.JLabel storeNamelbl;
    private javax.swing.JTextField storeText;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
