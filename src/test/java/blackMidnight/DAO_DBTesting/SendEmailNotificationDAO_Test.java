/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.DAO_DBTesting;

import blackMidnight.controller.ISendEmailController;
import blackMidnight.controller.SendEmailController;
import blackMidnight.controller_forTests.SendEmailNotificationController_forTests;
import java.io.FileInputStream;
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
public class SendEmailNotificationDAO_Test extends DBTestCase{
    
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
    public SendEmailNotificationDAO_Test(String name) throws Exception {
        super(name);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root" );
      //  System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
    }
    
    protected IDataSet getDataSet() throws Exception {
        
        flatXmlIntance=new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_user.xml"));
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
        return DatabaseOperation.NONE;
        
    }
    
    @Test
    public void testReadFromRegisterUsersLogEmailFail() throws Exception{
        SendEmailNotificationController_forTests instance = new SendEmailNotificationController_forTests();
        String readEmail = "";
        boolean result = false;
        readEmail = instance.readFromRegisterUsersLogEmailForTests("");
        if(readEmail.equals("")){
            result = false;
        } else
            result = true;
        
        boolean expResult = false;
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReadFromRegisterUsersLogEmailSuccess() throws Exception{
        SendEmailNotificationController_forTests instance = new SendEmailNotificationController_forTests();
        String readEmail = "";
        boolean result = false;
        readEmail = instance.readFromRegisterUsersLogEmailForTests("karona");
        if(readEmail.equals("")){
            result = false;
        } else
            result = true;
        
        boolean expResult = true;
        
        assertEquals(expResult, result);
    }
    
     @Test
    public void testReadFromStoreLogEmailFail() throws Exception{
        SendEmailNotificationController_forTests instance = new SendEmailNotificationController_forTests();
        String readEmail = "";
        boolean result = false;
        readEmail = instance.readFromStoreListEmailForTests("");
        if(readEmail.equals("")){
            result = false;
        } else
            result = true;
        
        boolean expResult = false;
        
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReadFromStoreLogEmailSuccess() throws Exception{
        SendEmailNotificationController_forTests instance = new SendEmailNotificationController_forTests();
        String readEmail = "";
        boolean result = false;
        readEmail = instance.readFromStoreListEmailForTests("store1");
        if(readEmail.equals("")){
            result = false;
        } else
            result = true;
        
        boolean expResult = true;
        
        assertEquals(expResult, result);
    }
}