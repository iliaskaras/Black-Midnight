/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.model;

import org.joda.time.DateTime;
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
public class StoreAvailableTest {
    
    public StoreAvailableTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
   
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of storeAvailable method, of class StoreAvailable.
     * Tests what happens if the store is available the requested day+time.
     */
    @Test
    public void testStoreAvailableTrue() {
        System.out.println("storeAvailableTrue");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "135", "18:00-23:00", "papas@gmail..com");
        String date = "08/11/2013";
        String hour = "19:00";
        boolean expResult = true;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeAvailable(store, date, hour);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of storeAvailable method, of class StoreAvailable.
     * Tests what happens if the store is not available the requested day+time.
     */
    @Test
    public void testStoreAvailableFalse() {
        System.out.println("storeAvailableFalse");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "135", "18:00-23:00", "papas@gmail.com");
        String date = "09/11/2013";
        String hour = "14:00";
        boolean expResult = false;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeAvailable(store, date, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeAvailable method, of class StoreAvailable.
     * Tests what happens if the store is not available at the requested time.
     */
    @Test
    public void testStoreAvailableFalseHour() {
        System.out.println("storeAvailableFalseHour");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "135", "18:00-23:00", "papas@gmail.com");
        String date = "08/11/2013";
        String hour = "02:00";
        boolean expResult = false;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeAvailable(store, date, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeAvailable method, of class StoreAvailable.
     * Tests what happens if the store is not available at the requested day.
     */
    @Test
    public void testStoreAvailableFalseDate() {
        System.out.println("storeAvailableFalseDate");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "135", "18:00-23:00", "papas@gmail.com");
        String date = "09/11/2013";
        String hour = "19:00";
        boolean expResult = false;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeAvailable(store, date, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeDayAvailable method, of class StoreAvailable.
     * Tests what happens if the store is available the requested day.
     */
    @Test
    public void testStoreDayAvailableTrue() {
        System.out.println("storeDayAvailableTrue");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "125", "18:00-23:00", "papas@gmail.com");
        String date = "08/11/2013";
        boolean expResult = true;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeDayAvailable(store, date);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeDayAvailable method, of class StoreAvailable.
     * Tests what happens if the store isn't available the requested day.
     */
    @Test
    public void testStoreDayAvailableFalse() {
        System.out.println("storeDayAvailable");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "125", "18:00-23:00", "papas@gmail.com");
        String date = "07/11/2013";
        boolean expResult = false;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeDayAvailable(store, date);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeDayAvailable method, of class StoreAvailable.
     * Tests what happens if the requested day is the first day
     * the store is available.
     */
    @Test
    public void testStoreDayAvailableFirstDay() {
        System.out.println("storeDayAvailableFirstDay");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "56", "18:00-23:00", "papas@gmail.com");
        String date = "08/11/2013";
        boolean expResult = true;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeDayAvailable(store, date);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of storeDayAvailable method, of class StoreAvailable.
     * Tests what happens if the requested day is the last day
     * the store is available.
     */
    @Test
    public void testStoreDayAvailableLastDay() {
        System.out.println("storeDayAvailableLastDay");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "18:00-23:00", "papas@gmail.com");
        String date = "08/11/2013";
        boolean expResult = true;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeDayAvailable(store, date);
        assertEquals(expResult, result);
    }
   
    /**
     * Test of storeHourAvailable method, of class StoreAvailable.
     * Tests what happens if the store is available the requested time.
     */
    @Test
    public void testStoreHourAvailableTrue() {
        System.out.println("storeHourAvailableTrue");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "18:00-02:00","papas@gmail.com");
        String hour = "19:00";
        boolean expResult = true;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeHourAvailable(store, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeHourAvailable method, of class StoreAvailable.
     * Tests what happens if the store isn't available the requested time.
     */
    @Test
    public void testStoreHourAvailableFalse() {
        System.out.println("storeHourAvailableFalse");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "18:00-23:00", "papas@gmail.com");
        String hour = "02:00";
        boolean expResult = false;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeHourAvailable(store, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeHourAvailable method, of class StoreAvailable.
     * Tests what happens if the requested time is the opening time
     * of the store.
     */
    @Test
    public void testStoreHourAvailableOpenHour() {
        System.out.println("storeHourAvailableOpenHour");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "18:00-23:00", "papas@gmail.com");
        String hour = "18:00";
        boolean expResult = true;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeHourAvailable(store, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeHourAvailable method, of class StoreAvailable.
     * Tests what happens if the requested time is in the middle
     * of open and close hours and is AM.
     */
    @Test
    public void testStoreHourAvailableMiddleHourAmTrue() {
        System.out.println("storeHourAvailableMiddleHourAmTrue");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "18:00-02:00", "papas@gmail.com");
        String hour = "01:00";
        boolean expResult = true;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeHourAvailable(store, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeHourAvailable method, of class StoreAvailable.
     * Tests what happens if the requested time is the opening time
     * of the store.
     */
    @Test
    public void testStoreHourAvailableMiddleHourAmFalse() {
        System.out.println("storeHourAvailableMiddleHourAmFalse");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "18:00-02:00", "papas@gmail.com");
        String hour = "03:00";
        boolean expResult = false;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeHourAvailable(store, hour);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of storeHourAvailable method, of class StoreAvailable.
     * Tests what happens if the requested time is the opening time
     * of the store.
     */
    @Test
    public void testStoreHourAvailableOpenHourIsAmTrue() {
        System.out.println("storeHourAvailableOpenHourIsAmTrue");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "01:00-06:00", "papas@gmail.com");
        String hour = "02:00";
        boolean expResult = true;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeHourAvailable(store, hour);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of storeHourAvailable method, of class StoreAvailable.
     * Tests what happens if the requested time is the opening time
     * of the store.
     */
    @Test
    public void testStoreHourAvailableOpenHourIs00AmTrue() {
        System.out.println("storeHourAvailableOpenHourIs00AmTrue");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "19:00-06:00", "papas@gmail.com");
        String hour = "00:00";
        boolean expResult = true;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeHourAvailable(store, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeHourAvailable method, of class StoreAvailable.
     * Tests what happens if the requested time is the opening time
     * of the store.
     */
    @Test
    public void testStoreHourAvailableOpenHourIs00AmFalse() {
        System.out.println("storeHourAvailableOpenHourIs00AmFalse");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "19:00-23:00", "papas@gmail.com");
        String hour = "00:00";
        boolean expResult = false;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeHourAvailable(store, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeHourAvailable method, of class StoreAvailable.
     * Tests what happens if the requested time is the opening time
     * of the store.
     */
    @Test
    public void testStoreHourAvailableOpenHourIsAmFalse() {
        System.out.println("storeHourAvailableOpenHourIsAmFalse");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "01:00-06:00", "papas@gmail.com");
        String hour = "07:00";
        boolean expResult = false;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeHourAvailable(store, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of storeHourAvailable method, of class StoreAvailable.
     * Tests what happens if the requested time is the opening time
     * of the store.
     */
    @Test
    public void testStoreHourAvailableCloseHour() {
        System.out.println("storeHourAvailableCloseHour");
        Store store = new Store("New Store", 10, "address", "city",
                "123456789", true, "35", "18:00-23:00", "papas@gmail.com");
        String hour = "23:00";
        boolean expResult = false;
        StoreAvailable instance = new StoreAvailable();
        boolean result = instance.storeHourAvailable(store, hour);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setTime method, of class StoreAvailable.
     * Tests what happens if the time is am
     */
    @Test
    public void testSetTimeAm() {
        System.out.println("setTimeAm");
        int hour = 01;
        int minute = 30;
        StoreAvailable instance = new StoreAvailable();
        DateTime current = new DateTime();
        DateTime expResult = new DateTime(current.getYear()
                                        , current.getMonthOfYear()
                                        , current.getDayOfMonth()+ 1, 01, 30);
        DateTime result = instance.setTime(hour, minute);
        assertEquals(expResult.toString(),result.toString());
    }
    
    /**
     * Test of setTime method, of class StoreAvailable.
     * Tests what happens if the time is pm
     */
    @Test
    public void testSetTimePm() {
        System.out.println("setTimePm");
        int hour = 19;
        int minute = 30;
        StoreAvailable instance = new StoreAvailable();
        DateTime current = new DateTime();
        DateTime expResult = new DateTime(current.getYear()
                                        , current.getMonthOfYear()
                                        , current.getDayOfMonth(), 19, 30);
        DateTime result = instance.setTime(hour, minute);
        assertEquals(expResult.toString(),result.toString());
    }
    
     @AfterClass
    public static void tearDownClass() {
    }
}
