package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class SavingAccountDataBase extends AccountDataBase {
	private int row_count ;
	private Connection connect;
	private java.sql.Statement myStmt;
	private ResultSet myRs;
	private ResultSetMetaData rsmd;
	private  PreparedStatement pstmt;
	public SavingAccountDataBase(){
    	try {
        	//Get a Connection
        	connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/aw","root", "19931127Shi@");
        	//create a statement
        	myStmt = connect.createStatement();
        	//execute an SQL query
        	myRs=  myStmt.executeQuery("select * from SavingAccount");
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
    public void setAccInfo(Bank sav,CustomerDataBase cd) {
    	String message = "set failed";
    	try {
    		String sql = "INSERT INTO SavingAccount"+ " VALUES(?,?,?,?)";
    		pstmt=  connect.prepareStatement(sql);
    		pstmt.setInt(1, cd.getrowCount()-1);
    		pstmt.setString(2, sav.getAccountNumber());
    		pstmt.setInt(3, sav.getAvailableBal());
    		pstmt.setInt(4, sav.getMinimumBalance());
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
    		myRs=  myStmt.executeQuery("select AvailableBal from SavingAccount where AccountNumber = "+AccountNumber);
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
    		myRs=  myStmt.executeQuery("select MinimumBalance from SavingAccount where AccountNumber = "+AccountNumber);
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
        	String sql = "UPDATE SavingAccount "+"SET AvailableBal = ? where AccountNumber = ?";
        	pstmt =  connect.prepareStatement(sql);
        	pstmt.setInt(1, balance);
        	pstmt.setString(2, AccountNumber);
        	pstmt.executeUpdate();
        	message = "update completetd";
        	//connect.close();
        	}
        catch(Exception e) {
        	System.out.println(message);
        }
    }
    public void updateMinBal(int balance,String AccountNumber) {
    	String message = "updated failed";
    	try {
        	String sql = "UPDATE SavingAccount "+"SET MinimumBalance = ? where AccountNumber = ?";
        	pstmt =  connect.prepareStatement(sql);
        	pstmt.setInt(1, balance);
        	pstmt.setString(2, AccountNumber);
        	pstmt.executeUpdate();
        	message = "update completetd";
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
    		myRs=  myStmt.executeQuery("select * from SavingAccount where AccountNumber = "+AccountNumber);
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
