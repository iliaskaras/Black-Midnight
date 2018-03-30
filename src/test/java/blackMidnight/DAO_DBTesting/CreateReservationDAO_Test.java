/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_DBTesting;

import blackMidnight.controller.CreateReservationController;
import blackMidnight.controller_forTests.CreateReservationController_Test;
import java.io.FileInputStream;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static junit.framework.Assert.assertEquals;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.DefaultOperationListener;
import org.dbunit.IOperationListener;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ilias
 */
public class CreateReservationDAO_Test extends DBTestCase {

    private FlatXmlDataSet flatXmlIntance;

    //* with getOperationListener we keep the same connection opened for all tests that will run, instead of closing and re-openning the connections *//
//   protected IOperationListener getOperationListener() {
//                return new DefaultOperationListener(){
//                    public void operationSetUpFinished( IDatabaseConnection connection) 
//                    {
//                        // Do not invoke the "super" method to avoid that the connection is closed
//                    }
//                    public void operationTearDownFinished(IDatabaseConnection connection) 
//                    {
//                        // Do not invoke the "super" method to avoid that the connection is closed
//                    }
//                };
//            }
       
    public CreateReservationDAO_Test(String name) throws Exception {
        super(name);
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
     //   System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
        
    }

    protected IDataSet getDataSet() throws Exception {

        flatXmlIntance = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_reservation.xml"));
        return flatXmlIntance;

    }
   // @Before
    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {

       return DatabaseOperation.CLEAN_INSERT;
     
    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        
        getConnection().close();
        return DatabaseOperation.NONE;
        

    }
   
    public void testNumberOfReservations() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        assertEquals(4, existing_rowCount);

    }

    public void testFirstReservationId() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT reservationId FROM reservation_test WHERE reservationId = 1");

        assertEquals(1, actualDbData.getValue(0, "reservationId"));

    }

    public void testLastReservationId() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT reservationId FROM reservation_test WHERE reservationId = 4");

        assertEquals(4, actualDbData.getValue(0, "reservationId"));

    }

    public void testUnknownReservationId() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT reservationId FROM reservation_test WHERE reservationId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

    public void testFirstReservationCustomerName() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT customerName FROM reservation_test WHERE reservationId = 1");

        assertEquals("customername1", actualDbData.getValue(0, "customerName"));

    }

    public void testLastReservationCustomerName() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT customerName FROM reservation_test WHERE reservationId = 4");

        assertEquals("customername4", actualDbData.getValue(0, "customerName"));

    }

    public void testUnknownReservationCustomerName() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT customerName FROM reservation_test WHERE reservationId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

    public void testFirstReservationCustomerUsername() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT customerUsername FROM reservation_test WHERE reservationId = 1");

        assertEquals("username1", actualDbData.getValue(0, "customerUsername"));

    }

    public void testLastReservationCustomerUsername() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT customerUsername FROM reservation_test WHERE reservationId = 4");

        assertEquals("username4", actualDbData.getValue(0, "customerUsername"));

    }

    public void testUnknownReservationCustomerUsername() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT customerUsername FROM reservation_test WHERE reservationId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

    public void testFirstReservationDate() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT date FROM reservation_test WHERE reservationId = 1");

        assertEquals("date1", actualDbData.getValue(0, "date"));

    }

    public void testLastReservationDate() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT date FROM reservation_test WHERE reservationId = 4");

        assertEquals("date4", actualDbData.getValue(0, "date"));

    }

    public void testUnknownReservationDate() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT date FROM reservation_test WHERE reservationId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

    public void testFirstReservationHour() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT hour FROM reservation_test WHERE reservationId = 1");

        assertEquals("18:00-20:00", actualDbData.getValue(0, "hour"));

    }

    public void testLastReservationHour() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT hour FROM reservation_test WHERE reservationId = 4");

        assertEquals("18:00-20:00", actualDbData.getValue(0, "hour"));

    }

    public void testUnknownReservationHour() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT hour FROM reservation_test WHERE reservationId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

    public void testFirstReservationNumberOfSeats() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT numberOfSeats FROM reservation_test WHERE reservationId = 1");

        assertEquals(55, actualDbData.getValue(0, "numberOfSeats"));

    }

    public void testLastReservationNumberOfSeats() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT numberOfSeats FROM reservation_test WHERE reservationId = 4");

        assertEquals(55, actualDbData.getValue(0, "numberOfSeats"));

    }

    public void testUnknownReservationNumberOfSeats() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT numberOfSeats FROM reservation_test WHERE reservationId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

    public void testFirstReservationReservation_Code() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT reservationCode FROM reservation_test WHERE reservationId = 1");

        assertEquals("code1", actualDbData.getValue(0, "reservationCode"));

    }

    public void testLastReservationReservation_Code() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT reservationCode FROM reservation_test WHERE reservationId = 4");

        assertEquals("code4", actualDbData.getValue(0, "reservationCode"));

    }

    public void testUnknownReservationReservation_Code() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT reservationCode FROM reservation_test WHERE reservationId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

    public void testFirstReservationStoreName() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT storeName FROM reservation_test WHERE reservationId = 1");

        assertEquals("storename1", actualDbData.getValue(0, "storeName"));

    }

    public void testLastReservationStoreName() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT storeName FROM reservation_test WHERE reservationId = 4");

        assertEquals("storename4", actualDbData.getValue(0, "storeName"));

    }

    public void testUnknownReservationStoreName() throws Exception, SQLException, Throwable {

        ITable actualDbData = getConnection().createQueryTable("s", "SELECT storeName FROM reservation_test WHERE reservationId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

    public void testDatabase() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        ITable result_set = db_testDataCon.getTable("reservation_test");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/3021_flatXmlDataSet_reservation_2.xml"));
        ITable result_expectedSet = expectedDataSet.getTable("reservation_test");

        Assertion.assertEquals(result_expectedSet, result_set);

    }

    @Test
    public void testcreateReservationNegativeNumberSeats() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "-2";
        String storeName = "store1";
        String dateToFile = "qwdqwd";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";

        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationPositiveNumberSeats() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "2";
        String storeName = "store1";
        String dateToFile = "2014/01/01";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationZeroNumberSeats() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "0";
        String storeName = "storename1";
        String dateToFile = "qwdqwd";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationNullStoreName() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "2";
        String storeName = "";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationNotNullStoreName() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "2";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationUnknownStoreName() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "2";
        String storeName = "asdasd";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationKnownStoreName() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "2";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationNullCustomerName() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "";
        String numberOfSeats = "2";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationNotNullCustomerName() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "2";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationNullDate() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "2";
        String storeName = "store1";
        String dateToFile = "";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationNotNullDate() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "2";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationUnavailableSeats() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "666"; //** at store1 we have 55 available seats **///
        String storeName = "storename1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationAvailableSeats() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "1"; //** at store1 we have 20 available seats **///
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationLongUsernameInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "111111111111111111111111111111"; //* length>=25 *//
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationProperUsernameLengthInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "11111111";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationKnownUsernameInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "11111111";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationUnknownUsernameInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "1";
        String storeName = "storenamestorenamestorenamestorenamestorename";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "unknownUsername";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationLongDateInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "datedatedatedatedatedatedatedatedatedatedate";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationProperDateLengthInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "datedatedatedate";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationWrongTimeInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "date1";
        String uid = "uid";
        String hour = "21:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationKnownTimeInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "date1";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationNullUidInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "date1";
        String uid = "";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationNotNullUidInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "date1";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationAvailableStoreDayInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "11111111";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testcreateReservationUnavailableStoreDayInput() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "11111111";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Παρ";
        String openHours = "18:00-20:00";
        
        CreateReservationController_Test instance = new CreateReservationController_Test();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay,openHours);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }
}
