/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO_DBTesting;

import blackMidnight.DAO_forTests.UserDAO_Test;
import blackMidnight.controller_forTests.RegisterUserController_forTests;
import blackMidnight.model.User;
import blackMidnight.model_forTests.User_Test;
import java.io.FileInputStream;
import java.sql.SQLException;
import org.dbunit.Assertion;
import org.dbunit.DBTestCase;
import org.dbunit.DefaultOperationListener;
import org.dbunit.IOperationListener;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.database.DatabaseConfig;
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
public class UserDAO_TestTest extends DBTestCase {
   
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
    public UserDAO_TestTest(String name) throws Exception {
       super(name);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root" ); 
     //   System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
       
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
        
        getConnection().close();
        return DatabaseOperation.NONE;
        
    }
    
    
 
     @Test
    public void testNumberOfUsers() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(4,existing_rowCount);
        
    }
     @Test
    public void testDatabase() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        ITable result_set = db_testDataCon.getTable("user_test");
        
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_user.xml"));
        ITable result_expectedSet = expectedDataSet.getTable("user_test");
        
        Assertion.assertEquals(result_expectedSet,result_set);
       
    }
    @Test
    public void testAddUserSuccess() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        User_Test user = new User_Test( "jolteen", "Giota" , "Jolteen" ,"1236547890", "kati" , "f_jolteen@yahoo.gr");
        
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean result = instance.registerUserControllerForTests(user);
        UserDAO_Test udt = new UserDAO_Test();
        if(result)
            udt.addUserTest(user);
        int afterReservation_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(existing_rowCount+1, afterReservation_rowCount);
       
    }
    
    @Test
    public void testAddUserLongUsername() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        User_Test user = new User_Test( "jolteenjjajkfjafkdanfajkfn", "Giota" , "Jolteen" ,"1236547890", "kati" , "f_jolteen@yahoo.gr");
        
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean result = instance.registerUserControllerForTests(user);
        UserDAO_Test udt = new UserDAO_Test();
        if(result)
            udt.addUserTest(user);
        int afterReservation_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(existing_rowCount, afterReservation_rowCount);
      
    }
    
    @Test
    public void testAddUserEmptyUsername() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        User_Test user = new User_Test( "", "Giota" , "Jolteen" ,"1236547890", "kati" , "f_jolteen@yahoo.gr");
        
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean result = instance.registerUserControllerForTests(user);
        UserDAO_Test udt = new UserDAO_Test();
        if(result)
            udt.addUserTest(user);
        int afterReservation_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(existing_rowCount, afterReservation_rowCount);
        
    }
    @Test
    public void testAddUserEmptyPassword() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        User_Test user = new User_Test( "jolteen", "Giota" , "Jolteen" ,"1236547890", "" , "f_jolteen@yahoo.gr");
        
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean result = instance.registerUserControllerForTests(user);
        UserDAO_Test udt = new UserDAO_Test();
        if(result)
            udt.addUserTest(user);
        int afterReservation_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(existing_rowCount, afterReservation_rowCount);
       
    }
    @Test
    public void testAddUserLongFirstName() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        User_Test user = new User_Test( "jolteen", "Giotaaffdfaffafdfdafafaf" , "Jolteen" ,"1236547890", "kati" , "f_jolteen@yahoo.gr");
        
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean result = instance.registerUserControllerForTests(user);
        UserDAO_Test udt = new UserDAO_Test();
        if(result)
            udt.addUserTest(user);
        int afterReservation_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(existing_rowCount, afterReservation_rowCount);
        
    }
    @Test
    public void testAddUserEmptyFirstName() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        User_Test user = new User_Test( "jolteen", "" , "Jolteen" ,"1236547890", "kati" , "f_jolteen@yahoo.gr");
        
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean result = instance.registerUserControllerForTests(user);
        UserDAO_Test udt = new UserDAO_Test();
        if(result)
            udt.addUserTest(user);
        int afterReservation_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(existing_rowCount, afterReservation_rowCount);
      
    }
    @Test
    public void testAddUserInvalidPhoneNumber() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        User_Test user = new User_Test( "jolteen", "Giota" , "Jolteen" ,"123654789052525258", "kati" , "f_jolteen@yahoo.gr");
        
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean result = instance.registerUserControllerForTests(user);
        UserDAO_Test udt = new UserDAO_Test();
        if(result)
            udt.addUserTest(user);
        int afterReservation_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(existing_rowCount, afterReservation_rowCount);
        
    }
    @Test
    public void testAddUserInvalidPhoneNumber2() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        User_Test user = new User_Test( "jolteen", "Giota" , "Jolteen" ,"123654", "kati" , "f_jolteen@yahoo.gr");
        
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean result = instance.registerUserControllerForTests(user);
        UserDAO_Test udt = new UserDAO_Test();
        if(result)
            udt.addUserTest(user);
        int afterReservation_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(existing_rowCount, afterReservation_rowCount);
       
    }
    @Test
    public void testEditUserSuccess() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        User_Test user = new User_Test( "karona", "Giota" , "Jolteen" ,"1236547890", "kati" , "f_jolteen@yahoo.gr");
        
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean result = instance.editUserControllerForTests(user);
        UserDAO_Test udt = new UserDAO_Test();
        if(result)
            udt.updateUserTestForTests(user.getUsername(),user.getUserFirstName(),user.getUserLastName(),user.getPhoneNumber(),user.getPassword(),user.getUsermail());
        int afterReservation_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(existing_rowCount, afterReservation_rowCount);
//        assertEquals("Giota", db_testDataCon.getTable("user_test").getValue(1, null));
//        assertEquals("Jolteen", user.getUserLastName());
//        assertEquals("1236547890", user.getPhoneNumber());
//        assertEquals("kati", user.getPassword());
//        assertEquals("f_jolteen@yahoo.gr", user.getUsermail());
    }
   @Test //FIX ME!!!
    public void testDeleteUserSuccess() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
        int existing_rowCount = db_testDataCon.getTable("user_test").getRowCount();
       
        UserDAO_Test udt = new UserDAO_Test();
        Integer uid = udt.userIdReturnForTests("karona");
        udt.deleteUserTestForTests(uid);
        int afterReservation_rowCount = db_testDataCon.getTable("user_test").getRowCount();
        assertEquals(existing_rowCount-1, afterReservation_rowCount);
    
    }

   
    
    
    
 /*   
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    
   

    //**
     //* Test of addUser method, of class UserDAO_Test.
     //*
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = null;
        UserDAO_Test instance = new UserDAO_Test();
        Integer expResult = null;
        Integer result = instance.addUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateUserForTests method, of class UserDAO_Test.
     *
    @Test
    public void testUpdateUserForTests() {
        System.out.println("updateUserForTests");
        String username = "";
        String userFirstName = "";
        String userLastName = "";
        String phoneNumber = "";
        String password = "";
        String usermail = "";
        UserDAO_Test instance = new UserDAO_Test();
        instance.updateUserForTests(username, userFirstName, userLastName, phoneNumber, password, usermail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userIdReturnForTests method, of class UserDAO_Test.
     *
    @Test
    public void testUserIdReturnForTests() {
        System.out.println("userIdReturnForTests");
        String username = "";
        UserDAO_Test instance = new UserDAO_Test();
        Integer expResult = null;
        Integer result = instance.userIdReturnForTests(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of userReturnForTests method, of class UserDAO_Test.
     *
    @Test
    public void testUserReturnForTests() {
        System.out.println("userReturnForTests");
        String username = "";
        UserDAO_Test instance = new UserDAO_Test();
        User expResult = null;
        User result = instance.userReturnForTests(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUserForTests method, of class UserDAO_Test.
     *
    @Test
    public void testDeleteUserForTests() {
        System.out.println("deleteUserForTests");
        Integer userID = null;
        UserDAO_Test instance = new UserDAO_Test();
        instance.deleteUserForTests(userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */
    
}
