package lab12;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class FindView extends JFrame {

    // define GUI elements
    // NORTH AREA
    private JPanel north = new JPanel(new GridLayout(1, 4));

    private JButton btnFirst = new JButton("|<<");
    private JButton btnPrevious = new JButton("<<");
    private JButton btnNext = new JButton(">>");
    private JButton btnLast = new JButton(">>|");

    // SOUTH AREA
    private JPanel south = new JPanel();
    private JButton btnSave = new JButton("SAVE");
    private JButton btnAdd = new JButton("ADD");
    private JButton btnDelete = new JButton("DELETE");
    private JButton btnFind = new JButton("FIND");

    // CENTER AREA
    private JTabbedPane center = new JTabbedPane();
    private JPanel form = new JPanel(new GridLayout(9, 2, 5, 5));
    private JPanel notes = new JPanel();
    private JScrollPane jsp = new JScrollPane();
    private JTextArea notesText = new JTextArea(10, 30);
    private JTextField txtFName = new JTextField();
    private JTextField txtLName = new JTextField();
    private JTextField txtStreet = new JTextField();
    private JTextField txtCity = new JTextField();
    private JComboBox<String> cmbState = new JComboBox<String>();
    private JTextField txtZip = new JTextField();
    private JTextField txtEmail = new JTextField();
    private JTextField txtPhone = new JTextField();
    private JTextField txtBirthday = new JTextField();

    public FindView() {

	// get reference to JFrame content pane
	Container c = getContentPane();

	// add buttons to NORTH panel
	north.add(btnFirst);
	north.add(btnPrevious);
	north.add(btnNext);
	north.add(btnLast);

	// add NORTH panel to JFrame via the ContentPane
	c.add(north, BorderLayout.NORTH);

	// add buttons to SOUTH panel
	south.add(btnSave);
	south.add(btnAdd);
	south.add(btnDelete);
	south.add(btnFind);

	// add SOUTH panel to JFrame via the ContentPane
	c.add(south, BorderLayout.SOUTH);

	// add text fields and labels to JPanel
	form.add(new JLabel("First Name"));
	form.add(txtFName);
	form.add(new JLabel("Last Name"));
	form.add(txtLName);
	form.add(new JLabel("Street Address"));
	form.add(txtStreet);
	form.add(new JLabel("City"));
	form.add(txtCity);
	form.add(new JLabel("State"));
	form.add(cmbState);
	form.add(new JLabel("Zip Code"));
	form.add(txtZip);
	form.add(new JLabel("Email"));
	form.add(txtEmail);
	form.add(new JLabel("Phone"));
	form.add(txtPhone);
	form.add(new JLabel("Birthday"));
	form.add(txtBirthday);

	// add state elements to combo box
	for (int i = 0; i < States.ELEMENTS; i++) {
	    cmbState.addItem(States.getStatesArray()[i].displayName());
	}

	// add FORM to Tabbed area
	center.add(form);
	notes.add(notesText);
	jsp.getViewport().add(notes);
	center.add(jsp);
	notesText.setLineWrap(true);
	c.add(center);

	// give tabs some descriptive text
	center.setTitleAt(0, "Contact Info");
	center.setTitleAt(1, "Notes");

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pack();
    }

    public void addListener(ActionListener al) {

	btnFirst.addActionListener(al);
	btnPrevious.addActionListener(al);
	btnNext.addActionListener(al);
	btnLast.addActionListener(al);
	btnSave.addActionListener(al);
	btnAdd.addActionListener(al);
	btnDelete.addActionListener(al);
	btnFind.addActionListener(al);
    }

    public void updateViewWithContact(Contact contact) {
	txtFName.setText(contact.getFName());
	txtLName.setText(contact.getLName());
	txtStreet.setText(contact.getAddress().getStreet());
	txtCity.setText(contact.getAddress().getCity());
	cmbState.setSelectedItem(contact.getAddress().getState().displayName());
	txtZip.setText(contact.getAddress().getZip());
	txtEmail.setText(contact.getEmail());
	txtPhone.setText(contact.getPhone().getPhoneNumber());
	txtBirthday.setText(contact.getBirthday().toString());
	notesText.setText(contact.getNotes());

	if (!txtFName.getText().isEmpty() || !txtLName.getText().isEmpty()) {
	    setTitle(contact.getLName() + ", " + contact.getFName());
	}
    }

    public void clearFields() {
	getTxtFName().setText("");
	getTxtLName().setText("");
	getTxtStreet().setText("");
	getCmbState().setSelectedIndex(0);
	getTxtCity().setText("");
	getTxtZip().setText("");
	getTxtEmail().setText("");
	getTxtPhone().setText("");
	getTxtBirthday().setText("");
	setTitle("Contacts");
    }

    public void showDateIncorrectFormatMessage() {
	JOptionPane.showMessageDialog(this,
		"The birthdate is not in the correct format.\nMM/DD/YYYY.",
		"Incorrect Date Format", JOptionPane.ERROR_MESSAGE);
    }

    public void showMustHaveOneMessage() {
	JOptionPane.showMessageDialog(this,
		"You must have at least one contact. Cannot delete.",
		"Cannot Delete Contact", JOptionPane.WARNING_MESSAGE);
    }

    public JButton getBtnFirst() {
	return btnFirst;
    }

    public JButton getBtnPrevious() {
	return btnPrevious;
    }

    public JButton getBtnNext() {
	return btnNext;
    }

    public JButton getBtnLast() {
	return btnLast;
    }

    public JButton getBtnSave() {
	return btnSave;
    }

    public JButton getBtnAdd() {
	return btnAdd;
    }

    public JButton getBtnDelete() {
	return btnDelete;
    }

    public JButton getBtnFind() {
	return btnFind;
    }

    public JTextArea getNotesText() {
	return notesText;
    }

    public void setNotesText(JTextArea notesText) {
	this.notesText = notesText;
    }

    public JTextField getTxtFName() {
	return txtFName;
    }

    public void setTxtFName(JTextField txtFName) {
	this.txtFName = txtFName;
    }

    public JTextField getTxtLName() {
	return txtLName;
    }

    public void setTxtLName(JTextField txtLName) {
	this.txtLName = txtLName;
    }

    public JTextField getTxtStreet() {
	return txtStreet;
    }

    public void setTxtStreet(JTextField txtStreet) {
	this.txtStreet = txtStreet;
    }

    public JTextField getTxtCity() {
	return txtCity;
    }

    public void setTxtCity(JTextField txtCity) {
	this.txtCity = txtCity;
    }

    public JTextField getTxtZip() {
	return txtZip;
    }

    public void setTxtZip(JTextField txtZip) {
	this.txtZip = txtZip;
    }

    public JTextField getTxtEmail() {
	return txtEmail;
    }

    public void setTxtEmail(JTextField txtEmail) {
	this.txtEmail = txtEmail;
    }

    public JTextField getTxtPhone() {
	return txtPhone;
    }

    public void setTxtPhone(JTextField txtPhone) {
	this.txtPhone = txtPhone;
    }

    public JTextField getTxtBirthday() {
	return txtBirthday;
    }

    public void setTxtBirthday(JTextField txtBirthday) {
	this.txtBirthday = txtBirthday;
    }

    public JComboBox<String> getCmbState() {
	return cmbState;
    }

    public void setCmbState(JComboBox<String> cmbState) {
	this.cmbState = cmbState;
    }
}
