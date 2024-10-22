package contactList;

public class Contact {
	int number;
	String name;
	// data fields
	
	public Contact(String name, int number) {
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
	
	public int getNumber() {
		return number;
	}
	// number getter
	
	public void setNumber(int number) {
		this.number = number;
	}
	// number setter
	
	@Override
	public String toString() {
		return name + " " + number;
	}
	//toString method
}
// end class Contact