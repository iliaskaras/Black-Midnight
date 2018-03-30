/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import java.util.Calendar;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author Ilias
 */
public class BookingConfirmationController {


 public static void main(String[] args) {

       // String text=msgBox();
       // System.out.println(text);

    }
    
    //Minima gia thn epiveveosi tis kratisis
public static void msgBox(String uuid){
    Calendar cal = Calendar.getInstance();
    JOptionPane.showMessageDialog(null,"Η ΚΡΑΤΗΣΗ ΣΑΣ ΠΡΑΓΜΑΤΟΠΟΙΗΘΗΚΕ ΕΠΙΤΥΧΩΣ!!\n"+"ΜΕ ΚΩΔΙΚΟ:"+uuid+"\n ΗΜΕΡΟΜΗΝΙΑ:"+cal.getTime());
}
    //Dinoume to uuid tis kratisis
public static String uuid(){
    String uuid = UUID.randomUUID().toString().substring(30);
   
    return uuid;
}

public static void msgBoxForTests(String uuid){
    Calendar cal = Calendar.getInstance();
    JOptionPane.showMessageDialog(null,"Η ΚΡΑΤΗΣΗ ΣΑΣ ΠΡΑΓΜΑΤΟΠΟΙΗΘΗΚΕ ΕΠΙΤΥΧΩΣ!!");
}
   
}
  
    
   

