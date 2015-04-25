package lab11;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;

public class LoginWindow extends JFrame implements ActionListener {

    private JPasswordField pwField = new JPasswordField();
    private JButton btnLogin = new JButton("Login");
    private JButton btnCancel = new JButton("Cancel");

    public LoginWindow() {
	// add GUI objects to the Frame
	add(pwField, BorderLayout.NORTH);
	add(btnCancel, BorderLayout.WEST);
	add(btnLogin, BorderLayout.EAST);

	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	pack();
	setVisible(true);
    }

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		new LoginWindow();
	    }
	});

    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
    }

}
