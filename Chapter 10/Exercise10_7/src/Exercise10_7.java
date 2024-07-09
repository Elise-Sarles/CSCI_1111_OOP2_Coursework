//// Elise Sarles July 8 2024 
import java.util.Scanner;

public class Exercise10_7 {

	static Scanner numberinput = new Scanner(System.in);  /// the input scanner for number var
	static Scanner wordinput = new Scanner(System.in);  //// the input for text based var
	public static Account[] accounts = new Account[25];  //// Account array to make them easier to handle.
	static int a = 10; //// basic Id number after the first 10.
	static int pa = 0; /// present account in use. 
	static boolean create; //// boolean for the creating an account here so I can set is true in a different part of the the code as well as when it is used. 
	static boolean logedin = false; //// to check if logged in.
	static boolean trylog = false; //// checks to see if you are trying to log in
	public static void main(String[] args) {
		//// Creating base 10 accounts all their passwords are password.
		for (int n = 0; n <= 9; n++){
		accounts[n] = new Account(n,100);
		}
		//// creating opening first interaction 
		 do{
			 System.out.print("Do you want to login or Create an Account? \nPlease type 1 for login or 2 for Create an account\n");
			 int answer = numberinput.nextInt();
			 //// if statement to work through the answers. else statement to deal with number based errors.
			 if(answer == 1) {
				 logedin = false;
				 trylog = true;
				 login();
			 }
			 else if (answer == 2) {
				 create = true;
			 createaccount();
			 }
			 else {
				 System.out.println("Sorry not an option please try again.\n");
			 }
			 
		 }while (true);
	}
	//// Creating an account. 
	public static void createaccount() {
		do{
			System.out.println("Your ID number is : " + a);
			System.out.println("Enter a Password: ");
			String password = wordinput.nextLine();
			System.out.println("Enter amount you would like to put into the account: ");
			double balance = numberinput.nextDouble();
			/// crating account based on next open slot is the array.
			accounts[a] = new Account(a,balance);
			accounts[a].setpassword(password);
			System.out.println("Account created! \nYour Id is: " +accounts[a].getId() + "\nYour Password is: " + accounts[a].getpassword() + "\nYour balance is : " + accounts[a].getBalance());
			System.out.println("Returning \n");
			a++;
			create = false;
		}while(create == true);
	}
	/////login page
	public static void login() {
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
								mainmenu();
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
	///// main menu page to choose an action.
	public static void mainmenu() {
		logedin = true;
		System.out.println("Welcome to the Main menu.");
		do {
			System.out.println("What whould you like to do? \n 1) check status balance\n 2) Withdraw \n 3) Deposit \n 4) Log out");
			int option = numberinput.nextInt();
			if(option == 1) {
				System.out.println("Balance is: " +accounts[pa].getBalance() + "\n");
			}
			else if (option == 2) {
				
				System.out.println("How much would you like to Withdraw \n");
				double amount = numberinput.nextDouble();
				accounts[pa].withdraw(amount);
				System.out.println("New Balance is: " + accounts[pa].getBalance() + "\n");
				
			}
			else if (option == 3) {
				System.out.println("How much would you like to Deposit \n");
				double amount = numberinput.nextDouble();
				accounts[pa].deposit(amount);
				System.out.println("New Balance is: " + accounts[pa].getBalance() + "\n");
			}
			else if (option == 4) {
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
				if(pID == accounts[i].getId()){
					pa = i;
				return true;
				}
			}catch(Exception e) {
				return false;
			}
		} return false;
	}
	//// compares password to see if it is right.
	static boolean correctpassword(String password) {
		if(password.equals(accounts[pa].getpassword())== true) {
			return true;
		}
		return false;
	}
	
	
}
