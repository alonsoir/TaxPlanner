package com.aironman.test.rumbo.model;

import java.util.UUID;

/***
 * 
 * @author aironman
 *
 */
public class Product {

	private String id;
	private String description;
	private double prize;
	private boolean imported;
	private boolean tax_exempt;
	private double sale_tax;
	
	public Product() {
		
	}
	
	public Product(String description, double prize) {
		super();
		this.id=UUID.randomUUID().toString();
		this.description = description;
		this.prize = prize;
		this.tax_exempt = description.matches("(.*)book(.*)") || 
						  description.matches("(.*)food(.*)") || 
						  description.matches("(.*)medical(.*)");
		
		this.imported = description.matches("(.*)imported(.*)");
		
	}

	public double getPrize() {
		return prize;
	}

	public boolean getisImported() {
		return imported;
	}

	
	public boolean getisTax_exempt() {
		return tax_exempt;
	}

	public double getSale_tax() {
		return sale_tax;
	}

	public void setSale_tax(double sale_tax) {
		this.sale_tax = sale_tax;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=").append(id).append(", description=").append(description).append(", prize=")
				.append(prize).append(", imported=").append(imported).append(", tax_exempt=").append(tax_exempt)
				.append(", sale_tax=").append(sale_tax).append("]")
				.append("\r\n");
		return builder.toString();
	}

	
	
	
	
}
