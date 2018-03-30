/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO_forTests;

import blackMidnight.model_forTests.StoreOwner_Test;
import blackMidnight.util.HibernateUtilTest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ilias
 */
public class StoreOwnerDAO_Test {
    private static SessionFactory factory = HibernateUtilTest.getSessionFactory();
   
   
   public boolean addStoreOwner(Integer userID, Integer storeId) {
        Session session = factory.openSession();
        StoreOwner_Test owner = new StoreOwner_Test(userID,storeId);
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
