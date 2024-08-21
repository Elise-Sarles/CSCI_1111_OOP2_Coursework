///Elise Sarles August 15 20024
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise17_1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner user = new Scanner(System.in);
		File file = new File ("Exersise12_15.txt");
		int answer = 0; // the users and answer
		/////Checkin to so if the file exists and if so to ask the user what they would like to do. 
		if (file.exists()) {
			do {
			System.out.println("The File already Exisits are you sure you want to add to this file? 1) yes    2) no");
			answer = user.nextInt();
				if(answer == 2) {
					System.exit(1);
				}
				
			}while(answer != 1);
		}
		user.close();
		
		ArrayList<Integer> fileinfo = new ArrayList<>();
		
		if (file.exists()){
			///Saving info already on file
			System.out.println("Editing File");
			Scanner input = new Scanner(file);
			while(input.hasNext()) {
				fileinfo.add(input.nextInt());
			}
			input.close();
			///Displaying numbers already on file.
			for (int i = 0 ; i<= fileinfo.size() - 1; i++) {
				System.out.print(fileinfo.get(i) + " ");
				
			}
		}
		
		else{
		System.out.println("File Created.");
		}
		
		PrintWriter output = new PrintWriter(file);
		///Replacing old numbers
		for (int i = 0 ; i<= fileinfo.size() - 1; i++) {
			 output.print(fileinfo.get(i) + " ");
		}
		///adding new Numbers
		 for (int i = 0; i < 100; i++) {
		        output.print((int)(Math.random() * 100) + " ");
		 }
		
		output.close();
		
		
	}

}
