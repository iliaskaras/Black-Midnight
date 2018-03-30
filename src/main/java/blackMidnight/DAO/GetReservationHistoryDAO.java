/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import blackMidnight.model.Reservation;
import blackMidnight.model_forTests.Reservation_Test;
import blackMidnight.util.HibernateUtil;
import blackMidnight.util.HibernateUtilTest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
public class GetReservationHistoryDAO implements IGetReservationHistoryDAO{
    
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public List<Reservation> getAllReservations(String customerUsername){
        
        Session session = factory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from Reservation where customerUsername = :customerUsername");
        query.setString("customerUsername", customerUsername);
          
        List<Reservation> reservations =(List<Reservation>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
        return reservations;
    }
    
    @Override
    public List<Reservation> getReservationsHistoryForSpecificStore(String storeName,String customerUsername){
        
        Session session = factory.openSession();
        session.beginTransaction();
        boolean storeExists = false;
        try {
            storeExists = StoreSeatAvailabilityDAO.checkIfStoreNameAvailable(storeName);
        } catch (Exception ex) {
            Logger.getLogger(GetReservationHistoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        try{
            Query query = session.createQuery("from Reservation where storeName = :storeName and customerUsername = :customerUsername");
            query.setString("storeName", storeName);
            query.setString("customerUsername", customerUsername);
            List<Reservation> reservations =(List<Reservation>) query.list();
            session.getTransaction().commit(); 
            session.close();
            return reservations;
        } catch(Exception e){
            System.out.println(e);
            return null;
        }
       
    }
    
     
    @Override
    public List<Reservation> getOnGoingReservationsHistory(){
        
        Session session = factory.openSession();
        session.beginTransaction();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,0);
        Date date = calendar.getTime();
      //  System.out.println(dateFormat.format(date));
        
        Query query = session.createQuery("from Reservation  where date = :date");
        query.setString("date", dateFormat.format(date));
          
        List<Reservation> reservations =(List<Reservation>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
        return reservations;
    }
    
    
   
    
}
