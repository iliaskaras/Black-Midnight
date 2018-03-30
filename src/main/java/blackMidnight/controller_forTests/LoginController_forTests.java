/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller_forTests;

import blackMidnight.DAO_forTests.LoginDAO_Test;

/**
 *
 * @author Ilias
 */
public class LoginController_forTests {
    
    static private LoginDAO_Test ld = new LoginDAO_Test();
    
    public Integer userLoginController(String username, String password){
        Integer userId=0;
        try{
            userId=ld.userLogin(username, password);
        }catch(Exception e){
            System.out.println("error"+e);
        }
        return userId;
    }
    
    public Integer ownerLoginController(Integer userId){
        Integer ownerId=0;
        try{
            ownerId=ld.ownerLogin(userId);
        }catch(Exception e){
            System.out.println("error"+e);
        }
        return ownerId;
    }
}
