package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class CheckingAccountDataBase extends AccountDataBase {
	private int row_count ;
	private Connection connect;
	private java.sql.Statement myStmt;
	private ResultSet myRs;
	private ResultSetMetaData rsmd;
	private  PreparedStatement pstmt;
	public CheckingAccountDataBase(){
    	try {
        	//Get a Connection
        	connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/aw","root", "19931127Shi@");
        	//create a statement
        	myStmt = connect.createStatement();
        	//execute an SQL query
        	myRs=  myStmt.executeQuery("select * from CheckingAccount");
        	rsmd = (ResultSetMetaData) myRs.getMetaData();
        	while(myRs.next()) {
        		System.out.println(myRs.getString("AccountNumber")+","+myRs.getInt("AvailableBal"));
        	}
        }
        catch(Exception e) {
        	System.out.println("Connection fails");
        }
	}
    public int getrowCount() {
    	return row_count;
    }
    public void setAccInfo(Bank che,CustomerDataBase cd) {
    	String message = "set failed";
    	try {
    		String sql = "INSERT INTO CheckingAccount"+ " VALUES(?,?,?,?)";
    		pstmt=  connect.prepareStatement(sql);
    		pstmt.setInt(1, cd.getrowCount()-1);
    		pstmt.setString(2, che.getAccountNumber());
    		pstmt.setInt(3, che.getAvailableBal());
    		pstmt.setInt(4, che.getMinimumBalance());
    		pstmt.executeUpdate();
    		message = "set completed";
    		//connect.close();
    	}
    	catch(Exception e) {
    		System.out.println(message);
    	}
    	row_count++;
    }
    public int getAvailableBal(String AccountNumber) {
    	int balance = 0;
    	String message = "get failed";
    	try {
    		myRs=  myStmt.executeQuery("select AvailableBal from CheckingAccount where AccountNumber = "+AccountNumber);
    		while(myRs.next()) {
    			balance=(int)myRs.getInt("AvailableBal");
    		}
    	
    		message = "get completed";
    		//connect.close();
    	}
    	catch(Exception e) {
    		System.out.println(message);
    	}
    	return balance;
    }
    public int getMinimumBalance(String AccountNumber) {
    	int balance = 0;
    	String message = "get failed";
    	try {
    		myRs=  myStmt.executeQuery("select MinimumBalance from CheckingAccount where AccountNumber = "+AccountNumber);
    		while(myRs.next()) {
    			balance=(int)myRs.getInt("MinimumBalance");
    		}
    	
    		message = "get completed";
    		//connect.close();
    	}
    	catch(Exception e) {
    		System.out.println(message);
    	}
    	return balance;
    }
    public void updateAvailableBal(int balance,String AccountNumber) {
    	String message = "update failed";
    	try {
        	String sql = "UPDATE CheckingAccount "+"SET AvailableBal = ? where AccountNumber = ?";
        	pstmt =  connect.prepareStatement(sql);
        	pstmt.setInt(1, balance);
        	pstmt.setString(2, AccountNumber);
        	pstmt.executeUpdate();
        	message = "update completed";
        	//connect.close();
        	}
        catch(Exception e) {
        	System.out.println(message);
        }
    }
    public void updateMinBal(int balance,String AccountNumber) {
    	String message = "update failed";
    	try {
        	String sql = "UPDATE CheckingAccount "+"SET MinimumBalance = ? where AccountNumber = ?";
        	pstmt =  connect.prepareStatement(sql);
        	pstmt.setInt(1, balance);
        	pstmt.setString(2, AccountNumber);
        	pstmt.executeUpdate();
        	message = "update completed";
        	//connect.close();
        	}
        catch(Exception e) {
        	System.out.println(message);
        }
    }
    public boolean containsAccountNumber(String AccountNumber) {
    	String id = "";
    	String message = "get failed";
    	try {
    		myRs=  myStmt.executeQuery("select * from CheckingAccount where AccountNumber = "+AccountNumber);
    		while(myRs.next()) {
    			id=myRs.getString("AccountNumber");
    		}
    	
    		message = "get completed";
    		//connect.close();
    	}
    	catch(Exception e) {
    		System.out.println(message);
    	}
    	return !id.equals("");
    }
}
