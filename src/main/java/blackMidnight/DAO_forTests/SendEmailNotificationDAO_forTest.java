/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_forTests;

import blackMidnight.model_forTests.Store_Test;
import blackMidnight.model_forTests.User_Test;
import blackMidnight.util.HibernateUtilTest;
import java.io.FileNotFoundException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class SendEmailNotificationDAO_forTest {
    
    
    public String readFromRegisterUsersLogEmailForTests(String username) throws FileNotFoundException{
         
        String emailResult = "";
      
        try{
          
            SessionFactory factory = HibernateUtilTest.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
        
            String customerUsername = username;
            Query query = session.createQuery("from User_Test where username = :customerUsername");
            query.setString("customerUsername", customerUsername);
          
            List<User_Test> users =(List<User_Test>) query.list();
            session.getTransaction().commit(); 
            session.close();
        
            for(User_Test user : users){
                emailResult = user.getUsermail();
            }
            }catch(Exception e){
                System.out.println(e);
            }
        return emailResult;
    }
    
    public String readFromStoreListEmailForTests(String storeName) throws FileNotFoundException{
      
        String emailResult = "";
        
        try{
            
            SessionFactory factory = HibernateUtilTest.getSessionFactory();
            Session session = factory.openSession();
            session.beginTransaction();
        
            String nameOfStore = storeName;
            Query query = session.createQuery("from Store_Test where nameOfStore = :nameOfStore");
            query.setString("nameOfStore", storeName);
          
            List<Store_Test> stores =(List<Store_Test>) query.list();
            session.getTransaction().commit(); 
            session.close();
        
            for(Store_Test store : stores){
                emailResult = store.getEmail();
            }
            }catch(Exception e){
                System.out.println(e);
            }
        return emailResult;
    }
}
