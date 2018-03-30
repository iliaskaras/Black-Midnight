/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;

import blackMidnight.model.StoreOwner;
import blackMidnight.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ilias
 */
public class StoreOwnerDAO {
   private static SessionFactory factory = HibernateUtil.getSessionFactory();
   
   
   public boolean addStoreOwner(Integer userID, Integer storeId) {
        Session session = factory.openSession();
        StoreOwner owner = new StoreOwner(userID,storeId);
        Transaction tx = null;
        boolean ownerCreated = false;
        try {
            tx = session.beginTransaction();
            session.save(owner);
            tx.commit();
            ownerCreated = true;
        } catch (HibernateException e) {
            if (tx != null) {
                ownerCreated = false;
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return ownerCreated;
    }
}
