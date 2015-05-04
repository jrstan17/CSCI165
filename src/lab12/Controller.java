package lab12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Calendar;
import java.util.Collections;
import java.util.regex.Pattern;

public class Controller {

    // create views
    private View view = new View();
    private FindView fv;

    // create services
    private ContactService cs = new ContactService();

    private int contactIndex = 0;

    public Controller() {
	this.view.getMainFrame().setVisible(true);
	this.view.addActionListener(new AListener());
	this.view.getMainFrame().addWindowListener(new WListener());

	Contact firstContact = cs.getContacts().get(0);

	view.updateViewWithContact(firstContact, contactIndex + 1, cs
		.getContacts().size());
	view.toggleFirstAndPrevButtons(false);
	
	if (cs.getContacts().size() == 1){
	    view.toggleLastAndNextButtons(false);
	}

	bDayCheck(firstContact);
    }

    private boolean isBDayToday(Contact c) {
	GregorianCalendarExtended today = new GregorianCalendarExtended();

	if (c.getBirthday() != null) {
	    return (today.get(Calendar.MONTH) == c.getBirthday().get(
		    Calendar.MONTH) && today.get(Calendar.DATE) == c
		    .getBirthday().get(Calendar.DATE));
	} else {
	    return false;
	}
    }

    private void bDayCheck(Contact contact) {
	if (isBDayToday(contact)) {
	    Messages.showBDayMessage(view.getMainFrame(), view.getTxtFName()
		    .getText());
	}
    }

    private class WListener implements WindowListener {

	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
	    if (saveContact() == 0) {
		view.getMainFrame().dispose();
		System.exit(0);
	    }
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}
    }

    private class AListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {

	    if (e.getSource() == view.getBtnFirst()) {
		btnFirstPressed();
	    } else if (e.getSource() == view.getBtnPrevious()) {
		btnPreviousPressed();
	    } else if (e.getSource() == view.getBtnNext()) {
		btnNextPressed();
	    } else if (e.getSource() == view.getBtnLast()) {
		btnLastPressed();
	    } else if (e.getSource() == view.getBtnNew()) {
		btnNewPressed();
	    } else if (e.getSource() == view.getBtnDelete()) {
		btnDeletePressed();
	    } else if (e.getSource() == view.getBtnFind()) {
		btnFindPressed();
	    }
	}
    }

    public void btnFindPressed() {
	view.getMainFrame().setEnabled(false);
	fv = new FindView(view.getMainFrame());
    }

    public void btnDeletePressed() {

	int messageResult = Messages.showDeleteContactMessage(view
		.getMainFrame(), view.getTxtFName().getText(), view
		.getTxtLName().getText());

	if (messageResult == 0) {

	    cs.getContacts().remove(contactIndex);

	    if (contactIndex < cs.getContacts().size()) {
		Contact c = cs.getContacts().get(contactIndex);
		view.updateViewWithContact(c, contactIndex + 1, cs
			.getContacts().size());
	    } else {
		contactIndex--;
		Contact c = cs.getContacts().get(contactIndex);
		cs.writeContactsToFile();
		view.updateViewWithContact(c, contactIndex + 1, cs
			.getContacts().size());
	    }

	    if (cs.getContacts().size() == 1) {
		view.getBtnDelete().setEnabled(false);
		view.toggleFirstAndPrevButtons(false);
		view.toggleLastAndNextButtons(false);
	    }
	}
    }

    public void btnNewPressed() {
	if (saveContact() == 0) {
	    view.clearFields();
	    contactIndex = cs.getContacts().size();
	    cs.getContacts().add(new Contact());

	    if (!view.getBtnDelete().isEnabled()) {
		view.getBtnDelete().setEnabled(true);
	    }
	    
	    view.toggleFirstAndPrevButtons(true);
	    view.toggleLastAndNextButtons(false);

	    view.getTxtFName().requestFocusInWindow();
	}
    }

    public int saveContact() {
	String birthdayText = view.getTxtBirthday().getText();

	if (!Pattern.matches(GregorianCalendarExtended.DATE_FORMAT,
		birthdayText) && !birthdayText.isEmpty()) {
	    Messages.showDateIncorrectFormatMessage(view.getMainFrame());
	    view.getTxtBirthday().requestFocusInWindow();
	    view.getTxtBirthday().selectAll();
	    return -1;
	}

	if (view.getTxtLName().getText().isEmpty()) {
	    Messages.showLNameMissingMessage(view.getMainFrame());
	    view.getTxtLName().requestFocusInWindow();
	    return -1;
	}

	Contact contact = cs.getContacts().get(contactIndex);

	contact.setFName(view.getTxtFName().getText());
	contact.setLName(view.getTxtLName().getText());
	contact.getAddress().setStreet(view.getTxtStreet().getText());
	contact.getAddress().setCity(view.getTxtCity().getText());
	contact.getAddress().setState(
		(String) view.getCmbState().getSelectedItem());
	contact.getAddress().setZip(view.getTxtZip().getText());
	contact.setEmail(view.getTxtEmail().getText());
	contact.getPhone().setPhoneNumber(view.getTxtPhone().getText());

	if (!birthdayText.isEmpty()) {
	    contact.setBirthday(new GregorianCalendarExtended(birthdayText));
	}

	contact.setNotes(view.getNotesText().getText());

	cs.writeContactsToFile();

	Collections.sort(cs.getContacts());

	return 0;
    }

    private void btnFirstPressed() {
	if (saveContact() == 0) {
	    if (contactIndex != 0) {
		contactIndex = 0;
		Contact contact = cs.getContacts().get(contactIndex);
		view.updateViewWithContact(contact, contactIndex + 1, cs
			.getContacts().size());
		view.toggleFirstAndPrevButtons(false);
		view.toggleLastAndNextButtons(true);

		bDayCheck(contact);
	    }
	}
    }

    public void btnLastPressed() {
	if (saveContact() == 0) {
	    if (contactIndex != cs.getContacts().size() - 1) {
		contactIndex = cs.getContacts().size() - 1;
		Contact contact = cs.getContacts().get(contactIndex);
		view.updateViewWithContact(contact, contactIndex + 1, cs
			.getContacts().size());
		view.toggleFirstAndPrevButtons(true);
		view.toggleLastAndNextButtons(false);

		bDayCheck(contact);
	    }
	}
    }

    public void btnNextPressed() {
	if (saveContact() == 0) {
	    view.toggleFirstAndPrevButtons(true);
	    
	    if (contactIndex == cs.getContacts().size() - 2) {
		view.toggleFirstAndPrevButtons(true);
		view.toggleLastAndNextButtons(false);
	    }
	    contactIndex++;
	    Contact contact = cs.getContacts().get(contactIndex);
	    view.updateViewWithContact(contact, contactIndex + 1, cs
		    .getContacts().size());

	    bDayCheck(contact);
	}
    }

    public void btnPreviousPressed() {
	if (saveContact() == 0) {

	    if (contactIndex == 1) {
		view.toggleFirstAndPrevButtons(false);
		view.toggleLastAndNextButtons(true);
	    }
	    else if (contactIndex != cs.getContacts().size()){
		view.toggleLastAndNextButtons(true);		
	    }
	    contactIndex--;
	    Contact contact = cs.getContacts().get(contactIndex);
	    view.updateViewWithContact(contact, contactIndex + 1, cs
		    .getContacts().size());

	    bDayCheck(contact);

	}
    }

    // public static void main(String[] args) {
    // ContactService cs = new ContactService();
    // Random rnd = new Random();
    //
    // for (int i = 0; i <= 1000; i++){
    // cs.getContacts().add(new Contact());
    //
    // Contact c = cs.getContacts().get(i);
    //
    // c.setFName(Integer.toString(i));
    // c.setLName(Integer.toString(rnd.nextInt(1000000) + 100000));
    // c.getAddress().setCity(Integer.toString(rnd.nextInt(1000000) + 100000));
    // c.getAddress().setState(States.NY);
    // c.getAddress().setStreet(Integer.toString(rnd.nextInt(1000000) + 100000)
    // + " Buck Road");
    // c.getAddress().setZip(Integer.toString(rnd.nextInt(1000000) + 100000));
    // c.setBirthday(new GregorianCalendarExtended("12/30/1982"));
    // c.setEmail(Integer.toString(rnd.nextInt(1000000) + 100000));
    // c.setNotes(Integer.toString(rnd.nextInt(1000000) + 100000));
    // c.setPhone(new PhoneNumber(Integer.toString(rnd.nextInt(1000000) +
    // 100000)));
    // }
    //
    // cs.writeContactsToFile();
    // }

}
