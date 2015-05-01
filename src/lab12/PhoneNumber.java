package lab12;

import java.io.Serializable;
import java.util.regex.Pattern;

public class PhoneNumber implements Serializable{
    private static final int NUMBER_LENGTH_WO_INTERNATIONAL = 10;
    private static final int NUMBER_LENGTH_W_INTERNATIONAL = 11;

    private String phoneNumber;

    public PhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
	parseNumber();
    }
    
    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append("Phone Number: ");
	sb.append(phoneNumber);
	sb.append("\n");

	return sb.toString();
    }

    private void parseNumber() {
	phoneNumber = removeNonDigits(phoneNumber);
	formatNumber();
    }
    
    private void formatNumber(){
	StringBuilder sb = new StringBuilder(phoneNumber);
	
	if (sb.length() == NUMBER_LENGTH_WO_INTERNATIONAL){
	    sb.insert(0, '(');
	    sb.insert(4, ')');
	    sb.insert(5, ' ');
	    sb.insert(9, '-');
	}
	else if (sb.length() == NUMBER_LENGTH_W_INTERNATIONAL){
	    sb.insert(0, '+');
	    sb.insert(2, ' ');
	    sb.insert(3, '(');
	    sb.insert(7, ')');
	    sb.insert(8, ' ');
	    sb.insert(12, '-');
	}
	
	phoneNumber = sb.toString();
    }

    private String removeNonDigits(String string) {
	StringBuilder sb = new StringBuilder(string);

	for (int i = 0; i < sb.length(); i++) {
	    if (Pattern.matches("\\D", sb.substring(i, i + 1))) {
		sb.deleteCharAt(i);
		i--;
	    }
	}

	return sb.toString();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
