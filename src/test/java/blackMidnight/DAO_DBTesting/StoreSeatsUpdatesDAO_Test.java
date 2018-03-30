/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_DBTesting;

import blackMidnight.DAO.StoreSeatsUpdatesDAO;
import blackMidnight.DAO_forTests.StoreSeatsUpdatesDAO_forTest;
import blackMidnight.controller.CreateReservationController;
import blackMidnight.model.Reservation;
import blackMidnight.model_forTests.Reservation_Test;
import blackMidnight.util.HibernateUtilTest;
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
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ilias
 */
public class StoreSeatsUpdatesDAO_Test extends DBTestCase {

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
    public StoreSeatsUpdatesDAO_Test(String name) throws Exception {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
      //  System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
     }

    protected IDataSet getDataSet() throws Exception {

        flatXmlIntance = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_reservationbydate_test.xml"));
        return flatXmlIntance;

    }
    
    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {

        
        //return DatabaseOperation.REFRESH;
        return DatabaseOperation.CLEAN_INSERT;
        //return DatabaseOperation.DELETE;

    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        
        getConnection().close();
        return DatabaseOperation.NONE;

    }
    
    
  
   
    @Test
    public void testUpdateSpecificDaySeatsSuccess() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservationbydate_test").getRowCount();
        Reservation_Test cr = new Reservation_Test();
        cr.setCustomerName("ilias");
        cr.setDate("2013/12/02");
        cr.setNumberOfSeats(1);
        cr.setStoreName("store1");
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();

        boolean result = StoreSeatsUpdatesDAO_forTest.updateSpecificStoreDateReservationSeatsForTests(cr, factoryForTests);
        int afterReservation_rowCount = db_testDataCon.getTable("reservationbydate_test").getRowCount();
        session.close();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testUpdateSpecificDaySeatsFailed() throws Exception {

        Reservation_Test cr = new Reservation_Test();
        cr.setCustomerName("ilias");
        cr.setDate("2013/12/02");
        cr.setNumberOfSeats(66); //* we dont have that many seats available for the specific day for store1 into our test database *//
        cr.setStoreName("store1");
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();
        boolean expResult = false;
        boolean result = StoreSeatsUpdatesDAO_forTest.updateSpecificStoreDateReservationSeatsForTests(cr, factoryForTests);
        session.close();
        assertEquals(expResult, result);

    }

    @Test
    public void testCreateSpecificDayForStoreSuccess() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservationbydate_test").getRowCount();
        Reservation_Test cr = new Reservation_Test();
        cr.setCustomerName("ilias");
        cr.setDate("2013/12/03"); //* we dont have that date for that store into our testing database *//
        cr.setNumberOfSeats(1);
        cr.setStoreName("store1");
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();

        boolean result = StoreSeatsUpdatesDAO_forTest.updateSpecificStoreDateReservationSeatsForTests(cr, factoryForTests);
        int afterReservation_rowCount = db_testDataCon.getTable("reservationbydate_test").getRowCount();
        session.close();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testCreateSpecificDayForStoreFailed() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservationbydate_test").getRowCount();
        Reservation_Test cr = new Reservation_Test();
        cr.setCustomerName("ilias");
        cr.setDate("2013/12/03"); //* we dont have that date for that store into our database for testing *//
        cr.setNumberOfSeats(77);  //* but we dont have that many seats available for one day *//
        cr.setStoreName("store1");
        SessionFactory factoryForTests = HibernateUtilTest.getSessionFactory();
        Session session = factoryForTests.openSession();

        boolean result = StoreSeatsUpdatesDAO_forTest.updateSpecificStoreDateReservationSeatsForTests(cr, factoryForTests);
        int afterReservation_rowCount = db_testDataCon.getTable("reservationbydate_test").getRowCount();
        session.close();
        assertEquals(4, afterReservation_rowCount);

    }

}
