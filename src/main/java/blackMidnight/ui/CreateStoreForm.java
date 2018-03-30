/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.ui;

import blackMidnight.controller.ICreateStoreController;
import blackMidnight.controller.CreateStoreController;
import blackMidnight.DAO.StoreDAO;
import blackMidnight.controller.StoreOwnerController;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ilias
 */
public class CreateStoreForm extends javax.swing.JFrame {
    private int flag;
    private Integer userId;
    /**
     * Creates new form CreateStoreForm
     */
    public CreateStoreForm() {
        initComponents();
        falseLabelsNoVisible();
        
    }
    public CreateStoreForm(Integer storeOwnerId) {
        initComponents();
        falseLabelsNoVisible();
        this.userId = storeOwnerId;
    
    }
    
    public CreateStoreForm(int flag2) {
        flag = flag2;
        initComponents();
        falseLabelsNoVisible();
        
    }
 
    private void falseLabelsNoVisible(){
        storeNameFalseLbl.setVisible(false);
        numberOfSeatsFalseLbl.setVisible(false);
        storeAddressFalseLbl.setVisible(false);
        storeCityFalseLbl.setVisible(false);
        storePhoneFalseLbl.setVisible(false);
        emailFalseLbl.setVisible(false);
        openDaysFalseLbl.setVisible(false);
        openHoursFalseLbl.setVisible(false);
    }
    
    private void clearOpenDays(){
        mondayCBx.setSelected(false);
        tuesdayCBx.setSelected(false);
        wednesdayCBx.setSelected(false);
        thursdayCBx.setSelected(false);
        fridayCBx.setSelected(false);
        saturdayCBx.setSelected(false);
        sundayCBx.setSelected(false);
    }
    
    private String getDays(){
        ArrayList<Boolean> days = new ArrayList();
        days.add(mondayCBx.isSelected());
        days.add(tuesdayCBx.isSelected());
        days.add(wednesdayCBx.isSelected());
        days.add(thursdayCBx.isSelected());
        days.add(fridayCBx.isSelected());
        days.add(saturdayCBx.isSelected());
        days.add(sundayCBx.isSelected());
        String openDays = "";
        for (int i=0; i<days.size(); i++){
            if (days.get(i) == true){
                openDays = openDays +  Integer.toString(i+1);
            }
        }
        return openDays;
    }
    
    private String getHours(){
        String openHours =""
                          +fromOpenHoursTFld.getText().toString()
                          +"-"
                          +toOpenHoursTFld.getText().toString();
        return openHours;
    }
    
    private void initializeComponents(){
            storeNameTFld.setText("");
            numOfSeatsTFld.setText("0");
            parkingCBx.setSelected(false);
            storeAddressTFld.setText("");
            storeCityTFld.setText("");
            storePhoneTFld.setText("");
            clearOpenDays();
            fromOpenHoursTFld.setText("00:00");
            toOpenHoursTFld.setText("00:00");
            emailTFld.setText("");
    }
    
   private void showFalse(boolean storeNameCheck, boolean storeSeatCheck,
            boolean storeAddressCheck, boolean storeCityCheck, boolean storePhoneCheck,  boolean emailCheck, boolean openDaysCheck, boolean openHoursCheck){
        
                
        if ((storeNameCheck) == false) {
            storeNameFalseLbl.setVisible(true);
        }
        if ((storeSeatCheck) == false) {
            numberOfSeatsFalseLbl.setVisible(true);
        }
        if ((storeAddressCheck) == false) {
            storeAddressFalseLbl.setVisible(true);
        }
        if ((storeCityCheck) == false) {
            storeCityFalseLbl.setVisible(true);
        }
        if((storePhoneCheck) == false) {
            storePhoneFalseLbl.setVisible(true);
        }
        if((emailCheck) == false){
            emailFalseLbl.setVisible(true);
        }
        if ((openDaysCheck) == false) {
            openDaysFalseLbl.setVisible(true);
        }
        if ((openHoursCheck) == false) {
            openHoursFalseLbl.setVisible(true);
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

        storeNameLbl = new javax.swing.JLabel();
        numOfSeatsLbl = new javax.swing.JLabel();
        storeNameTFld = new javax.swing.JTextField();
        numOfSeatsTFld = new javax.swing.JTextField();
        addStoreBtn = new javax.swing.JButton();
        storeAddressLbl = new javax.swing.JLabel();
        storeAddressTFld = new javax.swing.JTextField();
        storeCityLbl = new javax.swing.JLabel();
        storeCityTFld = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        storePhoneTFld = new javax.swing.JTextField();
        storePhoneLbl = new javax.swing.JLabel();
        parkingLbl = new javax.swing.JLabel();
        parkingCBx = new javax.swing.JCheckBox();
        storeNameFalseLbl = new javax.swing.JLabel();
        numberOfSeatsFalseLbl = new javax.swing.JLabel();
        storeAddressFalseLbl = new javax.swing.JLabel();
        storeCityFalseLbl = new javax.swing.JLabel();
        openDaysLbl = new javax.swing.JLabel();
        openHoursLbl = new javax.swing.JLabel();
        fromHourLbl = new javax.swing.JLabel();
        toHourLbl = new javax.swing.JLabel();
        openDaysPnl = new javax.swing.JPanel();
        mondayCBx = new javax.swing.JCheckBox();
        tuesdayCBx = new javax.swing.JCheckBox();
        wednesdayCBx = new javax.swing.JCheckBox();
        thursdayCBx = new javax.swing.JCheckBox();
        fridayCBx = new javax.swing.JCheckBox();
        saturdayCBx = new javax.swing.JCheckBox();
        sundayCBx = new javax.swing.JCheckBox();
        openDaysFalseLbl = new javax.swing.JLabel();
        fromOpenHoursTFld = new javax.swing.JFormattedTextField();
        toOpenHoursTFld = new javax.swing.JFormattedTextField();
        openHoursFalseLbl = new javax.swing.JLabel();
        closeBtn = new javax.swing.JButton();
        emailLbl = new javax.swing.JLabel();
        emailTFld = new javax.swing.JTextField();
        StoreDetailsLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        storeDetailsText = new javax.swing.JTextArea();
        storePhoneFalseLbl = new javax.swing.JLabel();
        emailFalseLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Create Store");
        setName("createStoreFrame"); // NOI18N

        storeNameLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        storeNameLbl.setText("Store name*");
        storeNameLbl.setToolTipText("");
        storeNameLbl.setName(""); // NOI18N

        numOfSeatsLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        numOfSeatsLbl.setText("Number of seats*");

        storeNameTFld.setPreferredSize(new java.awt.Dimension(100, 30));

        numOfSeatsTFld.setText("0");
        numOfSeatsTFld.setPreferredSize(new java.awt.Dimension(40, 30));

        addStoreBtn.setLabel("Save");
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

        storeAddressLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        storeAddressLbl.setText("Address*");

        storeAddressTFld.setToolTipText("");
        storeAddressTFld.setPreferredSize(new java.awt.Dimension(120, 30));

        storeCityLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        storeCityLbl.setText("City*");

        storeCityTFld.setPreferredSize(new java.awt.Dimension(120, 30));
        storeCityTFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeCityTFldActionPerformed(evt);
            }
        });

        storePhoneTFld.setMinimumSize(new java.awt.Dimension(100, 30));
        storePhoneTFld.setPreferredSize(new java.awt.Dimension(100, 30));

        storePhoneLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        storePhoneLbl.setText("Phone");

        parkingLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        parkingLbl.setText("Parking");

        parkingCBx.setPreferredSize(new java.awt.Dimension(30, 30));

        storeNameFalseLbl.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        storeNameFalseLbl.setForeground(new java.awt.Color(204, 0, 0));
        storeNameFalseLbl.setText("false");
        storeNameFalseLbl.setToolTipText("");

        numberOfSeatsFalseLbl.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        numberOfSeatsFalseLbl.setForeground(new java.awt.Color(204, 0, 0));
        numberOfSeatsFalseLbl.setText("false");
        numberOfSeatsFalseLbl.setToolTipText("");

        storeAddressFalseLbl.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        storeAddressFalseLbl.setForeground(new java.awt.Color(204, 0, 0));
        storeAddressFalseLbl.setText("false");
        storeAddressFalseLbl.setToolTipText("");

        storeCityFalseLbl.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        storeCityFalseLbl.setForeground(new java.awt.Color(204, 0, 0));
        storeCityFalseLbl.setText("false");
        storeCityFalseLbl.setToolTipText("");

        openDaysLbl.setFont(storeNameLbl.getFont());
        openDaysLbl.setText("Open Days*");

        openHoursLbl.setFont(storeNameLbl.getFont());
        openHoursLbl.setText("Open Hours*");

        fromHourLbl.setText("From");

        toHourLbl.setText("To");

        mondayCBx.setText("Monday");

        tuesdayCBx.setText("Tuesday");
        tuesdayCBx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesdayCBxActionPerformed(evt);
            }
        });

        wednesdayCBx.setText("Wednesday");

        thursdayCBx.setText("Thursday");

        fridayCBx.setText("Friday");

        saturdayCBx.setText("Saturday");

        sundayCBx.setText("Sunday");

        openDaysFalseLbl.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        openDaysFalseLbl.setForeground(new java.awt.Color(204, 0, 0));
        openDaysFalseLbl.setText("false");
        openDaysFalseLbl.setToolTipText("");

        javax.swing.GroupLayout openDaysPnlLayout = new javax.swing.GroupLayout(openDaysPnl);
        openDaysPnl.setLayout(openDaysPnlLayout);
        openDaysPnlLayout.setHorizontalGroup(
            openDaysPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, openDaysPnlLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(openDaysPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(openDaysPnlLayout.createSequentialGroup()
                        .addComponent(mondayCBx, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tuesdayCBx))
                    .addGroup(openDaysPnlLayout.createSequentialGroup()
                        .addComponent(fridayCBx)
                        .addGap(18, 18, 18)
                        .addComponent(saturdayCBx)))
                .addGap(13, 13, 13)
                .addGroup(openDaysPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wednesdayCBx)
                    .addComponent(sundayCBx))
                .addGap(18, 18, 18)
                .addGroup(openDaysPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(openDaysFalseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thursdayCBx))
                .addContainerGap())
        );
        openDaysPnlLayout.setVerticalGroup(
            openDaysPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, openDaysPnlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(openDaysPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mondayCBx)
                    .addComponent(tuesdayCBx)
                    .addComponent(wednesdayCBx)
                    .addComponent(thursdayCBx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(openDaysPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(openDaysPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fridayCBx)
                        .addComponent(saturdayCBx)
                        .addComponent(sundayCBx))
                    .addComponent(openDaysFalseLbl))
                .addGap(22, 22, 22))
        );

        fromOpenHoursTFld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
        fromOpenHoursTFld.setText("00:00");
        fromOpenHoursTFld.setToolTipText("Enter 24hour format (HH:mm).");
        fromOpenHoursTFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromOpenHoursTFldActionPerformed(evt);
            }
        });

        toOpenHoursTFld.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
        toOpenHoursTFld.setText("00:00");
        toOpenHoursTFld.setToolTipText("Enter 24hour format (HH:mm).");

        openHoursFalseLbl.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        openHoursFalseLbl.setForeground(new java.awt.Color(204, 0, 0));
        openHoursFalseLbl.setText("false");
        openHoursFalseLbl.setToolTipText("");

        closeBtn.setText("Close");
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

        emailLbl.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        emailLbl.setText("E-mail");

        emailTFld.setMinimumSize(new java.awt.Dimension(100, 30));
        emailTFld.setPreferredSize(new java.awt.Dimension(100, 30));

        StoreDetailsLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        StoreDetailsLabel.setText("Store Details");

        storeDetailsText.setColumns(20);
        storeDetailsText.setRows(5);
        jScrollPane1.setViewportView(storeDetailsText);

        storePhoneFalseLbl.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        storePhoneFalseLbl.setForeground(new java.awt.Color(204, 0, 0));
        storePhoneFalseLbl.setText("false");
        storePhoneFalseLbl.setToolTipText("");

        emailFalseLbl.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        emailFalseLbl.setForeground(new java.awt.Color(204, 0, 0));
        emailFalseLbl.setText("false");
        emailFalseLbl.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addStoreBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeBtn)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(storeAddressLbl)
                            .addComponent(storeCityLbl)
                            .addComponent(storePhoneLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(storeCityTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(storeCityFalseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(storePhoneTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(emailTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(storePhoneFalseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(emailFalseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(storeAddressTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(storeAddressFalseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(StoreDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fromHourLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fromOpenHoursTFld, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(toHourLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(toOpenHoursTFld, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(openHoursFalseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(openHoursLbl)
                    .addComponent(openDaysLbl)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(numOfSeatsLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(numOfSeatsTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberOfSeatsFalseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(parkingLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(parkingCBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(storeNameLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(storeNameTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(storeNameFalseLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(emailLbl)
                    .addComponent(openDaysPnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(storeNameTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storeNameLbl)
                    .addComponent(storeNameFalseLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(parkingCBx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(numOfSeatsTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(numOfSeatsLbl)
                        .addComponent(parkingLbl)
                        .addComponent(numberOfSeatsFalseLbl)))
                .addGap(26, 26, 26)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(storeAddressTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(storeAddressLbl)
                    .addComponent(storeAddressFalseLbl)
                    .addComponent(StoreDetailsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(storeCityTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(storeCityLbl)
                            .addComponent(storeCityFalseLbl))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(storePhoneTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(storePhoneLbl))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(emailLbl)
                                    .addComponent(emailTFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailFalseLbl)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(storePhoneFalseLbl)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(openDaysLbl))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(openDaysPnl, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openHoursLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromHourLbl)
                    .addComponent(toHourLbl)
                    .addComponent(fromOpenHoursTFld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toOpenHoursTFld, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(openHoursFalseLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStoreBtn)
                    .addComponent(closeBtn))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addStoreBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addStoreBtnMouseClicked
        // TODO add your handling code here:
        String storeName = storeNameTFld.getText();
        int numOfSeats = Integer.parseInt(numOfSeatsTFld.getText());
        String storeAddress = storeAddressTFld.getText();
        String storeCity = storeCityTFld.getText();
        String storePhone = storePhoneTFld.getText();
        boolean parking = parkingCBx.isSelected();
        String openDays = getDays();
        String openHours = getHours();
        String email = emailTFld.getText();
        String storeDetails = storeDetailsText.getText();

        falseLabelsNoVisible();
        //Giota
        StoreOwnerController soc = new StoreOwnerController();
        
        CreateStoreController storeControl = new CreateStoreController(new StoreDAO());
        boolean storeNameCheck = storeControl.checkNameOfStore(storeName);
        boolean storeSeatCheck = storeControl.checkNumberOfSeats(numOfSeats);
        boolean storeAddressCheck = storeControl.checkStoreAddress(storeAddress);
        boolean storeCityCheck = storeControl.checkStoreCity(storeCity);
        boolean storePhoneCheck = storeControl.checkStorePhone(storePhone);
        boolean emailCheck = storeControl.checkEmail(email);
        boolean openDaysCheck = storeControl.checkOpenDays(openDays);
        boolean openHoursCheck = storeControl.checkOpenHours(openHours);

        ICreateStoreController myStoreController = new CreateStoreController(new StoreDAO());

        boolean existStoreResult = myStoreController.checkIfStoreExists(storeName, storeAddress);

        if (existStoreResult == true)
            JOptionPane.showMessageDialog(rootPane, "Store already exists in the database!");

        
        boolean validationResult = myStoreController.storeCreation(storeName, numOfSeats, parking,
                storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);

        if (validationResult == true && existStoreResult == false) {
            //Giota
            Integer storeid = myStoreController.storeIdRet(storeName);
            if(soc.addStoreOwnerController(userId, storeid)){
            JOptionPane.showMessageDialog(rootPane, "Store Created Succesfully And StoreOwner saved to database");   
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Store Created Succesfully but StoreOwner had a problem");   
    
            }
            initializeComponents();   
        } else {
            JOptionPane.showMessageDialog(rootPane, "Store Creation Failed\n");
            showFalse(storeNameCheck, storeSeatCheck, storeAddressCheck,
                    storeCityCheck, storePhoneCheck, emailCheck, openDaysCheck, openHoursCheck);
        }
    }//GEN-LAST:event_addStoreBtnMouseClicked

    private void addStoreBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStoreBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addStoreBtnActionPerformed

    private void storeCityTFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeCityTFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_storeCityTFldActionPerformed

    private void tuesdayCBxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesdayCBxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tuesdayCBxActionPerformed

    private void fromOpenHoursTFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromOpenHoursTFldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromOpenHoursTFldActionPerformed

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        if(flag==0){
            LoginForm main = new LoginForm();
            main.setVisible(true);
            this.dispose();
        }else{
            StoreManagmentForm storeManagF= new StoreManagmentForm();
            storeManagF.setVisible(true);
            this.dispose();
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_closeBtnMouseClicked

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_closeBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CreateStoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateStoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateStoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateStoreForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateStoreForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StoreDetailsLabel;
    private javax.swing.JButton addStoreBtn;
    private javax.swing.JButton closeBtn;
    private javax.swing.JLabel emailFalseLbl;
    private javax.swing.JLabel emailLbl;
    private javax.swing.JTextField emailTFld;
    private javax.swing.JCheckBox fridayCBx;
    private javax.swing.JLabel fromHourLbl;
    private javax.swing.JFormattedTextField fromOpenHoursTFld;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox mondayCBx;
    private javax.swing.JLabel numOfSeatsLbl;
    private javax.swing.JTextField numOfSeatsTFld;
    private javax.swing.JLabel numberOfSeatsFalseLbl;
    private javax.swing.JLabel openDaysFalseLbl;
    private javax.swing.JLabel openDaysLbl;
    private javax.swing.JPanel openDaysPnl;
    private javax.swing.JLabel openHoursFalseLbl;
    private javax.swing.JLabel openHoursLbl;
    private javax.swing.JCheckBox parkingCBx;
    private javax.swing.JLabel parkingLbl;
    private javax.swing.JCheckBox saturdayCBx;
    private javax.swing.JLabel storeAddressFalseLbl;
    private javax.swing.JLabel storeAddressLbl;
    private javax.swing.JTextField storeAddressTFld;
    private javax.swing.JLabel storeCityFalseLbl;
    private javax.swing.JLabel storeCityLbl;
    private javax.swing.JTextField storeCityTFld;
    private javax.swing.JTextArea storeDetailsText;
    private javax.swing.JLabel storeNameFalseLbl;
    private javax.swing.JLabel storeNameLbl;
    private javax.swing.JTextField storeNameTFld;
    private javax.swing.JLabel storePhoneFalseLbl;
    private javax.swing.JLabel storePhoneLbl;
    private javax.swing.JTextField storePhoneTFld;
    private javax.swing.JCheckBox sundayCBx;
    private javax.swing.JCheckBox thursdayCBx;
    private javax.swing.JLabel toHourLbl;
    private javax.swing.JFormattedTextField toOpenHoursTFld;
    private javax.swing.JCheckBox tuesdayCBx;
    private javax.swing.JCheckBox wednesdayCBx;
    // End of variables declaration//GEN-END:variables
}