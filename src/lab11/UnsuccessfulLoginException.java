package lab11;

@SuppressWarnings("serial")
public class UnsuccessfulLoginException extends Exception {
    private Account account;

    public UnsuccessfulLoginException(Account account) {
	super("UnsuccessfulLoginException");
	this.setAccount(account);
    }

    public UnsuccessfulLoginException() {
	super("UnsuccessfulLoginException");
    }

    public UnsuccessfulLoginException(String message) {
	super(message);
    }

    public Account getaccount() {
	return new Account(account);
    }

    public void setAccount(Account account) {
	this.account = account;
    }
}
