import java.util.Scanner;

public class Exercise11_3 {
	static Scanner numberinput = new Scanner(System.in);  /// the input scanner for number var
	static Scanner wordinput = new Scanner(System.in);  //// the input for text based var
	public static Checking[] caccounts = new Checking[25]; //// Account array to make them easier to handle.
	public static Saving[] saccounts = new Saving[25];
	static int a = 10;//// basic Id number for after the first 10.
	static int pa = 0; /// present account in use. 
	static boolean create; //// boolean for the creating an account here so I can set is true in a different part of the the code as well as when it is used. 
	static boolean logedin = false; //// to check if logged in.
	static boolean trylog = false; //// checks to see if you are trying to log in
	static boolean actype = false;
	public static void main(String[] args) {
		//// Creating base 10 accounts all their passwords are password.
		for (int n = 0; n <= 9; n++){
		caccounts[n] = new Checking(n, 100);
		}
		for (int n = 0; n <= 9; n++){
		saccounts[n] = new Saving(n, 100);
		}
		//// creating opening first interaction 
		 do{
			 System.out.println("Do you want to login or Create an Account? \nPlease type 1 for login or 2 for Create an account\n");
			 int answer = numberinput.nextInt();
			 //// if statement to work through the answers. else statement to deal with number based errors.
			 if(answer == 1) {
				 System.out.println(" Checkings[1] or Savings[2]?");
				 int an = numberinput.nextInt();
				 if(an == 1) {
					 logedin = false;
					 trylog = true;
					 actype = false;
					 clogin();
				 }
				 else if(an == 2) {
					 logedin = false;
					 trylog = true;
					 actype = true;
					 slogin(); 
				 }
				 else {
					 System.out.println("Please try again");
				 }
			 }
			 else if (answer == 2) {
				 System.out.println(" Checkings[1] or Savings[2]?");
				 int an = numberinput.nextInt();
				 if(an == 1) {
					 create = true;
					 actype = false;
					 checkcreateaccount(); 
				 }
				 else if(an == 2) {
					 create = true;
					 actype = true;
					 savingcreateaccount(); 
				 }
				 else {
					 System.out.println("Please try again");
				 }
				
			 }
			 else {
				 System.out.println("Sorry not an option please try again.\n");
			 }
			 
		 }while (true);
	}
	//// Creating an account. 
	public static void checkcreateaccount() {
		do{
			System.out.println("Your ID number is : " + a);
			System.out.println("Enter a Password: ");
			String password = wordinput.nextLine();
			System.out.println("Enter amount you would like to put into the account: ");
			double balance = numberinput.nextDouble();
			/// crating account based on next open slot is the array.
			caccounts[a] = new Checking(a,balance);
			caccounts[a].setpassword(password);
			System.out.println("Account created! \nYour Id is: " +caccounts[a].getId() + "\nYour Password is: " + caccounts[a].getpassword() + "\nYour balance is : " + caccounts[a].getBalance());
			System.out.println("Returning \n");
			a++;
			create = false;
		}while(create == true);
	}
	public static void savingcreateaccount() {
		do{
			System.out.println("Your ID number is : " + a);
			System.out.println("Enter a Password: ");
			String password = wordinput.nextLine();
			System.out.println("Enter amount you would like to put into the account: ");
			double balance = numberinput.nextDouble();
			/// crating account based on next open slot is the array.
			saccounts[a] = new Saving(a,balance);
			saccounts[a].setpassword(password);
			System.out.println("Account created! \nYour Id is: " +saccounts[a].getId() + "\nYour Password is: " + saccounts[a].getpassword() + "\nYour balance is : " + saccounts[a].getBalance());
			System.out.println("Returning \n");
			a++;
			create = false;
		}while(create == true);
	}
	/////login page for checkings
	public static void clogin() {
		do {
			System.out.println("Plese Log in.");
			do {
				System.out.println("Enter your ID Number or enter 2225 to go back to first screen");
				
					int pID = numberinput.nextInt();
					if(validId(pID) == true) { //// sending to the id checking method.
						do {
							System.out.println("Please enter your Password or enter 'back' to go back to first screen");
							String password = wordinput.nextLine();
							if(correctpassword(password) == true) {
								cmainmenu();
								logedin = true;
							}
							else if(password.equals("back")) {
								logedin = true;
								trylog = false;
							}
							else {
								System.out.println("Incorrect password try again.");
							}
						}while (logedin == false);
					}
					else if (pID == 2225) {
						logedin = true;
						trylog = false;
					}
					else {
						System.out.println("Sorry that is not a valid ID number\n");
					}
			}while (logedin == false);
			
		} while (trylog == true);
	}
	
	//////Login in for savings account
	public static void slogin() {
		do {
			System.out.println("Plese Log in.");
			do {
				System.out.println("Enter your ID Number or enter 2225 to go back to first screen");
				
					int pID = numberinput.nextInt();
					if(validId(pID) == true) { //// sending to the id checking method.
						do {
							System.out.println("Please enter your Password or enter 'back' to go back to first screen");
							String password = wordinput.nextLine();
							if(correctpassword(password) == true) {
								smainmenu();
								logedin = true;
							}
							else if(password.equals("back")) {
								logedin = true;
								trylog = false;
							}
							else {
								System.out.println("Incorrect password try again.");
							}
						}while (logedin == false);
					}
					else if (pID == 2225) {
						logedin = true;
						trylog = false;
					}
					else {
						System.out.println("Sorry that is not a valid ID number\n");
					}
			}while (logedin == false);
			
		} while (trylog == true);
	}
	
	
	
	///// main menu page to choose an action for checkings
	public static void cmainmenu() {
		logedin = true;
		System.out.println("Checkings Account \nWelcome to the Main menu.");
		do {
			System.out.println("What whould you like to do? \n 1) check Balance\n 2) Withdraw \n 3) Deposit \n 4) Account info \n 5) Log out");
			int option = numberinput.nextInt();
			if(option == 1) {
				System.out.println("Balance is: " +caccounts[pa].getBalance() + "\n");
			}
			else if (option == 2) {
				
				System.out.println("How much would you like to Withdraw \n");
				double amount = numberinput.nextDouble();
				caccounts[pa].withdraw(amount);
				System.out.println("New Balance is: " + caccounts[pa].getBalance() + "\n");
				
			}
			else if (option == 3) {
				System.out.println("How much would you like to Deposit \n");
				double amount = numberinput.nextDouble();
				caccounts[pa].deposit(amount);
				System.out.println("New Balance is: " + caccounts[pa].getBalance() + "\n");
			}
			else if (option == 4) {
				System.out.println(caccounts[pa].toString());
			}
			else if (option == 5) {
				logedin = false;
				trylog = false;
			}
			else {
				System.out.println("Not an option please try again.");
			}
		}while(logedin == true);
	}
	////// main menu page to choose an action for savings.
	public static void smainmenu() {
		logedin = true;
		System.out.println("Savings Account \nWelcome to the Main menu.");
		do {
			System.out.println("What whould you like to do? \n 1) check Balance\n 2) Withdraw \n 3) Deposit \n 4) Account info \n 5) Log out");
			int option = numberinput.nextInt();
			if(option == 1) {
				System.out.println("Balance is: " +saccounts[pa].getBalance() + "\n");
			}
			else if (option == 2) {
				
				System.out.println("How much would you like to Withdraw \n");
				double amount = numberinput.nextDouble();
				saccounts[pa].withdraw(amount);
				System.out.println("New Balance is: " + saccounts[pa].getBalance() + "\n");
				
			}
			else if (option == 3) {
				System.out.println("How much would you like to Deposit \n");
				double amount = numberinput.nextDouble();
				caccounts[pa].deposit(amount);
				System.out.println("New Balance is: " + saccounts[pa].getBalance() + "\n");
			}
			else if (option == 4) {
				System.out.println(saccounts[pa].toString());
			}
			else if (option == 5) {
				logedin = false;
				trylog = false;
			}
			else {
				System.out.println("Not an option please try again.");
			}
		}while(logedin == true);
	}

	
	//// checks to see if the inputed number is a id in any of the objects in the array.
	static boolean validId(int pID){
		for(int i = 0; i <= 24; i++){
			//// catchs the error of some of the array being null, or not set up yet.
			try{
				/// see if it is checkings or savings
				if (actype == false) {
					if(pID == caccounts[i].getId()){
						pa = i;
					return true;
					}
				}
				else {
					if(pID == saccounts[i].getId()){
						pa = i;
					return true;	
					}
				}
			}catch(Exception e) {
				return false;
			}
		} return false;
	}
	//// compares password to see if it is right.
	static boolean correctpassword(String password) {
		if (actype == false) {
			if(password.equals(caccounts[pa].getpassword())== true) {
				return true;
			}
		}
		else if(actype == true){
			if(password.equals(saccounts[pa].getpassword())== true) {
				return true;
			}	
		}
		
		
		return false;
	}
}
