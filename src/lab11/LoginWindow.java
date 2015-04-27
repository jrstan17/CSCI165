package lab11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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

    private Controller controller;

    private HashMap<String, Object> componentBundle = new HashMap<String, Object>();

    public LoginWindow() {

	// add GUI objects to the Frame
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	// setup controller class
	setComponentBundle();
	controller = new Controller(componentBundle);

	// add action listeners
	btnLogin.addActionListener(controller);
	btnNew.addActionListener(controller);
	btnCancel.addActionListener(controller);
	txtUserName.addActionListener(controller);
	
	pack();
	setLocationRelativeTo(null);
	setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void setComponentBundle() {
	componentBundle.put("txtUserName", txtUserName);
	componentBundle.put("txtPassword", txtPassword);
	componentBundle.put("btnLogin", btnLogin);
	componentBundle.put("btnNew", btnNew);
	componentBundle.put("btnCancel", btnCancel);
    }

    public HashMap<String, Object> getComponentBundle() {
	return componentBundle;
    }

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		new LoginWindow();
	    }
	});
    }

    public void addButtonActionListener(ActionListener actionListener) {
	btnLogin.addActionListener(actionListener);
    }

    public String getUserName() {
	return txtUserName.getText();
    }

    public String getPassword() {
	return String.valueOf(txtPassword.getPassword());
    }

}
