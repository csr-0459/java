package com.Shopping.XYZ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Shopping.XYZ.util.DataBaseConnection;

public class Login {
	
	private Connection con = null;
	private PreparedStatement ps = null;
	public final static String INSERT_DETAILS = " insert into login values(?,?,?,?,?,?,?)";
	public final static String VAL = "SELECT * FROM login WHERE username = ? AND password = ?";
	public void insertDetails(String fn,String email,String gender,String userName,String dob,String password,long mobile_no)
	{
		try
		{
			con = DataBaseConnection.getDataBaseConnection();
			ps = con.prepareStatement(INSERT_DETAILS);
			
			ps.setString(1, fn);
			ps.setString(2, email);
			ps.setString(3, gender);
			ps.setString(4, userName);
			ps.setString(5, dob);
			ps.setString(6, password);
			ps.setLong(7, mobile_no);
			ps.executeUpdate();
			System.out.println("Registration Successful!");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean Validation(String un,String pas)
	{
	    try
	    {
	        con = DataBaseConnection.getDataBaseConnection();
	        ps = con.prepareStatement(VAL);
	        ps.setString(1, un);
	        ps.setString(2, pas);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            return true;   // login success
	        } else {
	            return false;  // login failed
	        }
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    return false;
	}

	
	
	

}
