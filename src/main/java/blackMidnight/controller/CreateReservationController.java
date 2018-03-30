/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.controller;

import blackMidnight.DAO.StoreSeatAvailabilityDAO;
import blackMidnight.model.Reservation;
import blackMidnight.DAO.CreateReservationDAO;
import blackMidnight.DAO.ICreateReservationDAO;
import blackMidnight.model.Store;
import blackMidnight.model_forTests.Reservation_Test;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 *
 * @author Ilias
 */
public class CreateReservationController implements ICreateReservationController{
    private ICreateReservationDAO reservationDAO = new CreateReservationDAO();
    
    /** createReservation : Takes the customerName,number of seats, store name, date
     * for the reservation the customer wants to make, and saves the reservation
     * into the database.
     */
    @Override
    public boolean createReservation(String customerName,String numberOfSeats,
                                     String storeName,String date,String hour,
                                     String UID,String userName,String chosenDay,String openHours) throws Exception{
   
        Reservation newReservation = new Reservation();
        newReservation.setCustomerName(customerName);
        newReservation.setNumberOfSeats(Integer.parseInt(numberOfSeats));
        newReservation.setStoreName(storeName);
        newReservation.setDate(date);
        newReservation.setHour(hour);
        newReservation.setReservationCode(UID);
        newReservation.setCustomerUsername(userName);
        int nos = Integer.parseInt(numberOfSeats);
        String toCheck = "";
        
        
         //** checking if the given day is available for the specific Store for the reservation **//
         try{
            boolean resultIfStoreDayAvailable = false;
            resultIfStoreDayAvailable = StoreAvailableDaysController.checkStoreDayAvailability(chosenDay,storeName);
            if(resultIfStoreDayAvailable == false){
                System.out.println("Store is not open at specific day!\n");
                return false;
            } else
                System.out.println("Store is open at specific day!\n");
         } catch (Exception e){
             System.out.println(e);
         }
         
         //** checking if the given store's Name we gave exists in the Database **//
        try{
            boolean resultIfStoreNameAvailable = false;
            resultIfStoreNameAvailable = StoreSeatAvailabilityDAO.checkIfStoreNameAvailable(newReservation.getStoreName());
            if(resultIfStoreNameAvailable == false){
                System.out.println("The name of store is not OK!\n");
                return false;
            } else
                System.out.println("The name of store is ok!\n");
         } catch (Exception e) {
                System.out.println(e);
         }  
        
        //** checking if the given seats are available for the reservation at specified day for the specified store **//
        try{
            String seatsAvailableLeft;
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
         }  
        
        try{
             boolean rChecks = true;
             rChecks = reservationChecks(customerName,date,storeName,nos,hour,UID,openHours);
             if(rChecks == false){
                 System.out.println("Something wrong with customerName , date, hour , storeName or UID");
                 return false;
             } else {
                 System.out.println("customerName , date , storeName , hour and UID are ok");
             }
         } catch (Exception e){
                 System.out.println(e);
         }
         
        try{
             boolean result = true;
             result = reservationDAO.writeToFileReservation(newReservation);
             
             if(result == false)
                return false;
             else 
                return true;
             
         }catch (Exception ex){
             System.out.println("Database Not Found!"); 
             return false;
         }
       
    }

    //** checking if customerName , cDate  and storeName require the input rules we have **//
    public boolean reservationChecks(String cName,String cDate,String sName,int cSeats,String cHour,String reservationCode,String openStoreHours){
        boolean result = true;
      
        if(checkReservationCustomerName(cName)==false)
            result = false;
        if(checkReservationDate(cDate)==false)
            result = false;
        if(checkReservationStoreName(sName)==false)
            result = false;
        if(checkNegativeOrZeroSeats(cSeats)==false)
            result = false;
        if(checkHour(cHour)==false)
            result = false;
        if(checkReservationCode(reservationCode)==false)
            result = false;
        if(checkStoresHourAvailability(cHour,openStoreHours)==false)
            result = false;
        System.out.println(cName+cDate+cHour+sName+"\t\t\t"+result);
        return result;                  
            
    }
    
    public boolean checkReservationCode(String rCode){
        boolean result ;
        String toCheck = "";
        
        if(rCode.equals(toCheck)){
            result = false;
        } else {
            result = true;
        }
      
        return result;
    }
    
    public boolean checkReservationCustomerName(String customerName){
        boolean result ;
        String toCheck = "";
        
        if(customerName.length()>25 || customerName.equals(toCheck)){
            result = false;
        } else {
            result = true;
        }
      
        return result;
    }
    
    public boolean checkReservationDate(String customerDate){
        boolean result;
        String toCheck = "";
        
        if(customerDate.length()>25 || customerDate.equals(toCheck)){
            result = false;
        } else {
            result = true;
        }
        
       return result;
    }
    
     public boolean checkReservationStoreName(String storeName){
        boolean result;
        String toCheck = "";
        
        if(storeName.length()>25 || storeName.equals(toCheck)){
            result = false;
        } else {
            result = true;
        }
        
        return result;
    }
     
     public boolean checkNegativeOrZeroSeats(int seats){
        boolean result;
        
        if(seats<0 || seats==0){
            result = false;
        } else {
            result = true;
        }
        
        return result;
    }
    
     public boolean checkHour(String hour){
        Pattern pattern;
        Matcher matcher;
        final String TIME24HOURS_PATTERN = 
                 "([01]?[0-9]|2[0-3]):[0-5][0-9]";
        pattern = Pattern.compile(TIME24HOURS_PATTERN);
        matcher = pattern.matcher(hour);
        return  matcher.matches();
    };
     
     //* we check if the given reservation hour is available at specific store *//
     public boolean checkStoresHourAvailability(String hour,String openHours){
         boolean result = false;
         int fromHour = Integer.parseInt(openHours.substring(0,2)); 
         int fromMinute = Integer.parseInt(openHours.substring(3,5));
         int toHour = Integer.parseInt(openHours.substring(6,8));
         int toMinute = Integer.parseInt(openHours.substring(9,11));
         int givenHour = Integer.parseInt(hour.substring(0,2));
         int givenMinute = Integer.parseInt(hour.substring(3,5));
        
         if(givenHour>12 && givenHour<=23){
             if(toHour>=0 && toHour<=12 && givenHour>=fromHour){
                if(givenMinute>toMinute){
                    if(givenMinute>=fromMinute)
                        result = true;
                    else
                        result = false;
                } else if(givenMinute<=toMinute){
                    if(givenMinute>=fromMinute)
                        result = true;
                    else
                        result = false;
                } 

             } else{
                if(givenHour>=fromHour && givenMinute>toMinute){
                    if(givenMinute>=fromMinute && givenHour<toHour)
                        result = true;
                    else
                        result = false;
                } else if(givenHour>=fromHour && givenMinute<=toMinute){
                    if(givenMinute>=fromMinute && givenHour<=toHour)
                        result = true;
                    else
                        result = false;
                }
             }
         }else{
             if(toHour>=0 && toHour<=12 ){
                 if(givenMinute>=fromMinute  && givenMinute<=toMinute && givenHour<=toHour)
                     result = true;
                 else
                     result = false;
             } else
                 if(givenHour>=fromHour && givenMinute>=fromMinute && givenHour>=toHour && givenMinute<=toMinute)
                     result = true;
                 else
                     result = false;
         }

         
        System.out.println("Result from times !!!!!!!!!!!!!!!!!!!!!!!"+result);
        return result;
     }
     
   
}
