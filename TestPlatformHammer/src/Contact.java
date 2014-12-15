
public class Contact {

	//Fields
	private String lastName;
	private String firstName;
	private String email;
	private String address;
	private String cell;
	
	
	//Constructor
	public Contact(String ln, String fn) {
		lastName = ln;
		firstName = fn;
	}
	
	//Methods
	public void setEmail(String em) {
		email = em;
	}
	
	public void setAddress(String ad) {
		address = ad;
	}
	
	public void setName(String last, String first) {
		last = lastName;
		first = firstName;
	}
	
	public void setCell(String c) {
		cell = c;
	}
	
	public String getName() {
		return firstName + " " + lastName;
	}
		
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getCell() {
		return cell;
	}
	
}
