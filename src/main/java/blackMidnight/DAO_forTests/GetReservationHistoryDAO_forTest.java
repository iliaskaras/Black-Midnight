/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_forTests;

import blackMidnight.DAO.GetReservationHistoryDAO;
import blackMidnight.DAO.StoreSeatAvailabilityDAO;
import blackMidnight.model_forTests.Reservation_Test;
import blackMidnight.util.HibernateUtilTest;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class GetReservationHistoryDAO_forTest {
    
    public List<Reservation_Test> getAllReservationsForTests(String customerUsername){
        
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from Reservation_Test where customerUsername = :customerUsername");
        query.setString("customerUsername", customerUsername);
          
        List<Reservation_Test> reservations =(List<Reservation_Test>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
        return reservations;
    }
    
    public List<Reservation_Test> getReservationsHistoryForSpecificStoreForTests(String storeName,String customerUsername){
        
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();
        session.beginTransaction();
        boolean storeExists = false;
        try {
            storeExists = StoreSeatAvailabilityDAO_forTest.checkIfStoreNameAvailableForTests(storeName);
        } catch (Exception ex) {
            Logger.getLogger(GetReservationHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            Query query = session.createQuery("from Reservation_Test where storeName = :storeName and customerUsername = :customerUsername");
            query.setString("storeName", storeName);
            query.setString("customerUsername", customerUsername);
            List<Reservation_Test> reservations =(List<Reservation_Test>) query.list();
            session.getTransaction().commit(); 
            session.close();
            return reservations;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
}
