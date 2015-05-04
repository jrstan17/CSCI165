package lab12;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class GregorianCalendarExtended extends GregorianCalendar {

    public final static String DATE_FORMAT = "(\\d{2}/\\d{2}/\\d{4})";

    public GregorianCalendarExtended() {
	super();
    }

    public GregorianCalendarExtended(String string) {
	this.set(Calendar.MONTH, Integer.valueOf(string.substring(0, 2)) - 1);
	this.set(Calendar.DATE, Integer.valueOf(string.substring(3, 5)));
	this.set(Calendar.YEAR, Integer.valueOf(string.substring(6)));
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();

	if (this.get(Calendar.MONTH) + 1 <= 9) {
	    sb.append("0");
	}

	sb.append(this.get(Calendar.MONTH) + 1);
	sb.append("/");

	if (this.get(Calendar.DATE) <= 9) {
	    sb.append("0");
	}

	sb.append(this.get(Calendar.DATE));
	sb.append("/");
	sb.append(this.get(Calendar.YEAR));

	return sb.toString();
    }

    public boolean equals(Object other) {
	if (other == null) {
	    return false;
	} // end of if ()
	else if (this.getClass() != other.getClass()) {
	    return false;
	} // end of if ()
	else {
	    GregorianCalendarExtended gce = (GregorianCalendarExtended) other;
	    return (this.get(Calendar.MONTH) == gce.get(Calendar.MONTH)
		    && this.get(Calendar.DATE) == gce.get(Calendar.DATE) && this
			.get(Calendar.YEAR) == gce.get(Calendar.YEAR));
	} // end of else
    }
}
