/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller;

/**
 *
 * @author Ilias
 */
public interface ICreateReservationController {
    
     public boolean createReservation(String customerName,String numberOfSeats,
                                     String storeName,String date,String hour,
                                     String UID,String userName,String chosenDay,String openHours) throws Exception;

}
