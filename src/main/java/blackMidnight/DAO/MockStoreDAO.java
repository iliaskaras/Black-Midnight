/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;

import blackMidnight.model.Store;
import blackMidnight.model_forTests.Store_Test;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ilias
 */
public class MockStoreDAO implements IStoreDAO{
    List<Store> stores = new ArrayList<Store>();
   
    @Override
    public boolean addStore(Store st) {
        stores.add(st);
        return true;
    }
    
    @Override
    public boolean editStore(Store store){
        return true;
    }
    
    @Override
    public boolean deleteStore(Store myStore){
        return true;
    }

    @Override
    public boolean addStoreForTest(Store_Test st) {
        return true;
    }

    @Override
    public Integer storeIdReturn(String storename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean storeExist(String storeName, String storeAddress) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
