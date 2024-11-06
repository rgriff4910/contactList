/** Contact - contact class
 * 
 * 
 * Copyright Howard Community College 2024
 * 
 * @author Ronald Griffin
 * 
 */
package contactList;

public class Contact{
	String number;
	String name;
	// data fields
	
	public Contact(String name, String number) {
		this.name = name;
		this.number = number;
	}
	// constructor
	
	public String getName() {
		return name;
	}
	// name getter
	
	public void setName(String name) {
		this.name = name;
	}
	// name setter
	
	public String getNumber() {
		return number;
	}
	// number getter
	
	public void setNumber(String number) {
		this.number = number;
	}
	// number setter
	
	@Override
	public String toString() {
		return "Contact [" + name + ": " + number + "]";
	}
	//toString method
}
// end class Contact