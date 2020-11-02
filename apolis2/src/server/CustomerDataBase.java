package server;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class CustomerDataBase {
	private int row_count ;
	private Connection connect;
	private java.sql.Statement myStmt;
	private ResultSet myRs;
	private ResultSetMetaData rsmd;
	private  PreparedStatement pstmt;
    public CustomerDataBase(){
    	try {
        	//Get a Connection
        	connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/aw","root", "19931127Shi@");
        	//create a statement
        	myStmt = connect.createStatement();
        	//execute an SQL query
        	myRs=  myStmt.executeQuery("select * from BankCustomer");
        	row_count=myRs.getRow()+1;
        	rsmd = (ResultSetMetaData) myRs.getMetaData();
        	while(myRs.next()) {
        		System.out.println(myRs.getString("FirstName")+","+myRs.getString("Salary"));
        	}
        }
        catch(Exception e) {
        	System.out.println("Connection fails");
        }
	}
    public int getrowCount() {
    	try {
    		
    		myRs=  myStmt.executeQuery("select count(*) from BankCustomer");
    		while(myRs.next()) {
    			row_count =(int)myRs.getInt("CustomerKey");
    		}
    		//connect.close();
    	}
    	catch(Exception e) {
    		return 2;
    	}
    	return row_count+1;
    }
    public void setInfo(PersonalInfo pi) {
    	String message = "set failed";
    	try {
    		String sql = "INSERT INTO BankCustomer"+ " VALUES(?,?,?,?,?,?,?,?,?,?)";
    		pstmt=  connect.prepareStatement(sql);
    		pstmt.setInt(1, row_count);
    		pstmt.setString(2, pi.getFirstName());
    		pstmt.setString(3, pi.getMiddleName());
    		pstmt.setString(4, pi.getLastName());
    		pstmt.setString(5, pi.getIdentity());
    		pstmt.setString(6,String.valueOf(pi.getGender()));
    		pstmt.setInt(7, pi.getAge());
    		pstmt.setInt(8, pi.getSalary());
    		pstmt.setString(9, pi.getEmail());
    		pstmt.setString(10, pi.getPhone());
    		pstmt.executeUpdate();
    		message = "set completetd";
    		//connect.close();
    	}
    	catch(Exception e) {
    		System.out.println(message);
    	}
    	row_count++;
    }
    public int getCustomerKey(String email) {
    	int id = -1;
    	try {
    		myRs=  myStmt.executeQuery("select CustomerKey from BankCustomer where EmailAddress = '"+email+"'");
    		while(myRs.next()) {
    			id=(int)myRs.getInt("MinimumBalance");
    		}
    	}
    	catch(Exception e) {
    		System.out.println("email not exist");
    	}
    	return id;
    }
}
