/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.GUI;

import blackMidnight.ui_forTests.CreateStoreForm_forTests;
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
@GUITest public class CreateStoreForm_Test {
    private FrameFixture window;
    
    public CreateStoreForm_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
   @Before
    public void setUp() {
        
       window = new FrameFixture(new CreateStoreForm_forTests());
       window.show();  
     }
    
   @After
    public void tearDown() {
        window.cleanUp();
    }
   
    @Test
    public void testFalseStoreNameInput()  {
        window.textBox("storeNameTFld").setText(""); //*store's name is empty, storeNameFalseLbl should be visible to warn the user *//
        window.textBox("numOfSeatsTFld").setText("155");
        window.textBox("storeAddressTFld").setText("address");
        window.textBox("storeCityTFld").setText("city");
        window.textBox("storePhoneTFld").setText("123123");
        window.textBox("emailTFld").setText("hlias.karas@yahoo.gr");
        window.checkBox("mondayCBx").check();
        window.textBox("fromOpenHoursTFld").setText("18:00");
        window.textBox("toOpenHoursTFld").setText("23:00");
        window.button("addStoreBtn").click();
        window.optionPane().okButton().click();
        window.label("storeNameFalseLbl").requireVisible();
    }
    
    @Test
    public void testFalseNumberOfSeatsInput()  {
        window.textBox("storeNameTFld").setText("store1");
        window.textBox("numOfSeatsTFld").setText("0");//*seats is empty, numberOfSeatsFalseLbl should be visible to warn the user *//
        window.textBox("storeAddressTFld").setText("address");
        window.textBox("storeCityTFld").setText("city");
        window.textBox("storePhoneTFld").setText("123123");
        window.textBox("emailTFld").setText("hlias.karas@yahoo.gr");
        window.checkBox("mondayCBx").check();
        window.textBox("fromOpenHoursTFld").setText("18:00");
        window.textBox("toOpenHoursTFld").setText("23:00");
        window.button("addStoreBtn").click();
        window.optionPane().okButton().click();
        window.label("numberOfSeatsFalseLbl").requireVisible();
    }
     
    @Test
    public void testFalseAddressInput()  {
        window.textBox("storeNameTFld").setText("store1");
        window.textBox("numOfSeatsTFld").setText("155");
        window.textBox("storeAddressTFld").setText("");//*address is empty, storeAddressFalseLbl should be visible to warn the user *//
        window.textBox("storeCityTFld").setText("city");
        window.textBox("storePhoneTFld").setText("123123");
        window.textBox("emailTFld").setText("hlias.karas@yahoo.gr");
        window.checkBox("mondayCBx").check();
        window.textBox("fromOpenHoursTFld").setText("18:00");
        window.textBox("toOpenHoursTFld").setText("23:00");
        window.button("addStoreBtn").click();
        window.optionPane().okButton().click();
        window.label("storeAddressFalseLbl").requireVisible();
    }
    @Test
    public void testFalseCityInput()  {
        window.textBox("storeNameTFld").setText("store1");
        window.textBox("numOfSeatsTFld").setText("155");
        window.textBox("storeAddressTFld").setText("address");
        window.textBox("storeCityTFld").setText("");//*city is empty, storeCityFalseLbl should be visible to warn the user *//
        window.textBox("storePhoneTFld").setText("123123");
        window.textBox("emailTFld").setText("hlias.karas@yahoo.gr");
        window.checkBox("mondayCBx").check();
        window.textBox("fromOpenHoursTFld").setText("18:00");
        window.textBox("toOpenHoursTFld").setText("23:00");
        window.button("addStoreBtn").click();
        window.optionPane().okButton().click();
        window.label("storeCityFalseLbl").requireVisible();
    }
    
    @Test
    public void testCloseButton()  {
        window.button("closeBtn").click();
        window.requireNotVisible();
    }
    @Test
    public void testFalsePhoneInput()  {
        window.textBox("storeNameTFld").setText("store1");
        window.textBox("numOfSeatsTFld").setText("155");
        window.textBox("storeAddressTFld").setText("address");
        window.textBox("storeCityTFld").setText("city");
        window.textBox("storePhoneTFld").setText("");//*phone is empty, storePhoneFalseLbl should be visible to warn the user *//
        window.textBox("emailTFld").setText("hlias.karas@yahoo.gr");
        window.checkBox("mondayCBx").check();
        window.textBox("fromOpenHoursTFld").setText("18:00");
        window.textBox("toOpenHoursTFld").setText("23:00");
        window.button("addStoreBtn").click();
        window.optionPane().okButton().click();
        window.label("storePhoneFalseLbl").requireVisible();
    }
    
    @Test
    public void testFalseEmailInput()  {
        window.textBox("storeNameTFld").setText("store1");
        window.textBox("numOfSeatsTFld").setText("155");
        window.textBox("storeAddressTFld").setText("address");
        window.textBox("storeCityTFld").setText("city");
        window.textBox("storePhoneTFld").setText("123123");
        window.textBox("emailTFld").setText("hlias.karasyahoo.gr");//*email is not proper, emailFalseLbl should be visible to warn the user *//
        window.checkBox("mondayCBx").check();
        window.textBox("fromOpenHoursTFld").setText("18:00");
        window.textBox("toOpenHoursTFld").setText("23:00");
        window.button("addStoreBtn").click();
        window.optionPane().okButton().click();
        window.label("emailFalseLbl").requireVisible();
    }
    @Test
    public void testNoOpenDaysCheck()  {
        //* we dont check any open days. so the openDaysFalseLbl should be visible *//
        window.textBox("storeNameTFld").setText("store1");
        window.textBox("numOfSeatsTFld").setText("155");
        window.textBox("storeAddressTFld").setText("address");
        window.textBox("storeCityTFld").setText("city");
        window.textBox("storePhoneTFld").setText("123123");
        window.textBox("emailTFld").setText("hlias.karasyahoo.gr");
        window.textBox("fromOpenHoursTFld").setText("18:00");
        window.textBox("toOpenHoursTFld").setText("23:00");
        window.button("addStoreBtn").click();
        window.optionPane().okButton().click();
        window.label("openDaysFalseLbl").requireVisible();
    }
    
    @Test
    public void testWrongOpenHoursCheck()  {
        //* we give no open hours, openHoursFalseLbl should be visible *//
        window.textBox("storeNameTFld").setText("store1");
        window.textBox("numOfSeatsTFld").setText("155");
        window.textBox("storeAddressTFld").setText("address");
        window.textBox("storeCityTFld").setText("city");
        window.textBox("storePhoneTFld").setText("123123");
        window.textBox("emailTFld").setText("hlias.karasyahoo.gr");
        window.textBox("fromOpenHoursTFld").setText("00:00");
        window.textBox("toOpenHoursTFld").setText("00:00"); 
        window.button("addStoreBtn").click();
        window.optionPane().okButton().click();
        window.label("openHoursFalseLbl").requireVisible();
    }
    
    @Test
    public void testFailedStoreCreationCheck()  {
        //* we give give something wrong , so the proper msgbox will appear *//
        window.textBox("storeNameTFld").setText("store1");
        window.textBox("numOfSeatsTFld").setText("155");
        window.textBox("storeAddressTFld").setText("address");
        window.textBox("storeCityTFld").setText("city");
        window.textBox("storePhoneTFld").setText("123123");
        window.textBox("emailTFld").setText("hlias.karasyahoo.gr");
        window.textBox("fromOpenHoursTFld").setText("00:00");
        window.textBox("toOpenHoursTFld").setText("00:00"); 
        window.button("addStoreBtn").click();
        window.optionPane().requireInformationMessage().requireMessage("Store Creation Failed\n");
    }
    
    @Test
    public void testStoreAlreadyExistsInDatabaseCheck()  {
        //* store already exists *//
        window.textBox("storeNameTFld").setText("store1");
        window.textBox("numOfSeatsTFld").setText("155");
        window.textBox("storeAddressTFld").setText("storeAddress1");
        window.textBox("storeCityTFld").setText("city");
        window.textBox("storePhoneTFld").setText("123123");
        window.textBox("emailTFld").setText("hlias.karasyahoo.gr");
        window.textBox("fromOpenHoursTFld").setText("18:00");
        window.textBox("toOpenHoursTFld").setText("23:00"); 
        window.checkBox("mondayCBx").check();
        window.button("addStoreBtn").click();
        window.optionPane().requireInformationMessage().requireMessage("Store already exists in the database!");
        window.optionPane().okButton().click();
        window.optionPane().okButton().click();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}