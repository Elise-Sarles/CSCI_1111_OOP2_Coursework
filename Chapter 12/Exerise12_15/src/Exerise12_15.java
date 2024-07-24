////Elise Sarles July 23 2023
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

 public class Exerise12_15 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner user = new Scanner(System.in);
		File file = new File ("Exersise12_15.txt");
		int answer = 0; // the users and answer
		/////Checkin to so if the file exists and if so to ask the user what they would like to do. 
		if (file.exists()) {
			do {
			System.out.println("The File already Exisits are you sure you want to rewrite this file? 1) yes    2) no");
			answer = user.nextInt();
				if(answer == 2) {
					System.exit(1);
				}
				
			}while(answer != 1);
		}
		user.close();
		//// making array list to put info into
		ArrayList<Integer> fileinfo = new ArrayList<>();
		/// writing into the file
		PrintWriter output = new PrintWriter(file);
		
		for(int i = 0; i <= 99; i ++) {
			
			output.print((int)(Math.random()* 100) + "\n");
		}
		output.close();
		///reading what is on the file and putting it into an array list. 
		Scanner input = new Scanner(file);
		while(input.hasNext()) {
			fileinfo.add(input.nextInt());
		}
		input.close();
		for (int i = 0 ; i<= fileinfo.size() - 1; i++) {
			System.out.print(fileinfo.get(i) + " ");
		}
		
		Collections.sort(fileinfo); ////sorting the array list increasing order. 
		System.out.println("\nInformation sorted least to greatest");
		for (int i = 0 ; i<= fileinfo.size() - 1; i++) {
			System.out.print(fileinfo.get(i) + " ");
		}
		
		
	
		
	}
	
}
