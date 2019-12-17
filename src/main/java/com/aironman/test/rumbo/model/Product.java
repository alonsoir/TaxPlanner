package com.aironman.test.rumbo.model;

import java.util.UUID;

import com.aironman.test.rumbo.misc.Utilities;

/***
 * 
 * @author aironman
 *
 */
public class Product {

	private String id;
	private String description;
	private float prize;
	private boolean imported;
	private boolean tax_exempt;
	private float sale_tax;
	
	public Product() {
		
	}
	
	public Product(String description, float prize) {
		super();
		this.id=UUID.randomUUID().toString();
		this.description = description;
		this.prize = prize;
		this.tax_exempt = description.matches("(.*)book(.*)") || 
						  description.matches("(.*)food(.*)") || 
						  description.matches("(.*)medical(.*)");
		
		this.imported = description.matches("(.*)imported(.*)");
		
	}

	public float getPrize() {
		return Utilities.roundToDecimals(prize,2);
	}

	
	public void setPrize(float prize) {
		this.prize = Utilities.roundToDecimals(prize,2);
	}

	public boolean getisImported() {
		return imported;
	}

	
	public boolean getisTax_exempt() {
		return tax_exempt;
	}

	public float getSale_tax() {
		return Utilities.roundToDecimals(sale_tax,2);
	}

	public void setSale_tax(float sale_tax) {
		this.sale_tax = Utilities.roundTo_Zero_Point_Zero_Five_Up_value(sale_tax);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [id=").append(id).append(", description=").append(description).append(", prize=")
				.append(prize).append(", imported=").append(imported).append(", tax_exempt=").append(tax_exempt)
				.append(", sale_tax=").append(sale_tax)
				.append("]")
				.append("\r\n");
		return builder.toString();
	}

	
	
	
	
}
