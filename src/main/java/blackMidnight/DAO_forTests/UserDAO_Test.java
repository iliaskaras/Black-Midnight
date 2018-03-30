/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO_forTests;

import blackMidnight.model_forTests.User_Test;
import blackMidnight.util.HibernateUtilTest;
import java.util.Iterator;
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
public class UserDAO_Test {
    private static SessionFactory factory = HibernateUtilTest.getSessionFactory();

    /**
     *
     * @param user the value of user
     * @return the Id of the created user
     */
        public Integer addUserTest(User_Test user) {
        Session session = factory.openSession();

        Transaction tx = null;
        Integer userID = null;
        try {
            tx = session.beginTransaction();
            userID = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return userID;
    }

    /**
     * This method update the fields of an existing user in the database
     *
     * @param username username of the user
     * @param userFirstName First name of user
     * @param userLastName last name of user
     * @param password password
     * @param phoneNumber phone number of user
     * @param usermail email of user
     */
        public void updateUserTestForTests(String username, String userFirstName, String userLastName,
            String phoneNumber, String password, String usermail) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userID = userIdReturnForTests(username);

        try {
            tx = session.beginTransaction();
            User_Test myUser_Test = (User_Test) session.get(User_Test.class, userID);
            myUser_Test.setUsername(username);
            myUser_Test.setUserFirstName(userFirstName);
            myUser_Test.setUserLastName(userLastName);
            myUser_Test.setPhoneNumber(phoneNumber);
            myUser_Test.setUsermail(usermail);
            myUser_Test.setPassword(password);

            session.update(myUser_Test);

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    /**
     *
     * @param username the username of the user to search for
     * @return the id of the user if the user exists in the database table 0
     * else.
     */
        public Integer userIdReturnForTests(String username) {

        Session session = factory.openSession();
        Transaction tx = null;
        Integer userID = 0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from User_Test where username = :username");
            query.setString("username", username);
            List<User_Test> users = (List<User_Test>) query.list();
//            for (User_Test user : users) {
//                userID = user.getUserID();
//            }
            userID = users.get(0).getUserID();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();

            }
            e.printStackTrace();
        } finally {
            session.close();
            if (userID != 0) {
                return userID;
            } else {
                return 0;
            }
        }
        
    }

        public User_Test userReturnForTests(Integer userID) {
        Session session = factory.openSession();
        Transaction tx = null;
        User_Test myUser = null;
        try {
            tx = session.beginTransaction();
            myUser = (User_Test) session.get(User_Test.class, userID);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();

            }
            e.printStackTrace();
        } finally {
            session.close();
            if (myUser != null) {
                return myUser;
            } else {
                return null;
            }
        }

    }
        public void deleteUserTestForTests(Integer userID) {
        Session session = factory.openSession();

        Transaction tx = null;
        
        try {
            tx = session.beginTransaction();
            User_Test myUser_Test = (User_Test) session.get(User_Test.class, userID);
            session.delete(myUser_Test);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
}
