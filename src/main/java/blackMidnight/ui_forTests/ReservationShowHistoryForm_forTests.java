/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.ui_forTests;

import blackMidnight.DAO_forTests.GetReservationHistoryDAO_forTest;
import blackMidnight.model_forTests.Reservation_Test;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ilias
 */
public class ReservationShowHistoryForm_forTests extends javax.swing.JFrame {

    /**
     * Creates new form ReservationShowHistoryForm_forTests
     */
    public ReservationShowHistoryForm_forTests() throws Exception {
        initComponents();
        Update_Table();
    }
    
    public ReservationShowHistoryForm_forTests(String username) throws Exception{
        initComponents();
        usernameText.setText(username);
        Update_Table();
    }
    
    private void Update_Table() throws Exception{
        GetReservationHistoryDAO_forTest getReservationHistory = new GetReservationHistoryDAO_forTest();
           
        List<Reservation_Test> reservations;
        reservations = getReservationHistory.getAllReservationsForTests(usernameText.getText().toString());
        DefaultTableModel dt = (DefaultTableModel)AllReservationsTable.getModel();
        
        while (dt.getRowCount() > 0) {
                    dt.removeRow(0);
        }
        
        try{ 
            for(Reservation_Test reservation : reservations){
                dt.addRow(new Object[]{reservation.getStoreName(),reservation.getDate(),reservation.getHour(),reservation.getNumberOfSeats(),reservation.getReservationCode()});
            }
      
        }catch (Exception e){
           System.out.println("Connection to Reservation Database failed!"+e);
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

        Home = new javax.swing.JButton();
        usernamelbl = new javax.swing.JLabel();
        ShowSpecificStoreHistory = new javax.swing.JButton();
        usernameText = new javax.swing.JTextField();
        chosenStore = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        AllReservationsTable = new javax.swing.JTable();
        AllReservations = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Home.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Home.setText("Home");
        Home.setName("Home"); // NOI18N
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        usernamelbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usernamelbl.setText("Username");

        ShowSpecificStoreHistory.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ShowSpecificStoreHistory.setText("Your Reservation's to store:");
        ShowSpecificStoreHistory.setName("ShowSpecificStoreHistory"); // NOI18N
        ShowSpecificStoreHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowSpecificStoreHistoryActionPerformed(evt);
            }
        });

        usernameText.setName("usernameText"); // NOI18N

        chosenStore.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        chosenStore.setName("chosenStore"); // NOI18N

        AllReservationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Store Name", "Date", "Hour", "Seats", "reservation Code"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        AllReservationsTable.setName("AllReservationsTable"); // NOI18N
        jScrollPane1.setViewportView(AllReservationsTable);

        AllReservations.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AllReservations.setText("Show all Reservations");
        AllReservations.setName("AllReservations"); // NOI18N
        AllReservations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllReservationsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usernamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(ShowSpecificStoreHistory)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(chosenStore, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(AllReservations, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernamelbl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowSpecificStoreHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chosenStore, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AllReservations, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        MainFormUser_forTests main = new MainFormUser_forTests(usernameText.getText());
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void ShowSpecificStoreHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowSpecificStoreHistoryActionPerformed
        // TODO add your handling code here:
        GetReservationHistoryDAO_forTest getReservationHistory = new GetReservationHistoryDAO_forTest();
        List<Reservation_Test> reservations;
        reservations = getReservationHistory.getReservationsHistoryForSpecificStoreForTests(chosenStore.getText().toString(),usernameText.getText().toString());
        DefaultTableModel dt = (DefaultTableModel)AllReservationsTable.getModel();
        
       
        while (dt.getRowCount() > 0) {
            dt.removeRow(0);
        }
        if(reservations.isEmpty()){
            JOptionPane.showMessageDialog(null, "You dont have any reservations for : "+chosenStore.getText().toString());
        }else{
            try{
                for(Reservation_Test reservation : reservations){
                    dt.addRow(new Object[]{reservation.getStoreName(),reservation.getDate(),reservation.getHour(),reservation.getNumberOfSeats(),reservation.getReservationCode()});
                }

            }catch (Exception e){
                System.out.println("You dont have any reservations for !"+chosenStore.getText().toString());
                JOptionPane.showMessageDialog(null, "You dont have any reservations for : "+chosenStore.getText().toString());
            }
        }
    }//GEN-LAST:event_ShowSpecificStoreHistoryActionPerformed

    private void AllReservationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllReservationsActionPerformed
        // TODO add your handling code here:
        GetReservationHistoryDAO_forTest getReservationHistory = new GetReservationHistoryDAO_forTest();
        List<Reservation_Test> reservations;
        reservations = getReservationHistory.getAllReservationsForTests(usernameText.getText().toString());
        DefaultTableModel dt = (DefaultTableModel)AllReservationsTable.getModel();

        while (dt.getRowCount() > 0) {
            dt.removeRow(0);
        }
        
        if(reservations.isEmpty()){
            JOptionPane.showMessageDialog(null, "You dont have any reservations");
        }else{
            try{
                for(Reservation_Test reservation : reservations){
                    dt.addRow(new Object[]{reservation.getStoreName(),reservation.getDate(),reservation.getHour(),reservation.getNumberOfSeats(),reservation.getReservationCode()});
                }

            }catch (Exception e){
                System.out.println("You dont have any reservations for !"+chosenStore.getText().toString());
                JOptionPane.showMessageDialog(null, "You dont have any reservations  : "+usernameText.getText().toString());
            }
        }
    }//GEN-LAST:event_AllReservationsActionPerformed

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
            java.util.logging.Logger.getLogger(ReservationShowHistoryForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReservationShowHistoryForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReservationShowHistoryForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReservationShowHistoryForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ReservationShowHistoryForm_forTests().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ReservationShowHistoryForm_forTests.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AllReservations;
    private javax.swing.JTable AllReservationsTable;
    private javax.swing.JButton Home;
    private javax.swing.JButton ShowSpecificStoreHistory;
    private javax.swing.JTextField chosenStore;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField usernameText;
    private javax.swing.JLabel usernamelbl;
    // End of variables declaration//GEN-END:variables
}