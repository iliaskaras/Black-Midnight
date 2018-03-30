/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.model;

import org.joda.time.DateTime;

/**
 *
 * @author Ilias
 */
public class StoreAvailable {

    /**
     * Checks if the user can book the store at a particular day and time.
     * @param store A store object with the info of the store in question.
     * @param date A string (DD/MM/YYYY) with the requested date.
     * @param hour A string (HH:MM) with the requested hour.
     * @return true if the store is available at the particular day and time.
     */
    public boolean storeAvailable(Store store, String date, String hour){
        
        return storeDayAvailable(store, date) && storeHourAvailable(store, hour);
    }
    
    /**
     * Checks if the store is available at the requested day.
     * @param store A store object with the info of the store in question.
     * @param date A string (DD/MM/YYYY) with the requested day.
     * @return
     */
    public boolean storeDayAvailable (Store store, String date){
        String[] dateParts = date.split("/");
        DateTime bookDate = new DateTime(Integer.parseInt(dateParts[2])
                                       ,Integer.parseInt(dateParts[1])
                                       ,Integer.parseInt(dateParts[0]),0,0,0);
        
        return (store.getOpenDays().contains( Integer.toString(bookDate.getDayOfWeek() )));
    }
    
    /**
     * Checks if the store is available at the requested time of the day.
     * @param store A store object with the info of the store in question.
     * @param hour A string (DD/MM/YYYY) with the requested day.
     * @return
     */
    public boolean storeHourAvailable (Store store, String hour){
        DateTime dateTime;
        DateTime openTime;
        DateTime closeTime;
        
        dateTime = setTime(Integer.parseInt(hour.substring(0, 2))
                           ,Integer.parseInt(hour.substring(3, 5)));
        openTime = setTime(Integer.parseInt(store.getOpenHours().substring(0, 2))
                           ,Integer.parseInt(store.getOpenHours().substring(3, 5)));
        closeTime = setTime(Integer.parseInt(store.getOpenHours().substring(6, 8))
                           ,Integer.parseInt(store.getOpenHours().substring(9, 11)));
       
        return (dateTime.isEqual(openTime) || dateTime.isAfter(openTime))
                && dateTime.isBefore(closeTime); 
    }
    
    /**
     * Takes hour and minutes and creates a DateTime object, with the current date
     * if the hour is pm or the next day if the hour is am.
     * @param hour A store object with the info of the store in question.
     * @param minute A string (DD/MM/YYYY) with the requested day.
     * @return DateTime object with the requested hour and minutes plus the right day.
     */
    DateTime setTime (int hour, int minute){
        DateTime current = new DateTime();
        
        if (hour <= 12){
            DateTime dateTime = new DateTime(current.getYear()
                            ,current.getMonthOfYear()
                            ,current.getDayOfMonth()+1
                            ,hour
                            ,minute);
            return dateTime;
        }else{
            DateTime dateTime = new DateTime(current.getYear()
                            ,current.getMonthOfYear()
                            ,current.getDayOfMonth()
                            ,hour
                            ,minute);
            return dateTime;
        }
    }
}
