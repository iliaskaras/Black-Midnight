/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;

import blackMidnight.model.Store;
import blackMidnight.model_forTests.Store_Test;

/**
 *
 * @author Ilias
 */
public interface IStoreDAO {

    /**
     *
     * @param st The name of the store object.
     * @return true if file is writen or false if not.
     */
    boolean addStore(Store st);
    boolean editStore(Store myStore);
    public boolean deleteStore(Store myStore);
    public boolean addStoreForTest(Store_Test st);
    public boolean storeExist(String storeName, String storeAddress);
    Integer storeIdReturn(String storename);
}
