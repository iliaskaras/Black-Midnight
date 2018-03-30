/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
public class StoreManagementDAO implements IStoreManagementDAO{

    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public List<Store> getStores() {
       
        //Configuration configuration = new Configuration();
        //configuration.configure("hibernate3207.cfg.xml");
        //ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        //SessionFactory sf = configuration.buildSessionFactory();
        //Session session = sf.openSession();
        Session session = factory.openSession();
        session.beginTransaction();
        
        String hq1 = "FROM Store";
        Query query = session.createQuery(hq1);
        
        List<Store> storesList = (List<Store>) query.list();
        session.getTransaction().commit();
        session.close();
        
        return storesList;
    }
    
}
