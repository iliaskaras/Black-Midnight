/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import blackMidnight.model.Store;
import blackMidnight.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class StoreChooserForReservationDAO implements IStoreChooserForReservationDAO{
    
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public List<Store> getStores(){
     
        Session session = factory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from Store");
          
        List<Store> stores =(List<Store>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
        return stores;
    }
    
    @Override
    public List<Store> getStoreDetails(String nameOfStore,String storeAddress){
     
        Session session = factory.openSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from Store where nameOfStore = :nameOfStore and storeAddress = :storeAddress");
        query.setString("nameOfStore", nameOfStore);
        query.setString("storeAddress", storeAddress);
          
        List<Store> stores =(List<Store>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
        return stores;
    }
    
 
    
}
