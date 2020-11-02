package server;

public class SavingAcc extends Bank {
    private PersonalInfo pi;
    private String accountNumber;
    private int availableBal;
    private int minbal;
    private AccountDataBase sa;
    private AccRecord sr;
    public SavingAcc(String accountNumber,PersonalInfo pi,AccountDataBase sa,AccRecord sr) {
    	this.accountNumber = accountNumber;
    	this.pi = pi;
    	this.sa = sa;
    	this.sr = sr;
    }
    public void setAcc(int minbal) {
		if(pi.getAge() > 18 && pi.getSalary() == 0) {
			this.minbal = 1000;
		}
		this.minbal = minbal;
		sa.updateMinBal(this.minbal, getAccountNumber());
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
    	sr.income(getAccountNumber(), this.availableBal);
    }
    public int getAvailableBal() {
    	return availableBal;
    }
    public void deposite(int amount) {
    	this.availableBal+=amount;
    	sa.updateAvailableBal(this.availableBal,getAccountNumber());
        sr.income(getAccountNumber(), amount);
    }
    public void withdraw(int amount) {
    	if(amount<=this.minbal&&amount<=this.availableBal) {
    		this.availableBal-=amount;
    		sa.updateAvailableBal(this.availableBal,getAccountNumber());
    		sr.income(getAccountNumber(),-1*amount);
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
    			sr.transfer(getAccountNumber(), targetAccount, amount);
    			sr.income(targetAccount, amount);
    		}
    		else if(sav.containsAccountNumber(targetAccount)) {
    			sav.updateAvailableBal(sav.getAvailableBal(targetAccount)+amount,targetAccount);
    			sr.transfer(getAccountNumber(), targetAccount, amount);
    			sr.income(targetAccount, amount);
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
    	sr.printRecord(AccountNumber);
    }
}
