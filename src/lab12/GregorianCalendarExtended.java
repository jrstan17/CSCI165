package lab12;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class GregorianCalendarExtended extends GregorianCalendar {

    public final static String DATE_FORMAT = "(\\d{2}/\\d{2}/\\d{4})";

    public GregorianCalendarExtended() {

    }

    public GregorianCalendarExtended(String string) {
	this.set(Calendar.MONTH, Integer.valueOf(string.substring(0, 2)));
	this.set(Calendar.DATE, Integer.valueOf(string.substring(3, 5)));
	this.set(Calendar.YEAR, Integer.valueOf(string.substring(6)));
    }

    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append(this.get(Calendar.MONTH));
	sb.append("/");
	sb.append(this.get(Calendar.DATE));
	sb.append("/");
	sb.append(this.get(Calendar.YEAR));

	return sb.toString();
    }
}
