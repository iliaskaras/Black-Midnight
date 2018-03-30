/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

//import HibernateUtil;
import blackMidnight.util.HibernateUtil;
import blackMidnight.model.User;
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
public class UserDAO implements IUserDAO {

    private static SessionFactory factory = HibernateUtil.getSessionFactory();

    /**
     *
     * @param user the value of user
     * @return the Id of the created user
     */
    @Override
    public Integer addUser(User user) {
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
    @Override
    public void updateUser(String username, String userFirstName, String userLastName,
            String phoneNumber, String password, String usermail) {
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userID = userIdReturn(username);

        try {
            tx = session.beginTransaction();
            User myUser = (User) session.get(User.class, userID);
            myUser.setUsername(username);
            myUser.setUserFirstName(userFirstName);
            myUser.setUserLastName(userLastName);
            myUser.setPhoneNumber(phoneNumber);
            myUser.setUsermail(usermail);
            myUser.setPassword(password);

            session.update(myUser);

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
    @Override
    public Integer userIdReturn(String username) {

        Session session = factory.openSession();
        Transaction tx = null;
        Integer userID = 0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from User where username = :username");
            query.setString("username", username);
            List<User> users = (List<User>) query.list();
//            for (User user : users) {
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

    @Override
    public User userReturn(Integer userID) {
        Session session = factory.openSession();
        Transaction tx = null;
        User myUser = null;
        try {
            tx = session.beginTransaction();
            myUser = (User) session.get(User.class, userID);
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

    @Override
    public void deleteUser(Integer userID) {
        Session session = factory.openSession();

        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            User myUser = (User) session.get(User.class, userID);
            session.delete(myUser);
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
