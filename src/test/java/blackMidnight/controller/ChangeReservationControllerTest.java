/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import blackMidnight.controller.ChangeReservationController;
import java.io.File;
import java.util.ArrayList;
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
public class ChangeReservationControllerTest {
    
    public ChangeReservationControllerTest() {
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
     * Test of writeFile method, of class JavaApplication2.
     */
   /* @Test
    public void testWriteFileFull() throws Exception {
        System.out.println("writeFile");
        ChangeReservationController change = new ChangeReservationController();
        String name = "pelopidas";
        String dt = "14/10/2013";
        String mag = "mag";
        int num = 4;
        String bookId = "888";
        boolean result = change.writeFile(name, dt, mag, num, bookId);
        boolean expResult = true;
        assertEquals(expResult, result);
        
    }
    @Test
    public void testWriteFileEmpty() throws Exception {
        System.out.println("writeFile");
        ChangeReservationController change = new ChangeReservationController();
        String name = "pelopidas";
        String dt = "14/10/2013";
        String mag = "mag";
        int num = 4;
        String bookId = "888";
        boolean result = change.writeFile(name, dt, mag, num, bookId);
        boolean expResult = false;
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of modifyList method, of class JavaApplication2.
     */
   /* @Test
    public void testModifyListFull() {
        System.out.println("modifyList: Full");
        ChangeReservationController change = new ChangeReservationController();
        ArrayList<String> temp = new ArrayList<String>();
        String text1 = "2971 zoi bal";
        String text2 = "988 blablabla";
        
        temp.add(text1);
        temp.add(text2);
        
        int line = 0;
        String text = "lalalalalalalala";
        ArrayList<String> result = change.modifyList(temp, text, line);
        
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add(text);
        expResult.add(text2);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testModifyListEmpty() {
        System.out.println("modifyList: Empty");
        ChangeReservationController change = new ChangeReservationController();
        ArrayList<String> temp = new ArrayList<String>();
        String text = "2971 zoi bal";
        int line = 0;
        ArrayList<String> expResult = new ArrayList<String>();
        ArrayList<String> result = change.modifyList(temp, text, line);
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of readFile method, of class JavaApplication2.
     * @throws java.lang.Exception
     */
   /* @Test
    public void testReadFileFull() throws Exception {
        System.out.println("readFile: Full");
        ChangeReservationController change = new ChangeReservationController();
        ArrayList<String> expResult = new ArrayList<String>();
        ArrayList<String> result = new ArrayList<String>();
        result = change.readFile();
        
        String line1 = "100 maria 12/2/2013 magazi 2";
        String line2 = "200 zoi 12/2/2013 magazi 6";
        String line3 = "300 kostas 12/2/2013 magazi 10";
        String line4 = "155 giannis 12/2/2013 magazi 2";
        String line5 = "456 despoina 12/2/2013 magazi 3";
        String line6 = "222 petros 12/2/2013 magazi 3";
        expResult.add(line1);
        expResult.add(line2);
        expResult.add(line3);
        expResult.add(line4);
        expResult.add(line5);
        expResult.add(line6);
        
        assertEquals(expResult, result);
    }
    @Test
    public void testReadFileEmpty() throws Exception {
        System.out.println("readFile: Empty");
        ChangeReservationController change = new ChangeReservationController();
        ArrayList<String> expResult = null;
        ArrayList<String> result = change.readFile();
        assertEquals(expResult, result);
    }
   
    /**
     * Test of findLine method, of class JavaApplication2.
     * @throws java.lang.Exception
     */
   /* @Test
    public void testFindLineFound() throws Exception {
        System.out.println("findLine: The record found");
        ChangeReservationController change = new ChangeReservationController();
        File file = change.getFile();
        String bookId = "100";
        int expResult = 0;
        int result = change.findLine(bookId,file);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testFindLineNotFound() throws Exception {
        System.out.println("findLine: record not found");
        ChangeReservationController change = new ChangeReservationController();
        File file = change.getFile();
        String bookId = "2871";
        int expResult = -1;
        int result = change.findLine(bookId,file);
        assertEquals(expResult, result);
        
    }

     /**
     * Test of countLines method, of class JavaApplication2.
     * @throws java.lang.Exception
     */ 
//    @Test
//    public void testCountLines() throws Exception {
//        System.out.println("countLines");
//        ChangeReservationController change = new ChangeReservationController();
//        File file = new File("Reservations.txt");
//        int expResult = 6;
//        int result = change.countLines();
//        assertEquals(expResult, result);
//        
//    } 
}
