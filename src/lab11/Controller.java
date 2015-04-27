package lab11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Controller implements ActionListener {

    TextFileService service;

    private JTextField txtUserName;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnNew;
    private JButton btnCancel;

    public Controller(HashMap<String, Object> componentBundle) {

	updateComponentBundle(componentBundle);

	try {
	    service = new TextFileService();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

	service.populateAccountsFromFile();
    }

    public void updateComponentBundle(HashMap<String, Object> componentBundle) {
	this.txtUserName = (JTextField) componentBundle.get("txtUserName");
	this.txtPassword = (JPasswordField) componentBundle.get("txtPassword");
	this.btnLogin = (JButton) componentBundle.get("btnLogin");
	this.btnNew = (JButton) componentBundle.get("btnNew");
	this.btnCancel = (JButton) componentBundle.get("btnCancel");
    }

    public void actionPerformed(ActionEvent ae) {

	Object src = ae.getSource();
	if (src == btnLogin) {
	    JOptionPane.showMessageDialog(btnLogin, "LOGIN SUCCESSFUL\n" + ae.getActionCommand(),
		    "Login Message", JOptionPane.INFORMATION_MESSAGE);
	} else if (src == btnCancel) {
	    JOptionPane.showMessageDialog(btnLogin, "LOGIN CANCELLED\n" + ae.getActionCommand(),
		    "Login Message", JOptionPane.INFORMATION_MESSAGE);
	}else if (src == btnNew) {
	    JOptionPane.showMessageDialog(btnLogin, "LOGIN NEW\n" + ae.getActionCommand(),
		    "Login Message", JOptionPane.INFORMATION_MESSAGE);
	}
    }

    public void setTxtUserName(JTextField txtUserName) {
	this.txtUserName = txtUserName;
    }

    public void setTxtPassword(JPasswordField txtPassword) {
	this.txtPassword = txtPassword;
    }

    public void setBtnLogin(JButton btnLogin) {
	this.btnLogin = btnLogin;
    }

    public void setBtnNew(JButton btnNew) {
	this.btnNew = btnNew;
    }

    public void setBtnCancel(JButton btnCancel) {
	this.btnCancel = btnCancel;
    }
}
