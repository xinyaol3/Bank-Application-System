package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

 public class Registration {
	 private Connection connect;
	 private java.sql.Statement myStmt;
	 private ResultSet myRs;
	 private ResultSetMetaData rsmd;
	 private  PreparedStatement pstmt;
	 public Registration(){
	    try {
	        //Get a Connection
	        connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/aw","root", "19931127Shi@");
	        //create a statement
	        myStmt = connect.createStatement();
	        //execute an SQL query
	        myRs=  myStmt.executeQuery("select * from Registration");
	        rsmd = (ResultSetMetaData) myRs.getMetaData();
	        while(myRs.next()) {
	        	System.out.println(myRs.getString("username")+","+myRs.getString("passcode"));
	        }
	     }
	     catch(Exception e) {
	        System.out.println("Connection fails");
	     }
	 }
	 public int getCustomerKey(CustomerDataBase cdb) {
		 return cdb.getrowCount()-1;
	 }
	 public void setInfo(CustomerDataBase cdb,String username,String password) {
		 String message = "set failed";
	    	try {
	    		String sql = "INSERT INTO Registration"+ " VALUES(?,?,?)";
	    		pstmt=  connect.prepareStatement(sql);
	    		pstmt.setInt(1, getCustomerKey(cdb));
	    		pstmt.setString(2, username);
	    		pstmt.setString(3, password);
	    		pstmt.executeUpdate();
	    		message = "set completetd";
	    		//connect.close();
	    	}
	    	catch(Exception e) {
	    		System.out.println(message);
	    	}
	 }
	 public void updateUsername(String oldusername,String password,String username,String email) {
		 	String message = "update failed";
		 	int id = -1;
		 	try {
	    		myRs=  myStmt.executeQuery("select CustomerKey from BankCustomer where EmailAddress = '"+email+"'");
	    		while(myRs.next()) {
	    			id =(int)myRs.getInt("CustomerKey");
	    		}
	    		//connect.close();
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
		 	String old_username = "";
		 	String offical_password = "";
		 	try {
		 		myRs = myStmt.executeQuery("select username from Registration where CustomerKey ="+id);
		 		while(myRs.next()) {
		 			old_username = myRs.getString("username");
		 		}
		 	}
		 	catch(Exception e) {
		 		e.printStackTrace();
		 	}
		 	try {
		 		myRs = myStmt.executeQuery("select passcode from Registration where CustomerKey ="+id);
		 		while(myRs.next()) {
		 			offical_password = myRs.getString("passcode");
		 		}
		 	}
		 	catch(Exception e) {
		 		e.printStackTrace();
		 	}
		 	if(old_username.equals(oldusername)&&offical_password.equals(password)) {
		 		try {
		 			String sql = "UPDATE Registration "+"SET username = ? where CustomerKey = ?";
		 			pstmt =  connect.prepareStatement(sql);
		 			pstmt.setString(1, username);
		 			pstmt.setInt(2, id);
		 			pstmt.executeUpdate();
		 			message = "update completed";
		 			//connect.close();
		 			}
		 		catch(Exception e) {
		 			System.out.println(message);
		 		}
		 	}
		 	else {
		 		System.out.println("Invaild username or password");
		 	}
	 }
	 public void updatePassword(String oldusername, String oldpassword,String password,String email) {
		 	String message = "update failed";
		 	int id = -1;
		 	try {
	    		myRs=  myStmt.executeQuery("select CustomerKey from BankCustomer where EmailAddress = '"+email+"'");
	    		while(myRs.next()) {
	    			id =(int)myRs.getInt("CustomerKey");
	    		}
	    		//connect.close();
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
		 	String old_username = "";
		 	String offical_password = "";
		 	try {
		 		myRs = myStmt.executeQuery("select username from Registration where CustomerKey ="+id);
		 		while(myRs.next()) {
		 			old_username = myRs.getString("username");
		 		}
		 	}
		 	catch(Exception e) {
		 		e.printStackTrace();
		 	}
		 	try {
		 		myRs = myStmt.executeQuery("select passcode from Registration where CustomerKey ="+id);
		 		while(myRs.next()) {
		 			offical_password = myRs.getString("passcode");
		 		}
		 	}
		 	catch(Exception e) {
		 		e.printStackTrace();
		 	}
		 	if(old_username.equals(oldusername)&&offical_password.equals(oldpassword)) {
		 		try {
		 			String sql = "UPDATE Registration "+"SET passcode = ? where CustomerKey = ?";
		 			pstmt =  connect.prepareStatement(sql);
		 			pstmt.setString(1, password);
		 			pstmt.setInt(2, id);
		 			pstmt.executeUpdate();
		 			message = "update completed";
		 			//connect.close();
		 		}
		 		catch(Exception e) {
		 			System.out.println(message);
		 		}
		 	}
	 }
	 public boolean passwordCorrectness(String username,String password) {
		 String offical_password = "";
		 	try {
		 		myRs = myStmt.executeQuery("select passcode from Registration where username ='"+username+"'");
		 		while(myRs.next()) {
		 			offical_password = myRs.getString("passcode");
		 		}
		 	}
		 	catch(Exception e) {
		 		e.printStackTrace();
		 	}
		 	return password.equals(offical_password);
	 }
	 public boolean usernameExist(String username) {
		   int id = -1;
		 	try {
		 		myRs = myStmt.executeQuery("select CustomerKey from Registration where username ='"+username+"'");
		 		while(myRs.next()) {
		 			id= myRs.getInt("CustomerKey");
		 		}
		 	}
		 	catch(Exception e) {
		 		e.printStackTrace();
		 	}
		 	return id != -1;
	 }
	 public boolean emailExist(String email) {
		 int id = -1;
		 	try {
	    		myRs=  myStmt.executeQuery("select CustomerKey from BankCustomer where EmailAddress = '"+email+"'");
	    		while(myRs.next()) {
	    			id =(int)myRs.getInt("CustomerKey");
	    		}
	    		//connect.close();
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
		 	return id!=-1;
	 }
	 public String getPassword(String email) {
		 int id = -1;
		 	try {
	    		myRs=  myStmt.executeQuery("select CustomerKey from BankCustomer where EmailAddress = '"+email+"'");
	    		while(myRs.next()) {
	    			id =(int)myRs.getInt("CustomerKey");
	    		}
	    		//connect.close();
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}
		 	String offical_password = "";
		 	try {
		 		myRs = myStmt.executeQuery("select passcode from Registration where CustomerKey ="+id);
		 		while(myRs.next()) {
		 			offical_password = myRs.getString("passcode");
		 		}
		 	}
		 	catch(Exception e) {
		 		e.printStackTrace();
		 	}
		 	return offical_password;
	 }
}
