/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.DAO.IItemManagementDAO;
import blackMidnight.DAO.ItemManagementDAO;
import blackMidnight.model.Item;
import java.util.List;

/**
 *
 * @author Ilias
 */
public class ItemManagementController implements IItemManagementController {
    
       private IItemManagementDAO managementDAO = new ItemManagementDAO();
    
    @Override
    public List<Item> getItems() {
        List<Item> itemsList;
        
        itemsList = managementDAO.getItems();
        
        return itemsList;
    }
    
    
}
