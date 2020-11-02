package server;

public abstract class AccountDataBase {
    public void setAccInfo(Bank che,CustomerDataBase cd) {}
    public int getAvailableBal(String AccountNumber) {
    	return 0;
    }
    public int getMinimumBalance(String AccountNumber) {
    	return 0;
    }
    public void updateAvailableBal(int balance,String AccountNumber) {}
    public void updateMinBal(int balance,String AccountNumber) {}
    public boolean containsAccountNumber(String AccountNumber) {
         return false;
    }
}
