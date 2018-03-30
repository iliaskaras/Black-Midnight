/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;

import blackMidnight.model.StoreOwner;
import blackMidnight.model.User;
import blackMidnight.util.HibernateUtil;
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
public class LoginDAO {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    
    
    
    public Integer userLogin(String username, String password) {

        Session session = factory.openSession();
        Transaction tx = null;
        Integer userID = 0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from User where username = :username and password= :password");
            query.setString("username", username);
            query.setString("password", password);
            List<User> users = (List<User>) query.list();
//            
            userID=users.get(0).getUserID();
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
public Integer ownerLogin(Integer userID) {

        Session session = factory.openSession();
        Transaction tx = null;
        Integer ownerid=0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from StoreOwner where UserID = :userID");
            query.setInteger("userID", userID);
            List<StoreOwner> owners = (List<StoreOwner>) query.list();
//            for (User user : users) {
//                userID = user.getUserID();
//            }
            if(!owners.isEmpty()){
                ownerid= owners.get(0).getUserID();
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();

            }
            e.printStackTrace();
        } finally {
            session.close();
            if (ownerid != 0) {
            return ownerid;
        } else {
            return 0;
        }
        }
        
    }
}
