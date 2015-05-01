package lab11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame {

    private JPanel buttonPanel = new JPanel();
    private JPanel textPanel = new JPanel(new GridLayout(2,2,10,10));

    private JTextField txtUserName = new JTextField();
    private JPasswordField txtPassword = new JPasswordField();

    private JButton btnLogin = new JButton("Login");
    private JButton btnNew = new JButton("New Account");
    private JButton btnCancel = new JButton("Cancel");

    public LoginWindow() {
	
	Container c = getContentPane();
	this.setResizable(false);

	// set north
	c.add(textPanel, BorderLayout.NORTH);
	textPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
	textPanel.add(new JLabel("User Name:"));
	textPanel.add(txtUserName);
	textPanel.add(new JLabel("Password:"));
	textPanel.add(txtPassword);
	txtPassword.setColumns(10);

	// set south
	c.add(buttonPanel, BorderLayout.SOUTH);
	buttonPanel.add(btnLogin);
	buttonPanel.add(btnNew);
	buttonPanel.add(btnCancel);

	pack();
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void addListener(ActionListener listenForButton) {

	btnLogin.addActionListener(listenForButton);
	btnNew.addActionListener(listenForButton);
	btnCancel.addActionListener(listenForButton);
	txtPassword.addActionListener(listenForButton);
    }

    public void clearFields() {
	txtUserName.setText("");
	txtPassword.setText("");
    }

    public void showAccountCreationSuccessfulMessage() {
	JOptionPane.showMessageDialog(this, "Account creation successful.",
		"Login Notice", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showUserAlreadyExistsMessage() {
	JOptionPane.showMessageDialog(this,
		"This user name already exists.\nPlease try again.",
		"Login Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showEmptyPasswordMessage() {
	JOptionPane.showMessageDialog(this, "Password cannot be empty.",
		"Login Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showEmptyUserNameMessage() {
	JOptionPane.showMessageDialog(this, "User name cannot be empty.",
		"Login Error", JOptionPane.ERROR_MESSAGE);
    }

    public void showInvalidPasswordMessage() {
	JOptionPane.showMessageDialog(this,
		"Passwords cannot contain the following characters:\n"
			+ Password.invalidCharactersVisible, "Login Error",
		JOptionPane.ERROR_MESSAGE);
    }

    public void showLoginSuccessfulMessage() {
	JOptionPane.showMessageDialog(this, "Login Successful!",
		"Login Notice", JOptionPane.INFORMATION_MESSAGE);
    }

    public void showLoginFailedMessage() {
	JOptionPane.showMessageDialog(this,
		"The user name and/or password is incorrect.\nAccess denied.",
		"Login Error", JOptionPane.ERROR_MESSAGE);
    }

    public String getUserName() {
	return txtUserName.getText();
    }

    public char[] getPassword() {
	return txtPassword.getPassword();
    }

    public JTextField getTxtUserName() {
	return txtUserName;
    }

    public JPasswordField getTxtPassword() {
	return txtPassword;
    }

    public JButton getBtnLogin() {
	return btnLogin;
    }

    public JButton getBtnNew() {
	return btnNew;
    }

    public JButton getBtnCancel() {
	return btnCancel;
    }
}
