/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller_forTests;

import blackMidnight.DAO_forTests.SendEmailNotificationDAO_forTest;

/**
 *
 * @author Ilias
 */
public class SendEmailNotificationController_forTests {
     private SendEmailNotificationDAO_forTest SendEmailNotificationDAO = new SendEmailNotificationDAO_forTest();
     
       //* we search the mail of given username and returns it. *//
    public String readFromRegisterUsersLogEmailForTests(String Username) throws Exception{
        String email;
        String result;
        try{
            email = SendEmailNotificationDAO.readFromRegisterUsersLogEmailForTests(Username);
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
    public String readFromStoreListEmailForTests(String storeName) throws Exception{
        String email;
        String result;
        try{
            email = SendEmailNotificationDAO.readFromStoreListEmailForTests(storeName);
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
}
