package lab12;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controller {
    private View view = new View();
    private ContactService cs = new ContactService();
    
    public Controller(){
	this.view.setVisible(true);
	this.view.addListener(new Listener());
    }

    private class Listener implements ActionListener {

	public void actionPerformed(ActionEvent e) {

	    if (e.getSource() == view.getBtnFirst()) {
		btnFirstPressed();
	    } else if (e.getSource() == view.getBtnPrevious()) {
		btnPreviousPressed();
	    } else if (e.getSource() == view.getBtnNext()) {
		btnNextPressed();
	    } else if (e.getSource() == view.getBtnLast()) {
		btnLastPressed();
	    } else if (e.getSource() == view.getBtnSave()) {
		btnSavePressed();
	    } else if (e.getSource() == view.getBtnAdd()) {
		btnAddPressed();
	    } else if (e.getSource() == view.getBtnDelete()) {
		btnDeletePressed();
	    } else if (e.getSource() == view.getBtnFind()) {
		btnFindPressed();
	    }else if (e.getSource() == view.getTxtFName()) {
		txtFNameChanged();
	    }
	}

    }

    private void btnFirstPressed() {


    }

    public void txtFNameChanged() {

		JOptionPane.showMessageDialog(view,
		"The user name and/or password is incorrect.\nAccess denied.",
		"Login Error", JOptionPane.ERROR_MESSAGE);
    }

    public void btnFindPressed() {
	// TODO Auto-generated method stub

    }

    public void btnDeletePressed() {
	// TODO Auto-generated method stub

    }

    public void btnAddPressed() {
	// TODO Auto-generated method stub

    }

    public void btnSavePressed() {
	// TODO Auto-generated method stub

    }

    public void btnLastPressed() {
	// TODO Auto-generated method stub

    }

    public void btnNextPressed() {
	// TODO Auto-generated method stub

    }

    public void btnPreviousPressed() {
	// TODO Auto-generated method stub

    }
}
