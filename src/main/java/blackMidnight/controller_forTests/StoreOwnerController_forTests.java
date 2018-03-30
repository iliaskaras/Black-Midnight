/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller_forTests;

import blackMidnight.DAO_forTests.StoreOwnerDAO_forTest;

/**
 *
 * @author Ilias
 */
public class StoreOwnerController_forTests {
    
    public boolean addStoreOwnerController(Integer userID,Integer storeId){
        boolean answer=true;
        StoreOwnerDAO_forTest sod = new StoreOwnerDAO_forTest();
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
