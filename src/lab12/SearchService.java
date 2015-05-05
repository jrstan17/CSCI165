package lab12;

import java.util.ArrayList;

public class SearchService {

    private String searchText;
    private String selectedRadioBtnName;
    private ArrayList<Contact> contacts;

    public SearchService(Object[] objects, ArrayList<Contact> contacts) {
	searchText = objects[0].toString();
	selectedRadioBtnName = objects[1].toString();
	this.contacts = contacts;

	System.out.println(searchText);
    }

    public int search() {
	int contactIndex = 0;

	if (selectedRadioBtnName.equals("Last Name")) {
	    for (Contact contact : contacts) {
		if (contact.getLName().equals(searchText)) {
		    contactIndex = contacts.indexOf(contact);
		}
	    }
	} else if (selectedRadioBtnName.equals("First Name")) {
	    for (Contact contact : contacts) {
		if (contact.getFName().equals(searchText)) {
		    contactIndex = contacts.indexOf(contact);
		}
	    }
	} else if (selectedRadioBtnName.equals("Street Address")) {
	    for (Contact contact : contacts) {
		if (contact.getAddress().getStreet().equals(searchText)) {
		    contactIndex = contacts.indexOf(contact);
		}
	    }
	} else if (selectedRadioBtnName.equals("City")) {
	    for (Contact contact : contacts) {
		if (contact.getAddress().getCity().equals(searchText)) {
		    contactIndex = contacts.indexOf(contact);
		}
	    }
	} else if (selectedRadioBtnName.equals("State")) {
	    for (Contact contact : contacts) {
		if (contact.getAddress().getState().displayName()
			.equals(searchText)
			|| contact.getAddress().getState().name()
				.equals(searchText)) {
		    contactIndex = contacts.indexOf(contact);
		}
	    }
	} else if (selectedRadioBtnName.equals("Email")) {
	    for (Contact contact : contacts) {
		if (contact.getEmail().equals(searchText)) {
		    contactIndex = contacts.indexOf(contact);
		}
	    }
	} else if (selectedRadioBtnName.equals("Phone")) {
	    for (Contact contact : contacts) {
		PhoneNumber temp = new PhoneNumber(searchText);

		if (contact.getPhone().getPhoneNumber()
			.equals(temp.getPhoneNumber())) {
		    contactIndex = contacts.indexOf(contact);
		}
	    }
	} else if (selectedRadioBtnName.equals("Birthday")) {
	    for (Contact contact : contacts) {
		if (contact.getBirthday() != null) {
		    if (contact.getBirthday().toString().equals(searchText)) {
			contactIndex = contacts.indexOf(contact);
		    }
		}
	    }
	}

	if (contactIndex == 0) {
	    contactIndex = -1;
	}

	return contactIndex;
    }
}
