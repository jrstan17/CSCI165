package lab11;

@SuppressWarnings("serial")
public class InvalidPasswordException extends Exception {
    private Account account;

    public InvalidPasswordException(Account account) {
	super("InvalidPasswordException");
	this.setAccount(account);
    }

    public InvalidPasswordException() {
	super("InvalidPasswordException");
    }

    public InvalidPasswordException(String message) {
	super(message);
    }

    public Account getAccount() {
	return new Account(account);
    }

    public void setAccount(Account account) {
	this.account = account;
    }
}
