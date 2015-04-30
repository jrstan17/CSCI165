package lab11;

import javax.swing.SwingUtilities;

public class Driver {

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		LoginWindow lw = new LoginWindow();
		TextFileService tfs = new TextFileService();
		Controller c = new Controller(tfs, lw);
	    }
	});
    }
}