package server;

public abstract class Bank{
	private PersonalInfo pi;
	private String accountNumber;
	private int availableBal;
	private int minbal;
	public void setAcc(int minbal) {
		this.minbal= minbal;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber=accountNumber;
	}
	public String getAccountNumber() {
    	return accountNumber;
    }
	public int getMinimumBalance() {
    	return minbal;
    }
	public void setAvailableBal(int availableBal) {
		this.availableBal=availableBal;
	}
	public int getAvailableBal() {
		return availableBal;
	}
	public void deposite(int amount) {
		this.availableBal+=amount;
	}
	public void withdraw(int amount) {
		this.availableBal-=amount;
	}
	public void transferFund(AccountDataBase acc1, String targetAccount, int amount) {}
	public void getStatement(String AccountNumber) {};
}

