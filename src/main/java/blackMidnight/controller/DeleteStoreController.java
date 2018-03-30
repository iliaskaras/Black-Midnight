/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.DAO.IStoreDAO;
import blackMidnight.DAO.StoreDAO;
import blackMidnight.model.Store;

/**
 *
 * @author Ilias
 */
public class DeleteStoreController implements IDeleteStoreController {
   
    @Override
    public boolean deleteStore(Store myStore){
        IStoreDAO myStoreDAO = new StoreDAO();
        boolean successDel = myStoreDAO.deleteStore(myStore);
        if(successDel==true)
            return true;
        else 
            return false;
    }
    
    
    
}
