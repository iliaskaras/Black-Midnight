/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import blackMidnight.model.Store;
import blackMidnight.model_forTests.Store_Test;
import blackMidnight.util.HibernateUtil;
import blackMidnight.util.HibernateUtilTest;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class StoreAvailableDaysDAO{
    
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    
    //** We get the Open Store Days **//
     public static ArrayList<String> getAvailableStoreDays(String storeName){
        
        Session session = factory.openSession();
        session.beginTransaction();
      
        Query query = session.createQuery("from Store where nameOfStore = :nameOfStore");
        query.setString("nameOfStore", storeName);
        
        List<Store> openDays =(List<Store>) query.list();
        session.getTransaction().commit(); 
        session.close();
        
        ArrayList<String> availableStoreDays = new ArrayList();
        String availableStoreDaysString = openDays.toString();
        
        for(Store availableDays : openDays)
                availableStoreDaysString = availableDays.getOpenDays();
       
        if(availableStoreDaysString.length()==0){
            availableStoreDaysString = null;
        } else {
            if(availableStoreDaysString.contains("1"))
                availableStoreDays.add("Δευ");
            if(availableStoreDaysString.contains("2"))
                availableStoreDays.add("Τρι");
            if(availableStoreDaysString.contains("3"))
                availableStoreDays.add("Τετ");
            if(availableStoreDaysString.contains("4"))
                availableStoreDays.add("Πεμ");
            if(availableStoreDaysString.contains("5"))
                availableStoreDays.add("Παρ");
            if(availableStoreDaysString.contains("6"))
                availableStoreDays.add("Σαβ");
            if(availableStoreDaysString.contains("7"))
                availableStoreDays.add("Κυρ");
        }
         
        return availableStoreDays;
        
        
    }
     
     
   
}
