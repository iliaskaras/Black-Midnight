/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.GUI;

import blackMidnight.ui.LoginForm;
import blackMidnight.ui.MainFormUser;
import blackMidnight.ui.RegisterUserForm;
import blackMidnight.ui_forTests.LoginForm_forTests;
import blackMidnight.ui_forTests.StoreChooserForReservationForm_forTests;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import org.fest.swing.annotation.GUITest;
import org.fest.swing.core.BasicRobot;
import org.fest.swing.core.MouseButton;
import org.fest.swing.core.Robot;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.finder.JOptionPaneFinder;
import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.MainClassAdapter;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JOptionPaneFixture;


/**
 *
 * @author Ilias
 */
@GUITest public class LoginForm_Test{
    
    private FrameFixture window;
/// 
//    @Before public void setUp() {
//        LoginForm newlf = new LoginForm();
//        newlf.get
//      JFrame  frame = newlf.execute(new GuiQuery<JFrame>() {
//          @Override
//          protected JFrame  executeInEDT() throws Throwable{
//            return new JFrame();
//          }
//      });
//      window = new FrameFixture(frame);
//      window.show(); // shows the frame to test
//    }
//////    
    @Before
    public void setUp() {
        
       window = new FrameFixture(new LoginForm_forTests());
       window.show();  
     }
  
    @AfterClass
    public static void tearDownClass() {
    }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
    @Test
    public void testWrongUserPasswordInput()  {

        window.textBox("jT_Username").enterText("karona");
        window.textBox("jPassword").enterText("wrongPassword");
        window.button("jB_Login").click();
        window.optionPane().requireInformationMessage().requireMessage("Account not found ,please enter right username and password or Register");
     
    }
    
    @Test
    public void testWrongUserUsernameInput()  {
      
        window.textBox("jT_Username").enterText("wrongUsername");
        window.textBox("jPassword").enterText("password");
        window.button("jB_Login").click();
        window.optionPane().requireInformationMessage().requireMessage("Account not found ,please enter right username and password or Register");
   
    }

    @Test
    public void testProperUserUsernamePasswordInput() throws InterruptedException {
          
        window.textBox("jT_Username").enterText("karona");
        window.textBox("jPassword").enterText("123");
        window.button("jB_Login").click();
        window.optionPane().requireInformationMessage().requireMessage("You logged in succesfully karona");
    
    }
 
    
    @Test
    public void testCloseLoginForm() throws InterruptedException {
        
        window.button("jB_Cancel").click();
        window.requireNotVisible();
    
    }
    
    @Test
    public void testOpenRegisterForm() throws InterruptedException {
        RegisterUserForm ruform = new RegisterUserForm();
        
        window.button("jB_Register").click();
        assertTrue(ruform.isEnabled());
        
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}