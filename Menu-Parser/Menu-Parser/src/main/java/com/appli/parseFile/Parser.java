package com.appli.parseFile;

import com.appli.pojo.Food;
import com.appli.pojo.Menu;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * This class parses the file from Json file and Xml file 
 * Json : I used the normal Gson Class to parse it
 * Xml : I used the xml.parsers.Document builder and the w3c.dom
 */

public class Parser {
	
	//parsing file from XML
    public static Menu parseFromXML(File file) {
    	
        if (file.exists()) {
        	
            try {
            	// Create the document factory
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); 
                
                // Create the document
                final DocumentBuilder documentBuilder = factory.newDocumentBuilder(); 
                
             // Parse the XML file
                final Document DOM = documentBuilder.parse(file); 
                
             // Get the first Element and casting it 
                final Element root = ((Element) DOM.getElementsByTagName("breakfast_menu").item(0)); 
                
                // Find all foods
                final NodeList food = root.getElementsByTagName("food");
                
                Food[] listFood = new Food[food.getLength()]; 
                
                
                for (int i = 0; i < food.getLength(); i++) { 
                	
                	// Security check because i cannot cast a DeferredNodeImpl as Element
                    if (food.item(0).getNodeType() == Node.ELEMENT_NODE) { 
                    	
                        final Element item = (Element) food.item(i); 
                        final Node name = item.getElementsByTagName("name").item(0);
                        final Node description = item.getElementsByTagName("description").item(0);
                        final Node price = item.getElementsByTagName("price").item(0);
                        final Node calories = item.getElementsByTagName("calories").item(0);
                     // Add the parsed food to the list
                        listFood[i] = new Food(name.getTextContent(), description.getTextContent(), price.getTextContent(), Integer.parseInt(calories.getTextContent())); 
                    }
                }
                
                return new Menu(listFood); 
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        } else throw new IllegalArgumentException("File: "+file.getAbsolutePath()+" does not exist");
        
        return null;
    }

    public static Menu parseFromJSON(File file) {
    	
        if (file.exists()) {
        	
            // Build Gson object
            final Gson gson = new GsonBuilder().create();
            try {
                final Scanner scanner = new Scanner(file);
                
                final StringBuilder builder = new StringBuilder();

                // Read JSON
                while (scanner.hasNextLine()) builder.append(scanner.nextLine());

                // Convert it
                return gson.fromJson(builder.toString(), Menu.class);
                
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else throw new IllegalArgumentException("File: "+file.getAbsolutePath()+" does not exist");
        
        return null;
    }
}
