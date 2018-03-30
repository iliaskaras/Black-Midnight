/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller;

import blackMidnight.model.Store;
import blackMidnight.DAO.IStoreDAO;
import blackMidnight.DAO.StoreDAO;
import blackMidnight.model_forTests.Store_Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author Ilias
 */
public class CreateStoreController implements ICreateStoreController {
    private IStoreDAO myDAO ;

    public CreateStoreController(IStoreDAO myDAO) {
      this.myDAO   = myDAO;
    }
    
    public CreateStoreController(){
        
    }
    
    @Override
    /**
     *
     * @param nameOfStore The name of the store to create.
     * @param numberOfSeats The number of seats of the store.
     * @param parking If the store has parking or not.
     * @param storeAddress The address of the store.
     * @param storeCity The city where the store is.
     * @param storePhone The phone of the store.
     * @param openDays The days of the week the store is open.
     * @param openHours The hours of the day the store is open.
     * @param email The email of the store.
     * @return true if the store added or false if not.
     */
    public boolean storeCreation(String nameOfStore, int numberOfSeats,
            boolean parking, String storeAddress, String storeCity, String storePhone,
            String openDays, String openHours, String email , String storeDetails) {
        Store myStore = new Store();
        myStore.setNameOfStore(nameOfStore);
        myStore.setNumberOfSeats(numberOfSeats);
        myStore.setParking(parking);
        myStore.setStoreAddress(storeAddress);
        myStore.setStoreCity(storeCity);
        myStore.setStorePhone(storePhone);
        myStore.setOpenDays(openDays);
        myStore.setOpenHours(openHours);
        myStore.setEmail(email);
        myStore.setStoreDetails(storeDetails);

        boolean check = checkValues(nameOfStore, numberOfSeats, storeAddress, storeCity,
                            storePhone, openDays, openHours, email, storeDetails);
        if (check == true) {
            myDAO.addStore(myStore);
            return true;
        } else {
            return false;
        }
    }
    
    
    
    @Override
       public boolean storeCreationForTest(String nameOfStore, int numberOfSeats,
            boolean parking, String storeAddress, String storeCity, String storePhone,
            String openDays, String openHours, String email , String storeDetails){
           
           IStoreDAO stDAO = new StoreDAO();
   
        Store_Test newStore = new Store_Test();
        newStore.setNameOfStore(nameOfStore);
        newStore.setNumberOfSeats(numberOfSeats);
        newStore.setParking(parking);
        newStore.setStoreAddress(storeAddress);
        newStore.setStoreCity(storeCity);
        newStore.setStorePhone(storePhone);
        newStore.setOpenDays(openDays);
        newStore.setOpenHours(openHours);
        newStore.setEmail(email);
        newStore.setStoreDetails(storeDetails);

        boolean check = checkValuesForTest(nameOfStore, numberOfSeats, storeAddress, storeCity,
                            storePhone, openDays, openHours, email, storeDetails);
        if (check == true) {
            stDAO.addStoreForTest(newStore);
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
     * @param storePhone
     * @param openDays
     * @param openHours
     * @param email
     * @param storeDetails
     * @return true if all values are correct otherwise return false.
     */
    public boolean checkValues(String nameOfStore, int numberOfSeats,
                               String storeAddress, String storeCity,
                               String storePhone, String openDays, String openHours, String email, String storeDetails){
        boolean nameCheck = checkNameOfStore(nameOfStore);
        boolean seatsCheck = checkNumberOfSeats(numberOfSeats);
        boolean addressCheck = checkStoreAddress(storeAddress);
        boolean cityCheck = checkStoreCity(storeCity);
        boolean openDaysCheck = checkOpenDays(openDays);
        boolean openHoursCheck = checkOpenHours(openHours);
        boolean detailsCheck = checkStoreDetails(storeDetails);
        boolean phoneCheck = checkStorePhone(storePhone);
        boolean emailCheck = checkEmail(email);
        boolean checkExist = checkIfStoreExists(nameOfStore, storeAddress);
        
        return nameCheck== true && seatsCheck == true && addressCheck == true 
                && cityCheck == true && phoneCheck == true && openDaysCheck == true && openHoursCheck == true && emailCheck == true && checkExist == false && detailsCheck == true;
    }
    public boolean checkValuesForTest(String nameOfStore, int numberOfSeats,
                               String storeAddress, String storeCity,
                               String storePhone, String openDays, String openHours, String email, String storeDetails){
        boolean nameCheck = checkNameOfStore(nameOfStore);
        boolean seatsCheck = checkNumberOfSeats(numberOfSeats);
        boolean addressCheck = checkStoreAddress(storeAddress);
        boolean cityCheck = checkStoreCity(storeCity);
        boolean phoneCheck = checkStorePhone(storePhone);
        boolean openDaysCheck = checkOpenDays(openDays);
        boolean openHoursCheck = checkOpenHours(openHours);
        boolean detailsCheck = checkStoreDetails(storeDetails);
        boolean emailCheck = checkEmail(email);
        boolean checkExist = checkIfStoreExistsForTest(nameOfStore, storeAddress);
        
        return nameCheck== true && seatsCheck == true && addressCheck == true 
                && cityCheck == true && phoneCheck == true && openDaysCheck == true && openHoursCheck == true && emailCheck == true && checkExist == false && detailsCheck == true;
    }
    
    public boolean checkNameOfStore(String nameOfStore){
        return !nameOfStore.equals("");
    };
    
     public boolean checkNumberOfSeats(int numberOfSeats){
        return numberOfSeats>0 && numberOfSeats<15000 && numberOfSeats!= 0;
    };
    
    public boolean checkStoreAddress(String storeAddress){
        return !storeAddress.equals("");
    };
    
    public boolean checkStoreCity(String storeCity){
        return !storeCity.equals("");
    };
    
    public boolean checkStorePhone(String storePhone){
        return validatePhoneNoString(storePhone);
    }
    
    public boolean checkOpenDays(String openDays){
        return !openDays.equals("") && validateOpenDays(openDays);
        
    };
    
    public boolean checkOpenHours(String openHours){
        return !openHours.equals("") && validateOpenHours(openHours);
    };
    
    public boolean checkEmail(String email){
        return email.contains("@");
    }
    
    public boolean validatePhoneNoString(String storePhone){
        Pattern pattern;
        Matcher matcher;
        final String PHONE_PATTERN = 
                 "[0-9]+";
        pattern = Pattern.compile(PHONE_PATTERN);
        matcher = pattern.matcher(storePhone);
        return matcher.matches();
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
    
    @Override
    public boolean checkIfStoreExists(String storeName, String storeAddress){
        StoreDAO myStDao = new StoreDAO();
        boolean result = myStDao.storeExist(storeName, storeAddress);
        
        return result;
    }
    
    @Override
    public boolean checkIfStoreExistsForTest(String storeName, String storeAddress){
        StoreDAO myStDao = new StoreDAO();
        boolean result = myStDao.storeExistForTest(storeName, storeAddress);
        
        return result;
    }
    @Override
    public Integer storeIdRet(String storename){
        return myDAO.storeIdReturn(storename);
    }
    
    public boolean checkStoreDetails(String storeDetails){
        return !storeDetails.equals("");
    }
    
    
//    /**
//     *
//     * @param st The name of the store object.
//     * @return true if file is written or false if not.
//     */
//    public boolean writeTofile(Store st) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(new File("storeList.txt"), true));
//            writer.write(st.getNameOfStore() + "\t" + st.getNumberOfSeats() + "\t"
//                    + st.getStoreAddress() + "\t" + st.getStoreCity() + "\t"
//                    + st.getStorePhone() + "\t" + st.getParking() + "\t"
//                    + st.getOpenDays() + "\t" + st.getOpenHours() + "\n");
//            writer.close();
//            return true;
//        } catch (IOException ex) {
//            return false;
//        }
//    }

}
