package com.appli.pojo;

import java.util.Arrays;

/*
 * The class Menu does the sorting based on the mode value
 * if mode = 1 asc , if mode = 2 desc
 * 
 */

public class Menu {
	
    private BreakfastMenu breakfast_menu;

    public Menu() {
    }

    public Menu( Food[] listFood ) {
        breakfast_menu = new BreakfastMenu( listFood );
    }


    public void print(int mode) {
    	
        if (mode == 1) {
        	
        	// Sorting
            Arrays.sort(breakfast_menu.getFood()); 
        } else if (mode == 2) {
        	
        	// Sorting
            Arrays.sort(breakfast_menu.getFood()); 

           // Reverse the array
            for (int i = 0; i < breakfast_menu.getFood().length/2; i++) { 
                Food temp = breakfast_menu.getFood()[i];
                breakfast_menu.getFood()[i] = breakfast_menu.getFood()[breakfast_menu.getFood().length-1-i];
                breakfast_menu.getFood()[breakfast_menu.getFood().length-1-i] = temp;
            }
        }
        
        // index of the menu Food 
        int index = 1;
        
        for (Food food : breakfast_menu.getFood()) {
        
            System.out.println("Food number : "+index+++"\nName : "+food.getName() +"\nPrice : "+food.getPrice()+"\nDescription : "+food.getDescription()+"\nCalories : "+food.getCalories()+"\n"); 
        }
    }

	public BreakfastMenu getBreakfast_menu() {
		return breakfast_menu;
	}

	public void setBreakfast_menu(BreakfastMenu breakfast_menu) {
		this.breakfast_menu = breakfast_menu;
	}
    
    
    
}
