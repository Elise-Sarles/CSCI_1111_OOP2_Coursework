///// Elise Sarles July 3 2024 
public class Exercise9_7 {
	
	public static void main(String[] args) {
		////Creating Account 
		Account A1122 = new Account(1122, 20000);
		A1122.setAnnualInterestRate(4.5);
		///Outputing info about account
		System.out.println("Welcome Account Number " + A1122.getId());
		System.out.println("Your blance is $" + A1122.getBalance());
		///causing withdraw and informing user of the process
		System.out.println("Withdraw in process");
		A1122.withdraw(2500);
		System.out.println("Withdraw Complete");
		System.out.println("New Balnce is $" + A1122.getBalance());
		///Causing deposit and informing user of the process
		System.out.println("Deposit in process");
		A1122.deposit(3000);
		System.out.println("Deposit Complete");
		System.out.println("New Balnce is $" + A1122.getBalance());
		////displaying more info about the account
		System.out.println("Monthly interest is $" + A1122.getMonthlyInterest());
		System.out.println("Account activated " + A1122.getDateCreated());
	
	}
	
}
