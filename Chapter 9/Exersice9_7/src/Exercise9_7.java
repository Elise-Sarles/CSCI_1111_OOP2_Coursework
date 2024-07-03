
public class Exercise9_7 {
	
	public static void main(String[] args) {
		Account A1122 = new Account(1122, 20000);
		A1122.setAnnualInterestRate(4.5);
		System.out.println("Welcome Account Number " + A1122.getId());
		System.out.println("Your blance is $" + A1122.getBalance());
		System.out.println("Withdraw in process");
		A1122.withdraw(2500);
		System.out.println("Withdraw in Complete");
		System.out.println("New Balnce is $" + A1122.getBalance());
		
		System.out.println("Deposit in process");
		A1122.deposit(3000);
		System.out.println("Deposit in Complete");
		System.out.println("New Balnce is $" + A1122.getBalance());
	
	}
	
}
