/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller_forTests;

import blackMidnight.DAO.IStoreChooserForReservationDAO;
import blackMidnight.DAO.StoreChooserForReservationDAO;
import blackMidnight.DAO_forTests.StoreChooserForReservationDAO_forTest;
import blackMidnight.model.Store;
import blackMidnight.model_forTests.Store_Test;
import java.util.List;

/**
 *
 * @author Ilias
 */
public class StoreChooserForReservationController_forTests {
    
     private StoreChooserForReservationDAO_forTest reservationDAO = new StoreChooserForReservationDAO_forTest();
    
   
    public List<Store_Test> getStores(){
        List<Store_Test> stores;
        
        stores = reservationDAO.getStores();
        
        return stores;
    }
    
    public List<Store_Test> getStoreDetails(String storeName,String storeAddress){
        List<Store_Test> stores;
        
        stores = reservationDAO.getStoreDetails(storeName,storeAddress);
        
        return stores;
    }
    
    public List<Store_Test> getStoresOpenHours(String storeName,String storeAddress){
        List<Store_Test> stores;
        
        stores = reservationDAO.getStoreDetails(storeName,storeAddress);
        
        return stores;
    }
}
