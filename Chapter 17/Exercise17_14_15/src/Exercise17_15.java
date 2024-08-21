import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Exercise17_15 {
	public static void main(String[] arg ) {
    Scanner in = new Scanner(System.in);
  System.out.println("Please enter the path to file to be dencrypted: ");
   String inFile = in.next();

    File inputFile = new File(inFile);

    System.out.println("Please enter a name for the decrypted file: ");
    String outFile = in.next();

    File outputFile = new File(outFile);
    try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile))) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFile))){
               int r;
               int numberofbytesEncrypted = 0;
        	while((r = inputStream.read())!= -1){
        	bufferedOutputStream.write((byte)r - 5);
        	numberofbytesEncrypted ++;
               }
        	System.out.println(numberofbytesEncrypted + " Bytes have been dencrypted");
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (Exception e) {
        e.printStackTrace();
    }


    in.close();
}
}
