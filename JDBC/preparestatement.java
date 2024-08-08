package com.tl.jdbc1;

import java.sql.*;

public class preparestatement {
    public static void main(String[] args) throws SQLException{
    	Connection mycon=null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	try{
    		mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","vikram","vikram");
   
    	    ps = mycon.prepareStatement("select * from employees where salary>? and department=?");
    	    ps.setDouble(1, 25000);
			ps.setString(2, "HR");

    	    rs = ps.executeQuery();
    	    while(rs.next()) {
    	    	System.out.println(rs.getString("last_name")+", "+rs.getString("first_name"));
    	}
    	}
    	catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (rs != null) {
				rs.close();
			}
			
			if (ps != null) {
				ps.close();
			}
			
			if (mycon != null) {
				mycon.close();
			}}
    	
    	
    }
}