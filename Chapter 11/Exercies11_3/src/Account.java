import java.util.Date;

public class Account {

	private int Id = 0;
	
	private double Balance = 0;
	
	private double AnnualIntrestRate = 0;
	
	private Date dateCreated;
	
	private String password = "password" ;
	
	///// Creating account
	Account(){
		dateCreated = new Date();
	}
	////// Creating an account with information. 
	Account(int newID, double newBlance){
		Id = newID;
		Balance = newBlance;
		dateCreated = new Date();
	}
	///Fetching ID
	int getId(){
		return Id;
		
	}
	////Changing ID
	void setId(int newid){
		Id = newid;
		
	}
	///Fetching password
	String getpassword(){
		return password;
	}
	/////Changing passwords
	void setpassword(String newpassword) {
		password = newpassword;
	}
	//// Fetching balance
	double getBalance() {
		return Balance;
	}
	////Changing Balance
	void setBalance(double newBalance){
		Balance = newBalance;
		
	}
	///// Fetching AnnualInterestRates
	double getAnnualInterestRate() {
		return AnnualIntrestRate;
	}
	////Changing AnnualIntrestRates
	void setAnnualInterestRate(Double newrates){
		AnnualIntrestRate = newrates;
		
	}
	////Fetching Date Created
	Date getDateCreated(){
		return dateCreated;
	}
	////Fetching monthly interest Rates
	double getMonthlyInterestRates() {
		return AnnualIntrestRate/12;
	}
	//// Fetching Monthly interest
	double getMonthlyInterest() {
		return Balance * ((AnnualIntrestRate/12)/100);
	}
	///// removing money from account 
	void withdraw(double withdraw) {
		
		Balance = Balance - withdraw;
	}
	//// Adding money to account
	void deposit(double deposit) {
		
		Balance = Balance + deposit;
	}
	/// Adding the Interest to the balance of the account
	void addmonthlyInterest() {
		Balance = Balance + this.getMonthlyInterest();
	}
	///Seeing if an id is a valid one
	
		
}