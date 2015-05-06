package lab12;

import java.util.ArrayList;

public class SearchService {

  private String searchText;
  private String selectedRadioBtnName;
  private ArrayList<Contact> contacts;

  public SearchService(final Object[] objects, 
      final ArrayList<Contact> contacts) {
    searchText = objects[0].toString();
    selectedRadioBtnName = objects[1].toString();
    this.contacts = contacts;

    System.out.println(searchText);
  }

  public final int search() {
    int contactIndex = -1;

    if (selectedRadioBtnName.equals("Last Name")) {
      for (Contact contact : contacts) {
        if (contact.getLName().equals(StringUtilities.
            toProperNoun(searchText))) {
          contactIndex = contacts.indexOf(contact);
        }
      }
    } else if (selectedRadioBtnName.equals("First Name")) {
      for (Contact contact : contacts) {
        if (contact.getFName().equals(StringUtilities.
            toProperNoun(searchText))) {
          contactIndex = contacts.indexOf(contact);
        }
      }
    } else if (selectedRadioBtnName.equals("Street Address")) {
      for (Contact contact : contacts) {
        if (contact.getAddress().getStreet()
            .equals(StringUtilities.toProperNoun(searchText))) {
          contactIndex = contacts.indexOf(contact);
        }
      }
    } else if (selectedRadioBtnName.equals("City")) {
      for (Contact contact : contacts) {
        if (contact.getAddress().getCity()
            .equals(StringUtilities.toProperNoun(searchText))) {
          contactIndex = contacts.indexOf(contact);
        }
      }
    } else if (selectedRadioBtnName.equals("State")) {
      for (Contact contact : contacts) {
        if (contact.getAddress().getState().displayName().equals(searchText)
            || contact.getAddress().getState().name().equals(searchText)) {
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

        if (contact.getPhone().getPhoneNumber().equals(temp.getPhoneNumber())) {
          contactIndex = contacts.indexOf(contact);
        }
      }
    } else if (selectedRadioBtnName.equals("Birthday MM/DD/YYYY")) {
      for (Contact contact : contacts) {
        if (contact.getBirthday() != null) {
          if (contact.getBirthday().toString().equals(searchText)) {
            contactIndex = contacts.indexOf(contact);
          }
        }
      }
    }

    return contactIndex;
  }
}
