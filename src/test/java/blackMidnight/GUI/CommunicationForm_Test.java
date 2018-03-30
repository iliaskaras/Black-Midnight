/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package blackMidnight.GUI;

import blackMidnight.ui_forTests.CommunicationForm_forTests;
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
@GUITest public class CommunicationForm_Test {
    
    private FrameFixture window;
    
    public CommunicationForm_Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
       window = new FrameFixture(new CommunicationForm_forTests("username"));
       window.show();  
     }
    
    @After
    public void tearDown() {
        window.cleanUp();
    }
    
    @Test
    public void testQuestionSendSuccess()  {
        window.textBox("textBox").setText("a question to blackmidnight");
        window.button("SendTextBtn").click();
        window.optionPane().requireInformationMessage().requireMessage("Question email to BlackMidnight sended succesfully!");
        window.optionPane().okButton().click();
    }
    
    @Test
    public void testQuestionSendFailed()  {
        window.textBox("textBox").setText("");
        window.button("SendTextBtn").click();
        window.optionPane().requireInformationMessage().requireMessage("Question email to BlackMidnight failed to send!");
        window.optionPane().okButton().click();
    }
    
    @Test
    public void testClearMessage()  {
        window.textBox("textBox").setText("a question to blackmidnight");
        window.button("ClearMessageBtn").click();
        window.textBox("textBox").requireEmpty();
    }
    
    @Test
    public void testBackToHomeClickFormClose()  {
        window.button("BackToHomeBtn").click();
        window.requireNotVisible();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}