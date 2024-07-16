
public class Saving extends Account{
	Saving(){
		
	}
	Saving(int newID, double newBalance){
		super.setId(newID);
		super.setBalance(newBalance);
	}
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
		return "Account type Savings \n Id: " + super.getId() +"\nBalance: " + super.getBalance() + "\nMonthly Interest Rate: " + getMonthlyInterestRates() ;
	}
}
