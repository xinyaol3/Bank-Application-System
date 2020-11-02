package server;

 public class CheckingAcc extends Bank {
	 private PersonalInfo pi;
	    private String accountNumber;
	    private int availableBal;
	    private int minbal;
	    private AccountDataBase ca;
	    private AccRecord cr;
	    public CheckingAcc(String accountNumber,PersonalInfo pi,AccountDataBase ca,AccRecord cr) {
	    	this.accountNumber = accountNumber;
	    	this.pi = pi;
	    	this.ca = ca;
	    	this.cr = cr;
	    }
	    public void setAcc(int minbal) {
			if(pi.getAge() > 18 && pi.getSalary() == 0) {
				this.minbal = 1000;
			}
			this.minbal = minbal;
			ca.updateMinBal(this.minbal, getAccountNumber());
	    }
	    public int getMinimumBalance() {
	    	return minbal;
	    }
	    public void setAccountNumber(String accountNumber) {
	    	this.accountNumber = accountNumber;
	    }
	    public String getAccountNumber() {
	    	return accountNumber;
	    }
	    public void setAvailableBal(int availableBal) {
	    	this.availableBal=availableBal;
	    	cr.income(getAccountNumber(), this.availableBal);
	    }
	    public int getAvailableBal() {
	    	return availableBal;
	    }
	    public void deposite(int amount) {
	    	this.availableBal+=amount;
	    	ca.updateAvailableBal(this.availableBal,getAccountNumber());
	        cr.income(getAccountNumber(), amount);
	    }
	    public void withdraw(int amount) {
	    	if(amount<=this.minbal&&amount<=this.availableBal) {
	    		this.availableBal-=amount;
	    		ca.updateAvailableBal(this.availableBal,getAccountNumber());
	    		cr.income(getAccountNumber(),-1*amount);
	    	}
	    	else {
	    		System.out.println("Sorry,this is out of your daily limitation");
	    	}
	    }
	    public void transferFund(AccountDataBase a,String targetAccount,int amount) {
	    	if(a.getAvailableBal(getAccountNumber())>=amount) {
	    		a.updateAvailableBal(a.getAvailableBal(getAccountNumber())-amount,getAccountNumber());
	    		AccountDataBase ch = new CheckingAccountDataBase();
	    		AccountDataBase sav= new SavingAccountDataBase();
	    		if(ch.containsAccountNumber(targetAccount)) {
	    			ch.updateAvailableBal(ch.getAvailableBal(targetAccount)+amount,targetAccount);
	    			cr.transfer(getAccountNumber(), targetAccount, amount);
	    			cr.income(targetAccount, amount);
	    		}
	    		else if(sav.containsAccountNumber(targetAccount)) {
	    			sav.updateAvailableBal(sav.getAvailableBal(targetAccount)+amount,targetAccount);
	    			cr.transfer(getAccountNumber(), targetAccount, amount);
	    			cr.income(targetAccount, amount);
	    		}
	    		else {
	    			System.out.println("Sorry, The account Number :"+targetAccount+" is not exist");
	    		}
	    	}
	    	else {
	    		System.out.println("Transfer failed, Maybe because your available balance is too low or transfer amount out of your daily limination,Please contact the Bank");
	    	}
	    }
	    public void getStatement(String AccountNumber) {
	    	cr.printRecord(AccountNumber);
	    }
}
