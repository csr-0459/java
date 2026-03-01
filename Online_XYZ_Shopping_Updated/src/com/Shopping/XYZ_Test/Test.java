package com.Shopping.XYZ_Test;

import java.util.Scanner;

import com.Shopping.XYZ.Login;
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
		int logininfo;
		String name,email,gender,userName,dob=null,password;
		long mobile_no;
		System.out.println("Enter 1 for Registration 2 for Login");
		logininfo = sc.nextInt();
		boolean isLoggedIn = false;
		switch(logininfo)
		{
			case 1 :
			System.out.println("Enter your Detals");
			System.out.println("Enter your Full name : ");
			name = sc.next();
			System.out.println("Enter your e-mail Id : ");
			email = sc.next();
			System.out.println("Enter the 1 for Male 2 for Female ");
			int g = sc.nextInt();
			if(g==1)
			{
				gender = "male";
			}
			else
			{
				gender = "Female";
			}
			System.out.println("Enter your userName : ");
			userName = sc.next();
			System.out.println("Create your Password : ");
			password = sc.next();
			System.out.println("Enter Date of Birth : ");
			System.out.println("Enter Date : ");
			int d = sc.nextInt();
			System.out.println("Enter Month : ");
			int m = sc.nextInt();
			System.out.println("Enter Year : ");
			int y = sc.nextInt();
			dob = String.format("%02d-%02d-%04d", d, m, y);
			System.out.println("Enter your phone Number : ");
			mobile_no = sc.nextLong();
			
			new Login().insertDetails(name,email,gender,userName,dob,password,mobile_no);
			System.out.printf("UserName : %s   Password : %s",userName,password);
			
			break;
			
			
			
			case 2 : 
			String un,pass;
			System.out.println("Enter Your userName :");
			un = sc.next();
			System.out.println("Enter Your password : ");
			pass = sc.next();
			isLoggedIn = new Login().Validation(un, pass);

	        if(isLoggedIn){
	            System.out.println("Login Successful!");
	        } else {
	            System.out.println("Invalid Username or Password");
	            System.out.println("Exiting Program...");
	            sc.close();
	            return;   // ❗ stops program here
	        }
	        break;
			
			default:
				System.out.print("Invalid Input");
				sc.close();
		        return;
		
		}
		
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
