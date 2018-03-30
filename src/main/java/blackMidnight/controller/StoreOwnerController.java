/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.DAO.StoreOwnerDAO;
import blackMidnight.model.StoreOwner;

/**
 *
 * @author Ilias
 */
public class StoreOwnerController {
    public boolean addStoreOwnerController(Integer userID,Integer storeId){
        boolean answer=true;
        StoreOwnerDAO sod = new StoreOwnerDAO();
        try{
            if(userID==0)
                answer=false;
            if(storeId==0)
                answer=false;
            if(answer==true){
                
               answer=sod.addStoreOwner(userID,storeId);
            }
                
        }catch(Exception e){
            System.out.println("error");
            
        }
        return answer;
        
    }
    
}
