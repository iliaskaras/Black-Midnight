/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.DAO.IItemDAO;
import blackMidnight.DAO.ItemDAO;
import blackMidnight.model.Item;
import blackMidnight.model_forTests.Item_Test;

/**
 *
 * @author Ilias
 */
public class DeleteItemController implements IDeleteItemController {
    
              
          @Override
    public boolean deleteItem(Item myItem){
        IItemDAO myDeleteItemDAO = new ItemDAO();
        boolean successDel = myDeleteItemDAO.deleteItem(myItem);
        if(successDel==true)
            return true;
        else 
            return false;
    }
   
    @Override
      public boolean deleteItemForTest(Item_Test myItem){
        IItemDAO myDeleteReservationDAO = new ItemDAO();
        boolean successDel = myDeleteReservationDAO.deleteItemForTest(myItem);
        if(successDel==true)
            return true;
        else 
            return false;
    }


    
}
