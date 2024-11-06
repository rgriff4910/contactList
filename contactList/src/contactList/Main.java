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
import java.io.FileNotFoundException;

public class Main {
	private static List <Contact> read() {
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
						contactList.add(new Contact(reader.next() + " " + reader.next(), reader.nextLine().strip()));
						// add contact to list
					}
					
					reader.close();
					// close reader
				}
				catch (FileNotFoundException fileNotFoundException)
				{
					System.out.println("Error opening file.");
					System.exit(1);
					// Throw exception and terminate JVM if error encountered
				}
				whileloop = 1;
				// end loop
			} else {
				System.out.print("File not found. Please try again.\n\n");
			}
		}
		return contactList;
	}
	// method for reading text file and adding contacts to a list
	
	
	
	public static List<Contact> selectionSort(List<Contact> contactList) {
		for(int i = 0; i < contactList.size(); i++) {
			for(int j = i + 1; j < contactList.size(); j++) {
				if(contactList.get(j).getName().compareTo(contactList.get(i).getName()) < 0) {
				// compare names to see if j value is lower than i value in lexicographic order
					
					Contact temp = contactList.get(i);
					contactList.set(i, contactList.get(j));
					contactList.set(j, temp);
					// swap the two names
				}
			}
		}
		return contactList;
	} 
	// method for sorting the list of contacts into alphabetical order
	
	
	
	public static void alphabeticalOrder(List<Contact> contactList) {
		System.out.print("\n");
		
		contactList = selectionSort(contactList);
		// use selection sort method to alphabetize contact list
		
		System.out.print("Contact List:\n");
		
		for (int i = 0; i < contactList.size(); i++) {
			System.out.printf("%s \n",contactList.get(i));
		}
		// display contact list in alphabetical order
	}
	// method for sorting list and displaying it in ascending order
	
	
	
	public static void reverseAlphabeticalOrder(List<Contact> contactList) {
		System.out.print("\n");
		
		contactList = selectionSort(contactList);
		// use selection sort method to alphabetize contact list
		
		for (int i = contactList.size() - 1; i >= 0; i--) {
			System.out.printf("%s \n",contactList.get(i));
		}
		// display contact list in reverse alphabetical order
	}
	// method for sorting list and displaying it in descending order
	
	
	
	public static void sequentialSearch(List<Contact> contactList, Scanner input) {
		System.out.print("\nEnter contact name: ");
		// prompt input
		
		input.nextLine();
		String searchName = input.nextLine();
		// user inputs name to search
		
		int found = 0;
		// loop sentinel
		
		for (int i = 0; i < contactList.size(); i++) {
			if (contactList.get(i).getName().equals(searchName)) { // if contact name equals search
				System.out.print(contactList.get(i));
				// display contact
				found = 1;
				// end loop
			}
		}
		if (found == 0) {
			System.out.print("Contact not found.");
		}
		System.out.print("\n");
	}
	// method for searching for contact in list using sequential search
	
	
	
	public static void binarySearch(List<Contact> contactList, Scanner input) {
		System.out.print("\nEnter contact name: ");
		// prompt input
		
		input.nextLine();
		String searchName = input.nextLine();
		// user inputs name to search
		
		int low = 0; // low end of search area
		int high = contactList.size() - 1; // high end of search area
		int middle = (low + high + 1) / 2; // middle element
		int location = -1; // return value
		
		do {
			if (searchName.equals((contactList).get(middle).getName())) {
				location = middle;
			} else if (searchName.compareTo(contactList.get(middle).getName()) < 0) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
			middle = (low + high + 1) / 2;
		} while ((low <= high) && (location == -1));
		
		if (location == -1) {
			System.out.print("Contact not found.");
		} else {
			System.out.print(contactList.get(location));
		}
		System.out.print("\n");
	}
	
	public static void displayMenu() {
		System.out.print("\n");
		System.out.print("Contact List\n");
		System.out.print("------------\n");
		System.out.print("Select One of the Following Operations\n");
		System.out.print("1. Display contents in alphabetical order\n");
		System.out.print("2. Display contents in reverse alphabetical order\n");
		System.out.print("3. Search contacts\n");
		System.out.print("4. Exit\n");
		System.out.print("Enter your selection here: ");
		// display menu
	}
	// method for displaying menu options
	
	public static void main(String[] args) {
		System.out.print("Copyright Howard Community College 2024\n\n");
		// copyright statement
		
		List <Contact> contactList = read();
		// create list of contacts from text file using read method
		
		Scanner input = new Scanner(System.in);
		// scanner object
		
		int whileloop = 0;
		// control variable
		
		int sorted = 0;
		// verify that list is sorted
		
		while (whileloop == 0) {
			displayMenu();
			// display menu
			
			int selection = 0;
			// reset selection
			
			selection = input.nextInt();
			// user enters selection
			
			if (selection == 1) {
				alphabeticalOrder(contactList);
				// use alphabetical order method on list
				
				sorted = 1;
				// list is now sorted
			}
			else if (selection == 2) {
				reverseAlphabeticalOrder(contactList);
				// use reverse alphabetical order method on list
				
				sorted = 1;
				// list is now sorted
			}
			else if (selection == 3) {
				if (sorted == 0) {
					sequentialSearch(contactList, input);
				// use sequential search if list not sorted
				} else if (sorted == 1) {
					binarySearch(contactList, input);
				} // use binary search if list sorted
			}
			else if (selection == 4) {
				System.out.print("\nGoodbye!");
				// display goodbye message
				
				whileloop = 1;
				// end while loop
				
				input.close();
				// close scanner
			} else {
				System.out.print("Invalid selection\n\n");
			}
		}
	}
}
