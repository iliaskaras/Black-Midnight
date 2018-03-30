/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller;

import blackMidnight.DAO.StoreAvailableDaysDAO;
import java.util.ArrayList;

/**
 *
 * @author Ilias
 */
public class StoreAvailableDaysController {
    
    private static StoreAvailableDaysDAO storeDaysAvailableDAO = new StoreAvailableDaysDAO();
    
    //** checking if the Store is open at specific day **//
    public static boolean checkStoreDayAvailability(String chosenDay, String storeName){
        
        ArrayList<String> openDays = new ArrayList();
        
        openDays = storeDaysAvailableDAO.getAvailableStoreDays(storeName);
        
        if(openDays.contains(chosenDay))
            return true;
        else
            return false;
        
    }
    
    
}
