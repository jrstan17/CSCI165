package lab12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Controller {
    private View view = new View();
    private ContactService cs = new ContactService();
    private int contactIndex = 0;

    public Controller() {
	this.view.setVisible(true);
	this.view.addListener(new Listener());

	Contact firstContact = cs.getContacts().get(contactIndex);
	view.updateViewWithContact(firstContact);
    }

    private class Listener implements ActionListener {

	public void actionPerformed(ActionEvent e) {

	    if (e.getSource() == view.getBtnFirst()) {
		btnFirstPressed();
	    } else if (e.getSource() == view.getBtnPrevious()) {
		btnPreviousPressed();
	    } else if (e.getSource() == view.getBtnNext()) {
		btnNextPressed();
	    } else if (e.getSource() == view.getBtnLast()) {
		btnLastPressed();
	    } else if (e.getSource() == view.getBtnSave()) {
		btnSavePressed();
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
	if (contactIndex != 0) {
	    contactIndex = 0;
	    Contact contact = cs.getContacts().get(contactIndex);
	    view.updateViewWithContact(contact);
	}
    }

    public void btnFindPressed() {
	// TODO Auto-generated method stub

    }

    public void btnDeletePressed() {
	cs.getContacts().remove(contactIndex);

	if (contactIndex < cs.getContacts().size()) {
	    Contact c = cs.getContacts().get(contactIndex);
	    view.updateViewWithContact(c);
	}
	else{
	    contactIndex--;
	    Contact c = cs.getContacts().get(contactIndex);
	    cs.writeContactsToFile();
	    view.updateViewWithContact(c);
	}	
    }

    public void btnAddPressed() {
	view.clearFields();
	contactIndex = cs.getContacts().size();
	cs.getContacts().add(new Contact());
	
    }

    public void btnSavePressed() {	
	if (!Pattern.matches(GregorianCalendarExtended.DATE_FORMAT, view.getTxtBirthday().getText())){
	    view.showDateIncorrectFormatMessage();
	    return;
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
	contact.setBirthday(new GregorianCalendarExtended(view.getTxtBirthday().getText()));	
	contact.setNotes(view.getNotesText().getText());

	cs.writeContactsToFile();
    }

    public void btnLastPressed() {
	if (contactIndex != cs.getContacts().size() - 1) {
	    contactIndex = cs.getContacts().size() - 1;
	    Contact contact = cs.getContacts().get(contactIndex);
	    view.updateViewWithContact(contact);
	}

    }

    public void btnNextPressed() {
	if (contactIndex < cs.getContacts().size() - 1) {
	    contactIndex++;
	    Contact contact = cs.getContacts().get(contactIndex);
	    view.updateViewWithContact(contact);
	}
    }

    public void btnPreviousPressed() {
	if (contactIndex > 0) {
	    contactIndex--;
	    Contact contact = cs.getContacts().get(contactIndex);
	    view.updateViewWithContact(contact);
	}
    }

}
