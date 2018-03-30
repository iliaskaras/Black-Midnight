/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_forTests;

import blackMidnight.DAO.StoreSeatsUpdatesDAO;
import blackMidnight.model_forTests.Reservation_Test;
import blackMidnight.util.HibernateUtilTest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ilias
 */
public class CreateReservationDAO_forTest {
    
   private static SessionFactory factory = HibernateUtilTest.getSessionFactory();
    public boolean writeToFileReservationForTest(Reservation_Test cr) {
        //SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        boolean result;
        try {
            tx = session.beginTransaction();
            result = StoreSeatsUpdatesDAO_forTest.updateSpecificStoreDateReservationSeatsForTests(cr, factory);
            if (result == false) {
                return false;
            } else {
                session.save(cr);
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
    }
//        try {
//            tx = session.beginTransaction();
//            session.save(cr);
//            tx.commit();
//            try {
//                StoreSeatsUpdatesDAO_forTest.updateSpecificStoreDateReservationSeatsForTests(cr, factoryForTests);
//            } catch (Exception e) {
//                System.out.println("update Specific Store Date ReservationSeats FAILED!  " + e);
//            }
//            return true;
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//            System.out.println("Connection to Database FAILED!  " + e);
//            return false;
//        } finally {
//            session.close();
//        }
//
//    }
}
