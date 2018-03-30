/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO;

import blackMidnight.model.Store;
import blackMidnight.model.User;
import blackMidnight.model_forTests.Store_Test;
import blackMidnight.model_forTests.User_Test;
import blackMidnight.util.HibernateUtil;
import blackMidnight.util.HibernateUtilTest;
import java.io.FileNotFoundException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author Ilias
 */
public class SendEmailDAO implements ISendEmailDAO{
    
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    
    //* We give the username and we search into the Register Users log the email of that user *//
    @Override
    public String readFromRegisterUsersLogEmail(String username) throws FileNotFoundException{
         
        String emailResult = "";
      
        try{
         
            Session session = factory.openSession();
            session.beginTransaction();
        
            String customerUsername = username;
            Query query = session.createQuery("from User where username = :customerUsername");
            query.setString("customerUsername", customerUsername);
          
            List<User> users =(List<User>) query.list();
            session.getTransaction().commit(); 
            session.close();
        
            for(User user : users){
                emailResult = user.getUsermail();
            }
            }catch(Exception e){
                System.out.println(e);
            }
        return emailResult;
    }
    
     //* We give the store's name and we search into the Store List file that store's email    *//
     //* TO DO: I need to change the first while argument cause we haven't yet add store email *//
     //* list into the storeList.txt file                                                      *//
    @Override
    public String readFromStoreListEmail(String storeName) throws FileNotFoundException{
      
        String emailResult = "";
        
        try{
           
            Session session = factory.openSession();
            session.beginTransaction();
        
            String nameOfStore = storeName;
            Query query = session.createQuery("from Store where nameOfStore = :nameOfStore");
            query.setString("nameOfStore", storeName);
          
            List<Store> stores =(List<Store>) query.list();
            session.getTransaction().commit(); 
            session.close();
        
            for(Store store : stores){
                emailResult = store.getEmail();
            }
            }catch(Exception e){
                System.out.println(e);
            }
        return emailResult;
    }
    
   
}
