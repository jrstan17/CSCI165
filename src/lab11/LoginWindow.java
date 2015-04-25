package lab11;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class LoginWindow extends JFrame implements ActionListener {

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
	
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
