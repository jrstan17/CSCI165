package lab12;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class View extends JFrame {

    private JFrame mainFrame;

    // define GUI elements
    // NORTH AREA
    private JPanel north = new JPanel(new GridLayout(1, 4));

    private JButton btnFirst = new JButton("|<<");
    private JButton btnPrevious = new JButton("<<");
    private JButton btnNext = new JButton(">>");
    private JButton btnLast = new JButton(">>|");

    // SOUTH AREA
    private JPanel south = new JPanel();
    private JLabel lblCurrentContact = new JLabel("Entry 1 of 1");
    private JButton btnNew = new JButton("NEW");
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

    public View() {
	// get reference to JFrame content pane
	mainFrame = new JFrame();
	mainFrame.setSize(400, 400);
	mainFrame.setLayout(new BorderLayout());

	// add buttons to NORTH panel
	north.add(btnFirst);
	north.add(btnPrevious);
	north.add(btnNext);
	north.add(btnLast);

	// add NORTH panel to JFrame via the ContentPane
	mainFrame.add(north, BorderLayout.NORTH);

	// add buttons to SOUTH panel
	south.add(btnNew);
	south.add(btnDelete);
	south.add(btnFind);	
		south.add(Box.createRigidArea(new Dimension(20,1)));
	south.add(lblCurrentContact);

	// add SOUTH panel to JFrame via the ContentPane
	mainFrame.add(south, BorderLayout.SOUTH);

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
	mainFrame.add(center);

	// give tabs some descriptive text
	center.setTitleAt(0, "Contact Info");
	center.setTitleAt(1, "Notes");

	mainFrame.setLocationRelativeTo(null);
	mainFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	pack();
    }

    public void addActionListener(ActionListener al) {

	btnFirst.addActionListener(al);
	btnPrevious.addActionListener(al);
	btnNext.addActionListener(al);
	btnLast.addActionListener(al);
	btnNew.addActionListener(al);
	btnDelete.addActionListener(al);
	btnFind.addActionListener(al);
    }

    public void addWindowListener(WindowAdapter wa) {
	mainFrame.addWindowListener(wa);
    }

    public void updateViewWithContact(Contact contact, int current, int total) {
	lblCurrentContact.setText("Entry " + current + " of " + total);
	txtFName.setText(contact.getFName());
	txtLName.setText(contact.getLName());
	txtStreet.setText(contact.getAddress().getStreet());
	txtCity.setText(contact.getAddress().getCity());
	cmbState.setSelectedItem(contact.getAddress().getState().displayName());
	txtZip.setText(contact.getAddress().getZip());
	txtEmail.setText(contact.getEmail());
	txtPhone.setText(contact.getPhone().getPhoneNumber());

	if (contact.getBirthday() != null) {
	    txtBirthday.setText(contact.getBirthday().toString());
	} else {
	    txtBirthday.setText("");
	}

	notesText.setText(contact.getNotes());

	if (!txtFName.getText().isEmpty() || !txtLName.getText().isEmpty()) {
	    mainFrame.setTitle(contact.getLName() + ", " + contact.getFName());
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
	mainFrame.setTitle("Contacts");
    }
    
    public void toggleFirstAndPrevButtons(boolean enabled){
	if (enabled){
	    btnFirst.setEnabled(true);
	    btnPrevious.setEnabled(true);
	}
	else{
	    btnFirst.setEnabled(false);
	    btnPrevious.setEnabled(false);	    
	}
    }
    
    public void toggleLastAndNextButtons(boolean enabled){
	if (enabled){
	    btnLast.setEnabled(true);
	    btnNext.setEnabled(true);
	}
	else{
	    btnLast.setEnabled(false);
	    btnNext.setEnabled(false);	    
	}
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

    public JButton getBtnNew() {
	return btnNew;
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

    public JFrame getMainFrame() {
	return mainFrame;
    }
}
