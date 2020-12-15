package com.appli.starterApplication;
import java.io.File;

import com.appli.parseFile.Parser;

/**
 * Class to run the Application
 *
 * @author MOHAMED TRAORE
 */

public class Application {
	
    public static void main(String[] args) {
    	
        try {
        	
            if (args.length == 2) {
            	// Detect the mode. If none of presets ascending.
                int mode = args[1].equals("desc") ? 2:1; 
             // Parse the JSON file
                if (args[0].endsWith(".json")) Parser.parseFromJSON(new File(args[0])).print(mode); 
             // Parse the XML file
                else if (args[0].endsWith(".xml")) Parser.parseFromXML(new File(args[0])).print(mode); 
            } else {
                System.out.println("Insertion incorrect, enter the right insertion please!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid file found");
        }
    }
}
