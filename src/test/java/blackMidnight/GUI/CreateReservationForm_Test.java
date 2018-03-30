/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.GUI;

import blackMidnight.ui_forTests.CreateReservationForm_forTests;
import blackMidnight.ui_forTests.LoginForm_forTests;
import blackMidnight.ui_forTests.MainFormUser_forTests;
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
@GUITest public class CreateReservationForm_Test {
    
    private FrameFixture window;
   
     
    public CreateReservationForm_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
       window = new FrameFixture(new CreateReservationForm_forTests());
       window.show();  
     }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
   
    @Test
    public void testProperReservationInput()  {
        window.textBox("usernameText").setText("username2");
        window.textBox("StoresNameTxt").setText("store1");
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").enterText("ilias");
        window.textBox("NumberOfSeatsTxt").enterText("1");
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().requireInformationMessage().requireMessage("Η ΚΡΑΤΗΣΗ ΣΑΣ ΠΡΑΓΜΑΤΟΠΟΙΗΘΗΚΕ ΕΠΙΤΥΧΩΣ!!");
     
    }
    
    @Test
    public void testLongCustomerNameReservationInput()  {
        window.textBox("usernameText").setText("username2");
        window.textBox("StoresNameTxt").setText("store1");
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").enterText("iliasiliasiliasiliasiliasiliasiliasiliasiliasiliasilias");
        window.textBox("NumberOfSeatsTxt").enterText("1");
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().requireInformationMessage().requireMessage("You need to fix the wrong inputs (red warning ones) !");
     
    }
    @Test
    public void testManySeatsInput()  {
        window.textBox("usernameText").setText("username2");
        window.textBox("StoresNameTxt").setText("store1");
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").enterText("ilias");
        window.textBox("NumberOfSeatsTxt").enterText("1111");
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().requireInformationMessage().requireMessage("You need to fix the wrong inputs (red warning ones) !");
     
    }
    
    @Test
    public void testUnavailableHourInput()  {
        window.textBox("usernameText").setText("username2");
        window.textBox("StoresNameTxt").setText("store1");
        window.textBox("openHoursTxt").setText("13:00-00:00");
        window.textBox("CustomerNameTxt").enterText("ilias");
        window.textBox("NumberOfSeatsTxt").enterText("1");
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(31);
        window.button("makeReservation").click();
        window.optionPane().requireInformationMessage().requireMessage("You need to fix the wrong inputs (red warning ones) !");
     
    }
    
     @Test
    public void testFormCloseFromToHomeButton()  {
        
        window.button("JBHome").click();
        window.requireNotVisible();
     
    }
     
    @Test
    public void testFormCloseFromBackButton()  {
        
        window.button("BackToMainReservationForm").click();
        window.requireNotVisible();
     
    }
    
    @Test
    public void testRedButton1Vissible()  {
        
        window.textBox("usernameText").setText("karona"); 
        window.textBox("StoresNameTxt").setText("store1");
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").setText(""); //* customer name is empty = > should make visible the redButton1 to warn the user *//
        window.textBox("NumberOfSeatsTxt").enterText("1");
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().okButton().click();
        window.button("redButton1").requireVisible();
    }
    
    @Test
    public void testRedButton2Vissible()  {
        
        window.textBox("usernameText").setText("karona"); 
        window.textBox("StoresNameTxt").setText(""); //* store name is not available (null, or unknown name works too) = > should make visible the redButton2 to warn the user *//
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").setText("ilias");
        window.textBox("NumberOfSeatsTxt").enterText("1");
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().okButton().click();
        window.button("redButton2").requireVisible();
    }
    
    @Test
    public void testRedButton3Vissible()  {
        
        window.textBox("usernameText").setText("karona"); 
        window.textBox("StoresNameTxt").setText("store1"); 
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").setText("ilias");
        window.textBox("NumberOfSeatsTxt").enterText("1111"); //* too many seats = > should make visible the redButton3 to warn the user *//
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().okButton().click();
        window.button("redButton3").requireVisible();
    }
    
     @Test
    public void testRedButton4Vissible()  {
        //* we dont select any date = > should make visible the redButton4 to warn the user *//
        window.textBox("usernameText").setText("karona"); 
        window.textBox("StoresNameTxt").setText("store1"); 
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").setText("ilias");
        window.textBox("NumberOfSeatsTxt").enterText("1"); 
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().okButton().click();
        window.button("redButton4").requireVisible();
    }
     
     @Test
    public void testRedButton5Vissible()  {
       
        window.textBox("usernameText").setText("karona"); 
        window.textBox("StoresNameTxt").setText("store1"); 
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").setText("ilias");
        window.textBox("NumberOfSeatsTxt").enterText("1"); 
        window.comboBox("HoursAvailable").selectItem(31); //* 31 = 2:15, an unavailable time for the specific store, should make redbutton5 visible to warn the user *//
        window.button("makeReservation").click();
        window.optionPane().okButton().click();
        window.button("redButton5").requireVisible();
    }
     
     @Test
    public void testGreenButton1Vissible()  {
        
        window.textBox("usernameText").setText("karona"); 
        window.textBox("StoresNameTxt").setText("");
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").setText("ilias"); //* customer name is not empty = > should make visible the greenButton1  *//
        window.textBox("NumberOfSeatsTxt").enterText("1");
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().okButton().click();
        window.button("greenButton1").requireVisible();
    }
    
    @Test
    public void testGreenButton2Vissible()  {
        
        window.textBox("usernameText").setText("karona"); 
        window.textBox("StoresNameTxt").setText("store1"); //* store is available = > should make visible the greenButton2 *//
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").setText("");
        window.textBox("NumberOfSeatsTxt").enterText("1");
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().okButton().click();
        window.button("greenButton2").requireVisible();
    }
    
    @Test
    public void testGreenButton3Vissible()  {
        
        window.textBox("usernameText").setText("karona"); 
        window.textBox("StoresNameTxt").setText("store1"); 
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").setText("");
        window.textBox("NumberOfSeatsTxt").enterText("1"); //* seats are ok = > should make visible the greenButton3  *//
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().okButton().click();
        window.button("greenButton3").requireVisible();
    }
    
     @Test
    public void testGreenButton4Vissible()  {
        //* we have select a proper date = > should make visible the greenButton4  *//
        window.textBox("usernameText").setText("karona"); 
        window.textBox("StoresNameTxt").setText("store1"); 
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").setText("");
        window.textBox("NumberOfSeatsTxt").enterText("1"); 
        window.comboBox("DateAvailable").selectItem(1);
        window.comboBox("HoursAvailable").selectItem(1);
        window.button("makeReservation").click();
        window.optionPane().okButton().click();
        window.button("greenButton4").requireVisible();
    }
     
     @Test
    public void testGreenButton5Vissible()  {
       
        window.textBox("usernameText").setText(""); 
        window.textBox("StoresNameTxt").setText("store1"); 
        window.textBox("openHoursTxt").setText("18:00-20:00");
        window.textBox("CustomerNameTxt").setText("ilias");
        window.textBox("NumberOfSeatsTxt").enterText("1"); 
        window.comboBox("HoursAvailable").selectItem(1); 
        window.button("makeReservation").click();
        window.optionPane().okButton().click();
        window.button("greenButton5").requireVisible();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}