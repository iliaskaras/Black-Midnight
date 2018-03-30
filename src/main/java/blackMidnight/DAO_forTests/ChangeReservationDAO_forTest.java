/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_forTests;

import blackMidnight.model_forTests.Reservation_Test;
import blackMidnight.util.HibernateUtilTest;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ilias
 */
public class ChangeReservationDAO_forTest {
    
    private static SessionFactory factory = HibernateUtilTest.getSessionFactory();
    
    public List<Reservation_Test> getData(int id){
               
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Reservation_Test where reservationId="+id);
       
        List<Reservation_Test> re = (List<Reservation_Test>) query.list();
        session.getTransaction().commit(); 
        session.close();
         
        if(re.isEmpty()){
            return null;
        }
        else{
            return re;
        }
        
    }
    
     public List<Reservation_Test> getDataByname(String Name){
               
        Session session = factory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Reservation_Test where customerName='"+Name+"'");
       
        List<Reservation_Test> re = (List<Reservation_Test>) query.list();
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

    public boolean change(Reservation_Test re){
        try{
        Session session = factory.openSession();
        session.beginTransaction();
        String hql = "UPDATE Reservation_Test SET customerName = :customerName, numberOfSeats = :numberOfSeats, "
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
