package lab12;

import java.io.Serializable;

public class Contact implements Serializable, Comparable<Contact> {

  private static final long serialVersionUID = 5147644076822841959L;
  private String firstName = "";
  private String lastName = "";
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
    sb.append(firstName + " " + lastName);
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

  public Contact(final Contact originalObject) {
    if (originalObject == null) {

      System.out.println("Error: null Contact object.");
      System.exit(0);
    }
    // else
    firstName = originalObject.firstName;
    lastName = originalObject.lastName;
    email = originalObject.email;
    notes = originalObject.notes;

    try {
      address = (Address) address.clone();
      birthday = (GregorianCalendarExtended) birthday.clone();
      phone = (PhoneNumber) phone.clone();
    }
    catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public final int compareTo(final Contact o) {
    return this.lastName.compareTo(o.lastName);
  }

  public final String getFirstName() {
    return firstName;
  }

  public final void setFirstName(final String firstName) {
    this.firstName = StringUtilities.toProperNoun(firstName);
  }

  public final String getLastName() {
    return lastName;
  }

  public final void setLastName(final String lastName) {
    this.lastName = StringUtilities.toProperNoun(lastName);
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
