/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package blackMidnight.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Ilias
 */
public class ChangeReservationController implements IChangeReservationController {
    
private File file = new File("Reservations.txt");
	    
		// A Function that writes the changes in the file
    @Override
	     public boolean writeFile(String name, String dt , String mag, int num, String bookId) throws FileNotFoundException, IOException 
	    {
	        String text =  bookId + " " + name + " " + dt + " " + mag + " " + num;
			 //readFile();
	        ArrayList<String> flines = new ArrayList<String>();
			flines = readFile();
			int line = findLine(bookId,file);
			flines = modifyList(flines,text,line);
	        try {
                  //FileOutputStream writer = new FileOutputStream("txt.txt");
                   
	          BufferedWriter output = new BufferedWriter(new FileWriter(file));
                  for(int i = 0; i<flines.size(); i ++){
	          output.write(flines.get(i));
	          output.newLine();
                  }
	          output.close();
                  
	        } catch ( IOException e ) {
	           e.printStackTrace();
	        }
                if(file.length()>0){
                    return true;
                }
                else{
                    return false;
                }
	     }
	     
	     //A function that modifies the arrayList
    @Override
	     public ArrayList<String> modifyList(ArrayList<String> temp, String text, int line)
	     {
	    	 ArrayList<String> finalList = new ArrayList<String>(); 
	    	 for(int i =0; i<temp.size(); i++)
	    	 {
	    		 if(i == line)
	    			 finalList.add(text);
	    		 else
	    			 finalList.add(temp.get(i));
	    		
                 }
                 return finalList;
             }
	    
		// A function that reads all the lines from the txt file and puts them on ArrayList
    @Override
	    public ArrayList<String> readFile() throws FileNotFoundException, IOException{
			BufferedReader input = new BufferedReader(new FileReader(file) );
			int lines = 0;
			lines = countLines();
			ArrayList<String> temp = new ArrayList<String>();
	                
			for(int i = 0; i<lines; i++){
				String out = input.readLine();
                                out.trim();
				temp.add(out);
	                        System.out.println(out);   
			}
			 input.close();
                         if(temp.isEmpty()){
                             return new ArrayList<String>();
                         }
                         else
                         {
                            return temp;
                         }
		}
		
		//A function that finds the line in the txt file that needs to be changed
    @Override
	    public int findLine(String bookId, File fl) throws FileNotFoundException, IOException
	    {
	        int line = -1;
	        final Scanner scanner = new Scanner(fl);
	        while (scanner.hasNextLine()) {
	            final String lineFromFile = scanner.nextLine();
	            line++;
	            if(lineFromFile.contains(bookId)) { 
				System.out.println("I found in line " + line);
	                        return line;
	            }   
			}
			return -1;
		}
		
		//A function that calculates the lines in the txt file
    @Override
	    public int countLines() throws FileNotFoundException{
	        Scanner scanner = new Scanner(file);
	        int line = 0;
	        while (scanner.hasNextLine()) {
	            final String lineFromFile = scanner.nextLine();
	            line++;
	        }
			return line;
		}
            
      public File getFile()
      {
          return file;
      }
}
