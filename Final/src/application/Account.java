package application;

import java.util.Date;

public class Account {
	
	private int accountnumber = 0;
	
	private double Balance = 0;
	
	private double AnnualIntrestRate = 0;
	
	private Date dateCreated;
	
	private String accountinfo = "History of actions:";
	
	
	
	///// Creating account
	Account(){
		dateCreated = new Date();
	}
	////// Creating an account with information. 
	Account(int newID, double newBlance){
		accountnumber = newID;
		Balance = newBlance;
		dateCreated = new Date();
	}
	
	Account(int newID, double newBlance, Date newdate){
		accountnumber = newID;
		Balance = newBlance;
		dateCreated = newdate;
	}
	///Fetching Account number
	int getAccountnumber(){
		return accountnumber;
		
	}
	////Changing Account number
	void setaccountnumber(int newid){
		accountnumber = newid;
		
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
	void setdateCreated(Date date) {
		dateCreated = date;
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
	void addHistory(String add){
		accountinfo = accountinfo + " " + add + "----";
	}
	void setHistory(String history){
		accountinfo = history;
	}
	String getHistory() {
		return accountinfo;
	}
}
