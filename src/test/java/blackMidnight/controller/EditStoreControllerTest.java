/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.DAO.IStoreDAO;
import blackMidnight.DAO.StoreDAO;
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
public class EditStoreControllerTest {
    
    public EditStoreControllerTest() {
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
     * Test of editStore method, of class EditStoreController.
     */
    @Test
    public void testEditStoreSuccess() {
        System.out.println("editStore");
        int storeId=1;
        String nameOfStore = "Ladokola";
        int numberOfSeats = 50;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "Σέρρες";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        IStoreDAO dao = new StoreDAO();
        EditStoreController instance = new EditStoreController();
        boolean expResult = true;
        boolean result = instance.editStore(storeId, nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email); // will be fixed soon
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEditStoreNegativeNumOfSeats() {
        System.out.println("editStore");
        int storeId=1;
        String nameOfStore = "Ladokola";
        int numberOfSeats = -5;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "Σέρρες";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        IStoreDAO dao = new StoreDAO();
        EditStoreController instance = new EditStoreController();
        boolean expResult = false;
        boolean result = instance.editStore(storeId, nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email); // will be fixed soon
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEditStoreNoAddress() {
        System.out.println("editStore");
        int storeId=1;
        String nameOfStore = "Ladokola";
        int numberOfSeats = 50;
        boolean parking = true;
        String address = "";
        String city = "Σέρρες";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        IStoreDAO dao = new StoreDAO();
        EditStoreController instance = new EditStoreController();
        boolean expResult = false;
        boolean result = instance.editStore(storeId, nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email); // will be fixed soon
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEditStoreNoCity() {
        System.out.println("editStore");
        int storeId=1;
        String nameOfStore = "Ladokola";
        int numberOfSeats = 50;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "18:00-20:00";
        String email = "papas@gmail.com";
        IStoreDAO dao = new StoreDAO();
        EditStoreController instance = new EditStoreController();
        boolean expResult = false;
        boolean result = instance.editStore(storeId, nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email); // will be fixed soon
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEditStoreNoOpenHours() {
        System.out.println("editStore");
        int storeId=1;
        String nameOfStore = "Ladokola";
        int numberOfSeats = 50;
        boolean parking = true;
        String address = "Ευζώνων 3";
        String city = "Σέρρες";
        String phone = "6976543210";
        String openDays = "123";
        String openHours = "";
        String email = "papas@gmail.com";
        IStoreDAO dao = new StoreDAO();
        EditStoreController instance = new EditStoreController();
        boolean expResult = false;
        boolean result = instance.editStore(storeId, nameOfStore, numberOfSeats, parking, 
                address, city, phone, openDays, openHours, email); // will be fixed soon
        assertEquals(expResult, result);
    }
    
}
