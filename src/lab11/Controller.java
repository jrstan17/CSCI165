package lab11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Controller {

    LoginWindow window;
    TextFileService service;
    
    public static void main(String[] args) {
	Controller controller = new Controller();
	controller.window.setVisible(true);
    }

    public Controller() {
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		window = new LoginWindow();
	    }
	});

	window.addButtonActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(window, "Eggs are not supposed to be green.");
		
	    }
	});

	try {
	    service = new TextFileService();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

	service.populateAccountsFromFile();
    }
}
