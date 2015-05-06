package lab12;

import java.io.Serializable;

public class Contact implements Serializable, Comparable<Contact> {

    private static final long serialVersionUID = 5147644076822841959L;
    private String fName = "";
    private String lName = "";
    private String email = "";
    private PhoneNumber phone = new PhoneNumber("");
    private String notes = "";
    private Address address = new Address();
    private GregorianCalendarExtended birthday;    
    
    public Contact() {
	System.out.println();
    }
    
    public final String toString() {
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
    public final int compareTo(final Contact o) {
	return this.lName.compareTo(o.lName);
    }

    public final String getFName() {
	return fName;
    }

    public final void setFName(final String fName) {
	this.fName = StringUtilities.toProperNoun(fName);
    }

    public final String getLName() {
	return lName;
    }

    public final void setLName(final String lName) {
	this.lName = StringUtilities.toProperNoun(lName);
    }

    public final PhoneNumber getPhone() {
	return phone;
    }

    public final void setPhone(final PhoneNumber phone) {
	this.phone = phone;
    }

    public final Address getAddress() {
	return address;
    }

    public final void setAddress(final Address address) {
	this.address = address;
    }

    public final GregorianCalendarExtended getBirthday() {
	return birthday;
    }
    
    public final void setBirthday(final GregorianCalendarExtended birthday) {
	this.birthday = birthday;
    }

    public final String getEmail() {
        return email;
    }

    public final void setEmail(final String email) {
        this.email = email;
    }

    public final String getNotes() {
        return notes;
    }

    public final void setNotes(final String notes) {
        this.notes = notes;
    }
}
