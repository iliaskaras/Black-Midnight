/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.ui;

import blackMidnight.DAO.ItemDAO;
import blackMidnight.controller.AddItemController;
import blackMidnight.controller.BookingConfirmationController;

import blackMidnight.controller.IAddItemController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ilias
 */
public class AddItemForm extends javax.swing.JFrame {
 private int flag;

    /**
     * Creates new form AddItemForm
     */
    public AddItemForm() {
        initComponents();
        falseLabelsNoVisible();
    }

        
    public AddItemForm(int flag2) {
        flag = flag2;
        initComponents();
        falseLabelsNoVisible();
        
    }
    
    private void falseLabelsNoVisible(){
        jitemNameFalseLabel.setVisible(false);
        jitemTypeFalseLabel.setVisible(false);
        jitemPriceFalseLabel.setVisible(false);
        jitemQuantityFalseLabel.setVisible(false);
       
    }
    
    
 
        private void initializeComponents(){
            jitemNameLabel.setText("");
            jitemTypeLabel.setText("");
            jitemPriceLabel.setText("0"); 
            jitemQuantityLabel.setText("0");
          
    }
        
         private void showFalse(boolean itemNameCheck, boolean itemTypeCheck,
                           boolean itemPriceCheck, boolean itemQuantityCheck){
        
                if((itemNameCheck) == false)
                    jitemNameFalseLabel.setVisible(true);
                if((itemTypeCheck) == false)
                    jitemTypeFalseLabel.setVisible(true);
                if((itemPriceCheck) == false)
                    jitemPriceFalseLabel.setVisible(true);
                if((itemQuantityCheck) == false)
                    jitemQuantityFalseLabel.setVisible(true);
               
    }
    
        
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jitemNameLabel = new javax.swing.JLabel();
        jitemPriceTextField = new javax.swing.JTextField();
        jitemQuantityLabel = new javax.swing.JLabel();
        jitemNameTextField = new javax.swing.JTextField();
        jitemTypeLabel = new javax.swing.JLabel();
        jitemTypeTextField = new javax.swing.JTextField();
        jitemPriceLabel = new javax.swing.JLabel();
        jitemQuantityTextField = new javax.swing.JTextField();
        jItemSaveButton = new javax.swing.JButton();
        jItemCancelButton = new javax.swing.JButton();
        jitemNameFalseLabel = new javax.swing.JLabel();
        jitemPriceFalseLabel = new javax.swing.JLabel();
        jitemTypeFalseLabel = new javax.swing.JLabel();
        jitemQuantityFalseLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jitemNameLabel.setText("Items Name");

        jitemPriceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jitemPriceTextFieldActionPerformed(evt);
            }
        });

        jitemQuantityLabel.setText("Item Quantity");

        jitemTypeLabel.setText("Item Type");

        jitemTypeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jitemTypeTextFieldActionPerformed(evt);
            }
        });

        jitemPriceLabel.setText("Item Price");

        jItemSaveButton.setText("Save");
        jItemSaveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jItemSaveButtonMouseClicked(evt);
            }
        });
        jItemSaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemSaveButtonActionPerformed(evt);
            }
        });

        jItemCancelButton.setText("Cancel");
        jItemCancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jItemCancelButtonMouseClicked(evt);
            }
        });
        jItemCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jItemCancelButtonActionPerformed(evt);
            }
        });

        jitemNameFalseLabel.setForeground(new java.awt.Color(255, 0, 102));
        jitemNameFalseLabel.setText("false");

        jitemPriceFalseLabel.setForeground(new java.awt.Color(255, 0, 102));
        jitemPriceFalseLabel.setText("false");

        jitemTypeFalseLabel.setForeground(new java.awt.Color(255, 0, 102));
        jitemTypeFalseLabel.setText("false");

        jitemQuantityFalseLabel.setForeground(new java.awt.Color(255, 0, 102));
        jitemQuantityFalseLabel.setText("false");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jitemQuantityLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jitemNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jitemTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jitemPriceLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jitemPriceTextField)
                    .addComponent(jitemNameTextField)
                    .addComponent(jitemTypeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(jitemQuantityTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jitemNameFalseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jitemPriceFalseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jitemQuantityFalseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jitemTypeFalseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(jItemSaveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jItemCancelButton)
                .addGap(8, 8, 8))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jitemNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jitemTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                                .addGap(31, 31, 31))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jitemTypeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jitemTypeFalseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jitemPriceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jitemPriceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jitemPriceFalseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jitemNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jitemNameFalseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jitemQuantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jitemQuantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jitemQuantityFalseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jItemSaveButton)
                    .addComponent(jItemCancelButton))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jitemPriceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jitemPriceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jitemPriceTextFieldActionPerformed

    private void jitemTypeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jitemTypeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jitemTypeTextFieldActionPerformed

    private void jItemCancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jItemCancelButtonMouseClicked
        // TODO add your handling code here:
         if(flag==0){
            MainFormUser main = new MainFormUser();
            main.setVisible(true);
            this.dispose();
        }else{
            ItemManagementForm catalogReservF= new ItemManagementForm();
            catalogReservF.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jItemCancelButtonMouseClicked

    private void jItemSaveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jItemSaveButtonMouseClicked
        // TODO add your handling code here:
         String itemName = jitemNameTextField.getText();
         String itemType = jitemTypeTextField.getText();
         int itemPrice = Integer.parseInt(jitemPriceTextField.getText());
         int itemQuantity = Integer.parseInt(jitemQuantityTextField.getText());

        falseLabelsNoVisible();

        AddItemController itemControl = new AddItemController ();
        boolean itemNameCheck = itemControl.checkItemName(itemName);
        boolean itemTypeCheck = itemControl.checkItemType(itemType);
        boolean itemPriceCheck = itemControl.checkItemPrice(itemPrice);
        boolean itemQuantityCheck = itemControl.checkItemQuantity(itemQuantity);
       

        IAddItemController myItemController = new AddItemController();
        
       
                
         try{
                boolean result = myItemController.addItem(itemName, itemType, itemPrice,itemQuantity);
                if(result==false){
                    JOptionPane.showMessageDialog(null, "You need to fix the wrong inputs (red warning ones) !");
                     showFalse(itemNameCheck,itemTypeCheck,itemPriceCheck,itemQuantityCheck);
                }else{
                      JOptionPane.showMessageDialog(rootPane, "Item Created Succesfully");
                  initializeComponents();  
                     
                }
             }catch (Exception e){
                System.out.println(e);
                   
             }
           
            
   
    }//GEN-LAST:event_jItemSaveButtonMouseClicked

    private void jItemSaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jItemSaveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jItemSaveButtonActionPerformed

    private void jItemCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jItemCancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jItemCancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddItemForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddItemForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jItemCancelButton;
    private javax.swing.JButton jItemSaveButton;
    private javax.swing.JLabel jitemNameFalseLabel;
    private javax.swing.JLabel jitemNameLabel;
    private javax.swing.JTextField jitemNameTextField;
    private javax.swing.JLabel jitemPriceFalseLabel;
    private javax.swing.JLabel jitemPriceLabel;
    private javax.swing.JTextField jitemPriceTextField;
    private javax.swing.JLabel jitemQuantityFalseLabel;
    private javax.swing.JLabel jitemQuantityLabel;
    private javax.swing.JTextField jitemQuantityTextField;
    private javax.swing.JLabel jitemTypeFalseLabel;
    private javax.swing.JLabel jitemTypeLabel;
    private javax.swing.JTextField jitemTypeTextField;
    // End of variables declaration//GEN-END:variables
}
