/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

/**
 *
 * @author Ilias
 */
public interface IAddItemController {

    boolean addItem(String itemName, String itemType, int itemPrice, int itemQuantity) throws Exception;

    boolean addItemForTest(String itemName, String itemType, int itemPrice, int itemQuantity) throws Exception;

    boolean checkItemName(String itemName);

    boolean checkItemPrice(int itemPrice);

    boolean checkItemQuantity(int itemQuantity);

    boolean checkItemType(String itemType);

    boolean itemCheck(String itemName, String itemType, int itemPrice, int itemQuantity);
    
}
