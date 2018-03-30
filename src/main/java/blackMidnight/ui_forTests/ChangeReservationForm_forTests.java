/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.ui_forTests;

import blackMidnight.DAO_forTests.ChangeReservationDAO_forTest;
import blackMidnight.DAO_forTests.StoreSeatAvailabilityDAO_forTest;
import blackMidnight.controller_forTests.CreateReservationController_Test;
import blackMidnight.model_forTests.Reservation_Test;
import blackMidnight.util.HibernateUtilTest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class ChangeReservationForm_forTests extends javax.swing.JFrame {

    private static SessionFactory factory = HibernateUtilTest.getSessionFactory();
    /**
     * Creates new form ChangeReservationForm_forTests
     */
    public ChangeReservationForm_forTests() {
        initComponents();
        setDateComboBox();
        redButton1.setVisible(false);
        redButton2.setVisible(false);
        redButton3.setVisible(false);
        redButton4.setVisible(false);
        redButton5.setVisible(false);
        greenButton1.setVisible(false);
        greenButton2.setVisible(false);
        greenButton3.setVisible(false);
        greenButton4.setVisible(false);
        greenButton5.setVisible(false);
    }

    public ChangeReservationForm_forTests(int id) throws Exception {
        initComponents();
        setDateComboBox();
        redButton1.setVisible(false);
        redButton2.setVisible(false);
        redButton3.setVisible(false);
        redButton4.setVisible(false);
        redButton5.setVisible(false);
        greenButton1.setVisible(false);
        greenButton2.setVisible(false);
        greenButton3.setVisible(false);
        greenButton4.setVisible(false);
        greenButton5.setVisible(false); 
       
        ChangeReservationDAO_forTest ch = new ChangeReservationDAO_forTest();
        List<Reservation_Test> re = (List<Reservation_Test>) ch.getData(id);
        for(Reservation_Test res : re){
        System.out.println(res.getCustomerName());
        CustomerNameTxt.setText(res.getCustomerName().toString());
        StoresNameTxt.setText(res.getStoreName().toString()); 
        NumberOfSeatsTxt.setText(String.valueOf(res.getNumberOfSeats()));
        DateAvailable.setSelectedItem(res.getDate().toString());
        HoursAvailable.setSelectedItem(res.getHour().toString());
        }
     }
    
    public String getCustomerNameTxt() {
        return CustomerNameTxt.getText().toString();
    }

    public void setCustomerNameTxt(JTextField CustomerNameTxt) {
        this.CustomerNameTxt = CustomerNameTxt;
    }
    
    public void setDateComboBox() {
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    
        try{
            for (int i = 0; i<30 ; i++){
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_YEAR,i);
                Date date = calendar.getTime();
                DateAvailable.addItem(dateFormat.format(date));
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
     public String getNumberOfSeatsTxt(){
       //** We are checking if we have null because null cant turn into integet (in createReservation method) **//
        if(NumberOfSeatsTxt.getText().toString().equals("")){
            return "0";
        } else
            return NumberOfSeatsTxt.getText().toString();
       
    }

    public void setNumberOfSeatsTxt(JTextField NumberOfSeatsTxt) {
        this.NumberOfSeatsTxt = NumberOfSeatsTxt;
    }

    public String getStoresNameTxt() {
        return StoresNameTxt.getText().toString();
    }

    public void setStoresNameTxt(JTextField StoresNameTxt) {
        this.StoresNameTxt = StoresNameTxt;
    }
    
    //** For changing the buttons from other classes (red,green buttons) **//
    //=================== BUTTONS 1 ============ SET VISIBLE =================//
    public void redButton1Visible() {                                           
        
        redButton1.setVisible(true);
    } 
     
    public void greenButton1Visible() {                                           
        
        greenButton1.setVisible(true);
    } 
   //=================== BUTTONS 2 ============ SET VISIBLE =================//
    public void redButton2Visible() {                                           
        
        redButton2.setVisible(true);
    } 
     
     public void greenButton2Visible() {                                           
        
        greenButton2.setVisible(true);
    } 
     
   //=================== BUTTONS 3 ============ SET VISIBLE =================//
    public void redButton3Visible() {                                           
        
        redButton3.setVisible(true);
    } 
     
    public void greenButton3Visible() {                                           
        
        greenButton3.setVisible(true);
    }  
    
    //=================== BUTTONS 4 ============ SET VISIBLE =================//
    public void redButton4Visible() {                                           
        
        redButton4.setVisible(true);
    } 
     
    public void greenButton4Visible() {                                           
        
        greenButton4.setVisible(true);
    } 
    //=================== BUTTONS 5 ============ SET VISIBLE =================//
    public void redButton5Visible() {                                           
        
        redButton5.setVisible(true);
    } 
     
    public void greenButton5Visible() {                                           
        
        greenButton5.setVisible(true);
    } 
    
      //=================== BUTTONS 1 ============ SET NOT VISIBLE ===========//
    public void redButton1NotVisible() {                                           
        
        redButton1.setVisible(false);
    } 
     
    public void greenButton1NotVisible() {                                           
        
        greenButton1.setVisible(false);
    } 
   //=================== BUTTONS 2 ============ SET NOT VISIBLE ===========//
    public void redButton2NotVisible() {                                           
        
        redButton2.setVisible(false);
    } 
     
     public void greenButton2NotVisible() {                                           
        
        greenButton2.setVisible(false);
    } 
     
   //=================== BUTTONS 3 ============ SET NOT VISIBLE ===========//
    public void redButton3NotVisible() {                                           
        
        redButton3.setVisible(false);
    } 
     
    public void greenButton3NotVisible() {                                           
        
        greenButton3.setVisible(false);
    }  
    
    //=================== BUTTONS 4 ============ SET NOT VISIBLE ===========//
    public void redButton4NotVisible() {                                           
        
        redButton4.setVisible(false);
    } 
     
    public void greenButton4NotVisible() {                                           
        
        greenButton4.setVisible(false);
    } 
    
     //=================== BUTTONS 5 ============ SET NOT VISIBLE ===========//
    public void redButton5NotVisible() {                                           
        
        redButton5.setVisible(false);
    } 
     
    public void greenButton5NotVisible() {                                           
        
        greenButton5.setVisible(false);
    } 
    
    /** buttonsManager Showing what fields have wrong inputs
     * @throws java.lang.Exception **/
    public void buttonsManager() throws Exception {
            String customerName = getCustomerNameTxt();
            String numberOfSeats = getNumberOfSeatsTxt();
            int nos = Integer.parseInt(numberOfSeats);
            String storeName = getStoresNameTxt();
            String date = DateAvailable.getSelectedItem().toString();
            String hour = HoursAvailable.getSelectedItem().toString();
             
            String toCheck="";
//==================================================================================//       
            boolean result1;
            result1=StoreSeatAvailabilityDAO_forTest.checkIfStoreNameAvailableForTests(storeName);   
            if(result1==false || storeName.equals(toCheck) || storeName.length()>25){
                   redButton2Visible();
                   greenButton2NotVisible();
            } else {
                   redButton2NotVisible();
                   greenButton2Visible();
            }
//==================================================================================//
            boolean result2;
            result2=StoreSeatAvailabilityDAO_forTest.checkIfStoreSeatAvailableForTests(nos,storeName);
            if(nos<=0 || result2==false){
                   redButton3Visible();
                   greenButton3NotVisible();
            } else {
                   redButton3NotVisible();
                   greenButton3Visible();
            } 
//==================================================================================//        
            if(customerName.length()>25 || customerName.equals(toCheck)){
                   redButton1Visible();
                   greenButton1NotVisible();
            } else {
                   redButton1NotVisible();
                   greenButton1Visible();
            }
//==================================================================================//          
            if(date.equals(toCheck) || date.length()>25){
                   redButton4Visible();
                   greenButton4NotVisible();
            } else {
                   redButton4NotVisible();
                   greenButton4Visible();
            }           
//==================================================================================//     
            CreateReservationController_Test instance = new CreateReservationController_Test();
            if(instance.checkHour(hour)){
                redButton5NotVisible();
                greenButton5Visible();
            }else{
                redButton5Visible();
                greenButton5NotVisible();
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

        dateLbl = new javax.swing.JLabel();
        JBHome = new javax.swing.JButton();
        NumberOfSeatsTxt = new javax.swing.JTextField();
        HoursAvailable = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        greenButton5 = new javax.swing.JButton();
        usernameText = new javax.swing.JTextField();
        redButton2 = new javax.swing.JButton();
        StoresNameTxt = new javax.swing.JTextField();
        redButton4 = new javax.swing.JButton();
        greenButton1 = new javax.swing.JButton();
        redButton1 = new javax.swing.JButton();
        hourLbl = new javax.swing.JLabel();
        CustomerNameTxt = new javax.swing.JTextField();
        ClientName = new javax.swing.JLabel();
        redButton3 = new javax.swing.JButton();
        redButton5 = new javax.swing.JButton();
        changeReservation = new javax.swing.JButton();
        StoresName = new javax.swing.JLabel();
        greenButton2 = new javax.swing.JButton();
        greenButton4 = new javax.swing.JButton();
        DateAvailable = new javax.swing.JComboBox();
        greenButton3 = new javax.swing.JButton();
        BackToMainReservationForm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dateLbl.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        dateLbl.setText("Date:");

        JBHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JBHome.setText("Home");
        JBHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHomeActionPerformed(evt);
            }
        });

        NumberOfSeatsTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfSeatsTxtActionPerformed(evt);
            }
        });

        HoursAvailable.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        HoursAvailable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45", "00:00", "00:15", "00:30", "00:45", "01:15", "01:30", "01:45", "02:00", "02:15", "02:30", "02:45", "03:00", " ", " ", " " }));
        HoursAvailable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                HoursAvailableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HoursAvailableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HoursAvailableMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HoursAvailableMousePressed(evt);
            }
        });
        HoursAvailable.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                HoursAvailablePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        HoursAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoursAvailableActionPerformed(evt);
            }
        });
        HoursAvailable.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                HoursAvailableFocusGained(evt);
            }
        });
        HoursAvailable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                HoursAvailableKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Number of seats you need:");

        usernameText.setText("karona");

        redButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButton2ActionPerformed(evt);
            }
        });

        StoresNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoresNameTxtActionPerformed(evt);
            }
        });

        redButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButton1ActionPerformed(evt);
            }
        });

        hourLbl.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        hourLbl.setText("Hour:");

        CustomerNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNameTxtActionPerformed(evt);
            }
        });

        ClientName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ClientName.setText("Your Name:");

        redButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButton3ActionPerformed(evt);
            }
        });

        changeReservation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        changeReservation.setText("Change the Reservation");
        changeReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeReservationActionPerformed(evt);
            }
        });

        StoresName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        StoresName.setText("Store's Name:");

        DateAvailable.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        DateAvailable.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                DateAvailablePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        BackToMainReservationForm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BackToMainReservationForm.setText("Back");
        BackToMainReservationForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMainReservationFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(ClientName)
                            .addComponent(StoresName, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hourLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(HoursAvailable, 0, 134, Short.MAX_VALUE)
                            .addComponent(CustomerNameTxt)
                            .addComponent(StoresNameTxt)
                            .addComponent(NumberOfSeatsTxt)
                            .addComponent(DateAvailable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(redButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greenButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(redButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(redButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(greenButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(greenButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(redButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greenButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(redButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greenButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(changeReservation)
                        .addGap(21, 21, 21)
                        .addComponent(BackToMainReservationForm, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JBHome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ClientName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CustomerNameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(redButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(greenButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(StoresNameTxt)
                        .addComponent(StoresName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(redButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(greenButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(redButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NumberOfSeatsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(greenButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(redButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DateAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hourLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(greenButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(redButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HoursAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(changeReservation, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(BackToMainReservationForm, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(JBHome, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHomeActionPerformed
        // TODO add your handling code here:
        MainFormUser_forTests main = new MainFormUser_forTests();
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBHomeActionPerformed

    private void NumberOfSeatsTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberOfSeatsTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumberOfSeatsTxtActionPerformed

    private void HoursAvailableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoursAvailableMouseReleased

    }//GEN-LAST:event_HoursAvailableMouseReleased

    private void HoursAvailableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoursAvailableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_HoursAvailableMouseClicked

    private void HoursAvailableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoursAvailableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_HoursAvailableMouseEntered

    private void HoursAvailableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HoursAvailableMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoursAvailableMousePressed

    private void HoursAvailablePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_HoursAvailablePopupMenuWillBecomeInvisible

    }//GEN-LAST:event_HoursAvailablePopupMenuWillBecomeInvisible

    private void HoursAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoursAvailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoursAvailableActionPerformed

    private void HoursAvailableFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_HoursAvailableFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_HoursAvailableFocusGained

    private void HoursAvailableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_HoursAvailableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_HoursAvailableKeyPressed

    private void redButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redButton2ActionPerformed

    private void StoresNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoresNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StoresNameTxtActionPerformed

    private void redButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redButton1ActionPerformed

    private void CustomerNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerNameTxtActionPerformed

    private void redButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redButton3ActionPerformed

    private void changeReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeReservationActionPerformed

        try {
            Reservation_Test re = new Reservation_Test();
            re.setReservationId(1);
            re.setCustomerName(getCustomerNameTxt());
            re.setStoreName(getStoresNameTxt());
            re.setNumberOfSeats((Integer.parseInt(getNumberOfSeatsTxt())));
            re.setDate(DateAvailable.getSelectedItem().toString());
            re.setHour(HoursAvailable.getSelectedItem().toString());

            boolean emailSendCheck=false;

            buttonsManager();

            ChangeReservationDAO_forTest ch = new ChangeReservationDAO_forTest();
            ch.change(re);

        } catch (Exception ex) {
            Logger.getLogger(ChangeReservationForm_forTests.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_changeReservationActionPerformed

    private void DateAvailablePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_DateAvailablePopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_DateAvailablePopupMenuWillBecomeInvisible

    private void BackToMainReservationFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToMainReservationFormActionPerformed

        ReservationChooserForChangeForm_forTests frm;
        try{
            frm = new ReservationChooserForChangeForm_forTests();
            frm.setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(ReservationChooserForChangeForm_forTests.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BackToMainReservationFormActionPerformed

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
            java.util.logging.Logger.getLogger(ChangeReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangeReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangeReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangeReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangeReservationForm_forTests().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToMainReservationForm;
    private javax.swing.JLabel ClientName;
    private javax.swing.JTextField CustomerNameTxt;
    private javax.swing.JComboBox DateAvailable;
    private javax.swing.JComboBox HoursAvailable;
    private javax.swing.JButton JBHome;
    private javax.swing.JTextField NumberOfSeatsTxt;
    private javax.swing.JLabel StoresName;
    private javax.swing.JTextField StoresNameTxt;
    private javax.swing.JButton changeReservation;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JButton greenButton1;
    private javax.swing.JButton greenButton2;
    private javax.swing.JButton greenButton3;
    private javax.swing.JButton greenButton4;
    private javax.swing.JButton greenButton5;
    private javax.swing.JLabel hourLbl;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton redButton1;
    private javax.swing.JButton redButton2;
    private javax.swing.JButton redButton3;
    private javax.swing.JButton redButton4;
    private javax.swing.JButton redButton5;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
