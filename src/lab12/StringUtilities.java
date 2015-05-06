package lab12;

public final class StringUtilities {

  private StringUtilities() {

  }

  public static String toProperNoun(final String str) {
    String stringToReturn = "";

    if (str != null && !str.isEmpty()) {

      stringToReturn = str.substring(0, 1).toUpperCase();

      int i = 1;
      while (i < str.length()) {
        if (str.charAt(i) == ' ') {
          i++;
          stringToReturn =
              stringToReturn + " " + str.substring(i, i + 1).toUpperCase();
        }
        else {
          stringToReturn = stringToReturn + str.charAt(i);
        }
        i++;
      }
    }

    return stringToReturn;
  }
}
