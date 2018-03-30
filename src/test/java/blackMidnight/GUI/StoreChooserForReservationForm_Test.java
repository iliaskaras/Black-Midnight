/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.GUI;

import blackMidnight.ui_forTests.StoreChooserForReservationForm_forTests;
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
@GUITest public class StoreChooserForReservationForm_Test {
    private FrameFixture window;
    public StoreChooserForReservationForm_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        
       window = new FrameFixture(new StoreChooserForReservationForm_forTests("username1"));
       window.show();  
     }
    
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
    @Test
    public void testLoadOpenHoursTextByClickingStore()  {
        window.table("Stores").selectRows(0);
        assertTrue(window.textBox("openHoursText").text().equals("18:00-20:00")); 
    }
    
    @Test
    public void testLoadStoreTextTextByClickingStore()  {
        window.table("Stores").selectRows(0);
        assertTrue(window.textBox("storeText").text().equals("store1")); 
    }
    
    @Test
    public void testLoadStoreInformationsTextByClickingStore()  {
        window.table("Stores").selectRows(0);
        assertTrue(window.textBox("storeInformationsText").text().equals("good place")); 
    }
    
    @Test
    public void testCancelReservationButtonIfFormClose()  {
        window.button("CancelReservation").click();
        window.requireNotVisible();
    }
    
    @Test
    public void testCreateReservationButtonWithoutStoreSelection()  {
        window.button("CreateReservation").click();
        window.optionPane().requireInformationMessage().requireMessage("You haven't selected a store name!");
    }
    
    @Test
    public void testStoresLoadedToTableSuccessfully()  {
        assertTrue(window.table("Stores").rowCount()!=0);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}