package com.Shopping.XYZ;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import com.Shopping.XYZ.util.DataBaseConnection;

public class Order {
	
	private static final String PLACE_ORDER_QUERY = "insert into orders values(?,?,?,?,?)";
	private static final String GET_ORDER_BY_ID_QUERY = "select * from orders where order_id = ?";
	private Connection con ;
	public int placeOrder(int order_id,int product_id,String product_name,int quantity,double total_price)
	{		
		int i=0;
		try
		{
			
			con = DataBaseConnection.getDataBaseConnection();
			if (con == null) {
	            System.out.println("Connection Failed!");
	            return 0;
	        }
			con.setAutoCommit(false);
			PreparedStatement ps = con.prepareStatement(PLACE_ORDER_QUERY);
			
			
			ps.setInt(1, order_id);
			ps.setInt(2, product_id);
			ps.setString(3, product_name);
			ps.setInt(4, quantity);
			ps.setDouble(5, total_price);
			i = ps.executeUpdate();
			con.commit();
			if(i>0)
			{
				System.out.println("Order Placed Successfully");
			}
			else
			{
				System.out.println("Failed to place Order");
			}
			
			ps.close();
			con.close();
		} 
		
		catch (Exception e) {
			try {
	            if(con != null)
	                con.rollback();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        e.printStackTrace();
		}
		return i;
		
	}
	
	public void generateBillById(int orderNo)
	{
		double Grant_Total = 0.0;
		try
		{
			con = DataBaseConnection.getDataBaseConnection();
			PreparedStatement ps = con.prepareStatement(GET_ORDER_BY_ID_QUERY);
			ps.setInt(1, orderNo);
			ResultSet rs = ps.executeQuery();
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("ORDER_ID\tPRODUCT_ID\tPRODUCT_NAME\tSTOCK\tPRICE");
			System.out.println("--------------------------------------------------------------------------");
			
			while(rs.next())
			{
				Grant_Total += rs.getInt(5);
				System.out.println(rs.getInt(1)+"\t\t\t"+rs.getInt(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getInt(5));
				
			}
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Grand Total Amount : "+Grant_Total);
			System.out.println("--------------------------------------------------------------------------");
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public int generateOrderId()
	{
		Random random = new Random();
		int orderNumber = random.nextInt(999999);
		
		return orderNumber;
	}

}
