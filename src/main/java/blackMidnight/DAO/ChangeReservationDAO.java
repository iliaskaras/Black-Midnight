/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;


import blackMidnight.model.Reservation;
import blackMidnight.model.Store;
import blackMidnight.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class ChangeReservationDAO {
    
    private static SessionFactory factory = HibernateUtil.getSessionFactory();
    
    public List<Reservation> getData(int id){
               
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Reservation where reservationId="+id);
       
        List<Reservation> re = (List<Reservation>) query.list();
        session.getTransaction().commit(); 
        session.close();
         
        if(re.isEmpty()){
            return null;
        }
        else{
            return re;
        }
        
    }
    
     public List<Reservation> getDataByname(String Name){
               
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Reservation where customerName='"+Name+"'");
       
        List<Reservation> re = (List<Reservation>) query.list();
        session.getTransaction().commit(); 
        session.close();
         
        if(re.isEmpty()){
            return null;
        }
        else{
            return re;
        }
        
    }
    /**
     *
     * @param re
     */

    public boolean change(Reservation re){
        try{
        Session session = factory.openSession();
        session.beginTransaction();
        String hql = "UPDATE Reservation SET customerName = :customerName, numberOfSeats = :numberOfSeats, "
                + "storeName = :storeName, date = :date, hour = :hour "
                + "WHERE reservationId = :reservationId";
        Query query = session.createQuery(hql);
        query.setParameter("customerName", re.getCustomerName());
        query.setParameter("numberOfSeats", re.getNumberOfSeats());
        query.setParameter("storeName", re.getStoreName());
        query.setParameter("date",re.getDate().toString());
        query.setParameter("hour",re.getHour().toString());
     
        query.setParameter("reservationId", re.getReservationId());
        int rows = query.executeUpdate();
        session.getTransaction().commit();
        if(rows==0)
            return false;
        else  
            return true;
    }
    catch (Exception e){
            System.out.println("Connection to Database FAILED!  " + e);
        return false;
    }
        
        
           
}
}


