package cse3040ex1203;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex12_03 {

	public static void main(String[] args) throws IOException {
		String str = "Hello, my name is Harry Potter.\nI am a student in the Java Language class.\nI am trying to write this text to a file.\nThank you.\n";
		FileOutputStream output1 = new FileOutputStream("src/cse3040ex1203/myfile1.txt");
		byte[] bytes = str.getBytes();
		output1.write(bytes);
		output1.close();
		
		FileWriter output2 = new FileWriter("src/cse3040ex1203/myfile2.txt");
		output2.write(str);
		output2.close();
	
		PrintWriter output3 = new PrintWriter("src/cse3040ex1203/myfile3.txt");
		output3.print(str);
		output3.close();
	}
}
