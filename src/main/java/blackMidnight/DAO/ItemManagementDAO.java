/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;

import blackMidnight.model.Item;
import blackMidnight.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class ItemManagementDAO implements IItemManagementDAO {
    
     private static SessionFactory factory = HibernateUtil.getSessionFactory();

    @Override
    public List<Item> getItems() {
       
      
        Session session = factory.openSession();
        session.beginTransaction();
        
        String hq1 = "FROM Item";
        Query query = session.createQuery(hq1);
        
        List<Item> itemList = (List<Item>) query.list();
        session.getTransaction().commit();
        session.close();
        
        return itemList;
    }
}
