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
//}
//class JFrame {
//}
//
//class Controller {
//	~TextFileService service
//	~LoginWindow view
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
//class Account {
//	-Username username
//	-Password password
//}
//
//
//class Username {
//	-String username
//}
//
//
//
//class Password {
//	-String text
//	-String cipheredText
//	-int shift
//	+{static}int SHIFT_MIN
//	+{static}int SHIFT_MAX
//	+{static}int CHAR_LOWER_BOUND
//	+{static}int CHAR_UPPER_BOUND
//	+{static}String invalidCharacters
//	+{static}String invalidCharactersVisible
//	+void encrypt()
//	+void decrypt()
//	-char shiftChar(char c, Crypt crypt)
//	-void setRandomShift()
//}
//
//
//
//LoginWindow --* Driver
//JFrame <|-- LoginWindow
//Driver *-- Controller
//Controller *-- LoginWindow
//Controller *-- TextFileService
//Controller -- Account : makes
//Account *-- Username
//Account *-- Password
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