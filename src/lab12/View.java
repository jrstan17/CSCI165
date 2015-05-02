package lab12;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

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

    // define GUI elements
    // NORTH AREA
    JPanel north = new JPanel(new GridLayout(1, 4));

    JButton btnFirst = new JButton("|<<");
    JButton btnPrevious = new JButton("<<");
    JButton btnNext = new JButton(">>");
    JButton btnLast = new JButton(">>|");

    // SOUTH AREA
    JPanel south = new JPanel();
    JButton btnSave = new JButton("SAVE");
    JButton btnAdd = new JButton("ADD");
    JButton btnDelete = new JButton("DELETE");
    JButton btnFind = new JButton("FIND");

    // CENTER AREA
    JTabbedPane center = new JTabbedPane();
    JPanel form = new JPanel(new GridLayout(8, 2, 5, 5));
    JPanel notes = new JPanel();
    JScrollPane jsp = new JScrollPane();
    JTextArea notesText = new JTextArea(10, 30);
    JTextField txtFName = new JTextField();
    JTextField txtLName = new JTextField();
    JTextField txtStreet = new JTextField();
    JTextField txtCity = new JTextField();
    JTextField txtZip = new JTextField();
    JTextField txtEmail = new JTextField();
    JTextField txtPhone = new JTextField();
    JComboBox<String> cmbState = new JComboBox<String>();

    public View() {

	setTitle("Contacts");

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
	

	// add states to combo box
	for (int i = 0; i < States.NUMBER_OF_STATES_AND_DC; i++){
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
	
	txtFName.addActionListener(al);
    }
    
    public void updateViewWithContact (Contact contact){
	txtFName.setText(contact.getFName());
	txtLName.setText(contact.getLName());
	txtStreet.setText(contact.getAddress().getStreet());
	txtCity.setText(contact.getAddress().getCity());
	cmbState.setSelectedItem(contact.getAddress().getState().displayName());
	txtZip.setText(contact.getAddress().getZip());
	txtEmail.setText(contact.getEmail());
	txtPhone.setText(contact.getPhone().getPhoneNumber());
	notesText.setText(contact.getNotes());
    }

    public JButton getBtnFirst() {
        return btnFirst;
    }

    public void setBtnFirst(JButton btnFirst) {
        this.btnFirst = btnFirst;
    }

    public JButton getBtnPrevious() {
        return btnPrevious;
    }

    public void setBtnPrevious(JButton btnPrevious) {
        this.btnPrevious = btnPrevious;
    }

    public JButton getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(JButton btnNext) {
        this.btnNext = btnNext;
    }

    public JButton getBtnLast() {
        return btnLast;
    }

    public void setBtnLast(JButton btnLast) {
        this.btnLast = btnLast;
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }

    public JButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public JButton getBtnFind() {
        return btnFind;
    }

    public void setBtnFind(JButton btnFind) {
        this.btnFind = btnFind;
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

    public JComboBox<String> getCmbState() {
        return cmbState;
    }

    public void setCmbState(JComboBox<String> cmbState) {
        this.cmbState = cmbState;
    }
}
