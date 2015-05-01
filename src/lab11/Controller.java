package lab11;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Controller {

    TextFileService service = new TextFileService();
    LoginWindow view = new LoginWindow();

    public Controller() {
	this.view.setVisible(true);
	this.view.addListener(new Listener());
    }

    private class Listener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == view.getBtnLogin()
		    || e.getSource() == view.getTxtPassword()) {
		btnLoginPressed();
	    } else if (e.getSource() == view.getBtnNew()) {
		btnNewPressed();
	    } else if (e.getSource() == view.getBtnCancel()) {
		btnCancelPressed();
	    }
	}
    }

    public void btnCancelPressed() {
	view.clearFields();
	view.getTxtUserName().requestFocusInWindow();
    }

    public void btnLoginPressed() {
	Account account = makeNewAccount();

	if (service.isCorrect(account)) {
	    view.showLoginSuccessfulMessage();
	} else {
	    try {
		throw new UnsuccessfulLoginException();
	    } catch (UnsuccessfulLoginException e) {
		view.getTxtUserName().requestFocusInWindow();
		view.getTxtUserName().selectAll();
		view.showLoginFailedMessage();
	    }
	}
    }

    public void btnNewPressed() {
	Account account = makeNewAccount();

	try {
	    if (service.isExistingAccount(account.getUsername())) {
		throw new ExistingAccountException();
	    }
	} catch (ExistingAccountException e1) {
	    view.getTxtUserName().setText("");
	    view.getTxtUserName().requestFocusInWindow();
	    view.showUserAlreadyExistsMessage();
	    return;
	}

	try {
	    if (view.getTxtUserName().getText().isEmpty()) {
		throw new EmptyException();
	    }
	} catch (EmptyException e) {
	    view.getTxtUserName().requestFocusInWindow();
	    view.showEmptyUserNameMessage();
	    return;
	}

	try {
	    if (view.getTxtPassword().getPassword().length == 0) {
		throw new EmptyException();
	    }
	} catch (EmptyException e) {
	    view.getTxtPassword().requestFocusInWindow();
	    view.showEmptyPasswordMessage();
	    return;
	}

	try {
	    for (int i = 0; i < view.getTxtPassword().getPassword().length; i++) {
		if (Pattern
			.matches("[" + Password.invalidCharacters + "]",
				Character.toString((view.getTxtPassword()
					.getPassword()[i])))) {
		    throw new InvalidPasswordException();
		}
	    }

	} catch (InvalidPasswordException e) {
	    view.getTxtPassword().setText("");
	    view.getTxtPassword().requestFocusInWindow();
	    view.showInvalidPasswordMessage();
	    return;
	}

	// write account to file
	service.write(account);
	view.showAccountCreationSuccessfulMessage();

	// reset form
	view.getTxtUserName().requestFocusInWindow();
    }

    public Account makeNewAccount() {
	String userName = view.getTxtUserName().getText();
	String password = String.copyValueOf(view.getTxtPassword()
		.getPassword());
	return new Account(userName, password);
    }
}