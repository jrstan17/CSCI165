package lab12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ContactService {

    private static final String DATA_FILE_LOCATION = "src\\lab12\\data.txt";
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    
    public ContactService(){
	readContactsFromFile();
    }

    public void writeContactsToFile() {
	try {
	    FileOutputStream fos = new FileOutputStream(DATA_FILE_LOCATION);
	    ObjectOutputStream oos = new ObjectOutputStream(fos);
	    
	    Integer size = contacts.size();
	    oos.writeObject(size);

	    for (Contact contact : contacts) {
		oos.writeObject(contact);
	    }
	    
	    oos.close();
	    
	    FileWriter fw = new FileWriter(DATA_FILE_LOCATION,true);
	    fw.write("add a line\n");
	    fw.close();

	    
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public void readContactsFromFile() {

	try {
	    FileInputStream fis = new FileInputStream(DATA_FILE_LOCATION);
	    ObjectInputStream ois = new ObjectInputStream(fis);

	    contacts = new ArrayList<Contact>();
	    
	    Integer numberOfContacts = (Integer)ois.readObject();

	    for(int i = 0; i < numberOfContacts; i++){
		contacts.add((Contact) ois.readObject());
	    }
	    
	    ois.close();

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    contacts.add(new Contact());
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}

    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}