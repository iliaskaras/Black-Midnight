/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.controller_forTests.RegisterUserController_forTests;
import blackMidnight.model.User;
import blackMidnight.model_forTests.User_Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jolteen
 */
public class RegisterUserControllerTest {
    
    public RegisterUserControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerUserController method, of class RegisterUserController.
     */
    @Test
    public void testSuccesRegisterUserController() {
        System.out.println("SuccessregisterUserController");
        User_Test user = new User_Test("jolteen", "Giota", "Zioga", "1234567890", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = true;
        boolean result = instance.registerUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    @Test
    public void testEmptyPasswordRegisterUserController() {
        System.out.println("EmptyPasswordregisterUserController");
        User_Test user = new User_Test("jolteen", "Giota", "Zioga", "1234567890", "", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.registerUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    @Test
    public void testEmptyUsernameRegisterUserController() {
        System.out.println("testEmptyUsernameRegisterUserController");
        User_Test user = new User_Test("", "Giota", "Zioga", "1234567890", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.registerUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    @Test
    public void testTooLongUsernameSuccesRegisterUserController() {
        System.out.println("testTooLongUsernameSuccesRegisterUserController");
        User_Test user = new User_Test("jolteen123654789654132", "Giota", "Zioga", "1234567890", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.registerUserControllerForTests(user);
        assertEquals(expResult, result);
    }
     @Test
    public void testTooLongFirstNameSuccesRegisterUserController() {
        System.out.println("testTooLongFirstNameSuccesRegisterUserController");
        User_Test user = new User_Test("jolteen", "Giota123654789652369857", "Zioga", "1234567890", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.registerUserControllerForTests(user);
        assertEquals(expResult, result);
    }
     @Test
    public void testInvalidPhoneNumber1SuccesRegisterUserController() {
        System.out.println("testInvalidPhoneNumberSuccesRegisterUserController");
        User_Test user = new User_Test("jolteen", "Giota", "Zioga", "1234567890123654", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.registerUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    @Test
    public void testInvalidPhoneNumber2SuccesRegisterUserController() {
        System.out.println("testInvalidPhoneNumberSuccesRegisterUserController");
        User_Test user = new User_Test("jolteen", "Giota", "Zioga", "1234", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.registerUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSuccesEditUserController() {
        System.out.println("SuccessEditUserController");
        User_Test user = new User_Test("jolteen", "Giota", "Zioga", "1234567890", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = true;
        boolean result = instance.editUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    @Test
    public void testEmptyPassEditUserController() {
        System.out.println("EmptyPassEditUserController");
        User_Test user = new User_Test("jolteen", "Giota", "Zioga", "1234567890", "", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.editUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    @Test
    public void testEmptyUsernameEditUserController() {
        System.out.println("EmptyUsernameEditUserController");
        User_Test user = new User_Test("", "Giota", "Zioga", "1234567890", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.editUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    @Test
    public void testTooLongUsernameEditUserController() {
        System.out.println("TooLongUsernameEditUserController");
        User_Test user = new User_Test("jolteensdasdadadadasada", "Giota", "Zioga", "1234567890", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.editUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    @Test
    public void testTooLongFirstNameEditUserController() {
        System.out.println("TooLongFirstNameEditUserController");
        User_Test user = new User_Test("jolteen", "Giotasasdsaasdasdasdadada", "Zioga", "1234567890", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.editUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    @Test
    public void testInvalidPhoneNumberEditUserController() {
        System.out.println("InvalidPhoneNumberEditUserController");
        User_Test user = new User_Test("jolteen", "Giota", "Zioga", "1234567890235252525", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.editUserControllerForTests(user);
        assertEquals(expResult, result);
    }
    @Test
    public void testSuccessDeleteUserController() {
        System.out.println("SuccessDeleteUserController");
        User_Test user = new User_Test("jolteen", "Giota", "Zioga", "1234567890", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = true;
        boolean result = instance.MockdeleteUserControllerForTests(user.getUsername());
        assertEquals(expResult, result);
    }
    @Test
    public void testEmptyUsernameDeleteUserController() {
        System.out.println("EmptyUsernameDeleteUserController");
        User_Test user = new User_Test("", "Giota", "Zioga", "1234567890", "kati", "f_jolteen@yahoo.gr");
        RegisterUserController_forTests instance = new RegisterUserController_forTests();
        boolean expResult = false;
        boolean result = instance.MockdeleteUserControllerForTests(user.getUsername());
        assertEquals(expResult, result);
    }
    
}
