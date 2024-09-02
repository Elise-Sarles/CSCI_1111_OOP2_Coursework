package application;

public class Checking extends Account{
	double overdraftlimit = -500;
	Checking(){
		
	}
	Checking(int newID, double newBalance){
		super.setaccountnumber(newID);
		super.setBalance(newBalance);
		
	}
	Checking(int newID, double newBalance, double limit){
		super.setaccountnumber(newID);
		super.setBalance(newBalance);
		overdraftlimit = limit;
		
	}
	public double getOverDraftLimit() {
		return overdraftlimit;
	}
	public void setOverDraftLimit(double amount) {
		overdraftlimit = amount;
	}
	
	@Override
	public void withdraw(double withdraw) {
		if (super.getBalance() - withdraw > overdraftlimit) {
			super.withdraw(withdraw);
		}
		else {
			System.out.println("Not enough Funds to withdraw");
		}
	}
	public String accounttype() {
		return "Checking account";
	}
	
	public String toString(){
		return "Account type Checking \n Id: " + super.getAccountnumber() +"\nBalance: " + super.getBalance() + "\nMonthly Interest Rate: " + super.getMonthlyInterestRates() + "\n OverDraftLimit" + overdraftlimit;
	}
	void addHistory(String add){
		super.addHistory(add);
	}
	String getHistory() {
		return super.getHistory();
	}
}
