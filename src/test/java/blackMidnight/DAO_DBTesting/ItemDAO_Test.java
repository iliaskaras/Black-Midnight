/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO_DBTesting;

import blackMidnight.controller.AddItemController;
import java.io.FileInputStream;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static junit.framework.Assert.assertEquals;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
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
public class ItemDAO_Test extends DBTestCase {

   private FlatXmlDataSet flatXmlIntance;
    private  IDatabaseConnection conn;



    public ItemDAO_Test(String name) throws Exception {
        
        super(name);
        
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
  //      System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
        this.conn = getConnection();
    }

    protected IDataSet getDataSet() throws Exception {

        flatXmlIntance = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_item.xml"));
        return flatXmlIntance;

    }
   // @Before
    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {

       
        return DatabaseOperation.CLEAN_INSERT;
       

    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {

        return DatabaseOperation.CLOSE_CONNECTION(DatabaseOperation.NONE);

    }
  /*  @Before
    @Override
    public void setUp() throws Exception {
        this.conn = getConnection();
    }*/
    @After
    @Override
    public void tearDown() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public void testNumberOfItems() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        assertEquals(4, existing_rowCount);

    }

    public void testFirstItemId() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemId FROM item_test WHERE itemId = 1");

        assertEquals(1, actualDbData.getValue(0, "itemId"));

    }

    public void testLastItemId() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemId FROM item_test WHERE itemId = 4");

        assertEquals(4, actualDbData.getValue(0, "itemId"));

    }

    public void testUnknownItemId() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemId FROM item_test WHERE itemId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

    public void testFirstItemName() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemName FROM item_test WHERE itemId = 1");

        assertEquals("itemname1", actualDbData.getValue(0, "itemName"));

    }

    public void testLastItemName() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemName FROM item_test WHERE itemId = 4");

        assertEquals("itemname4", actualDbData.getValue(0, "itemName"));

    }

    public void testUnknownItemName() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemName FROM item_test WHERE itemId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

    public void testFirstItemType() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemType FROM item_test WHERE itemId = 1");

        assertEquals("itemtype1", actualDbData.getValue(0, "itemType"));

    }

    public void testLastItemType() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemType FROM item_test WHERE itemId = 4");

        assertEquals("itemtype4", actualDbData.getValue(0, "itemType"));

    }

    public void testUnknownItemType() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemType FROM item_test WHERE itemId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

 
    public void testFirstItemPrice() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemPrice FROM item_test WHERE itemId = 1");

        assertEquals(55, actualDbData.getValue(0, "itemPrice"));

    }

    public void testLastItemPrice() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemPrice FROM item_test WHERE itemId = 4");

        assertEquals(55, actualDbData.getValue(0, "itemPrice"));

    }

    public void testUnknownItemPrice() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemPrice FROM item_test WHERE itemId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }
    
     public void testFirstItemQuantity() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemQuantity FROM item_test WHERE itemId = 1");

        assertEquals(200, actualDbData.getValue(0, "itemQuantity"));

    }

    public void testLastItemQuantity() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemQuantity FROM item_test WHERE itemId = 4");

        assertEquals(200, actualDbData.getValue(0, "itemQuantity"));

    }

    public void testUnknownItemQuantity() throws Exception, SQLException, Throwable {

        ITable actualDbData = conn.createQueryTable("s", "SELECT itemQuantity FROM item_test WHERE itemId = 5");

        assertEquals(0, actualDbData.getRowCount());

    }

 

    public void testDatabase() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        ITable result_set = db_testDataCon.getTable("item_test");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_item.xml"));
        ITable result_expectedSet = expectedDataSet.getTable("item_test");

        Assertion.assertEquals(result_expectedSet, result_set);

    }

    @Test
    public void testaddItemNegativeItemPrice() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemName";
        String itemType = "item1";
        int itemPrice = -2 ;
        int itemQuantity = 10;

        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testaddItemPositiveItemPrice() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemName";
        String itemType = "item1";
        int itemPrice = 2 ;
        int itemQuantity = 10;
        
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testaddItemZeroItemPrice() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemName";
        String itemType = "item1";
        int itemPrice = 0 ;
        int itemQuantity = 10;
        
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);


    }
    
     @Test
    public void testaddItemNegativeItemQuantity() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemName";
        String itemType = "item1";
        int itemPrice = 10 ;
        int itemQuantity = -2;

        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testaddItemPositiveItemQuantity() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemName";
        String itemType = "item1";
        int itemPrice = 10 ;
        int itemQuantity = 2;
        
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testaddItemZeroItemQuantity() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemName";
        String itemType = "item1";
        int itemPrice = 10 ;
        int itemQuantity = 0;
        
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);


    }

    @Test
    public void testaddItemNullItemName() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "";
        String itemType = "itemtype1";
        int itemPrice = 2;
        int itemQuantity = 10;
        
       
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testaddItemNotNullItemName() throws Exception {
           IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemname1";
        String itemType = "itemtype1";
        int itemPrice = 2;
        int itemQuantity = 10;
        
       
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testaddItemUnknownItemName() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "asdadsd";
        String itemType = "itemtype1";
        int itemPrice = 2;
        int itemQuantity = 10;
        
       
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(existing_rowCount+1, afterReservation_rowCount);

    }
    
    @Test
    public void testaddItemKnownItemName() throws Exception {
           IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemname1";
        String itemType = "itemtype1";
        int itemPrice = 2;
        int itemQuantity = 10;
        
       
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

  @Test
    public void testaddItemNullItemType() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemname1";
        String itemType = "";
        int itemPrice = 2;
        int itemQuantity = 10;
        
       
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }

    @Test
    public void testaddItemNotNullItemType() throws Exception {
           IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemname1";
        String itemType = "itemtype1";
        int itemPrice = 2;
        int itemQuantity = 10;
        
       
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }

    @Test
    public void testaddItemUnknownItemType() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemname1";
        String itemType = "asdda";
        int itemPrice = 2;
        int itemQuantity = 10;
        
       
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(existing_rowCount+1, afterReservation_rowCount);

    }
    
    @Test
    public void testaddItemKnownItemType() throws Exception {
           IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("item_test").getRowCount();

        String itemName = "itemname1";
        String itemType = "itemtype1";
        int itemPrice = 2;
        int itemQuantity = 10;
        
       
        AddItemController instance = new AddItemController();
        boolean result = instance.addItemForTest(itemName, itemType, itemPrice, itemQuantity);
        int afterReservation_rowCount = db_testDataCon.getTable("item_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }


 

 





   /*  Make: for price and quantity available
    
    @Test
    public void testcreateReservationAvailableSeats() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "customerName";
        String numberOfSeats = "20"; //** at store1 we have 20 available seats 
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        CreateReservationController instance = new CreateReservationController();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);
 
     */ 

   /*  MAKE : For itemName and itemTYPE
    
    @Test
    public void testaddItemLongUsernameInput() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "111111111111111111111111111111"; //* length>=25 
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        CreateReservationController instance = new CreateReservationController();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(4, afterReservation_rowCount);

    }*/

   /* @Test
    public void testcreateReservationProperUsernameLengthInput() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();

        String customerName = "11111111";
        String numberOfSeats = "1";
        String storeName = "store1";
        String dateToFile = "date";
        String uid = "uid";
        String hour = "19:00";
        String userName = "karona";
        String chosenDay = "Δευ";
        CreateReservationController instance = new CreateReservationController();
        boolean result = instance.createReservationForTests(customerName, numberOfSeats, storeName, dateToFile, hour, uid, userName, chosenDay);
        int afterReservation_rowCount = db_testDataCon.getTable("reservation_test").getRowCount();
        assertEquals(5, afterReservation_rowCount);

    }*/

   
   


}
