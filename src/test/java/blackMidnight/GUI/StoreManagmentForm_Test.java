/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.GUI;

import blackMidnight.ui_forTests.StoreManagementForm_forTests;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.fest.swing.annotation.GUITest;
import org.fest.swing.fixture.FrameFixture;
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
public class StoreManagmentForm_Test{
    
    private FrameFixture window;
   
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
       window = new FrameFixture(new StoreManagementForm_forTests());
       window.show(); 
     }
    
    @After
    public void tearDown() throws Exception {
        window.cleanUp();
    }
    
    @Test
    public void testProperReservationInput()  {
       window.table("storeTbl").requireColumnCount(6);
      
    }
    @Test
    public void testDeletedSelectedStore() {
       window.table("storeTbl").selectRows(3).click();
       window.button("deleteStoreBtn").click();
       window.optionPane().requireInformationMessage().requireMessage("Store Deleted Succesfully");
     }
    @Test
    public void testClosingFormFromEditStoreButton() throws Exception  {
       
       window.table("storeTbl").selectRows(0).click();
       window.button("editStoreBtn").click();
       window.requireNotVisible();
    }
    @Test
    public void testClosingFormFromAddStoreButton() throws Exception  {
       
       window.button("addStoreBtn").click();
       window.requireNotVisible();
    }
    @Test
    public void testClosingFormFromCloseButton() throws Exception  {
       
       window.button("closeBtn").click();
       window.requireNotVisible();
    }
    @Test
    public void testLoadingSuccessDataIndex() throws Exception  {
       assertFalse(window.table("storeTbl").selectRows(0).equals(null));
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}