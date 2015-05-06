package lab12;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class Messages {

  private Messages() {

  }

  public static void showDateIncorrectFormatMessage(final JFrame frame) {
    JOptionPane.showMessageDialog(frame,
        "The birthdate is not in the correct format.\nMM/DD/YYYY.",
        "Incorrect Date Format", JOptionPane.ERROR_MESSAGE);
  }

  public static void showLNameMissingMessage(final JFrame frame) {
    JOptionPane.showMessageDialog(frame,
        "The last name field cannot be empty.", "Empty Last Name",
        JOptionPane.ERROR_MESSAGE);
  }

  public static void showMustHaveOneMessage(final JFrame frame) {
    JOptionPane.showMessageDialog(frame,
        "You must have at least one contact. Cannot delete.",
        "Cannot Delete Contact", JOptionPane.WARNING_MESSAGE);
  }

  public static void showSearchNotFoundMessage(final JFrame frame) {
    JOptionPane.showMessageDialog(frame, "No results found.", "Information",
        JOptionPane.INFORMATION_MESSAGE);
  }

  public static void showBDayMessage(final JFrame frame, final String firstName) {
    JOptionPane.showMessageDialog(frame, "Happy Birthday, " + firstName + "!",
        "Important Message", JOptionPane.INFORMATION_MESSAGE);
  }

  public static int showDeleteContactMessage(final JFrame frame,
      final String firstName, final String lastName) {
    Object[] optionButtons = { "Yes", "No" };

    return JOptionPane.showOptionDialog(frame,
        "Are you sure you want to delete " + firstName + " " + lastName + "?",
        "Delete Contact", JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE, null, optionButtons, optionButtons[1]);
  }
}
