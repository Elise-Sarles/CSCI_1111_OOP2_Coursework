package application;

public class Savings extends Account{

	Savings(){
		
	}
	Savings(int newID, double newBalance){
		super.setaccountnumber(newID);
		super.setBalance(newBalance);
	}
	@Override
	void withdraw(double withdraw) {
		if (super.getBalance() - withdraw > 0 ) {
			super.withdraw(withdraw);
		}
		else {
			System.out.println("Not enough Funds to withdraw");
		}
	}
	public String accounttype() {
		return "Saving account";
	}
	public String toString(){
		return "Account type Savings \n Id: " + super.getAccountnumber() +"\nBalance: " + super.getBalance() + "\nMonthly Interest Rate: " + getMonthlyInterestRates() ;
	}
	
	void addHistory(String add){
		super.addHistory(add);
	}
	String getHistory() {
		return  super.getHistory();
	}
}
