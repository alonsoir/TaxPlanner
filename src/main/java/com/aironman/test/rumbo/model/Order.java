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
	private double totalPrize;
	private double totalTaxes;
	
	public Order() {
		super();
		this.id=UUID.randomUUID().toString();
		this.products = new ArrayList<Product>();
		this.totalPrize = 0d;
		this.totalTaxes = 0d;
		
	}
	
	public List<Product> getProducts() {
		return products;
	}

	public void addProduct(Product p) {
		this.products.add(p);
	}
	public double getTotalPrize() {
		return totalPrize;
	}
	public void setTotalPrize(double totalPrize) {
		this.totalPrize += Utilities.redondearDecimales(totalPrize,2);
	}
	public double getTotalTaxes() {
		return totalTaxes;
	}
	public void setTotalTaxes(double totalTaxes) {
		this.totalTaxes += Utilities.redondearDecimales(totalTaxes,2);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\r\n").append("Order [id=").append(id).append("\r\n").append(", products=").append(products).append(", totalPrize=")
				.append(totalPrize).append(", totalTaxes=").append(totalTaxes).append("]").append("\r\n");
		return builder.toString();
	}
	
	
}
