package com.appli.pojo;


/*
 * Pojo of the Food implementing the Comparable interface 
 * to compare the menu based on the name which is 
 * shown in the method copareTo
 */


public class Food implements Comparable<Food>{
	
    private String name, description, price;
    
    private int calories;

    public int compareTo(Food o) {
        return name.compareTo(o.name);
    }

    public Food() { }

    public Food(String name, String description, String price, int calories) {
    	
        this.name = name;
        
        this.description = description;
        
        this.price = price;
        
        this.calories = calories;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}
    
    
}
