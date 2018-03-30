/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.model.Item;
import blackMidnight.model_forTests.Item_Test;

/**
 *
 * @author Ilias
 */
public interface IDeleteItemController {

    boolean deleteItem(Item myItem);

    boolean deleteItemForTest(Item_Test myItem);
    
}
