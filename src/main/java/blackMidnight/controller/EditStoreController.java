/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller;

import blackMidnight.DAO.StoreDAO;
import blackMidnight.DAO.IStoreDAO;
import blackMidnight.model.Store;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ilias
 */
public class EditStoreController implements IEditStoreController {
    
    private IStoreDAO myDAO = new StoreDAO();
    /**
     *
     * @param store The store with the new values.
     * @param searchName The name of the store we want to edit.
     * @return
     */
    @Override
    public boolean editStore(int storeId, String nameOfStore, int numberOfSeats,
            boolean parking, String storeAddress, String storeCity, String storePhone,
            String openDays, String openHours, String email) {
        
        
        Store myStore = new Store();
        myStore.setStoreId(storeId);
        myStore.setNameOfStore(nameOfStore); 
        myStore.setNumberOfSeats(numberOfSeats);
        myStore.setParking(parking);
        myStore.setStoreAddress(storeAddress);
        myStore.setStoreCity(storeCity);
        myStore.setStorePhone(storePhone);
        myStore.setOpenDays(openDays);
        myStore.setOpenHours(openHours);
        myStore.setEmail(email);

        boolean check = true;
        check = checkValues(nameOfStore, numberOfSeats, storeAddress, storeCity,
                            openDays, openHours);
        if (check == true) {
            myDAO.editStore(myStore);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * @param nameOfStore The name of the store to check.
     * @param numberOfSeats The number of the seats to check.
     * @param storeAddress The store address to check.
     * @param storeCity The store city to check.
     * @return true if all values are correct otherwise return false.
     */
    public boolean checkValues(String nameOfStore, int numberOfSeats,
                               String storeAddress, String storeCity,
                               String openDays, String openHours){
        boolean nameCheck = checkNameOfStore(nameOfStore);
        boolean seatsCheck = checkNumberOfSeats(numberOfSeats);
        boolean addressCheck = checkStoreAddress(storeAddress);
        boolean cityCheck = checkStoreCity(storeCity);
       // boolean openDaysCheck = checkOpenDays(openDays);
        boolean openHoursCheck = checkOpenHours(openHours);
        
        return nameCheck== true && seatsCheck == true && addressCheck == true 
                && cityCheck == true /*&& openDaysCheck == true*/ && openHoursCheck == true;
    }
    
    public boolean checkNameOfStore(String nameOfStore){
        if(!nameOfStore.equals(""))
            return true;
        else 
            return false;
    };
    
    public boolean checkNumberOfSeats(int numberOfSeats){
        if(numberOfSeats>0 && numberOfSeats<15000 && numberOfSeats!= 0)
            return true;
        else 
            return false;
    };
    
    public boolean checkStoreAddress(String storeAddress){
        if(!storeAddress.equals(""))
            return true;
        else 
            return false;
    };
    
    public boolean checkStoreCity(String storeCity){
        if(!storeCity.equals(""))
            return true;
        else 
            return false;
    };
    
    public boolean checkOpenDays(String openDays){
        if(!openDays.equals("") && validateOpenDays(openDays)){
            return true;
        }else{
            return false;
        }
        
    };
    
    public boolean checkOpenHours(String openHours){
        if(!openHours.equals("") && validateOpenHours(openHours)){
            return true;
        }else{
            return false;
        }
    };
    
    public boolean validateOpenDays(String openDays){
        Pattern pattern;
        Matcher matcher;
        final String SEVENDAYS_PATTERN = 
                 "[1-7]+";
        pattern = Pattern.compile(SEVENDAYS_PATTERN);
        matcher = pattern.matcher(openDays);
        return matcher.matches();
    };
    
    public boolean validateOpenHours(String openHours){
        Pattern pattern;
        Matcher matcher;
        final String TIME24HOURS_PATTERN = 
                 "([01]?[0-9]|2[0-3]):[0-5][0-9]-([01]?[0-9]|2[0-3]):[0-5][0-9]";
        pattern = Pattern.compile(TIME24HOURS_PATTERN);
        matcher = pattern.matcher(openHours);
        
        String[] split = openHours.split("-");
        return (!openHours.equals("00:00-00:00"))
                && !split[0].equals(split[1])
                && matcher.matches();
    };

    
    
   
}
