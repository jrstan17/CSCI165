//@startuml
//class Driver {
//	+{static}void main(String[] args)
//}
//
//class LoginWindow {
//	-JPanel buttonPanel
//	-JPanel textPanel
//	-JTextField txtUserName
//	-JPasswordField txtPassword
//	-JButton btnLogin
//	-JButton btnNew
//	-JButton btnCancel
//	+void addListener(ActionListener listenForButton)
//	+void clearFields()
//	+void showAccountCreationSuccessfulMessage()
//	+void showUserAlreadyExistsMessage()
//	+void showEmptyPasswordMessage()
//	+void showEmptyUserNameMessage()
//	+void showInvalidPasswordMessage()
//	+void showLoginSuccessfulMessage()
//	+void showLoginFailedMessage()
//	+String getUserName()
//	+char[] getPassword()
//	+JTextField getTxtUserName()
//	+JPasswordField getTxtPassword()
//	+JButton getBtnLogin()
//	+JButton getBtnNew()
//	+JButton getBtnCancel()
//}
//class JFrame {
//}
//
//class Controller {
//	~TextFileService service
//	~LoginWindow view
//	+Controller(TextFileService service, LoginWindow view)
//	+void btnCancelPressed()
//	+void btnLoginPressed()
//	+void btnNewPressed()
//	+Account makeNewAccount()
//}
//
//
//class TextFileService {
//	-{static}String FILE_PATH
//	-FileInputStream fis
//	-Scanner scr
//	+boolean isExistingAccount(Username username)
//	+boolean isCorrect(Account account)
//	+void write(Account toAdd)
//}
//
//
//
//
//
//LoginWindow --* Driver
//JFrame <|-- LoginWindow
//Driver *-- Controller
//Controller *-- LoginWindow
//Controller *-- TextFileService
//@enduml




package lab11;

import javax.swing.SwingUtilities;

public class Driver {

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		LoginWindow lw = new LoginWindow();
		TextFileService tfs = new TextFileService();
		
		@SuppressWarnings("unused")
		Controller c = new Controller(tfs, lw);
	    }
	});
    }
}