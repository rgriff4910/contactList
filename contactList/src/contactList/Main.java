package contactList;

import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Main {
	private static void read() {
		List <Contact> contactList = new ArrayList<Contact>();
		
		Scanner input = new Scanner(System.in);
		
		int whileloop = 0;
		
		while(whileloop == 0) {
			System.out.print("Enter file name: ");
			
			String fileName = input.nextLine();
			
			File contactFile = new File(fileName);
			
			if(contactFile.exists()) {
				try
				{
					Scanner reader = new Scanner(contactFile);
					
					while (reader.hasNext()) {
						contactList.add(new Contact(reader.next(), reader.nextLine()));
					}
					
					for (Contact contact: contactList) {
						System.out.println(contact);
					}
					
					reader.close();
				}
				catch (FileNotFoundException fileNotFoundException)
				{
					System.out.println("Error opening file.");
					System.exit(1);
				}
				
				whileloop = 1;
			} else {
				System.out.print("File not found. Please try again.\n\n");
			}
		}
	}
	
	public static void main(String[] args) {
		read();
	}
}
