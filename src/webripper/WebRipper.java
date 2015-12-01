/*
 * This app will take a URL, and read it using the openStream() method
 * to rip the URL line for line and dump the code (assuming this works)
 * into a text file.


Imports: 

java.io
java.net.URL

Steps:

1. Get URL, place into URL object
2. create new BufferedReader
3. Create string to read line from BR
4. Write line to file.
 */
package webripper;

import java.io.*;
import java.net.*;
import javax.swing.JFrame;
import java.util.regex.*;

/**
 *
 * @author FCon
 */
public class WebRipper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        //Start up the GUI
        JFrame frame = new WebripUI();
        frame.setTitle("FCon's Web Ripper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        //String URLtest = "http://www.oracle.com/";
        String URLtest = "https://www.kickstarter.com/projects/netta/g-ro-revolutionary-carry-on-luggage";
        String outputFile = "c:\\outputTest.txt";
        
        //ripSite( URLtest, outputFile);
        
    }
    
    public static void ripSite(String destURL, String destFile, WebripUI f){
        
        
        String fileToWrite = destFile;
        f.appendText("Test");
        try{
        URL toRip = new URL(destURL);
        
        PrintWriter outTxt = new PrintWriter(destFile);
        
        BufferedReader BR = new BufferedReader( new InputStreamReader(toRip.openStream()));
        
        String inputLine;
        
        
            while((inputLine = BR.readLine()) != null){
                System.out.println(inputLine);
                outTxt.println(inputLine);
//outTxt.println(inputLine);
            }
            
        outTxt.close();
            
        }
        
        catch(Exception e){
            
            System.out.println("Error in ripSite method: " + e.toString());
        }
        
        
        
        
    }
}
