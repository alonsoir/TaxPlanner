package com.aironman.test.rumbo.misc;

import com.aironman.test.rumbo.model.Order;
import com.aironman.test.rumbo.model.Product;

/***
 * 
 * @author aironman
 *
 */
public class Utilities {

	public static Order createOrder1() {
    	/*
    	 * 
    	 * 1 book 12.49
    	 * 1 Music CD 14.99
    	 * 1 chocolate bar 0.85
    	 * */
    	Product p1 = new Product("book", 12.49f); //exempted not imported
    	Product p2 = new Product("Music CD",14.99f); // not exempted not imported
    	Product p3 = new Product("food chocolate bar",0.85f); //exempted not imported
    	Order order = new Order();
    	order.addProduct(p1);
    	order.addProduct(p2);
    	order.addProduct(p3);
    	
    	return order;
    }
    
	public static Order createOrder2() {
    	/*
    	 * 
    	 * 1 imported box of chocolate 10.00
    	 * 1 imported bottle of perfume 47.50
    	 * */
    	Product p1 = new Product("imported food box of chocolate", 10.00f); //exempted and imported
    	Product p2 = new Product("imported bottle of perfume",47.50f); //not exempted imported
    	
    	Order order = new Order();
    	order.addProduct(p1);
    	order.addProduct(p2);
    	
    	return order;
    }
    
	public static Order createOrder3() {
    	/*
    	 * 
    	 * 1 imported bottle of perfume 27.99
    	 * 1 bottle of perfume 18.99
    	 * 1 packet headache pills 9.75
    	 * 1 imported box of chocolate 11.25
    	 * 
    	 * */
    	Product p1 = new Product("imported food box of chocolate", 11.25f); ////exempted and imported
    	Product p2 = new Product("imported bottle of perfume",27.99f); //not exempted imported
    	
    	Product p3 = new Product("packet headache pills, medical", 9.75f); //exempted not imported
    	Product p4 = new Product("bottle of perfume",18.99f); //not exempted not imported
    	
    	Order order = new Order();
    	order.addProduct(p1);
    	order.addProduct(p2);
    	order.addProduct(p3);
    	order.addProduct(p4);
    	return order;
    }
	
	public static Float roundTo_Zero_Point_Zero_Five_Up_value(double initialValue) {
		Float rounded = new Float (Math.round(initialValue * 20.0) / 20.0);		
		return rounded;
	}
	
	public static float roundToDecimals(float initialValue, int numDecimals) {
        double wholePart, result;
        result = initialValue;
        wholePart = Math.floor(result);
        result=(result-wholePart)*Math.pow(10, numDecimals);
        result=Math.round(result);
        result=(result/Math.pow(10, numDecimals))+wholePart;
        
        return new Float(result);
        //return new Float (Math.round(result * 20.0) / 20.0);		
    }
	
}
