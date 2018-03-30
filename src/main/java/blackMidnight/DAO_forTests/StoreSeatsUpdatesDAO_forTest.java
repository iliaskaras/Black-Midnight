/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_forTests;

import blackMidnight.model_forTests.Reservation_Test;
import blackMidnight.util.HibernateUtilTest;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class StoreSeatsUpdatesDAO_forTest {
    
      public static boolean updateSpecificStoreDateReservationSeatsForTests(Reservation_Test cr,SessionFactory factory){
        Session session = factory.openSession();
        session.beginTransaction();
        boolean result = false;
        String seatsAvailableLeft;
        
        try{
            if(StoreSeatAvailabilityDAO_forTest.checkIfRowForSpecificDayReservationExistsForTests(cr.getStoreName(),cr.getDate())==true){
                seatsAvailableLeft = StoreSeatAvailabilityDAO_forTest.checkIfStoreSeatAvailableAtSpecificDayForTests(cr.getNumberOfSeats(), cr.getStoreName(),cr.getDate());
                if(Integer.parseInt(seatsAvailableLeft)>0){
                    
                    String sqlCreate = "update reservationbydate_test set seatsAvailable = "+Integer.parseInt(seatsAvailableLeft)+" where storeName = :storeName and date = :date";
                    Query query = session.createSQLQuery(sqlCreate);
                    query.setString("storeName", cr.getStoreName());
                    query.setString("date", cr.getDate());
                    query.executeUpdate();
                    session.getTransaction().commit(); 
                    session.close();
                    result = true;
                    
                } else if (seatsAvailableLeft.equals("unavailablySeats"))
                    
                    result = false;
                
            }  else if(StoreSeatAvailabilityDAO_forTest.checkIfRowForSpecificDayReservationExistsForTests(cr.getStoreName(),cr.getDate())==false){
                    int seats = StoreSeatAvailabilityDAO_forTest.getStoresAvailableSeatsForTests(cr.getStoreName());
                    int finalSeats = seats-cr.getNumberOfSeats();
                    if(finalSeats>=0){
                        Session session1 = factory.openSession();
                        session1.beginTransaction();
                        String sqlCreate = "INSERT INTO reservationbydate_test "+"(storeName,seatsAvailable,date)"+" VALUES "+" ('"+cr.getStoreName()+"',"+finalSeats+",'"+cr.getDate()+"')";
                        Query query1 = session1.createSQLQuery(sqlCreate);
                        query1.executeUpdate();
                        session1.getTransaction().commit(); 
                        session1.close();
                        result = true;
                    
                } else if (finalSeats<0)
                        result = false;
                }
        }catch (Exception e){
           System.out.println("Update Specific Store Day from Reservation FAILED!"+e);
           result = false;
        }
        
        return result;
    }
}
