/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_forTests;

import blackMidnight.model_forTests.Store_Test;
import blackMidnight.util.HibernateUtilTest;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ilias
 */
public class StoreDAO_Test {
    //private static SessionFactory factory = HibernateUtilTest.getSessionFactory();
    
     public boolean storeExistForTest(String storeName, String storeAddress) {
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        try {
            Session session = factoryForTests.openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Store_Test WHERE nameOfStore = :nameOfStore AND storeAddress = :storeAddress");
            query.setString("nameOfStore", storeName);
            query.setString("storeAddress", storeAddress);

            List<Store_Test> stores = (List<Store_Test>) query.list();
            session.getTransaction().commit();
            session.close();
            int foundId = stores.get(0).getStoreId();
            System.out.println(foundId);
            if (foundId > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }
     
    public boolean addStoreForTest(Store_Test st) {
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        try {
            Session session = factoryForTests.openSession();
            session.beginTransaction();
            session.save(st);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            System.out.println("Connection to Database FAILED!  " + e);
            return false;
        }
    }
    
   
     
     public boolean editStore(Store_Test myStore) {
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        try {
            Session session = factoryForTests.openSession();
            session.beginTransaction();
            String hql = "UPDATE Store_Test set nameOfStore = :nameOfStore, numberOfSeats = :numberOfSeats, "
                    + "storeAddress = :storeAddress, storeCity = :storeCity, storePhone = :storePhone, "
                    + "parking = :parking, openDays = :openDays, openHours = :openHours, email = :email "
                    + "WHERE storeId = :st_id";
            Query query = session.createQuery(hql);
            query.setParameter("nameOfStore", myStore.getNameOfStore());
            query.setParameter("numberOfSeats", myStore.getNumberOfSeats());
            query.setParameter("storeAddress", myStore.getStoreAddress());
            query.setParameter("storeCity", myStore.getStoreCity());
            query.setParameter("storePhone", myStore.getStorePhone());
            query.setParameter("parking", myStore.isParking());
            query.setParameter("openDays", myStore.getOpenDays());
            query.setParameter("openHours", myStore.getOpenHours());
            query.setParameter("email", myStore.getEmail());

            query.setParameter("st_id", myStore.getStoreId());
            query.executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            System.out.println("Connection to Database FAILED!  " + e);
            return false;
        }
    }
     
      public boolean deleteStore(Store_Test myStore){
          SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        try {
            Session session = factoryForTests.openSession();
            session.beginTransaction();
            String hql = "DELETE FROM Store_Test " + "WHERE storeId = :st_id";
            Query query = session.createQuery(hql);

            query.setParameter("st_id", myStore.getStoreId());
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            System.out.println("Connection to Database FAILED!  " + e);
            return false;
        }
    }
      
      public Integer storeIdReturn(String storename) {
          SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();
        Transaction tx = null;
        Integer storeId = 0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Store_Test where nameOfStore = :storename");
            query.setString("storename", storename);
            List<Store_Test> stores = (List<Store_Test>) query.list();
            storeId = stores.get(0).getStoreId();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();

            }
            e.printStackTrace();
        } finally {
            session.close();
            if (storeId != 0) {
                return storeId;
            } else {
                return 0;
            }
        }
    }
}
