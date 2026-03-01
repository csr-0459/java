package com.Shopping.XYZ.dto;

public class ProductDto {
	

	public int productId;
	public String productName;
	public int stock;
	public double price;
	
	@Override
	public String toString() {
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", stock=" + stock + ", price="
				+ price + "]";
	}
	
	
	

}
