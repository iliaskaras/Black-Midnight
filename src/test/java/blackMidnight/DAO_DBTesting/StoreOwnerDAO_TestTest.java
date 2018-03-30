/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO_DBTesting;

import blackMidnight.DAO_forTests.StoreOwnerDAO_Test;
import java.io.FileInputStream;
import java.sql.SQLException;
import org.dbunit.DBTestCase;
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
public class StoreOwnerDAO_TestTest extends DBTestCase{
    
    private FlatXmlDataSet flatXmlIntance;
    private  IDatabaseConnection conn;
    public StoreOwnerDAO_TestTest(String name) throws Exception {
       super(name);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root" ); 
       // System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
        this.conn = getConnection();
    }
   
   
    @Override
    protected IDataSet getDataSet() throws Exception {
         flatXmlIntance=new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_storeOwner.xml"));
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
        int existing_rowCount = db_testDataCon.getTable("storeowners_test").getRowCount();
        assertEquals(4,existing_rowCount);
        
    }
}
