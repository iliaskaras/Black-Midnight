/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.GUI;

import blackMidnight.ui_forTests.EditUserForm_forTests;
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
@GUITest public class EditUserForm_Test {
   
    private FrameFixture window;
    
    public EditUserForm_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        
       window = new FrameFixture(new EditUserForm_forTests());
       window.show();  
     }
    
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
    @Test
    public void testFalseUsernameInput()  {
        window.textBox("JT_username").setText(""); 
        window.textBox("JT_FirstName").setText("firstname");
        window.textBox("JT_LastName").setText("lastname");
        window.textBox("JT_PhoneNumber").setText("1231231231");
        window.textBox("JP_Password").setText("password");
        window.textBox("JT_E_mail").setText("hlias.karas@yahoo.gr");
        window.button("JB_Update").click();
        window.optionPane().requireInformationMessage().requireMessage("Error please try again");
        window.optionPane().okButton().click();
    }
     @Test
    public void testFalseFirstNameInput()  {
        window.textBox("JT_username").setText("username"); 
        window.textBox("JT_FirstName").setText("");
        window.textBox("JT_LastName").setText("lastname");
        window.textBox("JT_PhoneNumber").setText("1231231231");
        window.textBox("JP_Password").setText("password");
        window.textBox("JT_E_mail").setText("hlias.karas@yahoo.gr");
        window.button("JB_Update").click();
        window.optionPane().requireInformationMessage().requireMessage("Error please try again");
        window.optionPane().okButton().click();
    }
   
       @Test
    public void testFalsePhoneNumberInput()  {
        window.textBox("JT_username").setText("username"); 
        window.textBox("JT_FirstName").setText("firstname");
        window.textBox("JT_LastName").setText("lastname");
        window.textBox("JT_PhoneNumber").setText("");
        window.textBox("JP_Password").setText("password");
        window.textBox("JT_E_mail").setText("hlias.karas@yahoo.gr");
        window.button("JB_Update").click();
        window.optionPane().requireInformationMessage().requireMessage("Error please try again");
        window.optionPane().okButton().click();
    }
       
      @Test
    public void testFalsePasswordInput()  {
        window.textBox("JT_username").setText("username"); 
        window.textBox("JT_FirstName").setText("firstname");
        window.textBox("JT_LastName").setText("lastname");
        window.textBox("JT_PhoneNumber").setText("1231231231");
        window.textBox("JP_Password").setText("");
        window.textBox("JT_E_mail").setText("hlias.karas@yahoo.gr");
        window.button("JB_Update").click();
        window.optionPane().requireInformationMessage().requireMessage("Error please try again");
        window.optionPane().okButton().click();
    }
      
     @Test
    public void testSuccessRegister()  {
        window.textBox("JT_username").setText("username"); 
        window.textBox("JT_FirstName").setText("firstname");
        window.textBox("JT_LastName").setText("lastname");
        window.textBox("JT_PhoneNumber").setText("1231231231");
        window.textBox("JP_Password").setText("password");
        window.textBox("JT_E_mail").setText("hlias.karas@yahoo.gr");
        window.button("JB_Update").click();
        window.optionPane().requireInformationMessage().requireMessage("User Updated Succesfully");
        window.optionPane().okButton().click();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}