package lab12;

import java.io.Serializable;
import java.util.regex.Pattern;

public class PhoneNumber implements Serializable {
  private static final long serialVersionUID = 7335515713086090633L;
  private static final int NUMBER_LENGTH_WO_INTERNATIONAL = 10;
  private static final int NUMBER_LENGTH_W_INTERNATIONAL = 11;

  private String phoneNumber;

  public PhoneNumber(final String phoneNumber) {
    this.phoneNumber = phoneNumber;
    parseNumber();
  }

  public final String toString() {
    StringBuilder sb = new StringBuilder();

    sb.append("Phone Number: ");
    sb.append(phoneNumber);
    sb.append("\n");

    return sb.toString();
  }
  
  public PhoneNumber(final PhoneNumber originalObject) {
    if (originalObject == null) {

      System.out.println("Error: null PhoneNumber object.");
      System.exit(0);
    }

    phoneNumber = originalObject.phoneNumber;
  }
  
  public final boolean equals(final Object other) {
    if (other == null) {
      return false;
    } // end of if ()
    else if (this.getClass() != other.getClass()) {
      return false;
    } // end of if ()
    else {
      PhoneNumber phoneNumber = (PhoneNumber) other;
      return (this.phoneNumber.equals(phoneNumber.phoneNumber));
    } // end of else
  }
  
  public final Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  private void parseNumber() {
    phoneNumber = removeNonDigits(phoneNumber);
    formatNumber();
  }

  private void formatNumber() {
    StringBuilder sb = new StringBuilder(phoneNumber);
    
    if (sb.length() == NUMBER_LENGTH_WO_INTERNATIONAL) {
      sb.insert(0, '(');
      sb.insert(4, ')');
      sb.insert(5, ' ');
      sb.insert(9, '-');
    }
    else if (sb.length() == NUMBER_LENGTH_W_INTERNATIONAL) {
      sb.insert(0, '+');
      sb.insert(2, ' ');
      sb.insert(3, '(');
      sb.insert(7, ')');
      sb.insert(8, ' ');
      sb.insert(12, '-');
    }

    phoneNumber = sb.toString();
  }

  private String removeNonDigits(final String string) {
    StringBuilder sb = new StringBuilder(string);

    int i = 0;
    while (i < sb.length()) {
      if (Pattern.matches("\\D", sb.substring(i, i + 1))) {
        sb.deleteCharAt(i);
        i--;
      }
      i++;
    }

    return sb.toString();
  }

  public final String getPhoneNumber() {
    return phoneNumber;
  }

  public final void setPhoneNumber(final String phoneNumber) {
    this.phoneNumber = phoneNumber;
    parseNumber();
  }
}
