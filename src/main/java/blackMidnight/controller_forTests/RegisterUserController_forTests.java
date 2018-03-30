/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller_forTests;

import blackMidnight.DAO_forTests.UserDAO_Test;
import blackMidnight.model_forTests.User_Test;

/**
 *
 * @author Ilias
 */
public class RegisterUserController_forTests {
    public static   UserDAO_Test iud = new UserDAO_Test();
    /**
     *
     * @param user
     * @return true if all fields entered correctly
     */
    public boolean registerUserControllerForTests(User_Test user){
        boolean answer=true;
        try{
            if(user.getUsername().contentEquals("")||user.getUsername().length()>15)
                answer=false;
            if(user.getPassword().contentEquals(""))
                answer=false;
            if(user.getUserFirstName().contentEquals("")||user.getUserFirstName().length()>10)
                answer=false;
            if(user.getPhoneNumber().length()!=10)
                answer=false;
             if(answer==true && iud.userIdReturnForTests(user.getUsername())==0){
                
                iud.addUserTest(user);
            }
        }catch(Exception e){
            System.out.println("error");
            
        }
        return answer;
        
    }
    public boolean editUserControllerForTests(User_Test user){
        boolean answer=true;
        try{
            if(user.getUsername().contentEquals("")||user.getUsername().length()>15)
                answer=false;
            if(user.getPassword().contentEquals(""))
                answer=false;
            if(user.getUserFirstName().contentEquals("")||user.getUserFirstName().length()>10)
                answer=false;
            if(user.getPhoneNumber().length()!=10)
                answer=false;
              
        }catch(Exception e){
            System.out.println("error");
        }
        return answer;
    }
     public boolean deleteUserControllerForTests(String username){
        boolean answer=false;
        UserDAO_Test iud = new UserDAO_Test();
        try{
           Integer userId= iud.userIdReturnForTests(username);
            if(userId!=0){
                iud.deleteUserTestForTests(userId);
                answer=true;
            }
        }catch(Exception e){
            System.out.println("error");
        }
        return answer;
     }
     public boolean MockdeleteUserControllerForTests(String username){
         boolean answer=false;
         if(!"".equals(username))
             answer=true;
         return answer;   
     }
}
