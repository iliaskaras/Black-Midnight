/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import blackMidnight.model.Store;
import blackMidnight.model_forTests.Store_Test;
import blackMidnight.util.HibernateUtil;
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
public class StoreDAO implements IStoreDAO {

    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    /**
     *
     * @param st The store object to write to file.
     * @return true if file is writen or false if not.
     */
    @Override
    public boolean addStore(Store st) {

        try {
            Session session = factory.openSession();
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
    
    @Override
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

    /**
     *
     * @param myStore the Store with the new values.
     * @return true if file editStoreed or false if not.
     */
    @Override
    public boolean editStore(Store myStore) {

        try {
            Session session = factory.openSession();
            session.beginTransaction();
            String hql = "UPDATE Store set nameOfStore = :nameOfStore, numberOfSeats = :numberOfSeats, "
                    + "storeAddress = :storeAddress, storeCity = :storeCity, storePhone = :storePhone, "
                    + "parking = :parking, openDays = :openDays, openHours = :openHours, email = :email "
                    + "WHERE storeId = :st_id";
            Query query = session.createQuery(hql);
            query.setParameter("nameOfStore", myStore.getNameOfStore());
            query.setParameter("numberOfSeats", myStore.getNumberOfSeats());
            query.setParameter("storeAddress", myStore.getStoreAddress());
            query.setParameter("storeCity", myStore.getStoreCity());
            query.setParameter("storePhone", myStore.getStorePhone());
            query.setParameter("parking", myStore.getParking());
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

    /**
     *
     * @author Elias Myronidis
     * @param myStore hte Store to delete
     * @return true if deleted or false if not
     */
    @Override
    public boolean deleteStore(Store myStore){
        try {
            Session session = factory.openSession();
            session.beginTransaction();
            String hql = "DELETE FROM Store " + "WHERE storeId = :st_id";
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
    //@author Giota (mporei na ginei beltiwsh apo ton Elias)
    
    @Override
    public Integer storeIdReturn(String storename) {

        Session session = factory.openSession();
        Transaction tx = null;
        Integer storeId = 0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from Store where nameOfStore = :storename");
            query.setString("storename", storename);
            List<Store> stores = (List<Store>) query.list();
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
        @Override
    public boolean storeExist(String storeName, String storeAddress) {

        try {
            Session session = factory.openSession();
            session.beginTransaction();
            Query query = session.createQuery("FROM Store WHERE nameOfStore = :nameOfStore AND storeAddress = :storeAddress");
            query.setString("nameOfStore", storeName);
            query.setString("storeAddress", storeAddress);

            List<Store> stores = (List<Store>) query.list();
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

    


}
