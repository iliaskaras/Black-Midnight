/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO_DBTesting;

import blackMidnight.DAO_forTests.LoginDAO_Test;
import java.io.FileInputStream;
import java.sql.SQLException;
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
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ilias
 */
public class LoginDAO_TestTest extends DBTestCase{
    
    private FlatXmlDataSet flatXmlIntance;
    private  IDatabaseConnection conn;
    public LoginDAO_TestTest(String name) throws Exception {
       super(name);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root" ); 
      //  System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
        this.conn = getConnection();
    }
   
   
    @Override
    protected IDataSet getDataSet() throws Exception {
         flatXmlIntance=new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_user.xml"));
        return flatXmlIntance;
    }
   
    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception{
          
        return DatabaseOperation.CLEAN_INSERT;
    }
   
    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception{
        
        return DatabaseOperation.DELETE_ALL;
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }
   /* @Before
    @Override
    public void setUp() throws Exception {
        this.conn = getConnection();
        //conn.createDataSet();
    }*/
      @After
    @Override
    public void tearDown() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }
      @Test
    public void testNumberOfUsers() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(4,existing_rowCount);
        
    }
     @Test
    public void testDatabase() throws Exception {
        IDataSet db_testDataCon = conn.createDataSet();
        ITable result_set = db_testDataCon.getTable("storeowners_test");
        
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_storeOwner.xml"));
        ITable result_expectedSet = expectedDataSet.getTable("storeowners_test");
        
        Assertion.assertEquals(result_expectedSet,result_set);
       
    }

    /**
     * Test of userLogin method, of class LoginDAO_Test.
     */
//    @Test
//    public void testUserLogin() {
//        System.out.println("userLogin");
//        String username = "";
//        String password = "";
//        LoginDAO_Test instance = new LoginDAO_Test();
//        Integer expResult = null;
//        Integer result = instance.userLogin(username, password);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of ownerLogin method, of class LoginDAO_Test.
     */
//    @Test
//    public void testOwnerLogin() {
//        System.out.println("ownerLogin");
//        Integer userID = null;
//        LoginDAO_Test instance = new LoginDAO_Test();
//        Integer expResult = null;
//        Integer result = instance.ownerLogin(userID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
