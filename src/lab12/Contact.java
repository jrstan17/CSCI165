package lab12;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Contact implements Serializable{

    private static final long serialVersionUID = 5147644076822841959L;
    private String fName = "";
    private String lName = "";
    private String email = "";
    private PhoneNumber phone;
    private String notes = "";
    private Address address;
    private GregorianCalendar birthday;
    
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
	sb.append(birthday.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US));
	sb.append(" ");
	sb.append(birthday.get(Calendar.DATE));
	sb.append (", ");
	sb.append(birthday.get(Calendar.YEAR));
	sb.append("\n");
	sb.append("Notes: ");
	sb.append(notes);
	sb.append("\n");

	return sb.toString();
    }

    public String getFName() {
	return fName;
    }

    public void setFName(String fName) {
	this.fName = fName;
    }

    public String getLName() {
	return lName;
    }

    public void setLName(String lName) {
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

    public GregorianCalendar getBirthday() {
	return birthday;
    }

    public void setBirthday(GregorianCalendar birthday) {
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
