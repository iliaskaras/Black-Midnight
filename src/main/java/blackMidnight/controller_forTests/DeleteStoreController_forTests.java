/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller_forTests;

import blackMidnight.DAO_forTests.StoreDAO_Test;
import blackMidnight.model_forTests.Store_Test;

/**
 *
 * @author Ilias
 */
public class DeleteStoreController_forTests {
    
    public boolean deleteStore(Store_Test myStore){
        StoreDAO_Test myStoreDAO = new StoreDAO_Test();
        boolean successDel = myStoreDAO.deleteStore(myStore);
        if(successDel==true)
            return true;
        else 
            return false;
    }
}
