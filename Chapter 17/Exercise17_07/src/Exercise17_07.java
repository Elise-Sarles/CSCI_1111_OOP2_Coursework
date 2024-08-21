/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rmazorow
 * edited by Elise Sarles August 19 2024
 */
import java.io.*;

public class Exercise17_07 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException {
        Loan loan1 = new Loan();
        Loan loan2 = new Loan(1.8, 10, 10000);
        
        try (
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise17_07.dat"));
        ) {
            output.writeObject(loan1);
            output.writeObject(loan2);
            
            output.close();
            outputData();
     
        } 
        catch (IOException ex) {
            System.out.println("File could not be opened");
        }
    }
    
    public static void outputData() throws FileNotFoundException, IOException, ClassNotFoundException{
    	
    	  try (	ObjectInputStream input = new ObjectInputStream(new FileInputStream("Exercise17_07.dat")); ) {
    		 while(true){
    		  Loan loan = (Loan)input.readObject();
    		  System.out.println(loan);
    		  System.out.printf("Total loan amount: $%.2f\n", 
    				  loan.getTotalPayment());
    		  System.out.println();
    		  
    		 }
    	  }
    	  
    	  catch(EOFException ex) {
    		  System.out.println("End of File");
    		  
    	  }
    	  
    }
}
