/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller;

import blackMidnight.DAO.ISendEmailDAO;
import blackMidnight.DAO.SendEmailDAO;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Ilias
 */
public class SendEmailController implements ISendEmailController{
     private ISendEmailDAO SendEmailNotificationDAO = new SendEmailDAO();
 
     //* we search the mail of given username and returns it. *//
    @Override
    public String readFromRegisterUsersLogEmail(String Username) throws Exception{
        String email;
        String result;
        try{
            email = SendEmailNotificationDAO.readFromRegisterUsersLogEmail(Username);
            if(email.equals("")){
                result = "";
                System.out.println("Mail dont exist");
            }else{
                result = email;
                System.out.println("Usernames's email:"+Username+ "\t :"+email);
            }
        } catch (Exception ex){
            result = null;
            System.out.println(ex);
        }

        return result;
    }
    
    //* we search the mail of given store name and returns it. *//
    @Override
    public String readFromStoreListEmail(String storeName) throws Exception{
        String email;
        String result;
        try{
            email = SendEmailNotificationDAO.readFromStoreListEmail(storeName);
            if(email.equals("")){
                result = "";
                System.out.println("Mail dont exist");
            }else{
                result = email;
                System.out.println("Store's email:"+storeName+ "\t :"+email);
            }
        } catch (Exception ex){
            result = null;
            System.out.println(ex);
        }

        return result;
    }
    
    //* we give the customer's email, reservationCode that created from reservation, store Name, customer Name and date. And we send the proper Notification Email *//
    @Override
    public boolean sendToCustomerNotificationEmail(String email,String reservationCode,String storeName,String customerName,String date) throws Exception{
        String emailTo = email;
        final String emailFrom = "BlackMidnightClubs@gmail.com";
        final String emailFromPassword = "blackmidnight";
        boolean result;
        
        /* We determine the current system's properties */
        /* Properties is a class that represents a set of properties */
        Properties prop = System.getProperties();
        
        /* we are setting the properties, example : mail.smtp.auth = true */
        /* method put is a method from hashtable class */
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable","true"); //* enables us to use tranfer layer security *//
        prop.put("mail.smtp.host", "smtp.gmail.com"); //* we spesifie the host name sock server  we will use for the connection to mail server *//
        prop.put("mail.smtp.port", "587"); //* Port for the smtp server is 587 , while using TLS *//
       
        
        
        Session session = Session.getInstance(prop,new javax.mail.Authenticator() {
            
                 protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(emailFrom,emailFromPassword);
                 }
           });
        
         try {
            //* MimeMessage object. MIME style email message , uses the InternetHeaders class *//
            MimeMessage message = new MimeMessage(session);
            // Set Header from field of the header.
            message.setFrom(new InternetAddress("BlackMidnightClubs@gmail.com"));
            // Set Header to field of the header.
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(emailTo));
            // The subject message 
            message.setSubject("Notification email by Black-Midnight");
            // The actual message
            message.setContent("<h:body style=background-color :white;font-family:verdana;color:#0066CC;>"
                    + customerName +" your reservation added, go to "+ storeName+" with the code : "+reservationCode+" at date :"+date+"<br/><br/>"
                    + "</body>", "text/html; charset=utf-8");
            // Send message
            try{
                Transport.send(message);
                System.out.println("Mail to customer was sent successfully...");
                result = true;
                }catch (Exception ex){
                    System.out.println("Mail to customer was failed to sent");
                    result = false;
                }
        } catch (MessagingException e) {
            result = false;
            throw new RuntimeException(e);
        }
        return result;
    }
    
    //* we give the customer's email, reservationCode that created from reservation, store Name, customer Name and date. And we send the proper Notification Email *//
    @Override
    public boolean sendToStoreManagerNotificationEmail(String email,String reservationCode,String storeName,String customerName,String date,String numberOfSeats) throws Exception{
        String emailTo = email;
        final String emailFrom = "BlackMidnightClubs@gmail.com";
        final String emailFromPassword = "blackmidnight";
        boolean result;
        
        /* We determine the current system's properties */
        /* Properties is a class that represents a set of properties */
        Properties prop = System.getProperties();
        
        /* we are setting the properties, example : mail.smtp.auth = true */
        /* method put is a method from hashtable class */
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable","true"); //* enables us to use tranfer layer security *//
        prop.put("mail.smtp.host", "smtp.gmail.com"); //* we spesifie the host name sock server  we will use for the connection to mail server *//
        prop.put("mail.smtp.port", "587"); //* Port for the smtp server is 587 , while using TLS *//
       
        
        
        Session session = Session.getInstance(prop,new javax.mail.Authenticator() {
            
                 protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(emailFrom,emailFromPassword);
                 }
           });
        
         try {
            //* MimeMessage object. MIME style email message , uses the InternetHeaders class *//
            MimeMessage message = new MimeMessage(session);
            // Set Header from field of the header.
            message.setFrom(new InternetAddress("BlackMidnightClubs@gmail.com"));
            // Set Header to field of the header.
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(emailTo));
            // The subject message 
            message.setSubject("Notification email by Black-Midnight");
            // The actual message
            message.setContent("<h:body style=background-color :white;font-family:verdana;color:#0066CC;>"
                    + storeName +" Reservation added for you from "+ customerName+" with the code : "+reservationCode+" at date :"+date+" for : " +numberOfSeats +"seats <br/><br/>"
                    + "</body>", "text/html; charset=utf-8");
            // Send message
            try{
                Transport.send(message);
                System.out.println("Mail to store manager was sent successfully...");
                result = true;
                }catch (Exception ex){
                    System.out.println("Mail to store manager was failed to sent");
                    result = false;
                }
        } catch (MessagingException e) {
            result = false;
            throw new RuntimeException(e);
        }
        return result;
    }
    
     //* we give the customer's email, reservationCode that created from reservation, store Name, customer Name and date. And we send the proper Notification Email *//
    @Override
    public boolean sendToBlackMidnightQuestionEmail(String username,String questionText) throws Exception{
        String emailTo = "BlackMidnightClubsQuestions@gmail.com";
        final String emailFrom = "BlackMidnightClubs@gmail.com";
        final String emailFromPassword = "blackmidnight";
        boolean result;
        
        if(questionText.equals("") || username.equals(""))
            return false;
        /* We determine the current system's properties */
        /* Properties is a class that represents a set of properties */
        Properties prop = System.getProperties();
        
        /* we are setting the properties, example : mail.smtp.auth = true */
        /* method put is a method from hashtable class */
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable","true"); //* enables us to use tranfer layer security *//
        prop.put("mail.smtp.host", "smtp.gmail.com"); //* we spesifie the host name sock server  we will use for the connection to mail server *//
        prop.put("mail.smtp.port", "587"); //* Port for the smtp server is 587 , while using TLS *//
       
        
        
        Session session = Session.getInstance(prop,new javax.mail.Authenticator() {
            
                 protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                    return new javax.mail.PasswordAuthentication(emailFrom,emailFromPassword);
                 }
           });
        
         try {
            //* MimeMessage object. MIME style email message , uses the InternetHeaders class *//
            MimeMessage message = new MimeMessage(session);
            // Set Header from field of the header.
            message.setFrom(new InternetAddress("BlackMidnightClubs@gmail.com"));
            // Set Header to field of the header.
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(emailTo));
            // The subject message 
            message.setSubject("Question email to Black-Midnight");
            // The actual message
            message.setContent("<h:body style=background-color :white;font-family:verdana;color:#0066CC;>"
                    + username +" asks the following :  "+ questionText +"<br/><br/>"
                    + "</body>", "text/html; charset=utf-8");
            // Send message
            try{
                Transport.send(message);
                result = true;
                }catch (Exception ex){
                    result = false;
                }
        } catch (MessagingException e) {
            result = false;
            throw new RuntimeException(e);
        }
        return result;
    }
    
}
