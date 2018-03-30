/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.DAO.IStoreDAO;
import blackMidnight.DAO.MockStoreDAO;
import blackMidnight.DAO.MockStoreFailureDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Elias
 */
public class CreateStoreControllerTest {
    
    public CreateStoreControllerTest() {
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
     * Test of storeCreation method, of class CreateStoreController.
     */
    @Test
    public void testStoreCreationAllPass() {
        System.out.println("StoreCreation");
        String nameOfStore = "Ladokola";
        int numberOfSeats = 50;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "Σέρρες";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        String storeDetails = "good store nice place";
        IStoreDAO dao = new MockStoreDAO();
        CreateStoreController instance = new CreateStoreController(dao);
        boolean expResult = true;
        boolean result = instance.storeCreationForTest(nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email, storeDetails); 
        assertEquals(expResult, result);
        //assertTrue(dao.existStore(nameOfStore));
        // TODO review the generated test code and remove the default call to fail.
    }
    
    @Test
    public void testStoreCreationFailToWrite() {
        System.out.println("StoreCreation");
        String nameOfStore = "Agisilaos";
        int numberOfSeats = 50;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "Σέρρες";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        String storeDetails = "good store nice place";
        IStoreDAO dao = new MockStoreFailureDAO();
        CreateStoreController instance = new CreateStoreController(dao);
        boolean expResult = true;
        boolean result = instance.storeCreation(nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email, storeDetails); // will be fixed soon
        assertEquals(expResult, result);
        //assertFalse(dao.existStore(nameOfStore));
    }
    
    @Test
    public void testStoreCreationFail() {
        System.out.println("StoreCreation");
        String nameOfStore = "";
        int numberOfSeats = 50;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "Σέρρες";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        String storeDetails = "good store nice place";
        CreateStoreController instance = new CreateStoreController(new MockStoreDAO());
        boolean expResult = false;
        boolean result = instance.storeCreation(nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email, storeDetails); // will be fixed soon
        assertEquals(expResult, result);
        // TODO rev
    }
    
    
    @Test
    public void testStoreCreationNumSeatsFail() {
        System.out.println("StoreCreation");
        String nameOfStore = "Agisilaos";
        int numberOfSeats = 0;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "Σέρρες";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        String storeDetails = "good store nice place";
        CreateStoreController instance = new CreateStoreController(new MockStoreDAO());
        boolean expResult = false;
        boolean result = instance.storeCreation(nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email,storeDetails); // will be fixed soon
        assertEquals(expResult, result);
        // TODO rev
    }
    
    @Test
    public void testStoreCreationAddressFail() {
        System.out.println("StoreCreation");
        String nameOfStore = "Agisilaos";
        int numberOfSeats = 0;
        boolean parking = true;
        String address = "";
        String city = "Σέρρες";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        String storeDetails = "good store nice place";
        CreateStoreController instance = new CreateStoreController(new MockStoreDAO());
        boolean expResult = false;
        boolean result = instance.storeCreation(nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email,storeDetails); // will be fixed soon
        assertEquals(expResult, result);
        // TODO rev
    }
    
    @Test
    public void testStoreCreationCityFail() {
        System.out.println("StoreCreation");
        String nameOfStore = "Agisilaos";
        int numberOfSeats = 0;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        String storeDetails = "good store nice place";
        CreateStoreController instance = new CreateStoreController(new MockStoreDAO());
        boolean expResult = false;
        boolean result = instance.storeCreation(nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email,storeDetails); // will be fixed soon
        assertEquals(expResult, result);
        // TODO rev
    }

    @Test
    public void testStoreCreationOpenDaysFail() {
        System.out.println("StoreCreationOpenDaysFail");
        String nameOfStore = "Agisilaos";
        int numberOfSeats = 0;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "Serres";
        String phone = "6976543210";
        String openDays = "";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        String storeDetails = "good store nice place";
        CreateStoreController instance = new CreateStoreController(new MockStoreDAO());
        boolean expResult = false;
        boolean result = instance.storeCreation(nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email,storeDetails); // will be fixed soon
        assertEquals(expResult, result);
        // TODO rev
    }
    
    @Test
    public void testStoreCreationOpenHoursFail() {
        System.out.println("StoreCreationOpenHoursFail");
        String nameOfStore = "Agisilaos";
        int numberOfSeats = 0;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "Serres";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "";
        String email = "papas@gmail.com";
        String storeDetails = "good store nice place";
        CreateStoreController instance = new CreateStoreController(new MockStoreDAO());
        boolean expResult = false;
        boolean result = instance.storeCreation(nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email,storeDetails); // will be fixed soon
        assertEquals(expResult, result);
        // TODO rev
    }
    
}
