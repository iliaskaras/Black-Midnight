/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_DBTesting;

import blackMidnight.controller.CreateStoreController;
import java.io.FileInputStream;
import static junit.framework.Assert.assertEquals;

import org.dbunit.Assertion;
import org.dbunit.DBTestCase;

import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import org.junit.Test;

/**
 *
 * @author Ilias
 */
public class StoreDAO_Test extends DBTestCase {

    private FlatXmlDataSet flatXmlInstance;

    public StoreDAO_Test(String name) throws Exception {
        super(name);

        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull");
        System.setProperty(PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root");
       // System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @Override
    protected IDataSet getDataSet() throws Exception {

        flatXmlInstance = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_store.xml"));
        return flatXmlInstance;

    }
    //@Before
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
   

    public void testDatabase() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        ITable result_set = db_testDataCon.getTable("store_test");

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_store.xml"));
        ITable result_expectedSet = expectedDataSet.getTable("store_test");

        Assertion.assertEquals(result_expectedSet, result_set);

    }
     @Test
    public void testStoreAddedSuccessful() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store11";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "storeAddress11";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-12:00";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "good store nice place";
        
        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount+1, afterStore_rowCount);

    }

    @Test
    public void testStoreNegativeNumberSeats() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store1";
        int numberOfSeats = -2;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-12:00";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "good store nice place";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }

    @Test
    public void testStoreZeroNumberSeats() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store1";
        int numberOfSeats = 0;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-12:00";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "good store nice place";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }

    @Test
    public void testStoreLargeNumberSeats() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store1";
        int numberOfSeats = 500000;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-12:00";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "good store nice place";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }

    @Test
    public void testStoreFalseName() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-12:00";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "good store nice place";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }

    @Test
    public void testStoreFalseAddress() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store1";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-12:00";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "good store nice place";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }

    @Test
    public void testStoreFalseCity() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store1";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-12:00";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "good store nice place";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }
    @Test
    public void testStorePhoneContainsString() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store7";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123fg34";
        String openDays = "5";
        String openHours = "10:00-20:00";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "good store nice place";
        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }

    @Test
    public void testStoreFalseOpenDays() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store1";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "";
        String openHours = "10:00-12:00";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "good store nice place";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }

    @Test
    public void testStoreFalseOpenHours() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store1";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "good store nice place";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }
    
    @Test
    public void testStoreNullStoreDetails() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store1";
        int numberOfSeats = -2;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-12:00";
        String email = "iliamyro@gmail.uk";
        String storeDetails = "";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }
    @Test
    public void testStoreAlreadyExist() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store1";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-20:00";
        String email = "iliamyro@gmail.uk";
         String storeDetails = "good store nice place";
        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }
    
    @Test
    public void testStoreDoesNotExist() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();

        String nameOfStore = "store7";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-20:00";
        String email = "iliamyro@gmail.uk";
         String storeDetails = "good store nice place";
        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount+1, afterStore_rowCount);

    }
    
    @Test
    public void testStoreFalseEmail() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();
         String storeDetails = "good store nice place";
        String nameOfStore = "store7";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-20:00";
        String email = "iliamyro";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount, afterStore_rowCount);

    }
    
    @Test
    public void testStoreCorrectEmail() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("store_test").getRowCount();
         String storeDetails = "good store nice place";
        String nameOfStore = "store7";
        int numberOfSeats = 50;
        boolean parking = true;
        String storeAddress = "storeAddress1";
        String storeCity = "storeCity1";
        String storePhone = "123";
        String openDays = "5";
        String openHours = "10:00-20:00";
        String email = "iliamyro@hol.gr";

        CreateStoreController instance = new CreateStoreController();
        instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, storeAddress, storeCity, storePhone, openDays, openHours, email, storeDetails);
        int afterStore_rowCount = db_testDataCon.getTable("store_test").getRowCount();
        assertEquals(existing_rowCount+1, afterStore_rowCount);

    }
    
   
}
