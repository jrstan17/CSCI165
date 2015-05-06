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

  private static final int NAV_BUTTONS = 4;
  private static final int TEXT_FIELDS = 9;
  private static final int FORM_COLUMNS = 2;
  private static final int GAP = 5;
  private static final int TEXT_AREA_ROWS = 16;
  private static final int TEXT_AREA_COLUMNS = 33;
  private static final int FRAME_WIDTH = 400;
  private static final int FRAME_HEIGHT = 400;
  private static final int RIGID_AREA_WIDTH = 20;
  private static final int RIGID_AREA_HEIGHT = 1;

  private JFrame mainFrame;

  // define GUI elements
  // NORTH AREA
  private JPanel north = new JPanel(new GridLayout(1, NAV_BUTTONS));

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

  private JPanel form = new JPanel(new GridLayout(TEXT_FIELDS, FORM_COLUMNS,
      GAP, GAP));

  private JPanel notes = new JPanel();
  private JScrollPane jsp = new JScrollPane();

  private JTextArea notesText = new JTextArea(TEXT_AREA_ROWS,
      TEXT_AREA_COLUMNS);

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
    mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
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
    south.add(Box.createRigidArea(new Dimension(RIGID_AREA_WIDTH,
        RIGID_AREA_HEIGHT)));
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
    notes.add(BorderLayout.CENTER, notesText);
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

  public final void addActionListener(final ActionListener al) {

    btnFirst.addActionListener(al);
    btnPrevious.addActionListener(al);
    btnNext.addActionListener(al);
    btnLast.addActionListener(al);
    btnNew.addActionListener(al);
    btnDelete.addActionListener(al);
    btnFind.addActionListener(al);
  }

  public final void addWindowListener(final WindowAdapter wa) {
    mainFrame.addWindowListener(wa);
  }

  public final void updateViewWithContact(final Contact contact,
      final int current, final int total) {
    
    lblCurrentContact.setText("Entry " + current + " of " + total);
    lblCurrentContact.setVisible(true);
    
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
    }
    else {
      txtBirthday.setText("");
    }

    notesText.setText(contact.getNotes());

    if (!txtFName.getText().isEmpty() || !txtLName.getText().isEmpty()) {
      mainFrame.setTitle(contact.getLName() + ", " + contact.getFName());
    }

    if (current == total) {
      toggleFirstAndPrevButtons(true);
      toggleLastAndNextButtons(false);
    }
    else if (current == 1) {
      toggleFirstAndPrevButtons(false);
      toggleLastAndNextButtons(true);
    }
    else {
      toggleFirstAndPrevButtons(true);
      toggleLastAndNextButtons(true);
    }
  }

  public final void clearFields() {
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

  public final void clearEntryLabel() {
    lblCurrentContact.setVisible(false);
  }

  public final void toggleFirstAndPrevButtons(final boolean enabled) {
    if (enabled) {
      btnFirst.setEnabled(true);
      btnPrevious.setEnabled(true);
    }
    else {
      btnFirst.setEnabled(false);
      btnPrevious.setEnabled(false);
    }
  }

  public final void toggleLastAndNextButtons(final boolean enabled) {
    if (enabled) {
      btnLast.setEnabled(true);
      btnNext.setEnabled(true);
    }
    else {
      btnLast.setEnabled(false);
      btnNext.setEnabled(false);
    }
  }

  public final JButton getBtnFirst() {
    return btnFirst;
  }

  public final JButton getBtnPrevious() {
    return btnPrevious;
  }

  public final JButton getBtnNext() {
    return btnNext;
  }

  public final JButton getBtnLast() {
    return btnLast;
  }

  public final JButton getBtnNew() {
    return btnNew;
  }

  public final JButton getBtnDelete() {
    return btnDelete;
  }

  public final JButton getBtnFind() {
    return btnFind;
  }

  public final JTextArea getNotesText() {
    return notesText;
  }

  public final void setNotesText(final JTextArea notesText) {
    this.notesText = notesText;
  }

  public final JTextField getTxtFName() {
    return txtFName;
  }

  public final void setTxtFName(final JTextField txtFName) {
    this.txtFName = txtFName;
  }

  public final JTextField getTxtLName() {
    return txtLName;
  }

  public final void setTxtLName(final JTextField txtLName) {
    this.txtLName = txtLName;
  }

  public final JTextField getTxtStreet() {
    return txtStreet;
  }

  public final void setTxtStreet(final JTextField txtStreet) {
    this.txtStreet = txtStreet;
  }

  public final JTextField getTxtCity() {
    return txtCity;
  }

  public final void setTxtCity(final JTextField txtCity) {
    this.txtCity = txtCity;
  }

  public final JTextField getTxtZip() {
    return txtZip;
  }

  public final void setTxtZip(final JTextField txtZip) {
    this.txtZip = txtZip;
  }

  public final JTextField getTxtEmail() {
    return txtEmail;
  }

  public final void setTxtEmail(final JTextField txtEmail) {
    this.txtEmail = txtEmail;
  }

  public final JTextField getTxtPhone() {
    return txtPhone;
  }

  public final void setTxtPhone(final JTextField txtPhone) {
    this.txtPhone = txtPhone;
  }

  public final JTextField getTxtBirthday() {
    return txtBirthday;
  }

  public final void setTxtBirthday(final JTextField txtBirthday) {
    this.txtBirthday = txtBirthday;
  }

  public final JComboBox<String> getCmbState() {
    return cmbState;
  }

  public final void setCmbState(final JComboBox<String> cmbState) {
    this.cmbState = cmbState;
  }

  public final JFrame getMainFrame() {
    return mainFrame;
  }

  public final void setLblCurrentContact(final JLabel lblCurrentContact) {
    this.lblCurrentContact = lblCurrentContact;
  }
}
