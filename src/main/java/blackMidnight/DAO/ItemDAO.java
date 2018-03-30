/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;

import blackMidnight.model.Item;
import blackMidnight.model.Reservation;
import blackMidnight.model_forTests.Item_Test;
import blackMidnight.util.HibernateUtilTest;
import blackMidnight.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Transaction;

/**
 *
 * @author Ilias
 */

public class ItemDAO implements  IItemDAO{

    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    private static SessionFactory factoryTest = HibernateUtilTest.getSessionFactory();
    

    /**
     *
     * @param st The store object to write to file.
     * @return true if file is writen or false if not.
     */
    @Override
    public boolean addItem(Item st) {

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
/*      @Override
    public boolean addItem (Item st) {
        Session session = factory.openSession();
        Transaction tx = null;
        boolean result;
        try {
            tx = session.beginTransaction();
          //  result = itemQuantityUpdates.updateSpecificStoreDateReservationSeats(st, factory);
            if (result == false) {
                return false;
            } else {
                session.save(st);
                tx.commit();
                return true;
            }
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
            System.out.println("Connection to Database FAILED!  " + e);
            return false;
        } finally {
            session.close();
        }
    }*/
       @Override
       public boolean deleteItem(Item myItem){
           
           

      //  Transaction tx = null;
        try {
           Session session = factory.openSession();
           session.beginTransaction();
            String hql = "DELETE FROM Item " + "WHERE itemId = :itemId";
            Query query = session.createQuery(hql);

            query.setParameter("itemId", myItem.getItemId());
            query.executeUpdate();
            //session.delete(myReservation);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            System.out.println("Connection to Database FAILED!  " + e);
            return false;
        }
       }
    
    @Override
    public boolean addItemForTest(Item_Test st) {

        try {
            Session session = factoryTest.openSession();
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
       public boolean deleteItemForTest(Item_Test myItem){
           
           

      //  Transaction tx = null;
        try {
           Session session = factoryTest.openSession();
           session.beginTransaction();
            String hql = "DELETE FROM Item " + "WHERE itemId = :itemId";
            Query query = session.createQuery(hql);

            query.setParameter("itemId", myItem.getItemId());
            query.executeUpdate();
            //session.delete(myReservation);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            System.out.println("Connection to Database FAILED!  " + e);
            return false;
        }
       }
    
    }

