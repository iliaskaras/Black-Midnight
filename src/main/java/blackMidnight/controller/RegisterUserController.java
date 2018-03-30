/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.DAO.IUserDAO;
import blackMidnight.DAO.UserDAO;
import blackMidnight.model.User;

/**
 *
 * @author Ilias
 */
public class RegisterUserController implements IRegisterUserController {
  public static   IUserDAO iud = new UserDAO();
    /**
     *
     * @param user
     * @return true if all fields entered correctly
     */
    @Override
    public boolean registerUserController(User user){
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
            if(answer==true && iud.userIdReturn(user.getUsername())==0){
                
                iud.addUser(user);
            }
                
        }catch(Exception e){
            System.out.println("error");
            
        }
        return answer;
        
    }
    @Override
        public boolean editUserController(User user){
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
            if(answer==true){
                iud.updateUser(user.getUsername(),user.getUserFirstName(),user.getUserLastName(),user.getPhoneNumber(),user.getPassword(),user.getUsermail());
            }
                
        }catch(Exception e){
            System.out.println("error");
        }
        return answer;
    }
  @Override
     public boolean deleteUserController(String username){
        boolean answer=false;
        try{
           Integer userId= iud.userIdReturn(username);
            if(userId!=0){
                iud.deleteUser(userId);
                answer=true;
            }
        }catch(Exception e){
            System.out.println("error");
        }
        return answer;
     }
}
