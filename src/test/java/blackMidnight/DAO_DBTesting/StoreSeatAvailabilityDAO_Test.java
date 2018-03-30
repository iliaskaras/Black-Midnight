/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_DBTesting;

import blackMidnight.DAO.StoreSeatAvailabilityDAO;
import blackMidnight.DAO_forTests.StoreSeatAvailabilityDAO_forTest;
import java.io.FileInputStream;
import java.sql.SQLException;
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
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ilias
 */
public class StoreSeatAvailabilityDAO_Test extends DBTestCase {

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
    public StoreSeatAvailabilityDAO_Test(String name) throws Exception {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
       // System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
       
    }
   
    @Override
    protected IDataSet getDataSet() throws Exception {

        flatXmlIntance = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_reservationbydate_test.xml"));
        return flatXmlIntance;

    }

    protected DatabaseOperation getSetUpOperation() throws Exception {

        
        //return DatabaseOperation.REFRESH;
        return DatabaseOperation.CLEAN_INSERT;
        //return DatabaseOperation.DELETE;

    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        
        getConnection().close();
        return DatabaseOperation.CLOSE_CONNECTION(DatabaseOperation.NONE);

    }
    
   
    @Test
    public void testCheckIfStoreNameAvailable() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        String storeName = "store1";  /* We havent saved any store with name wrongStoreName into the store file */

        StoreSeatAvailabilityDAO_forTest instance = new StoreSeatAvailabilityDAO_forTest();
        boolean expResult = true;
        boolean result = instance.checkIfStoreNameAvailableForTests(storeName);
        assertEquals(expResult, result);

    }

    @Test
    public void testCheckIfStoreNameUnavailable() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();

        String storeName = "wrongStoreName";  /* We havent saved any store with name wrongStoreName into the store file */

        StoreSeatAvailabilityDAO_forTest instance = new StoreSeatAvailabilityDAO_forTest();
        boolean expResult = false;
        boolean result = instance.checkIfStoreNameAvailableForTests(storeName);
        assertEquals(expResult, result);

    }

    @Test
    public void testCheckIfStoreSeatAvailable() throws Exception {
        String storeName = "store1";
        int seat = 30; /* store with name store1 havent 30 seats available */

        StoreSeatAvailabilityDAO_forTest instance = new StoreSeatAvailabilityDAO_forTest();
        boolean expResult = true;
        boolean result = instance.checkIfStoreSeatAvailableForTests(seat, storeName);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckIfStoreSeatUnavailable() throws Exception {
        String storeName = "store1";
        int seat = 77; /* store with name store1 havent 77 seats available */

        StoreSeatAvailabilityDAO_forTest instance = new StoreSeatAvailabilityDAO_forTest();
        boolean expResult = false;
        boolean result = instance.checkIfStoreSeatAvailableForTests(seat, storeName);
        assertEquals(expResult, result);
    }

    @Test
    public void testCheckIfStoreSeatAvailableAtSpecificDay() throws Exception {
        boolean actualResult;
        String storeName = "store1";
        String date = "2013/12/02";
        int seat = 1; /* store with name store1 1 seat available */

        StoreSeatAvailabilityDAO_forTest instance = new StoreSeatAvailabilityDAO_forTest();
        boolean expResult = true;
        String result = instance.checkIfStoreSeatAvailableAtSpecificDayForTests(seat, storeName, date);
        if (result.equals("unavailablySeats")) {
            actualResult = false;
        } else {
            actualResult = true;
        }
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testCheckIfStoreSeatUnavailableAtSpecificDay() throws Exception {
        boolean actualResult;
        String storeName = "store1";
        String date = "2013/12/02";
        int seat = 77; /* store with name store1 dont have 77 seats available */

        StoreSeatAvailabilityDAO_forTest instance = new StoreSeatAvailabilityDAO_forTest();
        boolean expResult = false;
        String result = instance.checkIfStoreSeatAvailableAtSpecificDayForTests(seat, storeName, date);
        if (result.equals("unavailablySeats")) {
            actualResult = false;
        } else {
            actualResult = true;
        }
        assertEquals(expResult, actualResult);
    }

    @Test
    public void testIfSpecificDayReservationExistsIntoDataBaseSuccess() throws Exception {
        boolean actualResult;
        String storeName = "store1";
        String date = "2013/12/02";
        int seat = 1; /* store with name store1 dont have 77 seats available */

        StoreSeatAvailabilityDAO_forTest instance = new StoreSeatAvailabilityDAO_forTest();
        boolean expResult = true;
        boolean result = instance.checkIfRowForSpecificDayReservationExistsForTests(storeName, date);
        assertEquals(expResult, result);
    }

    @Test
    public void testIfSpecificDayReservationExistsIntoDataBaseSuccessFailed() throws Exception {
        boolean actualResult;
        String storeName = "store1";
        String date = "2014/12/02";
        int seat = 1; /* store with name store1 dont have 77 seats available */

        StoreSeatAvailabilityDAO_forTest instance = new StoreSeatAvailabilityDAO_forTest();
        boolean expResult = false;
        boolean result = instance.checkIfRowForSpecificDayReservationExistsForTests(storeName, date);
        assertEquals(expResult, result);
    }

}
