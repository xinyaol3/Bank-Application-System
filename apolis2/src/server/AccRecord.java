package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class AccRecord {
	private int row_count ;
	private Connection connect;
	private java.sql.Statement myStmt;
	private ResultSet myRs;
	private ResultSetMetaData rsmd;
	private  PreparedStatement pstmt;
	private String AccountNumber;
	private AccountDataBase db;
	public AccRecord(String AccountNumber){
		this.AccountNumber=AccountNumber;
    	try {
        	//Get a Connection
        	connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/aw","root", "19931127Shi@");
        	//create a statement
        	myStmt = connect.createStatement();
        	//execute an SQL query
        }
        catch(Exception e) {
        	System.out.println("Connection fails");
        }
    	try {
    		String sql = "CREATE TABLE "+"Record_"+ AccountNumber+"(Income int NOT NULL,"
        			+ "Transfer int NOT NULL,TargetAccountNumber varchar(50) NULL,Date varchar(50) NOT NULL);";
        	pstmt = connect.prepareStatement(sql);
        	pstmt.executeUpdate();
    	}
    	catch(Exception e) {
    		System.out.println("existed");
    	}
	}
	public int getCustomerKey(String AccountNumber) {
		int id = -1;
			try {
				String sql = "select CustomerKey from SavingAccount where AccountNumber = '"+AccountNumber+"'";
				myRs=  myStmt.executeQuery(sql);
				while(myRs.next()) {
	        		id = myRs.getInt("CustomerKey");
	        	}
		    	//connect.close();
			}
			catch(Exception e) {
				System.out.println("Get failed");
			}
			try {
				String sql = "select CustomerKey from CheckingAccount where AccountNumber = '"+AccountNumber+"'";
				myRs=  myStmt.executeQuery(sql);
				while(myRs.next()) {
					int new_id = myRs.getInt("CustomerKey");
	        		id = Math.max(id, new_id);
	        	}
		    	//connect.close();
			}
			catch(Exception e) {
				System.out.println("Get failed");
			}
		return id;
	}
	public void transfer(String account1,String account2,int amount) {
		try {
	    	String sql = "INSERT INTO "+"Record_"+account1+ " VALUES(?,?,?,?)";
	    	String date = ""+java.time.LocalDate.now();
	    	pstmt=  connect.prepareStatement(sql);
	    	pstmt.setInt(1,-1*amount);
	    	pstmt.setInt(2,amount);
	    	pstmt.setString(3, account2);
	    	pstmt.setString(4, date);
	    	pstmt.executeUpdate();
	    	//connect.close();
	    	}
	    catch(Exception e) {
	    	System.out.println("transfer failed");
	    }
		income(account2,amount);
		
	}
	public void income(String AccountNumber,int amount) {
		try {
	    	String sql = "INSERT INTO "+"Record_"+AccountNumber+ " VALUES(?,?,?,?)";
	    	String date = ""+java.time.LocalDate.now();
	    	pstmt=  connect.prepareStatement(sql);
	    	pstmt.setInt(1,amount);
	    	pstmt.setInt(2, 0);
	    	pstmt.setString(3,"");
	    	pstmt.setString(4, date);
	    	pstmt.executeUpdate();
	    	//connect.close();
	    	}
	    catch(Exception e) {
	    	System.out.println("set failed");
	    }
	}
	public void printRecord(String AccountNumber) {
		try {
			myRs=  myStmt.executeQuery("select * from "+"Record_"+AccountNumber);
			System.out.println("AccountNumber: "+ AccountNumber+" Transcation");
			while(myRs.next()) {
        		System.out.println("Income:"+myRs.getInt("Income")+", Transfer: "+myRs.getInt("Transfer")
        		+", TargetAccountNumber: "+myRs.getString("TargetAccountNumber")+", Date: "+myRs.getString("Date"));
        	}
		}
		catch(Exception e) {
			System.out.println("Error,can't not load the record this time. Maybe come back to check again");
		}
	}
}
