/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller;

import blackMidnight.DAO.IStoreChooserForReservationDAO;
import blackMidnight.DAO.StoreChooserForReservationDAO;
import blackMidnight.model.Store;
import java.util.List;

/**
 *
 * @author Ilias
 */
public class StoreChooserForReservationController implements IStoreChooserForReservationController {
    
    private IStoreChooserForReservationDAO reservationDAO = new StoreChooserForReservationDAO();
    
    @Override
    public List<Store> getStores(){
        List<Store> stores;
        
        stores = reservationDAO.getStores();
        
        return stores;
    }
    @Override
    public List<Store> getStoreDetails(String storeName,String storeAddress){
        List<Store> stores;
        
        stores = reservationDAO.getStoreDetails(storeName,storeAddress);
        
        return stores;
    }
    
    @Override
    public List<Store> getStoresOpenHours(String storeName,String storeAddress){
        List<Store> stores;
        
        stores = reservationDAO.getStoreDetails(storeName,storeAddress);
        
        return stores;
    }
}
