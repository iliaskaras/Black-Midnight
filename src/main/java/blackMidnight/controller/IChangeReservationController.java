/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Ilias
 */
public interface IChangeReservationController {

    //A function that calculates the lines in the txt file
    int countLines() throws FileNotFoundException;

    //A function that finds the line in the txt file that needs to be changed
    int findLine(String bookId,File fl) throws FileNotFoundException, IOException;

    //A function that modifies the arrayList
    ArrayList<String> modifyList(ArrayList<String> temp, String text, int line);

    // A function that reads all the lines from the txt file and puts them on ArrayList
    ArrayList<String> readFile() throws FileNotFoundException, IOException;

    // A Function that writes the changes in the file
    boolean writeFile(String name, String dt, String mag, int num, String bookId) throws FileNotFoundException, IOException;
    
    public File getFile();
}
