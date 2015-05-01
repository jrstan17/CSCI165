package lab11;

import javax.swing.SwingUtilities;

public class Driver {

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		@SuppressWarnings("unused")
		Controller c = new Controller();
	    }
	});
    }
}