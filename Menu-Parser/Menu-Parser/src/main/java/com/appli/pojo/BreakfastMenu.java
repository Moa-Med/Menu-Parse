package com.appli.pojo;


/**
 * Pojo of the BreakfastMenu
 *
 */

public class BreakfastMenu {
	
    private Food[] food;

    public BreakfastMenu(Food[] list) {
        food = list;
    }
    
    public BreakfastMenu() {
        
    }

	public Food[] getFood() {
		return food;
	}

	public void setFood(Food[] food) {
		this.food = food;
	}
    
    
}
