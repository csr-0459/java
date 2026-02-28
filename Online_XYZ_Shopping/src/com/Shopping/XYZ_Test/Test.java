package com.Shopping.XYZ_Test;

import java.util.Scanner;
import com.Shopping.XYZ.Order;
import com.Shopping.XYZ.Product;
import com.Shopping.XYZ.dto.ProductDto;

public class Test {
	
	static public void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		Product pro = new Product();
		Order order = new Order();
		char choice,buyMoreProducts;
		int option,productid,quantity;
		double totalPrice;
		int orderNumber = 0;
		
		do
		{
			System.out.println("*****Welcome to XYZ Shopping *****");
			System.out.println("1. Buy Product");
			System.out.println("2. Generate Bill");
			
			System.out.println("Enter Your option : ");
			option = sc.nextInt();
			
			switch(option)
			{
			case 1:{
				do
				{
				System.out.println("***** All Availabe products *****");
				// All Products
				pro.getAllProducts();
				System.out.println("Enter Product id which you want to buy :");
				productid = sc.nextInt();
				System.out.println("Enter Quantity : ");
				quantity = sc.nextInt();
				
				ProductDto dto  = pro.getProductById(productid);
				
				totalPrice = quantity*dto.price;
				
				
				if(orderNumber == 0)
				{
					orderNumber = order.generateOrderId();
				}
				
				order.placeOrder(orderNumber, productid, dto.productName, quantity, totalPrice);
				pro.updateProduct(productid, quantity);
				
				System.out.println("Do you want to buy more products ? (Y/N) ");
				buyMoreProducts = sc.next().toUpperCase().charAt(0);
				}while(buyMoreProducts=='Y');
				
				break;
				
				}
			case 2:{
				System.out.println("Enter ORDER NUMBER : ");
				orderNumber = sc.nextInt();
				order.generateBillById(orderNumber);
				break;
				}
			default:
				System.out.println("Please Enter Correct Input ");
			}
			
			
			System.out.println("Please note your order number for bill generetion : "+orderNumber);
			System.out.println("Do you want to continue shopping ? (Y/N)");
			choice = sc.next().charAt(0);
			
		}while(choice == 'Y'||choice == 'y');
		System.out.println("Thanking for Using XYZ Shopping \n\tWe Will Meet You Soon");
		sc.close();
	}

}
