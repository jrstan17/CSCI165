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

  public Address(final Address originalObject) {
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

  public final boolean equals(final Object other) {
    if (other == null) {
      return false;
    } // end of if ()
    else if (this.getClass() != other.getClass()) {
      return false;
    } // end of if ()
    else {
      Address address = (Address) other;
      return (this.street.equals(address.street)
          && this.city.equals(address.city)
          && this.state.equals(address.state) && this.zip.equals(address.zip));
    } // end of else
  }
  
  public final Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  public final String toString() {
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

  public final String getStreet() {
    return street;
  }

  public final void setStreet(final String street) {
    this.street = (StringUtilities.toProperNoun(street));
  }

  public final String getCity() {
    return city;
  }

  public final void setCity(final String city) {
    this.city = (StringUtilities.toProperNoun(city));
  }

  public final States getState() {
    return state;
  }

  public final void setState(final States state) {
    this.state = state;
  }

  public final void setState(final String state) {
    for (States s : States.values()) {
      if (state.equals(s.displayName())) {
        this.state = s;
      }
    }
  }

  public final String getZip() {
    return zip;
  }

  public final void setZip(final String zip) {
    this.zip = zip;
  }

}
