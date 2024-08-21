///Elise Sarles August 19 2024

import java.io.*;

public class Exercise17_03 {
public static void main(String[] args)throws IOException{
	try(RandomAccessFile file = new RandomAccessFile("temp.dat", "rw")){
		for (int i = 0; i < 100; i++) {
			file.writeInt((int)(Math.random() * 100));
		}
		System.out.println("Current file length is " + file.length());
		
		for(int i = 0; i < (file.length()/4); i++) {
			file.seek((i * 4));
			System.out.print(file.readInt()+ " ");
		}
	}
}
	
}
