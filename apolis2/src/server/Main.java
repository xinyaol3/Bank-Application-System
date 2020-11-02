package server;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		CustomerDataBase db = new CustomerDataBase();
		PersonalInfo ps = new PersonalInfo();
		Registration rg = new Registration();
		ps.setFirstName("Xinyao");
		ps.setMiddleName("");
		ps.setLastName("Li");
		ps.setIdentity("61661313");
		ps.setAge(26);
		ps.setSalary(5000);
		ps.setEmail("li651854292@gmail.com");
		ps.setPhone("9496561732");
		ps.setGender('M');
		db.setInfo(ps);
		rg.setInfo(db, "xinyaoli", "19931127li");
		AccountDataBase cd = new CheckingAccountDataBase();
	    AccountDataBase sd = new SavingAccountDataBase();
		AccRecord ars = new AccRecord("1211415");
		AccRecord arc = new AccRecord("1817162");
		Bank sa = new SavingAcc("1211415",ps,sd,ars);
		Bank ch = new CheckingAcc("1817162",ps,cd,arc);
		sa.setAcc(1000);
		ch.setAcc(1000);
		sa.setAvailableBal(10000);
		ch.setAvailableBal(10000);
		//System.out.println(db.getrowCount());
		cd.setAccInfo(ch,db);
		sd.setAccInfo(sa, db);
		//sd.updateAvailableBal(1000,"1211415");
		sa.deposite(10000);
		sa.withdraw(200);
		ch.deposite(15000);
		ch.withdraw(300);
		//System.out.println(cd.containsAccountNumber("1817162"));
		sa.transferFund(sd, ch.getAccountNumber(), 500);
		//System.out.println(rg.getEmail(db));
		rg.updateUsername("xinyaoli","19931127li","xinyaol3", "li651854292@gmail.com");
		rg.updatePassword("xinyaol3","19931127li","19931127Li","li651854292@gmail.com");
		//System.out.println(db.getrowCount());
		sa.getStatement(sa.getAccountNumber());
	}
}
