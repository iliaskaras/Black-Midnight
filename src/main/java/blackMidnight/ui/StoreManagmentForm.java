/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.ui;

import blackMidnight.controller.DeleteStoreController;
import blackMidnight.controller.IDeleteStoreController;
import blackMidnight.controller.IStoreManagementController;
import blackMidnight.controller.StoreManagementController;
import blackMidnight.model.Store;
import blackMidnight.util.HibernateUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class StoreManagmentForm extends javax.swing.JFrame {

    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    private Store myStore = new Store();
    private String username;

    /**
     * Creates new form StoreManagmentForm
     */
    public StoreManagmentForm() {
        initComponents();
        updateStoresTable();

    }
    public StoreManagmentForm(String username) {
        this.username=username;
        initComponents();
        updateStoresTable();

    }

    private void updateStoresTable() {
        IStoreManagementController storeManagementController = new StoreManagementController();
        List<Store> storesList;
        storesList = storeManagementController.getStores();
        DefaultTableModel deftm = (DefaultTableModel) storeTbl.getModel();

        try {
            for (Store store : storesList) {
                deftm.addRow(new Object[]{store.getNameOfStore(), store.getNumberOfSeats(), store.getStoreAddress(), store.getStoreCity(), store.getStorePhone(), store.getEmail()});
            }
        } catch (Exception e) {
            System.out.println("Connection to Database failed!" + e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        storeTbl = new javax.swing.JTable();
        addStoreBtn = new javax.swing.JButton();
        editStoreBtn = new javax.swing.JButton();
        deleteStoreBtn = new javax.swing.JButton();
        closeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Store Management");
        setName("StoreManagementFrm"); // NOI18N

        storeTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Number of seats", "Address", "City", "Phone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        storeTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                storeTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(storeTbl);

        addStoreBtn.setText("Add Store");
        addStoreBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addStoreBtnMouseClicked(evt);
            }
        });
        addStoreBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStoreBtnActionPerformed(evt);
            }
        });

        editStoreBtn.setText("Edit Store");
        editStoreBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editStoreBtnMouseClicked(evt);
            }
        });

        deleteStoreBtn.setLabel("Delete Store");
        deleteStoreBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteStoreBtnMouseClicked(evt);
            }
        });

        closeBtn.setLabel("Close");
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
        });
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(closeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteStoreBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(editStoreBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addStoreBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addStoreBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editStoreBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(deleteStoreBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(closeBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked

        try {
            // StoreChooserForReservationForm mainResForm = new StoreChooserForReservationForm();
            MainFormStoreOwner main = new MainFormStoreOwner(username);
            main.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(CreateReservationForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_closeBtnMouseClicked

    private void addStoreBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStoreBtnMouseClicked
        CreateStoreForm csform = new CreateStoreForm(1);
        csform.setVisible(true);
        this.dispose();
        //this.setVisible(false);
    }//GEN-LAST:event_addStoreBtnMouseClicked

    private void storeTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_storeTblMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_storeTblMouseClicked

    private void editStoreBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editStoreBtnMouseClicked

        getSelectedStore();

        EditStoreForm editStoreF = new EditStoreForm(myStore);

        try {
            editStoreF.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_editStoreBtnMouseClicked

    private void getSelectedStore() {
        try {
            int row = storeTbl.getSelectedRow();
            String Table_click = (storeTbl.getModel().getValueAt(row, 0).toString());

            Session session = factory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Store where nameOfStore = :nameOfStore");
            query.setString("nameOfStore", Table_click);

            List<Store> stores = (List<Store>) query.list();
            session.getTransaction().commit();
            session.close();

            myStore.setStoreId(stores.get(0).getStoreId());
            myStore.setNameOfStore(stores.get(0).getNameOfStore());
            myStore.setNumberOfSeats(stores.get(0).getNumberOfSeats());
            myStore.setParking(stores.get(0).getParking());
            myStore.setStoreAddress(stores.get(0).getStoreAddress());
            myStore.setStoreCity(stores.get(0).getStoreCity());
            myStore.setStorePhone(stores.get(0).getStorePhone());
            myStore.setOpenDays(stores.get(0).getOpenDays());
            myStore.setOpenHours(stores.get(0).getOpenHours());
            myStore.setEmail(stores.get(0).getEmail());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void deleteStoreBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteStoreBtnMouseClicked
        getSelectedStore();

        IDeleteStoreController deleteStore = new DeleteStoreController();
        boolean successDel = deleteStore.deleteStore(myStore);
        if (successDel == true) {
            JOptionPane.showMessageDialog(rootPane, "Store Deleted Succesfully");
            StoreManagmentForm myForm = new StoreManagmentForm();
            myForm.setVisible(true);
            this.dispose();
            
        } else {
            JOptionPane.showMessageDialog(rootPane, "Store Failed to Delete!");
        };
    }//GEN-LAST:event_deleteStoreBtnMouseClicked

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeBtnActionPerformed

    private void addStoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStoreBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStoreBtnActionPerformed

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
            java.util.logging.Logger.getLogger(StoreManagmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StoreManagmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StoreManagmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StoreManagmentForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StoreManagmentForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStoreBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JButton deleteStoreBtn;
    private javax.swing.JButton editStoreBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable storeTbl;
    // End of variables declaration//GEN-END:variables
}
