package lab12;

import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class GregorianCalendarExtended extends GregorianCalendar {

  private static final int DATE_BEGINNING_INDEX = 3; 
  private static final int DATE_ENDING_INDEX = 5; 
  private static final int YEAR_BEGINNING_INDEX = 6; 
  private static final int MONTH_ENDING_INDEX = 2; 
  
  private static final int HIGHEST_SINGLE_DIGIT = 9; 
  
  public static final String DATE_FORMAT = "(\\d{2}/\\d{2}/\\d{4})";

  public GregorianCalendarExtended() {
    super();
  }

  public GregorianCalendarExtended(final String string) {
    this.set(Calendar.MONTH, Integer.valueOf(string.
        substring(0, MONTH_ENDING_INDEX)) - 1);
    this.set(Calendar.DATE, Integer.valueOf(string.
        substring(DATE_BEGINNING_INDEX, DATE_ENDING_INDEX)));
    this.set(Calendar.YEAR, Integer.valueOf(string.
        substring(YEAR_BEGINNING_INDEX)));
  }

  public final String toString() {
    StringBuilder sb = new StringBuilder();

    if (this.get(Calendar.MONTH) + 1 <= HIGHEST_SINGLE_DIGIT) {
      sb.append("0");
    }

    sb.append(this.get(Calendar.MONTH) + 1);
    sb.append("/");

    if (this.get(Calendar.DATE) <= HIGHEST_SINGLE_DIGIT) {
      sb.append("0");
    }

    sb.append(this.get(Calendar.DATE));
    sb.append("/");
    sb.append(this.get(Calendar.YEAR));

    return sb.toString();
  }

  @Override
  public final int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result;
    return result;
  }

  public final boolean equals(final Object other) {
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
