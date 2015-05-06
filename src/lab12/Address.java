package lab12;

import java.io.Serializable;

public class Address implements Cloneable, Serializable {

  private static final long serialVersionUID = -6055649143312376189L;
  private String street = "";
  private String city = "";
  private States state = States.NA;
  private String zip = "";

  public Address() {

  }

  public Address(Address originalObject) {
    if (originalObject == null) {

      System.out.println("Error: null Address object.");
      System.exit(0);
    }
    // else
    street = originalObject.street;
    city = originalObject.city;
    state = originalObject.state;
    zip = originalObject.zip;
  }

  public boolean equals(Object other) {
    if (other == null) {
      return false;
    } // end of if ()
    else if (this.getClass() != other.getClass()) {
      return false;
    } // end of if ()
    else {
      Address address = (Address) other;
      return (this.street.equals(address.street)
          && this.city.equals(address.city) && this.state.equals(address.state) && this.zip
            .equals(address.zip));
    } // end of else
  }

  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Address: ");
    sb.append(street);
    sb.append(", ");
    sb.append(city);
    sb.append(", ");
    sb.append(state);
    sb.append(" ");
    sb.append(zip);
    sb.append("\n");

    return sb.toString();
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    street = (StringUtilities.toProperNoun(street));
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    city = (StringUtilities.toProperNoun(city));
    this.city = city;
  }

  public States getState() {
    return state;
  }

  public void setState(States state) {
    this.state = state;
  }

  public void setState(String state) {
    for (States s : States.values()) {
      if (state.equals(s.displayName())) {
        this.state = s;
      }
    }
  }

  public String getZip() {
    return zip;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

}
