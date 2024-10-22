package contactList;

import java.util.Scanner;
import java.io.File;
import java.util.List;

public class Main {
	private static void read() {
		List <String> contactList;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter file name: ");
		
		String fileName = input.nextLine();
		
		File contactFile = new File(fileName);
		
		if(contactFile.exists()) {
			System.out.print("yes");
		} else {
			System.out.print("no");
		}
	}
	
	public static void main(String[] args) {
		read();
	}
}
