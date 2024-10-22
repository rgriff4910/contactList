/** Main - class to interact with contact list
 * 
 * 
 * Copyright Howard Community College 2024
 * 
 * @author Ronald Griffin
 * 
 */
package contactList;

import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileNotFoundException;

public class Main {
	private static List read() {
		List <Contact> contactList = new ArrayList<Contact>();
		// list variable
		
		Scanner input = new Scanner(System.in);
		// input variable
		
		int whileloop = 0;
		// while variable
		
		while(whileloop == 0) {
			System.out.print("Enter file name: ");
			// prompt file name
			
			String fileName = input.nextLine();
			// get file name
			
			File contactFile = new File(fileName);
			// create file object
			
			if(contactFile.exists()) {
				try
				{
					Scanner reader = new Scanner(contactFile);
					// scanner for reading file
					
					while (reader.hasNext()) { // while lines are still left
						contactList.add(new Contact(reader.next(), reader.nextLine()));
						// add contact to list
					}
					
					
					reader.close();
					// close reader
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
		return contactList;
	}
	
	public static void alphabeticalOrder(List contactList) {
		int n = contactList.size();
		Collections.sort(contactList);
		
		for (int i = 0; i < contactList.size(); i++) {
			System.out.print(contactList.get(i));
		}
	}
	
	public static void reverseAlphabeticalOrder(List contactList) {
		int n = contactList.size();
		Collections.sort(contactList);
		
		for (int i = contactList.size(); i == 0; i--) {
			System.out.print(contactList.get(i));
		}
	}
	
	public static void search(List contactList) {
		
	}
	
	public static void main(String[] args) {
		System.out.print("Copyright Howard Community College 2024\n\n");
		// copyright statement
		
		List <Contact> contactList = read();
		
		Scanner input = new Scanner(System.in);
		
		int whileloop = 0;
		while (whileloop == 0) {
			System.out.print("Contact List\n");
			System.out.print("------------\n");
			System.out.print("Select One of the Following Operations\n");
			System.out.print("1. Display contents in alphabetical order\n");
			System.out.print("2. Display contents in reverse alphabetical order\n");
			System.out.print("3. Search contacts\n");
			System.out.print("4. Exit\n");
			System.out.print("Enter your selection here: ");
			
			int selection = 0;
			
			selection = input.nextInt();
			
			if (selection == 1) {
				alphabeticalOrder(contactList);
			}
			if (selection == 2) {
				reverseAlphabeticalOrder(contactList);
			}
			if (selection == 3) {
				search(contactList);
			}
			if (selection == 4) {
				System.out.print("Goodbye!");
				whileloop = 1;
			} else {
				System.out.print("Invalid selection");
			}
		}
	}
}
