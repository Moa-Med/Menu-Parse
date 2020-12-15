package com.appli.test;

import java.io.File;

import com.appli.parseFile.Parser;
import com.appli.pojo.Food;
import com.appli.pojo.Menu;

/*
 * Class test
 */

public class SimpleTest {
	
    private Menu menu;

    public static void main(String[] args) {
    	
        final SimpleTest simpleTest = new SimpleTest();
        
        Food[] food = new Food[3];
        // I added two files which will be sorted and displayed
        try {
        System.out.println("Ascending order\n");	
        Parser.parseFromJSON(new File("Data/menuTest1.json")).print(1);
        System.out.println("\n");
        
        System.out.println("Descending order\n");	
        Parser.parseFromXML(new File("Data/menuTest.xml")).print(2);
        System.out.println("\n");
        
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Invalid file found");
        }
        
       // testing the sorting
        food[0] = new Food("A", "desc", "10$", 400);
        food[1] = new Food("B", "desc", "99$", 400);
        food[2] = new Food("C", "desc", "12$", 400);

        simpleTest.menu = new Menu(food);

        System.out.println("Ascending order");
        simpleTest.menu.print(1);

        System.out.println("\nDescending order");
        simpleTest.menu.print(2);
    }
    
    
}
