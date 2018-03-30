/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.DAO.IStoreManagementDAO;
import blackMidnight.DAO.StoreManagementDAO;
import blackMidnight.model.Store;
import java.util.List;

/**
 *
 * @author Ilias
 */
public class StoreManagementController implements IStoreManagementController{

    private IStoreManagementDAO managementDAO = new StoreManagementDAO();
    
    @Override
    public List<Store> getStores() {
        List<Store> storesList;
        
        storesList = managementDAO.getStores();
        
        return storesList;
    }
    
}
