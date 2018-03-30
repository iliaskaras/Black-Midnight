/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_DBTesting;

//import blackMidnight.DAO.GetReservationHistoryDAO;
//import blackMidnight.DAO.IGetReservationHistoryDAO;
import blackMidnight.DAO_forTests.GetReservationHistoryDAO_forTest;
import blackMidnight.controller.CreateReservationController;
import blackMidnight.model_forTests.Reservation_Test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.dbunit.DBTestCase;
import org.dbunit.DefaultOperationListener;
import org.dbunit.IOperationListener;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Test;

/**
 *
 * @author Ilias
 */
public class GetReservationHistoryDAO_Test extends DBTestCase{
    
    private FlatXmlDataSet flatXmlIntance;
 
//     protected IOperationListener getOperationListener() {
//                    return new DefaultOperationListener(){
//                        public void operationSetUpFinished( IDatabaseConnection connection) 
//                        {
//                            // Do not invoke the "super" method to avoid that the connection is closed
//                        }
//                        public void operationTearDownFinished(IDatabaseConnection connection) 
//                        {
//                            // Do not invoke the "super" method to avoid that the connection is closed
//                        }
//                    };
//                }
    public GetReservationHistoryDAO_Test(String name) throws Exception {
        super(name);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root" );
       // System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
    
    }

   
    protected IDataSet getDataSet() throws Exception {
        
        flatXmlIntance=new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_reservation.xml"));
        return flatXmlIntance;
        
    }
    
    protected DatabaseOperation getSetUpOperation() throws Exception{
          
        //return DatabaseOperation.REFRESH;
        return DatabaseOperation.CLEAN_INSERT;
        //return DatabaseOperation.DELETE;
        
    }
    
    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception{
        
        getConnection().close();
        return DatabaseOperation.CLOSE_CONNECTION(DatabaseOperation.NONE);
        
    }
 
    @Test
    public void testGetReservationsForKnownStore() throws Exception{
       
        boolean finalResult = false;
        String storeName = "storename1";
        String userName = "username1";
        GetReservationHistoryDAO_forTest instance = new GetReservationHistoryDAO_forTest();
        List<Reservation_Test> reservations;
       
        reservations = instance.getReservationsHistoryForSpecificStoreForTests(storeName,userName);
        if(reservations.isEmpty())
            finalResult = false;
        else 
            finalResult = true;
       
        assertEquals(true, finalResult);
    }
    
    @Test
    public void testGetReservationsForUnknownStore() throws Exception{
       
        boolean finalResult = false;
        String storeName = "unknownStoreName";
        String userName = "username1";
        GetReservationHistoryDAO_forTest instance = new GetReservationHistoryDAO_forTest();
        List<Reservation_Test> reservations;
        
        reservations = instance.getReservationsHistoryForSpecificStoreForTests(storeName,userName);
        if(reservations.isEmpty())
            finalResult = false;
        else 
            finalResult = true;
       
        assertEquals(false, finalResult);
    }
    
    @Test
    public void testGetReservationsForKnownUsername() throws Exception{
       
        boolean finalResult = false;
        String storeName = "storename1";
        String userName = "username1";
        GetReservationHistoryDAO_forTest instance = new GetReservationHistoryDAO_forTest();
        List<Reservation_Test> reservations;
        
        reservations = instance.getReservationsHistoryForSpecificStoreForTests(storeName,userName);
        if(reservations.isEmpty())
            finalResult = false;
        else 
            finalResult = true;
       
        assertEquals(true, finalResult);
    }
    
    @Test
    public void testGetReservationsForUnknownUsername() throws Exception{
       
        boolean finalResult = false;
        String storeName = "storename1";
        String userName = "unknownUsername";
        GetReservationHistoryDAO_forTest instance = new GetReservationHistoryDAO_forTest();
        List<Reservation_Test> reservations;
        
        reservations = instance.getReservationsHistoryForSpecificStoreForTests(storeName,userName);
        if(reservations.isEmpty())
            finalResult = false;
        else 
            finalResult = true;
       
        assertEquals(false, finalResult);
    }
    
    @Test
    public void testAllReservationsKnownCustomerUsername() throws Exception{
       
        boolean finalResult = false;
        String username = "username1";
        GetReservationHistoryDAO_forTest instance = new GetReservationHistoryDAO_forTest();
        List<Reservation_Test> reservations;
        
        reservations = instance.getAllReservationsForTests(username);
        if(reservations.isEmpty())
            finalResult = false;
        else 
            finalResult = true;
       
        assertEquals(true, finalResult);
    }
    
    @Test
    public void testAllReservationsUnknownCustomerUsername() throws Exception{
       
        boolean finalResult = false;
        String username = "unknownUsername";
        GetReservationHistoryDAO_forTest instance = new GetReservationHistoryDAO_forTest();
        List<Reservation_Test> reservations;
        
        reservations = instance.getAllReservationsForTests(username);
        if(reservations.isEmpty())
            finalResult = false;
        else 
            finalResult = true;
       
        assertEquals(false, finalResult);
    }
}
