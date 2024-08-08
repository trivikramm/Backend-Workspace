package com.tl.jdbc1;
import java.sql.*;
public class jdbctest {
    public static void main(String[] args)throws SQLException {
    	Connection mycon = null;
    	Statement myst = null;
    	ResultSet myres = null;
    	
    	try {
    		mycon = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","vikram","vikram");
    		System.out.println("Database Connection Successful!\n");
    	    myst = mycon.createStatement();
    	    //myst.executeUpdate("insert into employees"+"(id,last_name, first_name, email, department, salary)"+"values"+"(13,'A N','Shreelakshmi','shreelakshmi@gmail.com','CSE',70000.00)");
    	    //myst.executeUpdate("UPDATE employees SET email='trivikram@gmail.com' WHERE last_name='A N' AND first_name='Shreelakshmi'");
    	    myst.executeUpdate("delete from employees where last_name='Adams' and first_name='Carl'");
    	    myres = myst.executeQuery("select * from employees order by last_name");
    	    while(myres.next()) {
    	    	System.out.println(myres.getString("last_name")+", "+myres.getString("first_name"));
    	}
    	}
    	catch(Exception exc) {
    		exc.printStackTrace();
    	}
    	finally {
    		if (myres!=null){
    			myres.close();    		}
    	    }
    	    if (mycon!=null) {
    	    	mycon.close();
    	    }
    	    if (myst!=null) {
    	    	myst.close();
    	    }}

	private static void displayEmployee(Connection mycon, String string, String string2) {
		// TODO Auto-generated method stub
		
	}	
}