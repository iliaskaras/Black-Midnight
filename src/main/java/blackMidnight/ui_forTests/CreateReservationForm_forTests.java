/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.ui_forTests;

import blackMidnight.DAO_forTests.StoreSeatAvailabilityDAO_forTest;
import blackMidnight.controller.BookingConfirmationController;
import blackMidnight.controller_forTests.CreateReservationController_Test;
import blackMidnight.controller_forTests.SendEmailController_forTests;
import blackMidnight.controller_forTests.StoreAvailableDaysController_forTest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Ilias
 */
public class CreateReservationForm_forTests extends javax.swing.JFrame {

    /**
     * Creates new form CreateReservationForm_forTests
     */
    public CreateReservationForm_forTests() {
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

     /** Loads the Store's name into the StoresNameTxt **/
    public CreateReservationForm_forTests(String storesName,String storesOpenHours, String username) {
        initComponents();
        setDateComboBox();
        usernameText.setText(username);
        StoresNameTxt.setText(storesName);
        openHoursTxt.setText(storesOpenHours);
      
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

    public String getCustomerNameTxt() {
        return CustomerNameTxt.getText().toString();
    }

    public void setCustomerNameTxt(JTextField CustomerNameTxt) {
        this.CustomerNameTxt = CustomerNameTxt;
    }
 
    public String getUsernameTxt() {
        
        return usernameText.getText().toString();
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
    
    /** we load the first 2 months (starting from current date) into the comboBox that have the dates available **/
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
    
    /** buttonsManager Showing what fields have wrong inputs **/
    public void buttonsManager() throws Exception {
            String customerName = getCustomerNameTxt();
            String numberOfSeats = getNumberOfSeatsTxt();
            int nos = Integer.parseInt(numberOfSeats);
            String storeName = getStoresNameTxt();
            String date = DateAvailable.getSelectedItem().toString();
            String hour = HoursAvailable.getSelectedItem().toString();
            String openStoreHour = openHoursTxt.getText().toString();
            String chosenDay = ChosenDay.getText();
             
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
 //==================================================================================//     
            boolean result3;
            result3=StoreAvailableDaysController_forTest.checkStoreDayAvailabilityForTests(chosenDay,storeName);  
            if(result3==false){
                redButton4Visible();
                greenButton4NotVisible();
            } else {
                redButton4NotVisible();
                greenButton4Visible();
            }    
  //==================================================================================//     
            boolean result4;
            result4=instance.checkStoresHourAvailability(hour,openStoreHour );  
            if(result4==false){
                redButton5Visible();
                greenButton5NotVisible();
            } else {
                redButton5NotVisible();
                greenButton5Visible();
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

        HoursAvailable = new javax.swing.JComboBox();
        DateAvailable = new javax.swing.JComboBox();
        JBHome = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        openHoursLbl = new javax.swing.JLabel();
        ChosenDayLbl = new javax.swing.JLabel();
        ChosenDay = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CustomerNameTxt = new javax.swing.JTextField();
        makeReservation = new javax.swing.JButton();
        openHoursTxt = new javax.swing.JTextField();
        greenButton2 = new javax.swing.JButton();
        StoresNameTxt = new javax.swing.JTextField();
        StoresName = new javax.swing.JLabel();
        ClientName = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();
        greenButton1 = new javax.swing.JButton();
        greenButton3 = new javax.swing.JButton();
        redButton2 = new javax.swing.JButton();
        redButton3 = new javax.swing.JButton();
        redButton1 = new javax.swing.JButton();
        NumberOfSeatsTxt = new javax.swing.JTextField();
        greenButton4 = new javax.swing.JButton();
        redButton4 = new javax.swing.JButton();
        BackToMainReservationForm = new javax.swing.JButton();
        usernameText = new javax.swing.JTextField();
        hourLbl = new javax.swing.JLabel();
        redButton5 = new javax.swing.JButton();
        greenButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        HoursAvailable.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        HoursAvailable.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45", "20:00", "20:15", "20:30", "20:45", "21:00", "21:15", "21:30", "21:45", "22:00", "22:15", "22:30", "22:45", "23:00", "23:15", "23:30", "23:45", "00:00", "00:15", "00:30", "00:45", "01:15", "01:30", "01:45", "02:00", "02:15", "02:30", "02:45", "03:00", "", "", "" }));
        HoursAvailable.setName("HoursAvailable"); // NOI18N
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

        DateAvailable.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        DateAvailable.setName("DateAvailable"); // NOI18N
        DateAvailable.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                DateAvailablePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        DateAvailable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DateAvailableActionPerformed(evt);
            }
        });

        JBHome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        JBHome.setText("Home");
        JBHome.setName("JBHome"); // NOI18N
        JBHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBHomeActionPerformed(evt);
            }
        });

        openHoursLbl.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        openHoursLbl.setText("Open Hours:");

        ChosenDayLbl.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ChosenDayLbl.setText("Chosen Day:");

        ChosenDay.setName("ChosenDay"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Username");

        CustomerNameTxt.setName("CustomerNameTxt"); // NOI18N
        CustomerNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerNameTxtActionPerformed(evt);
            }
        });

        makeReservation.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        makeReservation.setText("Make the Reservation");
        makeReservation.setName("makeReservation"); // NOI18N
        makeReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makeReservationActionPerformed(evt);
            }
        });

        openHoursTxt.setName("openHoursTxt"); // NOI18N
        openHoursTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openHoursTxtActionPerformed(evt);
            }
        });

        greenButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ilias\\Documents\\NetBeansProjects\\13_12_2013\\trunk\\black-midnight\\src\\main\\java\\resources\\Button-Blank-Green-icon.png")); // NOI18N
        greenButton2.setName("greenButton2"); // NOI18N

        StoresNameTxt.setName("StoresNameTxt"); // NOI18N
        StoresNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoresNameTxtActionPerformed(evt);
            }
        });

        StoresName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        StoresName.setText("Store's Name:");

        ClientName.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        ClientName.setText("Your Name:");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Number of seats you need:");

        dateLbl.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        dateLbl.setText("Date:");

        greenButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ilias\\Documents\\NetBeansProjects\\13_12_2013\\trunk\\black-midnight\\src\\main\\java\\resources\\Button-Blank-Green-icon.png")); // NOI18N
        greenButton1.setName("greenButton1"); // NOI18N

        greenButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ilias\\Documents\\NetBeansProjects\\13_12_2013\\trunk\\black-midnight\\src\\main\\java\\resources\\Button-Blank-Green-icon.png")); // NOI18N
        greenButton3.setName("greenButton3"); // NOI18N

        redButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ilias\\Documents\\NetBeansProjects\\13_12_2013\\trunk\\black-midnight\\src\\main\\java\\resources\\Button-Blank-Red-icon.png")); // NOI18N
        redButton2.setName("redButton2"); // NOI18N
        redButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButton2ActionPerformed(evt);
            }
        });

        redButton3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ilias\\Documents\\NetBeansProjects\\13_12_2013\\trunk\\black-midnight\\src\\main\\java\\resources\\Button-Blank-Red-icon.png")); // NOI18N
        redButton3.setName("redButton3"); // NOI18N
        redButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButton3ActionPerformed(evt);
            }
        });

        redButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ilias\\Documents\\NetBeansProjects\\13_12_2013\\trunk\\black-midnight\\src\\main\\java\\resources\\Button-Blank-Red-icon.png")); // NOI18N
        redButton1.setName("redButton1"); // NOI18N
        redButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButton1ActionPerformed(evt);
            }
        });

        NumberOfSeatsTxt.setName("NumberOfSeatsTxt"); // NOI18N
        NumberOfSeatsTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumberOfSeatsTxtActionPerformed(evt);
            }
        });

        greenButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ilias\\Documents\\NetBeansProjects\\13_12_2013\\trunk\\black-midnight\\src\\main\\java\\resources\\Button-Blank-Green-icon.png")); // NOI18N
        greenButton4.setName("greenButton4"); // NOI18N

        redButton4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ilias\\Documents\\NetBeansProjects\\13_12_2013\\trunk\\black-midnight\\src\\main\\java\\resources\\Button-Blank-Red-icon.png")); // NOI18N
        redButton4.setName("redButton4"); // NOI18N

        BackToMainReservationForm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BackToMainReservationForm.setText("Back");
        BackToMainReservationForm.setName("BackToMainReservationForm"); // NOI18N
        BackToMainReservationForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToMainReservationFormActionPerformed(evt);
            }
        });

        usernameText.setName("usernameText"); // NOI18N

        hourLbl.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        hourLbl.setText("Hour:");

        redButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ilias\\Documents\\NetBeansProjects\\13_12_2013\\trunk\\black-midnight\\src\\main\\java\\resources\\Button-Blank-Red-icon.png")); // NOI18N
        redButton5.setName("redButton5"); // NOI18N

        greenButton5.setIcon(new javax.swing.ImageIcon("C:\\Users\\Ilias\\Documents\\NetBeansProjects\\13_12_2013\\trunk\\black-midnight\\src\\main\\java\\resources\\Button-Blank-Green-icon.png")); // NOI18N
        greenButton5.setName("greenButton5"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(openHoursLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(StoresName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(StoresNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(redButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(greenButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(openHoursTxt)
                                .addGap(321, 321, 321))))
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(makeReservation)
                                .addGap(21, 21, 21)
                                .addComponent(BackToMainReservationForm, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(JBHome, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(ClientName)
                                    .addComponent(hourLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ChosenDayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CustomerNameTxt)
                                        .addComponent(NumberOfSeatsTxt)
                                        .addComponent(DateAvailable, 0, 134, Short.MAX_VALUE)
                                        .addComponent(ChosenDay))
                                    .addComponent(HoursAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(redButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(greenButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(redButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(greenButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(redButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(greenButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(redButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(greenButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(StoresName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(redButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(greenButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(StoresNameTxt)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(openHoursLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(openHoursTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ClientName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CustomerNameTxt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(redButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(greenButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hourLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(greenButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(redButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(HoursAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChosenDayLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChosenDay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(makeReservation, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(BackToMainReservationForm, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(JBHome, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                .addGap(80, 80, 80))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void DateAvailablePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_DateAvailablePopupMenuWillBecomeInvisible
        // We set ChosenDay text with the proper selected day from ComboBox:DateAvailable //
        int i = DateAvailable.getSelectedIndex();

        DateFormat dateFormat = new SimpleDateFormat("E");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_WEEK,i);
        Date date = calendar.getTime();
        String day = dateFormat.format(date);
        ChosenDay.setText(day);// TODO add your handling code here:

    }//GEN-LAST:event_DateAvailablePopupMenuWillBecomeInvisible

    private void DateAvailableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DateAvailableActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DateAvailableActionPerformed

    private void JBHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBHomeActionPerformed
        // TODO add your handling code here:
        MainFormUser_forTests main = new MainFormUser_forTests(usernameText.getText());
        main.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_JBHomeActionPerformed

    private void CustomerNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerNameTxtActionPerformed

    private void makeReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makeReservationActionPerformed

        String customerName = getCustomerNameTxt();
        String numberOfSeats = getNumberOfSeatsTxt();
        String storeName = getStoresNameTxt();
        String date = DateAvailable.getSelectedItem().toString();
        String hour = HoursAvailable.getSelectedItem().toString();
        String userName = getUsernameTxt();
        String chosenDay = ChosenDay.getText();
        String openStoreHours = openHoursTxt.getText();
        Calendar cal = Calendar.getInstance();
        boolean emailSendCheck=false;

        /* We get the reservation's uid */
        String uid = BookingConfirmationController.uuid();

        CreateReservationController_Test instance = new CreateReservationController_Test();
        SendEmailController_forTests sendEmailNotificationController = new SendEmailController_forTests();

        try{
            boolean result=instance.createReservationForTests(customerName,numberOfSeats,storeName,date,hour,uid,userName,chosenDay,openStoreHours);
            if(result==false){
                JOptionPane.showMessageDialog(null, "You need to fix the wrong inputs (red warning ones) !");
            }else{
                String resultEmail = sendEmailNotificationController.readFromRegisterUsersLogEmail(usernameText.getText().toString());
                emailSendCheck = sendEmailNotificationController.sendToCustomerNotificationEmail(resultEmail,uid,storeName,customerName,date);
                if(emailSendCheck==true){
                    System.out.println("Email Notification to customer sended Successfully !");
                }else
                System.out.println("Email Notification to customer failed to send !");

                resultEmail = sendEmailNotificationController.readFromStoreListEmail(StoresNameTxt.getText().toString());
                emailSendCheck = sendEmailNotificationController.sendToStoreManagerNotificationEmail(resultEmail,uid,storeName,customerName,date,numberOfSeats);
                if(emailSendCheck==true){
                    System.out.println("Email Notification to Store sended Successfully !");
                }else
                System.out.println("Email Notification to Store failed to send !");

                BookingConfirmationController.msgBoxForTests(uid);
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            buttonsManager();
        } catch (Exception ex) {
            Logger.getLogger(CreateReservationForm_forTests.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_makeReservationActionPerformed

    private void openHoursTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openHoursTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openHoursTxtActionPerformed

    private void StoresNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoresNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StoresNameTxtActionPerformed

    private void redButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redButton2ActionPerformed

    private void redButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redButton3ActionPerformed

    private void redButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redButton1ActionPerformed

    private void NumberOfSeatsTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumberOfSeatsTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NumberOfSeatsTxtActionPerformed

    private void BackToMainReservationFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToMainReservationFormActionPerformed
        StoreChooserForReservationForm_forTests crform;
        try {
            crform = new StoreChooserForReservationForm_forTests(usernameText.getText());
            crform.setVisible(true);
            this.setVisible(false);
        } catch (Exception ex) {
            Logger.getLogger(MainFormStoreOwner_forTests.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(CreateReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateReservationForm_forTests.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateReservationForm_forTests().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToMainReservationForm;
    private javax.swing.JTextField ChosenDay;
    private javax.swing.JLabel ChosenDayLbl;
    private javax.swing.JLabel ClientName;
    private javax.swing.JTextField CustomerNameTxt;
    private javax.swing.JComboBox DateAvailable;
    private javax.swing.JComboBox HoursAvailable;
    private javax.swing.JButton JBHome;
    private javax.swing.JTextField NumberOfSeatsTxt;
    private javax.swing.JLabel StoresName;
    private javax.swing.JTextField StoresNameTxt;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JButton greenButton1;
    private javax.swing.JButton greenButton2;
    private javax.swing.JButton greenButton3;
    private javax.swing.JButton greenButton4;
    private javax.swing.JButton greenButton5;
    private javax.swing.JLabel hourLbl;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JButton makeReservation;
    private javax.swing.JLabel openHoursLbl;
    private javax.swing.JTextField openHoursTxt;
    private javax.swing.JButton redButton1;
    private javax.swing.JButton redButton2;
    private javax.swing.JButton redButton3;
    private javax.swing.JButton redButton4;
    private javax.swing.JButton redButton5;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
