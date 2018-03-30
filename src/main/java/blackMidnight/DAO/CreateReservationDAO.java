/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import blackMidnight.model.Reservation;
import blackMidnight.model_forTests.Reservation_Test;
import blackMidnight.util.HibernateUtil;
import blackMidnight.util.HibernateUtilTest;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ilias
 */
public class CreateReservationDAO implements ICreateReservationDAO {

    /**
     * writeToFileReservation : Here we send the object that created after the
     * inputs from the user, and writes them into the file name
     * ReservationTxtFile
     */
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    //private static SessionFactory factoryForTests = HibernateUtil_Test.getSessionFactory();

    @Override
    public boolean writeToFileReservation(Reservation cr) {
        Session session = factory.openSession();
        Transaction tx = null;
        boolean result;
        try {
            tx = session.beginTransaction();
            result = StoreSeatsUpdatesDAO.updateSpecificStoreDateReservationSeats(cr, factory);
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

    //* We are calling this method only for testing create of reservation *//
//    @Override
//    public boolean writeToFileReservationForTest(Reservation_Test cr) {
//        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
//        Session session = factoryForTests.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            session.save(cr);
//            tx.commit();
//            try {
//                StoreSeatsUpdatesDAO.updateSpecificStoreDateReservationSeatsForTests(cr, factoryForTests);
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
