/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.model.Item;
import blackMidnight.DAO.IItemDAO;
import blackMidnight.DAO.ItemDAO;
import blackMidnight.model_forTests.Item_Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Ilias
 */
public class AddItemController implements IAddItemController  {
         private IItemDAO reservationDAO = new ItemDAO();
         
          
       
           
    @Override
    /**
     *
     * @param itemName The name of the item that will be created.
     * @param itemType The type of the item that will be created.
     * @param itemPrice The price of the time.
     * @param itemQuantity The quantity of the item.
     .
     * @return true if the item was added or false if was not.
     */
    public boolean addItem(String itemName, String itemType, int itemPrice, int itemQuantity)
                throws Exception{
     
        Item myItem = new Item();
        myItem.setItemName(itemName);
        myItem.setItemType(itemType);
        myItem.setItemPrice(itemPrice);
        myItem.setItemQuantity(itemQuantity);
        String toCheck = "";
        
        
      /* Switch this to itemQuantityCheck  
        
        try{
            String itemQuantityLeft;
            if(StoreSeatAvailabilityDAO.checkIfRowForSpecificDayReservationExists(newReservation.getStoreName(),newReservation.getDate())==true){
                seatsAvailableLeft = StoreSeatAvailabilityDAO.checkIfStoreSeatAvailableAtSpecificDay(newReservation.getNumberOfSeats(), newReservation.getStoreName(),newReservation.getDate());
                if(Integer.parseInt(seatsAvailableLeft)>0){
                    System.out.println("Your required seats are available!\n");
                } else if (seatsAvailableLeft.equals("unavailablySeats"))
                        return false;
            }
         } catch (Exception e) {
                System.out.println(e);
                return false;
         }  */
       
       
        
            try{
             boolean rChecks = true;
             rChecks = itemCheck(itemName,itemType,itemPrice,itemQuantity);
             if(rChecks == false){
                 System.out.println("Something wrong with itemName, itemType, itemPrice or itemQuantity");
                 return false;
             } else {
                 System.out.println(" itemName , itemType , itemPrice and itemQuanity are ok");
             }
         } catch (Exception e){
                 System.out.println(e);
         }
         
        
         
         try{
             boolean result = true;
             result = reservationDAO.addItem(myItem);
             
             if(result == false)
                return false;
             else 
                return true;
             
         }catch (Exception ex){
             System.out.println("Database Not Found!"); 
             return false;
         }
    }
    
    @Override
    public boolean addItemForTest(String itemName, String itemType, int itemPrice, int itemQuantity)
                throws Exception{
     
        Item_Test myItem = new Item_Test();
        myItem.setItemName(itemName);
        myItem.setItemType(itemType);
        myItem.setItemPrice(itemPrice);
        myItem.setItemQuantity(itemQuantity);
        String toCheck = "";
        
        
      /* Switch this to itemQuantityCheck  
        
        try{
            String itemQuantityLeft;
            if(StoreSeatAvailabilityDAO.checkIfRowForSpecificDayReservationExists(newReservation.getStoreName(),newReservation.getDate())==true){
                seatsAvailableLeft = StoreSeatAvailabilityDAO.checkIfStoreSeatAvailableAtSpecificDay(newReservation.getNumberOfSeats(), newReservation.getStoreName(),newReservation.getDate());
                if(Integer.parseInt(seatsAvailableLeft)>0){
                    System.out.println("Your required seats are available!\n");
                } else if (seatsAvailableLeft.equals("unavailablySeats"))
                        return false;
            }
         } catch (Exception e) {
                System.out.println(e);
                return false;
         }  */
       
       
        
            try{
             boolean rChecks = true;
             rChecks = itemCheck(itemName,itemType,itemPrice,itemQuantity);
             if(rChecks == false){
                 System.out.println("Something wrong with itemName, itemType, itemPrice or itemQuantity");
                 return false;
             } else {
                 System.out.println(" itemName , itemType , itemPrice and itemQuanity are ok");
             }
         } catch (Exception e){
                 System.out.println(e);
         }
         
        
         
         try{
             boolean result = true;
             result=reservationDAO.addItemForTest(myItem);
             if(result == false)
                return false;
             else 
                return true;
             
         }catch (Exception ex){
             System.out.println("Database Not Found!"); 
             return false;
         }
    }
    
    @Override
     public boolean itemCheck(String itemName, String itemType, int itemPrice, int itemQuantity){
        boolean nameCheck = checkItemName(itemName);
        boolean typeCheck = checkItemType(itemType);
        boolean priceCheck = checkItemPrice(itemPrice);
        boolean quantityCheck = checkItemQuantity(itemQuantity);
       
        
        return nameCheck== true && typeCheck == true && priceCheck == true 
                && quantityCheck == true ;
    }
    
    @Override
    public boolean checkItemName(String itemName){
        if(!itemName.equals(""))
            return true;
        else 
            return false;
    };
    
    @Override
    public boolean checkItemType(String itemType){
        if(!itemType.equals(""))
            return true;
        else 
            return false;
    };
    
    
    @Override
    public boolean checkItemPrice(int itemPrice){
        if(itemPrice>0 && itemPrice<15000 && itemPrice!= 0)
            return true;
        else 
            return false;
    };
    
    @Override
      public boolean checkItemQuantity(int itemQuantity){
        if(itemQuantity>0 && itemQuantity<15000 && itemQuantity!= 0)
            return true;
        else 
            return false;
    };

}