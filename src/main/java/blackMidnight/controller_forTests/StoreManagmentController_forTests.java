/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller_forTests;

import blackMidnight.DAO_forTests.StoreManagementDAO_forTest;
import blackMidnight.model_forTests.Store_Test;
import java.util.List;

/**
 *
 * @author Ilias
 */
public class StoreManagmentController_forTests {
    
    private StoreManagementDAO_forTest managementDAO = new StoreManagementDAO_forTest();
    
    
    public List<Store_Test> getStores() {
        List<Store_Test> storesList;
        
        storesList = managementDAO.getStores();
        
        return storesList;
    }
}
