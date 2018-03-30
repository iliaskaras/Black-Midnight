/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_forTests;

import blackMidnight.model.Store;
import blackMidnight.model_forTests.Store_Test;
import blackMidnight.util.HibernateUtil;
import blackMidnight.util.HibernateUtilTest;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class StoreChooserForReservationDAO_forTest {
    
    private static SessionFactory factory = HibernateUtilTest.getSessionFactory();

    public List<Store_Test> getStores(){
     
        Session session = factory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from Store_Test");
          
        List<Store_Test> stores =(List<Store_Test>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
        return stores;
    }
    
    public List<Store_Test> getStoreDetails(String nameOfStore,String storeAddress){
     
        Session session = factory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from Store_Test where nameOfStore = :nameOfStore and storeAddress = :storeAddress");
        query.setString("nameOfStore", nameOfStore);
        query.setString("storeAddress", storeAddress);
          
        List<Store_Test> stores =(List<Store_Test>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
        return stores;
    }
}
