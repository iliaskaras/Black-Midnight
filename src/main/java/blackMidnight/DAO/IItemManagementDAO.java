/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;

import blackMidnight.model.Item;
import java.util.List;

/**
 *
 * @author Ilias
 */
public interface IItemManagementDAO {

    List<Item> getItems();
    
}
