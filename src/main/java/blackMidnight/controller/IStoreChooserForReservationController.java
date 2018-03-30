/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller;

import blackMidnight.model.Store;
import java.util.List;

/**
 *
 * @author Ilias
 */
public interface IStoreChooserForReservationController {
    
    
    public List<Store> getStores();
    public List<Store> getStoreDetails(String storeName,String storeAddress);
    public List<Store> getStoresOpenHours(String storeName, String storeAddress);
    
}
