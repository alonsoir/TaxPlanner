package com.aironman.test.rumbo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.aironman.test.rumbo.misc.Utilities;

/***
 * 
 * @author aironman
 *
 */
public class Order {
	
	private String id;
	private List<Product> products;
	private float totalPrize;
	private float totalTaxes;
	
	public Order() {
		super();
		this.id=UUID.randomUUID().toString();
		this.products = new ArrayList<Product>();
		this.totalPrize = 0f;
		this.totalTaxes = 0f;
		
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product p) {
		this.products.add(p);
	}
	
	public float getTotalPrize() {
		return Utilities.roundToDecimals(totalPrize,2);
	}
	
	public void setTotalPrize(float totalPrize) {
		this.totalPrize += Utilities.roundToDecimals(totalPrize,2);
	}
	
	public float getTotalTaxes() {
		return Utilities.roundToDecimals(totalTaxes,2);
	}
	
	public void setTotalTaxes(float totalTaxes) {
		this.totalTaxes += Utilities.roundTo_Zero_Point_Zero_Five_Up_value(totalTaxes);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n").append("Order [id=").append(id).append("\r\n").append(", products=").append(products).append(", totalPrize=")
				.append(totalPrize).append(", totalTaxes=").append(totalTaxes).append("]").append("\r\n");
		return builder.toString();
	}
	
	
}
