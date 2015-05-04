package lab12;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Messages {
    public static void showDateIncorrectFormatMessage(JFrame frame) {
	JOptionPane.showMessageDialog(frame,
		"The birthdate is not in the correct format.\nMM/DD/YYYY.",
		"Incorrect Date Format", JOptionPane.ERROR_MESSAGE);
    }

    public static void showMustHaveOneMessage(JFrame frame) {
	JOptionPane.showMessageDialog(frame,
		"You must have at least one contact. Cannot delete.",
		"Cannot Delete Contact", JOptionPane.WARNING_MESSAGE);
    }

    public static void showBDayMessage(JFrame frame, String firstName) {
	JOptionPane.showMessageDialog(frame, "Happy Birthday, " + firstName
		+ "!", "Important Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int showDeleteContactMessage(JFrame frame, String firstName,
	    String lastName) {
	Object[] optionButtons = { "Yes", "No" };

	return JOptionPane.showOptionDialog(frame,
		"Are you sure you want to delete " + firstName + " " + lastName
			+ "?", "Delete Contact", JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, optionButtons,
		optionButtons[1]);
    }
}
