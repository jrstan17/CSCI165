package lab12;

public class StringUtilities {

  public static String toProperNoun(String str) {
    String stringToReturn = "";

    if (str != null && !str.isEmpty()) {

      stringToReturn = str.substring(0, 1).toUpperCase();

      for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i) == ' ') {
          stringToReturn = stringToReturn + " "
              + str.substring(i + 1, i + 2).toUpperCase();
          i++;
        } else {
          stringToReturn = stringToReturn + str.charAt(i);
        }
      }
    }

    return stringToReturn;
  }
}
