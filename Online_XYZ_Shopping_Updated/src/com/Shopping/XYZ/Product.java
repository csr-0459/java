package com.Shopping.XYZ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Shopping.XYZ.dto.ProductDto;
import com.Shopping.XYZ.util.DataBaseConnection;

public class Product {
	
	private Connection con = null;
	private static final String SELECT_ALL_PRODUCT="SELECT * FROM PRODUCT";
	private static final String SELECT_BY_ID_QUERY="select * from product where PRODUCT_ID = ?";
	private static final String UPDATE_TABLE_PRODUCT = "update product set stock = stock - ? where product_id = ?";
	
	public void getAllProducts()
	{
		
		try
		{
			con = DataBaseConnection.getDataBaseConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_ALL_PRODUCT);
			ResultSet rs = ps.executeQuery();
			
			System.out.println("------------------------------------------------");
			System.out.println("PRODUCT_ID\tPRODUCT_NAME\tSTOCK\tPRICE");
			System.out.println("------------------------------------------------");
			
			
			while(rs.next())
			{
				int pid = rs.getInt(1), stock = rs.getInt(3);
				String product=rs.getString(2);
				double price = rs.getDouble(4);
				System.out.println(pid+"\t\t"+product+"\t"+stock+"\t"+price);
			}
			con.close();
		} 
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void updateProduct(int pid,int stock)
	{
		try
		{
			con = DataBaseConnection.getDataBaseConnection();
			PreparedStatement ps = con.prepareStatement(UPDATE_TABLE_PRODUCT);
			ps.setInt(1, stock);
			ps.setInt(2,pid);
			ps.executeUpdate();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ProductDto getProductById(int productId)
	{
		ProductDto dto = new ProductDto();
		
		try
		{
			con = DataBaseConnection.getDataBaseConnection();
			PreparedStatement ps = con.prepareStatement(SELECT_BY_ID_QUERY);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				dto.productId = rs.getInt(1);
				dto.productName = rs.getString(2);
				dto.stock = rs.getInt(3);
				dto.price = rs.getDouble(4);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return dto;
		
	}
	
	

}
