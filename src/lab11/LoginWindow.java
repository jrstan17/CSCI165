package lab11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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

    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JPanel userNamePanel;
    private JPanel passwordPanel;

    private JLabel lblUserName = new JLabel("User Name: ");
    private JTextField txtUserName = new JTextField();

    private JLabel lblPassword = new JLabel("Password: ");
    private JPasswordField txtPassword = new JPasswordField();

    private JButton btnLogin = new JButton("Login");
    private JButton btnNew = new JButton("New Account");
    private JButton btnCancel = new JButton("Cancel");

    public LoginWindow() {

	// add GUI objects to the Frame
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	setBounds(100, 100, 668, 509);

	// set main panel
	mainPanel = new JPanel();
	mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(mainPanel);
	mainPanel.setLayout(new BorderLayout(0, 0));

	// set button panel
	buttonPanel = new JPanel();
	buttonPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	mainPanel.add(buttonPanel, BorderLayout.SOUTH);
	buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	// set user name panel
	userNamePanel = new JPanel();
	userNamePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	mainPanel.add(userNamePanel, BorderLayout.NORTH);
	userNamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	// set password panel
	passwordPanel = new JPanel();
	passwordPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	mainPanel.add(passwordPanel, BorderLayout.CENTER);
	passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

	// populate window with controls
	userNamePanel.add(lblUserName);
	userNamePanel.add(txtUserName);
	txtUserName.setColumns(15);

	passwordPanel.add(lblPassword);
	passwordPanel.add(txtPassword);
	txtPassword.setColumns(15);

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
