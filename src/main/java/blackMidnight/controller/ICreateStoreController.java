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
public interface ICreateStoreController {
    public boolean storeCreation(String nameOfStore, int numberOfSeats,
            boolean parking, String storeAddress, String storeCity,
            String storePhone, String openDays, String openHours, String email, String storeDetails);
    
    public boolean storeCreationForTest(String nameOfStore, int numberOfSeats,
            boolean parking, String storeAddress, String storeCity,
            String storePhone, String openDays, String openHours, String email, String storeDetails);
    public boolean checkIfStoreExists(String storeName, String storeAddress);
   public boolean checkIfStoreExistsForTest(String storeName, String storeAddress);
    public Integer storeIdRet(String storename);
}
