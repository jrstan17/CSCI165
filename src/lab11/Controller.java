package lab11;

import java.io.FileNotFoundException;

import javax.swing.SwingUtilities;

public class Controller {

    LoginWindow window;
    TextFileService service;

    public void run() {
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		window = new LoginWindow();
	    }
	});

	try {
	    service = new TextFileService();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}
	
	service.populateAccountsFromFile();
    }
    
    public void login(){
	
    }
}
