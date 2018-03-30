/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import blackMidnight.model.Store;
import java.util.List;

/**
 *
 * @author Ilias
 */
public interface IStoreChooserForReservationDAO {
    
    public List<Store> getStores();
    public List<Store> getStoreDetails(String nameOfStore,String storeAddress);
   
}
