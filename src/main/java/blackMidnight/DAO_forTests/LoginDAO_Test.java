/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO_forTests;

import blackMidnight.model_forTests.StoreOwner_Test;
import blackMidnight.model_forTests.User_Test;
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
public class LoginDAO_Test {
   private static SessionFactory factory = HibernateUtilTest.getSessionFactory();
    
    
    
    public Integer userLogin(String username, String password) {

        Session session = factory.openSession();
        Transaction tx = null;
        Integer userID = 0;

        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from User_Test where username = :username and password= :password");
            query.setString("username", username);
            query.setString("password", password);
            List<User_Test> users = (List<User_Test>) query.list();
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
            Query query = session.createQuery("from StoreOwner_Test where UserID = :userID");
            query.setInteger("userID", userID);
            List<StoreOwner_Test> owners = (List<StoreOwner_Test>) query.list();
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
