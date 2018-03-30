/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.DAO.LoginDAO;

/**
 *
 * @author Ilias
 */
public class LoginController implements ILoginController {
    static private LoginDAO ld = new LoginDAO();
    @Override
    public Integer userLoginController(String username, String password){
        Integer userId=0;
        try{
            userId=ld.userLogin(username, password);
        }catch(Exception e){
            System.out.println("error"+e);
        }
        return userId;
    }
    @Override
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
