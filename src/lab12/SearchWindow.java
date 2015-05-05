package lab12;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SearchWindow {

    public static final int NUMBER_OF_VALUES = 2;

    private int dialogOKCancelResult = 0;

    private JTextField txtSearch = new JTextField(15);
    private JRadioButton rbtnLName = new JRadioButton("Last Name");
    private JRadioButton rbtnFName = new JRadioButton("First Name");
    private JRadioButton rbtnStreet = new JRadioButton("Street Address");
    private JRadioButton rbtnCity = new JRadioButton("City");
    private JRadioButton rbtnState = new JRadioButton("State");
    private JRadioButton rbtnEmail = new JRadioButton("Email");
    private JRadioButton rbtnPhone = new JRadioButton("Phone");
    private JRadioButton rbtnBirthday = new JRadioButton("Birthday");

    private Object[] returnValues = new Object[NUMBER_OF_VALUES];

    public void run() {
	JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
	panel.add(rbtnLName);
	panel.add(rbtnFName);
	panel.add(rbtnStreet);
	panel.add(rbtnCity);
	panel.add(rbtnState);
	panel.add(rbtnEmail);
	panel.add(rbtnPhone);
	panel.add(rbtnBirthday);

	ButtonGroup bg = new ButtonGroup();
	bg.add(rbtnLName);
	bg.add(rbtnFName);
	bg.add(rbtnStreet);
	bg.add(rbtnCity);
	bg.add(rbtnState);
	bg.add(rbtnEmail);
	bg.add(rbtnPhone);
	bg.add(rbtnBirthday);

	rbtnLName.setSelected(true);

	String btnSearchStr = "Search";
	String btnCancelStr = "Cancel";

	Object[] array = { txtSearch, panel };
	Object[] options = { btnSearchStr, btnCancelStr };

	dialogOKCancelResult = JOptionPane.showOptionDialog(null, array,
		"Search For Contact", JOptionPane.YES_NO_OPTION,
		JOptionPane.PLAIN_MESSAGE, null, options, null);

	txtSearch.requestFocusInWindow();

	if (dialogOKCancelResult == JOptionPane.OK_OPTION) {
	    returnValues[0] = txtSearch.getText();
	    returnValues[1] = getSelected();
	} else {
	    return;
	}
    }

    private String getSelected() {
	String str = "";

	if (rbtnLName.isSelected()) {
	    str = rbtnLName.getText();
	} else if (rbtnFName.isSelected()) {
	    str = rbtnFName.getText();
	} else if (rbtnStreet.isSelected()) {
	    str = rbtnStreet.getText();
	} else if (rbtnCity.isSelected()) {
	    str = rbtnCity.getText();
	} else if (rbtnState.isSelected()) {
	    str = rbtnState.getText();
	} else if (rbtnEmail.isSelected()) {
	    str = rbtnEmail.getText();
	} else if (rbtnPhone.isSelected()) {
	    str = rbtnPhone.getText();
	} else if (rbtnBirthday.isSelected()) {
	    str = rbtnBirthday.getText();
	}

	return str;
    }

    public Object[] getReturnValues() {
	return returnValues;
    }

    public int getDialogOKCancelResult() {
	return dialogOKCancelResult;
    }
}