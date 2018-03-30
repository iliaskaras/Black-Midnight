/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;


import blackMidnight.model.Store;
import blackMidnight.model.UpdateStoreSeat;
import blackMidnight.model_forTests.Store_Test;
import blackMidnight.model_forTests.UpdateStoreSeat_Test;
import blackMidnight.util.HibernateUtil;
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
public class StoreSeatAvailabilityDAO {
    /** FileReaderActivities class is a class that has to do with checking if the 
     * customer's inputs for the reservation are correct.
     */
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public static void main(String args[]) throws Exception{
        
    }
    
    /** checkIfStoreSeatAvailable: Checks if the seats that customer asked are available to the specific store name **/
    public static int getStoresAvailableSeats(String sName) throws Exception{

        Session session = factory.openSession();
        session.beginTransaction();
            
        String nameOfStore = sName;
          
        Query query = session.createQuery("from Store where nameOfStore = :nameOfStore");
        query.setString("nameOfStore", sName);
        
        List<Store> stores =(List<Store>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
         //* we check if the store exists in database *//
        int result = 0;
        if(stores.isEmpty())
                result = -1;
           
        try{
            
            //* Now we check if the specific store have the required seats availably for the reservation *//
            for(Store store : stores)
                result = store.getNumberOfSeats();
                
         
        }catch (Exception ex){
            System.out.println("We cant have a reservation with so many seats for the specific store"+ex);
        }
        
        return result;
    }
    
    /** checkIfStoreNameAvailable: Checks if the store's name customer gave for the reservation exist **/
    public static boolean checkIfStoreNameAvailable(String sName) throws Exception{
  
        Session session = factory.openSession();
        session.beginTransaction();
            
        String nameOfStore = sName;
        
        Query query = session.createQuery("from Store where nameOfStore = :nameOfStore");
        query.setString("nameOfStore", sName);
        
        List<Store> stores =(List<Store>) query.list();
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
    public static boolean checkIfStoreSeatAvailable(int seats,String sName) throws Exception{

        Session session = factory.openSession();
        session.beginTransaction();
            
        String nameOfStore = sName;
        int numberOfSeats = seats;
          
        Query query = session.createQuery("from Store where nameOfStore = :nameOfStore");
        query.setString("nameOfStore", sName);
        
        List<Store> stores =(List<Store>) query.list();
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
            for(Store store : stores){
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
   
    //* Checks if for the given reservation store we have the seats required at specific day *//
    public static String checkIfStoreSeatAvailableAtSpecificDay(int seats,String sName,String date) throws Exception{

        Session session = factory.openSession();
        session.beginTransaction();
            
        String nameOfStore = sName;
        int numberOfSeats = seats;
        String result = null;
        
        Query query = session.createQuery("from UpdateStoreSeat where storeName = :storeName and date = :date");
        query.setString("storeName", sName);
        query.setString("date", date);
        
        
        List<UpdateStoreSeat> seatsAvailable =(List<UpdateStoreSeat>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
         
        try{
            int finalSeatResult;
            //* Now we check if the specific store have the required seats availably at the specific day for the reservation *//
            for(UpdateStoreSeat seatToCheck : seatsAvailable){
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
    public static boolean checkIfRowForSpecificDayReservationExists(String sName,String date) throws Exception{
  
        Session session = factory.openSession();
        session.beginTransaction();
        boolean existStore;    
        String nameOfStore = sName;
        boolean result = false;
        
        existStore = checkIfStoreNameAvailable(sName);
        try{
        if(existStore=true){
            Query query = session.createQuery("from UpdateStoreSeat where  storeName = :storeName and date = :date");
            query.setString("storeName", sName);
            query.setString("date", date);
        
            List<UpdateStoreSeat> row =(List<UpdateStoreSeat>) query.list();
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
    
}
  