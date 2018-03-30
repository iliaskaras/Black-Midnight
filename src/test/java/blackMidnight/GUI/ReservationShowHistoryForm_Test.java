/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.GUI;

import blackMidnight.ui_forTests.CreateStoreForm_forTests;
import blackMidnight.ui_forTests.ReservationShowHistoryForm_forTests;
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
@GUITest public class ReservationShowHistoryForm_Test {
    private FrameFixture window;
    public ReservationShowHistoryForm_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        
       window = new FrameFixture(new ReservationShowHistoryForm_forTests("username1"));
       window.show();  
     }
    
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
    @Test
    public void testLoadUserHistoryAtOpening()  {
        assertTrue(window.table("AllReservationsTable").rowCount()==1); 
    }
    
    @Test
    public void testShowHistoryFormClosesFromHomeButton()  {
        window.button("Home").click();
        window.requireNotVisible();
    }
    @Test
    public void testLoadSpecificStoresReservation()  {
        window.textBox("chosenStore").enterText("storename1");
        window.button("ShowSpecificStoreHistory").click();
        assertTrue(window.table("AllReservationsTable").rowCount()==1); 
    }
    
    //* We give a store that the user dont have any reservations, the table should show no reservations. *//
    @Test
    public void testLoadUnknownStoresReservations()  {
        window.textBox("chosenStore").enterText("unknownStore");
        window.button("ShowSpecificStoreHistory").click();
        assertTrue(window.table("AllReservationsTable").rowCount()==0); 
        window.optionPane().okButton().click();
    }
    
    @Test
    public void testIfMessageBoxForUnknownStoresReservationAppear()  {
        window.textBox("usernameText").setText("UsernameWithoutAnyReservations");
        window.button("AllReservations").click();
        window.optionPane().requireInformationMessage().requireMessage("You dont have any reservations");
        window.optionPane().okButton().click();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}