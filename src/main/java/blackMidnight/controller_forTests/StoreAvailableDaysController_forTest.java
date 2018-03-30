/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller_forTests;

import blackMidnight.DAO_forTests.StoreAvailableDayDAO_forTest;
import java.util.ArrayList;

/**
 *
 * @author Ilias
 */
public class StoreAvailableDaysController_forTest {
    
     private static StoreAvailableDayDAO_forTest storeDaysAvailableDAO = new StoreAvailableDayDAO_forTest();
    
     /** checking if the Store is open at specific day **/
    public static boolean checkStoreDayAvailabilityForTests(String chosenDay, String storeName){
        
        ArrayList<String> openDays = new ArrayList();
        
        openDays = storeDaysAvailableDAO.getAvailableStoreDaysForTests(storeName);
        
        if(openDays.contains(chosenDay))
            return true;
        else
            return false;
        
    }
}
