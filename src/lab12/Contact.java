package lab12;

import java.io.Serializable;

public class Contact implements Serializable, Comparable<Contact>{

    private static final long serialVersionUID = 5147644076822841959L;
    private String fName = "";
    private String lName = "";
    private String email = "";
    private PhoneNumber phone = new PhoneNumber("");
    private String notes = "";
    private Address address = new Address();
    private GregorianCalendarExtended birthday;    
    
    public Contact(){
	System.out.println();
    }
    
    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append("Name: ");
	sb.append(fName + " " + lName);
	sb.append("\n");
	sb.append("Email: ");
	sb.append(email);
	sb.append("\n");
	sb.append(address);
	sb.append(phone);
	sb.append("Birthday: ");
	sb.append(birthday);
	sb.append("\n");
	sb.append("Notes: ");
	sb.append(notes);
	sb.append("\n");

	return sb.toString();
    }
    
    @Override
    public int compareTo(Contact o) {
	return this.lName.compareTo(o.lName);
    }

    public String getFName() {
	return fName;
    }

    public void setFName(String fName) {
	fName.equals(StringUtilities.toProperNoun(fName));
	this.fName = fName;
    }

    public String getLName() {
	return lName;
    }

    public void setLName(String lName) {
	lName = (StringUtilities.toProperNoun(lName));
	this.lName = lName;
    }

    public PhoneNumber getPhone() {
	return phone;
    }

    public void setPhone(PhoneNumber phone) {
	this.phone = phone;
    }

    public Address getAddress() {
	return address;
    }

    public void setAddress(Address address) {
	this.address = address;
    }

    public GregorianCalendarExtended getBirthday() {
	return birthday;
    }
    
    public void setBirthday(GregorianCalendarExtended birthday) {
	this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
