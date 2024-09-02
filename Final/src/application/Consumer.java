package application;

import java.util.Date;

public class Consumer {
	Checking c = new Checking();
	boolean hasChecking = false;
	Savings s = new Savings();
	boolean hasSavings = false;
	private int Id = 0;
	private String password = "password";
	
	Consumer(){
		
	}
	Consumer(boolean hc, boolean hs){
		hasChecking = hc;
		hasSavings = hs;
	}
	Consumer(int id, String newpassword, boolean hc, boolean hs){
		Id = id;
		password = newpassword;
		hasChecking = hc;
		hasSavings = hs;
		
	}
	Consumer(int id, String newpassword, boolean hc,int chaccount, double chBalance, boolean hs, int savingaccount, double sabalance){
		Id = id;
		password = newpassword;
		hasChecking = hc;
		if(hasChecking == true) {
			c.setaccountnumber(chaccount);
			c.setBalance(chBalance);
		}
		hasSavings = hs;
		if(hasSavings == true) {
			s.setaccountnumber(savingaccount);
			s.setBalance(sabalance);
		}
		
	}
	Consumer(int id, String newpassword, boolean hc,int chaccount, double chBalance, boolean hs, int savingaccount, double sabalance, Date hcreated, Date screated, double hinterest, double sinterest){
		Id = id;
		password = newpassword;
		hasChecking = hc;
		if(hasChecking == true) {
			c.setaccountnumber(chaccount);
			c.setBalance(chBalance);
			c.setdateCreated(hcreated);
			c.setAnnualInterestRate(hinterest);
		}
		hasSavings = hs;
		if(hasSavings == true) {
			s.setaccountnumber(savingaccount);
			s.setBalance(sabalance);
			s.setdateCreated(screated);
			s.setAnnualInterestRate(sinterest);
		}
		
	}
	Consumer(int id, String newpassword, boolean hc,int chaccount, double chBalance, boolean hs, int savingaccount, double sabalance, Date hcreated, Date screated, double hinterest, double sinterest, String chistory, String shistory){
		Id = id;
		password = newpassword;
		hasChecking = hc;
		if(hasChecking == true) {
			c.setaccountnumber(chaccount);
			c.setBalance(chBalance);
			c.setdateCreated(hcreated);
			c.setAnnualInterestRate(hinterest);
			c.setHistory(chistory);
		}
		hasSavings = hs;
		if(hasSavings == true) {
			s.setaccountnumber(savingaccount);
			s.setBalance(sabalance);
			s.setdateCreated(screated);
			s.setAnnualInterestRate(sinterest);
			s.setHistory(shistory);
		}
		
	}
	
	void openchecking(int accountnumber, double balance) {
		if(hasChecking == false) {
		hasChecking = true;
		c.setaccountnumber(accountnumber);
		c.setBalance(balance);
		}
		else {
			System.out.println("Already has a Checking account");
		}
	}
	void opensavings(int accountnumber, double balance) {
		if(hasSavings == false) {
		hasSavings = true;
		s.setaccountnumber(accountnumber);
		s.setBalance(balance);
		}
		else {
			System.out.println("Already has a Savings account");
		}
	}
	
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
	
	boolean hasChecking() {
		return hasChecking;
	}
	
	boolean hasSavings() {
		return hasSavings;
	}
	int getAccountnumber(int type){
		if(type == 1) {
			return c.getAccountnumber();
		}
		else {
			return s.getAccountnumber();
		}
	}
	
	void setaccountnumber(int number, int type){
		if(type == 1) {
			c.setaccountnumber(number);
		}
		else {
			s.setaccountnumber(number);
		}
	}
	
	double getBalance(int type){
		if(type == 1) {
			return c.getBalance();
		}
		else {
			return s.getBalance();
		}
	
	}
	
	void setBalance(double newBalance, int type){
		if(type == 1) {
			c.setBalance(newBalance);
		}
		else {
			s.setBalance(newBalance);
		}
	
	}
	
	double getAnnualInterestRate(int type){
		if(type == 1) {
			return c.getAnnualInterestRate();
		}
		else {
			return s.getAnnualInterestRate();
		}
		
	}
	
	void setAnnualInterestRate(Double newrates, int type){
		if(type == 1) {
			c.setAnnualInterestRate(newrates);
		}
		else {
			s.setAnnualInterestRate(newrates);
		}
		
	}
	double getOverDraftLimit(int type){
		if(type == 1) {
			return c.getOverDraftLimit();
		}else {
			System.out.println("Savings account do not have an overdraft");
			return 0.0;
		}
	}
	
	Date getDateCreated(int type){
		if(type == 1) {
			return c.getDateCreated();
		}
		else {
			return s.getDateCreated();
		}
	}
	void setdateCreated(Date date, int type) {
		if(type == 1) {
		c.setdateCreated(date);
		}
		else {
		s.setdateCreated(date);
		}
	}
	double getMonthlyInterestRates(int type){
		if(type == 1) {
			return c.getMonthlyInterestRates();
		}
		else {
			return s.getMonthlyInterestRates();
		}
	}
	
	double getMonthlyInterest(int type){
		if(type == 1) {
			return c.getMonthlyInterest();
		}
		else {
			return s.getMonthlyInterest();
		}
	}

	void withdraw(double withdraw, int type){
		if(type == 1) {
			c.withdraw(withdraw);
		}
		else {
			s.withdraw(withdraw);
		}
	}

	void deposit(double deposit, int type){
		if(type == 1) {
			c.deposit(deposit);
		}
		else {
			s.deposit(deposit);
		}
	}
	
	void addmonthlyInterest(int type){
		if(type == 1) {
			c.addmonthlyInterest();
		}
		else {
			s.addmonthlyInterest();
		}
	}
	String accountinfo(int type){
		if(type == 1) {
			return c.toString();
		}
		else {
			return s.toString();
		}
	}
	
	void addHistory(String add, int type){
		
		if(type == 1) {
			c.addHistory(add);
		}
		else {
			s.addHistory(add);
		}
	}
	String getHistory(int type) {
		if(type == 1) {
			return c.getHistory();
		}
		else {
			return s.getHistory();
		}
	}
}
