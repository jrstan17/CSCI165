package lab11;

@SuppressWarnings("serial")
public class EmptyException extends Exception {
    private Account account;

    public EmptyException(Account account) {
	super("EmptyException");
	this.setAccount(account);
    }

    public EmptyException() {
	super("EmptyException");
    }

    public EmptyException(String message) {
	super(message);
    }

    public Account getaccount() {
	return new Account(account);
    }

    public void setAccount(Account account) {
	this.account = account;
    }
}
