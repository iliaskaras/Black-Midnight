/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_forTests;

//import static blackMidnight.DAO.StoreSeatAvailabilityDAO.checkIfStoreNameAvailableForTests;
import blackMidnight.model_forTests.Store_Test;
import blackMidnight.model_forTests.UpdateStoreSeat_Test;
import blackMidnight.util.HibernateUtilTest;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Ilias
 */
public class StoreSeatAvailabilityDAO_forTest {
    
    
    public static String checkIfStoreSeatAvailableAtSpecificDayForTests(int seats,String sName,String date) throws Exception{

        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();
        session.beginTransaction();
            
        String nameOfStore = sName;
        int numberOfSeats = seats;
        String result = null;
        
        Query query = session.createQuery("from UpdateStoreSeat_Test where storeName = :storeName and date = :date");
        query.setString("storeName", sName);
        query.setString("date", date);
        
        
        List<UpdateStoreSeat_Test> seatsAvailable =(List<UpdateStoreSeat_Test>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
         
        try{
            int finalSeatResult;
            //* Now we check if the specific store have the required seats availably at the specific day for the reservation *//
            for(UpdateStoreSeat_Test seatToCheck : seatsAvailable){
                finalSeatResult = seatToCheck.getSeatsAvailable()-numberOfSeats;
                if(finalSeatResult>0)
                    result = Integer.toString(finalSeatResult);
                else
                    result = "unavailablySeats";
                System.out.println("Store's Seat:"+seatToCheck.getSeatsAvailable()+"\t After - seats are : "+finalSeatResult);
            }
         
        }catch (Exception ex){
            System.out.println("We cant have a reservation with so many seats for the specific store"+ex);
            
        }
        
        return result;
    }
    
     /** checkIfStoreNameAvailable: Checks if the for the giving store and date there is a row into database that managing seats for the chosen days **/
    public static boolean checkIfRowForSpecificDayReservationExistsForTests(String sName,String date) throws Exception{
  
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();
        session.beginTransaction();
        boolean existStore;    
        String nameOfStore = sName;
        boolean result = false;
        
        existStore = checkIfStoreNameAvailableForTests(sName);
        try{
        if(existStore=true){
            Query query = session.createQuery("from UpdateStoreSeat_Test where  storeName = :storeName and date = :date");
            query.setString("storeName", sName);
            query.setString("date", date);
        
            List<UpdateStoreSeat_Test> row =(List<UpdateStoreSeat_Test>) query.list();
            session.getTransaction().commit(); 
            session.close();
        
            //* we check if the store with that day exists in database UpdateStoreSeat *//
            if(row.isEmpty())
                result = false;
            else 
                result = true;
        } else
            result = false;
        }catch(Exception e){
            System.out.println("checkIfRowForSpecificDayReservationExists"+e);
        }
      
        return result;
    }
    
     /** checkIfStoreNameAvailable: Checks if the store's name customer gave for the reservation exist **/
    public static boolean checkIfStoreNameAvailableForTests(String sName) throws Exception{
    
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();
        session.beginTransaction();
            
        String nameOfStore = sName;
        
        Query query = session.createQuery("from Store_Test where nameOfStore = :nameOfStore");
        query.setString("nameOfStore", sName);
        
        List<Store_Test> stores =(List<Store_Test>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
        //* we check if store name is available in database *//
        boolean result = false;
        if(stores.isEmpty())
            result = false;
        else
            result = true;
      
        return result;
    }
    
    /** checkIfStoreSeatAvailable: Checks if the seats that customer asked are available to the specific store name **/
    public static boolean checkIfStoreSeatAvailableForTests(int seats,String sName) throws Exception{

        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();
        session.beginTransaction();
            
        String nameOfStore = sName;
        int numberOfSeats = seats;
          
        Criteria criteria = session.createCriteria(Store_Test.class);
                            criteria.add(Restrictions.eq("nameOfStore",nameOfStore));
        List<Store_Test> stores =(List<Store_Test>) criteria.list();
        session.getTransaction().commit(); 
        session.close();
        
         //* we check if the store exists in database *//
        boolean result = false;
        if(stores.isEmpty())
                result = false;
            else
                result = true;
        try{
            int finalSeatResult;
            //* Now we check if the specific store have the required seats availably for the reservation *//
            for(Store_Test store : stores){
                finalSeatResult = store.getNumberOfSeats()-numberOfSeats;
                if(finalSeatResult>0)
                    result = true;
                else
                    result = false;
                System.out.println("Store's Seat:"+store.getNumberOfSeats()+"\t After - seats are : "+finalSeatResult);
            }
         
        }catch (Exception ex){
            System.out.println("We cant have a reservation with so many seats for the specific store"+ex);
        }
        
        return result;
    }
    /** checkIfStoreSeatAvailable: Checks if the seats that customer asked are available to the specific store name **/
    public static int getStoresAvailableSeatsForTests(String sName) throws Exception{

        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();
        session.beginTransaction();
            
        String nameOfStore = sName;
          
        Query query = session.createQuery("from Store_Test where nameOfStore = :nameOfStore");
        query.setString("nameOfStore", sName);
        
        List<Store_Test> stores =(List<Store_Test>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
         //* we check if the store exists in database *//
        int result = 0;
        if(stores.isEmpty())
                result = -1;
           
        try{
            
            //* Now we check if the specific store have the required seats availably for the reservation *//
            for(Store_Test store : stores)
                result = store.getNumberOfSeats();
                
         
        }catch (Exception ex){
            System.out.println("We cant have a reservation with so many seats for the specific store"+ex);
        }
        
        return result;
    }
}
