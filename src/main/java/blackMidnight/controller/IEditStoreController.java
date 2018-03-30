/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.model.Store;

/**
 *
 * @author Ilias
 */
public interface IEditStoreController {
    boolean editStore(int storeId, String nameOfStore, int numberOfSeats,
            boolean parking, String storeAddress, String storeCity, String storePhone,
            String openDays, String openHours, String email);
}
