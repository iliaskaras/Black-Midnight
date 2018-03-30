/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_forTests;

import blackMidnight.model_forTests.Store_Test;
import blackMidnight.util.HibernateUtilTest;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class StoreManagementDAO_forTest {
    
     private static SessionFactory factory = HibernateUtilTest.getSessionFactory();

    public List<Store_Test> getStores() {
       
        //Configuration configuration = new Configuration();
        //configuration.configure("hibernate3207.cfg.xml");
        //ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        //SessionFactory sf = configuration.buildSessionFactory();
        //Session session = sf.openSession();
        Session session = factory.openSession();
        session.beginTransaction();
        
        String hq1 = "FROM Store_Test";
        Query query = session.createQuery(hq1);
        
        List<Store_Test> storesList = (List<Store_Test>) query.list();
        session.getTransaction().commit();
        session.close();
        
        return storesList;
    }
}
