/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import blackMidnight.DAO_forTests.StoreSeatAvailabilityDAO_forTest;
import blackMidnight.model.Reservation;
import blackMidnight.model_forTests.Reservation_Test;
import blackMidnight.util.HibernateUtilTest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class StoreSeatsUpdatesDAO {
    
    
    /* This method will run only if there is the given reservation store in stores database, and will check if there is a row for the given reservation date, 
    * If there is a row, then will check if we can have the required seats, if we can then will update the row
    * If there isnt a row for the specific store and date, will create a new row ofc only if passing the check about seats availability
    * */
    public static boolean updateSpecificStoreDateReservationSeats(Reservation cr,SessionFactory factory){
        Session session = factory.openSession();
        session.beginTransaction();
        boolean result = false;
        String seatsAvailableLeft;
        
        try{
            if(StoreSeatAvailabilityDAO.checkIfRowForSpecificDayReservationExists(cr.getStoreName(),cr.getDate())==true){
                seatsAvailableLeft = StoreSeatAvailabilityDAO.checkIfStoreSeatAvailableAtSpecificDay(cr.getNumberOfSeats(), cr.getStoreName(),cr.getDate());
                if(Integer.parseInt(seatsAvailableLeft)>0){
                    String sqlCreate = "update reservationbydate set seatsAvailable = "+Integer.parseInt(seatsAvailableLeft)+" where storeName = :storeName and date = :date";
                    Query query = session.createSQLQuery(sqlCreate);
                    query.setString("storeName", cr.getStoreName());
                    query.setString("date", cr.getDate());
                    query.executeUpdate();
                    session.getTransaction().commit(); 
                    session.close();
                    result = true;
                } else if (seatsAvailableLeft.equals("unavailablySeats"))
                    result = false;
            } else if(StoreSeatAvailabilityDAO.checkIfRowForSpecificDayReservationExists(cr.getStoreName(),cr.getDate())==false){
                    int seats = StoreSeatAvailabilityDAO.getStoresAvailableSeats(cr.getStoreName());
                    int finalSeats = seats-cr.getNumberOfSeats();
                    if(finalSeats>=0){
                        Session session1 = factory.openSession();
                        session1.beginTransaction();
                        String sqlCreate = "INSERT INTO reservationbydate "+"(storeName,seatsAvailable,date)"+" VALUES "+" ('"+cr.getStoreName()+"',"+finalSeats+",'"+cr.getDate()+"')";
                        Query query1 = session1.createSQLQuery(sqlCreate);
                        query1.executeUpdate();
                        session1.getTransaction().commit(); 
                        session1.close();
                        result = true;
                    
                } else if (finalSeats<0)
                        result = false;
                
            }
        } catch (Exception e){
           System.out.println("Update Specific Store Day from Reservation FAILED!"+e);
           result = false;
        }
        
        return result;
    }
    
   
     
}
