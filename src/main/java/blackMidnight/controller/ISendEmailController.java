/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller;

import java.net.PasswordAuthentication;

/**
 *
 * @author Ilias
 */
public interface ISendEmailController {
    
    public String readFromRegisterUsersLogEmail(String Username) throws Exception;
    public boolean sendToCustomerNotificationEmail(String email,String reservationCode,String storeName,String customerName,String date) throws Exception;
    public String readFromStoreListEmail(String storeName) throws Exception;
    public boolean sendToStoreManagerNotificationEmail(String email,String reservationCode,String storeName,String customerName,String date,String numberOfSeats) throws Exception;
    public boolean sendToBlackMidnightQuestionEmail(String username,String questionText) throws Exception;
  
    
}
