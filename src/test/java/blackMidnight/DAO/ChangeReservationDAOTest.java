/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.DAO;

import blackMidnight.model.Reservation;
import java.io.FileInputStream;
import java.util.List;
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
import static org.junit.Assert.*;

/**
 *
 * @author Ilias
 */
public class ChangeReservationDAOTest extends DBTestCase{
    
    private FlatXmlDataSet flatXmlIntance;
    
    public ChangeReservationDAOTest(String name) {
        super(name);
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS, "com.mysql.jdbc.Driver" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL, "jdbc:mysql://localhost:3306/blackMidnight_Test?zeroDateTimeBehavior=convertToNull" );
        System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME, "root" );
        //System.setProperty( PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD, "password" );
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        
        flatXmlIntance=new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/flatXmlDataSet_reservation.xml"));
        return flatXmlIntance;
        
    }
    
    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception{
     
        return DatabaseOperation.CLEAN_INSERT;
         
    }
    
    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception{
        
        return DatabaseOperation.NONE;
        
    }
    
    @Test
    public void testDatabase() throws Exception {
        IDataSet db_testDataCon = getConnection().createDataSet();
        ITable result_set = db_testDataCon.getTable("reservation_test");
        
        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("src/main/java/DbTesting_Xml_Files/3021_flatXmlDataSet_reservation_2.xml"));
        ITable result_expectedSet = expectedDataSet.getTable("reservation_test");
        
        Assertion.assertEquals(result_expectedSet,result_set);
    }
    
    @Test
    public void testchangeReservationExist() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
                
        Reservation expResult = new Reservation();
        
        expResult.setReservationId(2);
        expResult.setCustomerName("bal");
        expResult.setNumberOfSeats(8);
        expResult.setStoreName("store1");
        expResult.setDate("2013/12/09");
        expResult.setHour("23:15");
                
        ChangeReservationDAO instance = new ChangeReservationDAO();
        boolean change = instance.change(expResult);
        
        ITable actualDbData = getConnection().createQueryTable("s","SELECT * FROM reservation_test WHERE reservationId = 2");
        
        assertEquals(expResult.getReservationId(), actualDbData.getValue(0, "reservationId"));
        assertEquals(expResult.getCustomerName(),actualDbData.getValue(0, "customerName"));
        assertEquals(expResult.getNumberOfSeats(), actualDbData.getValue(0, "numberOfSeats"));
        assertEquals(expResult.getStoreName(), actualDbData.getValue(0, "storeName"));
        assertEquals(expResult.getDate(), actualDbData.getValue(0, "date"));
        assertEquals(expResult.getHour(), actualDbData.getValue(0, "hour"));
                
        assertEquals(change, true);
    }
    
     @Test
    public void testchangeReservationNotExist() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
                
        Reservation expResult = new Reservation();
        
        expResult.setReservationId(99);
        expResult.setCustomerName("bal");
        expResult.setNumberOfSeats(8);
        expResult.setStoreName("store1");
        expResult.setDate("2013/12/09");
        expResult.setHour("23:15");
                
        ChangeReservationDAO instance = new ChangeReservationDAO();
        boolean change = instance.change(expResult);
        
        ITable actualDbData = getConnection().createQueryTable("s","SELECT * FROM reservation_test WHERE reservationId = 99");
        
         
        assertEquals(0,actualDbData.getRowCount());
        assertEquals(change, false);
    }
    
    
    @Test
    public void testgetDataExist() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
         
        ITable actualDbData = getConnection().createQueryTable("s","SELECT * FROM reservation_test WHERE reservationId = 1");
              
        ChangeReservationDAO instance = new ChangeReservationDAO();
        List<Reservation> expResult = instance.getData(1);
         
        assertEquals(expResult.get(0).getReservationId(), actualDbData.getValue(0, "reservationId"));
        assertEquals(expResult.get(0).getCustomerName(),actualDbData.getValue(0, "customerName"));
        assertEquals(expResult.get(0).getNumberOfSeats(), actualDbData.getValue(0, "numberOfSeats"));
        assertEquals(expResult.get(0).getStoreName(), actualDbData.getValue(0, "storeName"));
        assertEquals(expResult.get(0).getDate(), actualDbData.getValue(0, "date"));
        assertEquals(expResult.get(0).getHour(), actualDbData.getValue(0, "hour"));
    }
    
     @Test
    public void testgetDataNotExist() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
         
        ITable actualDbData = getConnection().createQueryTable("s","SELECT * FROM reservation_test WHERE reservationId = 99");
              
        ChangeReservationDAO instance = new ChangeReservationDAO();
        List<Reservation> expResult = instance.getData(99);
         
        assertEquals(0,actualDbData.getRowCount());
        assertEquals(null, expResult);
    }
    
    @Test
    public void testgetDataBynameExist() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
         
        ITable actualDbData = getConnection().createQueryTable("s","SELECT * FROM reservation_test WHERE customerName = 'customername1'");
              
        ChangeReservationDAO instance = new ChangeReservationDAO();
        List<Reservation> expResult = instance.getDataByname("customername1");
         
        assertEquals(expResult.get(0).getReservationId(), actualDbData.getValue(0, "reservationId"));
        assertEquals(expResult.get(0).getCustomerName(),actualDbData.getValue(0, "customerName"));
        assertEquals(expResult.get(0).getNumberOfSeats(), actualDbData.getValue(0, "numberOfSeats"));
        assertEquals(expResult.get(0).getStoreName(), actualDbData.getValue(0, "storeName"));
        assertEquals(expResult.get(0).getDate(), actualDbData.getValue(0, "date"));
        assertEquals(expResult.get(0).getHour(), actualDbData.getValue(0, "hour"));
        assertEquals(1,actualDbData.getRowCount());
    }
    
    @Test
    public void testgetDataBynameNotExist() throws Exception{
        IDataSet db_testDataCon = getConnection().createDataSet();
         
        ITable actualDbData = getConnection().createQueryTable("s","SELECT * FROM reservation_test WHERE customerName = 'notexist'");
              
        ChangeReservationDAO instance = new ChangeReservationDAO();
        List<Reservation> expResult = instance.getDataByname("notexist");
         
        assertEquals(0,actualDbData.getRowCount());
        assertEquals(null, expResult);
    }
   
   }
