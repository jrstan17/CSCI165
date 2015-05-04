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

	view.updateViewWithContact(firstContact);

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
	    } else if (e.getSource() == view.getBtnAdd()) {
		btnAddPressed();
	    } else if (e.getSource() == view.getBtnDelete()) {
		btnDeletePressed();
	    } else if (e.getSource() == view.getBtnFind()) {
		btnFindPressed();
	    }
	}
    }

    private void btnFirstPressed() {
	if (saveContact() == 0) {
	    if (contactIndex != 0) {
		contactIndex = 0;
		Contact contact = cs.getContacts().get(contactIndex);
		view.updateViewWithContact(contact);

		bDayCheck(contact);
	    }
	}
    }

    public void btnFindPressed() {
	view.setEnabled(false);
	fv = new FindView();
	fv.setVisible(true);
    }

    public void btnDeletePressed() {
	int messageResult = Messages.showDeleteContactMessage(view
		.getMainFrame(), view.getTxtFName().getText(), view
		.getTxtLName().getText());

	if (messageResult == 0) {
	    if (cs.getContacts().size() == 1) {
		Messages.showMustHaveOneMessage(view);
		view.getTxtFName().requestFocusInWindow();
		view.getTxtFName().selectAll();
		return;
	    }

	    cs.getContacts().remove(contactIndex);

	    if (contactIndex < cs.getContacts().size()) {
		Contact c = cs.getContacts().get(contactIndex);
		view.updateViewWithContact(c);
	    } else {
		contactIndex--;
		Contact c = cs.getContacts().get(contactIndex);
		cs.writeContactsToFile();
		view.updateViewWithContact(c);
	    }
	}
    }

    public void btnAddPressed() {
	if (saveContact() == 0) {
	    view.clearFields();
	    contactIndex = cs.getContacts().size();
	    cs.getContacts().add(new Contact());
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

    public void btnLastPressed() {
	if (saveContact() == 0) {
	    if (contactIndex != cs.getContacts().size() - 1) {
		contactIndex = cs.getContacts().size() - 1;
		Contact contact = cs.getContacts().get(contactIndex);
		view.updateViewWithContact(contact);

		bDayCheck(contact);
	    }
	}
    }

    public void btnNextPressed() {
	if (saveContact() == 0) {
	    if (contactIndex < cs.getContacts().size() - 1) {
		contactIndex++;
		Contact contact = cs.getContacts().get(contactIndex);
		view.updateViewWithContact(contact);

		bDayCheck(contact);
	    }
	}
    }

    public void btnPreviousPressed() {
	if (saveContact() == 0) {
	    if (contactIndex > 0) {
		contactIndex--;
		Contact contact = cs.getContacts().get(contactIndex);
		view.updateViewWithContact(contact);

		bDayCheck(contact);
	    }
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
